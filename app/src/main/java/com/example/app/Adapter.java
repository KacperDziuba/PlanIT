package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Note> notes;

    Adapter(Context context,List<Note> notes){
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_list_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String  title    = notes.get(i).getTitle();
        String  date     = notes.get(i).getDate();
        String  time     = notes.get(i).getTime();
        Log.d("date on ", "Date on: "+date);

        viewHolder.nTitle.setText(title);
        viewHolder.nDate.setText(date);
        viewHolder.nTime.setText(time);

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nTitle,nDate,nTime,nID;

        public ViewHolder(final View itemView) {
            super(itemView);
            nTitle  = itemView.findViewById(R.id.nTitle);
            nDate   = itemView.findViewById(R.id.nDate);
            nTime   = itemView.findViewById(R.id.nTime);

        }
    }
}
