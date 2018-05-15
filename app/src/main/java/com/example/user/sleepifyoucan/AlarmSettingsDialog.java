package com.example.user.sleepifyoucan;

import android.content.Intent;
import android.os.TestLooperManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AlarmSettingsDialog extends DialogFragment {

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View dialog = inflater.inflate(R.layout.alarm_settings_dialog, container, false);
        getDialog().setTitle("Settings");
        return dialog;
    }*/

   EditText etAlarmSettingsLabel, etAlarmSettingsBarcodeLabel;
   TextView tvAlarmSettingsTime;
   CheckBox cbAlarmSettingsBarcode;
   Button btnSettingsAlarmSave, btnSettingsAlarmCancel;

   String time, label;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        time = getArguments().getString("time");
        label = getArguments().getString("label");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View dialog = inflater.inflate(R.layout.alarm_settings_dialog, container, false);
        etAlarmSettingsLabel = dialog.findViewById(R.id.etAlarmSettingsLabel);
        tvAlarmSettingsTime = dialog.findViewById(R.id.tvAlarmSettingsTime);
        cbAlarmSettingsBarcode = dialog.findViewById(R.id.cbAlarmSettingsBarcode);
        btnSettingsAlarmSave = dialog.findViewById(R.id.btnSettingsAlarmSave);
        btnSettingsAlarmCancel = dialog.findViewById(R.id.btnSettingsAlarmCancel);
        etAlarmSettingsBarcodeLabel = dialog.findViewById(R.id.etAlarmSettingsBarcodeLabel);
        return dialog;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvAlarmSettingsTime.setText(time);
        etAlarmSettingsLabel.setText(label);
        btnSettingsAlarmSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveClick();
            }
        });

        btnSettingsAlarmCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelClick();
            }
        });

        cbAlarmSettingsBarcode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    etAlarmSettingsBarcodeLabel.setVisibility(View.VISIBLE);
                }
                else
                    etAlarmSettingsBarcodeLabel.setVisibility(View.GONE);
            }
        });

    }

    public static AlarmSettingsDialog init(String time, String label){
        AlarmSettingsDialog dialog = new AlarmSettingsDialog();
        Bundle args = new Bundle();
        args.putString("time", time);
        args.putString("label", label);
        dialog.setArguments(args);
        return dialog;
    }

    public void saveClick(){
        dismiss();
    }

    public void cancelClick(){
        dismiss();
    }

}
