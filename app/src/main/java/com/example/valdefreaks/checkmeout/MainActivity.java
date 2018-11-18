package com.example.valdefreaks.checkmeout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar myActionBar = findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        listView = findViewById(R.id.listViewRubricas);

        fillListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, RubricDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                Intent intentProfile = new Intent(this, RegistrationActivity.class);
                startActivity(intentProfile);
                return true;
            case R.id.action_add:
                Intent intentAdd = new Intent(this,AddRubricActivity.class);
                startActivity(intentAdd);
                return true;
            case R.id.action_log_out:
                Toast.makeText(this, "Has cerrado sesión", Toast.LENGTH_LONG).show();
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void fillListView() {
        ArrayList<RubricClass> rubricClass = new ArrayList<>();
        RubricClass objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 1. Conocimiento de las vocales y silabas");
        objRubric.setDescription("El alumno identifica las vocales y su sonido");
        objRubric.setDate("05/05/2018");
        objRubric.setId_rubric(1);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 2");
        objRubric.setDescription("Descripción 2");
        objRubric.setDate("05/06/2018");
        objRubric.setId_rubric(2);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 3");
        objRubric.setDescription("Descripción 3");
        objRubric.setDate("05/07/2018");
        objRubric.setId_rubric(3);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 4");
        objRubric.setDescription("Descripción 4");
        objRubric.setDate("05/07/2018");
        objRubric.setId_rubric(4);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 5");
        objRubric.setDescription("Descripción 5");
        objRubric.setDate("05/07/2018");
        objRubric.setId_rubric(5);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 6");
        objRubric.setDescription("Descripción 6");
        objRubric.setDate("05/07/2018");
        objRubric.setId_rubric(6);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 7");
        objRubric.setDescription("Descripción 7");
        objRubric.setDate("05/07/2018");
        objRubric.setId_rubric(7);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 8");
        objRubric.setDescription("Descripción 8");
        objRubric.setDate("05/07/2018");
        objRubric.setId_rubric(8);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 9");
        objRubric.setDescription("Descripción 9");
        objRubric.setDate("05/07/2018");
        objRubric.setId_rubric(9);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 10");
        objRubric.setDescription("Descripción 10");
        objRubric.setDate("05/07/2018");
        objRubric.setId_rubric(10);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 11");
        objRubric.setDescription("Descripción 11");
        objRubric.setDate("05/07/2018");
        objRubric.setId_rubric(11);
        rubricClass.add(objRubric);

        objRubric = new RubricClass();
        objRubric.setTitle("Rubrica 12");
        objRubric.setDescription("Descripción 12");
        objRubric.setDate("05/07/2018");
        objRubric.setId_rubric(12);
        rubricClass.add(objRubric);

        listViewAdapter = new ListViewAdapter(this, rubricClass);
        listView.setAdapter(listViewAdapter);
    }

}
