package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class SuaRepCommentActivity extends AppCompatActivity {
    EditText edtnoidung;
    Button btnhuy, btncapnhat;
    String nd;
    String noidungmoi;
    int id;
    // check noidung hop le
    boolean hople = false;

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
                final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdansuatraloinhanxet, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(!response.equals("invalidcontent")){
                            hople = true;
                            Toast.makeText(getApplicationContext(), "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
                        }else {
                            hople = false;
                            Toast.makeText(getApplicationContext(), "Cập nhật thất bại!", Toast.LENGTH_SHORT).show();

                        }

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
                       // if(hople){
                            param.put("id", String.valueOf(id));
                            param.put("noidung", noidungmoi);

                       // }
                        return param;
                    }
                };
                requestQueue.add(stringRequest);

//                Intent intent = new Intent(SuaRepCommentActivity.this, ChitietSanpham.class);
//                startActivity(intent);

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
