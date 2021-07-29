package com.example.chamcong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chamcong.MyUtil;
import com.example.chamcong.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DSPBAdapter extends BaseAdapter {

    private Context context;
    private JSONArray jsonArrayPhongban;

    public DSPBAdapter(Context context, JSONArray jsonArrayPhongban) {
        this.context = context;
        this.jsonArrayPhongban = MyUtil.jsonArrayPhongban;
    }

    @Override
    public int getCount() {
        return jsonArrayPhongban.length();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.dspb, parent, false);
        }

        TextView pbTen = (TextView) convertView.findViewById(R.id.pb_ten);
//        TextView pbID = (TextView) convertView.findViewById(R.id.pbId);

        try {
            JSONObject jsonObject = jsonArrayPhongban.getJSONObject(position);


//            pbID.setText(jsonObject.getString("Pb_id"));
            pbTen.setText(jsonObject.getString("Pb_ten"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
