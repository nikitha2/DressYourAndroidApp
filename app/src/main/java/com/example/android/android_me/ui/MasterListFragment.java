package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.data.SharedViewModel;


public class MasterListFragment extends Fragment {
    int headIndex=-1;
    int bodyIndex=-1;
    int legIndex=-1;
    onImageClickListener onItemClickListener;
    SharedViewModel model;
    ImageView tick;
    public MasterListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            onItemClickListener= (onImageClickListener)context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnImageClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView listView = (GridView) view.findViewById(R.id.list);
        MasterListAdapter masterListAdapter=new MasterListAdapter(view.getContext(), AndroidImageAssets.getAll());

        listView.setAdapter(masterListAdapter);

        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClickListener.onListItemClickReviews(position);
            }
        });
        return view;
    }

    interface onImageClickListener {
        void onListItemClickReviews(int position);
    }
}