package com.example.piggybank;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView category;
    TextView money;
    AdapterView.OnItemClickListener listenr;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        category=itemView.findViewById(R.id.comparemoney);
        money=itemView.findViewById(R.id.presentview);



    }

    public void onBind(PiggybankData data){
        category.setText(data.getCategory());
        money.setText(data.getMoney());
    }

}
