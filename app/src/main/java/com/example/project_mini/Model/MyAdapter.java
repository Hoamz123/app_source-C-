package com.example.project_mini.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_mini.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHodel>{

    private Context context;
    private List<Des> desList;

    private onItemListener onItemListener;

    public interface onItemListener {
        void onItemSelect(int pos);
    }

    public MyAdapter(List<Des> list,Context context){
        this.context = context;
        this.desList = list;
    }

    public void setOnItemListener(onItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public myViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_detail,parent,false);
        return new myViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHodel holder, int position) {
        //do du lieu nen
        String name = desList.get(position).getName();
        String complexity = desList.get(position).getComplexity();

        holder.txtView.setText(String.format("\n%s\n\n%s\n", name, complexity));

        //xu ly su kien trong rcView tai day

        holder.cardView.setOnClickListener(v -> {
            Toast.makeText(context,"hoamz",Toast.LENGTH_SHORT).show();
        });

        holder.cardView.setOnClickListener(v -> {
            onItemListener.onItemSelect(position);
        });

    }

    @Override
    public int getItemCount() {
        if(this.desList != null){
            return this.desList.size();
        }
        return 0;
    }

    public static class myViewHodel extends RecyclerView.ViewHolder{

        //khoi tao nhung attribute xuat hien tren rcView\

        private CardView cardView;
        private TextView txtView;

        public myViewHodel(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            txtView = itemView.findViewById(R.id.txtRcView);
        }
    }
}
