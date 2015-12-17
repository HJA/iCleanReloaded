package com.citrusbits.hassan.icleanreloaded;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ServiceCheckActivity extends Activity implements View.OnClickListener {

    private static final String SERVICE_CHECK_URL ="http://54.67.29.66/iosweb/iclean_v1/index.php?methodName=ic_ServiceCheck";

    public static final String KEY_ZIPCODE = "ic_zip";

    EditText zipcode;
    String user_id;
    ImageButton serviceCheckRegisterButton;

    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_check);

        zipcode = (EditText) findViewById(R.id.zipcode_ET);

        serviceCheckRegisterButton = (ImageButton) findViewById(R.id.service_check_register_btn);
        serviceCheckRegisterButton.setOnClickListener(ServiceCheckActivity.this);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(RegisterFragment.KEY_USER_ID)) {
            user_id = String.valueOf(sharedpreferences.getInt(RegisterFragment.KEY_USER_ID, 0));

        }
    }

    private void serviceCheck(final String user_id, final String zipcode){

        RequestQueue requestQueue = Volley.newRequestQueue(ServiceCheckActivity.this);

        Map<String, String> map = new HashMap<String, String>();

        map.put(RegisterFragment.KEY_USER_ID, user_id);
        map.put(KEY_ZIPCODE, zipcode);


        GsonRequest<ServiceCheckResponse> myReq = new GsonRequest<ServiceCheckResponse>(
                Method.POST, SERVICE_CHECK_URL, ServiceCheckResponse.class, map,
                successListener(), errorListener());
        requestQueue.add(myReq);
    }

    private Response.Listener<ServiceCheckResponse> successListener() {
        return new Response.Listener<ServiceCheckResponse>() {

            @Override
            public void onResponse(ServiceCheckResponse response) {

                if (response.getStatus() == 200) {
                    Intent loggedIn = new Intent(ServiceCheckActivity.this, YesServiceActivity.class);
                    startActivity(loggedIn);
                }
                else {
                    Intent loggedIn = new Intent(ServiceCheckActivity.this, NoServiceActivity.class);
                    startActivity(loggedIn);
                }
            }
        };

    }

    private Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ServiceCheckActivity.this, error.toString(),
                        Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    public void onClick(View v) {
        String zip = zipcode.getText().toString().trim();

        if (v.getId() == R.id.service_check_register_btn) {

            if (zip.isEmpty()) {
                Toast.makeText(ServiceCheckActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
            } else {
                serviceCheck(user_id, zip);
            }

        }
    }
}
