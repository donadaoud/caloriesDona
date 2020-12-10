package daoud.dona.caloriesdona.MyUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import daoud.dona.caloriesdona.R;

public class MainActivity extends AppCompatActivity {
    private TextView tvDailyCals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}