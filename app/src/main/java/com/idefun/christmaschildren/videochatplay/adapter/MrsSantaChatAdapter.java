package com.idefun.christmaschildren.videochatplay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.idefun.christmaschildren.videochatplay.R;
import com.idefun.christmaschildren.videochatplay.activity.Chat;

import java.util.ArrayList;

public class MrsSantaChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int TYPE_RECIEVER = 2;
    int TYPE_SENDER = 1;
    ArrayList<Chat> chatArrayList;
    Context context;

    public class Reciever extends RecyclerView.ViewHolder {
        TextView textView;

        public Reciever(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.text_chat_you);
        }
    }

    public class Sender extends RecyclerView.ViewHolder {
        TextView textView;

        public Sender(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.text_chat_me);
        }
    }

    public MrsSantaChatAdapter(Context context2, ArrayList<Chat> arrayList) {
        this.context = context2;
        this.chatArrayList = arrayList;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == this.TYPE_SENDER) {
            return new Sender(LayoutInflater.from(this.context).inflate(R.layout.card_view_chat_msg_me, viewGroup, false));
        }
        if (i == this.TYPE_RECIEVER) {
            return new Reciever(LayoutInflater.from(this.context).inflate(R.layout.santa_claus_cardview, viewGroup, false));
        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Chat chat = (Chat) this.chatArrayList.get(i);
        if (getItemViewType(i) == this.TYPE_SENDER) {
            ((Sender) viewHolder).textView.setText(chat.getMessage());
        } else {
            ((Reciever) viewHolder).textView.setText(chat.getMessage());
        }
    }

    public int getItemViewType(int i) {
        if (((Chat) this.chatArrayList.get(i)).getType() == 1) {
            return this.TYPE_SENDER;
        }
        return this.TYPE_RECIEVER;
    }

    public int getItemCount() {
        return this.chatArrayList.size();
    }
}
