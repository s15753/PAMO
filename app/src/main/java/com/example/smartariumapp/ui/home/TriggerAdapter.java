package com.example.smartariumapp.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.model.pojo.TriggerResponse;
import com.example.smartariumapp.data.model.pojo.TriggerResult;

import java.util.ArrayList;

public class TriggerAdapter  extends BaseAdapter {

    ArrayList<TriggerResult> triggerResults;
    Context context;
    LayoutInflater inflter;

    public TriggerAdapter(Context applicationContext, ArrayList<TriggerResult> triggerResults) {
        this.context = applicationContext;
        this.triggerResults = triggerResults;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return triggerResults.size();
    }

    @Override
    public Object getItem(int position) {
        return triggerResults.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflter.inflate(R.layout.trigger_view, null);
        TextView triggerHost = (TextView) convertView.findViewById(R.id.triggerHost);
        TextView triggerDesc = (TextView) convertView.findViewById(R.id.triggerDesc);
        TextView triggerSeverity = (TextView) convertView.findViewById(R.id.triggerSeverity);

        triggerHost.setText(triggerResults.get(position).getHosts().get(0).getHost());
        triggerDesc.setText(triggerResults.get(position).getDescription());
        triggerSeverity.setText(triggerResults.get(position).getLastEvent().getSeverity());

        return convertView;
    }
}
