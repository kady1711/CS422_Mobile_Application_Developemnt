package com.example.assignment4_knowyourgoverment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class OfficialViewHolder extends RecyclerView.ViewHolder {
    public TextView row_name;
    public TextView row_office;

    public OfficialViewHolder(View itemView) {
        super(itemView);
        row_name = (TextView) itemView.findViewById(R.id.row_nameText);
        row_office = (TextView) itemView.findViewById(R.id.row_officeText);
    }
}
