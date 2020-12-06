package daoud.dona.caloriesdona.MyUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.UUID;

import daoud.dona.caloriesdona.R;

//1. design addTask XML
public class AddTask extends AppCompatActivity {
    //2.
    private EditText etTitle, etSubject;
    private SeekBar skbNessecry, skbImportant;
    private ImageButton imgBtn;
    private Button btnUpload,btnSaveTask,btnDatePicker;
    private TextView tvImportant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //3. find view by id
        setContentView(R.layout.activity_add_task);
        etTitle= findViewById(R.id.etTitle);
        etSubject= findViewById(R.id.etSubject);
        tvImportant= findViewById(R.id.tvImportant);
        btnSaveTask= findViewById(R.id.btnSaveTask);
        imgBtn= findViewById(R.id.imgBtn);
        skbNessecry= findViewById(R.id.skbNessecry);
        skbImportant= findViewById(R.id.skbImportant);
        btnDatePicker= findViewById(R.id.btnDatePicker);
        tvImportant= findViewById(R.id.tvImportant);

        //4. listeners
        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //5
    public void validateForm() {
        String title = etTitle.getText().toString();
        String subject = etSubject.getText().toString();
        int imp = skbImportant.getProgress();
        int nec = skbNessecry.getProgress();
        boolean isOk = true;
        if (title.length() == 0) {
            isOk = false;
            etTitle.setError("at least one char");
        }
        if (isOk) {
            //6. save on firebase
            //6.1 build your data object
            MyTask myTask = new MyTask();
            myTask.setTitle(title);
            myTask.setSub(subject);
            myTask.setNecessary(nec);
            myTask.setImportant(imp);
            //6.2
            saveTask(myTask);
        }
    }
    //6.3 request to save my task (firebase database)
    private void saveTask(MyTask myTask){
        //1.
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        //2.
        DatabaseReference reference= database.getReference();
        //3.User id
        FirebaseAuth auth=FirebaseAuth.getInstance();
        String uid=auth.getCurrentUser().getUid();
        //4. My Object key
        String key=reference.child("All Task").push().getKey();
        //5.
        myTask.setOwner(uid);
        myTask.setKey(key);
        //6 actual storing
        reference.child("AllTasls").child(uid).setValue(myTask).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(AddTask.this,"add successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(AddTask.this,"add failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });

    }
}