package com.khai.crud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.khai.crud.R;
import com.khai.crud.api.ApiClient;
import com.khai.crud.api.RestInteface;
import com.khai.crud.constant.AppConstant;
import com.khai.crud.model.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Product product;
    TextView tv_id;
    TextView tv_title;
    TextView tv_price;
    Button btn_fetch;
    RestInteface restInteface ;
    Retrofit retrofit = ApiClient.getClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restInteface = retrofit.create(RestInteface.class);
        initData();
        getData();

    }

    public void initData(){
        tv_id = findViewById(R.id.pro_content_id);
        tv_title = findViewById(R.id.pro_content_title);
        tv_price = findViewById(R.id.pro_content_price);
    }

    public void getData(){
        btn_fetch = findViewById(R.id.btn_fetch);
        btn_fetch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Call<Product> call = restInteface.getById("1");
                call.enqueue(new Callback<Product>() {
                    @Override
                    public void onResponse(Call<Product> call, Response<Product> response) {
                        product = response.body();
                        tv_id.setText(product.getId().toString());
                        tv_price.setText(product.getPrice().toString());
                        tv_title.setText(product.getTitle());
;                    }

                    @Override
                    public void onFailure(Call<Product> call, Throwable t) {
                        Log.d("content123","failuree");
                    }
                });
            }
        });
    }
}