package com.example.admin.pizzaordering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PizzaActivity extends AppCompatActivity {
    Toolbar toolbarPizza;
    ListView lvPizza;
    ArrayList<ListProduct> arrayPizza;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        anhXa();
        actionBar();



    }
    public void anhXa(){
        toolbarPizza = findViewById(R.id.toolbarPizza);
        lvPizza = findViewById(R.id.lvPizza);
        arrayPizza = new ArrayList<>();
        arrayPizza.add(new ListProduct("Pizza Gà Thập Cẩm","Pizza Gà Thập Cẩm trong cuộc phiêu lưu của vị giác với 2 loại thịt gà, ớt chuông, hành tây và nấm rơm. Thịt gà hòa quyện với vị nồng của hành tây, kèm thêm vị cay của ớt chuông sẽ tạo một nét rất riêng cho bạn.","159000",R.drawable.pizza_ga));
        arrayPizza.add(new ListProduct("Pizza Hải Sản","Pizza Hải Sản Sốt Pesto cao cấp với tôm, mực, nghêu và nấm trên nền sốt Pesto đặc trưng, phủ phô mai Mozzarella và lá húng quế. Một loại sốt đặc trưng mang hương vị lạ, sẽ làm cho bạn cảm thấy rất đặc biệt.","189000",R.drawable.pizza_haisanpesto));
        arrayPizza.add(new ListProduct("Pizza Xúc Xích","Pizza Xúc Xích nướng cùng với lớp phô mai Mozzarella sẽ mang đến một màu sắc đặc trưng. Độ béo của phô mai kèm với vị giòn của xúc xích nướng sẽ làm bạn khó quên.","159000",R.drawable.pizza_xucxich));
        arrayPizza.add(new ListProduct("Pizza Phô Mai","Pizza Phô Mai Cao Cấp với 3 lớp phô mai Mozzarela vàng óng quyến rũ trên nền xốt cà chua. Nếu bạn đang thèm vị béo của phô mai nhưng lại muốn không muốn ảnh hưởng đến cân nặng thì cà chua sẽ giúp cân bằng món ăn này.","129000",R.drawable.pizza_phomai));
        arrayPizza.add(new ListProduct("Pizza Cá Ngừ","Pizza Cá Ngừ là một nét đặc trưng nhất của chúng tôi, ngoài cá ngừ còn có thanh cua, hành tây trên nền sốt Pesto cao cấp. Nếu bạn đang thèm hải sản thì đây là sản phẩm thích hợp nhất rồi đấy.","159000",R.drawable.pizza_cangu));
        arrayPizza.add(new ListProduct("Pizza Thanh Cua","Pizza Cơn Lốc Hải Sản với mực, nghêu, thanh cua, thơm, ớt chuông xanh, hành tây trên nền xốt Cheesy Mayo và phô mai Mozzarella.","189000",R.drawable.pizza_thanhcua));
        arrayPizza.add(new ListProduct("Pizza Thập Cẩm","Pizza Thập Cẩm Cao Cấp được tạo ra từ xúc xích, thịt nguội, thịt bò, xúc xích gà, thơm, nấm, hành tây, ớt chuông và ô liu. Một món ăn đầy đủ màu sắc cũng như gia vị sẽ làm bạn thích mê.","199000",R.drawable.pizza_thapcam));
        arrayPizza.add(new ListProduct("Pizza Thịt Nguội","Pizza Thịt Nguội và Thơm cùng với thịt nguội, thơm, phô mai Mozzarella và xốt cà chưa. Nếu bạn ngại ăn rau củ hãy chọn sản phẩm này, nó sẽ mang lại cảm giác ngon miệng nhưng vẫn sẽ đủ chất dinh dưỡng.","129000",R.drawable.pizza_thitnguoi));
        arrayPizza.add(new ListProduct("Pizza Xúc Xích Thịt","Pizza Thịt và Xúc Xích, một món ăn được tạo từ 3 loại thịt là thịt muối, thịt bò, thịt nguội và xúc xích. Vị mặn hòa với vị béo của lớp bán Pizza sẽ tạo độ hấp dẫn cho món ăn.","189000",R.drawable.pizza_thitxucxich));
        arrayPizza.add(new ListProduct("Pizza Hải Sản Tiêu","Pizza Hải Sẩn Sốt Tiêu Đen, không cần phải nói nhiều vì đây vẫn best seller của chúng tôi từ trước tới giờ. Tôm, mực, thanh cua, hành tây, thơm phủ xốt tiêu đen và phô mai Mozzarella","189000",R.drawable.pizza_tieuden));
        arrayPizza.add(new ListProduct("Pizza Tôm Xốt","Pizza Tôm Xốt Cheesy Mayo cùng với tôm, nấm và ớt chuông đỏ phủ trên nền sốt Chessy Mayo và lớp phô mai Mozarella. Vị ngọt của tôm tươi kèm độ béo của 2 loại sốt phô mai thì còn gì bằng.","159000",R.drawable.pizza_tom));
        arrayPizza.add(new ListProduct("Pizza Rau Củ","Pizza Rau Củ là một món ăn phù hợp cho những bạn ăn chay. Sự hòa quyện của ô liu đen, cà chua bi, nấm, thơm, bắp và phô mai Mozarella. Tuy là món ăn chay nhưng màu sắc và gia vị đều đầy đủ, sẽ tạo cho bạn cảm giác ngon miệng.","129000",R.drawable.pizza_raucu));


        adapter = new CustomAdapter(PizzaActivity.this,R.layout.product,arrayPizza);
        lvPizza.setAdapter(adapter);

        lvPizza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PizzaActivity.this,DetailProduct.class);
                intent.putExtra("thongtin",arrayPizza.get(i));
                startActivity(intent);
            }
        });

    }
    private void actionBar(){
        setSupportActionBar(toolbarPizza);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarPizza.setNavigationIcon(android.R.drawable.ic_menu_close_clear_cancel);
        toolbarPizza.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }
}
