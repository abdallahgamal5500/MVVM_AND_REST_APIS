package data;

import java.util.List;

import pojo.Model;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IDB {
    @GET("posts")
    public Call<List<Model>> getPosts();
}
