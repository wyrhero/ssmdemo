package com.wyrhero.demo.di.impl;

import com.wyrhero.demo.di.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * Created by wyrhero on 2017/6/26.
 */

//自动装配的时候使用
 @Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
