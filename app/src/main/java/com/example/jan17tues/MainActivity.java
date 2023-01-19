package com.example.jan17tues;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Final;
    TextView Formula;
    Button Swap;
    EditText Input;
    Button Calculate;
    
    public double CtoF (double val){
        double q = ((val*(9.0/5))+32);
        return q;
    }

    public double FtoC (double val){
        double q = (val-32)*(5.0/9);
        return q;
    }
    boolean celtofah = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Formula = findViewById(R.id.Formula);
        Final = findViewById(R.id.Final);
        Swap = findViewById(R.id.Swap);
        Input = findViewById(R.id.Input);
        Calculate = findViewById(R.id.Calculate);

        Swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Input.getText().toString();
                if (celtofah == true) {
                    double x = Double.parseDouble(s);
                    Final.setText("" + String.format("%.2f", FtoC(x)) + " C.");
                    Formula.setText("F->C");
                    celtofah = false;
                }
                else {
                    double x = Double.parseDouble(s);
                    Final.setText("" + String.format("%.2f", CtoF(x)) + " F.");
                    Formula.setText("C->F");
                    celtofah = true;
                }


            }
        });
        
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (celtofah == true) {
                    String s = Input.getText().toString();
                    double x = Double.parseDouble(s);
                    Final.setText("" + String.format("%.2f", CtoF(x)) + " F.");
                }
                else {
                    String s = Input.getText().toString();
                    double x = Double.parseDouble(s);
                    Final.setText("" + String.format("%.2f", FtoC(x)) + " C.");
                }
            }
        });
        
    }
}