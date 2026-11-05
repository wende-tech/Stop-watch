package com.example.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Locale;

public class ActiveSessionActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextView tvCountdown;
    private Button btnPause;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 0;
    private boolean isRunning = false;
    private TextToSpeech textToSpeech;
    private boolean isTtsReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_session);

        textToSpeech = new TextToSpeech(this, this);

        int hours = getIntent().getIntExtra("EXTRA_HOURS", 0);
        int minutes = getIntent().getIntExtra("EXTRA_MINUTES", 25);
        int seconds = getIntent().getIntExtra("EXTRA_SECONDS", 0);

        timeLeftInMillis = ((hours * 3600L) + (minutes * 60L) + seconds) * 1000L;
        if (timeLeftInMillis <= 0) {
            timeLeftInMillis = 25 * 60 * 1000L; // default 25 min
        }

        tvCountdown = findViewById(R.id.tv_countdown_timer);
        btnPause = findViewById(R.id.btn_session_pause);

        updateTimerText();
        startTimer();

        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            if (countDownTimer != null) countDownTimer.cancel();
            finish();
        });

        btnPause.setOnClickListener(v -> {
            if (isRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
        });

        Button btnReset = findViewById(R.id.btn_session_reset);
        btnReset.setOnClickListener(v -> {
            if (countDownTimer != null) countDownTimer.cancel();
            timeLeftInMillis = ((hours * 3600L) + (minutes * 60L) + seconds) * 1000L;
            if (timeLeftInMillis <= 0) timeLeftInMillis = 25 * 60 * 1000L;
            updateTimerText();
            startTimer();
        });

        Button btnAdd1m = findViewById(R.id.btn_session_add1m);
        btnAdd1m.setOnClickListener(v -> {
            timeLeftInMillis += 60000L;
            updateTimerText();
        });

        Button btnStop = findViewById(R.id.btn_session_stop);
        btnStop.setOnClickListener(v -> {
            if (countDownTimer != null) countDownTimer.cancel();
            finish();
        });
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED) {
                isTtsReady = true;
            }
        }
    }

    private void startTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateTimerText();
                isRunning = false;
                btnPause.setText("DONE");

                if (isTtsReady) {
                    textToSpeech.speak("Time is up! Your session has successfully completed.", TextToSpeech.QUEUE_FLUSH, null, null);
                }

                new MaterialAlertDialogBuilder(ActiveSessionActivity.this)
                        .setTitle("⏰ Time's Up!")
                        .setMessage("Your countdown session has successfully completed. Great job!")
                        .setPositiveButton("OK", (dialog, which) -> finish())
                        .setCancelable(false)
                        .show();
            }
        }.start();

        isRunning = true;
        btnPause.setText("PAUSE");
    }

    private void pauseTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        isRunning = false;
        btnPause.setText("RESUME");
    }

    private void updateTimerText() {
        int totalSeconds = (int) (timeLeftInMillis / 1000);
        int h = totalSeconds / 3600;
        int m = (totalSeconds % 3600) / 60;
        int s = totalSeconds % 60;

        if (h > 0) {
            tvCountdown.setText(String.format(Locale.getDefault(), "%02d:%02d:%02d", h, m, s));
        } else {
            tvCountdown.setText(String.format(Locale.getDefault(), "%02d:%02d", m, s));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
