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