package com.example.chamcong;

import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.github.dewinjm.monthyearpicker.MonthYearPickerDialog;
import com.github.dewinjm.monthyearpicker.MonthYearPickerDialogFragment;

import java.util.Calendar;


public class LichSuChamCongThangFragment extends Fragment {

    EditText edtMonth;
    View view;
    private DatePickerDialog.OnDateSetListener datePickerListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lichsuchamcong_thang, container, false);
        edtMonth = view.findViewById(R.id.pickMonth);

        edtMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int yearSelected;
                int monthSelected;

                //Set default values
                Calendar calendar = Calendar.getInstance();
                yearSelected = calendar.get(Calendar.YEAR);
                monthSelected = calendar.get(Calendar.MONTH);

                MonthYearPickerDialogFragment dialogFragment = MonthYearPickerDialogFragment
                        .getInstance(monthSelected, yearSelected);

                dialogFragment.show(getActivity().getSupportFragmentManager(), null);

                dialogFragment.setOnDateSetListener(new MonthYearPickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(int year, int monthOfYear) {

                        String year1 = String.valueOf(year);
                        String monthOfYear1 = String.valueOf(monthOfYear + 1);

                        Resources res = getResources();
                        int color = res.getColor(R.color.orange);
                        edtMonth.setText(year1 + "/" + monthOfYear1);
                        edtMonth.setTextColor(color);
                    }
                });
            }
        });
        return view;
    }
}