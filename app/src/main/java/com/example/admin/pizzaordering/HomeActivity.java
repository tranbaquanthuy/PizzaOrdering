package com.example.admin.pizzaordering;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    Button btnRegister;
    GridView gridView;
    public static ArrayList<Cart> arrayCart;
    ArrayList<ListProduct> arrayNewProduct;
    CustomAdapter adapterNewProduct;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ViewFlipper viewFlipper;
    ListView listViewSP;
    Button buttonLgR;
    Animation in, out;
    SharedPreferences savename,stateLogin;
    TextView textViewUSN;
    SharedPreferences.Editor editorstateLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        anhXa();
        setViewFlipper();
        actionBar();
    }

    //Ánh xạ các component
    public void anhXa() {
        toolbar = findViewById(R.id.toolbarHome);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        viewFlipper = findViewById(R.id.viewFlipper);
        if(arrayCart != null){

        }
        else {
            arrayCart = new ArrayList<>();
        }
        gridView = findViewById(R.id.gridViewItem);
        arrayNewProduct = new ArrayList<>();
        arrayNewProduct.add(new ListProduct("Pizza Hải Sản Tiêu","Pizza Hải Sẩn Sốt Tiêu Đen, không cần phải nói nhiều vì đây vẫn best seller của chúng tôi từ trước tới giờ. Tôm, mực, thanh cua, hành tây, thơm phủ xốt tiêu đen và phô mai Mozzarella","189000",R.drawable.pizza_newtieuden));
        arrayNewProduct.add(new ListProduct("Pizza Thập Cẩm","Pizza Thập Cẩm Cao Cấp được tạo ra từ xúc xích, thịt nguội, thịt bò, xúc xích gà, thơm, nấm, hành tây, ớt chuông và ô liu. Một món ăn đầy đủ màu sắc cũng như gia vị sẽ làm bạn thích mê.","199000",R.drawable.pizza_newthapcam));
        arrayNewProduct.add(new ListProduct("Pizza Cá Ngừ","Pizza Cá Ngừ là một nét đặc trưng nhất của chúng tôi, ngoài cá ngừ còn có thanh cua, hành tây trên nền sốt Pesto cao cấp. Nếu bạn đang thèm hải sản thì đây là sản phẩm thích hợp nhất rồi đấy.","159000",R.drawable.pizza_newcangu));
        arrayNewProduct.add(new ListProduct("Pizza Xúc Xích Thịt","Pizza Thịt và Xúc Xích, một món ăn được tạo từ 3 loại thịt là thịt muối, thịt bò, thịt nguội và xúc xích. Vị mặn hòa với vị béo của lớp bán Pizza sẽ tạo độ hấp dẫn cho món ăn.","189000",R.drawable.pizza_newthitxucxich));

        adapterNewProduct = new CustomAdapter(HomeActivity.this, R.layout.product,arrayNewProduct);
        gridView.setAdapter(adapterNewProduct);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this,DetailProduct.class);
                intent.putExtra("thongtin",arrayNewProduct.get(i));
                startActivity(intent);
            }
        });

        stateLogin = getSharedPreferences("state", MODE_PRIVATE);
        savename = getSharedPreferences("tendangnhap",MODE_PRIVATE);
        in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        out = AnimationUtils.loadAnimation(this, R.anim.fade_out);
    }

    //Set thời gian cho chạy quảng cáo
    public void setViewFlipper(){
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
    }

    //Gán sự kiện mở thanh Toolbar
    public void actionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
                buttonLgR = findViewById(R.id.btnLgR);
                textViewUSN = findViewById(R.id.textViewUSN);
                buttonLgR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(buttonLgR.getText().equals("ĐăngNhập/ĐăngKý")) {
                            Intent i = new Intent(HomeActivity.this, LoginAndRegisterActivity.class);
                            startActivity(i);
                        }
                        else
                        {
                            showAlertDialogLogout();
                        }
                    }
                });
                textViewUSN.setVisibility(View.GONE);
                if (stateLogin.getString("state","") == "true") {
                    buttonLgR.setText("Đăng xuất");
                    textViewUSN.setVisibility(View.VISIBLE);
                    textViewUSN.setText("Xin chào " + savename.getString("tendangnhap", ""));
                    int color = R.color.colorPrimary;
                    textViewUSN.setTextColor(getResources().getColor(color));
                    textViewUSN.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                            getResources().getDimension(R.dimen.textsize));
                }
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        if(id == R.id.home){
                            Intent intent = new Intent(HomeActivity.this,HomeActivity.class);
                            startActivity(intent);
                        } else if (id == R.id.pizza){
                            Intent intent = new Intent(HomeActivity.this,PizzaActivity.class);
                            startActivity(intent);
                        } else if (id == R.id.cart){
                            Intent intent = new Intent(HomeActivity.this,CartActivity.class);
                            startActivity(intent);
                        } else if (id == R.id.contact){
                            Intent intent = new Intent(HomeActivity.this,ContactActivity.class);
                            startActivity(intent);
                        }
                        else if (id == R.id.profile && stateLogin.getString("state","") == "true" ){
                            Intent intent = new Intent(HomeActivity.this,ProfileActivity.class);
                            startActivity(intent);
                        }
                        else if (id == R.id.profile && stateLogin.getString("state","") != "true" )
                        {
                            Toast t = Toast.makeText(HomeActivity.this, "Bạn cần đăng nhập để xem profile!", Toast.LENGTH_LONG);
                            t.show();
                        }
                            return true;
                    }
                });
            }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart,menu);

        return true;
    }
    public void showAlertDialogLogout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận đăng xuất");
        builder.setMessage("Bạn có chắc muốn đăng xuất không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                editorstateLogin = stateLogin.edit();
                editorstateLogin.clear();
                editorstateLogin.putString("state", "false");
                editorstateLogin.commit();
                textViewUSN.setVisibility(View.GONE);
                buttonLgR.setText("ĐăngNhập/ĐăngKý");
                Toast t = Toast.makeText(HomeActivity.this, "Đăng xuất thành công", Toast.LENGTH_LONG);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuCart:
                Intent intent = new Intent(HomeActivity.this,CartActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
