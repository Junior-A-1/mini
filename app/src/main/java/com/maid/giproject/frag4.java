package com.maid.giproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;


public class frag4 extends Fragment {

    private ViewPager2 viewPager;
    private CarouselAdapter adapter;
    private List<CarouselItem> items;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private ArrayList<News> newsArrayList;


    private String[] newsHeading;
    private int[] imageResourceID;
    private RecyclerView recyclerview, recyclerview2, recyclerview3, recyclerview4, recyclerview5, recyclerview6, recyclerview7, recyclerview8, recyclerview9;
    private ScrollView scrollView;

    public frag4() {
        // Required empty public constructor
    }


    public static frag4 newInstance(String param1, String param2) {
        frag4 fragment = new frag4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag4, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        Button BTN_VIEWALL1 = view.findViewById(R.id.btn_viewall1);
        Button BTN_VIEWALL2 = view.findViewById(R.id.btn_viewall2);
        Button BTN_VIEWALL3 = view.findViewById(R.id.btn_viewall3);
        Button BTN_VIEWALL4 = view.findViewById(R.id.btn_viewall4);
        Button BTN_VIEWALL5 = view.findViewById(R.id.btn_viewall5);
        Button BTN_VIEWALL6 = view.findViewById(R.id.btn_viewall6);
        Button BTN_VIEWALL7 = view.findViewById(R.id.btn_viewall7);
        Button BTN_VIEWALL8 = view.findViewById(R.id.btn_viewall8);
        Button BTN_VIEWALL9 = view.findViewById(R.id.btn_viewall9);

        BTN_VIEWALL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), View_btn_Circket.class);

                startActivity(intent);

            }
        });
        BTN_VIEWALL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), View_btn_Tennis.class);

                startActivity(intent);

            }
        });


        BTN_VIEWALL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), View_btn_Golf.class);

                startActivity(intent);

            }
        });
        BTN_VIEWALL4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), View_btn_NPL.class);

                startActivity(intent);

            }
        });
        BTN_VIEWALL5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), View_btn_Master.class);

                startActivity(intent);

            }
        });
        BTN_VIEWALL6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), View_btn_NFL.class);

                startActivity(intent);

            }
        });

        BTN_VIEWALL7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), View_btn_Football.class);

                startActivity(intent);

            }
        });
        BTN_VIEWALL8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), View_btn_EPL.class);

                startActivity(intent);

            }
        });
        BTN_VIEWALL9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), View_btn_F1.class);

                startActivity(intent);

            }
        });
























        items = new ArrayList<>();

        items.add(new CarouselItem("Item 1", R.drawable.oo));
        items.add(new CarouselItem("Item 1", R.drawable.pp));
        adapter = new CarouselAdapter(items);
        viewPager.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialize();

        recyclerview = view.findViewById(R.id.recycler_view);
        recyclerview2 = view.findViewById(R.id.recycler_view2);
        recyclerview3 = view.findViewById(R.id.recycler_view3);
        recyclerview4 = view.findViewById(R.id.recycler_view4);
        recyclerview5 = view.findViewById(R.id.recycler_view5);
        recyclerview6 = view.findViewById(R.id.recycler_view6);
        recyclerview7 = view.findViewById(R.id.recycler_view7);
        recyclerview8 = view.findViewById(R.id.recycler_view8);
        recyclerview9 = view.findViewById(R.id.recycler_view9);

        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview3.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview4.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview5.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview6.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview7.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview8.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview9.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerview.setHasFixedSize(true);
        recyclerview2.setHasFixedSize(true);
        recyclerview3.setHasFixedSize(true);
        recyclerview4.setHasFixedSize(true);
        recyclerview5.setHasFixedSize(true);
        recyclerview6.setHasFixedSize(true);
        recyclerview7.setHasFixedSize(true);
        recyclerview8.setHasFixedSize(true);
        recyclerview9.setHasFixedSize(true);

        MyAdapter myAdapter = new MyAdapter(getContext(), newsArrayList);
        MyAdapter myAdapter2 = new MyAdapter(getContext(), newsArrayList);
        MyAdapter myAdapter3 = new MyAdapter(getContext(), newsArrayList);
        MyAdapter myAdapter4 = new MyAdapter(getContext(), newsArrayList);
        MyAdapter myAdapter5 = new MyAdapter(getContext(), newsArrayList);
        MyAdapter myAdapter6 = new MyAdapter(getContext(), newsArrayList);
        MyAdapter myAdapter7 = new MyAdapter(getContext(), newsArrayList);
        MyAdapter myAdapter8 = new MyAdapter(getContext(), newsArrayList);
        MyAdapter myAdapter9 = new MyAdapter(getContext(), newsArrayList);

        recyclerview.setAdapter(myAdapter);
        recyclerview2.setAdapter(myAdapter2);
        recyclerview3.setAdapter(myAdapter3);
        recyclerview4.setAdapter(myAdapter4);
        recyclerview5.setAdapter(myAdapter5);
        recyclerview6.setAdapter(myAdapter6);
        recyclerview7.setAdapter(myAdapter7);
        recyclerview8.setAdapter(myAdapter8);
        recyclerview9.setAdapter(myAdapter9);

        myAdapter.notifyDataSetChanged();
        myAdapter2.notifyDataSetChanged();
        myAdapter3.notifyDataSetChanged();
        myAdapter4.notifyDataSetChanged();
        myAdapter5.notifyDataSetChanged();
        myAdapter6.notifyDataSetChanged();
        myAdapter7.notifyDataSetChanged();
        myAdapter8.notifyDataSetChanged();
        myAdapter9.notifyDataSetChanged();
    }

    private void dataInitialize() {
        newsArrayList = new ArrayList<>();

        newsHeading = new String[]{
                getString(R.string.head_1),
                getString(R.string.head_2),
                getString(R.string.head_3),
                getString(R.string.head_4),
                getString(R.string.head_5),
                getString(R.string.head_6),
                getString(R.string.head_7),
                getString(R.string.head_8),
                getString(R.string.head_9),
                getString(R.string.head_10),
        };

        imageResourceID = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.h,
                R.drawable.i,
                R.drawable.j
        };

        for (int i = 0; i < newsHeading.length; i++) {
            News news = new News(newsHeading[i], imageResourceID[i]);
            newsArrayList.add(news);
        }
    }
}
