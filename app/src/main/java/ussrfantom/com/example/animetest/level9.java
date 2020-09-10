package ussrfantom.com.example.animetest;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.Map;

public class level9 extends AppCompatActivity {
    Dialog dialog;
    Dialog dialogEnd;
    public int count; //счетчик
    public int countDatabase = 160;  //<-----------------------------------------------
    public
    Button button1;
    Button button2;
    Button button3;
    ImageView img_question;
    String truAnswer;
    final int [] progress = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9,
            R.id.point10, R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level_9);  //<-----------------------------------------------


       img_question = findViewById(R.id.imageView_question);
        button1 = findViewById(R.id.button_question1);
        button2 = findViewById(R.id.button_question2);
        button3 = findViewById(R.id.button_question3);
    //код скругляющий углы у картинки
        img_question.setClipToOutline(true);

        //Разворачиваем игру на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //Вызов диалогового окна в начале игры
        dialog = new Dialog(this);//создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog.setContentView(R.layout.previewdialog91);//<---------------------------------------------
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
        dialog.setCancelable(false); //нельзя закрыть кнопкой назат

        //Вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this);//создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend9);//<---------------------------------------------
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT); //на весь экран
        dialogEnd.setCancelable(false); //нельзя закрыть кнопкой назат

        //кнопка закрытия
        TextView btnclose = dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //возврат в меню уровней
                    Intent intent = new Intent(level9.this, LevelsActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialog.dismiss();//закрываем диалоговое окно
            }
        });

        //кнопка продолжить стартовая
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

        //кнопка продолжить конечная
        Button buttoncontinue2 = dialogEnd.findViewById(R.id.btncontinue2);
        buttoncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intet = new Intent(level9.this, FinishActivity.class);
                    startActivity(intet);
                    finish();
                }catch (Exception e){

                }
                dialogEnd.dismiss();
            }
        });


        dialog.show();//запуск диалога


        //Кнопка назад в уровне
        Button buttonback  = findViewById(R.id.buttonBack);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(level9.this, LevelsActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button1.getText().toString().equals(truAnswer)){
                    if (count < 19){
                        count++;
                        countDatabase++;
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                        Toast.makeText(getApplicationContext(), "Верно", Toast.LENGTH_SHORT).show();
                        String over = Integer.toString(countDatabase);
                        getData(over);
                    }else{
                        dialogEnd.show();
                    }
                }else{
                    if (count < 19){
                        count++;
                        countDatabase++;
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_points_red);
                        Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                        String over = Integer.toString(countDatabase);
                        getData(over);
                    }else{
                        dialogEnd.show();
                    }
                }
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button2.getText().toString().equals(truAnswer)){
                    if (count < 19){
                        count++;
                        countDatabase++;
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                        Toast.makeText(getApplicationContext(), "Верно", Toast.LENGTH_SHORT).show();
                        String over = Integer.toString(countDatabase);
                        getData(over);
                    }else{
                        dialogEnd.show();
                    }
                }else{
                    if (count < 19){
                        count++;
                        countDatabase++;
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_points_red);
                        Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                        String over = Integer.toString(countDatabase);
                        getData(over);
                    }else{
                        dialogEnd.show();
                    }
                }
            }
        });



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button3.getText().toString().equals(truAnswer)){
                    if (count < 19){
                        count++;
                        countDatabase++;
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                        Toast.makeText(getApplicationContext(), "Верно", Toast.LENGTH_SHORT).show();
                        String over = Integer.toString(countDatabase);
                        getData(over);
                    }else{
                        dialogEnd.show();
                    }
                }else{
                    if (count < 19){
                        count++;
                        countDatabase++;
                        TextView tv = findViewById(progress[count]);
                        tv.setBackgroundResource(R.drawable.style_points_red);
                        Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                        String over = Integer.toString(countDatabase);
                        getData(over);
                    }else{
                        dialogEnd.show();
                    }
                }
            }
        });





        getData("160");//<-----------------------------------------------
    }

    //системная кнопка назад, для возврата к уровням
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(level9.this, LevelsActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }


    //получение данных
    public void getData(String numberDocument){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(numberDocument)
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
                                truAnswer = level.get("5").toString();
                                System.out.println(img);
                                Picasso.get().load(level.get("4").toString()).into(img_question);
                            }
                        }else{
                            System.out.println("Провал!<---------------------------------------------------");
                        }
                    }
                });

    }
}