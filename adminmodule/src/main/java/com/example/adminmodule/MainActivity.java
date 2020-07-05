package com.example.adminmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView service, stuService, immigrants, deviceRepair, itServiceForBusiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = findViewById(R.id.service);
        stuService = findViewById(R.id.studentService);
        immigrants = findViewById(R.id.immigrants);
        deviceRepair = findViewById(R.id.deviceRepair);
        itServiceForBusiness = findViewById(R.id.itSerForBusiness);


        service.setOnClickListener(this);
        stuService.setOnClickListener(this);
        immigrants.setOnClickListener(this);
        deviceRepair.setOnClickListener(this);
        itServiceForBusiness.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.service:
                Intent service = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(service);
                break;


            case R.id.studentService:
                Intent studentService = new Intent(MainActivity.this, StudentService.class);
                startActivity(studentService);
                break;

            case R.id.immigrants:
                Intent immigrants = new Intent(MainActivity.this, Immigrants.class);
                startActivity(immigrants);
                break;


            case R.id.deviceRepair:
                Intent device = new Intent(MainActivity.this, DeviceRepair.class);
                startActivity(device);
                break;

            case R.id.itSerForBusiness:
                Intent business = new Intent(MainActivity.this, BusinessService.class);
                startActivity(business);
                break;






        }

    }
}
