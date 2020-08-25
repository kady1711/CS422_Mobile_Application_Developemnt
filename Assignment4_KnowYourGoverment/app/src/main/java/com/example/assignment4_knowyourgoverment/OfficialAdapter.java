package com.example.assignment4_knowyourgoverment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OfficialAdapter extends RecyclerView.Adapter<OfficialViewHolder> {

    private List<Official>  officialList;
    private MainActivity mainAct;

    public OfficialAdapter(List<Official> officialList, MainActivity mainAct) {
        this.officialList = officialList;
        this.mainAct = mainAct;
    }
    @NonNull
    @Override
    public OfficialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.officiallistview,parent, false);
        view.setOnClickListener(mainAct);
        return new OfficialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfficialViewHolder holder, int position) {

        Official official = officialList.get(position);
        if (official.getParty() == null) holder.row_name.setText(official.getName());
        else holder.row_name.setText(official.getName()+'('+official.getParty()+')');
        holder.row_office.setText(official.getOfficeName());

    }

    @Override
    public int getItemCount() {
        return officialList.size();
    }
}
