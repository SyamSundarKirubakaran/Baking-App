package com.bugscript.bakingapp;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private GridView gridview;
    public static String [] dishNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview = findViewById(R.id.gridview);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            gridview.setNumColumns(2);
        }
        getContentsFromJson();
    }

    private void getContentsFromJson()  {
        try {
            JSONArray jsonArray = new JSONArray(loadJSONFromAssert());
            dishNames=new String[jsonArray.length()];
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jo=jsonArray.getJSONObject(i);
                dishNames[i]=jo.getString("name");
                Toast.makeText(MainActivity.this,dishNames[i]+"",Toast.LENGTH_SHORT).show();
            }
            gridview.setAdapter(new HomeAdapter(MainActivity.this));
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
                }
            });
        }catch (JSONException e){
            Toast.makeText(MainActivity.this,"JSON parsing Exception",Toast.LENGTH_SHORT).show();
        }
    }

    public String loadJSONFromAssert(){
        String json=null;
        try{
            InputStream inputStream=this.getAssets().open("baking.json");
            int size= inputStream.available();
            byte[] buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json=new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
