package ca.ualberta.cs.lonelytwitter.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetSetModel;

public class TweetSetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetSetModelTest() {
		super(LonelyTwitterActivity.class);
	}

	public void testCount(){
		TweetSetModel tweets = new TweetSetModel();
		assertEquals("tweet set should start empty", 0, tweets.countTweets());

	}
	
	public void testAddTweet(){
		TweetSetModel tweets = new TweetSetModel();
		tweets.addTweet(new NormalTweetModel("test"));
		final NormalTweetModel t1 = new NormalTweetModel("something");
		
		tweets.addTweet(t1);
		
		assertEquals("GetTweets returns an array list, we added a tweet so it should't be null", true, (tweets.getTweetList()) != null);
		
		try{
			tweets.addTweet(t1);
			fail();
			
		}
		catch(IllegalArgumentException e){
			// success
		}
		
		try{
			tweets.addTweet(new NormalTweetModel("should pass"));
		}
		catch(IllegalArgumentException e){
			fail();
		}
	
	}
}
