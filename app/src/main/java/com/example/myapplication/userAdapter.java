package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userViewHolder> {
    private ArrayList<UserItem> mUserItemArrayList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class userViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mUsername;
        public ImageView mDeleteImage;

        public userViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mUsername = itemView.findViewById(R.id.textViewUserName);
            mDeleteImage = itemView.findViewById(R.id.image_delete);

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public userAdapter(ArrayList<UserItem> userItemArrayList) {
        mUserItemArrayList = userItemArrayList;

    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        userViewHolder rvh = new userViewHolder(v, mListener);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        UserItem userItem = mUserItemArrayList.get(position);

        holder.mImageView.setImageResource(userItem.getImageResource());
        holder.mUsername.setText(userItem.getUserName());

    }

    @Override
    public int getItemCount() {
        return mUserItemArrayList.size();
    }
}
