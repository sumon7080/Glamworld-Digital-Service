package com.example.glamworlddigitalservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.glamworlddigitalservice.feedback.Feedback;
import com.example.glamworlddigitalservice.serviceList.Immigrants;
import com.example.glamworlddigitalservice.serviceList.ServiceList;
import com.example.glamworlddigitalservice.serviceList.StudentService;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView serviceList, profile, aboutUs, feedback, studentService, logOut;
    TextView contact, probasi, software, itBusiness;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceList = findViewById(R.id.serviceName);
        studentService = findViewById(R.id.studentService);
        profile = findViewById(R.id.profile);
        aboutUs = findViewById(R.id.about);
        feedback = findViewById(R.id.feedBack);
        logOut = findViewById(R.id.logOut);

        contact = findViewById(R.id.contactUs);
        probasi = findViewById(R.id.immigrants);
        software = findViewById(R.id.softWare);
        itBusiness = findViewById(R.id.itServiceBusiness);

        serviceList.setOnClickListener(this);
        studentService.setOnClickListener(this);
        profile.setOnClickListener(this);
        aboutUs.setOnClickListener(this);
        feedback.setOnClickListener(this);
        logOut.setOnClickListener(this);

        itBusiness.setOnClickListener(this);
        contact.setOnClickListener(this);
        probasi.setOnClickListener(this);
        software.setOnClickListener(this);




        


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.serviceName:
                Intent service = new Intent(MainActivity.this, ServiceList.class);
                startActivity(service);
                break;

            case R.id.studentService:
                Intent student = new Intent(MainActivity.this, StudentService.class);
                startActivity(student);
                break;

            case R.id.immigrants:
                Intent immigrants = new Intent(MainActivity.this, Immigrants.class);
                startActivity(immigrants);
                break;



            case R.id.softWare:
                Intent soft = new Intent(MainActivity.this, Software.class);
                startActivity(soft);
                break;

            case R.id.itServiceBusiness:
                Intent video = new Intent(MainActivity.this, ItServiceBusiness.class);
                startActivity(video);
                break;


            case R.id.profile:
                Intent profile = new Intent(MainActivity.this, Profile.class);
                startActivity(profile);
                break;

            case R.id.feedBack:
                Intent feedback = new Intent(MainActivity.this, Feedback.class);
                startActivity(feedback);
                break;

            case R.id.contactUs:
                Intent contact = new Intent(MainActivity.this, Contact.class);
                startActivity(contact);
                break;

            case R.id.about:
                Intent about = new Intent(MainActivity.this, AboutUs.class);
                startActivity(about);
                break;




            case R.id.logOut:


                FirebaseAuth.getInstance().signOut();
                Intent logout = new Intent(MainActivity.this, Login.class);
                startActivity(logout);
                break;




        }

    }
}