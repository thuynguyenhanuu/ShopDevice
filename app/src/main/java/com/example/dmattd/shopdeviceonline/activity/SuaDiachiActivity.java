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

public class SuaDiachiActivity extends AppCompatActivity {

    EditText edt;
    Button btnHuy, btnCapnhat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_diachi);

        Anhxa();
        CapnhatDiachimoi();


    }

    private void CapnhatDiachimoi() {
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String newdiachi = edt.getText().toString();

                if( newdiachi.length() < 16){
                    Toast.makeText(getApplicationContext(), "Thất bại: địa chỉ cần lớn hơn 16 kí tự!", Toast.LENGTH_SHORT).show();

                }else if(newdiachi.length() > 50){
                    Toast.makeText(getApplicationContext(), "Thất bạt: địa chỉ cần nhỏ hơn 50 ký tự!", Toast.LENGTH_SHORT).show();
                }else if(newdiachi.equals(CheckStatusUser.diachi)){
                    Toast.makeText(getApplicationContext(), "Thất bạt: địa chỉ mới không thay đổi!", Toast.LENGTH_SHORT).show();
                }else{
                    CheckStatusUser.diachi = newdiachi;

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdansuadiachi, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            CheckStatusUser.diachi = newdiachi;
                            Toast.makeText(getApplicationContext(), "Đã đổi địa chỉ thành công", Toast.LENGTH_SHORT).show();
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
                            param.put("diachi", CheckStatusUser.diachi);
                            return param;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
                Intent intent = new Intent(SuaDiachiActivity.this, ThongtinKhachhangActivity.class);
                startActivity(intent);

            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuaDiachiActivity.this, ThongtinKhachhangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        edt = findViewById(R.id.edtnoidungdiachi);
        btnHuy = findViewById(R.id.btnhuydiachi);
        btnCapnhat = findViewById(R.id.btncapnhatdiachi);

        edt.setText(CheckStatusUser.diachi);
    }
}
