package com.android.example.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int quantity = 0;
    int price    = 15;

    Button decrement_quantity_button;
    Button increment_quantity_button;

    TextView quantity_text_view;
    TextView price_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        decrement_quantity_button = (Button) findViewById(R.id.decrement_quantity_button);
        increment_quantity_button = (Button) findViewById(R.id.increment_quantity_button);
        decrement_quantity_button.setOnClickListener(this);
        increment_quantity_button.setOnClickListener(this);

        quantity_text_view = (TextView) findViewById(R.id.quantity_text_view);
        price_text_view    = (TextView) findViewById(R.id.price_text_view);

        display();
    }

    public void submitOrder(View view) {
        Toast.makeText(this, "Submited!", Toast.LENGTH_SHORT).show();
    }

    public void display() {
        quantity_text_view.setText("" + quantity);
        price_text_view.setText(NumberFormat.getCurrencyInstance().format((quantity * price)));
    }

    public void decrementQuantity() {
        quantity = (quantity > 0) ? quantity -= 1 : 0;
    }

    public void incrementQuantity() {
        quantity++;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.increment_quantity_button:
                incrementQuantity();
                break;

            case R.id.decrement_quantity_button:
                decrementQuantity();
                break;
        }

        display();

    }
}
