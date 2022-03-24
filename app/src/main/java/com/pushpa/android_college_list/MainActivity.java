package com.pushpa.android_college_list;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pushpa.android_college_list.db.DbHelper;
import com.pushpa.android_college_list.model.College;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DbHelper dbHelper;
    FloatingActionButton button;
    List<College> collegeList;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.fab);
        dbHelper = new DbHelper(MainActivity.this);
        rv =findViewById(R.id.rv);

        // Attach the adapter to the recyclerview to populate items
        collegeList = dbHelper.retrieveData();
        rv.setAdapter(new CollegeAdapter(this,collegeList));
        // Set layout manager to position the items

        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            createAddDialog();
            }
        });




    }

    private void createAddDialog(){
        AlertDialog.Builder alertLayout = new AlertDialog.Builder(MainActivity.this);
        View view=getLayoutInflater().inflate(R.layout.activity_college,null);
        alertLayout.setView(view);




        EditText name = view.findViewById(R.id.name);
        EditText website = view.findViewById(R.id.web);
        EditText lat = view.findViewById(R.id.lat);
        EditText lng = view.findViewById(R.id.lng);
        Button btnsave = view.findViewById(R.id.saveBtn);

        AlertDialog alert = alertLayout.create();
        alert.show();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                College college = new College();
                college.setName(name.getText().toString());
                college.setWebsite(website.getText().toString());
                college.setLang(Double.parseDouble(lng.getText().toString()));
                college.setLat(Double.parseDouble(lat.getText().toString()));

                dbHelper.insertDataToDb(college);
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                alert.dismiss();

            }
        });


    }
    
    
}