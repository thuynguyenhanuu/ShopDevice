package com.example.dmattd.shopdeviceonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.model.Choxacnhan;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DonhangchoxulyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Choxacnhan> arrayChoxacnhan;

    public DonhangchoxulyAdapter(Context context, ArrayList<Choxacnhan> arrayChoxacnhan) {
        this.context = context;
        this.arrayChoxacnhan = arrayChoxacnhan;
    }

    @Override
    public int getCount() {
        return arrayChoxacnhan.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayChoxacnhan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        public TextView txttensp1, soluongspkhac, txtiddonhang, txttgiandathang, txttrangthai;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listdonhangcho, null);
            viewHolder.txtiddonhang = view.findViewById(R.id.iddonhangcxl);
            viewHolder.txttgiandathang = view.findViewById(R.id.ngaydathangcxl);
            viewHolder.txttrangthai = view.findViewById(R.id.trangthaidon);
            //   viewHolder.txttensp1 = view.findViewById(R.id.tenspcxl);
          //  viewHolder.soluongspkhac = view.findViewById(R.id.soluongspkhac);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        //lay du lieu va gan vao layout
        Choxacnhan choxacnhan = (Choxacnhan) getItem(i);
//        viewHolder.txttensp1.setText(choxacnhan.getTenspcxn());

        //** parse id sang dang String, neu k se bi loi
        viewHolder.txtiddonhang.setText("#"+String.valueOf(choxacnhan.getIddonhang()));
        viewHolder.txttgiandathang.setText(choxacnhan.getNgaydathang());
        if (choxacnhan.getTrangthai().equals("0")){
            viewHolder.txttrangthai.setText("Chờ xử lý");
        }else if(choxacnhan.getTrangthai().equals("1")){
            viewHolder.txttrangthai.setText("Chờ lấy hàng");
        }else if(choxacnhan.getTrangthai().equals("2")){
            viewHolder.txttrangthai.setText("Đang giao");
        }else if(choxacnhan.getTrangthai().equals("3")){
            viewHolder.txttrangthai.setText("Hoàn thành");
        }else if(choxacnhan.getTrangthai().equals("4")){
            viewHolder.txttrangthai.setText("Đã hủy");
        }else if(choxacnhan.getTrangthai().equals("5")){
            viewHolder.txttrangthai.setText("Trả hàng");
        }


        return view;


    }
}
