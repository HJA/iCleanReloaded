package com.citrusbits.hassan.icleanreloaded;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AddCreditCardActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_credit_card_activity);

        ImageButton back_button = (ImageButton) findViewById(R.id.add_card_back_icon);
        back_button.setOnClickListener(this);
        ImageButton skip_btn = (ImageButton) findViewById(R.id.add_card_skip_icon);
        skip_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.add_card_back_icon) {

            Intent back_btn = new Intent(AddCreditCardActivity.this, AddLocationActivity.class);
            startActivity(back_btn);
        }
        if(v.getId() == R.id.add_card_skip_icon){

            Intent skip_btn = new Intent(AddCreditCardActivity.this, WashSettingsActivity.class);
            startActivity(skip_btn);
        }
    }
}
