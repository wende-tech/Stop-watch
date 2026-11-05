package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class TimerPresetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_presets);

        ImageButton btnBack = findViewById(R.id.btn_presets_back);
        btnBack.setOnClickListener(v -> finish());

        MaterialCardView cardPomodoro = findViewById(R.id.card_preset_pomodoro);
        MaterialCardView cardBreak = findViewById(R.id.card_preset_break);
        MaterialCardView cardHiit = findViewById(R.id.card_preset_hiit);
        MaterialButton btnNew = findViewById(R.id.btn_new_preset);

        cardPomodoro.setOnClickListener(v -> {
            Toast.makeText(this, "Preset Loaded: Pomodoro Focus (25m)", Toast.LENGTH_SHORT).show();
            finish();
        });

        cardBreak.setOnClickListener(v -> {
            Toast.makeText(this, "Preset Loaded: Short Break (5m)", Toast.LENGTH_SHORT).show();
            finish();
        });

        cardHiit.setOnClickListener(v -> {
            Toast.makeText(this, "Preset Loaded: HIIT Interval (45s)", Toast.LENGTH_SHORT).show();
            finish();
        });

        btnNew.setOnClickListener(v -> {
            Toast.makeText(this, "Create New Preset feature", Toast.LENGTH_SHORT).show();
        });
    }
}
