package com.citrusbits.hassan.icleanreloaded;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.citrusbits.hassan.icleanreloaded.app.GsonRequest;
import com.citrusbits.hassan.icleanreloaded.fragments.RegisterFragment;
import com.citrusbits.hassan.icleanreloaded.model.AddLocationResponse;

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
import java.util.HashMap;
import java.util.Map;

public class AddLocationActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String ADD_LOCATION_URL = "http://54.67.29.66/iosweb/iclean_v1/index.php?methodName=ic_addlLocation";

    public static final String KEY_USER_ID = "ic_user_id";
    public static final String KEY_LOCATION_NAME = "ic_locationName";
    public static final String KEY_ADDRESS_1 = "ic_address1";
    public static final String KEY_ADDRESS_2 = "ic_address2";
    public static final String KEY_CITY = "ic_city";
    public static final String KEY_ZIP = "ic_zip";
    public static final String KEY_STATE = "ic_state";

    String userId;

    EditText nick_name_ET;
    EditText address1_ET;
    EditText address2_ET;
    EditText city_ET;
    EditText state_ET;
    EditText zip_code_ET;

    ImageButton add_location_add_btn;
    ImageButton add_location_skip_btn;

    private static final String LOG_TAG = "ExampleApp";

    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String OUT_JSON = "/json";

    private static final String API_KEY = "AIzaSyAU9ShujnIg3IDQxtPr7Q1qOvFVdwNmWc4";
    private GooglePlacesAutocompleteAdapter autoCompleteAdapter;

    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        nick_name_ET = (EditText) findViewById(R.id.nick_name_ET);
        address1_ET = (EditText) findViewById(R.id.address1_ET);
        address2_ET = (EditText) findViewById(R.id.address2_ET);
        city_ET = (EditText) findViewById(R.id.city_ET);
        state_ET = (EditText) findViewById(R.id.state_ET);
        zip_code_ET = (EditText) findViewById(R.id.zip_code_ET);

        AutoCompleteTextView address1 = (AutoCompleteTextView) findViewById(R.id.address1_ET);

        autoCompleteAdapter = new GooglePlacesAutocompleteAdapter(this,R.layout.activity_list_item);
        address1.setAdapter(autoCompleteAdapter);
        address1.setOnItemClickListener(this);

        add_location_add_btn = (ImageButton) findViewById(R.id.add_location_add_btn);
        add_location_skip_btn = (ImageButton) findViewById(R.id.add_location_skip_btn);

        add_location_add_btn.setOnClickListener(this);
        add_location_skip_btn.setOnClickListener(this);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(RegisterFragment.KEY_USER_ID)) {
            userId = String.valueOf(sharedpreferences.getInt(RegisterFragment.KEY_USER_ID, 0));

        }
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

    private void addLocation(String userId, String location_name, String address1, String address2, String city, String zip, String state) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        Map<String, String> map = new HashMap<String, String>();
        map.put(KEY_USER_ID, userId);
        map.put(KEY_LOCATION_NAME, location_name);
        map.put(KEY_ADDRESS_1, address1);
        map.put(KEY_ADDRESS_2, address2);
        map.put(KEY_CITY, city);
        map.put(KEY_STATE, state);
        map.put(KEY_ZIP, zip);

        GsonRequest<AddLocationResponse> myReq = new GsonRequest<AddLocationResponse>(
                Request.Method.POST, ADD_LOCATION_URL, AddLocationResponse.class, map,
                successListener(), errorListener());
        requestQueue.add(myReq);
    }

    private Response.Listener<AddLocationResponse> successListener() {
        return new Response.Listener<AddLocationResponse>() {

            @Override
            public void onResponse(AddLocationResponse response) {

                if (response.getStatus() == 201) {

                    Intent loggedIn = new Intent(AddLocationActivity.this, AddCreditCardActivity.class);
                    startActivity(loggedIn);
                }
                else {
                    Toast.makeText(AddLocationActivity.this, response.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    private Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddLocationActivity.this, error.toString(),
                        Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.add_location_add_btn) {

            String location_name = nick_name_ET.getText().toString().trim();
            String address1 = address1_ET.getText().toString().trim();
            String address2 = address2_ET.getText().toString().trim();
            String city = city_ET.getText().toString().trim();
            String state = state_ET.getText().toString().trim();
            String zip = zip_code_ET.getText().toString().trim();

            if (location_name.isEmpty() || address1.isEmpty()|| city.isEmpty()|| zip.isEmpty()) {
                Toast.makeText(AddLocationActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
            }
            else {
                addLocation(userId, location_name, address1, address2, city, zip, state);
            }
        }
        if(v.getId() == R.id.add_location_skip_btn){

            Intent skip_btn = new Intent(AddLocationActivity.this, AddCreditCardActivity.class);
            startActivity(skip_btn);
        }
    }
}