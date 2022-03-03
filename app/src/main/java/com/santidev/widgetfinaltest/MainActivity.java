package com.santidev.widgetfinaltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //primer grupo
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final TextClock textClock = (TextClock) findViewById(R.id.textClock);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);

        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                RadioButton rb = (RadioButton) radioGroup.findViewById(checkedID);

                switch (rb.getId()){
                    case R.id.radioButtonLondon:
                            textClock.setTimeZone("Europe/London");
                        break;
                    case R.id.radioButtonNewYork:
                            textClock.setTimeZone("America/New_York");
                        break;
                    case R.id.radioButtonTokio:
                            textClock.setTimeZone("Asia/Tokyo");
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setText(editText.getText().toString());
            }
        });

        //segundo grupo
        final CheckBox cbTransparency = (CheckBox) findViewById(R.id.checkboxTransparency);
        final CheckBox cbTint = (CheckBox) findViewById(R.id.checkboxTint);
        final CheckBox cbResize = (CheckBox) findViewById(R.id.checkboxResize);
        final ImageView imageView = (ImageView) findViewById(R.id.imageview);

        cbTransparency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    imageView.setAlpha(0.2f);
                }else {
                    imageView.setAlpha(1.0f);
                }
            }
        });

        cbTint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    imageView.setColorFilter(Color.argb(150, 255, 0, 0));
                }else{
                    imageView.setColorFilter(Color.argb(0,0,0,0));
                }
            }
        });

        cbResize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                }else {
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }
            }
        });

        //tercer grupo
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.switch1);
        final WebView webView = (WebView) findViewById(R.id.webView);

        webView.loadUrl("http://facebook.com");
        webView.setVisibility(View.INVISIBLE);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    webView.setVisibility(View.VISIBLE);
                }else{
                    webView.setVisibility(View.INVISIBLE);
                }
            }
        });



    }
}