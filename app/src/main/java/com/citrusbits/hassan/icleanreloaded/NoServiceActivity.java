package com.citrusbits.hassan.icleanreloaded;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class NoServiceActivity extends AppCompatActivity {


    ImageButton noservice_okay_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_service);

        noservice_okay_btn = (ImageButton) findViewById(R.id.noservice_okay_btn);

        noservice_okay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.noservice_okay_btn) {
                    Intent loggedIn = new Intent(NoServiceActivity.this, LoginRegisterActivity.class);
                    startActivity(loggedIn);
                }
            }
        });
    }
}