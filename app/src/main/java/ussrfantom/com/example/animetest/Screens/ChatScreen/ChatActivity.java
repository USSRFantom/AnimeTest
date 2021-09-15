package ussrfantom.com.example.animetest.Screens.ChatScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import ussrfantom.com.example.animetest.R;
import ussrfantom.com.example.animetest.adapters.MessagesAdapter;
import ussrfantom.com.example.animetest.pojo.Message;

public class ChatActivity extends AppCompatActivity {

    private FirebaseFirestore db;

    private RecyclerView recyclerViewMessages;
    private MessagesAdapter adapter;
    private EditText editTextMessage;
    private ImageView imageViewSendMessage;

    private String author;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        db = FirebaseFirestore.getInstance();
        recyclerViewMessages = findViewById(R.id.recyclerViewMessage);
        editTextMessage =findViewById(R.id.editTextMessage);
        imageViewSendMessage = findViewById(R.id.imageViewSendMessage);
        adapter = new MessagesAdapter();
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(adapter);

        author = "Дмитрий";
        imageViewSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
  }

  private void sendMessage(){
        String textOfMessage = editTextMessage.getText().toString().trim();
        if (!textOfMessage.isEmpty()){
            recyclerViewMessages.scrollToPosition(adapter.getItemCount() -1);
            db.collection("messages").add(new Message(author, textOfMessage)).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    editTextMessage.setText("");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull  Exception e) {
                    Toast.makeText(ChatActivity.this, "Сообщение не отправлено", Toast.LENGTH_SHORT).show();
                }
            });
        }
  }

}