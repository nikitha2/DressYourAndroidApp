/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.android.android_me.R;
import com.example.android.android_me.data.ItemDataIndex;
import com.example.android.android_me.data.SharedViewModel;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    private FrameLayout FrameLayout_head;
    private FrameLayout FrameLayout_body;
    private FrameLayout FrameLayout_legs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        final BodyPart_head_Fragment bodyPart_head_fragment = new BodyPart_head_Fragment();
        final BodyPart_body_Fragment bodyPart_body_fragment = new BodyPart_body_Fragment();
        final BodyPart_legs_Fragment bodyPart_legs_fragment = new BodyPart_legs_Fragment();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        bodyPart_head_fragment.setImageid(extras.getInt("head_position"));
        bodyPart_body_fragment.setImageid(extras.getInt("body_position"));
        bodyPart_legs_fragment.setImageid(extras.getInt("tail_position"));
        if(savedInstanceState==null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.FrameLayout_head, bodyPart_head_fragment);
            fragmentTransaction.add(R.id.FrameLayout_body, bodyPart_body_fragment);
            fragmentTransaction.add(R.id.FrameLayout_legs, bodyPart_legs_fragment);
            fragmentTransaction.commit();
        }
    }
}
