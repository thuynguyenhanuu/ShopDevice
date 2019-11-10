package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.adapter.DonhangchoxulyAdapter;
import com.example.dmattd.shopdeviceonline.model.CheckStatusUser;
import com.example.dmattd.shopdeviceonline.model.Choxacnhan;
import com.example.dmattd.shopdeviceonline.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListDonhoanthanhActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Choxacnhan> arraydonhangchoxuly;
    DonhangchoxulyAdapter donhangchoxulyAdapter;
    Toolbar toolbar;

    int iddon = 0;
    String time = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlydonchoxuly);

        AnhXa();
        Getdulieu();
        ActionToolbar();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        AnhXa();
        Getdulieu();
        ActionToolbar();
    }

    // set toolbar de back lai man hinh truoc do
    private void ActionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Getdulieu() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.DuongdangetIDdonhoanthanh, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response != null) {
                    Log.wtf("KK", "don cho xac nhan: " +response);
                    int iddon =0;
                    String trangthai="";
                    String time;
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i<jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            iddon = jsonObject.getInt("id_don");
                            trangthai= jsonObject.getString("trangthai");
                            time= jsonObject.getString("updated_at");

                            arraydonhangchoxuly.add(new Choxacnhan(iddon, trangthai, time));

                            donhangchoxulyAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        Log.wtf("KK", "error: " +e);
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("idkh", String.valueOf(CheckStatusUser.idNgdung));
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), ChitietdonhoanthanhActivity.class);
                intent.putExtra("id_don",arraydonhangchoxuly.get(i).getIddonhang());
                Log.wtf("KK", "id don put"+arraydonhangchoxuly.get(i).getIddonhang());
                startActivity(intent);
            }
        });

    }

    private void AnhXa() {
        listView = findViewById(R.id.listviewdonhangcho);
        toolbar = findViewById(R.id.toolbarquanlydoncho);
        toolbar.setTitle("Danh sách đơn hoàn thành");
        arraydonhangchoxuly = new ArrayList<>();
        donhangchoxulyAdapter = new DonhangchoxulyAdapter(getApplicationContext(), arraydonhangchoxuly);
        listView.setAdapter(donhangchoxulyAdapter);

    }
}

