package daoud.dona.caloriesdona.Data;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import daoud.dona.caloriesdona.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MainBarCodeFragment extends Fragment {
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100 ;
    private CodeScanner mCodeScanner;
    private CodeScannerView scannerView;
    private View root;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main_bar_code, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
            }
        }


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    public void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CAMERA_PERMISSION_REQUEST_CODE:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Start your camera handling here
                    scannerView = root.findViewById(R.id.scanner_view);
                    mCodeScanner = new CodeScanner(getActivity(), scannerView);
                    mCodeScanner.setDecodeCallback(new DecodeCallback() {
                        @Override
                        public void onDecoded(@NonNull final Result result) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getActivity(), result.getText(), Toast.LENGTH_SHORT).show();
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
                } else {
                    Toast.makeText(getActivity(), "\"You declined to allow the app to access your camera\"", Toast.LENGTH_SHORT).show();
                    //AppUtils.showUserMessage("You declined to allow the app to access your camera", this);
                }
        }
    }
}