package com.wyrhero.demo.di.config;

import com.wyrhero.demo.di.CompactDisc;
import com.wyrhero.demo.di.impl.CDPlayer;
import com.wyrhero.demo.di.impl.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by wyrhero on 2017/6/27.
 */
@Configuration
//@ComponentScan(basePackages = "com.wyrhero.demo.di")
public class CDPlayerConfig {

    //@Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    //@Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);

    }

}

