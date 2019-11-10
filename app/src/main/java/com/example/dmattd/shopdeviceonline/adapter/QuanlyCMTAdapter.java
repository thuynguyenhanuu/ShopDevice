package com.example.dmattd.shopdeviceonline.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.model.CheckStatusUser;
import com.example.dmattd.shopdeviceonline.model.Giohang;
import com.example.dmattd.shopdeviceonline.model.Quanlynhanxet;
import com.example.dmattd.shopdeviceonline.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class QuanlyCMTAdapter extends BaseAdapter {

    Context context;
    ArrayList<Quanlynhanxet> arrayquanlynx;


    public QuanlyCMTAdapter(Context context, ArrayList<Quanlynhanxet> arrayquanlynx) {
        this.context = context;
        this.arrayquanlynx = arrayquanlynx;
    }

    @Override
    public int getCount() {
        return arrayquanlynx.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayquanlynx.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public class ViewHolder{
        public TextView txttennguoi, txtnoidung, txttensanpham, txttime;
        public ImageView imghinhanhsp;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_quanly_cmt, null);
            viewHolder.txttennguoi = view.findViewById(R.id.txtnguoinhanxetqlcmt);
            viewHolder.txtnoidung = view.findViewById(R.id.txtnoidungnhanxetqlcmt);
            viewHolder.imghinhanhsp = view.findViewById(R.id.anhSanphamqlcmt);
            viewHolder.txttensanpham = view.findViewById(R.id.tenSanphamqlcmt);
            viewHolder.txttime = view.findViewById(R.id.timeqlnx);
            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Quanlynhanxet quanlynx = (Quanlynhanxet) getItem(i);
        viewHolder.txttennguoi.setText(CheckStatusUser.ten);
        // set mo ta gom co 2 dong
        viewHolder.txtnoidung.setText(quanlynx.getNoidungqlnx());
        viewHolder.txttensanpham.setMaxLines(2);
        viewHolder.txttensanpham.setText(quanlynx.getTensp());
        viewHolder.txttime.setText(quanlynx.getTime());

        Picasso.with(context).load(quanlynx.getImgsp())
                .placeholder(R.drawable.delete_button)
                .error(R.drawable.no_image)
                .into(viewHolder.imghinhanhsp);
        return view;
    }





}
