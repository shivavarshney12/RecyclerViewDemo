package com.example.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    contactitem c;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String name,dept,email;
    Button submit;
    EditText editText1,editText2,editText3;
    TextView t1,t2,t3;
    private static ArrayList<contactitem> conlist;
    public  Fragment2() {}
    //public Fragment2(ArrayList<contactitem> list){
        //conlist=list;
    //}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        //Fragment2 fragment = new Fragment2(conlist);
        Fragment2 fragment=new Fragment2();
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


        //contactitem currentcontact=conlist.get(pos);
        View v=inflater.inflate(R.layout.fragment_2, container, false);
        //Toast.makeText(getContext(), "New data is !"+ c.getName(), Toast.LENGTH_SHORT).show();

        submit = (Button) v.findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1= (EditText) v.findViewById(R.id.editText);
                editText2= (EditText) v.findViewById(R.id.editText2);
                editText3= (EditText) v.findViewById(R.id.editText3);
                Toast.makeText(getContext(), "New data on click is !", Toast.LENGTH_SHORT).show();
                name = editText1.getText().toString();
                dept = editText2.getText().toString();
                email = editText3.getText().toString();
                c.setName(name);
                c.setdept(dept);
                c.setEmail(email);
                Toast.makeText(getContext(), "Data saved!!New name is !"+name, Toast.LENGTH_SHORT).show();
            }
        });
        /*
        t1.setText(name.toString());
        t2.setText(c.getDept());
        t3.setText(c.getEmail());

        Toast.makeText(getContext(), "New data before click is !"+ t1.getText(), Toast.LENGTH_SHORT).show();*/

                /*currentcontact.setName(name);
                currentcontact.setdept(dept);
                currentcontact.setEmail(email);
                v.getContext().startActivity(new Intent(v.getContext(),ContactActiv   ity.class));*/
           // }
        //
        //
        //
        //
        //});
        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Bundle bundle=this.getArguments();
        int pos=bundle.getInt("position");
        pos++;
        Toast.makeText(getContext(), "New Position is !"+ pos, Toast.LENGTH_SHORT).show();
        StudentS s=StudentS.get(getActivity());
        c= s.getContact(pos);
        t1= (TextView) getView().findViewById(R.id.textview1);
        t2= (TextView) getView().findViewById(R.id.textview2);
        t3= (TextView) getView().findViewById(R.id.textview3);
        t1.setText("Student name: "+c.getName());
        t2.setText("Student dept: "+c.getDept());
        t3.setText("Student email: "+c.getEmail());

    }
    public void save(View v){
        Toast.makeText(getContext(), "save method !", Toast.LENGTH_SHORT).show();
    }
}