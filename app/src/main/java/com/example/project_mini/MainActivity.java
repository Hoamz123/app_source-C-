package com.example.project_mini;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_mini.Data.Agrt;
import com.example.project_mini.Model.Des;
import com.example.project_mini.Model.FragmentToViewCode;
import com.example.project_mini.Model.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.onItemListener{


    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Des> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        initData();

        adapter = new MyAdapter(list,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        adapter.setOnItemListener(this);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    private void initData() {
        list = new ArrayList<>();
        int size = Agrt.name_Ag.size();
        for(int i=0;i<size;i++){
            list.add(new Des(Agrt.name_Ag.get(i),Agrt.complexity.get(i),Agrt.code_detail.get(i)));
        }
    }

    private void initView() {
        recyclerView = findViewById(R.id.rcView);
    }

    @Override
    public void onItemSelect(int pos) {
        //da co vi tri cua item am user bam vao
        int imgId = list.get(pos).getImg();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, FragmentToViewCode.newInstance(imgId));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}