package com.minahatami.audiomanager;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tvVolume;
	int volValue = 6;
	AudioManager audioManager;
	MediaPlayer myPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvVolume = (TextView) findViewById(R.id.textView1);
		tvVolume.setText("" + volValue);

		myPlayer = MediaPlayer.create(this, R.raw.slow_whoop_bubble_pop);

	}

	public void downVolumeClick(View view) {
		if (volValue > 0) {
			volValue -= 2;
		}
		tvVolume.setText("" + volValue);
		
		float volume = (float)volValue/10 ;
		Log.v("Volume", "Volume is: " + volume);
		myPlayer.setVolume(volume, volume);
	}

	public void upVolumeClick(View view) {
		if (volValue < 10) {
			volValue += 2;
		}
		tvVolume.setText("" + volValue);
		
		float volume = (float)volValue/10 ;
		Log.v("Volume", "Volume is: " + volume);
		myPlayer.setVolume(volume, volume);
	}

	public void playClick(View view) {
		myPlayer.start();
	}

}
