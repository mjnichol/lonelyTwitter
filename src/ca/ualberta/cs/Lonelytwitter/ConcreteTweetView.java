package ca.ualberta.cs.Lonelytwitter;

public class ConcreteTweetView implements TweetView {

	public String formatTweet(LonelyTweetModel lt) {
		return lt.getTimestamp().toString() + " | " + lt.getText();
	}

}
