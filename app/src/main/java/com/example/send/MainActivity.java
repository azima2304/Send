package com.example.send;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private MaterialButton send1, send2;
    private ImageButton tgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        send1 = findViewById(R.id.send_button);
        send2 = findViewById(R.id.send_button2);
        tgButton = findViewById(R.id.tg_button);

        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setVisibility(View.VISIBLE);
                send2.setVisibility(View.VISIBLE);
                tgButton.setVisibility(View.VISIBLE);
                send1.setVisibility(View.INVISIBLE);
            }
        });

        send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My message");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());

                    if (emailIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(emailIntent);}
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Can't process !!! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}