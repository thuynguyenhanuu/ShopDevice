package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.model.CheckStatusUser;

public class XacnhanmatkhauActivity extends AppCompatActivity {
    EditText edt;
    Button btntieptuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xacnhanmatkhau);
        Anhxa();
        Xacnhanmatkhau();
    }

    private void Xacnhanmatkhau() {
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kiemtramk = edt.getText().toString();
                Toast.makeText(getApplicationContext(), "Mật khẩuc"+kiemtramk, Toast.LENGTH_SHORT).show();
                Log.wtf("Mk", ".."+CheckStatusUser.matkhau +"..."+kiemtramk);

                if(kiemtramk.equals(CheckStatusUser.matkhau)){
                    Intent intent = new Intent(XacnhanmatkhauActivity.this, SuaMatKhauActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Anhxa() {
        edt = findViewById(R.id.edtnoidungmatkhauxacnhan);
        btntieptuc = findViewById(R.id.btnteptucdoimk);
        //edt.setText(CheckStatusUser.matkhau);
    }
}
