package com.example.valer.lab2t1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> countryList;
    EditText text_editor;
    TextView text_view;
    String maa;
    private ListView myListView;
    private ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        countryList = new ArrayList<>();
        countryList.addAll(Arrays.asList("Afghanistan", "Albania", "Algeria","American Samoa","Andorra",
                "Angola","Anguilla","Antarctica","Antigua and Barbuda","Argentina",
                "Armenia","Aruba","Australia","Austria","Azerbaijan"));


        myListView = findViewById(R.id.country_list_view);
        aa = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                countryList);
        myListView.setAdapter(aa);
        Collections.sort(countryList, String.CASE_INSENSITIVE_ORDER);

        findViewById(R.id.add_button).setOnClickListener(this);
        findViewById(R.id.remove_button).setOnClickListener(this);
        findViewById(R.id.edit_button).setOnClickListener(this);
        text_editor = findViewById(R.id.text_editor);
        text_view = findViewById(R.id.text_editor);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.edit_menu_item){
                Intent editViewintent = new Intent(this, EditActivity.class);
                String nimi = "Seppo Taalasmaa";
                editViewintent.putExtra("user_name",nimi);
                startActivity(editViewintent);
        }
        else if(item.getItemId() == R.id.settings_menu_item){
            String url = "http://www.valerihaataja.com/";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }

                return true;
    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();

        if(viewID == R.id.add_button){
            maa = text_editor.getText().toString();
            countryList.add(maa);

            Collections.sort(countryList, String.CASE_INSENSITIVE_ORDER);
            text_editor.setText("");
            myListView.setAdapter(aa);
        }

        if(viewID == R.id.edit_button){

        }

        if(viewID == R.id.remove_button){
            maa = text_editor.getText().toString();
            countryList.remove(maa);
            text_editor.setText("");
            myListView.setAdapter(aa);

        }
    }
}
