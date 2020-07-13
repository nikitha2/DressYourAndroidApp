package com.example.android.android_me.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BodyPart_legs_Fragment extends Fragment {
    final String IMAGEID_INDEX="IMAGEID_index";
    final String IMAGE_ID="IMAGEID";

    int imageid=0;

    public BodyPart_legs_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            imageid=savedInstanceState.getInt(IMAGEID_INDEX);
        }

        // Inflate the layout for this fragment
        View rootView=  inflater.inflate(R.layout.fragment_body_part_legs, container, false);

        final ImageView fragment_body_id=(ImageView)rootView.findViewById(R.id.fragment_legs_id);

        setImage(fragment_body_id);
        fragment_body_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageid++;
                setImage(fragment_body_id);
            }
        });
        return rootView;
    }

    private void setImage(ImageView fragment_body_id) {
        int listSize = AndroidImageAssets.getHeads().size();
        if (0 <= imageid && imageid < listSize) {

        } else {
            imageid=0;
        }
        fragment_body_id.setImageResource(AndroidImageAssets.getLegs().get(imageid));
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState) {
        super.onSaveInstanceState(currentState);
        currentState.putInt(IMAGEID_INDEX,imageid);
        currentState.putIntegerArrayList(IMAGE_ID, (ArrayList<Integer>) AndroidImageAssets.getLegs());

    }
}