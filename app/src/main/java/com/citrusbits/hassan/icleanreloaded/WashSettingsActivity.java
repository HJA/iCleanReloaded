package com.citrusbits.hassan.icleanreloaded;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;

public class WashSettingsActivity extends Activity implements View.OnClickListener {

    ImageButton back_btn;
    ImageButton active_container;
    ImageButton inactive_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_settings);

        back_btn = (ImageButton) findViewById(R.id.wash_settings_back_icon);
        back_btn.setOnClickListener(this);

        active_container = (ImageButton) findViewById(R.id.wash_settings_container_active);
        active_container.setOnClickListener(this);

        inactive_container = (ImageButton) findViewById(R.id.wash_settings_container);
        inactive_container.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.wash_settings_back_icon) {

            Intent back_btn = new Intent(WashSettingsActivity.this, AddCreditCardActivity.class);
            startActivity(back_btn);
        }
        if (v.getId() == R.id.wash_settings_container_active) {
            active_container.setImageResource(R.drawable.wash_settings_container);

        } else{
            active_container.setImageResource(R.drawable.wash_settings_container_active);
        }
    }
}

