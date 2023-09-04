package com.example.yokkyuu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.HashMap;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    private ArrayList<String> itemList;
    private HashMap<String, Integer> choicesMenu;
    private HashMap<String, Integer> quantity;
    private Button button;
    private Button btn1;
    private Button item1, item2, item3, item4, item5, item6, item7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        choicesMenu = new HashMap<>();
        quantity = new HashMap<>();
        itemList = new ArrayList<>();

        button = findViewById(R.id.orderlist);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, orders.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("choicesMenu", choicesMenu);
                bundle.putSerializable("quantity", quantity);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        item1 = findViewById(R.id.item1);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Takoyaki original";
                choicesMenu.put("Takoyaki original", 202);
                int itemPrice = 220;
                addToCart(itemName, itemPrice);
                Toast.makeText(getApplicationContext(), "Product has been added to the cart", Toast.LENGTH_SHORT).show();
            }
        });

        item2 = findViewById(R.id.item2);
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Takoyaki Cheese Mentakoi";
                choicesMenu.put("Takoyaki Cheese Mentakoi", 220);
                int itemPrice = 220;
                addToCart(itemName, itemPrice);
                Toast.makeText(getApplicationContext(), "Product has been added to the cart", Toast.LENGTH_SHORT).show();
            }
        });

        // Rest of the itemX click listeners...

        item3 = findViewById(R.id.item3);
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Takoyaki Teritama";
                choicesMenu.put("Takoyaki Teritama", 220);
                int itemPrice = 220;
                addToCart(itemName, itemPrice);
                Toast.makeText(getApplicationContext(), "Product has been added to the cart", Toast.LENGTH_SHORT).show();
            }
        });

        item4 = findViewById(R.id.item4);
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Takoyaki Ebimayo";
                choicesMenu.put("Takoyaki Ebimayo", 220);
                int itemPrice = 220;
                addToCart(itemName, itemPrice);
                Toast.makeText(getApplicationContext(), "Product has been added to the cart", Toast.LENGTH_SHORT).show();
            }
        });

        item5 = findViewById(R.id.item5);
        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Takoyaki Redmayo";
                choicesMenu.put("Takoyaki Redmayo", 205);
                int itemPrice = 205;
                addToCart(itemName, itemPrice);
                Toast.makeText(getApplicationContext(), "Product has been added to the cart", Toast.LENGTH_SHORT).show();
            }
        });

        item6 = findViewById(R.id.item6);
        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Raya-Yaki Serunding (Chicken Floss Takoyaki)";
                choicesMenu.put("Raya-Yaki Serunding (Chicken Floss Takoyaki", 220);
                int itemPrice = 220;
                addToCart(itemName, itemPrice);
                Toast.makeText(getApplicationContext(), "Product has been added to the cart", Toast.LENGTH_SHORT).show();
            }
        });

        item7 = findViewById(R.id.item7);
        item7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "Super Jimat Takoyaki Box";
                choicesMenu.put("Super Jimat Takoyaki Box", 220);
                int itemPrice = 220;
                addToCart(itemName, itemPrice);
                Toast.makeText(getApplicationContext(), "Product has been added to the cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void addToCart(String itemName, int itemPrice) {
        // Check if the item is already in the cart
        if (choicesMenu.containsKey(itemName)) {
            int currentQuantity = quantity.getOrDefault(itemName, 0);
            quantity.put(itemName, currentQuantity + 1);
        } else {
            choicesMenu.put(itemName, itemPrice);
            quantity.put(itemName, 1);
        }
    }
}
