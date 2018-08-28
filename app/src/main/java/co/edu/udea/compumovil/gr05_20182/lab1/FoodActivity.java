package co.edu.udea.compumovil.gr05_20182.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioGroup;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox cb1,cb2,cb3;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        radioGroup = findViewById(R.id.radio_grupo);
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
