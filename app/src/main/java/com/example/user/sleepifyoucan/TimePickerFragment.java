package com.example.user.sleepifyoucan;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

import static com.example.user.sleepifyoucan.MainActivity.alarmRecyclerItemList;
import static com.example.user.sleepifyoucan.MainActivity.adapter;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    // TimePickerDialog.OnTimeSetListener interface is implemented to
    //receive a callback when user sets the time


    @Override
    //Returns instance of the TimePickerDialog

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Use the current time as the default values for the picker
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        //New instance
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    //This method is used to add a new alarm
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //TODO implement connection to database to add a new alarm
        //TODO create a new alarm here

        //%02d means formatting the integer with 2 digits, left padding it with zeroes
        AlarmRecyclerItem alarmRecyclerItem = new AlarmRecyclerItem(String.format("%02d", hourOfDay)
                + ":" + String.format("%02d", minute), "Created by Picker");

        alarmRecyclerItemList.add(alarmRecyclerItem);

        //Telling recyclerview that list is updated
        adapter.notifyDataSetChanged();
    }
}
