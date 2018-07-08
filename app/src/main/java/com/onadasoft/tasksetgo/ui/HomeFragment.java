/*
 * Created by Ahmed Karim on 07/07/18 15:50
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 27/06/18 13:31
 */

package com.onadasoft.tasksetgo.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onadasoft.tasksetgo.R;
import com.onadasoft.tasksetgo.db.entity.ListEntity;
import com.onadasoft.tasksetgo.db.entity.TaskEntity;
import com.onadasoft.tasksetgo.viewmodel.ListViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ListViewModel mListViewModel;

    private TextView textTest;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        textTest = view.findViewById(R.id.test_text1);


        mListViewModel = ViewModelProviders.of(this).get(ListViewModel.class);

        mListViewModel.getLists().observe(this, new Observer<List<ListEntity>>() {
            @Override
            public void onChanged(@Nullable List<ListEntity> listEntities) {
                if(listEntities==null){
                    Log.i("LIST_TEST", "List is null");
                }else{

                    int test = listEntities.size();

                    Log.i("LIST_TEST", "List size "+test);

                    for(ListEntity list : listEntities){
                        Log.i("LIST_TEST", "List: "+list.getName());
                    }

                }
            }
        });

        return view;
    }

}
