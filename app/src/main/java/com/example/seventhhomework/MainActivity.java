package com.example.seventhhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.widget.Toast;

import com.example.seventhhomework.fragment.ViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar !=null)
        {
            actionBar.hide();
        }
        setContentView(R.layout.main);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager =findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewpagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions( this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions( this, new String[]{Manifest.permission.SEND_SMS}, 2);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
            case 2:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "申请权限成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "你拒绝了这个权限的申请", Toast.LENGTH_SHORT).show();
                }
                break;
            default:

        }
    }
}