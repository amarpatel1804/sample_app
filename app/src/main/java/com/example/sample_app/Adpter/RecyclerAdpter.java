package com.example.sample_app.Adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sample_app.Model.PojoModel;
import com.example.sample_app.R;

import java.util.List;

public class RecyclerAdpter extends RecyclerView.Adapter<RecyclerAdpter.ViewHolder> {
    List<PojoModel.Detail> list;

    public RecyclerAdpter(List<PojoModel.Detail> list){
        this.list=list;
    }

    @NonNull
    @Override
    public RecyclerAdpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdpter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.idNo.setText(String.valueOf(list.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,idNo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            idNo=itemView.findViewById(R.id.idNumber);

        }
    }
}
