/*
 * This program is a to do list. A user can enter a thing to do and press the add button to add it to the list. The user
 * can also press on the item to clear it and remove it from the list.
 */

package com.example.jiwoo.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import java.util.ArrayList;

/*
 * Initializes variables, creates list and adapter that will help with updating the list.
 */
public class MainActivity extends AppCompatActivity {
    private ArrayList<String> myArray;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.listView);
        myArray = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myArray);
        list.setAdapter(adapter);
    }
    /*
     * This method takes the text from the field and adds it to the array. It then updates the list through the adapter.
     * If anything in the list is clicked, the item is removed and again the adapter updates the list.
     */
    public void addToList(View view) {
        ListView list = (ListView) findViewById(R.id.listView);
        EditText field = (EditText) findViewById(R.id.textField);
        String entry = field.getText().toString();
        myArray.add(entry);
        adapter.notifyDataSetChanged();
        field.setText("");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myArray.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
