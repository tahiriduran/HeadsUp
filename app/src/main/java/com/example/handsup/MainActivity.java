 package com.example.handsup;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

 public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Topic[] topics = new Topic[]{new Topic("Movie"), new Topic("Animal"), new Topic("Food"), new Topic("Celebritie"), new Topic("Sport"), new Topic("Technology")};

        GridView gridView = (GridView)findViewById(R.id.gridview);
        TopicAdapter topicsAdapter = new TopicAdapter(this, topics);
        gridView.setAdapter(topicsAdapter);
    }
}
