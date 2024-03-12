package dev.cesarele23.monitorearthquake.earthquakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import dev.cesarele23.monitorearthquake.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.eqRecycler.setLayoutManager(new LinearLayoutManager(this));

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getEqList().observe(this, eqList -> {
            for(Earthquake eq : eqList){
                Log.d("eq", eq.getMagnitude() + " " + eq.getPlace());
            }

            EqAdapter adapter = new EqAdapter();
            binding.eqRecycler.setAdapter(adapter);
            adapter.submitList(eqList);
        });

        viewModel.getEarthquakes();


    }
}