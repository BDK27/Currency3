package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edNTD;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
    }

    private void findviews() {
        edNTD = findViewById(R.id.ntd);
        result = findViewById(R.id.result1);

    }

    public void us(View view){
        String n=edNTD.getText().toString();

        if(n.equals("")){
            result.setText(getString(R.string.none));
            new AlertDialog.Builder(this)
                .setTitle(R.string.problem)
                .setMessage(R.string.please_enter_ntd)
                .setPositiveButton(getString(R.string.ok),null)
                .show();
        }else {
            float NTD=Float.parseFloat(n);
            float us=NTD/28.11f;
            Log.d("MainActivity","USD: "+us);
            Toast.makeText(this,"USD is "+us,Toast.LENGTH_LONG).show();
            result.setText(""+us);
            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.usd_is)+us)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNTD.setText("");
                        }
                    })
                    .show();

        }
    }

}