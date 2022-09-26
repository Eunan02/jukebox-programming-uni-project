package part02;

import part01.AudioPlayer;
import part01.AudioTrack;
/**
 * 
 * @author Eunan Diamond @StudentNumber:40293751 @Date:5/11/2020
 *This is an object class. It is used to declare a MP3Player, with the necessary variables and methods.
 *It is a subclass of AudioPlayer relationship
 *This class is used to check if a track has the valid encoding to play
 *
 */
public class MP3Player extends AudioPlayer {
//private String encoding;
public MP3Player() {
	super();
}

/**
 * This method is overridng the method from AudioTrack as same name and same parameter, it is used to check if the track passed in is a valid for 
 * the mp3 player and if so the track will play and currentTrack will be set my calling this method in super class
 */
@Override
public boolean play(AudioTrack trk) {
	if (trk.getEncoding().equalsIgnoreCase("mp3")) {
		super.play(trk);//this will set the currentTrack by calling this method in super class AudioPlayer
		return true;
		
	}
	else return false;
}
}
