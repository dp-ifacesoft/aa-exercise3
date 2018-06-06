package com.example.dp.aa_exercise3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = this.findViewById(R.id.list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new CatListAdapter(this));
    }

    public class Cat {
        private final String url;

        Cat(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    public class CatHolder extends RecyclerView.ViewHolder {
            ImageView cat;


        CatHolder(View itemView) {
            super(itemView);

            this.cat = itemView.findViewById(R.id.cat);
        }

        public ImageView getCat() {
            return cat;
        }
    }

    public class CatListAdapter extends RecyclerView.Adapter {

        private List<Cat> catList = new ArrayList<>();
        LayoutInflater layoutInflater;

        CatListAdapter(Context context) {
            this.catList.add(new Cat("https://mtdata.ru/u28/photo96CE/20466331848-0/original.jpg"));
            this.catList.add(new Cat("http://bipbap.ru/wp-content/uploads/2017/08/5114e7b13c84a77355cbec162ca7ff45.jpg"));
            this.catList.add(new Cat("http://bipbap.ru/wp-content/uploads/2017/09/2189909404.jpg"));
            this.catList.add(new Cat("http://kakzachem.ru/wp-content/uploads/2018/01/Bez-imeni-2-8.jpg"));
            this.catList.add(new Cat("https://static2.shop033.com/resources/18/160536/picture/5D/85442141.jpg"));
            this.catList.add(new Cat("https://gloss.ua/file/t/17/11/28/bqeye_640x360.jpg"));
            this.catList.add(new Cat("https://obovsem.pp.ua/wp-content/uploads/kotiki-31.jpg"));
            this.catList.add(new Cat("https://www.telegraph.co.uk/content/dam/pets/2017/01/06/1-JS117202740-yana-two-face-cat-news_trans_NvBQzQNjv4BqJNqHJA5DVIMqgv_1zKR2kxRY9bnFVTp4QZlQjJfe6H0.jpg?imwidth=450"));
            this.catList.add(new Cat("https://www.kedisahiplendirme.com/wp-content/uploads/2018/04/Scottish-Fold.jpg"));
            this.catList.add(new Cat("http://honesttopaws.com/wp-content/uploads/sites/5/2017/05/banana-cat-1.png"));
            this.catList.add(new Cat("http://www.catster.com/wp-content/uploads/2017/10/A-kitten-meowing-with-his-mouth-open.jpg"));
            this.catList.add(new Cat("https://static.euronews.com/articles/432451/603x339_432451.jpg"));

            this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CatHolder(layoutInflater.inflate(R.layout.cat_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Picasso.get().load(this.catList.get(position).getUrl()).into(((CatHolder)holder).getCat());
        }

        @Override
        public int getItemCount() {
            return catList.size();
        }
    }
}
