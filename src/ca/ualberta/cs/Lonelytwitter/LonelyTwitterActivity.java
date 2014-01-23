package ca.ualberta.cs.Lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import ca.ualberta.cs.lonelytwitter.R;

import com.google.gson.Gson;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> tweet_list;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				saveInFile(text, new Date(System.currentTimeMillis()));
				
				//onStart();
				tweet_list.add(new Date().toString() + " | " + text + "\n");
				
				/*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
						R.layout.list_item, tweets);*/
				adapter.notifyDataSetChanged();
				
				
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		tweet_list = loadFromFile();
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweet_list);
		
		/*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);*/
		oldTweetsList.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}

	/* We want to turn all of the strings into loenly tweet models */
	private ArrayList<String> loadFromFile() {
		
		//ArrayList<NormalTweetModel> tweets = new ArrayList<NormalTweetModel>();
		ArrayList<String> tweets = new ArrayList<String>();
		//TweetListModel tweets = new TweetListModel();
		Gson gsonTweet = new Gson();
		try {
			
			
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
		
			String line = in.readLine();
			
			tweets.add(line);
			//tweeter = gsonTweet.fromJson(isr, LonelyTweetModel.class);
			
		
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* try and unpack the JSON */
		
		
		return tweets;
	}
	
	private void saveInFile(String text, Date date) {
	
		Gson gsonTweet = new Gson();
		NormalTweetModel tweeter = new NormalTweetModel(date.toString() + " | " + text + "\n");
		tweeter.setTimestamp(date);
		String json = gsonTweet.toJson(tweeter);
		
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(json.getBytes());
			//fos.write(new String(date.toString() + " | " + text +"\n").getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}