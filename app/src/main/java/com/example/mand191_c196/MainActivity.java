package com.example.mand191_c196;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mand191_c196.Controller.DbHelper;
import com.example.mand191_c196.Controller.AssessmentDat;
import com.example.mand191_c196.Controller.TermDat;
import com.example.mand191_c196.Controller.CourseDat;
import com.example.mand191_c196.Model.Assessment;
import com.example.mand191_c196.Model.Course;
import com.example.mand191_c196.Model.Term;
import com.example.mand191_c196.R;
import com.example.mand191_c196.View.AddTermActivity;

public class MainActivity extends AppCompatActivity {
    private Button nav_button_add_term;
    private Button nav_button_add_course;
    private Button nav_button_add_assessment;
    private Button nav_button_view_terms;
    private Button nav_button_view_courses;
    private Button nav_button_view_assessments;
    private Button nav_button_TestData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_button_add_term = (Button) findViewById(R.id.nav_button_add_term);
        nav_button_add_course = (Button) findViewById(R.id.nav_button_add_course);
        nav_button_add_assessment = (Button) findViewById(R.id.nav_button_add_assessment);
        nav_button_view_terms = (Button) findViewById(R.id.nav_button_view_terms);
        nav_button_view_courses = (Button) findViewById(R.id.nav_button_view_courses);
        nav_button_view_assessments = (Button) findViewById(R.id.nav_button_view_assessments);
        nav_button_TestData = (Button) findViewById(R.id.nav_button_TestData);

        nav_button_add_term.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddTermActivity.class);
                //optional
                //i.putExtra("key", value);
                MainActivity.this.startActivity(i);
            }
            });


        nav_button_add_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
