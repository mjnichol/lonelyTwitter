package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetSetModel {
	
	private int count = 0;
	private ArrayList<LonelyTweetModel> tweetList;
	
	public TweetSetModel() {
		super();
		tweetList = new ArrayList<LonelyTweetModel>();
	}

	public int countTweets() {
		return count;
	}

	public void addTweet(NormalTweetModel normalTweetModel) throws IllegalArgumentException{
		count++;
		
		for(LonelyTweetModel tweet: tweetList){
			if( tweet.equals(normalTweetModel))
				throw new IllegalArgumentException();
		}
		tweetList.add(normalTweetModel);
	}

	// added as desired!
	public ArrayList<LonelyTweetModel> getTweetList() {
		return tweetList;
	}

}
