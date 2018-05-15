package com.example.user.sleepifyoucan;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


public class AlarmRecyclerHolder extends RecyclerView.ViewHolder {

    TextView tvAlarmTime,tvAlarmLabel;
    Switch switchEnableAlarm;
    Button btnDeleteAlarm, btnSettingsAlarm;
    View viewAlarmDivider;

    public AlarmRecyclerHolder(View itemView) {
        super(itemView);
        tvAlarmTime = itemView.findViewById(R.id.tvAlarmTime);
        tvAlarmLabel = itemView.findViewById(R.id.tvAlarmLabel);
        switchEnableAlarm = itemView.findViewById(R.id.switchEnableAlarm);
        btnSettingsAlarm = itemView.findViewById(R.id.btnSettingsAlarm);
        viewAlarmDivider = itemView.findViewById(R.id.viewAlarmDivider);
    }
}
