package com.example.reviewfragmentrecycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reviewfragmentrecycler.R;
import com.example.reviewfragmentrecycler.modle.Person;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ReViewHolder> {

    Context context;
    ArrayList<Person> personArrayList;

    public RecyclerAdapter(Context context, ArrayList<Person> personArrayList) {
        this.context = context;
        this.personArrayList = personArrayList;
    }

    @NonNull
    @Override
    public ReViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReViewHolder(LayoutInflater.from(context).inflate(R.layout.itemperson,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReViewHolder holder, int position) {

        Person person=personArrayList.get(position);
        holder.tv_name.setText(person.getName());
        holder.tv_num.setText(person.getNumber());



    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    class ReViewHolder extends RecyclerView.ViewHolder{
TextView tv_name,tv_num;

        public ReViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name=itemView.findViewById(R.id.tv_name);
            tv_num=itemView.findViewById(R.id.tv_number);
        }
    }

}
