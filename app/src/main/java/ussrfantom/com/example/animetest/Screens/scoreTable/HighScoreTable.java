package ussrfantom.com.example.animetest.Screens.scoreTable;

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
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ussrfantom.com.example.animetest.R;
import ussrfantom.com.example.animetest.Screens.mainMenu.MainMenu;
import ussrfantom.com.example.animetest.adapters.WinnerAdapter;
import ussrfantom.com.example.animetest.api.ApiFactory;
import ussrfantom.com.example.animetest.api.ApiService;
import ussrfantom.com.example.animetest.pojo.Table;
import ussrfantom.com.example.animetest.pojo.WinnerTable;

public class HighScoreTable extends AppCompatActivity implements WinnerTableListView {


    private RecyclerView recyclerViewTable;
    private WinnerAdapter adapter;
    private WinnerTableListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new WinnerTableListPresenter(this);
        setContentView(R.layout.activity_high_score_table);
        recyclerViewTable = findViewById(R.id.recyclerViewTable);
        adapter = new WinnerAdapter();
        adapter.setTables(new ArrayList<Table>());
        recyclerViewTable.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTable.setAdapter(adapter);
        presenter.loadData(); //загрузка данных

    }

    //Проверка на нажатие кнопки Назад начало
    public void clickButtonBack(View view) {
        Intent intent = new Intent(HighScoreTable.this, MainMenu.class);
        startActivity(intent);
        finish();
    }
    //Проверка на нажатие кнопки Назад конец

    //получение данных начало
    @Override
    public void showData(List<Table> tables) {
        adapter.setTables(tables);
    }
    //получение данных конец

    //ошибка получения данных начало
    @Override
    public void showError() {
        Toast.makeText(this,
                R.string.error_internet,
                Toast.LENGTH_SHORT).show();
    }
    //ошибка получения данных конец

    @Override
    protected void onDestroy() {
        presenter.disposeDisposable();
        super.onDestroy();
    }
}

