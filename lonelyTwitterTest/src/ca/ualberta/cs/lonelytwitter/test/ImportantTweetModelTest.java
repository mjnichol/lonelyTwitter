package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

public class ImportantTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public ImportantTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}

	public void testFailure(){
		
		
		Date d1 = new Date();  // time now
		Date d2 = new Date(0); // time at epoch
		
		ImportantTweetModel imp_tweet = new ImportantTweetModel("heyo", d1);
		NormalTweetModel norm_tweet = new NormalTweetModel("oi", d1);
		
		assertEquals("Normal Tweet Model shouldn't be a normal tweet model", false, norm_tweet.equals(imp_tweet));
		assertEquals("Important tweet should not be an important tweet if the text does not match", false, imp_tweet.equals(new ImportantTweetModel("sup?")));
		assertEquals("Important tweet should equal itself", true, imp_tweet.equals(imp_tweet));
		
		// Normal tweet tests
		assertEquals("should fail if the text is the same, but timestamp is different", false, norm_tweet.equals(new NormalTweetModel("oi",d2)));
		assertEquals("should fail if the text is the different, but timestamp is same", false, norm_tweet.equals(new NormalTweetModel("clown time fun",d1)));
		assertEquals("should pass if the text is the same, but timestamp is same", true, norm_tweet.equals(new NormalTweetModel("oi",d1)));

		// Important tweet tests
		assertEquals("should fail if the text is the same, but timestamp is different", false, imp_tweet.equals(new ImportantTweetModel("heyo",d2)));
		assertEquals("should fail if the text is the different, but timestamp is same", false, imp_tweet.equals(new ImportantTweetModel("clown time fun",d1)));
		assertEquals("should pass if the text is the same, but timestamp is same", true, imp_tweet.equals(new ImportantTweetModel("heyo",d1)));
	}
}
