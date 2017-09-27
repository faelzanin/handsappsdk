package com.dvloop.hands.features.users.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dvloop.hands.R;
import com.dvloop.hands.features.users.detail.DetailUserActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rafaelzanin on 25/09/17.
 */

public class ListUsersAdapter extends RecyclerView.Adapter<ListUsersAdapter.ViewHolder> {

    private List<String> usersList;
    private Context context;

    public ListUsersAdapter(Context context, List<String> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String userId = usersList.get(position);


        holder.tvUserId.setText(userId);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailUserActivity.class);
                i.putExtra("USER_ID", userId);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cvItemUserList)
        CardView cardView;
        @BindView(R.id.tvUserId)
        TextView tvUserId;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
