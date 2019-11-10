package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.adapter.ChoxacnhanAdapter;
import com.example.dmattd.shopdeviceonline.model.CheckStatusUser;
import com.example.dmattd.shopdeviceonline.model.Choxacnhan;
import com.example.dmattd.shopdeviceonline.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChitietdonhoanthanhActivity extends AppCompatActivity {

        ListView listViewsanphammua;
        Button btnhuydon;
        ChoxacnhanAdapter choxacnhanAdapter;
        ArrayList<Choxacnhan> mangspcho;


        TextView ten1, sdt1, diachi1, hinhthucgiaohang1, hinhthucthanhtoan1, tongtien1;
        Toolbar toolbarchoxacnhan;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chitietchoxacnhan);
//        setContentView(R.layout.ac);

            Anhxa();
            GetIDdonhang();
            Getdulieusanphammua();
            Events();
            ActionToolbar();
        }

    // set toolbar de back lai man hinh truoc do
    private void ActionToolbar() {
        setSupportActionBar(toolbarchoxacnhan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarchoxacnhan.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetIDdonhang() {
        Intent intent = getIntent();
        int iddon = intent.getIntExtra("id_don", -1);
        Log.wtf("KK", "id don get: " +iddon);
        CheckStatusUser.idDonhangchoxuly = iddon;


    }

    private void Getdulieusanphammua() {
            final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdangetdonhoanthanh, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if(response != null) {
                        Log.wtf("KK", "don cho xac nhan: " +response);
                        String tensp = "";
                        String hinhanh = "";
                        int gia = 0;
                        int soluong = 0;
                        String tennguoinhan="";
                        String sdt="";

                        String diachi;
                        String hinhthucthanhtoan;
                        String hinhthucvanchuyen;
                        int tongtien;
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                tensp = jsonObject.getString("tensp");
                                hinhanh = jsonObject.getString("hinhanhsp");
                                gia = jsonObject.getInt("giasanpham");
                                soluong = jsonObject.getInt("soluongsanpham");
                                tennguoinhan = jsonObject.getString("ten");
                                ten1.setText(tennguoinhan);
                                sdt = jsonObject.getString("sdt");
                                sdt1.setText(sdt);
                                diachi = jsonObject.getString("diachigiaohang");
                                diachi1.setText(diachi);
                                hinhthucthanhtoan = jsonObject.getString("hinhthucthanhtoan");
                                hinhthucthanhtoan1.setText(hinhthucthanhtoan);
                                hinhthucvanchuyen = jsonObject.getString("hinhthucvanchuyen");
                                hinhthucgiaohang1.setText(hinhthucvanchuyen);
                                tongtien = jsonObject.getInt("tongtien");
                                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                                tongtien1.setText("Giá: " +decimalFormat.format(tongtien) + "Đ");

                                mangspcho.add(new Choxacnhan(tensp, gia, hinhanh,soluong));
//

                                choxacnhanAdapter.notifyDataSetChanged();
                            }
                            Log.wtf("KK", "kkk: " +tensp+" "+ hinhanh+" "+ gia+" "+ soluong);

                        } catch (JSONException e) {
                            Log.wtf("KK", "error: " +e);
                            e.printStackTrace();
                        } catch (Exception e) {
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
                    hashMap.put("id_don", String.valueOf(CheckStatusUser.idDonhangchoxuly));
                    return hashMap;
                }
            };
            requestQueue.add(stringRequest);
        }

        private void Events() {
            btnhuydon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdantradon, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(),"Yêu cầu trả hàng thành công!", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> hashMap = new HashMap<String, String>();
                            hashMap.put("id_don", String.valueOf(CheckStatusUser.idDonhangchoxuly));
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);

                    finish();

                }
            });

        }

        private void Anhxa() {
            toolbarchoxacnhan = findViewById(R.id.toolbarchoxacnhandon);
            toolbarchoxacnhan.setTitle("Chi tiết đơn hoàn thành");
            listViewsanphammua = findViewById(R.id.listviewchoxacnhan);
            ten1 = findViewById(R.id.ten1);
            diachi1 = findViewById(R.id.diachi1);
            sdt1 = findViewById(R.id.sdt1);
            hinhthucgiaohang1 = findViewById(R.id.hinhhuc1);
            hinhthucthanhtoan1 = findViewById(R.id.thanhtoan1);
            tongtien1 = findViewById(R.id.Tongtien1);
            btnhuydon = findViewById(R.id.buttonhuydon);
            btnhuydon.setText("Trả hàng");
            mangspcho = new ArrayList<>();
            choxacnhanAdapter = new ChoxacnhanAdapter(getApplicationContext(), mangspcho);
            listViewsanphammua.setAdapter(choxacnhanAdapter);

        }
    }
