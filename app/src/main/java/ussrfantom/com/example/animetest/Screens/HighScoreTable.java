package ussrfantom.com.example.animetest.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ussrfantom.com.example.animetest.R;

public class HighScoreTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_table);
    }
        //Проверка на нажатие кнопки Назад начало
    public void clickButtonBack(View view) {
        Intent intent = new Intent(HighScoreTable.this, MainMenu.class);
        startActivity(intent);
        finish();
    }
    //Проверка на нажатие кнопки Назад конец
}