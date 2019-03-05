package com.ravebiz.day003contactcard;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity2 extends AppCompatActivity {

    @BindView(R.id.nameEditText) EditText name;
    @BindView(R.id.jobEditText) EditText job;
    @BindView(R.id.ageEditText) EditText age;
    @BindView(R.id.addressEditText) EditText address;
    @BindView(R.id.cityEditText) EditText city;
    @BindView(R.id.stateEditText) EditText state;
    @BindView(R.id.zipCodeEditText) EditText zip;
    @BindView(R.id.emailEditText) EditText email;
    @BindView(R.id.phoneEditText) EditText phone;
    private static TextView date;
    private static int monthData;
    private static int dayData;
    private static int yearData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     /*   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences.getString("NAME", "");
        if (name.length()>0){
            Intent intent =new Intent(MainActivity2.this, MainActivity.class);
        }*/

        setContentView(R.layout.activity_secondary);

        ButterKnife.bind(MainActivity2.this);
        phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        date = findViewById(R.id.dateTextView);
    }
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            date.setText(getString(R.string.dateFormat, month, day, year));
            monthData = month;
            yearData = year;
            dayData = day;
        }


    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    @OnClick (R.id.submitButton)
    public void clickSubmit(){
        Intent intent =new Intent(MainActivity2.this, MainActivity.class);
        intent.putExtra("NAME", name.getText().toString());
        intent.putExtra("JOB", job.getText().toString());
        intent.putExtra("AGE", age.getText().toString());
        intent.putExtra("ADDRESS", address.getText().toString());
        intent.putExtra("EMAIL", email.getText().toString());
        intent.putExtra("PHONE", phone.getText().toString());
        intent.putExtra("DAY", String.valueOf(dayData));
        intent.putExtra("MONTH", String.valueOf(monthData));
        intent.putExtra("YEAR", String.valueOf(yearData));
        intent.putExtra("CITY", city.getText().toString());
        intent.putExtra("STATE", state.getText().toString());
        intent.putExtra("ZIP", zip.getText().toString());
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NAME",name.getText().toString());
        editor.putString("JOB",job.getText().toString());
        editor.putString("AGE",age.getText().toString());
        editor.putString("ADDRESS",address.getText().toString());
        editor.putString("EMAIL",email.getText().toString());
        editor.putString("PHONE",phone.getText().toString());
        editor.putString("DAY",String.valueOf(dayData));
        editor.putString("MONTH",String.valueOf(monthData));
        editor.putString("YEAR",String.valueOf(yearData));
        editor.putString("CITY",city.getText().toString());
        editor.putString("STATE",state.getText().toString());
        editor.putString("STATE",zip.getText().toString());

        editor.apply();
        startActivity(intent);
    }


}
