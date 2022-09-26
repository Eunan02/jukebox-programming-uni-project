package part01;

import java.util.ArrayList;

/**
 * 
 * @author eunan Diamond @StudentNumber 40293751 Date 11/11/2020
 *This interface is used to ensure Jukebox uses these methods
 */
public interface IJukebox {
	public String getTrackList();
	public boolean playTrack(AudioTrack trk);
	public String shuffle(ArrayList<AudioTrack> list);
	public void addTrack(AudioTrack trk);
	public AudioTrack[] getTracks();
}
