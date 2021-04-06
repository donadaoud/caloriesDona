 package daoud.dona.caloriesdona.Data;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import daoud.dona.caloriesdona.R;

 public class BarCode extends AppCompatActivity {
     private CodeScanner mCodeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                //todo teracher
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(BarCode.this, result.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
    }

     @Override
     protected void onResume() {
         super.onResume();
         mCodeScanner.startPreview();
     }

     @Override
     protected void onPause() {
         mCodeScanner.releaseResources();
         super.onPause();
     }
 }