package com.citrusbits.hassan.icleanreloaded;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends Fragment implements View.OnClickListener{

    private static final String LOGIN_URL = "http://54.67.29.66/iosweb/iclean_v1/index.php?methodName=ic_signIn";

    public static final String KEY_EMAIL = "ic_email";
    public static final String KEY_PASSWORD = "ic_password";
    public static final String KEY_TYPE = "ic_type";
    public static final String KEY_TOKEN = "ic_token";

    private EditText editTextEmail;
    private EditText editTextPassword;

    private ImageButton buttonLogin;
    private ImageButton loginFacebook;
    private ImageButton loginTwitter;

    private String type = "ic";
    private String token = "1234";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.login_fragment, container, false);

        editTextEmail = (EditText) rootView.findViewById(R.id.login_email_ET);
        String email = editTextEmail.getText().toString();
        editTextPassword = (EditText) rootView.findViewById(R.id.password_ET);
        String password = editTextPassword.getText().toString();


            buttonLogin = (ImageButton) rootView.findViewById(R.id.login_btn);
            buttonLogin.setOnClickListener(LoginFragment.this);

            loginFacebook = (ImageButton) rootView.findViewById(R.id.facebook);
            loginFacebook.setOnClickListener(LoginFragment.this);

            loginTwitter = (ImageButton) rootView.findViewById(R.id.twitter);
            loginTwitter.setOnClickListener(LoginFragment.this);
        /*}*/
        return rootView;
    }
    private void userLogin(final String email, final String password, final String type, final String token) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("200")) {

                    Intent login = new Intent(getActivity(),OrdersActivity.class);
                    startActivity(login);

                } else {

                    Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                }

            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_EMAIL, email);
                map.put(KEY_PASSWORD, password);
                map.put(KEY_TOKEN,token);
                map.put(KEY_TYPE,type);

                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (v.getId() == R.id.login_btn) {

            if (email.matches("") || password.matches("")) {
            Toast.makeText(getActivity(), "Invalid Input", Toast.LENGTH_SHORT).show();
            }else {
                userLogin(email, password, type, token);
            }
        }
    }
}
