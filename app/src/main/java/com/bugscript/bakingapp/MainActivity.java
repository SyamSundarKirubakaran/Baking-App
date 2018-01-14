package com.bugscript.bakingapp;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private GridView gridview;
    public static int[] ing_numbers;
    public static int[] step_numbers;
    public static String [] dishNames;
    public static String [][] quantity;
    public static String [][] measure;
    public static String [][] ingredient;
    public static String [][] step_id;
    public static String [][] shortDescription;
    public static String [][] description;
    public static String [][] videoURL;
    public static String [][] thumbnailURL;
    public static String [] servings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
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
            servings=new String[jsonArray.length()];
            ing_numbers=new int[jsonArray.length()];
            step_numbers=new int[jsonArray.length()];
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jo=jsonArray.getJSONObject(i);
                dishNames[i]=jo.getString("name");
                servings[i]=jo.getString("servings");
                JSONArray jsonArray1=jo.getJSONArray("ingredients");
                ing_numbers[i]=jsonArray1.length();
                JSONArray jsonArray2=jo.getJSONArray("steps");
                step_numbers[i]=jsonArray2.length();
            }
            int max=ing_numbers[0];
            for(int i = 0; i < ing_numbers.length; i++)
                if(max < ing_numbers[i])
                    max = ing_numbers[i];
            quantity=new String[jsonArray.length()][max];
            measure=new String[jsonArray.length()][max];
            ingredient=new String[jsonArray.length()][max];
            max=step_numbers[0];
            for(int i = 0; i < step_numbers.length; i++)
                if(max < step_numbers[i])
                    max = step_numbers[i];
            step_id=new String[jsonArray.length()][max];
            shortDescription=new String[jsonArray.length()][max];
            description=new String[jsonArray.length()][max];
            videoURL=new String[jsonArray.length()][max];
            thumbnailURL=new String[jsonArray.length()][max];
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jo=jsonArray.getJSONObject(i);
                JSONArray jsonArray1=jo.getJSONArray("ingredients");
                for(int j=0;j<jsonArray1.length();j++){
                    JSONObject je=jsonArray1.getJSONObject(j);
                    quantity[i][j]=je.getString("quantity");
                    measure[i][j]=je.getString("measure");
                    ingredient[i][j]=je.getString("ingredient");
                }
                JSONArray jsonArray2=jo.getJSONArray("steps");
                for (int j=0;j<jsonArray2.length();j++){
                    JSONObject jw=jsonArray2.getJSONObject(j);
                    step_id[i][j]=jw.getString("id");
                    shortDescription[i][j]=jw.getString("shortDescription");
                    description[i][j]=jw.getString("description");
                    videoURL[i][j]=jw.getString("videoURL");
                    thumbnailURL[i][j]=jw.getString("thumbnailURL");
                }
            }
            Toast.makeText(MainActivity.this,"JSON Parsing successfull..",Toast.LENGTH_LONG).show();
            gridview.setAdapter(new HomeAdapter(MainActivity.this));
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
                }
            });
            progressBar.setVisibility(View.INVISIBLE);
            gridview.setVisibility(View.VISIBLE);
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
