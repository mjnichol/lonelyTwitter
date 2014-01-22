package ca.ualberta.cs.Lonelytwitter;
import java.util.Date;

public class NormalTweetModel extends LonelyTweetModel {

	public NormalTweetModel(String text) {
		super(text);
	}
	public NormalTweetModel() {
		super();
	}
	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean getUrgency() {
		return false;
	}
}
