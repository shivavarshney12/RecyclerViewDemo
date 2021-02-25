package com.example.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    //ArrayList<contactitem> arrli;
    List<contactitem> arrli;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String email;
    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_1, container, false);
        //arrli=new ArrayList<contactitem>();
        //arrli=new List<contactitem>();
        StudentS s=StudentS.get(getActivity());
        arrli=s.getStudents();
        //createlist();
        recyclerView=(RecyclerView) v.findViewById(R.id.recview);
        layoutManager=new LinearLayoutManager(getContext());
        adapter=new contactadapter(arrli);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        updateDetails();
        return v;
    }
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "onResume1 RV !", Toast.LENGTH_SHORT).show();
        updateDetails();
        //Toast.makeText(getContext(), "onResume2 RV !", Toast.LENGTH_SHORT).show();
    }
    public void createlist(){
        String tmpname="Student";
        String tmproll="MT2010";
        for(int i=0;i<30;i++){
            email=tmpname+(i+1)+"@iiitd.ac.in";
            arrli.add(new contactitem((i+1),tmpname+(i+1),tmproll+(i+1),"CSE",email));
        }
    }
    private void updateDetails(){
        StudentS s=StudentS.get(getActivity());
        List<contactitem> c=s.getStudents();
        //contactitem c1=s.getContact(10);
        adapter=new contactadapter(c);
        recyclerView.setAdapter(adapter);
        /*if(adapter==null){
            Toast.makeText(getContext(), "null adapter", Toast.LENGTH_SHORT).show();
            adapter=new contactadapter(c);
            recyclerView.setAdapter(adapter);
        }
        else {
            Toast.makeText(getContext(), "notnull adapter !"+c1.getName(), Toast.LENGTH_SHORT).show();
            adapter=new contactadapter(c);
            adapter.notifyDataSetChanged();
        }*/

    }
}