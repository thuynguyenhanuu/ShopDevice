package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.example.dmattd.shopdeviceonline.adapter.TraloiNhanxetAdapter;
import com.example.dmattd.shopdeviceonline.model.CheckStatusUser;
import com.example.dmattd.shopdeviceonline.model.Nhanxet;
import com.example.dmattd.shopdeviceonline.model.Traloinhanxet;
import com.example.dmattd.shopdeviceonline.util.CheckConnection;
import com.example.dmattd.shopdeviceonline.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TraloiCommentActivity extends AppCompatActivity {

    TextView txttennguoitl, txtnoidungtl, timetl, traloitl;
    ImageView anhnguoitl;
    EditText edtthemnx;
    Button btnthemnx;
    RecyclerView recyclerView;

    ArrayList<Traloinhanxet> mangTraloinx;
    TraloiNhanxetAdapter traloiNhanxetAdapter;

    String ten, noidung, time;
    int idnhanxet, idnguoidung, idXoa;
    int idrepnhanxet, idxoarep;

    String tentlnx, noidungtlnx, timetlnx;

    String txtnoidungnx = "";
    String timenx = "";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentDateandTime = sdf.format(new Date());

    // check noidung hop le
    boolean hople = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traloinhanxet);

        Anhxa();
        GetNhanxet();
        VietTraloiNhanxet();
        GetTraloiNhanxet();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Anhxa();
        GetNhanxet();
        VietTraloiNhanxet();
        GetTraloiNhanxet();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menugiohang, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if(idnguoidung == CheckStatusUser.idNgdung) {
            getMenuInflater().inflate(R.menu.menu_xoa_sua, menu);
        }else{
            getMenuInflater().inflate(R.menu.menu_traloi_cmt, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.traloicmt:
                break;
            case R.id.xoacmt:
                final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanxoatraloinhanxet, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TEST", "sdtout " + response);
                        CheckConnection.ShowToast_short(getApplicationContext(), "xoa ok");

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("TEST", "sdtout " + error);

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> param = new HashMap<String, String>();
                        param.put("id", String.valueOf(idrepnhanxet));
                        return param;
                    }
                };
                requestQueue.add(stringRequest);
                mangTraloinx.remove(idxoarep);
                traloiNhanxetAdapter.notifyDataSetChanged();
                break;
            case R.id.suacmt:
                Intent intent = new Intent(this, SuaRepCommentActivity.class);
                intent.putExtra("suanhanxet", noidungtlnx);
                intent.putExtra("id", idrepnhanxet);
                Log.d("ND", "" + noidungtlnx + " " + idrepnhanxet);

                startActivity(intent);
                traloiNhanxetAdapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void GetTraloiNhanxet() {
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdangettraloinhanxet, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if(response != null){
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                idrepnhanxet = jsonObject.getInt("id");
                                idnguoidung = jsonObject.getInt("idnguoidung");
                                noidungtlnx = jsonObject.getString("noidung");
                                tentlnx = jsonObject.getString("ten");
                                timetlnx = jsonObject.getString("time");

                                mangTraloinx.add(new Traloinhanxet(idnguoidung, tentlnx, noidungtlnx, timetlnx));
                                traloiNhanxetAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
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
                    hashMap.put("id", String.valueOf(idnhanxet));
                    return hashMap;
                }
            };
            requestQueue.add(stringRequest);

    }

    private void VietTraloiNhanxet() {

        btnthemnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.wtf("REPREP", ":" + idnhanxet);
                txtnoidungnx = edtthemnx.getText().toString();
                timenx = currentDateandTime;

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanthemtraloinhanxet, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("invalidcontent")){
                            hople = false;
                            Toast.makeText(getApplicationContext(), "Nội dung từ 1 đến 500 kí tự ", Toast.LENGTH_SHORT).show();
                        }else{
                            hople = true;
                            if(hople){
                                mangTraloinx.add(new Traloinhanxet(CheckStatusUser.idNgdung, CheckStatusUser.ten, txtnoidungnx, timenx));
                                Log.d("NXX", "teen nguoi viet nx" + CheckStatusUser.ten);
                                edtthemnx.setText("");
                                traloiNhanxetAdapter.notifyDataSetChanged();


                            }
                            Toast.makeText(getApplicationContext(), "Viết comment thành công", Toast.LENGTH_SHORT).show();
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
                        hashMap.put("idnhanxet", String.valueOf(idnhanxet));
                        hashMap.put("idnguoidung", String.valueOf(CheckStatusUser.idNgdung));
                        hashMap.put("noidung", txtnoidungnx);


                        return hashMap;
                    }
                };

                requestQueue.add(stringRequest);
            }
        });
    }

    private void GetNhanxet() {
        Intent intent = getIntent();
        ten = intent.getStringExtra("ten");
        noidung = intent.getStringExtra("noidung");
        time = intent.getStringExtra("time");
        idnhanxet = intent.getIntExtra("idnhanxet", -1);
        txttennguoitl.setText(ten);
        txtnoidungtl.setText(noidung);
        timetl.setText(time);
    }

    private void Anhxa() {
        txttennguoitl = findViewById(R.id.txttenrep);
        txtnoidungtl = findViewById(R.id.txtnoidungrep);
        timetl = findViewById(R.id.txttimerep);
        traloitl = findViewById(R.id.txtTraloirep);
        anhnguoitl = findViewById(R.id.imageViewrep);
        edtthemnx = findViewById(R.id.edtVietNhanxetrep);
        //edtthemnx.setClickable(false);
        btnthemnx = findViewById(R.id.btnVietNhanxetrep);
        recyclerView = findViewById(R.id.recycleviewRep);

        mangTraloinx = new ArrayList<>();
        traloiNhanxetAdapter = new TraloiNhanxetAdapter(getApplicationContext(), mangTraloinx);


        //đăng ký view cho context menu
        registerForContextMenu(recyclerView);
        traloiNhanxetAdapter.setOnItemClickListener(new RecycleviewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                // Toast.makeText(getApplicationContext(), "short", Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onItemLongClick(View view, int i) {
                // Toast.makeText(getApplicationContext(), "long" + mangnhanxet.get(i).getIdnguoinx(), Toast.LENGTH_SHORT ).show();
                idnguoidung = mangTraloinx.get(i).getIdnguoitraloinx();
                noidungtlnx = mangTraloinx.get(i).getNoidungtraloinx();
                timetlnx = mangTraloinx.get(i).getTimetraloinx();
                idxoarep = i;



                Log.d("ID", "id mangnx " );
                //Toast.makeText(getApplicationContext(), "abc"+ idXoa, Toast.LENGTH_SHORT).show();
                view.showContextMenu();

            }
        });


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        recyclerView.setAdapter(traloiNhanxetAdapter);
    }
}
