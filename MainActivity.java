package com.example.News;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements relatedNewsAdapter.OnRowClickListener{

    RecyclerView newsRecyclerView;
    RecyclerView topNewsRecycler;
    relatedNewsAdapter relatedNewsAdap;
    TopNewsAdapter newsAdap;

    List<relatedNews> newList = new ArrayList<>();
    List<TopNews> topNewsList = new ArrayList<>();

    Integer[] imageList  = {R.drawable.news1,R.drawable.news2 , R.drawable.news3, R.drawable.news4, R.drawable.news5, R.drawable.news6 , R.drawable.news7, R.drawable.news8};
    Integer[] topImageList ={R.drawable.news1,R.drawable.news2 , R.drawable.news3, R.drawable.news4, R.drawable.news5, R.drawable.news6 , R.drawable.news7, R.drawable.news8};
    String[] Headline = {"Senior Melbourne doctor quits, warning of staff burnout ahead of triple zero report release",
            "NSW government pushes ahead with new train fleet despite safety concerns",
            "Superyacht owner arrested over alleged role in cocaine bust",
            "Horse-drawn carriages to be banned from Melbourne's CBD",
            "Legal proceedings begin against waste company after complaints about 'bad egg' smell",
            "Health warning issued for mosquito-borne viruses in Sydney",
            "Emergency flood warnings declared in several south-east Queensland regions as wet weather set to continue",
            "Queensland to review hundreds of HomeBuilder applications after satellite image bungle"};
    String[] newsDescription = {"A senior Melbourne doctor at The Alfred hospital has resigned over what he says are \"deteriorating conditions\" in Victoria\'s healthcare system .Professor John Wilson warned lives were at risk if healthcare workers were continually pushed beyond their limits. The call came after a busy two years for the state\'s healthcare system, including a code brown being declared earlier this year, which prohibited staff from taking leave.",
        "News Detail 2",
        "News Detail 3",
        "News detail 5",
        "A senior Melbourne doctor at The Alfred hospital has resigned over what he says are \"deteriorating conditions\" in Victoria\'s healthcare system .Professor John Wilson warned lives were at risk if healthcare workers were continually pushed beyond their limits. The call came after a busy two years for the state\'s healthcare system, including a code brown being declared earlier this year, which prohibited staff from taking leave.",
        "News Detail 6",
        "News Detail 7",
        "News Detail 8"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsRecyclerView = findViewById(R.id.newsRecyclerView);
        topNewsRecycler = findViewById(R.id.topNewsRecyclerView);

        relatedNewsAdap = new relatedNewsAdapter(newList,MainActivity.this,this);
        newsRecyclerView.setAdapter(relatedNewsAdap);
        newsAdap = new TopNewsAdapter(topNewsList,MainActivity.this);
        topNewsRecycler.setAdapter(newsAdap);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        newsRecyclerView.setLayoutManager(mLayoutManager);
        topNewsRecycler.setLayoutManager(layoutManager2);

        for (int i = 0; i< imageList.length; i++){

            relatedNews m = new relatedNews(i,imageList[i], Headline[i], newsDescription[i]);
            newList.add(m);
        }
        for (int i = 0; i< topImageList.length; i++){
            TopNews destination = new TopNews(i,topImageList[i]);
            topNewsList.add(destination);
        }

    }

    @Override
    public void onItemClick(int position) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);


        ConstraintLayout myView =  findViewById(R.id.container);
        myView.setVisibility(View.GONE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentOne f = new FragmentOne();
        Bundle bundle = new Bundle();
        bundle.putInt("pID", position );
        bundle.putInt("pImg", imageList[position] );
        bundle.putString("pName", Headline[position]);
        bundle.putString("pDesc", newsDescription[position]);
        f.setArguments(bundle);


        fragmentTransaction.add(R.id.main,f);
        fragmentTransaction.commit();

    }

}