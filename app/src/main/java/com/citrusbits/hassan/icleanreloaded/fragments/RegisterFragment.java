package com.citrusbits.hassan.icleanreloaded.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.citrusbits.hassan.icleanreloaded.app.GsonRequest;
import com.citrusbits.hassan.icleanreloaded.LoggedInActivity;
import com.citrusbits.hassan.icleanreloaded.R;
import com.citrusbits.hassan.icleanreloaded.pojo.RegisterResponse;
import com.citrusbits.hassan.icleanreloaded.pojo.RegisterResponseData;
import com.citrusbits.hassan.icleanreloaded.ServiceCheckActivity;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import java.util.HashMap;
import java.util.Map;

public class RegisterFragment extends Fragment implements View.OnClickListener {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "hMHMHKR7XV0WEY3zOcXS0cNy0";
    private static final String TWITTER_SECRET = "DR88sKNSe3jIkDT3ApAl3kJJEBz3g1OGksdatntEY1ED7kQW8M";

    private static final String REGISTER_URL ="http://54.67.29.66/iosweb/iclean_v1/index.php?methodName=ic_adduser";

    public static final String KEY_NAME = "ic_name";
    public static final String KEY_EMAIL = "ic_email";
    public static final String KEY_PASSWORD = "ic_password";
    public static final String KEY_PHONE_NUMBER = "ic_phone";

    public static final String KEY_TYPE = "ic_type";
    public static final String KEY_TOKEN = "ic_token";

    public static final String KEY_SOCIAL = "Social";
    public static final String KEY_USER_ID = "ic_user_id";

    public static final String KEY_PROMO = "ic_promocode";

    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextNumber;

    private ImageButton buttonRegister;
    private ImageButton registerFacebook;
    private ImageButton registerTwitter;
    private TwitterLoginButton loginButton;

    private String type = "ic";
    private String token = "1234";

    private String name;
    private String email;
    private String password;
    private String number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        editTextName =(EditText) view.findViewById(R.id.name_ET);
        editTextEmail =(EditText) view.findViewById(R.id.email_ET);
        editTextPassword =(EditText) view.findViewById(R.id.register_password_ET);
        editTextNumber =(EditText) view.findViewById(R.id.phone_ET);

        buttonRegister = (ImageButton) view.findViewById(R.id.register_register_btn);
        buttonRegister.setOnClickListener(RegisterFragment.this);

        registerFacebook = (ImageButton) view.findViewById(R.id.facebook);
        registerFacebook.setOnClickListener(RegisterFragment.this);

        registerTwitter = (ImageButton) view.findViewById(R.id.twitter_login_button);
        registerTwitter.setOnClickListener(RegisterFragment.this);

        //loginButton = (TwitterLoginButton) view.findViewById(R.id.twitter_login_button);

        return view;
    }
    private void registerUser(final String name, final String email, final String password, final String number, final String token, final String type){

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        Map<String, String> map = new HashMap<String, String>();
        map.put(KEY_NAME, name);
        map.put(KEY_EMAIL, email);
        map.put(KEY_PASSWORD, password);
        map.put(KEY_PHONE_NUMBER, number);
        map.put(KEY_TYPE, type);
        map.put(KEY_TOKEN, token);

        GsonRequest<RegisterResponse> myReq = new GsonRequest<RegisterResponse>(
                Request.Method.POST, REGISTER_URL, RegisterResponse.class, map,
                successListener(), errorListener());
        requestQueue.add(myReq);

    }

    private Response.Listener<RegisterResponse> successListener() {
        return new Response.Listener<RegisterResponse>() {

            @Override
            public void onResponse(RegisterResponse response) {

                if (response.getStatus() == 201) {

                    Save(response.getData());
                    Intent loggedIn = new Intent(getActivity(), ServiceCheckActivity.class);
                    startActivity(loggedIn);

                }
                else {
                    Toast.makeText(getActivity(), response.getMessage(),
                            Toast.LENGTH_LONG).show();

                }
            }
        };

    }

    private Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.toString(),
                        Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    public void onClick (View v){


        if (v.getId() == R.id.register_register_btn) {

            name = editTextName.getText().toString().trim();
            email = editTextEmail.getText().toString().trim();
            password = editTextPassword.getText().toString().trim();
            number = editTextNumber.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()|| password.isEmpty()|| number.isEmpty()) {
                Toast.makeText(getActivity(), "Invalid Input", Toast.LENGTH_SHORT).show();
            }else {
                registerUser(name, email, password, number, token, type);
            }
        }
        if(v.getId() == R.id.facebook) {

            String Social = "Facebook!";

            Intent loggedIn = new Intent(getActivity(), LoggedInActivity.class);
            loggedIn.putExtra(KEY_SOCIAL, Social);
            startActivity(loggedIn);
        }
        if(v.getId() == R.id.twitter_login_button) {

            String Social = "Twitter!";

            /*TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
            Fabric.with(getActivity(), new Twitter(authConfig));

            TwitterAuthClient client = new TwitterAuthClient();
            loginButton.setCallback(new Callback<TwitterSession>() {

                @Override
                public void success(Result<TwitterSession> result) {
                    // The TwitterSession is also available through:
                    // Twitter.getInstance().core.getSessionManager().getActiveSession()
                    TwitterSession session = result.data;
                    // TODO: Remove toast and use the TwitterSession's userID
                    // with your app's user model
                    String msg = "@" + session.getUserName() + " logged in! (#" + session.getUserId() + ")";
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                }

                @Override
                public void failure(TwitterException exception) {
                    Log.d("TwitterKit", "Login with Twitter failure", exception);
                }
            });*/

            Intent loggedIn = new Intent(getActivity(), LoggedInActivity.class);
            loggedIn.putExtra(KEY_SOCIAL, Social);
            startActivity(loggedIn);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    public void Save(RegisterResponseData data) {

        sharedpreferences = getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        Integer user_id = data.getIcUserId();
        String name = data.getIcName();
        String email = data.getIcEmail();
        String phone = data.getIcPhone();
        String type = data.getIcType();
        String promo = data.getIcPromocode();

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putInt(KEY_USER_ID, user_id);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PHONE_NUMBER, phone);
        editor.putString(KEY_TYPE, type);
        editor.putString(KEY_PROMO, promo);

        editor.commit();
    }
}

