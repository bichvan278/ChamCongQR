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


public class DSNVAdapter extends BaseAdapter {

    private Context context;
    private JSONArray jsonArrayUser;

    public DSNVAdapter(Context context, JSONArray jsonArrayUser) {
        this.context = context;
        this.jsonArrayUser = MyUtil.jsonArrayUser;
    }

    @Override
    public int getCount() {
        return jsonArrayUser.length();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.dsnv, parent, false);
        }

        TextView nvTen = (TextView) convertView.findViewById(R.id.nv_ten);
//        TextView cvID = (TextView) convertView.findViewById(R.id.cvId);

        try {
            JSONObject jsonObject = jsonArrayUser.getJSONObject(position);


//            cvID.setText(jsonObject.getString("cv_id"));
            nvTen.setText(jsonObject.getString("User_hoten"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
