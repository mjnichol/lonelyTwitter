package ca.ualberta.cs.Lonelytwitter;
import java.util.Date;

public class NormalTweet extends LonelyTweetModel {

	public NormalTweet(String text) {
		super(text);
	}

	@Override
	public void setText(String text) {

	}

	@Override
	public boolean getUrgency() {
		return false;
	}
}
