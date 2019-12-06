package com.example.seventhhomework.recycleview;


import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.seventhhomework.R;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyInnerViewHolder> {
    private Context context;
    private ArrayList<Linkman>linkmanArrayList;


    public RvAdapter (Context context,ArrayList<Linkman>linkmanArrayList){
        this.context=context;
        this.linkmanArrayList=linkmanArrayList;
    }
    @NonNull
    @Override
    public MyInnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = View.inflate(context,R.layout.rv_item,null);
        itemview.setOnClickListener(onItemClickListener);
        return new MyInnerViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyInnerViewHolder holder, int position) {
        Linkman data = linkmanArrayList.get(position);
        holder.mname.setText(data.getName());
        holder.mtime.setText(data.getTime());
        holder.mnumber.setText(data.getNumber());
        holder.ming.setImageResource(data.getImg());
    }

    @Override
    public int getItemCount() {
        return  linkmanArrayList.size();
    }

    class MyInnerViewHolder extends RecyclerView.ViewHolder {
        private TextView mname;
        private TextView mtime;
        private TextView mnumber;
        private ImageView ming;
        MyInnerViewHolder(@NonNull View itemView) {
            super(itemView);
            mnumber=itemView.findViewById(R.id.item_number);
            mname =itemView.findViewById(R.id.item_name);
            mtime=itemView.findViewById(R.id.item_time);
            ming=itemView.findViewById(R.id.item_img);
        }
    }


    private View.OnClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
