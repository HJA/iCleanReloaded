package com.citrusbits.hassan.icleanreloaded;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.citrusbits.hassan.icleanreloaded.fragments.RegisterFragment;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoggedInActivity extends Activity implements View.OnClickListener {

    TextView textView;
    ImageButton next_btn;
    private TwitterLoginButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        next_btn = (ImageButton) findViewById(R.id.logged_in_next_btn);
        next_btn.setOnClickListener(LoggedInActivity.this);

        textView =(TextView) findViewById(R.id.logged_in_feedback);
        Intent intent = getIntent();
        textView.setText("You are logged in with\n " + intent.getStringExtra(RegisterFragment.KEY_SOCIAL));
    }
    @Override
    public void onClick(View v) {

        if(v.getId()== R.id.logged_in_next_btn){

            Intent next = new Intent(LoggedInActivity.this, ServiceCheckActivity.class);
            startActivity(next);

        }
    }
}

