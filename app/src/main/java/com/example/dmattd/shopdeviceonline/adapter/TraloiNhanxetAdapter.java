package com.example.dmattd.shopdeviceonline.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.activity.RecycleviewItemClickListener;
import com.example.dmattd.shopdeviceonline.activity.TraloiCommentActivity;
import com.example.dmattd.shopdeviceonline.model.Traloinhanxet;

import java.util.ArrayList;

public class TraloiNhanxetAdapter extends RecyclerView.Adapter<TraloiNhanxetAdapter.ItemHolder> {

    Context context;
    ArrayList<Traloinhanxet> arrayNhanxet;
    RecycleviewItemClickListener recycleviewItemClickListener;

    public void setOnItemClickListener(RecycleviewItemClickListener recycleviewItemClickListener){
        this.recycleviewItemClickListener = recycleviewItemClickListener;
    }

    public TraloiNhanxetAdapter(Context context, ArrayList<Traloinhanxet> arrayNhanxet) {
        this.context = context;
        this.arrayNhanxet = arrayNhanxet;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dong_traloinhanxet,null );
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        Traloinhanxet nhanxet = arrayNhanxet.get(i);
        itemHolder.txttennguoinx.setText(nhanxet.getTennguoitraloinx());
        itemHolder.txtnoidungnx.setText(nhanxet.getNoidungtraloinx());

        itemHolder.txtTime.setText(nhanxet.getTimetraloinx());
        itemHolder.position = i;
    }

    @Override
    public int getItemCount() {
        return arrayNhanxet.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public TextView txttennguoinx, txtnoidungnx;
        TextView  txtTime, txtTraloi;
        int idNguoiDung;
        int position = 0;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            txttennguoinx = itemView.findViewById(R.id.txtnguoinhanxet1);
            txtnoidungnx = itemView.findViewById(R.id.txtnoidungnhanxet1);

            txtTraloi = itemView.findViewById(R.id.txtTraloi1);
            txtTime = itemView.findViewById(R.id.txttime1);

            txtTraloi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Log.d("REP", "â");
//                    Intent intent = new Intent(context, TraloiCommentActivity.class);
//                    intent.putExtra("ten", String.valueOf(txttennguoinx));
//                    intent.putExtra("noidung", String.valueOf(txtnoidungnx));
//                    context.startActivity(intent);
                }
            });



            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    recycleviewItemClickListener.onItemLongClick(view, position);
                    return true;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recycleviewItemClickListener.onItemClick(view, position);
                }
            });

        }
    }


}
