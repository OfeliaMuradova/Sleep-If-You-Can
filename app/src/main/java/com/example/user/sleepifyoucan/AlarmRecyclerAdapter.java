package com.example.user.sleepifyoucan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AlarmRecyclerAdapter extends RecyclerView.Adapter<AlarmRecyclerHolder> {

    Context mContext;
    private List<AlarmRecyclerItem> alarmRecyclerItemList;

    public AlarmRecyclerAdapter(List<AlarmRecyclerItem> alarmRecyclerItemList){
        this.alarmRecyclerItemList = alarmRecyclerItemList;

    }

    @NonNull
    @Override
    public AlarmRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.e("Inflated", "Inflated");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.alarm_item, parent,false);
        Log.e("Set Adapeter", "On Create");
        mContext = parent.getContext();
        return new AlarmRecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmRecyclerHolder holder, final int position) {
        AlarmRecyclerItem alarmRecyclerItem = alarmRecyclerItemList.get(position);
        holder.tvAlarmTime.setText(String.valueOf(alarmRecyclerItem.getTime()));
        holder.tvAlarmLabel.setText(alarmRecyclerItem.getLabel());

        holder.btnSettingsAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmRecyclerItem item = getItem(position);
                FragmentManager fm = ((AppCompatActivity) mContext).getSupportFragmentManager();
                DialogFragment newFragment = AlarmSettingsDialog.init(item.getTime(), item.getLabel());
                newFragment.show(fm , "dialog");

            }
        });
    }

    @Override
    public int getItemCount() {

        int size = alarmRecyclerItemList.size();
        Log.e("size", String.valueOf(size));
        return alarmRecyclerItemList.size();
    }

    public AlarmRecyclerItem getItem(int position){
        return alarmRecyclerItemList.get(position);
    }
}
