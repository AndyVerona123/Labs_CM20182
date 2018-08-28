package co.edu.udea.compumovil.gr05_20182.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

//ANDRES ES UN MONGOLO
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imageButtonbutton =  findViewById(R.id.buttom_food);
        imageButtonbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageButtonbutton = new Intent(MainActivity.this,FoodActivity.class);
                startActivity(imageButtonbutton);
            }
        });
    }
}