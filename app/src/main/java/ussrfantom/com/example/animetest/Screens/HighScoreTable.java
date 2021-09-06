package ussrfantom.com.example.animetest.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ussrfantom.com.example.animetest.R;
import ussrfantom.com.example.animetest.adapters.WinnerAdapter;
import ussrfantom.com.example.animetest.pojo.Table;

public class HighScoreTable extends AppCompatActivity {


    private RecyclerView recyclerViewTable;
    private WinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_table);
        recyclerViewTable = findViewById(R.id.recyclerViewTable);
        adapter = new WinnerAdapter();
        recyclerViewTable.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTable.setAdapter(adapter);

        List<Table> tables = new ArrayList<>();
        Table table1 = new Table();
        Table table2 = new Table();
        table1.setName("Гриша");
        table1.setLevel("1");
        table1.setDescription("Бывает и такое");
        table2.setName("Акакий");
        table2.setLevel("2");
        table2.setDescription("ацацуацуацуацуацуацуацуацу");
        tables.add(table1);
        tables.add(table2);
        adapter.setTables(tables);


    }
        //Проверка на нажатие кнопки Назад начало
    public void clickButtonBack(View view) {
        Intent intent = new Intent(HighScoreTable.this, MainMenu.class);
        startActivity(intent);
        finish();
    }
    //Проверка на нажатие кнопки Назад конец
}