package daoud.dona.caloriesdona;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class imagePickExamp extends AppCompatActivity {
    private ImageView imageView;
    private Button btnViewImage;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMTION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickimage);
        btnViewImage= findViewById(R.id.btnViewImage);
        imageView= findViewById(R.id.imageView);

    }
private void pickImageFromGallery() {
        //intent to pic image
    Intent intent = new Intent(Intent.ACTION_PICK);
    intent.setType("image/*");
    startActivityForResult(intent,IMAGE_PICK_CODE);
    imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //check runtime permition
            if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                    //Permision not granted , request it.
                    String[] permitions = { Manifest.permission.READ_EXTERNAL_STORAGE};
                    // SHOW POPUP for runtime permision
                }
            }
        }
    });    }

}