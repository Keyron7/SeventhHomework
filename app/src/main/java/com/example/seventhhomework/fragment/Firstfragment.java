package com.example.seventhhomework.fragment;

import android.Manifest;
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
    public View view;
    public RecyclerView recyclerView1;
    private RvAdapter rvAdapter;
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
        Linkman linkman1 = new Linkman("123456789","10:11");
        for (int i = 0;i<20;i++){
        linkmen.add(linkman1); }
        }
    private void initRecyclerView(){
        recyclerView1=(RecyclerView) view.findViewById(R.id.rv_firstcall);
        rvAdapter = new RvAdapter(getActivity(),linkmen);
        recyclerView1.setAdapter(rvAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        rvAdapter.setOnItemClickListener(this);
    }
    private void callPhone(String number) {

        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel"+number));
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        TextView textView = v.findViewById(R.id.item_name);
        String number = textView.getText().toString();
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            callPhone(number);
        }else {
            Toast.makeText(getActivity(),"请重新打开应用以获取权限",Toast.LENGTH_SHORT).show();
        }
    }
}
