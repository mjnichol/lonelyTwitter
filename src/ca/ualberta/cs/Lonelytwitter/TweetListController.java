package ca.ualberta.cs.Lonelytwitter;

import java.util.ArrayList;

public class TweetListController {
	private static TweetListModel tweetListModel = null;

	public TweetListController() {
		super();
		if (tweetListModel == null){
			tweetListModel = new TweetListModel();
		}
	}

	public void addTweet(String text){
		LonelyTweetModel lt = new NormalTweetModel(text);
		ArrayList<LonelyTweetModel> list = tweetListModel.getList();
		list.add(lt);
		
	}

}
