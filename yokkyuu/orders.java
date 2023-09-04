package com.example.yokkyuu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class orders extends AppCompatActivity {
    private LinearLayout linearLayout;
    private Intent intent;
    private Bundle bundle;
    private DatabaseReference userRef;



    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        linearLayout = findViewById(R.id.product_place);

        userRef = FirebaseDatabase.getInstance().getReference();
        userRef.child("customerNumber").setValue(1);

        intent = getIntent();
        bundle = intent.getExtras();

        exitButton = findViewById(R.id.exit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        if (bundle != null) {
            HashMap<String, Integer> choicesMenu = (HashMap<String, Integer>) bundle.getSerializable("choicesMenu");
            HashMap<String, Integer> quantity = (HashMap<String, Integer>) bundle.getSerializable("quantity");

            if (choicesMenu != null && quantity != null) {
                for (Map.Entry<String, Integer> entry : choicesMenu.entrySet()) {
                    String itemName = entry.getKey();
                    int itemPrice = entry.getValue();
                    int itemQuantity = quantity.getOrDefault(itemName, 0);

                    String itemDetails = itemName + " - PHP " + itemPrice + " - Quantity: " + itemQuantity;
                    String storing = itemName + itemQuantity;

                    TextView textView = new TextView(this);
                    TextView textView1 = new TextView(this);
                    textView.setText(itemDetails);
                    textView1.setText(storing);
                    linearLayout.addView(textView);
                }
            }
        }
    }
}