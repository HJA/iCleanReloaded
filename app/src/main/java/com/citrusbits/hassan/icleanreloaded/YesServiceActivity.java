package com.citrusbits.hassan.icleanreloaded;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class YesServiceActivity extends AppCompatActivity {

    ImageButton yesservice_okay_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yes_service_activity);

        yesservice_okay_btn = (ImageButton) findViewById(R.id.yesservice_okay_btn);

        yesservice_okay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.yesservice_okay_btn) {
                    Intent loggedIn = new Intent(YesServiceActivity.this, AddLocationActivity.class);
                    startActivity(loggedIn);
                }
            }
        });
    }
}
