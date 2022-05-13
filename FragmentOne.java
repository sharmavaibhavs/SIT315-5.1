package com.example.News;

import static com.example.tourismapp.R.id.recycler;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {
    RecyclerView newsRecyclerView;
    relatedNewsAdapter relatedNewsAdap;
    List<FragmentRecyclerModel> newsList = new ArrayList<>();


    private static final String ARG_NAME = "pName";
    private static final String ARG_DESCRIPTION = "pDesc";
    private static final String ARG_IMAGE = "pImg";
    private static final String ARG_ID = "pID";

    private String address;
    private String name;
    private String description;
    private Integer id;
    private Integer image;

    public FragmentOne()
    {

    }

    public static FragmentOne newInstance(int id, int image, String address, String name, String description) {
        FragmentOne fragment = new FragmentOne();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, id);
        args.putInt(ARG_IMAGE, image);

        args.putString(ARG_NAME, name);
        args.putString(ARG_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            description = getArguments().getString(ARG_DESCRIPTION);
            image = getArguments().getInt(ARG_IMAGE);
            id = getArguments().getInt(ARG_ID);
        }



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        ImageView fragmentImage = view.findViewById(R.id.imageView);
        TextView fragmentName = view.findViewById(R.id.nameTextView2);
        TextView fragmentDescription = view.findViewById(R.id.descriptionTextView2);
        fragmentImage.setImageResource(image);
        fragmentName.setText(name);
        fragmentDescription.setText(description);

        RecyclerView recyclerView= view.findViewById(recycler);

        Integer[] imageList  = {R.drawable.news1,R.drawable.news2 , R.drawable.news3, R.drawable.news4};
        String[] Headline = {"Senior Melbourne doctor quits, warning of staff burnout ahead of triple zero report release",
                "NSW government pushes ahead with new train fleet despite safety concerns",
                "Superyacht owner arrested over alleged role in cocaine bust",
                "Horse-drawn carriages to be banned from Melbourne's CBD"};
        for(int i=0; i<imageList.length;i++)
        {
            newsList.add(new FragmentRecyclerModel(Headline[i], imageList[i]));
        }
        fragmentAdapter adapter =  new fragmentAdapter(getContext() , (ArrayList<FragmentRecyclerModel>) newsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), recyclerView.VERTICAL,false));







        return view;
    }


}