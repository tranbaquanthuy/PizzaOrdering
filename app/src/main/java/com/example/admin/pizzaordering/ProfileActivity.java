package com.example.admin.pizzaordering;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    SharedPreferences savename,savepassword,saveemail,savephone;
    SharedPreferences.Editor editoremail,editorphone;
    EditText edit1,edit2,edit3,edit4;
    Button btnback,btnedit,btnhoantat,btnhuy;
    Toolbar toolbarProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        anhXa();
        showProfile();
        editButton();
        //backHome();
        actionBar();
    }
    private void actionBar(){
        setSupportActionBar(toolbarProfile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarProfile.setNavigationIcon(android.R.drawable.ic_menu_close_clear_cancel);
        toolbarProfile.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void anhXa(){
        edit1 = findViewById(R.id.editText);
        edit2 = findViewById(R.id.editText2);
        edit3 = findViewById(R.id.editText3);
        edit4 = findViewById(R.id.editText4);
        savename = getSharedPreferences("tendangnhap",MODE_PRIVATE);
        savepassword = getSharedPreferences("password",MODE_PRIVATE);
        saveemail = getSharedPreferences("email",MODE_PRIVATE);
        savephone = getSharedPreferences("phone",MODE_PRIVATE);
      //  btnback = findViewById(R.id.btnbackprofile);
        btnhoantat = findViewById(R.id.button3);
        btnhuy = findViewById(R.id.button4);
        btnedit = findViewById(R.id.btnEdit);
        toolbarProfile = findViewById(R.id.toolbarProfile);

    }
    private void showProfile(){
        edit1.setText(savename.getString("tendangnhap", ""));
        edit2.setText(savepassword.getString("password",""));
        edit3.setText(saveemail.getString("email",""));
        edit4.setText(savephone.getString("phone",""));
        edit1.setEnabled(false);edit2.setEnabled(false);edit3.setEnabled(false);edit4.setEnabled(false);
        btnhoantat.setVisibility(View.INVISIBLE);
        btnhuy.setVisibility(View.INVISIBLE);
    }
    private void backHome(){
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });
    }
    private void editButton(){
    btnedit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       btnhoantat.setVisibility(View.VISIBLE);
       btnhuy.setVisibility(View.VISIBLE);
       btnedit.setClickable(false);
edit3.setEnabled(true);edit4.setEnabled(true);
    }
     });
    btnhuy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
       btnedit.setClickable(true);
       btnhoantat.setVisibility(View.INVISIBLE);
       btnhuy.setVisibility(View.INVISIBLE);

            edit3.setText(saveemail.getString("email",""));
            edit4.setText(savephone.getString("phone",""));
          edit3.setEnabled(false);edit4.setEnabled(false);
        }
    });
    btnhoantat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(edit3.getText().toString().length() == 0  )
            {
                Toast t = Toast.makeText(ProfileActivity.this, "Email không được để trống!", Toast.LENGTH_LONG);
                t.show();
            }
            if(edit4.getText().toString().length() ==  0){
                Toast t = Toast.makeText(ProfileActivity.this, "Số điện thoại không được để trống!", Toast.LENGTH_LONG);
                t.show();
            }
            if(edit3.getText().toString().length() > 0 &&edit4.getText().toString().length() > 0 )
            {
                showAlertDialogEdit();

            }
        }
    });

    }
    public void showAlertDialogEdit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận sửa thông tin");
        builder.setMessage("Bạn có chắc muốn sửa thông tin không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                editoremail = saveemail.edit();
                editoremail.clear();
                editoremail.putString("email",edit3.getText().toString());
                editoremail.commit();
                editorphone = savephone.edit();
                editorphone.clear();
                editorphone.putString("phone",edit4.getText().toString());
                editorphone.commit();
                Toast t = Toast.makeText(ProfileActivity.this, "Sửa thành công!", Toast.LENGTH_LONG);
                t.show();
                edit3.setText(saveemail.getString("email",""));
                edit4.setText(savephone.getString("phone",""));
                btnedit.setClickable(true);
                btnhoantat.setVisibility(View.INVISIBLE);
                btnhuy.setVisibility(View.INVISIBLE);
                edit3.setEnabled(false);edit4.setEnabled(false);
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
