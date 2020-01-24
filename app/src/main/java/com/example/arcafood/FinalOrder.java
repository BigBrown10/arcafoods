package com.example.arcafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalOrder extends AppCompatActivity {




    int total;
    int meal;
    int protein;
    int top;
    String miscelenous;
    String Rice;
    String Pros;
    String Tops;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);


        Intent theIntent = getIntent();
        Rice = theIntent.getStringExtra(ConfirmRiceActivity.EXTRA_SPIN1);
        Pros = theIntent.getStringExtra(ConfirmRiceActivity.EXTRA_SPIN2);
        Tops = theIntent.getStringExtra(ConfirmRiceActivity.EXTRA_SPIN3);
        miscelenous = theIntent.getStringExtra(ConfirmRiceActivity.EXTRA_EXTRA);
        meal = theIntent.getIntExtra(ConfirmRiceActivity.EXTRA_RICE, 0);
        protein = theIntent.getIntExtra(ConfirmRiceActivity.EXTRA_PROTEIN, 0);
        top = theIntent.getIntExtra(ConfirmRiceActivity.EXTRA_TOP, 0);
        total = theIntent.getIntExtra(ConfirmRiceActivity.EXTRA_TOTAL, 0);



        TextView SpinnerRice = findViewById(R.id.main);
        SpinnerRice.setText(Rice);

        TextView spinnerPro = findViewById(R.id.pro);
        spinnerPro.setText(Pros);

        TextView spinnerTops = findViewById(R.id.top);
        spinnerTops.setText(Tops);


        TextView miss = findViewById(R.id.extract);
        miss.setText(miscelenous);


        TextView chow =findViewById(R.id.rice);
        chow.setText("" + meal);

        TextView prot = findViewById(R.id.protein);
        prot.setText("" + protein);

        TextView topper =findViewById(R.id.TopPrice);
        topper.setText("" + top);

        TextView totalPrice = findViewById(R.id.total);
        totalPrice.setText("Total = " + "" + total);




        Button thyButton = findViewById(R.id.Button);
        thyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }

}
