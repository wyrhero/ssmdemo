package com.wyrhero.demo.di;

import com.wyrhero.demo.di.config.CDPlayerConfig;
import com.wyrhero.demo.di.impl.CDPlayer;
import jdk.nashorn.internal.ir.annotations.Ignore;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by wyrhero on 2017/6/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;

    @Autowired
    private CDPlayer cdPlayer;

   @Autowired
    private MediaPlayer player;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }


    @Test
    public void play() {
        player.play();
        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\r\n",log.getLog());
    }





}
