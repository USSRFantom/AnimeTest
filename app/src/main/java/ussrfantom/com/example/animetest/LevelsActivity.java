package ussrfantom.com.example.animetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Level;

public class LevelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        Button button_back = (Button) findViewById(R.id.button_back);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);
        TextView textView7 = findViewById(R.id.textView7);
        TextView textView8 = findViewById(R.id.textView8);
        TextView textView9 = findViewById(R.id.textView9);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelsActivity.this, MainActivity.class);
                startActivity(intent);finish();
            }
        });


        //переход на первый уровень

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(LevelsActivity.this, level1.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //
                }
            }
        });

            //переход на второй уровень
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(LevelsActivity.this, level2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //
                }
            }
        });

        //переход на третий уровень
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(LevelsActivity.this, level3.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //
                }
            }
        });

        //переход на четвертый уровень
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(LevelsActivity.this, level4.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //
                }
            }
        });

        //переход на пятый уровень
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(LevelsActivity.this, level5.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //
                }
            }
        });

        //переход на шестой уровень
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(LevelsActivity.this, level6.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //
                }
            }
        });

        //переход на седьмой уровень
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(LevelsActivity.this, level7.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //
                }
            }
        });

        //переход на восьмой уровень
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(LevelsActivity.this, level8.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //
                }
            }
        });

        //переход на шестой уровень
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(LevelsActivity.this, level9.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //
                }
            }
        });








        // скрываем меню
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }



    //системная кнопка
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(LevelsActivity.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
}