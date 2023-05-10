package ru.mirea.koldinma.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.koldinma.lesson6.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPref = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        String group = sharedPref.getString("GROUP", "");
        String number = sharedPref.getString("NUMBER", "");
        String film = sharedPref.getString("FILM", "");
        binding.editGroup.setText(group);
        binding.editNumber.setText(number);
        binding.editFilm.setText(film);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("GROUP", binding.editGroup.getText().toString());
                editor.putString("NUMBER", binding.editNumber.getText().toString());
                editor.putString("FILM", binding.editFilm.getText().toString());
                editor.apply();
            }
        });





    }
}