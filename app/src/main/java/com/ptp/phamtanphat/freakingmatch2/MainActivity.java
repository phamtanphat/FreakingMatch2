package com.ptp.phamtanphat.freakingmatch2;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtdiem,txtsothu1,txtsothu2,txtpheptinh,txtketqua;
    SeekBar seekBarthoigian;
    ImageButton imgtrue,imgfalse;
    ArrayList<String> mangpheptinh;
    int ketqua = 0;
    boolean ramdomtruefalse = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        random();
        checkdapan();
    }

    private void checkdapan() {
        imgtrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ramdomtruefalse == true){
                    Toast.makeText(MainActivity.this, "Dung roi", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Sai roi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imgfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ramdomtruefalse == false){
                    Toast.makeText(MainActivity.this, "Dung roi", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Sai roi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void random() {
        Random random = new Random();

        int sothu1 = random.nextInt(10) + 1;
        int sothu2 = random.nextInt(5) + 2;

        int index = random.nextInt(mangpheptinh.size());
        String pheptinh = mangpheptinh.get(index);

        ramdomtruefalse = random.nextBoolean();

        switch (pheptinh){
            case "+" : ketqua = sothu1 + sothu2;
                break;
            case "-" : ketqua = sothu1 - sothu2;
                break;
            case "*" : ketqua = sothu1 * sothu2;
                break;
        }
        if (ramdomtruefalse == true){
            ketqua += 0;
        }else {
            ketqua += random.nextInt(5) + 1;
        }
        txtsothu1.setText(sothu1+"");
        txtsothu2.setText(sothu2+"");
        txtpheptinh.setText(pheptinh);
        txtketqua.setText(" = " +ketqua + "");
    }

    private void anhxa() {
        txtdiem = (TextView) findViewById(R.id.textviewdiem);
        txtsothu1 = (TextView) findViewById(R.id.textviewsothu1);
        txtsothu2 = (TextView) findViewById(R.id.textviewsothu2);
        txtpheptinh = (TextView) findViewById(R.id.textviewpheptinh);
        txtketqua = (TextView) findViewById(R.id.textviewketqua);
        imgtrue = (ImageButton) findViewById(R.id.imagebuttontrue);
        imgfalse = (ImageButton) findViewById(R.id.imagebuttonfalse);
        seekBarthoigian = (SeekBar) findViewById(R.id.seekbartime);
        mangpheptinh = new ArrayList<>();
        mangpheptinh.add("+");
        mangpheptinh.add("*");
        mangpheptinh.add("-");
    }
}
