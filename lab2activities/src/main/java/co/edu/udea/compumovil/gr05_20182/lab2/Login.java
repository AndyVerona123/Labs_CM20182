package co.edu.udea.compumovil.gr05_20182.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button Buttonbutton_Register =  findViewById(R.id.button_register);
        Buttonbutton_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageButtonbutton = new Intent(Login.this,Register.class);
                startActivity(imageButtonbutton);
            }
        });
    }
}
