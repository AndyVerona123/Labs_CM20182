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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioGroup;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    CheckBox cb1,cb2,cb3;
    RadioGroup radioGroup;
    Button p_clear;
    EditText p_food;
    EditText p_price;
    EditText p_ingredients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        radioGroup = findViewById(R.id.radio_grupo);
        imageView = findViewById(R.id.imagen_id);
        NumberPicker np = findViewById(R.id.number_piker);
        np.setMinValue(1);
        np.setMaxValue(60);
        cb1 = (CheckBox) findViewById(R.id.dia);
        cb2 = (CheckBox) findViewById(R.id.tarde);
        cb3 = (CheckBox) findViewById(R.id.noche);
        if (cb1.isChecked()) {
            cb1.setChecked(false);
        }
        else if(cb2.isChecked()){
            cb2.setChecked(false);
        }
        else {
            cb3.setChecked(false);
        }
        cb1.setOnClickListener(this);
        cb2.setOnClickListener(this);
        cb3.setOnClickListener(this);

        p_food = findViewById(R.id.food);
        p_price = findViewById(R.id.price);
        p_ingredients = findViewById(R.id.ingredients);
        p_clear = (Button) findViewById(R.id.clear);
        p_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p_food.setText("");
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
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.dia:
                cb1.setChecked(true);
                cb2.setChecked(false);
                cb3.setChecked(false);
                break;
            case R.id.tarde:
                cb1.setChecked(false);
                cb2.setChecked(true);
                cb3.setChecked(false);
                break;
            case R.id.noche:
                cb1.setChecked(false);
                cb2.setChecked(false);
                cb3.setChecked(true);
                break;
        }
    }
}
