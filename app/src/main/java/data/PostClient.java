package data;

import java.util.List;

import pojo.Model;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static PostClient INSTANCE;
    private IDB idb;

    public PostClient () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        idb = retrofit.create(IDB.class);
    }

    public static PostClient getINSTANCE () {
        if (INSTANCE == null) {
            INSTANCE = new PostClient();
        }
        return INSTANCE;
    }

    public Call<List<Model>> getPosts () {
        return idb.getPosts();
    }
}
