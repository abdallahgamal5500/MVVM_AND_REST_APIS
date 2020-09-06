package ui;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import data.PostClient;
import pojo.Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel extends androidx.lifecycle.ViewModel {

    public MutableLiveData<List<Model>> mutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> error = new MutableLiveData<>();

    public void getPosts () {
        PostClient.getINSTANCE().getPosts().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                error.setValue("Error");
            }
        });
    }
}
