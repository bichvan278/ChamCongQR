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


public class DSCVAdapter extends BaseAdapter {

    private Context context;
    private JSONArray jsonArrayChucvu;

    public DSCVAdapter(Context context, JSONArray jsonArrayChucvu) {
        this.context = context;
        this.jsonArrayChucvu = MyUtil.jsonArrayChucvu;
    }

    @Override
    public int getCount() {
        return jsonArrayChucvu.length();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.dscv, parent, false);
        }

        TextView cvTen = (TextView) convertView.findViewById(R.id.cv_ten);
//        TextView cvID = (TextView) convertView.findViewById(R.id.cvId);

        try {
            JSONObject jsonObject = jsonArrayChucvu.getJSONObject(position);


//            cvID.setText(jsonObject.getString("cv_id"));
            cvTen.setText(jsonObject.getString("cv_ten"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
