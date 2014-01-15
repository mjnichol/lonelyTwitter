package ca.ualberta.cs.Lonelytwitter;

import java.util.Date;

public class ImportantTweetModel extends LonelyTweetModel {

	public ImportantTweetModel(String text, Date timestamp) {
		super(text, timestamp);
		}

	public ImportantTweetModel(String text) {
		super(text);
	}
	
	public void setText(String text){
		this.text = text;
	}

	@Override
	public boolean getUrgency() {
		return true;
	}
}
