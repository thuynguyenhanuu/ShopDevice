package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.example.dmattd.shopdeviceonline.model.CheckStatusUser;
import com.example.dmattd.shopdeviceonline.util.Server;

import java.util.HashMap;
import java.util.Map;

public class SuaMatKhauActivity extends AppCompatActivity {
    EditText edt, edt2;
    Button btnHuy, btnCapnhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_mat_khau);
        
        Anhxa();
        Capnhatmatkhaumoi();
    }

    private void Capnhatmatkhaumoi() {
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String newMatkhau = edt.getText().toString();
                String nhaplaimk = edt2.getText().toString();

                if( newMatkhau.length() <8){
                    Toast.makeText(getApplicationContext(), "Thất bại: mật khẩu cần lớn hơn 8 kí tự!", Toast.LENGTH_SHORT).show();

                }else if(newMatkhau.length() > 16){
                    Toast.makeText(getApplicationContext(), "Thất bạt: mật khẩu cần nhỏ hơn 16 ký tự!", Toast.LENGTH_SHORT).show();
                }else if(newMatkhau.equals(CheckStatusUser.matkhau)){
                    Toast.makeText(getApplicationContext(), "Thất bạt: mật khẩu mới không thay đổi!", Toast.LENGTH_SHORT).show();
                }else if(!newMatkhau.equals(nhaplaimk)){
                    Toast.makeText(getApplicationContext(), "Thất bạt: mật khẩu không trùng khớp!", Toast.LENGTH_SHORT).show();
                }else{
                    CheckStatusUser.matkhau = newMatkhau;

                    final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdansuamatkhau, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            CheckStatusUser.matkhau = newMatkhau;
                            Toast.makeText(getApplicationContext(), "Đã đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> param = new HashMap<>();
                            param.put("id", String.valueOf(CheckStatusUser.idNgdung));
                            param.put("matkhau", CheckStatusUser.matkhau);
                            return param;
                        }
                    };
                    requestQueue.add(stringRequest);

                }

                Intent intent = new Intent(SuaMatKhauActivity.this, ThongtinKhachhangActivity.class);
                startActivity(intent);
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuaMatKhauActivity.this, ThongtinKhachhangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        edt = findViewById(R.id.edtnoidungmatkhau);
        edt2 = findViewById(R.id.edtnhaplaimk);
        btnHuy = findViewById(R.id.btnhuymatkhau);
        btnCapnhat = findViewById(R.id.btncapnhatmatkhau);


    }
}
