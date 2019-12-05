package com.example.seventhhomework.recycleview;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
        View itemview = View.inflate(context,R.layout.item,null);
        itemview.setOnClickListener(onItemClickListener);
        return new MyInnerViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyInnerViewHolder holder, int position) {
        Linkman data = linkmanArrayList.get(position);
        holder.mname.setText(data.name);
        holder.mtime.setText(data.time);
    }

    @Override
    public int getItemCount() {
            return  linkmanArrayList.size();
    }

    public class MyInnerViewHolder extends RecyclerView.ViewHolder {
       private TextView mname;
       private TextView mtime;
//       private ImageView mimg;
        public MyInnerViewHolder(@NonNull View itemView) {
            super(itemView);
            mname =itemView.findViewById(R.id.item_name);
            mtime=itemView.findViewById(R.id.item_time);
//            mimg=itemView.findViewById(R.id.item_img);
        }
    }


    private View.OnClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
