package com.example.admin.pizzaordering;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    SharedPreferences savename,savepassword,saveemail,savephone;
    SharedPreferences.Editor editorten,editorpassword,editoremail,editorphone;
    Button btnregisterlayout,btnback;
    EditText editTextUsername,editTextPassword,editTextEmail,editTextPhone ;
    boolean existaccount = false;
    private void anhXa(){
        editTextUsername = findViewById(R.id.eTusername);
        editTextPassword = findViewById(R.id.eTpassword);
        editTextEmail =findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        btnregisterlayout =  findViewById(R.id.btnregisterlayout);
        btnback = findViewById(R.id.btnback);
        savename = getSharedPreferences("tendangnhap",MODE_PRIVATE);
        savepassword = getSharedPreferences("password",MODE_PRIVATE);
        saveemail = getSharedPreferences("email",MODE_PRIVATE);
        savephone = getSharedPreferences("phone",MODE_PRIVATE);
    }
    private void onClick(){
        btnregisterlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTextUsername.getText().toString().length() > 5 && editTextPassword.getText().toString().length() > 5 && editTextEmail.getText().toString().length() > 0 && editTextPhone.getText().toString().length() > 0 )
                {
                    showAlertDialogClear();
                }


                if (editTextUsername.getText().toString().length() <= 5)
                {
                    Toast t = Toast.makeText(RegisterActivity.this, "Tên đăng nhập phải tối thiểu 6 ký tự!", Toast.LENGTH_LONG);
                    t.show();
                }
                if (editTextPassword.getText().toString().length() <= 5)
                {
                    Toast t = Toast.makeText(RegisterActivity.this, "Mật khẩu phải tối thiểu 6 ký tự!", Toast.LENGTH_LONG);
                    t.show();
                }
                if(editTextEmail.getText().toString().length() == 0  )
                {
                    Toast t = Toast.makeText(RegisterActivity.this, "Email không được để trống!", Toast.LENGTH_LONG);
                    t.show();
                }
                if(editTextPhone.getText().toString().length() ==  0){
                    Toast t = Toast.makeText(RegisterActivity.this, "Số điện thoại không được để trống!", Toast.LENGTH_LONG);
                    t.show();
                }

            }
        });
    }


    public void showAlertDialogClearExist(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("WARNING");
        builder.setMessage("You are resgistered before. Are you sure to register?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                editorten = savename.edit();
                editorten.clear();
                editorten.putString("tendangnhap", editTextUsername.getText().toString());
                editorten.commit();
                editorpassword = savepassword.edit();
                editorpassword.clear();
                editorpassword.putString("password",editTextPassword.getText().toString());
                editorpassword.commit();
                editoremail = saveemail.edit();
                editoremail.clear();
                editoremail.putString("email",editTextEmail.getText().toString());
                editoremail.commit();
                editorphone = savephone.edit();
                editorphone.clear();
                editorphone.putString("phone",editTextPhone.getText().toString());
                Toast t = Toast.makeText(RegisterActivity.this, "Dang ky thanh cong", Toast.LENGTH_LONG);
                t.show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void showAlertDialogClear(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận đăng ký");
        builder.setMessage("Bạn có chắc muốn đăng ký không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                editorten = savename.edit();
                editorten.clear();
                editorten.putString("tendangnhap", editTextUsername.getText().toString());
                editorten.commit();
                editorpassword = savepassword.edit();
                editorpassword.clear();
                editorpassword.putString("password",editTextPassword.getText().toString());
                editorpassword.commit();
                editoremail = saveemail.edit();
                editoremail.clear();
                editoremail.putString("email",editTextEmail.getText().toString());
                editoremail.commit();
                editorphone = savephone.edit();
                editorphone.clear();
                editorphone.putString("phone",editTextPhone.getText().toString());
                editorphone.commit();
                Toast t = Toast.makeText(RegisterActivity.this, "Đăng ký thành công!", Toast.LENGTH_LONG);
                t.show();
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        anhXa();
        onClick();
       btnback.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(RegisterActivity.this,LoginAndRegisterActivity.class);
               startActivity(i);
           }
       });

    }

}
