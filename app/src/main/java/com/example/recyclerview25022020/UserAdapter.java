package com.example.recyclerview25022020;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ItemViewHolder>{

    private ArrayList<User> mArrayUsers;
    private OnListenerClickItem onListenerClickItem;

    public UserAdapter(){
        mArrayUsers = new ArrayList<>();
    }

    public void submitData(ArrayList<User> arrayUsers){
        if (arrayUsers!= null){
            mArrayUsers.clear();
            mArrayUsers.addAll(arrayUsers);
            notifyDataSetChanged();
        }
    }
    public void addItem(User user){
        if (user != null){
            mArrayUsers.add(user);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout_user,null,true);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        User user = mArrayUsers.get(position);
        holder.mImage.setImageResource(user.getImage());
        holder.mTvName.setText(user.getName());
        holder.mTvAge.setText(String.valueOf(user.getAge()));
    }

    @Override
    public int getItemCount() {
        return mArrayUsers.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mTvName,mTvAge;
        public ItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            mTvAge = itemView.findViewById(R.id.textviewAge);
            mImage = itemView.findViewById(R.id.imageview);
            mTvName = itemView.findViewById(R.id.textviewName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onListenerClickItem.onItemClick(getLayoutPosition());
                }
            });
        }
    }
    public void setOnItemClickListener( OnListenerClickItem onListenerClickItem){
        this.onListenerClickItem = onListenerClickItem;
    }
}
