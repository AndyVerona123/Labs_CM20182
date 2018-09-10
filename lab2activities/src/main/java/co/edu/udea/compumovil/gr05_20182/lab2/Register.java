package co.edu.udea.compumovil.gr05_20182.lab2;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Register extends AppCompatActivity {
    ImageView upload_image;
    Button rotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        upload_image = findViewById(R.id.image_id);
        rotate = findViewById(R.id.button_rotate);
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView img =  findViewById(R.id.image_id);
                img.setRotation(img.getRotation()+90);
            }
        });
    }

    public void onClickImage(View view) {
        uploadmage();
    }
    private void uploadmage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),10);
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri path = data.getData();
            upload_image.setImageURI(path);
        }
    }
}
