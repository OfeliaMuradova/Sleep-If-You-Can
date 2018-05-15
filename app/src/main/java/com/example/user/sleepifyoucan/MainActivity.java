package com.example.user.sleepifyoucan;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<AlarmRecyclerItem> alarmRecyclerItemList;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getSupportFragmentManager(), "timepicker");
            }
        });


        alarmRecyclerItemList = new ArrayList<>();

        recyclerView = findViewById(R.id.rvAlarmList);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AlarmRecyclerAdapter(alarmRecyclerItemList);
        recyclerView.setAdapter(adapter);

        fillList();

    }

    private void fillList() {
        Date currentTime = Calendar.getInstance().getTime();
        String time = new SimpleDateFormat("hh:mm").format(currentTime);
        AlarmRecyclerItem alarmRecyclerItem = new AlarmRecyclerItem(time, "Test Alarm Label 1");
        alarmRecyclerItemList.add(alarmRecyclerItem);

        for (int i = 2; i < 10; i++) {
            currentTime = Calendar.getInstance().getTime();
            time = new SimpleDateFormat("hh:mm").format(currentTime);
            alarmRecyclerItem = new AlarmRecyclerItem(time, "Test Alarm Label " + i);
            alarmRecyclerItemList.add(alarmRecyclerItem);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
