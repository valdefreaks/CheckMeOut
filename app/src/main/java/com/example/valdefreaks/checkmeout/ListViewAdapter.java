package com.example.valdefreaks.checkmeout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<RubricClass> arrayList;


    public ListViewAdapter(Context context, ArrayList<RubricClass> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.arrayList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        if (convertview == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertview = layoutInflater.inflate(R.layout.item_listview, null);
        }



        TextView titleTextView = convertview.findViewById(R.id.rubricTitle);
        TextView descriptionTextView = convertview.findViewById(R.id.rubricDescription);
        TextView dateTextView = convertview.findViewById(R.id.rubricDate);

        titleTextView.setText(arrayList.get(position).getTitle());
        descriptionTextView.setText(arrayList.get(position).getDescription());
        dateTextView.setText(arrayList.get(position).getDate());



        return convertview;
    }
}
