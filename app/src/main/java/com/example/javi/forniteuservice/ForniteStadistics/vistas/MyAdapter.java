package com.example.javi.forniteuservice.ForniteStadistics.vistas;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.javi.forniteuservice.ForniteStadistics.dto.ForniteDataDetails;
import com.example.javi.forniteuservice.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ForniteViewHolder> {


    private List<ForniteDataDetails> dataObject;

    public MyAdapter(List<ForniteDataDetails> dataObject) {
        this.dataObject = dataObject;
    }

    @Override
    public ForniteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycleview, viewGroup, false);
        return new ForniteViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ForniteViewHolder forniteViewHolder, int i) {
        final ForniteDataDetails item = dataObject.get(i);
        forniteViewHolder.txtForniteTitle.setText(item.getField());
        forniteViewHolder.txtForniteValue.setText(item.getDisplayValue());
        forniteViewHolder.txtForniteRank.setText(item.getRank());

    }

    @Override
    public int getItemCount() {
        return dataObject.size();
    }

    public class ForniteViewHolder extends RecyclerView.ViewHolder {

        private TextView txtForniteTitle, txtForniteValue, txtForniteRank;

        public ForniteViewHolder(View itemView) {
            super(itemView);
            txtForniteTitle = itemView.findViewById(R.id.textViewtitle);
            txtForniteValue = itemView.findViewById(R.id.textViewvalue);
            txtForniteRank = itemView.findViewById(R.id.textViewrank);
        }
    }
}