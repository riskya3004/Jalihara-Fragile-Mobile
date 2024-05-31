package com.example.fragile_jalihara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShowAdapterTwo extends RecyclerView.Adapter<ShowAdapterTwo.MyViewHolder>{
    private List<HomePage.ShowModel> showList;
    private SelectListener listener;
    Context context;
    static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView rvItem;
        TextView title, location;
        ImageView img;
        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.titlerv);
            location = view.findViewById(R.id.locationrv);
            img = view.findViewById(R.id.imgrv);
//                rvItem = view.findViewById(R.id.cardItem);
            rvItem = view.findViewById(R.id.imgrv);
        }
    }
    public ShowAdapterTwo(Context context, List<HomePage.ShowModel> showList, SelectListener listener) {
        this.context = context;
        this.showList = showList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public ShowAdapterTwo.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ShowAdapterTwo.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HomePage.ShowModel show = showList.get(position);
        holder.title.setText(show.getTitle());
        holder.location.setText(show.getLocation());
        holder.img.setImageResource(show.getImg());
        holder.rvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(showList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return showList.size();
    }
}
