package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHold> {
    private Context mcontext;
    private List<User> listUser;

    public UserAdapter(Context context) {
        this.mcontext = context;
    }
    public void SetData(List<User> list)
    {
        this.listUser=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHold holder, int position) {
            User user=listUser.get(position);
            if(user==null)
            {
                return ;
            }
        holder.imgUser.setImageResource(user.getResourceId());
        holder.tvName.setText(user.getName());
        holder.layoutitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickgotoDetail(user);
            }
        });

    }

    private void onClickgotoDetail(User user) {
        Intent intent=new Intent(mcontext,detail_activity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("object_user",user);
        intent.putExtras(bundle);
        mcontext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(listUser!=null)
        {
            return listUser.size();
        }
        return 0;
    }

    public class UserViewHold extends RecyclerView.ViewHolder{
        private RelativeLayout layoutitem;
        private ImageView imgUser;
        private TextView tvName;
        public UserViewHold(@NonNull View itemView) {
            super(itemView);
            imgUser =itemView.findViewById(R.id.img_user);
            layoutitem =itemView.findViewById(R.id.layout_item);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
