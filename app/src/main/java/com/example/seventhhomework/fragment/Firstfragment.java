package com.example.seventhhomework.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.seventhhomework.R;
import com.example.seventhhomework.recycleview.Linkman;
import com.example.seventhhomework.recycleview.RvAdapter;
import java.util.ArrayList;
public class Firstfragment extends Fragment implements View.OnClickListener
{
    private View view;
    private ArrayList<Linkman>linkmen = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment1,container,false);
        initData();
        initRecyclerView();
        return view;
    }
    private void initData(){
        for (int i = 10;i<40;i++){
            Linkman linkman1 = new Linkman("YZ","10:"+i,"123456789123",R.drawable.touxiang);
            linkmen.add(linkman1); }
    }
    private void initRecyclerView(){
        RecyclerView recyclerView1 =  view.findViewById(R.id.rv_firstcall);
        RvAdapter rvAdapter = new RvAdapter(getActivity(), linkmen);
        recyclerView1.setAdapter(rvAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        rvAdapter.setOnItemClickListener(this);
    }
    private void callPhone(String number) {

        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+number));
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    private void sendMessage(String number){

        try {
            Uri uri = Uri.parse("smsto://"+number);
            Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
            startActivity(intent);
        } catch (SecurityException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        TextView textView = v.findViewById(R.id.item_number);
        final String number = textView.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("执行方式：");
        builder.setMessage("请选择执行方式");
        builder.setPositiveButton("打电话", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(),"请重新打开应用以获取权限",Toast.LENGTH_SHORT).show();
                }else {
                    callPhone(number);
                }
            }
        });
        builder.setNegativeButton("发短信", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(),"请重新打开应用以获取权限",Toast.LENGTH_SHORT).show();
                }else {
                    sendMessage(number);
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
