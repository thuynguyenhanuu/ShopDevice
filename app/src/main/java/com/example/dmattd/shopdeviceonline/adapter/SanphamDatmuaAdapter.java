package com.example.dmattd.shopdeviceonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.activity.MainActivity;
import com.example.dmattd.shopdeviceonline.model.Giohang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanphamDatmuaAdapter extends BaseAdapter {

    Context context;
    ArrayList<Giohang> arrayGiohang;

    public SanphamDatmuaAdapter(Context context, ArrayList<Giohang> arrayGiohang) {
        this.context = context;
        this.arrayGiohang = arrayGiohang;
    }

    @Override
    public int getCount() {
        return arrayGiohang.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayGiohang.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        public TextView txttenspgh, txtgiaspgh;
        public ImageView imghinhanhspgh;
        public TextView txtsoluonggh;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_sanpham_donhang, null);
            viewHolder.txttenspgh = view.findViewById(R.id.ten);
            viewHolder.txtgiaspgh = view.findViewById(R.id.gia);
            viewHolder.imghinhanhspgh = view.findViewById(R.id.hinhanh);
            viewHolder.txtsoluonggh = view.findViewById(R.id.soluong);
            view.setTag(viewHolder);
        }else {
            viewHolder = (SanphamDatmuaAdapter.ViewHolder) view.getTag();
        }
        //lay du lieu va gan vao layout
        Giohang giohang = (Giohang) getItem(i);
        viewHolder.txttenspgh.setText(giohang.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiaspgh.setText("Giá: " +decimalFormat.format(MainActivity.manggiohang.get(i).getGiasp()) + "Đ");
        Picasso.with(context).load(giohang.getHinhanhsp())
                .placeholder(R.drawable.delete_button)
                .error(R.drawable.no_image)
                .into(viewHolder.imghinhanhspgh);
        //cast vef dang chuoi
        viewHolder.txtsoluonggh.setText(MainActivity.manggiohang.get(i).getSoluongsp() + "");



        return view;
    }
}
