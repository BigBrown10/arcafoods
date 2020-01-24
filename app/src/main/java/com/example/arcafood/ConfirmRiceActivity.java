package com.example.arcafood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ConfirmRiceActivity extends AppCompatActivity {
    public static final String EXTRA_EXTRA = "com.example.arcafood.EXTRA_EXTRA";
    public static final String EXTRA_TOTAL = "com.example.arcafood.EXTRA_TOTAL";
    public static final String EXTRA_TOP = "com.example.arcafood.EXTRA_TOP";
    public static final String EXTRA_PROTEIN = "com.example.arcafood.EXTRA_PROTEIN";
    public static final String EXTRA_RICE = "com.example.arcafood.EXTRA_RICE";
    public static final String EXTRA_SPIN1 = "com.example.arcafood.EXTRA_SPIN1";
    public static final String EXTRA_SPIN2 = "com.example.arcafood.EXTRA_SPIN2";
    public static final String EXTRA_SPIN3 = "com.example.arcafood.EXTRA_SPIN3";

    String spinnerOrder1;
    String spinnerOrder2;
    String spinnerOrder3;
    int RiceInt;
    int toppings;
    String extra;
    int protein;
    EditText myRice;
    EditText myProtein;
    EditText myToppings;
    EditText miscelenous;
    Button orderButton;
    CheckBox myCheck;

    private String currentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_rice);


        try {
            currentImage = getIntent().getExtras().get("pictures").toString();
            Log.e("ConfirmRice", currentImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        final List<String> foodArray = new ArrayList<String>();
            foodArray.add("White Rice");
            foodArray.add("Jollof Rice");
            foodArray.add("Fried Rice");
            foodArray.add("Fufu");
            foodArray.add("Pounded Yam");
            foodArray.add("Eba");
            foodArray.add("Amala");


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, foodArray);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            final Spinner sItems = (Spinner) findViewById(R.id.SpinnerFeedbackType);

            sItems.setAdapter(adapter);
            sItems.setSelection(foodArray.indexOf(currentImage));
            sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                   spinnerOrder1 = (String) adapterView.getSelectedItem();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });




        final List<String> ProteinArray = new ArrayList<String>();
            ProteinArray.add("None");
            ProteinArray.add("Chicken");
            ProteinArray.add("Beef");
            ProteinArray.add("Fish");
            ProteinArray.add("Goat Meat");
            ProteinArray.add("Beans");


            ArrayAdapter<String> theAdapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, ProteinArray);

            theAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            final Spinner myItems = (Spinner) findViewById(R.id.FeedType);
            myItems.setAdapter(theAdapter);
            myItems.setSelection(ProteinArray.indexOf(currentImage));
            myItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                     spinnerOrder2 = (String) adapterView.getSelectedItem();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


        final List<String> toppingArray = new ArrayList<String>();
            toppingArray.add("None");
            toppingArray.add("Plantain");
            toppingArray.add("Moi-Moi");
            toppingArray.add("Spaghetti");
            toppingArray.add("Salad");

            ArrayAdapter<String> dapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, toppingArray);

            dapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            final Spinner theItems = (Spinner) findViewById(R.id.Type);
            theItems.setAdapter(dapter);
            theItems.setSelection(toppingArray.indexOf(currentImage));
            theItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                 public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                     spinnerOrder3 = (String) adapterView.getSelectedItem();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


        myCheck = findViewById(R.id.Check);
        boolean mybooCheck = myCheck.isChecked();


        orderButton = findViewById(R.id.myButton);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(myCheck.isChecked())) {
                    Toast.makeText(getApplicationContext(), "agree to terms and conditions", Toast.LENGTH_SHORT).show();

                } else {


                    myRice = findViewById(R.id.ricePrice);
                    RiceInt = Integer.parseInt(myRice.getText().toString());
                    myProtein = findViewById(R.id.proteinPrice);
                    protein = Integer.parseInt(myProtein.getText().toString());
                    myToppings = findViewById(R.id.ToppingPrice);
                    toppings = Integer.parseInt(myToppings.getText().toString());
                    miscelenous = findViewById(R.id.Miscelenous);
                    extra = miscelenous.getText().toString();


                    Intent myIntent = new Intent(ConfirmRiceActivity.this, FinalOrder.class);
                    myIntent.putExtra(EXTRA_TOTAL, Total(RiceInt, protein, toppings));
                    myIntent.putExtra(EXTRA_RICE, RiceInt);
                    myIntent.putExtra(EXTRA_PROTEIN, protein);
                    myIntent.putExtra(EXTRA_TOP, toppings);
                    myIntent.putExtra(EXTRA_EXTRA, extra);
                    myIntent.putExtra(EXTRA_SPIN1, spinnerOrder1);
                    myIntent.putExtra(EXTRA_SPIN2, spinnerOrder2);
                    myIntent.putExtra(EXTRA_SPIN3, spinnerOrder3);
                    startActivity(myIntent);
                }

                }

            public int Total(int rice, int myProtein, int tops){
                rice = RiceInt;
                myProtein = protein;
                tops = toppings;
                int total = (RiceInt + protein + toppings);
                return total;
            }
        });
    }

}




