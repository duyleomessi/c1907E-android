package com.example.c1907e_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c1907e_android.post.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.ViewHolder> {
    private Context context;
    private List<User> users;
    private OnUserListener mOnUserListener;

    public GithubUserAdapter(Context context, List<User> users, OnUserListener mOnUserListener) {
        this.context = context;
        this.users = users;
        this.mOnUserListener = mOnUserListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView avatar;
        private TextView username;
        OnUserListener onUserListener;

        public ViewHolder(View itemView, OnUserListener onUserListener) {
            super(itemView);
            avatar = (ImageView) itemView.findViewById(R.id.rv_gh_user_avatar);
            username = (TextView) itemView.findViewById(R.id.rv_gh_user_username);
            this.onUserListener = onUserListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onUserListener.onUserClick(getBindingAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_github_user, parent, false);
        return new ViewHolder(view, mOnUserListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        Picasso.get().load(user.getAvatar()).into(holder.avatar);
        holder.username.setText(user.getLogin());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void updateUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public interface OnUserListener {
        void onUserClick(int position);
    }
}
