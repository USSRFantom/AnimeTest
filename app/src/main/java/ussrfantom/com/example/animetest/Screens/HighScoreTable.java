package ussrfantom.com.example.animetest.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ussrfantom.com.example.animetest.R;
import ussrfantom.com.example.animetest.adapters.WinnerAdapter;
import ussrfantom.com.example.animetest.api.ApiFactory;
import ussrfantom.com.example.animetest.api.ApiService;
import ussrfantom.com.example.animetest.pojo.Table;
import ussrfantom.com.example.animetest.pojo.WinnerTable;

public class HighScoreTable extends AppCompatActivity {


    private RecyclerView recyclerViewTable;
    private WinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_table);
        recyclerViewTable = findViewById(R.id.recyclerViewTable);
        adapter = new WinnerAdapter();
        adapter.setTables(new ArrayList<Table>());
        recyclerViewTable.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTable.setAdapter(adapter);
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        apiService.getWinners()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WinnerTable>() {
                    @Override
                    public void accept(WinnerTable winnerTable) throws Exception {
                        adapter.setTables(winnerTable.getTable());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(HighScoreTable.this, "Ошибка получения данных", Toast.LENGTH_SHORT).show();
                    }
                });




    }
        //Проверка на нажатие кнопки Назад начало
    public void clickButtonBack(View view) {
        Intent intent = new Intent(HighScoreTable.this, MainMenu.class);
        startActivity(intent);
        finish();
    }
    //Проверка на нажатие кнопки Назад конец
}