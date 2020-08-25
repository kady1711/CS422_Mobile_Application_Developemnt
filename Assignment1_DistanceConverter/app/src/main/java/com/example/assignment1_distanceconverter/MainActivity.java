package com.example.assignment1_distanceconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private RadioButton kilometertomiles;
    private RadioButton milestokilometers;
    private EditText UserInput;
    private TextView ConvertedOutput;
    private TextView UnitofInputValue;
    private TextView UnitofOutputValue;
    private TextView RecentConversions;
    private Button ConvertButton;
    private String string="";
    private String CheckRadioButton = "Kilometers to Miles";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kilometertomiles = (RadioButton) findViewById(R.id.kilometerstomiles);
        milestokilometers = (RadioButton) findViewById(R.id.milestokilometers);
        UserInput = (EditText) findViewById(R.id.Input);
        ConvertedOutput = (TextView) findViewById(R.id.Output);
        UnitofInputValue = (TextView) findViewById(R.id.UnitOfInput);
        UnitofOutputValue = (TextView) findViewById(R.id.UnitOfOutput);
        RecentConversions = (TextView) findViewById(R.id.ConversionHistoryView);
        ConvertButton =(Button) findViewById(R.id.ConvertButton);
        RecentConversions.setMovementMethod(new ScrollingMovementMethod());
    }

    public void selectUnit(View v)
    {
        switch (v.getId())
        {
            case R.id.kilometerstomiles:
                UnitofInputValue.setText("Kilometers Value:");
                UnitofOutputValue.setText("Miles Value:");
                break;

            case R.id.milestokilometers:
                UnitofInputValue.setText("Miles Value:");
                UnitofOutputValue.setText("Kilometers Value:");
                break;
        }

        }
       /* CheckRadioButton = ((RadioButton) v).getText().toString();
        if(CheckRadioButton.trim().equals("Kilometers to Miles"))
        {
            UnitofInputValue.setText("Kilometers");
            UnitofOutputValue.setText("Miles");
        }
        else
        {
            UnitofInputValue.setText("Miles");
            UnitofOutputValue.setText("Kilometers");
        }
        UserInput.setText("");
        ConvertedOutput.setText("");
    }*/


    public void onClickClear(View v)
    {
        string="";
        RecentConversions.setText(string);
    }

    public void DistanceConversion (View v)
    {
        if (UserInput.getText().length() == 0)
        {
            Toast.makeText(getApplicationContext(), "Please Enter Distance", Toast.LENGTH_SHORT).show();
        }
        else{
            Double DistanceInput = Double.parseDouble(UserInput.getText().toString());
            Double DistanceResult;
            if (kilometertomiles.isChecked())
            {
                DistanceResult = (DistanceInput * 0.621371);
                ConvertedOutput.setText(String.format("%,.1f", DistanceResult));
                double tempinput = Double.parseDouble(UserInput.getText().toString());
                string = "KM to MI: " + (String.format("%,.1f", tempinput)) + " -> " + (String.format("%,.1f", DistanceResult)) + "\n" + string;
                RecentConversions.setText(string);

            }

            if (milestokilometers.isChecked())
            {

                DistanceResult = (DistanceInput * 1.60934);
                ConvertedOutput.setText(String.format("%,.1f", DistanceResult));
                double tmpinput =  Double.parseDouble(UserInput.getText().toString());
                string = "MI to KM: " + (String.format("%,.1f", tmpinput)) + " -> " + (String.format("%,.1f", DistanceResult)) + "\n" + string;
                RecentConversions.setText(string);
            }
        }
    }

    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString("RecentConversions", string);
        outState.putString("UnitofInputValue", UnitofInputValue.getText().toString());
        outState.putString("UnitofOutputValue", UnitofOutputValue.getText().toString());
        outState.putString("inputValue", UserInput.getText().toString());
        outState.putString("outputValue", ConvertedOutput.getText().toString());
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        // Call super first
        super.onRestoreInstanceState(savedInstanceState);

        string = savedInstanceState.getString("RecentConversions");
        RecentConversions.setText(string);
        UserInput.setText(savedInstanceState.getString("inputValue"));
        ConvertedOutput.setText(savedInstanceState.getString("outputValue"));
        UnitofInputValue.setText(savedInstanceState.getString("UnitofInputValue"));
        UnitofOutputValue.setText(savedInstanceState.getString("UnitofOutputValue"));
        if(savedInstanceState.getString("UnitofInputValue").toString().equalsIgnoreCase("Kilometers Value:"))
        {
            kilometertomiles.setChecked(true);
            milestokilometers.setChecked(false);
        }
        else
        {
            kilometertomiles.setChecked(false);
            milestokilometers.setChecked(true);
        }
    }




}
