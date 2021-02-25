package com.example.recyclerviewdemo;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class contactadapter extends RecyclerView.Adapter<contactadapter.contactviewholder> implements Serializable {
    //private ArrayList<contactitem> conlist;
    //private List<contactadapter>conlist;
    private List<contactitem>conlist;
    private String emailId;
    //contactitem currentcontact;
    /*public  contactadapter(ArrayList<contactitem> list){
        conlist=list;
    }*/
    public contactadapter(List<contactitem> list){
        this.conlist=list;
    }
    @NonNull
    @Override
    public contactviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_contact,parent,false);
        contactviewholder cvholder=new contactviewholder(v);
        return cvholder;
    }

    @Override
    public void onBindViewHolder(@NonNull contactviewholder holder, int position) {
        contactitem currentcontact=conlist.get(position);
        //StudentS s=StudentS.get(getActivity());
        //currentcontact= s.getContact(position);
        holder.conname.setText(currentcontact.getName());
        holder.connum.setText(currentcontact.getrollno());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(holder.conname.getText()==currentcontact.getName()) {
                    emailId=currentcontact.getName()+currentcontact.getrollno()+"@iiitd.ac.in";
                    holder.conname.setText(currentcontact.getName()+", Dept: "+currentcontact.getDept()+", Email Id: "+emailId);
                    /*Toast.makeText(v.getContext(),"Student "+currentcontact.getId()+" has been clicked",Toast.LENGTH_SHORT).show();
                }
                else {
                    holder.conname.setText("test");
                    Fragment2 f2= new Fragment2();
                    Bundle args= new Bundle();
                    args.putString("currentContact",position.toString());
                    f2.setArguments(args);
                    getFragmentManager().be
                    //Toast.makeText(v.getContext(),"Student "+currentcontact.getId()+" has been clicked",Toast.LENGTH_SHORT).show();
                }*/
                Intent i=new Intent(v.getContext(),Activity2.class);
                i.putExtra("pos",position);
                /*i.putExtra("list",conlist);
                i.putExtra("name",currentcontact.getName());
                i.putExtra("dept",currentcontact.getDept());
                i.putExtra("email",currentcontact.getEmail());*/
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return conlist.size();
    }
    public void setItems(List<contactitem> c){
        this.conlist=c;
    }

    public static class contactviewholder extends RecyclerView.ViewHolder{
        public TextView conname;
        public TextView connum;

        public contactviewholder(@NonNull View itemView) {
            super(itemView);
            conname=itemView.findViewById(R.id.contact_name);
            connum=itemView.findViewById(R.id.contact_phonenumber);

        }
    }
}
