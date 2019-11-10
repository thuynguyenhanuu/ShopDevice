package com.example.dmattd.shopdeviceonline.adapter;

import android.app.MediaRouteButton;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmattd.shopdeviceonline.R;
import com.example.dmattd.shopdeviceonline.activity.RecycleviewItemClickListener;
import com.example.dmattd.shopdeviceonline.activity.TraloiCommentActivity;
import com.example.dmattd.shopdeviceonline.model.Nhanxet;
import com.example.dmattd.shopdeviceonline.model.Traloinhanxet;

import java.util.ArrayList;

public class NhanxetAdapter extends RecyclerView.Adapter<NhanxetAdapter.ItemHolder> {

    Context context;
    ArrayList<Nhanxet> arrayNhanxet;
    RecycleviewItemClickListener recycleviewItemClickListener;


    String ten = "";
    String noidung = "";
    String time = "";


    public void setOnItemClickListener(RecycleviewItemClickListener recycleviewItemClickListener){
        this.recycleviewItemClickListener = recycleviewItemClickListener;
    }


    public NhanxetAdapter(Context context, ArrayList<Nhanxet> arrayNhanxet) {
        this.context = context;
        this.arrayNhanxet = arrayNhanxet;


    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dong_nhan_xet,null );
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder itemHolder, int i) {
        final Nhanxet nhanxet = arrayNhanxet.get(i);
        int id = 0;
        itemHolder.txttennguoinx.setText(nhanxet.getTennguoinx());
        itemHolder.txtnoidungnx.setText(nhanxet.getNoidungnx());

        itemHolder.txtTime.setText(nhanxet.getTime());
        itemHolder.position = i;
//        itemHolder.txtnumberrep.setText(nhanxet.getRepNumber());


            itemHolder.txtTraloi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
    //                Log.d("REP", "â" + String.valueOf(txttennguoinx));
                    Intent intent = new Intent(context, TraloiCommentActivity.class);
                    intent.putExtra("ten", itemHolder.txttennguoinx.getText());
                    intent.putExtra("noidung", itemHolder.txtnoidungnx.getText());
                    intent.putExtra("time", itemHolder.txtTime.getText());
                    intent.putExtra("idnhanxet", nhanxet.getId());
                    context.startActivity(intent);
                   // Toast.makeText(context, "abc" + nhanxet.getId() , Toast.LENGTH_SHORT).show();
                }
            });

            //if(nhanxet.getRepNumber() > 0){
                    Toast.makeText(context, "abc" + nhanxet.getRepNumber() , Toast.LENGTH_SHORT).show();
                   // itemHolder.txtxemthem.setVisibility(View.VISIBLE);
                   // itemHolder.txtnumberrep.setText(nhanxet.getRepNumber());

                itemHolder.txtxemthem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, TraloiCommentActivity.class);
                        intent.putExtra("ten", itemHolder.txttennguoinx.getText());
                        intent.putExtra("noidung", itemHolder.txtnoidungnx.getText());
                        intent.putExtra("time", itemHolder.txtTime.getText());
                        intent.putExtra("idnhanxet", nhanxet.getId());
                        context.startActivity(intent);
                    }
                });
            }

        //}

    @Override
    public int getItemCount() {
        return arrayNhanxet.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public TextView txtxemthem;
        //public TextView txtxemthem;

        public TextView txttennguoinx, txtnoidungnx;
        TextView  txtTime, txtTraloi;
        int position = 0;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            txttennguoinx = itemView.findViewById(R.id.txtnguoinhanxet);
            txtnoidungnx = itemView.findViewById(R.id.txtnoidungnhanxet);
            txtTraloi = itemView.findViewById(R.id.txtTraloi);
            txtTime = itemView.findViewById(R.id.txttime);
            txtxemthem = itemView.findViewById(R.id.xemthem);
           // txtnumberrep = itemView.findViewById(R.id.txtNumberrep);






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
