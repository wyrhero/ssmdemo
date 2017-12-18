package com.wyrhero.demo.di.impl;

import com.wyrhero.demo.di.CompactDisc;

/**
 * Created by wyrhero on 2017/7/1.
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    public BlankDisc(String title,String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing " + artist + " by " + artist);
    }
}
