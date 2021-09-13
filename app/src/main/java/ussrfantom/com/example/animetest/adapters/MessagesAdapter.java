package ussrfantom.com.example.animetest.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ussrfantom.com.example.animetest.R;
import ussrfantom.com.example.animetest.pojo.Message;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>{

    private List<Message> messages;

    public MessagesAdapter() {
        messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_message, viewGroup, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int position) {
        messageViewHolder.textViewAuthor.setText(messages.get(position).getAuthor());
        messageViewHolder.textViewTextOfMessage.setText(messages.get(position).getTextOfMessage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }



    class MessageViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewAuthor;
        private TextView textViewTextOfMessage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewTextOfMessage = itemView.findViewById(R.id.textViewTextOfMessage);
        }
    }

}
