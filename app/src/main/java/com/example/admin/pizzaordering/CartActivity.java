package com.example.admin.pizzaordering;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    ListView listViewCart;
    TextView txvNoti;
    static TextView txvTong;
    Button btnThanhToan;
    Button btnTiepTuc;
    android.support.v7.widget.Toolbar toolbarCart;
    CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        anhXa();
        actionBar();
        checkData();
        eventUltil();
        catchOnItem();
        eventButton();
    }

    private void eventButton() {
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (HomeActivity.arrayCart.size() > 0){
                    Intent intent = new Intent(CartActivity.this,InformationActivity.class);
                    startActivity(intent);
                    
                }else {

                    Toast.makeText(CartActivity.this, "Giỏ hàng của bạn hiện chưa có sản phẩm", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void catchOnItem() {
        listViewCart.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này ?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(HomeActivity.arrayCart.size() < 0){
                            txvNoti.setVisibility(View.VISIBLE);

                        }else {
                            HomeActivity.arrayCart.remove(position);
                            cartAdapter.notifyDataSetChanged();
                            eventUltil();
                            if (HomeActivity.arrayCart.size() <=0){
                                txvNoti.setVisibility(View.VISIBLE);
                            }else {
                                txvNoti.setVisibility(View.INVISIBLE);
                                cartAdapter.notifyDataSetChanged();
                                eventUltil();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        cartAdapter.notifyDataSetChanged();
                        eventUltil();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    public static void eventUltil() {
        long tongTien = 0;
        for (int i = 0; i<HomeActivity.arrayCart.size();i++){
            tongTien += HomeActivity.arrayCart.get(i).getPriceProduct();
        }
        txvTong.setText( tongTien + "");
    }

    public void checkData() {
        if (HomeActivity.arrayCart.size()<=0){
            txvNoti.setVisibility(View.VISIBLE);
            listViewCart.setVisibility(View.INVISIBLE);
        }else {
            txvNoti.setVisibility(View.INVISIBLE);
            listViewCart.setVisibility(View.VISIBLE);
        }
    }

    public void anhXa() {
        listViewCart = findViewById(R.id.listViewCart);
        txvNoti = findViewById(R.id.textViewNoti);
        txvTong = findViewById(R.id.txvTong);
        btnThanhToan = findViewById(R.id.buttonThanhToan);
        btnTiepTuc = findViewById(R.id.buttonTiepTuc);
        toolbarCart = findViewById(R.id.toolbarCart);
        cartAdapter = new CartAdapter(CartActivity.this,HomeActivity.arrayCart,R.layout.cart);
        listViewCart.setAdapter(cartAdapter);
    }

    private void actionBar() {
        setSupportActionBar(toolbarCart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarCart.setNavigationIcon(android.R.drawable.ic_menu_close_clear_cancel);
        toolbarCart.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
