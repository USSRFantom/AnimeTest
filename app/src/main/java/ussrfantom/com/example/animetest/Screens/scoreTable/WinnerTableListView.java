package ussrfantom.com.example.animetest.Screens.scoreTable;

import java.util.List;

import ussrfantom.com.example.animetest.pojo.Table;

public interface WinnerTableListView {
    void showData(List<Table> tables);
    void showError();
}
