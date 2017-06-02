package com.dhcc.smvp.view.test;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dhcc.smvp.R;

public class SurfaceActivity extends AppCompatActivity {

    private static final int CALL_PHONE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suface);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            //未获得权限  申请权限

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                //权限已经被禁用
                Toast.makeText(this, "您已禁止该权限，需要重新开启。", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS}, CALL_PHONE_CODE);
            }
        } else {
            //获得权限  进行相关操作
            call();
        }
    }

    //打电话
    private void call() {
        Toast.makeText(this, "打电话", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CALL_PHONE_CODE:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    Toast.makeText(this, "获取权限失败", Toast.LENGTH_SHORT).show();
                }
                break;
            default:

                break;
        }
    }
}
