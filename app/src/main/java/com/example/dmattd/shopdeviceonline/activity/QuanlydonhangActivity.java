package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.dmattd.shopdeviceonline.R;

public class QuanlydonhangActivity extends AppCompatActivity {

    ImageView imgchoxacnhan, imgcholayhang, imgdanggiao, imghoanthanh, imgdahuy, imgtrahang;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dong_quanlydon);

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
        imgchoxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDonchoxulyActivity.class);
                startActivity(intent);
            }
        });
        imgcholayhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDoncholayhangActivity.class);
                startActivity(intent);
            }
        });
        imgdanggiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDondanggiaoActivity.class);
                startActivity(intent);
            }
        });

        imghoanthanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDonhoanthanhActivity.class);
                startActivity(intent);
            }
        });
        imgdahuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDondahuyActivity.class);
                startActivity(intent);
            }
        });
        imgtrahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDontrahangActivity.class);
                startActivity(intent);
            }
        });

    }

    private void Anhxa() {
        toolbar = findViewById(R.id.toolbarquanlydon);
        imgchoxacnhan = findViewById(R.id.choxacnhan);
        imgcholayhang = findViewById(R.id.cholayhang);
        imgdanggiao = findViewById(R.id.danggiao);
        imghoanthanh = findViewById(R.id.hoanthanh);
        imgdahuy = findViewById(R.id.dahuy);
        imgtrahang= findViewById(R.id.trahang);


    }
}
