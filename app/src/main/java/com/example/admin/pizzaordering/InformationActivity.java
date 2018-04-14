package com.example.admin.pizzaordering;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InformationActivity extends AppCompatActivity {
    Button btnTroVe;
    Button btnXacNhan;
    EditText edtName;
    EditText edtPhone;
    EditText edtEmail;
    SharedPreferences savename,saveemail,savephone,stateLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        anhXa();
        eventButton();
        setInfo();
    }

    private void eventButton() {
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformationActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtName.getText().toString().isEmpty()){
                    Toast.makeText(InformationActivity.this, "Bạn chưa nhập tên", Toast.LENGTH_SHORT).show();
                }else if (edtEmail.getText().toString().isEmpty()){
                    Toast.makeText(InformationActivity.this, "Bạn chưa nhập email", Toast.LENGTH_SHORT).show();
                }else if (edtPhone.getText().toString().isEmpty()){
                    Toast.makeText(InformationActivity.this, "Bạn chưa nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }
                else {
                    HomeActivity.arrayCart.removeAll(HomeActivity.arrayCart);
                    Intent intent = new Intent(InformationActivity.this,HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(InformationActivity.this, "Bạn đã đặt mua hàng thành công, mời bạn tiếp tục mua hàng", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
private void setInfo(){
    if (stateLogin.getString("state","") == "true") {
        edtName.setText(savename.getString("tendangnhap", ""));
        edtEmail.setText(saveemail.getString("email", ""));
        edtPhone.setText(savephone.getString("phone", ""));
    }
}
    private void anhXa() {
        btnTroVe = findViewById(R.id.buttonTroVe);
        btnXacNhan = findViewById(R.id.buttonXacNhan);
        edtName = findViewById(R.id.edtNameKH);
        edtEmail = findViewById(R.id.edtEmailKH);
        edtPhone = findViewById(R.id.edtSDTKH);
        savename = getSharedPreferences("tendangnhap",MODE_PRIVATE);
        saveemail = getSharedPreferences("email",MODE_PRIVATE);
        savephone = getSharedPreferences("phone",MODE_PRIVATE);
        stateLogin = getSharedPreferences("state",MODE_PRIVATE);
    }
}
