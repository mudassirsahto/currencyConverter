package com.example.currencyconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    Button btnP, btnU;

    TextView result;

    double RATE = 280.0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        amount = findViewById(R.id.txtAmount);
        btnP = findViewById(R.id.btnPKR);
        btnU = findViewById(R.id.btnUSD);
        result = findViewById(R.id.txtViewResult);

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = amount.getText().toString();

                if(!input.isEmpty()){
                    double usd = Double.parseDouble(input);
                    double pkr = usd * RATE;

                    result.setText(usd +" USD = " + pkr + " PKR ");
                }
                else {
                    result.setText("Please enter an amount");
                }
            }
        });

        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = amount.getText().toString();

                if(!input.isEmpty()){
                    double pkr = Double.parseDouble(input);
                    double usd = pkr / RATE;

                    result.setText(pkr +" PKR = " + usd + " USD ");
                }
                else {
                    result.setText("Please enter an amount");
                }
            }
        });
    }
}