package com.example.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
//import android.support.v4.app.Fragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Bundle bundle=new Bundle();
        Intent i=getIntent();
        int pos=i.getIntExtra("pos",0);
        Toast.makeText(getApplicationContext(), "Position is !"+ pos, Toast.LENGTH_SHORT).show();
        /*bundle.putString("name",i.getStringExtra("name"));
        bundle.putString("dept",i.getStringExtra("dept"));
        bundle.putString("email",i.getStringExtra("email"));*/
        bundle.putInt("position",pos);
        //Fragment2 f2=new Fragment2((ArrayList<contactitem>)i.getSerializableExtra("list"));
        Fragment2 f2=new Fragment2();
        f2.setArguments(bundle);
        //FragmentManager fm= getSupportFragmentManager();
        //Fragment2 f2=new Fragment2();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frag_view, f2)
                .commit();

    }


}