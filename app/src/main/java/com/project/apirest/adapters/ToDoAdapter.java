package com.project.apirest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.project.apirest.R;
import com.project.apirest.models.ToDo;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private List<ToDo> list;
    private LayoutInflater inflater;
    private Context context;

    public ToDoAdapter(List<ToDo> toDos, Context context) {
        this.list = toDos;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ToDoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_todo, null);
        return new ToDoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoAdapter.ViewHolder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView completed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tvTitle);
            completed = itemView.findViewById(R.id.tvCompleted);
        }

        void bindData(ToDo toDo) {
            title.setText(toDo.getTitle());
            completed.setText(toDo.getCompleted() ? "Completed" : "Pending");
        }
    }

}
