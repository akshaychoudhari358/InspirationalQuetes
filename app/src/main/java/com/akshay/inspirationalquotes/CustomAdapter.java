package com.akshay.inspirationalquotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Quotes> dataList;
    private Context context;

    public CustomAdapter(Context context, List<Quotes> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtData;
        TextView txtAuthor;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            txtData = mView.findViewById(R.id.data);
            txtAuthor = mView.findViewById(R.id.author);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.txtData.setText(dataList.get(position).getText());
        holder.txtAuthor.setText(dataList.get(position).getAuthor());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
