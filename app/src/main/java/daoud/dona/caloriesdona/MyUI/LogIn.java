package daoud.dona.caloriesdona.MyUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import daoud.dona.caloriesdona.R;

public class LogIn extends AppCompatActivity {
    private EditText edEmail,edPassWord;
    private Button btnSignIn,btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //3 Find view by ID
        edEmail= findViewById(R.id.edEmail);
        edPassWord= findViewById(R.id.edPassWord);
        btnSignIn= findViewById(R.id.btnSignIn);
        btnSignUp= findViewById(R.id.btnSignUp);
    }

}