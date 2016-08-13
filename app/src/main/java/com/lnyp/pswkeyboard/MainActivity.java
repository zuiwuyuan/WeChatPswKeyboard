package com.lnyp.pswkeyboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toNormalKeyBoard(View view) {
        startActivity(new Intent(this, NormalKeyBoardActivity.class));
    }

    public void toPayKeyBoard(View view) {
        startActivity(new Intent(this, PaymentKeyBoardActivity.class));
    }
}
