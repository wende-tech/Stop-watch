package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class SoundSettingsActivity extends AppCompatActivity {

    private MaterialCardView cardTone1, cardTone2, cardTone3;
    private TextView tvCheck1, tvCheck2, tvCheck3;
    private SeekBar seekBarVolume;
    private TextView tvVolumeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_settings);

        ImageButton btnBack = findViewById(R.id.btn_sound_back);
        btnBack.setOnClickListener(v -> finish());

        cardTone1 = findViewById(R.id.card_tone_1);
        cardTone2 = findViewById(R.id.card_tone_2);
        cardTone3 = findViewById(R.id.card_tone_3);

        tvCheck1 = findViewById(R.id.tv_check_1);
        tvCheck2 = findViewById(R.id.tv_check_2);
        tvCheck3 = findViewById(R.id.tv_check_3);

        seekBarVolume = findViewById(R.id.seekBar_volume);
        tvVolumeText = findViewById(R.id.tv_volume_text);

        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvVolumeText.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        cardTone1.setOnClickListener(v -> selectTone(1));
        cardTone2.setOnClickListener(v -> selectTone(2));
        cardTone3.setOnClickListener(v -> selectTone(3));
    }

    private void selectTone(int toneIndex) {
        cardTone1.setStrokeWidth(toneIndex == 1 ? (int)(1.5 * getResources().getDisplayMetrics().density) : 0);
        cardTone1.setCardBackgroundColor(getResources().getColor(toneIndex == 1 ? R.color.surface_container : R.color.surface_container_low, null));
        tvCheck1.setVisibility(toneIndex == 1 ? View.VISIBLE : View.GONE);

        cardTone2.setStrokeWidth(toneIndex == 2 ? (int)(1.5 * getResources().getDisplayMetrics().density) : 0);
        cardTone2.setCardBackgroundColor(getResources().getColor(toneIndex == 2 ? R.color.surface_container : R.color.surface_container_low, null));
        tvCheck2.setVisibility(toneIndex == 2 ? View.VISIBLE : View.GONE);

        cardTone3.setStrokeWidth(toneIndex == 3 ? (int)(1.5 * getResources().getDisplayMetrics().density) : 0);
        cardTone3.setCardBackgroundColor(getResources().getColor(toneIndex == 3 ? R.color.surface_container : R.color.surface_container_low, null));
        tvCheck3.setVisibility(toneIndex == 3 ? View.VISIBLE : View.GONE);

        String toneName = toneIndex == 1 ? "Digital Chime" : (toneIndex == 2 ? "Radar Pulse" : "Zen Singing Bowl");
        Toast.makeText(this, "Selected: " + toneName, Toast.LENGTH_SHORT).show();
    }
}
