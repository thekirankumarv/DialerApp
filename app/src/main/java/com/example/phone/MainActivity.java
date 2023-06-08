package com.example.phone;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText display;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    Button btncall,btnsave,btndel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btndel=findViewById(R.id.btndel);
        btnsave=findViewById(R.id.btnsave);
        btncall=findViewById(R.id.btncall);
        display=findViewById(R.id.editTextPhone);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("9");
            }
        });
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=display.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+data));
                startActivity(intent);
            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=display.getText().toString();
                Intent intent=new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.NAME,"unknown");
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,data);
                startActivity(intent);
            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=display.getText().toString();
                if(data.length()>0){
                    String val=data.substring(0,data.length()-1);
                    display.setText(val);
                }else{
                    display.setText("");
                }
            }
        });

    }
}
