package com.minahatami.audiomanager;

import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tvVolume;
	int volValue = 6;
	AudioManager audioManager;
	MediaPlayer myPlayer;
	Button btPlay, btStop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btPlay = (Button) findViewById(R.id.btPlay);
		btStop = (Button) findViewById(R.id.btStop);

		tvVolume = (TextView) findViewById(R.id.textView1);
		tvVolume.setText("" + volValue);

		myPlayer = MediaPlayer.create(this, R.raw.shekeitoff);

	}

	public void downVolumeClick(View view) {
		if (volValue > 0) {
			volValue -= 2;
		}
		tvVolume.setText("" + volValue);
		setVolumeLevel(volValue);

	}

	public void upVolumeClick(View view) {
		if (volValue < 10) {
			volValue += 2;
		}
		tvVolume.setText("" + volValue);
		setVolumeLevel(volValue);
	}

	public void playClick(View view) throws IllegalStateException, IOException {
		if (!myPlayer.isPlaying() && btPlay.isEnabled()) {
			
			myPlayer.start();
			btPlay.setEnabled(false);
			btStop.setEnabled(true);
		}
		
	}

	public void stopClick(View view) throws IllegalStateException, IOException {
		if (myPlayer.isPlaying() && btStop.isEnabled()) {
			myPlayer.stop();
			btStop.setEnabled(false);
			btPlay.setEnabled(true);
		}
	}
	
	

	public void setVolumeLevel(int volValue) {
		float volume = (float) volValue / 10;
		Log.v("Volume", "Volume is: " + volume);
		myPlayer.setVolume(volume, volume);
	}
}
