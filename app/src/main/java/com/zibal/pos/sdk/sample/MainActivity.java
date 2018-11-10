package com.zibal.pos.sdk.sample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    private boolean isPackageInstalled(String packagename) {
        try {
            getPackageManager().getPackageInfo(packagename, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
    
    public void onPay(View view){
        if (isPackageInstalled("pos.zibal.com.zibal")){
            Intent payByZibal = new Intent("com.zibal.pos.zibalpay");
            payByZibal.putExtra("zibalId", "14359");
            startActivityForResult(payByZibal, 951);
        }
        else
            Toast.makeText(this, "لطفا زیبال را نصب و فعال کنید.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "just returned", Toast.LENGTH_SHORT).show();
    }
}
