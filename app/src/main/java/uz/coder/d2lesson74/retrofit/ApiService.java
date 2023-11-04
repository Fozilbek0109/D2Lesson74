package uz.coder.d2lesson74.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import uz.coder.d2lesson74.model.MarvelData;

public interface ApiService {
    @GET("/demos/marvel")
    public Call<List<MarvelData>> getMarvel();
}
