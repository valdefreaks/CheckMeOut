package com.example.valdefreaks.checkmeout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class AddRubricActivity extends AppCompatActivity {

    EditText et_add_rubric_tittle;
    EditText et_add_rubric_description;
    EditText et_add_rubric_new_item;
    Button btn_add_rubric_add_to_listview;
    ListView lv_add_rubric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rubric);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_add_rubric_tittle = findViewById(R.id.et_add_rubric_tittle);
        et_add_rubric_description = findViewById(R.id.et_add_rubric_description);
        et_add_rubric_new_item = findViewById(R.id.et_add_rubric_new_item);
        btn_add_rubric_add_to_listview = findViewById(R.id.btn_add_rubric_add_to_listview);
        lv_add_rubric = findViewById(R.id.lv_add_rubric);

        et_add_rubric_tittle.setHint("Nombre");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.registration_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                //Guardar la rubrica y regresar a la lista principal
                this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
