package com.example.admin.pizzaordering;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAndRegisterActivity extends AppCompatActivity {
Button  buttonregister,buttonback;
SharedPreferences savename,savepassword,stateLogin,rememberme;
CheckBox checkboxrememberme;
EditText editTextUsnLg,editTextPs;
boolean checkusn = false ,checkpw = false;
SharedPreferences.Editor editorstateLogin,editorememberme;
DrawerLayout drawerLayout;
Toolbar toolbarLoginAndRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_register);
        anhXa();
        checkLoginOrRegister();
        backActionBar();
        checkLoginButton();

    }


    private void anhXa(){
        buttonregister =  findViewById(R.id.buttonregister);
        buttonback  = findViewById(R.id.buttonBackLoginRegister);
        editTextUsnLg = findViewById(R.id.editText);
        editTextPs  = findViewById(R.id.editText2);
        savename = getSharedPreferences("tendangnhap",MODE_PRIVATE);
        savepassword = getSharedPreferences("password",MODE_PRIVATE);
        stateLogin = getSharedPreferences("state",MODE_PRIVATE);
        rememberme = getSharedPreferences("remember",MODE_PRIVATE);
        checkboxrememberme = findViewById(R.id.CheckBoxRememberMe);
        toolbarLoginAndRegister = findViewById(R.id.toolbarLoginAndRegisterActivity);
    }

    private void checkLoginButton(){
    if (rememberme.getString("remember", "").equals("true")) {
        editTextUsnLg.setText(savename.getString("tendangnhap", ""));
        editTextPs.setText(savepassword.getString("password", ""));
        checkboxrememberme.setChecked(true);
    }

                 buttonregister.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         if (editTextUsnLg.getText().toString().isEmpty() || editTextPs.getText().toString().isEmpty()){
                             Intent intent = new Intent(LoginAndRegisterActivity.this,RegisterActivity.class);
                             startActivity(intent);
                         }
                         if (buttonregister.getText().equals("Đăng nhập") && checkboxrememberme.isChecked()) {
                             editorstateLogin = stateLogin.edit();
                             editorstateLogin.clear();
                             editorstateLogin.putString("state", "true");
                             editorstateLogin.commit();
                             editorememberme =rememberme.edit();
                             editorememberme.clear();
                             editorememberme.putString("remember", "true");
                             editorememberme.commit();
                             Toast t = Toast.makeText(LoginAndRegisterActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG);
                             t.show();
                             Intent i = new Intent(LoginAndRegisterActivity.this, HomeActivity.class);
                             startActivity(i);
                         }
                         if (buttonregister.getText().equals("Đăng nhập") && checkboxrememberme.isChecked() == false) {
                             editorstateLogin = stateLogin.edit();
                             editorstateLogin.clear();
                             editorstateLogin.putString("state", "true");
                             editorstateLogin.commit();
                             editorememberme =rememberme.edit();
                             editorememberme.clear();
                             editorememberme.putString("remember", "false");
                             editorememberme.commit();
                             Toast t = Toast.makeText(LoginAndRegisterActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG);
                             t.show();
                             Intent i = new Intent(LoginAndRegisterActivity.this, HomeActivity.class);
                             startActivity(i);
                         }
                         if (buttonregister.getText().equals("Đăng ký")) {
                             Intent i = new Intent(LoginAndRegisterActivity.this, RegisterActivity.class);
                             startActivity(i);
                         }
                     }
                     });

        }

    private void checkLoginOrRegister() {
        editTextUsnLg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                if (savename.getString("tendangnhap","").equals(s.toString())){
                      checkusn = true ;
                }
                else
                {
                   checkusn = false;
                }
                if (checkusn == true && checkpw == true){
                    buttonregister.setText("Đăng nhập");
                }
                else{
                    buttonregister.setText("Đăng ký");
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (savename.getString("tendangnhap","").equals(s.toString())){
                    checkusn = true ;
                }
                else
                {
                    checkusn = false;
                }
                if (checkusn == true && checkpw == true){
                    buttonregister.setText("Đăng nhập");
                }
                else{
                    buttonregister.setText("Đăng ký");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (savename.getString("tendangnhap","").equals(s.toString())){
                    checkusn = true ;
                }
                else
                {
                    checkusn = false;
                }
                if (checkusn == true && checkpw == true){
                    buttonregister.setText("Đăng nhập");
                }
                else{
                    buttonregister.setText("Đăng ký");
                }
            }
        });
        editTextPs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if ( savepassword.getString("password","").equals(s.toString()))
                {
                   checkpw = true;
                }
                else
                {
                    checkpw = false;
                }
                if (checkusn == true && checkpw == true){
                    buttonregister.setText("Đăng nhập");
                }
                else{
                    buttonregister.setText("Đăng ký");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ( savepassword.getString("password","").equals(s.toString()))
                {
                    checkpw = true;

                }
                else
                {
                    checkpw = false;
                }
                if (checkusn == true && checkpw == true){
                    buttonregister.setText("Đăng nhập");
                }
                else{
                    buttonregister.setText("Đăng ký");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if ( savepassword.getString("password","").equals(s.toString()))
                {
                    checkpw = true;

                }
                else
                {
                    checkpw = false;
                }
                if (checkusn == true && checkpw == true){
                    buttonregister.setText("Đăng nhập");
                }
                else{
                    buttonregister.setText("Đăng ký");
                }
            }
        });

    }

    private void backActionBar(){
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginAndRegisterActivity.this,HomeActivity.class);
                startActivity(i);

            }
        });
    }

}
