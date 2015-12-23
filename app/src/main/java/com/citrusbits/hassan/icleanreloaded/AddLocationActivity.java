package com.citrusbits.hassan.icleanreloaded;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class AddLocationActivity extends Activity implements AdapterView.OnItemClickListener {

    ImageButton add_location_add_btn;
    ImageButton add_location_skip_btn;
    EditText nick_name_ET;
    EditText address1_ET;
    EditText address2_ET;
    EditText city_ET;
    EditText zip_code_ET;

    private static final String LOG_TAG = "ExampleApp";

    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String OUT_JSON = "/json";

    //------------ make your specific key ------------
    private static final String API_KEY = "AIzaSyAU9ShujnIg3IDQxtPr7Q1qOvFVdwNmWc4";
    private GooglePlacesAutocompleteAdapter autoCompleteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_location_activity);

        AutoCompleteTextView address1_ET = (AutoCompleteTextView) findViewById(R.id.address1_ET);
        AutoCompleteTextView address2_ET = (AutoCompleteTextView) findViewById(R.id.address2_ET);

        autoCompleteAdapter = new GooglePlacesAutocompleteAdapter(this,R.layout.list_item);
        address1_ET.setAdapter(autoCompleteAdapter);
        address1_ET.setOnItemClickListener(this);

        add_location_add_btn = (ImageButton) findViewById(R.id.add_location_add_btn);
        add_location_skip_btn = (ImageButton) findViewById(R.id.add_location_skip_btn);

        add_location_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nick_name = nick_name_ET.getText().toString();
                /*String address1 = address1_ET.getText().toString();
                String address2 = address2_ET.getText().toString();*/
                String city = city_ET.getText().toString();
                String zip = zip_code_ET.getText().toString();

                if (v.getId() == R.id.add_location_add_btn) {
                    if (nick_name.isEmpty()) {
                        Toast.makeText(AddLocationActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
                    }else{
                        Intent add_location = new Intent(AddLocationActivity.this, AddCreditCardActivity.class);
                        startActivity(add_location);
                    }
                }
            }


        });
        add_location_skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.add_location_skip_btn) {
                    Intent skip_btn = new Intent(AddLocationActivity.this, AddCreditCardActivity.class);
                    startActivity(skip_btn);
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String str = (String) parent.getItemAtPosition(position);
		/*Toast.makeText(this, str, Toast.LENGTH_SHORT).show();*/
    }

    public  ArrayList<String> autocomplete(String input) {
        ArrayList<String> resultList = null;

        HttpURLConnection conn = null;
        final StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON);
            sb.append("?key=" + API_KEY);
			/*sb.append("&components=country:gr");*/
            sb.append("&input=" + URLEncoder.encode(input, "utf8"));

            URL url = new URL(sb.toString());

            System.out.println("URL: "+url);
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            // Load the results into a StringBuilder
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error processing Places API URL", e);
            return resultList;
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error connecting to Places API", e);
            return resultList;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        try {

            /*// Create a JSON object hierarchy from the results
            AddLocationActivity.this.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    Toast.makeText(AddLocationActivity.this.getApplicationContext(), jsonResults.toString(), Toast.LENGTH_LONG).show();
                }
            });*/

            JSONObject jsonObj = new JSONObject(jsonResults.toString());
            JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

            // Extract the Place descriptions from the results
            resultList = new ArrayList<String>(predsJsonArray.length());
            for (int i = 0; i < predsJsonArray.length(); i++) {
                System.out.println(predsJsonArray.getJSONObject(i).getString("description"));
                System.out.println("============================================================");
                resultList.add(predsJsonArray.getJSONObject(i).getString("description"));
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Cannot process JSON results", e);
        }

        return resultList;
    }

    class GooglePlacesAutocompleteAdapter extends ArrayAdapter<String> implements Filterable {
        private ArrayList<String> resultList;

        public GooglePlacesAutocompleteAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        @Override
        public int getCount() {
            return resultList.size();
        }

        @Override
        public String getItem(int index) {
            return resultList.get(index);
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint != null) {
                        // Retrieve the autocomplete results.
                        resultList = autocomplete(constraint.toString());

                        // Assign the data to the FilterResults
                        filterResults.values = resultList;
                        filterResults.count = resultList.size();
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                    if (results != null && results.count > 0) {
                        notifyDataSetChanged();
                    } else {
                        notifyDataSetInvalidated();
                    }
                }
            };
            return filter;
        }
    }

}