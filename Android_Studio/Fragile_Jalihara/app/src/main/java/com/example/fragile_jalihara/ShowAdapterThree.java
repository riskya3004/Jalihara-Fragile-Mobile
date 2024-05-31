package com.example.fragile_jalihara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShowAdapterThree extends RecyclerView.Adapter<ShowAdapterThree.MyViewHolder>{
    private List<TicketCatalog.ShowModel> showList;
    private SelectListener listener;
    Context context;

    static class MyViewHolder extends RecyclerView.ViewHolder {
            public Button rvItem;
            TextView title, location;
            ImageView img;
        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.titlerv);
            location = view.findViewById(R.id.locationrv);
            img = view.findViewById(R.id.imgrv);
            rvItem = view.findViewById(R.id.buybtn);
        }

    }

    public ShowAdapterThree(Context context, List<TicketCatalog.ShowModel> showList, SelectListener listener) {
        this.context = context;
        this.showList = showList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ShowAdapterThree.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.catalog_item, parent, false);
        return new ShowAdapterThree.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TicketCatalog.ShowModel show = showList.get(position);
        holder.title.setText(show.getTitle());
        holder.location.setText(show.getLocation());
        holder.img.setImageResource(show.getImg());
        holder.rvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClickedCatalog(showList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return showList.size();
    }
}
