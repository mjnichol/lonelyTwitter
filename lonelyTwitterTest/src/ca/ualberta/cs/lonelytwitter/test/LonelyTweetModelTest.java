package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import android.test.ActivityInstrumentationTestCase2;


public class LonelyTweetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

		public LonelyTweetModelTest(){
			super(LonelyTwitterActivity.class);
		}
		
		public void testFailure(){
			//fail("failure!");
			assertEquals("Does 5 equal 5?", 5, 5);
		}
}
