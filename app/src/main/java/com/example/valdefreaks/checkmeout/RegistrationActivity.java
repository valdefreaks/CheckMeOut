package com.example.valdefreaks.checkmeout;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    EditText et_registration_tutor_name;
    EditText et_registration_relationship;

    private static final String TAG = RegistrationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_registration_tutor_name = findViewById(R.id.et_registration_tutor_name);
        et_registration_relationship = findViewById(R.id.et_registration_relationship);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.registration_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                if (!emptyEditText()) {
                    saveTutor();
                    this.finish();
                } else {
                    Toast.makeText(this, "Completa los campos", Toast.LENGTH_LONG).show();
                }


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void processAnswer(JSONObject response) {
        try {
            // Obtener estado
            String estado = response.getString("estado");
            //Obtener mensaje
            String mensaje = response.getString("mensaje");

            switch (estado) {
                case "1":
                    //Mostrar mensaje
                    Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
                    //Enviar codigo de exito
                    this.setResult(Activity.RESULT_OK);
                    //Terminar actividad
                    this.finish();
                    break;
                case "2":
                    //Mostrar mensaje
                    Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
                    //Enviar codigo de falla
                    this.setResult(Activity.RESULT_CANCELED);
                    //Terminar actividad
                    this.finish();
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean emptyEditText() {
        String tutor = et_registration_tutor_name.getText().toString();
        String relationship = et_registration_relationship.getText().toString();

        return (tutor.isEmpty() || relationship.isEmpty());
    }

    public void saveTutor() {
        //Obtener valores de los controles
        final String d_tutor = et_registration_tutor_name.getText().toString();
        final String d_relationship = et_registration_relationship.getText().toString();

        //-- MANDAMOS A PANTALLA PARA VER SI LAS VARIABLES TIENEN VALORES
        //Toast.makeText(this,d_tutor,Toast.LENGTH_LONG).show();
        //--Toast.makeText(this,d_relationship,Toast.LENGTH_LONG).show();

        HashMap<String, String> map = new HashMap<>();
        map.put("d_tutor", d_tutor);
        map.put("d_relationship", d_relationship);

        //Crear objeto Json basado en el mapa
        JSONObject jsonObject = new JSONObject(map);

        //Depurando objeto Json
        Log.d(TAG, jsonObject.toString());
        try {
            VolleySingletonClass.getInstance(RegistrationActivity.this).addToRequestQueue(
                    new JsonObjectRequest(
                            Request.Method.POST,
                            ConstantsClass.INSERT,
                            jsonObject,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    //Procesar la respuesta del servidor
                                    processAnswer(response);
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.d(TAG, "Error Volley:" + error.getMessage());
                                }
                            }
                    ) {
                        @Override
                        public Map<String, String> getHeaders() {
                            Map<String, String> headers = new HashMap<String, String>();
                            headers.put("Content-Type", "application/json; charset=utf-8");
                            headers.put("Accept", "application/json");
                            return headers;
                        }

                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset=utf-8" + getParamsEncoding();
                        }
                    });
        } catch (Exception Ex) {
            Toast.makeText(this, Ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();
    }
}
