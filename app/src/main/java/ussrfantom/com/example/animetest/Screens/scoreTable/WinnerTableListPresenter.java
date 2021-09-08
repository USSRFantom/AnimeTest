package ussrfantom.com.example.animetest.Screens.scoreTable;

import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ussrfantom.com.example.animetest.api.ApiFactory;
import ussrfantom.com.example.animetest.api.ApiService;
import ussrfantom.com.example.animetest.pojo.WinnerTable;

public class WinnerTableListPresenter {
    private CompositeDisposable compositeDisposable;
    private WinnerTableListView view;

    public WinnerTableListPresenter(WinnerTableListView view) {
        this.view = view;
    }

    public void loadData() {
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        compositeDisposable = new CompositeDisposable();
        Disposable disposable = apiService.getWinners()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WinnerTable>() {
                    @Override
                    public void accept(WinnerTable winnerTable) throws Exception {
                        view.showData(winnerTable.getTable());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.showError();
                    }
                });
        compositeDisposable.add(disposable);
    }
    public void disposeDisposable(){
        if (compositeDisposable != null){
            compositeDisposable.dispose();
        }

    }
}
