 package com.example.handsup;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

 public class MainActivity extends Activity {


     private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState)   {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);
        obtenerDatosVolley();

        Topic[] topics = new Topic[]{new Topic("Movie"), new Topic("Animal"), new Topic("Food"), new Topic("Celebritie"), new Topic("Sport"), new Topic("Technology")};

        GridView gridView = (GridView)findViewById(R.id.gridview);
        TopicAdapter topicsAdapter = new TopicAdapter(this, topics);
        gridView.setAdapter(topicsAdapter);
    }

    private void obtenerDatosVolley() {

        String url = "http://www.mocky.io/v2/5d4633d2320000b704ae8bef/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray mJsonArray = response.getJSONArray("categories");
                    for(int i=0; i<mJsonArray.length();i++){
                        JSONObject mJsonObject = mJsonArray.getJSONObject(i);
                        String name = mJsonObject.getString("name");
                        String[] palabra = (String[]) mJsonObject.get("palabra");



                        Toast.makeText(MainActivity.this, "Nombre:"+name, Toast.LENGTH_SHORT).show();


                    }



                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }

        });

        queue.add(request);
    }


}
