package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    Button btTop, btRed, btGreen, btBlue;
    SeekBar sbRed, sbGreen, sbBlue;
    NumberPicker npRed, npGreen, npBlue;
    RadioButton rbRed, rbGreen, rbBlue;
    CheckBox cbRed, cbGreen, cbBlue;
    int r = 0, g = 0, b = 0, npMax = 255, npMin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind button value by id
        btTop = findViewById(R.id.btTop);
        btRed = findViewById(R.id.btRed);
        btGreen = findViewById(R.id.btGreen);
        btBlue = findViewById(R.id.btBlue);

        // bind SeekBar value by id
        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);

        // bind NumberPicker by id and set range
        npRed = findViewById(R.id.npRed);
        npGreen = findViewById(R.id.npGreen);
        npBlue = findViewById(R.id.npBlue);
        setNumberPickerRange(npRed);
        setNumberPickerRange(npGreen);
        setNumberPickerRange(npBlue);

        rbRed = findViewById(R.id.rbRed);
        rbGreen = findViewById(R.id.rbGreen);
        rbBlue = findViewById(R.id.rbBlue);

        cbRed = findViewById(R.id.cbRed);
        cbGreen = findViewById(R.id.cbGreen);
        cbBlue = findViewById(R.id.cbBlue);

        btTop.setBackgroundColor(Color.rgb(r, g, b));   // initial the top button color

        // bind the SeekBar event Listener
        sbRed.setOnSeekBarChangeListener(onSeekBarChange);
        sbGreen.setOnSeekBarChangeListener(onSeekBarChange);
        sbBlue.setOnSeekBarChangeListener(onSeekBarChange);

        // bind the NumberPicker event Listener
        npRed.setOnValueChangedListener(onNumberPickerChange);
        npGreen.setOnValueChangedListener(onNumberPickerChange);
        npBlue.setOnValueChangedListener(onNumberPickerChange);
    }

    // change the top button color into the progress value
    private final SeekBar.OnSeekBarChangeListener onSeekBarChange = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int id = seekBar.getId();

            if (id == R.id.sbRed) {
                r = progress;
                npRed.setValue(progress);
            } else if (id == R.id.sbGreen) {
                g = progress;
                npGreen.setValue(progress);
            } else if (id == R.id.sbBlue) {
                b = progress;
                npBlue.setValue(progress);
            }

            btTop.setBackgroundColor(Color.rgb(r, g, b));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    // when click the button at bottom add 1 to the SeekBar progress
    public void onButtonClick(View v) {
        int id = v.getId();

        if (id == R.id.btRed) {
            setProgressOneColor(255, 0, 0);
            rbRed.setChecked(true);
        } else if (id == R.id.btGreen) {
            setProgressOneColor(0, 255, 0);
            rbGreen.setChecked(true);
        } else if (id == R.id.btBlue) {
            setProgressOneColor(0, 0, 255);
            rbBlue.setChecked(true);
        }
    }

    private final NumberPicker.OnValueChangeListener onNumberPickerChange = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            int id = picker.getId();

            if (id == R.id.npRed) {
                sbRed.setProgress(newVal);
            } else if (id == R.id.npGreen) {
                sbGreen.setProgress(newVal);
            } else if (id == R.id.npBlue) {
                sbBlue.setProgress(newVal);
            }
        }
    };

    public final void onRadioButtonClick(View v) {
        int id = v.getId();

        if (id == R.id.rbRed) {
            setProgressOneColor(255, 0, 0);
        } else if (id == R.id.rbGreen) {
            setProgressOneColor(0, 255, 0);
        } else if (id == R.id.rbBlue) {
            setProgressOneColor(0, 0, 255);
        }
    };

    private void setNumberPickerRange(NumberPicker picker) {
        picker.setMaxValue(npMax);
        picker.setMinValue(npMin);
    }

    private void setProgressOneColor(int r, int g, int b) {
        sbRed.setProgress(r);
        sbGreen.setProgress(g);
        sbBlue.setProgress(b);
    }

    public void onCheckBoxClick(View v) {
        r = cbRed.isChecked() ? 255 : 0;
        g = cbGreen.isChecked() ? 255 : 0;
        b = cbBlue.isChecked() ? 255 : 0;

        setProgressOneColor(r, g, b);
    }
}