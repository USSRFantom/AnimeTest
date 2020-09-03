package ussrfantom.com.example.animetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.Map;
import java.util.logging.Level;

public class level1 extends AppCompatActivity {
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        final Button button1 = findViewById(R.id.button_question1);
        final Button button2 = findViewById(R.id.button_question2);
        final Button button3 = findViewById(R.id.button_question3);
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level_1);
        final ImageView img_question = findViewById(R.id.imageView_question);
    //код скругляющий углы у картинки
        img_question.setClipToOutline(true);

        //Разворачиваем игру на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //Вызов диалогового окна в начале игры
        dialog = new Dialog(this);//создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
        dialog.setCancelable(false); //нельзя закрыть кнопкой назат

        //кнопка закрытия
        TextView btnclose = dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //возврат в меню уровней
                    Intent intent = new Intent(level1.this, LevelsActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialog.dismiss();//закрываем диалоговое окно
            }
        });

        //кнопка продолжить
        Button buttoncontinue = dialog.findViewById(R.id.btncontinue);
        buttoncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dialog.dismiss();
                }catch (Exception e){

                }
            }
        });



        dialog.show();//запуск диалога


        //Кнопка назад в уровне
        Button buttonback  = findViewById(R.id.buttonBack);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(level1.this, LevelsActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });



        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("1")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            System.out.println("Успешно!<---------------------------------------------------");
                            QuerySnapshot querySnapshot = task.getResult();
                            if (querySnapshot == null) return;
                            for(QueryDocumentSnapshot documentSnapshot : querySnapshot){
                                Map<String, Object> level = documentSnapshot.getData();
                                button1.setText(level.get("1").toString());
                                button2.setText(level.get("2").toString());
                                button3.setText(level.get("3").toString());
                                String img = (level.get("4").toString());
                                System.out.println(img);
                                Picasso.get().load(level.get("4").toString()).into(img_question);
                            }
                        }else{
                            System.out.println("Провал!<---------------------------------------------------");
                        }
                    }
                });

    }

    //системная кнопка назад, для возврата к уровням
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(level1.this, LevelsActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }
}