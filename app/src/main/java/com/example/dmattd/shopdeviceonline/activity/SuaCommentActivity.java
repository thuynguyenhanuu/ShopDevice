package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.util.Server;

import java.util.HashMap;
import java.util.Map;

public class SuaCommentActivity extends AppCompatActivity {
    EditText edtnoidung;
    Button btnhuy, btncapnhat;
    String nd;
    String noidungmoi;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_comment);

        Anhxa();
        Getnoidungnhanxet();
        Suanoidungnhanxet();
    }

    private void Suanoidungnhanxet() {

        btncapnhat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                noidungmoi = edtnoidung.getText().toString();
                Log.wtf("NX", "ndmoi:" + noidungmoi + "id: " + id);
                final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdansuanhanxet, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", "" + error);

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> param = new HashMap<String, String>();
                        param.put("id", String.valueOf(id));
                        param.put("noidung", noidungmoi);
                        return param;
                    }
                };
                requestQueue.add(stringRequest);
                finish();
            }
        });

        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void Getnoidungnhanxet() {
        Intent intent = this.getIntent();
        String noidung = intent.getStringExtra("suanhanxet");
        id = intent.getIntExtra("id", -1);
        edtnoidung.setText(noidung);
    }

    private void Anhxa() {
        edtnoidung = findViewById(R.id.edtnoidung);
        btnhuy = findViewById(R.id.btnhuy);
        btncapnhat = findViewById(R.id.btncapnhat);
    }
}
