package ussrfantom.com.example.animetest;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class firebase {





    public static void setCollection() {

        for(int a = 140; a<180; a++) {
            System.out.println("сработал " + a);
            String b = Integer.toString(a);

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            Map<String, Object> user = new HashMap<>();
            user.put("1", "Алхимик");
            user.put("2", "Инопланетянин");
            user.put("3", "Это растение");
            user.put("4", "картинка");
            user.put("5", "?");

            db.collection(b).add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    System.out.println("Успешно " );
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    System.out.println("Провалено " );
                }
            });

        }
    }
}
