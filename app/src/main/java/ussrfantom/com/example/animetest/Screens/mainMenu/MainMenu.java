package ussrfantom.com.example.animetest.Screens.mainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ussrfantom.com.example.animetest.R;
import ussrfantom.com.example.animetest.Screens.scoreTable.HighScoreTable;

public class MainMenu extends AppCompatActivity {


    private long backPressedTime;
    private String toastTextExit;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        toastTextExit = getString(R.string.click_again_to_exit);

    }

    //Системная кнопка назад начало
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(), toastTextExit, Toast.LENGTH_LONG);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    //Системная кнопка назад конец

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view){
        Intent intent;
        switch (view.getId())
        {
            case R.id.imageViewTable:
                intent = new Intent(MainMenu.this, HighScoreTable.class);
                startActivity(intent);
                finish();
                break;
            case R.id.imageViewChat:
                break;
            case R.id.imageViewInfo:
                break;
            case R.id.imageViewTest:
                break;
        }
    }


}