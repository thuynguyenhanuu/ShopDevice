package com.example.dmattd.shopdeviceonline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.model.CheckStatusUser;

public class HinhthucThanhtoanActivity extends AppCompatActivity {

    Button btntieptuc;
    RadioGroup radioGiaohang, radioThanhtoan;
    RadioButton radioVCnhanh, radioVcthuong;
    RadioButton radioTienmat, radioAtmqte, radioAtmthuong;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinhthuc_thanhtoan);

        Anhxa();
        EventsABC();
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

    private void EventsABC() {
//        xuLyRadioButton();
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyRadioButton();
                Intent intent = new Intent(getApplicationContext(), XacnhanThanhtoanActivity.class );
                startActivity(intent);
            }
        });
    }

    private void xuLyRadioButton() {

        CheckStatusUser.hinhthucvanchuyen = "";
        CheckStatusUser.hinhthucthanhtoan = "";
        if(radioVCnhanh.isChecked()) {
            Toast.makeText(getApplicationContext(),"vc nhanh", Toast.LENGTH_LONG).show();
            CheckStatusUser.hinhthucvanchuyen = radioVCnhanh.getText().toString();
        }if(radioVcthuong.isChecked()){
            Toast.makeText(getApplicationContext(),"vc thuong", Toast.LENGTH_LONG).show();
            CheckStatusUser.hinhthucvanchuyen = radioVcthuong.getText().toString();
        }if(radioTienmat.isChecked()){
            CheckStatusUser.hinhthucthanhtoan = radioTienmat.getText().toString();
        }if(radioAtmthuong.isChecked()){
            CheckStatusUser.hinhthucthanhtoan = radioAtmthuong.getText().toString();
        }if(radioAtmqte.isChecked()){
            CheckStatusUser.hinhthucthanhtoan = radioAtmqte.getText().toString();
        }
    }

    private void Anhxa() {
        btntieptuc = findViewById(R.id.buttonTieptuc);
        radioGiaohang = findViewById(R.id.radiovanchuyen);
        radioThanhtoan = findViewById(R.id.radiothanhtoan);
        radioVCnhanh = findViewById(R.id.radioVCnhanh);
        radioVcthuong = findViewById(R.id.radioVCthuong);
        radioTienmat = findViewById(R.id.radioTienmat);
        radioAtmqte = findViewById(R.id.radioATMquocte);
        radioAtmthuong = findViewById(R.id.radioATMnoidia);
        toolbar = findViewById(R.id.toolbarhinhthucvc);
    }
}
