package ussrfantom.com.example.animetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class LevelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        Button button_back = (Button) findViewById(R.id.button_back);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelsActivity.this, MainActivity.class);
                startActivity(intent);finish();
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