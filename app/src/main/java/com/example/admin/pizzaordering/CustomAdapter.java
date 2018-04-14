package com.example.admin.pizzaordering;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 12/17/2017.
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<ListProduct> listProduct;
    private int layout;

    public CustomAdapter(Context context, int layout, List<ListProduct> listProduct) {
        this.context = context;
        this.listProduct = listProduct;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return listProduct.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView txvName = (TextView) view.findViewById(R.id.txtViewProduct);
        TextView txvPrice = (TextView) view.findViewById(R.id.txtViewPrice);
        TextView txvDescription = (TextView) view.findViewById(R.id.txtViewDescription);
        ImageView imgProduct = (ImageView) view.findViewById(R.id.imgViewProduct);



        ListProduct pizza = listProduct.get(i);
        txvName.setText(pizza.Name);

        txvPrice.setText(pizza.Price);

        txvDescription.setMaxLines(2);
        txvDescription.setEllipsize(TextUtils.TruncateAt.END);
        txvDescription.setText(pizza.Description);
        imgProduct.setImageResource(pizza.Image);

        return view;
    }
}
