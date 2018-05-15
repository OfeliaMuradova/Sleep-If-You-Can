package com.example.user.sleepifyoucan;

import android.widget.Button;
import android.widget.ToggleButton;

public class AlarmRecyclerItem {

    private String time, label;

    public AlarmRecyclerItem(String time, String label){
        this.time = time;
        this.label = label;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
