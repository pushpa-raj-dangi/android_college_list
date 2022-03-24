package com.pushpa.android_college_list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pushpa.android_college_list.model.College;

import java.util.List;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.ViewHolder>  {

    private List<College> collegeList;
    Context c;
    // Pass in the contact array into the constructor
    public CollegeAdapter(Context c,List<College> collegeList) {
        this.collegeList= collegeList;
        this.c = c;
    }

    @Override
    public CollegeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.college_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CollegeAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        College clg = this.collegeList.get(position);
        TextView textView = holder.name;
        textView.setText(clg.getName());
        Button button = holder.map;
        Button btnWeb = holder.web;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG", "onClick: "+collegeList.toString() );
                Intent intent = new Intent(c,MapsActivity.class);
                intent.putExtra("lat",clg.getLat());
                intent.putExtra("lng",clg.getLang());
                intent.putExtra("name", clg.getName());

                c.startActivity(intent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(collegeList.get(position).getWebsite())));
            }
        });

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return collegeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public Button map,web;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.clgName);
            map = itemView.findViewById(R.id.viewMap);
            web = itemView.findViewById(R.id.viewWebsite);


        }
    }
}
