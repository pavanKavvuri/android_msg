package pro.pavan.broadcastreceiver_try;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView T1, T2;
    Button acceptCall;
    private static final int read_phone = 1;
    broadcast broad = new broadcast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        T1 = (TextView)findViewById(R.id.t1);
        T2 = (TextView)findViewById(R.id.t2);
        acceptCall = (Button) findViewById(R.id.accept);

        acceptCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkPermission(Manifest.permission.READ_PHONE_STATE)) {
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_PHONE_STATE}, read_phone);
                }

            }
        });

    }

    private boolean checkPermission(String permissionString) {
        return ContextCompat.checkSelfPermission(this, permissionString) == PackageManager.PERMISSION_GRANTED;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case read_phone :
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    //dial.setEnabled(true);
                    Toast.makeText(this, "PermissionGranted", Toast.LENGTH_SHORT).show();
                }
                return;
        }


    }





}
