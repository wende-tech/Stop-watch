package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int hours = 0;
    private int minutes = 25;
    private int seconds = 0;

    private TextView tvHours, tvMinutes, tvSeconds, tvFinishTime;
    private MaterialButton chip1m, chip5m, chip10m, chip25m, chip45m, chip60m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvHours = findViewById(R.id.tv_hours);
        tvMinutes = findViewById(R.id.tv_minutes);
        tvSeconds = findViewById(R.id.tv_seconds);
        tvFinishTime = findViewById(R.id.tv_finish_time);

        chip1m = findViewById(R.id.chip_1m);
        chip5m = findViewById(R.id.chip_5m);
        chip10m = findViewById(R.id.chip_10m);
        chip25m = findViewById(R.id.chip_25m);
        chip45m = findViewById(R.id.chip_45m);
        chip60m = findViewById(R.id.chip_60m);

        updateDisplay();
        highlightPreset(25);

        ImageButton btnSoundNav = findViewById(R.id.btn_sound_nav);
        btnSoundNav.setOnClickListener(v -> startActivity(new Intent(this, SoundSettingsActivity.class)));

        ImageButton btnPresetsNav = findViewById(R.id.btn_presets_nav);
        btnPresetsNav.setOnClickListener(v -> startActivity(new Intent(this, TimerPresetsActivity.class)));

        MaterialCardView cardKeypad = findViewById(R.id.card_keypad);
        cardKeypad.setOnClickListener(v -> showCustomTimeDialog());

        View frameTimerDisplay = findViewById(R.id.frame_timer_display);
        frameTimerDisplay.setOnClickListener(v -> showCustomTimeDialog());

        MaterialCardView cardSound = findViewById(R.id.card_sound);
        cardSound.setOnClickListener(v -> startActivity(new Intent(this, SoundSettingsActivity.class)));

        MaterialCardView cardPresets = findViewById(R.id.card_presets);
        cardPresets.setOnClickListener(v -> startActivity(new Intent(this, TimerPresetsActivity.class)));

        chip1m.setOnClickListener(v -> setTime(0, 1, 0, chip1m));
        chip5m.setOnClickListener(v -> setTime(0, 5, 0, chip5m));
        chip10m.setOnClickListener(v -> setTime(0, 10, 0, chip10m));
        chip25m.setOnClickListener(v -> setTime(0, 25, 0, chip25m));
        chip45m.setOnClickListener(v -> setTime(0, 45, 0, chip45m));
        chip60m.setOnClickListener(v -> setTime(1, 0, 0, chip60m));

        Button btnAdd1m = findViewById(R.id.btn_add_1m);
        btnAdd1m.setOnClickListener(v -> {
            minutes += 1;
            normalizeTime();
            updateDisplay();
            clearPresetHighlight();
        });

        Button btnAdd5m = findViewById(R.id.btn_add_5m);
        btnAdd5m.setOnClickListener(v -> {
            minutes += 5;
            normalizeTime();
            updateDisplay();
            clearPresetHighlight();
        });

        Button btnReset = findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(v -> {
            hours = 0;
            minutes = 25;
            seconds = 0;
            updateDisplay();
            highlightPreset(25);
        });

        MaterialButton btnStartTimer = findViewById(R.id.btn_start_timer);
        btnStartTimer.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActiveSessionActivity.class);
            intent.putExtra("EXTRA_HOURS", hours);
            intent.putExtra("EXTRA_MINUTES", minutes);
            intent.putExtra("EXTRA_SECONDS", seconds);
            startActivity(intent);
        });
    }

    private void showCustomTimeDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_custom_time, null);
        TextInputEditText etHours = dialogView.findViewById(R.id.et_dialog_hours);
        TextInputEditText etMinutes = dialogView.findViewById(R.id.et_dialog_minutes);
        TextInputEditText etSeconds = dialogView.findViewById(R.id.et_dialog_seconds);

        if (etHours != null) etHours.setText(String.valueOf(hours));
        if (etMinutes != null) etMinutes.setText(String.valueOf(minutes));
        if (etSeconds != null) etSeconds.setText(String.valueOf(seconds));

        new MaterialAlertDialogBuilder(this)
                .setTitle("Set Custom Time")
                .setView(dialogView)
                .setPositiveButton("Set", (dialog, which) -> {
                    try {
                        String hStr = (etHours != null && etHours.getText() != null) ? etHours.getText().toString() : "0";
                        String mStr = (etMinutes != null && etMinutes.getText() != null) ? etMinutes.getText().toString() : "0";
                        String sStr = (etSeconds != null && etSeconds.getText() != null) ? etSeconds.getText().toString() : "0";

                        hours = hStr.isEmpty() ? 0 : Integer.parseInt(hStr);
                        minutes = mStr.isEmpty() ? 0 : Integer.parseInt(mStr);
                        seconds = sStr.isEmpty() ? 0 : Integer.parseInt(sStr);

                        normalizeTime();
                        updateDisplay();
                        clearPresetHighlight();
                    } catch (NumberFormatException e) {
                        // ignore invalid input
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void setTime(int h, int m, int s, MaterialButton selectedChip) {
        hours = h;
        minutes = m;
        seconds = s;
        updateDisplay();
        clearPresetHighlight();
        selectedChip.setBackgroundColor(getResources().getColor(R.color.primary_container, null));
        selectedChip.setTextColor(getResources().getColor(R.color.on_primary_container, null));
    }

    private void clearPresetHighlight() {
        MaterialButton[] chips = {chip1m, chip5m, chip10m, chip25m, chip45m, chip60m};
        for (MaterialButton chip : chips) {
            chip.setBackgroundColor(getResources().getColor(R.color.surface_container_low, null));
            chip.setTextColor(getResources().getColor(R.color.on_surface_variant, null));
        }
    }

    private void highlightPreset(int targetMin) {
        clearPresetHighlight();
        if (targetMin == 1) highlightChip(chip1m);
        else if (targetMin == 5) highlightChip(chip5m);
        else if (targetMin == 10) highlightChip(chip10m);
        else if (targetMin == 25) highlightChip(chip25m);
        else if (targetMin == 45) highlightChip(chip45m);
        else if (targetMin == 60) highlightChip(chip60m);
    }

    private void highlightChip(MaterialButton chip) {
        chip.setBackgroundColor(getResources().getColor(R.color.primary_container, null));
        chip.setTextColor(getResources().getColor(R.color.on_primary_container, null));
    }

    private void normalizeTime() {
        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds %= 60;
        }
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes %= 60;
        }
    }

    private void updateDisplay() {
        tvHours.setText(String.format(Locale.getDefault(), "%02d", hours));
        tvMinutes.setText(String.format(Locale.getDefault(), "%02d", minutes));
        tvSeconds.setText(String.format(Locale.getDefault(), "%02d", seconds));
    }
}
