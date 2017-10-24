package com.acherniakovich.android.astrology;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class AddInformation extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private Button button_year;
    private EditText city;
    private EditText name;
    private Spinner diffTime;
    private Switch sex;
    private Spinner listViewCountry;

    private Button save;
    private Button cancel;

    private int _day;
    private int _month;
    private int _birthYear;

    private String [] countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_information);

        init();
    }

    private void init() {
        button_year = (Button)findViewById(R.id.year);
        name = (EditText)findViewById(R.id.name);
        city = (EditText) findViewById(R.id.city);
        diffTime = (Spinner) findViewById(R.id.diffTime);
        sex = (Switch)findViewById(R.id.sex);
        save = (Button) findViewById(R.id.save);
        cancel = (Button) findViewById(R.id.close);
        listViewCountry = (Spinner) findViewById(R.id.listViewCountry);

        countries = new String [] {"	Азербайджан 	"	,
                "	Армения 	"	,
                "	Афганистан 	"	,
                "	Бангладеш 	"	,
                "	Бахрейн 	"	,
                "	Бруней 	"	,
                "	Бутан 	"	,
                "	Восточный Тимор 	"	,
                "	Вьетнам 	"	,
                "	Грузия 	"	,
                "	Израиль 	"	,
                "	Индия 	"	,
                "	Индонезия 	"	,
                "	Иордания 	"	,
                "	Ирак 	"	,
                "	Иран 	"	,
                "	Йемен 	"	,
                "	Казахстан 	"	,
                "	Узбекистан 	"	,
                "	Камбоджа 	"	,
                "	Катар 	"	,
                "	Кипр 	"	,
                "	Киргизия 	"	,
                "	КНДР 	"	,
                "	Китай 	"	,
                "	Кувейт 	"	,
                "	Лаос 	"	,
                "	Ливан 	"	,
                "	Макао (Аомынь) 	"	,
                "	Малайзия 	"	,
                "	Мальдивы 	"	,
                "	Монголия 	"	,
                "	Мьянма ( Бирма ) 	"	,
                "	Непал 	"	,
                "	ОАЭ 	"	,
                "	Оман 	"	,
                "	Пакистан 	"	,
                "	Палестина 	"	,
                "	Саудовская Аравия 	"	,
                "	Сингапур 	"	,
                "	Сирия 	"	,
                "	Таджикистан 	"	,
                "	Таиланд 	"	,
                "	Туркменистан 	"	,
                "	Турция 	"	,
                "	Филиппины 	"	,
                "	Шри-Ланка 	"	,
                "	Южная Корея 	"	,
                "	Япония 	"	,
                "	Алжир 	"	,
                "	Ангола 	"	,
                "	Бенин 	"	,
                "	Ботсвана 	"	,
                "	Буркина-Фасо 	"	,
                "	Бурунди 	"	,
                "	Габон 	"	,
                "	Гамбия 	"	,
                "	Гана 	"	,
                "	Гвинея 	"	,
                "	Гвинея-Бисау 	"	,
                "	Джибути 	"	,
                "	Египет 	"	,
                "	Замбия 	"	,
                "	Западная Сахара 	"	,
                "	Зимбабве 	"	,
                "	Кабо-Верде 	"	,
                "	Кот-д'Ивуар 	"	,
                "	Камерун 	"	,
                "	Кения 	"	,
                "	Коморские острова 	"	,
                "	Демократическая Республика Конго 	"	,
                "	Народная Республика Конго 	"	,
                "	Лесото 	"	,
                "	Либерия 	"	,
                "	Ливия 	"	,
                "	Маврикий 	"	,
                "	Мавритания 	"	,
                "	Мадагаскар 	"	,
                "	Малави 	"	,
                "	Мали 	"	,
                "	Марокко 	"	,
                "	Мозамбик 	"	,
                "	Намибия 	"	,
                "	Нигер 	"	,
                "	Нигерия 	"	,
                "	Реюньон 	"	,
                "	Руанда 	"	,
                "	Сан-Томе и Принсипи 	"	,
                "	Свазиленд 	"	,
                "	Святой Елены Остров 	"	,
                "	Сейшельские острова 	"	,
                "	Сенегал 	"	,
                "	Сомали 	"	,
                "	Судан 	"	,
                "	Сьерра-Леоне 	"	,
                "	Танзания 	"	,
                "	Того 	"	,
                "	Тунис 	"	,
                "	Уганда 	"	,
                "	ЧАД 	"	,
                "	Центрально-Африканская республика 	"	,
                "	Экваториальная Гвинея 	"	,
                "	Эритрея 	"	,
                "	Эфиопия 	"	,
                "	Южно-Африканская Республика 	"	,
                "	Австрия 	"	,
                "	Андорра 	"	,
                "	Албания 	"	,
                "	Беларусь 	"	,
                "	Бельгия 	"	,
                "	Болгария 	"	,
                "	Босния и Герцеговина 	"	,
                "	Ватикан 	"	,
                "	Великобритания 	"	,
                "	Венгрия 	"	,
                "	Германия 	"	,
                "	Гибралтар 	"	,
                "	Греция 	"	,
                "	Дания 	"	,
                "	Ирландия 	"	,
                "	Исландия 	"	,
                "	Испания 	"	,
                "	Италия 	"	,
                "	Латвия 	"	,
                "	Литва 	"	,
                "	Лихтенштейн 	"	,
                "	Люксембург 	"	,
                "	Македония 	"	,
                "	Мальта 	"	,
                "	Молдавия 	"	,
                "	Монако 	"	,
                "	Нидерланды 	"	,
                "	Норвегия 	"	,
                "	Польша 	"	,
                "	Португалия 	"	,
                "	Россия 	"	,
                "	Румыния 	"	,
                "	Сан-Марино 	"	,
                "	Сербия и Черногория 	"	,
                "	Словакия 	"	,
                "	Словения 	"	,
                "	Украина 	"	,
                "	Фарерские острова 	"	,
                "	Финляндия 	"	,
                "	Франция 	"	,
                "	Хорватия 	"	,
                "	Черногория 	"	,
                "	Чехия 	"	,
                "	Швейцария 	"	,
                "	Швеция 	"	,
                "	Эстония 	"	,
                "	Австралия 	"	,
                "	Вануату 	"	,
                "	Гуам 	"	,
                "	Восточное (Американское) Самоа 	"	,
                "	Западное Самоа 	"	,
                "	Кирибати 	"	,
                "	Кокосовые острова 	"	,
                "	Кука острова 	"	,
                "	Маршаловы острова 	"	,
                "	Мидуэй 	"	,
                "	Микронезия 	"	,
                "	Науру 	"	,
                "	Ниуэ 	"	,
                "	Новая Зеландия 	"	,
                "	Новая Каледония 	"	,
                "	Норфолк 	"	,
                "	Палау 	"	,
                "	Папуа-Новая Гвинея 	"	,
                "	Питкэрн 	"	,
                "	Рождества остров 	"	,
                "	Северные Марианские острова 	"	,
                "	Токелау 	"	,
                "	Тонга 	"	,
                "	Тувалу 	"	,
                "	Уоллис и Футуна 	"	,
                "	Уэйк 	"	,
                "	Фиджи 	"	,
                "	Французская полинезия 	"	,
                "	Страны Северной Америки:	"	,
                "	Гренландия 	"	,
                "	Канада 	"	,
                "	Мексика 	"	,
                "	Сен-Пьер и Микелон 	"	,
                "	США 	"	,
                "	Ангилья (Ангуилла) 	"	,
                "	Антигуа и Барбуда 	"	,
                "	Нидерландские Антиллы 	"	,
                "	Аруба 	"	,
                "	Багамские острова 	"	,
                "	Барбадос 	"	,
                "	Белиз 	"	,
                "	Бермудские острова 	"	,
                "	Британские Виргинские острова 	"	,
                "	Виргинские острова 	"	,
                "	Гаити 	"	,
                "	Гваделупа 	"	,
                "	Гватемала 	"	,
                "	Гондурас 	"	,
                "	Гренада 	"	,
                "	Доминика 	"	,
                "	Доминиканская республика 	"	,
                "	Каймановы острова 	"	,
                "	Коста-Рика 	"	,
                "	Куба 	"	,
                "	Мартиника 	"	,
                "	Монтсеррат 	"	,
                "	Никарагуа 	"	,
                "	Панама 	"	,
                "	Пуэрто-Рико 	"	,
                "	Сальвадор 	"	,
                "	Сент-Винсент и Гренадины 	"	,
                "	Сент-Китс и Невис 	"	,
                "	Сент-Люсия 	"	,
                "	Тёркс и Кайкос 	"	,
                "	Тринидад и Тобаго 	"	,
                "	Ямайка 	"	,
                "	Аргентина 	"	,
                "	Боливия 	"	,
                "	Бразилия 	"	,
                "	Венесуэла 	"	,
                "	Гайана 	"	,
                "	Колумбия 	"	,
                "	Парагвай 	"	,
                "	Перу 	"	,
                "	Суринам 	"	,
                "	Уругвай 	"	,
                "	Фолклендские (Мальвинские) острова 	"	,
                "	Чили 	"	,
                "	Эквадор	"};
        Arrays.sort(countries);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
        listViewCountry.setAdapter(adapter);

        if (!readFromFile(this).equals("")){

        }
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.year:
                //year
                Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

                DatePickerDialog dialog = new DatePickerDialog(AddInformation.this, this,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
                break;
            case R.id.city:
                //year
                break;
            case R.id.diffTime:
                //year
                break;
            case R.id.save:
                //year
                saveData();
                break;
            case R.id.close:
                //year
                break;
        }
    }

    private void saveData() {
        if (!name.getText().toString().equals("")&!button_year.getText().toString().equals("Год рождения")
                &!listViewCountry.getSelectedItem().equals(null)&!city.getText().toString().equals("")
                &!diffTime.getSelectedItem().equals("")){
            String sexText = "";
            if (!sex.isChecked()){
                sexText = "Мужчина";
            }else{
                sexText = "Женщина";
            }
            People people = new People(name.getText().toString(),button_year.getText().toString(),listViewCountry.getSelectedItem().toString()
                    ,city.getText().toString(),diffTime.getSelectedItem().toString(),sexText);
            createText(people);

        }else{
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
        }
    }

    private void createText(People people) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(AddInformation.this.openFileOutput("people.txt", Context.MODE_APPEND));
            outputStreamWriter.write(people.getName());
            outputStreamWriter.write(people.getDateOfBirdth());
            outputStreamWriter.write(people.getCountry());
            outputStreamWriter.write(people.getCity());
            outputStreamWriter.write(people.getDifferentTime());
            outputStreamWriter.write(people.getSex());
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.d(MainActivity.LOG_TAG, "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("people.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
                Log.d(MainActivity.LOG_TAG, "ret: " + ret);
            }
        }
        catch (FileNotFoundException e) {
            Log.d(MainActivity.LOG_TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.d(MainActivity.LOG_TAG, "Can not read file: " + e.toString());
        }

        return ret;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        _birthYear = year;
        _month = month;
        _day = dayOfMonth;

        button_year.setText(new StringBuilder()
                .append(_day).append("/").append(_month + 1).append("/").append(_birthYear).append(" "));
        button_year.animate()
                .rotationXBy(360)
                .start();
    }
}
