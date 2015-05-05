package com.utest.googplay.utils.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.utest.googleplay.utils.DataExtractor;

public class DataExtraxtorTest {
	
	@Test
    public void getStarsFromText() {
         assertEquals(3.9, DataExtractor.getStarsFromText(" Rated 3.9 stars out of five stars"), 0);
	}
    	
	@Test
    public void getStarCountFromText() {
         assertEquals(219, DataExtractor.getStarCountFromText("(219)"), 0);
    }

}
