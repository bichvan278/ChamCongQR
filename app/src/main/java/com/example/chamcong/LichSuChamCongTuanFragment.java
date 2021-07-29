package com.example.chamcong;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;
import java.util.TimeZone;


public class LichSuChamCongTuanFragment extends Fragment {

    EditText edtWeek;
    ListView LwDateW;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lichsuchamcong_tuan, container, false);
        edtWeek = view.findViewById(R.id.pickWeek);

        edtWeek.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                // calender class's instance and get current date , month and year from calender
                Calendar cal = Calendar.getInstance(TimeZone.getDefault()); // Get current date
                cal.clear();

                Long today = MaterialDatePicker.todayInUtcMilliseconds();

                Long rangedate = MaterialDatePicker.thisMonthInUtcMilliseconds();


                MaterialDatePicker.Builder<Pair<Long, Long>> dateRangePicker = MaterialDatePicker.Builder.dateRangePicker();
                dateRangePicker.setTitleText("Select dates");
                dateRangePicker.build();

                final MaterialDatePicker materialDatePicker = dateRangePicker.build();

                materialDatePicker.show(getActivity().getSupportFragmentManager(), "tag");

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        Resources res = getResources();
                        int color = res.getColor(R.color.orange);

                        edtWeek.setText(materialDatePicker.getHeaderText());
                        edtWeek.setTextColor(color);
                    }
                });
            }
        });
        return view;
    }
}