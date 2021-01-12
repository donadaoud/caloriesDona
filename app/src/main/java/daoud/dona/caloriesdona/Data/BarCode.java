 package daoud.dona.caloriesdona.Data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.os.Bundle;

import daoud.dona.caloriesdona.R;

 public class BarCode extends AppCompatActivity {
     private val requestCodeCameraPermission = 1001

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code);
        if(ContextCompat.checkSelfPermission(
                this@BarCode
        ))
    }
    private fun setupControls(){

    }
    private fun askForCameraPermission()
    {
        ActivityCompat.requestPermissions(this@BarCode,
        arrayOf(Manifest.permission.CAMERA),
        requestCodeCameraPermission
        )
    }

}