package com.example.piggybank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter2 extends RecyclerView.Adapter<ItemViewHolder> {


    private ArrayList<PiggybankData> list;

    public RecyclerAdapter2(ArrayList<PiggybankData> list){
        this.list = list;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
       // ((ItemViewHolder)holder).onBind(ist.get(position));

        holder.category.setText(list.get(position).getDate().toString()+" 월");
       holder.money.setText(String.valueOf(list.get(position).getMoney()));

    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    void addItem(PiggybankData data) {
        // 외부에서 item을 추가시킬 함수입니다.
        list.add(data);
    }
}
/*
class ItemViewHolder extends RecyclerView.ViewHolder{
    TextView category;
    TextView money;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        category=itemView.findViewById(R.id.textView);
        money=itemView.findViewById(R.id.textView2);
    }
}*/
