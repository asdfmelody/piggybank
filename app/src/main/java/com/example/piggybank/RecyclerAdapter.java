package com.example.piggybank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {


    private ArrayList<PiggybankData> list;

    public RecyclerAdapter(ArrayList<PiggybankData> list){
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
       // ((ItemViewHolder)holder).onBind(list.get(position));
        holder.category.setText(list.get(position).getCategory());
       holder.money.setText(list.get(position).getMoney());

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
