package com.wyrhero.demo.di.impl;

import com.wyrhero.demo.di.CompactDisc;
import com.wyrhero.demo.di.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wyrhero on 2017/6/26.
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;


    public CDPlayer(){};

    public CDPlayer(CompactDisc compectDisc){
        this.cd = compectDisc;
    };

    @Override
    public void play() {
        cd.play();
    }
}

