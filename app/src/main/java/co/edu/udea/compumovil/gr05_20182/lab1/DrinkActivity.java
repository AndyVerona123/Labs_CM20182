package co.edu.udea.compumovil.gr05_20182.lab1;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DrinkActivity extends AppCompatActivity {
    ImageView imageView;
    Button p_clear;
    EditText p_name;
    EditText p_price;
    EditText p_ingredients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        imageView = findViewById(R.id.imagen_id);
        p_name = findViewById(R.id.name);
        p_price = findViewById(R.id.price);
        p_ingredients = findViewById(R.id.ingredients);
        p_clear = (Button) findViewById(R.id.clear);
        p_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p_name.setText("");
                p_price.setText("");
                p_ingredients.setText("");
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void on_click(View view) {
        uploadmage();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    private void uploadmage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
           Uri path = data.getData();
           imageView.setImageURI(path);
        }
    }

    public void button_exit(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}
