package com.example.recyclerview25022020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerviewUser;
    UserAdapter mUserAdapter;
    ArrayList<User> mUserArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerviewUser = findViewById(R.id.recyclerview);
        mUserArrayList = new ArrayList<>();
        mUserAdapter = new UserAdapter();
        mRecyclerviewUser.setItemViewCacheSize(20);
        mRecyclerviewUser.setHasFixedSize(true);
        mRecyclerviewUser.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerviewUser.setAdapter(mUserAdapter);

        // Cập nhật dữ liệu
        mUserArrayList.add(new User("Nguyen Van A",10,R.mipmap.ic_launcher_round));
        mUserArrayList.add(new User("Nguyen Van B",11,R.mipmap.ic_launcher_round));
        mUserArrayList.add(new User("Nguyen Van C",12,R.mipmap.ic_launcher_round));
        mUserArrayList.add(new User("Nguyen Van D",13,R.mipmap.ic_launcher_round));
        mUserArrayList.add(new User("Nguyen Van E",14,R.mipmap.ic_launcher_round));
        mUserArrayList.add(new User("Nguyen Van F",15,R.mipmap.ic_launcher_round));
        mUserArrayList.add(new User("Nguyen Van G",16,R.mipmap.ic_launcher_round));
        mUserArrayList.add(new User("Nguyen Van H",17,R.mipmap.ic_launcher_round));
        mUserArrayList.add(new User("Nguyen Van E",18,R.mipmap.ic_launcher_round));
        mUserArrayList.add(new User("Nguyen Van K",19,R.mipmap.ic_launcher_round));
        mUserArrayList.add(new User("Nguyen Van M",20,R.mipmap.ic_launcher_round));

        mUserAdapter.submitData(mUserArrayList);

        mUserAdapter.setOnItemClickListener(new OnListenerClickItem() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, mUserArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        mUserAdapter.addItem(new User("Nguyen Van N",21,R.mipmap.ic_launcher_round));

    }
}
