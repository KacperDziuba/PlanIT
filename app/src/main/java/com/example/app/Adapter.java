package com.example.app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Note> notes;

    Adapter(Context context,List<Note> notes) {
     this.inflater = LayoutInflater.from(context);
     this.notes = notes;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        String  title    = notes.get(position).getTitle();
        String  date     = notes.get(position).getDate();
        String  time     = notes.get(position).getTime();
        long    id       = notes.get(position).getId();
        Log.d("date on ", "Date on: "+date);

        holder.nTitle.setText(title);
        holder.nDate.setText(date);
        holder.nTime.setText(time);

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nTitle,nDate,nTime,nID;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            nTitle  = itemView.findViewById(R.id.nTitle);
            nDate   = itemView.findViewById(R.id.nDate);
            nTime   = itemView.findViewById(R.id.nTime);

        }
    }
}
