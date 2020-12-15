package com.hfad.adlesson6fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android1lesson71.Destination;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<Destination> list;
    private Context context;

    public IFragments listener;


    public RecyclerAdapter(ArrayList<Destination> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.onBind(list.get(position),position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtTitle;
        private TextView txtSubTitle;
        private ImageView   imageViewForId;


        private Destination model;
        int pos = 0;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            txtSubTitle = itemView.findViewById(R.id.tvDesc);
            txtTitle = itemView.findViewById(R.id.tvTitle);
            imageViewForId = itemView.findViewById(R.id.imageViewRecycler);
        }

        private void onBind(Destination model, int pos){
            this.model = model;
            this.pos = pos;


            txtTitle.setText(model.getTitle());
            txtSubTitle.setText(model.getSubTitle());
        }

        @Override
        public void onClick(View v) {
            if(listener !=null) {
                listener.displayDetails(model.getTitle(), model.getSubTitle(), model.getImageResourceId());
            }
        }
    }

    // after this it jumps to ChangeFragment class

    public void setOnClickListener(IFragments mListener){
        this.listener = mListener;
    }
}