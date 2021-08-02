package com.example.chamcong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.example.chamcong.MyUtil;
import com.example.chamcong.Object.Chucvu;
import com.example.chamcong.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


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

//    public Filter getFilter() {
//
//        Filter filter = new Filter() {
//
//        @SuppressWarnings("unchecked")
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//
//            arrayListNames = (JSONArrayChucvu) results.values;
//            notifyDataSetChanged();
//        }
//
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//
//            FilterResults results = new FilterResults();
//            ArrayList<Chucvu> FilteredArrayNames = new ArrayList<Chucvu>();
//
//            // perform your search here using the searchConstraint String.
//
//            constraint = constraint.toString().toLowerCase();
//            for (int i = 0; i < mDatabaseOfNames.size(); i++) {
//                String dataNames = mDatabaseOfNames.get(i);
//                if (dataNames.toLowerCase().startsWith(constraint.toString()))  {
//                    FilteredArrayNames.add(dataNames);
//                }
//            }
//
//            results.count = FilteredArrayNames.size();
//            results.values = FilteredArrayNames;
//            Log.e("VALUES", results.values.toString());
//
//            return results;
//        }
//    };
//
//        return filter;
//    }
}
