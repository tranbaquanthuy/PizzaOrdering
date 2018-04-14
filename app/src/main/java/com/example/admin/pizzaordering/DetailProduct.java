package com.example.admin.pizzaordering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class DetailProduct extends AppCompatActivity {
    Toolbar toolbarDetail;
    ImageView imgDetail;
    TextView txvDetailProduct;
    TextView txvDetailPrice;
    TextView txvDetailDescription;
    Spinner spinner;
    Button buttonCart;
    String name = "";
    String price = "";
    String description = "";
    int img = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        anhXa();
        actionBar();
        catchEventSpinner();
        eventButton();
        getInformation();
    }

    private void eventButton(){
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (HomeActivity.arrayCart.size()>0){
                    boolean exists = false;
                    int s = Integer.parseInt(spinner.getSelectedItem().toString());
                    for (int i = 0 ; i<HomeActivity.arrayCart.size();i++){
                        if(HomeActivity.arrayCart.get(i).getNameProduct() == name){
                            HomeActivity.arrayCart.get(i).setNumberProduct(HomeActivity.arrayCart.get(i).getNumberProduct() + s);
                            if (HomeActivity.arrayCart.get(i).getNumberProduct() >=10){
                                HomeActivity.arrayCart.get(i).setNumberProduct(10);
                            }
                            HomeActivity.arrayCart.get(i).setPriceProduct(Integer.parseInt(price.toString())*HomeActivity.arrayCart.get(i).getNumberProduct());
                            exists = true;
                        }
                    }
                    if (exists == false){
                        int number = Integer.parseInt(spinner.getSelectedItem().toString());
                        long newPrice = number*Integer.parseInt(price.toString());
                        HomeActivity.arrayCart.add(new Cart(name,newPrice,img,number));
                    }
                }else{
                    int number = Integer.parseInt(spinner.getSelectedItem().toString());
                    long newPrice = number*Integer.parseInt(price.toString());
                    HomeActivity.arrayCart.add(new Cart(name,newPrice,img,number));
                }

                Intent intent = new Intent(DetailProduct.this,CartActivity.class);
                intent.putExtra("giohang",HomeActivity.arrayCart);
                startActivity(intent);
            }
        });
    }
    private void catchEventSpinner(){
        Integer[] number = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_dropdown_item,number);
        spinner.setAdapter(arrayAdapter);
    }
    private void getInformation(){

        ListProduct listProduct = (ListProduct) getIntent().getSerializableExtra("thongtin");
        name = listProduct.getName();
        price = listProduct.getPrice();
        description = listProduct.getDescription();
        img = listProduct.getImage();

        txvDetailProduct.setText(name);
        txvDetailPrice.setText(price);
        txvDetailDescription.setText(description);
        imgDetail.setImageResource(img);
    }

    private void actionBar(){
        setSupportActionBar(toolbarDetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarDetail.setNavigationIcon(android.R.drawable.ic_menu_close_clear_cancel);
        toolbarDetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void anhXa(){
        toolbarDetail = findViewById(R.id.toolbarDetail);
        imgDetail = findViewById(R.id.imgViewDetailProduct);
        txvDetailProduct = findViewById(R.id.txtViewDetailProduct);
        txvDetailPrice = findViewById(R.id.txtViewDetailPrice);
        txvDetailDescription = findViewById(R.id.txtViewDetailDescription);
        buttonCart = findViewById(R.id.buttonCart);
        spinner =findViewById(R.id.spinner);
    }
}
