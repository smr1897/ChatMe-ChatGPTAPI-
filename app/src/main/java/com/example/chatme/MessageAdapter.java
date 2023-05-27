package com.example.chatme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{

    List<Message> messageList;
    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_items,null);
        MyViewHolder myViewHolder = new MyViewHolder(chatView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        if(message.getSentBy().equals(Message.sent_by_me))
        {
            holder.left_chat_msg.setVisibility(View.GONE);
            holder.right_chat_msg.setVisibility(View.VISIBLE);
            holder.right_chat_textView.setText(message.getMessage());
        }
        else
        {
            holder.right_chat_msg.setVisibility(View.GONE);
            holder.left_chat_msg.setVisibility(View.VISIBLE);
            holder.left_chat_textView.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout left_chat_msg,right_chat_msg;
        TextView left_chat_textView,right_chat_textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            left_chat_msg = itemView.findViewById(R.id.left_chat_msg);
            right_chat_msg = itemView.findViewById(R.id.right_chat_msg);
            left_chat_textView = itemView.findViewById(R.id.left_chat_textView);
            right_chat_textView = itemView.findViewById(R.id.right_chat_textView);

        }
    }

}
