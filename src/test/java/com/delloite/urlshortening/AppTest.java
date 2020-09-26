package com.delloite.urlshortening;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deloitte.urlshortening.App;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest{

    /**
     * Test Main :-)
     */
	@Test(expected = NullPointerException.class)
    public void mainTest()
    {
        String[] args = new String[1];
        App.main(args);
    }
}
