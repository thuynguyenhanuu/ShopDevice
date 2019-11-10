package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.model.CheckStatusUser;

public class QuanlyToiActivity extends AppCompatActivity {

    ImageView imgquanlydon, imgdanhgia, imgcaidat;
    TextView txtten;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly_toi);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menugiohang, menu);
        return true;
    }

    //bat su kien menugio hang
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                    Intent intent = new Intent(getApplicationContext(), GiohangActivity.class);
                    startActivity(intent);
                }
        return super.onOptionsItemSelected(item);
    }

    private void Events() {
        imgcaidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanlyToiActivity.this, ThongtinKhachhangActivity.class);
                startActivity(intent);
            }
        });
        imgquanlydon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanlyToiActivity.this, QuanlydonhangActivity.class);
                startActivity(intent);
            }
        });
        imgdanhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanlyToiActivity.this, QuanlyCMTActivity.class);
                startActivity(intent);
            }
        });

    }

    private void Anhxa() {
        toolbar = findViewById(R.id.toolbarquanlytoi);
        imgquanlydon = findViewById(R.id.quanlydon);
        imgdanhgia = findViewById(R.id.quanlydanhgia);
        imgcaidat = findViewById(R.id.caidat);
        txtten = findViewById(R.id.tennguoidungtoi);
        txtten.setText(CheckStatusUser.ten);
    }
}
