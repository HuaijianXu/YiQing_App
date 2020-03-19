package com.example.testnet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    private List<Info> list ;
    private YqAdapter mAdapter;
    Info yq=new Info();
    int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Intent m =getIntent();
        String result=m.getStringExtra("data");
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        String[] province=new String[1000];
        String[] date=new String[1000];
        String[] now=new String[1000];
        String[] cured=new String[1000];
        String[] dead=new String[1000];
        String[] today=new String[1000];
        try {
            JSONArray json = new JSONArray(result);
            for (int i = 0;i<json.length();i++){
                JSONObject jb=json.getJSONObject(i);
                date[i]=jb.getString("date");
                province[i]=jb.getString("province");
                now[i]=jb.getString("confirmed_num");
                cured[i]=jb.getString("cured_num");
                dead[i]=jb.getString("dead_num");
                today[i]=jb.getString("newconfirmed_num");
                n=i+1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <n; i++)
        {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("province",province[i]);
            map.put("date",date[i]);
            map.put("now",now[i]);
            map.put("cured",cured[i]);
            map.put("dead",dead[i]);
            map.put("today",today[i]);
            listitem.add(map);
        }
//        for (int i=0;i<n;i++){
//            System.out.println(province[i]);
//        }
        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.list_item
                , new String[]{"province","date","now","cured","dead","today"}
                ,new int[]{R.id.tv_province,R.id.tv_date,R.id.tv_confirmed,R.id.tv_cured,R.id.tv_dead,R.id.tv_new});
        ListView listView =(ListView) findViewById(R.id.lv_main);
        listView.setAdapter(adapter);
        System.out.println("/*/*/*/*");
    }
}

