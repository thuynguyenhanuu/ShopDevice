package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.model.CheckStatusUser;

public class DiachiThanhtoanActivity extends AppCompatActivity {
    TextView txtdiachi, txtsdt, txtten;
    EditText edt;
    ImageButton btnsave, btnedit;
    String diachimoi;
    Button btndatmua;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diachi_thanhtoan);
        diachimoi = CheckStatusUser.diachi;
        Anhxa();
        EventButton();
        ActionToolBar();
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void EventButton() {
        txtdiachi.setVisibility(View.VISIBLE);
        txtten.setVisibility(View.VISIBLE);
        txtsdt.setVisibility(View.VISIBLE);
        btndatmua.setVisibility(View.VISIBLE);

        btnedit.setVisibility(View.VISIBLE);
        edt.setVisibility(View.INVISIBLE);
        btnsave.setVisibility(View.INVISIBLE);

        CheckStatusUser.diachigiaohang = CheckStatusUser.diachi;
        txtdiachi.setText(CheckStatusUser.diachi);
        edt.setText(CheckStatusUser.diachi);
        txtten.setText(CheckStatusUser.ten);
        txtsdt.setText(CheckStatusUser.sdt);


        Log.d("DCGH", "" + CheckStatusUser.diachi);


        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtdiachi.setVisibility(View.INVISIBLE);
                btnedit.setVisibility(View.INVISIBLE);
                edt.setVisibility(View.VISIBLE);
                btnsave.setVisibility(View.VISIBLE);
                edt.setText(diachimoi);

                Log.d("MOI", "1 " + diachimoi);


            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MOI", "2 " + diachimoi);
                diachimoi = edt.getText().toString();
                txtdiachi.setText(diachimoi);
                edt.setText(diachimoi);
                txtdiachi.setVisibility(View.VISIBLE);
                btnedit.setVisibility(View.VISIBLE);
                edt.setVisibility(View.INVISIBLE);
                btnsave.setVisibility(View.INVISIBLE);
                CheckStatusUser.diachigiaohang = diachimoi;

            }
        });

        Log.d("DCGH", "" + CheckStatusUser.diachigiaohang);


        btndatmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HinhthucThanhtoanActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        txtdiachi = findViewById(R.id.txtdiachi);
        edt = findViewById(R.id.edtdiachi);
        btnedit = findViewById(R.id.imageedit);
        btnsave = findViewById(R.id.imagesave);
        txtsdt = findViewById(R.id.txtsdtgh);
        txtten = findViewById(R.id.txtTengh);
        btndatmua = findViewById(R.id.buttondiachi);
        toolbar = findViewById(R.id.toolbardiachinhanhang);
    }
}
