package part03;
import java.util.ArrayList;

import part01.*;
public class JukeboxIntegrationTesting {
public static void testCase30() {
	//testing that a jukebox instance can be created, without error
	AudioPlayer myAudioPlayer=new AudioPlayer();//instancing an audioplayer instance as it is needed to create an instance of Jukebox
	Jukebox myJukebox=new Jukebox(myAudioPlayer);
}
public static void testCase31() {
	//check if you are able to add a track
	AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	AudioPlayer myAudioPlayer=new AudioPlayer();//instancing an audioplayer instance as it is needed to create an instance of Jukebox
	Jukebox myJukebox=new Jukebox(myAudioPlayer);
	myJukebox.addTrack(testTrack);//adding track
	System.out.println(myJukebox.getTrackList());//needed to show that the track was added
}
public static void testCase32(){
	//check if getTrackList outputs all tracks added to jukebox Audiotrack arraylist
	AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	AudioTrack	testTrack1=new AudioTrack("morning glory","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	AudioPlayer myAudioPlayer=new AudioPlayer();//instancing an audioplayer instance as it is needed to create an instance of Jukebox
	Jukebox myJukebox=new Jukebox(myAudioPlayer);
	
	myJukebox.addTrack(testTrack);//adding track
	myJukebox.addTrack(testTrack1);//adding track
	System.out.println(myJukebox.getTrackList());//to check if the tracks are outputting
}
public static void testCase33() {
	//check if getTracklist  returns null when there is no tracks added
	AudioPlayer myAudioPlayer=new AudioPlayer();//instancing an audioplayer instance as it is needed to create an instance of Jukebox
	Jukebox myJukebox=new Jukebox(myAudioPlayer);
	System.out.println(myJukebox.getTrackList());//to check if it's outputting
}
public static void testCase34() {
	//testing that getTracks returns an array of tracks added to jukebox
	AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	AudioTrack	testTrack1=new AudioTrack("morning glory","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	AudioPlayer myAudioPlayer=new AudioPlayer();//instancing an audioplayer instance as it is needed to create an instance of Jukebox
	Jukebox myJukebox=new Jukebox(myAudioPlayer);
	
	myJukebox.addTrack(testTrack);//adding track
	myJukebox.addTrack(testTrack1);//adding track
	AudioTrack[] testArray;//will store the details of getTracks method in this array
	testArray=myJukebox.getTracks();
	for (int x=0;x<testArray.length;x++)//going through array and outputting the details of it using the getDetails method for an AudioTrack
	System.out.println(testArray[x].getDetails());
}
public static void testCase35() {
	//checking if passing in a valid track which has been added to the jukebox will play using the playTrack method
	AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	
	AudioPlayer myAudioPlayer=new AudioPlayer();//instancing an audioplayer instance as it is needed to create an instance of Jukebox
	Jukebox myJukebox=new Jukebox(myAudioPlayer);
	myJukebox.addTrack(testTrack);//adding track
	System.out.println("Song count:"+testTrack.getSongCount());
	//Playing the track that was just added
	if (myJukebox.playTrack(testTrack)==true)//playTrack returns a boolean, true if the track played, false if it didn't
		System.out.println("Track Played ,TEST PASSED!!");
	else if (myJukebox.playTrack(testTrack)==false)
		System.out.println("Track didn't play,TEST FAILED!!");
	System.out.println("Song count:"+testTrack.getSongCount());
}
public static void testCase36() {
	//checking if passing in a  track which hasn't been added to the jukebox will play using the playTrack method
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		
		AudioPlayer myAudioPlayer=new AudioPlayer();//instancing an audioplayer instance as it is needed to create an instance of Jukebox
		Jukebox myJukebox=new Jukebox(myAudioPlayer);

	//Playing the track that wasn't added
		if (myJukebox.playTrack(testTrack)==false)//playTrack returns a boolean, true if the track played, false if it didn't
			System.out.println("Track didn't Play ,TEST PASSED!!");
		else if (myJukebox.playTrack(testTrack)==false)
			System.out.println("Track Played,TEST FAILED!!");	
		
}
public static void testCase37() {
	//checking if it shuffles AudioTracks from an arraylist passed in, outputting it in a string with it only doing each track once
	AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	AudioTrack	testTrack1=new AudioTrack("morning glory","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	AudioPlayer myAudioPlayer=new AudioPlayer();//instancing an audioplayer instance as it is needed to create an instance of Jukebox
	Jukebox myJukebox=new Jukebox(myAudioPlayer);
	ArrayList<AudioTrack> tracks=new ArrayList<AudioTrack>();
	System.out.println("Song count for track 1:"+testTrack.getSongCount());
	System.out.println("Song count for track 2:"+testTrack1.getSongCount());
	tracks.add(testTrack);//adds it to playlist
	tracks.add(testTrack1);//adds to playlist
	System.out.println(myJukebox.shuffle(tracks));//will output in string the order they shuffled with each song playing once and details
	System.out.println("Song count for track 1:"+testTrack.getSongCount());
	System.out.println("Song count for track 2:"+testTrack1.getSongCount());
}
	public static void main(String[] args) {
	//methods commented out as testing one at a time
		//testCase31();
		//testCase32();
		//testCase33();
		//testCase34();
		testCase35();
		//testCase36();
		//testCase37();
	}

}
