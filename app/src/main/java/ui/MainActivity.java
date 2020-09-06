package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm_rest_apis.R;

import java.util.List;

import pojo.Model;
import ui.adapters.Recycler_Adapter;

public class MainActivity extends AppCompatActivity {

    private ViewModel viewModel;
    private RecyclerView recyclerView;
    private Recycler_Adapter adapter = new Recycler_Adapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getPosts();
        viewModel.mutableLiveData.observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
                adapter.setList(models);
            }
        });
    }
}