package com.example.volleyapi;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Requestqueue  initialized
        RequestQueue mRequestqueue;
        mRequestqueue = Volley.newRequestQueue(this);

        // String Request initialized
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos/1", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                   // Log.d("myapp", "the response is" + response.getString("title"));
                    Toast.makeText(getApplicationContext(), "Response :" + response.getString("title"), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "something went wrong" );
            }
        });


       /* JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,"https://jsonplaceholder.typicode.com/todos/1", null, response -> {
            try {
                Log.d(TAG , "the response is" + response.getString("title"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }, error -> Log.i(TAG, "Something went wrong"));

        mRequestqueue.add(jsonObjectRequest);*/
        mRequestqueue.add(jsonObjectRequest);

    }


}
