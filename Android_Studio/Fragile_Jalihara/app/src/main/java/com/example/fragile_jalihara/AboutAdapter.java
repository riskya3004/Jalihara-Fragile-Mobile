package com.example.fragile_jalihara;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.MyViewHolder>{

    String[] list;
    String[] loc;
    Integer[] img;
    public AboutAdapter(String[] list, String[] loc, Integer[] img){
        this.list=list;
        this.loc = loc;
        this.img = img;
    };
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(list[position]);
        holder.location.setText(loc[position]);
        holder.img.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView rvItem;
        TextView title, location;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rvItem = itemView.findViewById(R.id.imgrv);
            title = itemView.findViewById(R.id.titlerv);
            location = itemView.findViewById(R.id.locationrv);
            img = itemView.findViewById(R.id.imgrv);
        }
    }
}
