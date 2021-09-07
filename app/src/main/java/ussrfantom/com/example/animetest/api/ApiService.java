package ussrfantom.com.example.animetest.api;

import retrofit2.http.GET;
import io.reactivex.Observable;
import ussrfantom.com.example.animetest.pojo.WinnerTable;

public interface ApiService {
    @GET("project_info.json")
    Observable<WinnerTable> getWinners();
}
