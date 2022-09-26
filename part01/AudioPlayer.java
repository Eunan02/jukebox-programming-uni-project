package part01;
/**
 * @author  Eunan Diamond  @StudentNumber:40293751 @Date:5/11/2020
 *This is an object class. It is used to declare a AudioPlayer, with the necessary variables and methods.
 *It has an association relationship with Jukebox
 *This class is used as simulation of playing the track using the play method by setting the currentTrack
 */
public class AudioPlayer implements IPlayer {//implementing IPlayer ensures it uses all the methods within that interface
private AudioTrack currentTrack;//this is used to simulate the song playing in the AudioPlayer
public AudioPlayer() {//constructor, which takes no parameters
//instancing the variable
	this.currentTrack=null;
}
/**
 * 
 * @param trk- passes in the AudioTrack from the consoleapp which had already been verifed as a valid Track in the jukebox playTrack method
 * this is set as the currentTrack, therefore simulating it playing and then it is return true, which is passed back to the console app from the Jukebox
 * playTrack allowing the user to see that the track has been played with it's details 
 * @return
 */
public boolean play(AudioTrack trk) {

	this.currentTrack=trk;//setting the current Track to the Track just played
	return true;
}
/**
 * This method is used to get the Current Track which has been set in the play method
 * @return current Track-this is needed for testing to prove that the currentTrack was set
 */
public AudioTrack getCurrentTrack() {
	return this.currentTrack;
}
}
