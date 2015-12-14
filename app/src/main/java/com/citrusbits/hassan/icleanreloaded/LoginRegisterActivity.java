package com.citrusbits.hassan.icleanreloaded;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LoginRegisterActivity extends Activity implements View.OnClickListener {

    //UI variables
    ImageButton loginTab;
    ImageButton registerTab;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginTab = (ImageButton) findViewById(R.id.loginTab);
        registerTab = (ImageButton) findViewById(R.id.registerTab);

        loginTab.setOnClickListener(this);
        registerTab.setOnClickListener(this);

        fragment = new LoginFragment();

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
        }

    }

    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked
        switch (v.getId()) {

            case R.id.loginTab:
                loginTab.setBackgroundResource(R.drawable.login_active_tab);
                registerTab.setBackgroundResource(R.drawable.register_inactive_tab);

                fragment = new LoginFragment();

                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
                }
                break;

            case R.id.registerTab:
                registerTab.setBackgroundResource(R.drawable.register_active_tab);
                loginTab.setBackgroundResource(R.drawable.login_inactive_tab);

                fragment = new RegisterFragment();

                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
                }

                break;

        }
    }
}
