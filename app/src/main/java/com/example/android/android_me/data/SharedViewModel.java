package com.example.android.android_me.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

    public class SharedViewModel  extends ViewModel{
        private final MutableLiveData<ItemDataIndex> selected = new MutableLiveData<ItemDataIndex>();

        public void select(ItemDataIndex ItemDataIndex) {
            selected.setValue(ItemDataIndex);
        }

        public LiveData<ItemDataIndex> getSelected() {
            return selected;
        }
    }

