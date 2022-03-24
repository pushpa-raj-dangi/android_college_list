package com.pushpa.android_college_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CollegeActivity extends AppCompatActivity {
    private Button saveButton;
    EditText website,name,lat,lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);

        website = findViewById(R.id.web);
        name = findViewById(R.id.name);
        lat = findViewById(R.id.lat);
        lang = findViewById(R.id.lng);
        saveButton = findViewById(R.id.saveBtn);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CollegeActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                Log.e("TAG", "onClick: "+website.getText()+"{"+name.getText()+"}"+"{"+lat.getText() +""+lang.getText() );

            }
        });
    }
}