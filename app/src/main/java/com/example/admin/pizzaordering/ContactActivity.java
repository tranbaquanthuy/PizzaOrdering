package com.example.admin.pizzaordering;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
    ImageView imgPhone, imgFace, imgLocate;
    TextView txvPhone, txvFace, txvLocate;
    Toolbar toolbarContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


       anhXa();
       actionBar();
       event();

    }
    private void event(){
        imgPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogCall();
            }
        });
        txvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogCall();
            }
        });
        imgFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogFace();
            }
        });
        txvFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogFace();
            }
        });
        imgLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogLocate();
            }
        });
        txvLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogLocate();
            }
        });
    }
    private void anhXa() {
        imgPhone = findViewById(R.id.imgPhone);
        txvPhone = findViewById(R.id.txvPhone);
        imgFace = findViewById(R.id.imgFace);
        txvFace = findViewById(R.id.txvFace);
        imgLocate = findViewById(R.id.imgLocate);
        txvLocate = findViewById(R.id.txvLocate);
        toolbarContact = findViewById(R.id.toolbarContact);
    }
    private void actionBar(){
        setSupportActionBar(toolbarContact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarContact.setNavigationIcon(android.R.drawable.ic_menu_close_clear_cancel);
        toolbarContact.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void showAlertDialogLocate(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận truy cập");
        builder.setMessage("Bạn muốn mở Google Map ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Mở", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://maps.google.com"));
                startActivity(intent);


            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void showAlertDialogFace(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận truy cập");
        builder.setMessage("Bạn muốn mở Facebook ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Mở", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://facebook.com"));
                startActivity(intent);


            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void showAlertDialogCall(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận liên hệ");
        builder.setMessage("Bạn muốn gọi cho chúng tôi?");
        builder.setCancelable(false);
        builder.setPositiveButton("Gọi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0974641631"));
                startActivity(intent);


            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}





