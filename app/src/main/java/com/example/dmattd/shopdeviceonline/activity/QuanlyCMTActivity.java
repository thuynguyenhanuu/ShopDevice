package com.example.dmattd.shopdeviceonline.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.adapter.QuanlyCMTAdapter;
import com.example.dmattd.shopdeviceonline.model.CheckStatusUser;
import com.example.dmattd.shopdeviceonline.model.Choxacnhan;
import com.example.dmattd.shopdeviceonline.model.Quanlynhanxet;
import com.example.dmattd.shopdeviceonline.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuanlyCMTActivity extends AppCompatActivity {
    ListView listView;
    QuanlyCMTAdapter quanlyCMTAdapter;
    ArrayList<Quanlynhanxet> arraynhanxet;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly_cmt);
        Anhxa();
        Events();
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

    private void Events() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdangetquanlynhanxet, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response != null) {
                    Log.wtf("KK", "don cho xac nhan: " +response);
                    String noidungnx ="";
                    String tensp = "";
                    String hinhanhsp = "";
                    String timenx ="";
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i<jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            tensp = jsonObject.getString("tensp");
                            hinhanhsp = jsonObject.getString("hinhanhsp");
                            noidungnx = jsonObject.getString("noidung");
                            timenx= jsonObject.getString("time");


                            arraynhanxet.add(new Quanlynhanxet(noidungnx,hinhanhsp,tensp,timenx));
                            quanlyCMTAdapter.notifyDataSetChanged();
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
                hashMap.put("idnguoidung", String.valueOf(CheckStatusUser.idNgdung));
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);

    }


    private void Anhxa() {
        toolbar = findViewById(R.id.toolbarquanlycmt);
        listView = findViewById(R.id.listviewquanlycmt);
        arraynhanxet = new ArrayList<>();
        quanlyCMTAdapter = new QuanlyCMTAdapter(getApplicationContext(), arraynhanxet);
        listView.setAdapter(quanlyCMTAdapter);

    }
}
