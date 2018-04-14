package com.example.admin.pizzaordering;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 12/19/2017.
 */

public class CartAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Cart> arrayCart;
    private int layout;

    public CartAdapter(Context context, ArrayList<Cart> arrayCart, int layout) {
        this.context = context;
        this.arrayCart = arrayCart;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrayCart.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView txvCart = (TextView) view.findViewById(R.id.txvCart);
        final TextView txvCartPrice = (TextView) view.findViewById(R.id.txvCartPrice);
        ImageView imgCart = (ImageView) view.findViewById(R.id.imgCart);
        final Button btnMinute = (Button) view.findViewById(R.id.buttonMinute);
        final Button btnPlus = (Button) view.findViewById(R.id.buttonPlus);
        final Button btnValue = (Button) view.findViewById(R.id.buttonValue);

        final Cart cart = arrayCart.get(i);
        txvCart.setText(cart.getNameProduct());
        txvCartPrice.setText(cart.getPriceProduct() +"");
        imgCart.setImageResource(cart.getImgProduct());
        btnValue.setText(cart.getNumberProduct()+"");

        int sl = Integer.parseInt(btnValue.getText().toString());
        if (sl >= 10){
            btnPlus.setVisibility(View.INVISIBLE);
            btnMinute.setVisibility(View.VISIBLE);
        }else if (sl <= 1){
            btnMinute.setVisibility(View.INVISIBLE);
        }else if (sl > 1){
            btnMinute.setVisibility(View.VISIBLE);
            btnPlus.setVisibility(View.VISIBLE);
        }
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmn = Integer.parseInt(btnValue.getText().toString()) +1;
                int slht = HomeActivity.arrayCart.get(i).getNumberProduct();
                long giaht = HomeActivity.arrayCart.get(i).getPriceProduct();
                HomeActivity.arrayCart.get(i).setNumberProduct(slmn);
                long giamoinhat = (giaht * slmn) / slht;
                HomeActivity.arrayCart.get(i).setPriceProduct(giamoinhat);
                txvCartPrice.setText( giamoinhat +"");
                CartActivity.eventUltil();
                if(slmn >9){
                    btnPlus.setVisibility(View.INVISIBLE);
                    btnMinute.setVisibility(View.VISIBLE);
                    btnValue.setText(String.valueOf(slmn));
                }else {
                    btnMinute.setVisibility(View.VISIBLE);
                    btnPlus.setVisibility(View.VISIBLE);
                    btnValue.setText(String.valueOf(slmn));
                }

            }
        });
        btnMinute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmn = Integer.parseInt(btnValue.getText().toString()) - 1;
                int slht = HomeActivity.arrayCart.get(i).getNumberProduct();
                long giaht = HomeActivity.arrayCart.get(i).getPriceProduct();
                HomeActivity.arrayCart.get(i).setNumberProduct(slmn);
                long giamoinhat = (giaht * slmn) / slht;
                HomeActivity.arrayCart.get(i).setPriceProduct(giamoinhat);
                txvCartPrice.setText( giamoinhat +"");
                CartActivity.eventUltil();
                if(slmn < 2 ){
                    btnPlus.setVisibility(View.VISIBLE);
                    btnMinute.setVisibility(View.INVISIBLE);
                    btnValue.setText(String.valueOf(slmn));
                }else {
                    btnMinute.setVisibility(View.VISIBLE);
                    btnPlus.setVisibility(View.VISIBLE);
                    btnValue.setText(String.valueOf(slmn));
                }
            }
        });
        return view;
    }
}
