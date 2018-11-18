package com.example.valdefreaks.checkmeout;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by valdefreaks on 18/10/18.
 */

public final class VolleySingletonClass {

    private static VolleySingletonClass singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleySingletonClass(Context context){
        VolleySingletonClass.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleySingletonClass getInstance(Context context){
        if (singleton == null){
            singleton = new VolleySingletonClass(context.getApplicationContext());
        }
        return singleton;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;

    }

    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }




}


