package com.example.javi.forniteuservice;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.example.javi.forniteuservice.ForniteStadistics.ForniteRank;
import com.example.javi.forniteuservice.ForniteStadistics.ForniteStats;
import com.example.javi.forniteuservice.ForniteStadistics.ForniteViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nick_name_fornite;
    private Spinner spinner_plataform;
    private MyAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton buttonGo;
    private ForniteViewModel forniteViewModel;
    private String plattaform;
    private String epic_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nick_name_fornite = findViewById(R.id.nick_name_fornite);
        spinner_plataform = findViewById(R.id.spinner_plataform);
        buttonGo = findViewById(R.id.buttonGo);

        changeData("","");

        ckickbuttongo();

        setTitle("Fortnite");
    }

    private void changeData(String plattaform,String epic_nickname){
        forniteViewModel = ViewModelProviders.of(this).get(ForniteViewModel.class);
        forniteViewModel.dataFornite.observe(this, stadisticObjectData -> {
            if(stadisticObjectData!=null){
                Log.d("ServicioFornite","Cambios: "+stadisticObjectData);
                generateForniteList(stadisticObjectData);
            }
        });
        forniteViewModel.getData(plattaform, epic_nickname);
    }

    private void generateForniteList(List<ForniteRank> listFornite) {
        recyclerView = findViewById(R.id.recycleview_fornite);
        adapter = new MyAdapter(listFornite);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void ckickbuttongo(){
        buttonGo.setOnClickListener(v -> {
            plattaform = spinner_plataform.getSelectedItem().toString();
            epic_nickname = nick_name_fornite.getText().toString();
            Log.d("Cambio","plataforma "+plattaform+" epic_name "+epic_nickname);
            forniteViewModel.getData(plattaform, epic_nickname);
            setTitle(epic_nickname);
        });

    }
}
