package com.acherniakovich.android.astrology;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Sovmestimost extends AppCompatActivity {

    private Spinner sp_year;
    private Spinner sp_mounth;
    private Spinner sp_day;

    private ArrayList <Integer> list_year;
    private ArrayList <String> list_month;
    private ArrayList <Integer> list_day;

    private ArrayAdapter<Integer> adapter_year;
    private ArrayAdapter adapter_month;
    private ArrayAdapter adapter_day;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sovmestimost);
        init();
    }

    private void init() {
        sp_year = (Spinner)findViewById(R.id.sp_sov_year);
        sp_mounth = (Spinner)findViewById(R.id.sp_sov_mounth);
        sp_day = (Spinner)findViewById(R.id.sp_sov_day);

        list_year = new ArrayList<>();
        list_month = new ArrayList<>();
        list_day = new ArrayList<>();

        for (int i = 1900; i<=2017;i++){
            list_year.add(i);
        }
        list_month.add("Январь");
        list_month.add("Февраль");
        list_month.add("Март");
        list_month.add("Апрель");
        list_month.add("Март");
        list_month.add("Июнь");
        list_month.add("Июль");
        list_month.add("Август");
        list_month.add("Сентябрь");
        list_month.add("Октябрь");
        list_month.add("Ноябрь");
        list_month.add("Декабрь");
        for (int i = 1; i<=31;i++){
            list_day.add(i);
        }
        adapter_year = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list_year);
        adapter_month = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list_month);
        adapter_day = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list_day);

        sp_year.setAdapter(adapter_year);
        sp_mounth.setAdapter(adapter_month);
        sp_day.setAdapter(adapter_day);

        btn = (Button)findViewById(R.id.button_1);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                Intent intent = new Intent(Sovmestimost.this,SovmResult.class);
                startActivity(intent);
        }
    }
}
