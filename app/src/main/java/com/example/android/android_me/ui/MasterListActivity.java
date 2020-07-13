package com.example.android.android_me.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MasterListActivity extends AppCompatActivity implements MasterListFragment.onImageClickListener {
String LOG_TAG=MasterListActivity.class.getSimpleName();
    private int head_position;
    private int body_position;
    private int tail_position;
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_list_layout);

        if(findViewById(R.id.doublePainLayout) != null) {
            mTwoPane=true;
            GridView gridView = (android.widget.GridView) findViewById(R.id.list);
            gridView.setNumColumns(2);

            if(savedInstanceState==null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                final BodyPart_head_Fragment bodyPart_head_fragment = new BodyPart_head_Fragment();
                final BodyPart_body_Fragment bodyPart_body_fragment = new BodyPart_body_Fragment();
                final BodyPart_legs_Fragment bodyPart_legs_fragment = new BodyPart_legs_Fragment();

                fragmentTransaction.add(R.id.FrameLayout_head, bodyPart_head_fragment);
                fragmentTransaction.add(R.id.FrameLayout_body, bodyPart_body_fragment);
                fragmentTransaction.add(R.id.FrameLayout_legs, bodyPart_legs_fragment);
                fragmentTransaction.commit();
            }
        }
        else{
            mTwoPane=false;
        }

    }

    @Override
    public void onListItemClickReviews(int position) {
        Toast.makeText(this,"clicked on pos="+position,Toast.LENGTH_SHORT).show();
        int bodypart= position/12;
        int listIndex=position-12*bodypart;

        if(mTwoPane){
            switch (bodypart) {
                case 0:
                    final BodyPart_head_Fragment bodyPart_head_fragment = new BodyPart_head_Fragment();
                    head_position = listIndex;
                    bodyPart_head_fragment.setImageid(head_position);
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_head, bodyPart_head_fragment).commit();break;
                case 1:
                    final BodyPart_body_Fragment bodyPart_body_fragment = new BodyPart_body_Fragment();
                    bodyPart_body_fragment.setImageid(body_position);
                    body_position = listIndex;
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_body, bodyPart_body_fragment).commit();break;
                case 2:
                    final BodyPart_legs_Fragment bodyPart_legs_fragment = new BodyPart_legs_Fragment();
                    tail_position = listIndex;
                    bodyPart_legs_fragment.setImageid(tail_position);
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_legs, bodyPart_legs_fragment).commit();break;
                default:
            }
        }
        else{
            switch (bodypart){
                case 0:head_position = listIndex ;break;
                case 1:body_position=listIndex;break;
                case 2:tail_position=listIndex;break;
                default:
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(!mTwoPane) {
            getMenuInflater().inflate(R.menu.menu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.next:
                Intent intent = new Intent(this,AndroidMeActivity.class);
                intent.putExtra("head_position",head_position);
                intent.putExtra("body_position",body_position);
                intent.putExtra("tail_position",tail_position);
                startActivity(intent);
        }
     return true;
    }

}