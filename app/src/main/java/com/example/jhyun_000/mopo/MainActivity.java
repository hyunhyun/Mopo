package com.example.jhyun_000.mopo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init(){
        tv = (TextView)findViewById(R.id.tv);
    }

    void jsonParsing(){
        String file = "short.json";
        String result = "";
        try {
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            result = new String(buffer, "utf-8");
            JSONObject json = new JSONObject(result);
            JSONArray jsonArray = json.getJSONArray("DATA");

            for(int i=0; i< jsonArray.length(); i++){

//                JSONObject order = ja.getJSONObject(i);
//                JSONObject order = jsonArray.getJSONObject(i);
//            result += "product: " + order.getString("CODE_DESC") + ", maker: " + order.getString("FAC_ADDR") +
//                    ", price: " + order.getInt("Price") + "\n";
                json = jsonArray.getJSONObject(i);
                String name = json.getString("CODE_DESC");
                String address = json.getString("FAC_ADDR");
//                tv.append(name+"\n");
                tv.setText(name+"\n");
//                tv.append(address+"\n");
            }
        } catch (Exception e) {
            tv.setText(e.getMessage());
        }
    }
}
