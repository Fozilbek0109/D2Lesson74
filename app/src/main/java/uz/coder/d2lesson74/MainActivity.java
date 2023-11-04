package uz.coder.d2lesson74;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uz.coder.d2lesson74.adapter.MarvelAdapter;
import uz.coder.d2lesson74.databinding.ActivityMainBinding;
import uz.coder.d2lesson74.model.MarvelData;
import uz.coder.d2lesson74.retrofit.ApiClient;
import uz.coder.d2lesson74.retrofit.ApiService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private MarvelAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
        apiService.getMarvel().enqueue(new Callback<List<MarvelData>>() {
            @Override
            public void onResponse(Call<List<MarvelData>> call, Response<List<MarvelData>> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "onResponse: "   + response.body().toString());
                    adapter = new MarvelAdapter(response.body());
                    binding.rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    binding.rec.setAdapter(adapter);
                    ;


                }
            }

            @Override
            public void onFailure(Call<List<MarvelData>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}