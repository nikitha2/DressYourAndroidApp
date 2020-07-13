package com.example.android.android_me.data;

public class ItemDataIndex {
    int headIndex;
    int bodyIndex;
    int legIndex;

    public ItemDataIndex(int headIndex, int bodyIndex, int legIndex) {
        this.headIndex = headIndex;
        this.bodyIndex = bodyIndex;
        this.legIndex = legIndex;
    }
    public ItemDataIndex(){

    }
    public int getHeadIndex() {
        return headIndex;
    }

    public void setHeadIndex(int headIndex) {
        this.headIndex = headIndex;
    }

    public int getBodyIndex() {
        return bodyIndex;
    }

    public void setBodyIndex(int bodyIndex) {
        this.bodyIndex = bodyIndex;
    }

    public int getLegIndex() {
        return legIndex;
    }

    public void setLegIndex(int legIndex) {
        this.legIndex = legIndex;
    }

}
