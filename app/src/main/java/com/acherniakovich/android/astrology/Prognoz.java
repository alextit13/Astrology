package com.acherniakovich.android.astrology;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Prognoz extends Activity {

    private Spinner sp_1;
    private ArrayList <Integer> list;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prognoz);

        init();

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        // инициализация
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        // создаем вкладку и указываем тег
        tabSpec = tabHost.newTabSpec("tag1");
        // название вкладки
        tabSpec.setIndicator("Прогноз на день");
        // указываем id компонента из FrameLayout, он и станет содержимым
        tabSpec.setContent(R.id.tvTab1);
        // добавляем в корневой элемент

        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        // указываем название и картинку
        // в нашем случае вместо картинки идет xml-файл,
        // который определяет картинку по состоянию вкладки
        tabSpec.setIndicator("Прогноз на год");
        tabSpec.setContent(R.id.tvTab2);
        tabHost.addTab(tabSpec);

        // первая вкладка будет выбрана по умолчанию
        tabHost.setCurrentTabByTag("tag1");

        TextView tv1 = (TextView)tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        TextView tv2 = (TextView)tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        tv1.setTextColor(Color.parseColor("#FFFFFF"));
        tv2.setTextColor(Color.parseColor("#FFFFFF"));

        // обработчик переключения вкладок
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                //Toast.makeText(getBaseContext(), "tabId = " + tabId, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void init() {
        list = new ArrayList<>();
        sp_1 = (Spinner)findViewById(R.id.sp_1);
        for (int i = 1900;i<=2020;i++){
            list.add(i);
        }
        ArrayAdapter <Integer> arrayAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,list);
        sp_1.setAdapter(arrayAdapter);
    }
}