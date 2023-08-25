package com.overthinkers.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner_age,spinner_gender;
    //private TextView txt_age,txt_gender;
    //private ArrayAdapter<CharSequence> adapter_gender;
    private ArrayAdapter<String> adapterage;
    private ArrayList<String> age_list;
    private ArrayList<String> list_view_array;
    private ListView listView;
    private ArrayAdapter<String> list_view_adapter;
    private String a;

    private void init()
    {
        age_list = new ArrayList<>();
        age_list.add("Fenerbahçe");
        age_list.add("Galatasaray");
        age_list.add("Beşiktaş");
        age_list.add("Trabzonspor");
        age_list.add("Bucaspor");
        age_list.add("Aydınspor");
        age_list.add("Antalyaspor");
        age_list.add("Başakşehir");

        spinner_age = findViewById(R.id.main_activity_spinner_age);
        //spinner_gender = findViewById(R.id.main_activity_spinner_gender);
        //txt_age = findViewById(R.id.main_activity_txt_age);
        /*txt_gender = findViewById(R.id.main_activity_txt_gender);

        adapter_gender = ArrayAdapter.createFromResource(this,R.array.GenderList, android.R.layout.simple_spinner_item);
        adapter_gender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter_gender);

        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txt_gender.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                txt_gender.setText(parent.getItemAtPosition(0).toString());

            }
        });
         */

        adapterage = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, age_list);
        adapterage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapterage);

        list_view_array = new ArrayList<String>();
        listView = findViewById(R.id.list_view_main);


        /*spinner_age.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),age_list.get(i)+" seçildi.",Toast.LENGTH_SHORT).show();
                list_view_array.add(age_list.get(i));
                list_view_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,list_view_array);
                listView.setAdapter(list_view_adapter);

            }
        });*/

        /*spinner_age.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long i) {
                a = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),a+" seçildi.",Toast.LENGTH_SHORT).show();
                list_view_array.add(a);
                list_view_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,list_view_array);
                listView.setAdapter(list_view_adapter);

            }
        });*/

        spinner_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long i) {
                a = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),a+" seçildi.",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //txt_age.setText(parent.getItemAtPosition(0).toString());


            }
        });

        /*spinner_age.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext()," item tıklandı",Toast.LENGTH_SHORT).show();
            }
        });*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), list_view_array.get(i)+" Tıklandı",Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), list_view_array.get(i)+" Silindi",Toast.LENGTH_SHORT).show();
                list_view_array.remove(i);
                list_view_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,list_view_array);
                listView.setAdapter(list_view_adapter);
                return false;
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void ekle(View view)
    {
        list_view_array.add(a);
        list_view_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,list_view_array);
        listView.setAdapter(list_view_adapter);
        Toast.makeText(this,a + " Eklendi",Toast.LENGTH_SHORT).show();
    }
}