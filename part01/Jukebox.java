package part01;

import java.util.*;
/**
 * @author Eunan Diamond  @StudentNumber:40293751 @Date:5/11/2020
 *This is an object class. It is used to declare a Jukebox, with the necessary variables and methods.
 *It has a aggrratation relationship with AudioTrack and association relationship with AudioPlayer
 */
public class Jukebox implements IJukebox{//implementing IJukebox ensures it uses all the methods within that interface
private ArrayList<AudioTrack> allTracks;//this makes the aggretation with AudioTrack, this is used to store a list of tracks 
private AudioPlayer player;//this is used to call the AudioPlayer play method in the playTrack method

/**
 * @param it passes in a AudioPlayer parameters,Constructor-needed to instance the object in main class, 
 * it is always public follow by object name and then any parameters
 */
public Jukebox(AudioPlayer p) {
	//setting instances of variables
	this.player=p;
	allTracks=new ArrayList<AudioTrack>();
}
/**
 * This method is used to play a audioTrack
 * @param trk- this is a AudioTrack object, which is passes in from the main console app, which is the track the user wants to play
 * @return it will return player play method, if the track passed in, track code is valid, which in there it will return true and set the currentTrack to the Track that was passed in
 * therefore playing it. It will return false if the Track passed in is not a validTrack code and will not pass to audioPlayer, therefore not playing.
 */
public boolean playTrack(AudioTrack trk) {
if (trk.getTrackCode()>0 && trk.getTrackCode()<=allTracks.size()) {
	if (player.play(trk)==true)//needed as it could come false in part 2 for player and still increase count
		trk.setSongCount();//increases songcount each time a track is played
	return player.play(trk);
}
else return false;
}
/**
 * 
 * @param trk- passing in an audioTrack, to add to the arraylist of audioTracks, no need for validation as it has already been carried out in the addTrack
 * in the console app and it ensures that only a valid AudioTrack can be passed in.  
 */
public void addTrack(AudioTrack trk) {
	if (trk != null) {
		allTracks.add(trk);
	}
	
}
/**
 * This method passes in no parameters and is used to get a list of all the AudioTracks as arrays, this is used to instance the AudioTracks array tracks 
 * in the main console app
 * @return-it returns the tracks arrays
 */
public AudioTrack[] getTracks() {
	 AudioTrack[] trks = new AudioTrack[allTracks.size()]; 
	 for  (int x=0;x<allTracks.size();x++) {
		 trks[x]=allTracks.get(x);
	 }
	 return trks;

}
/**
 * This is used to return a simple list of all the tracks added
 * @return This returns a track list of track code and track title of every track added, it will return null if there is no tracks added
 */
public String getTrackList() {
	String str="";
	if (allTracks.size()>0) {
	for (int x=0;x<allTracks.size();x++) {

		str+=allTracks.get(x).getTrackCode()+","+allTracks.get(x).getTitle()+",";//adding each track in the allTracks arraylist to the string
		
	}
	return str;	
	}
	else return null;
	}
	
/**
 * 
 * @param tracks- this passes in an arraylist, which is used to shuffle play it.
 * @return it returns a string of the order of the shuffle play along with title of song, artist and duration
 */
public String shuffle(ArrayList<AudioTrack> tracks) {
	String shuffle="";
	int elements=0;
	int shuffleTrackNums[] =new int[tracks.size()];
	for (int y=0;y<shuffleTrackNums.length;y++) {
		shuffleTrackNums[y]=-1;
	}
	int songcount=0;
	Random randomIndex=new Random();
	do {
		int rand=randomIndex.nextInt(tracks.size());//chosing a random index using the random function

	 for (int x=0;x<songcount;x++) {
	 if (rand==shuffleTrackNums[x]) {
		 elements++;

	 }
	 }

if (elements==0) {//this if statement ensures each song can only be played once
	shuffleTrackNums[songcount]=rand;
	songcount++;
	//outputs order of shuffle play along with details of each song
	shuffle+="Song number "+songcount+ " played:"+"Title:"+tracks.get(rand).getTitle()+",Artist:"+tracks.get(rand).getArtist()+","+"Duration:"+tracks.get(rand).getMinutes()+":"+tracks.get(rand).getSeconds()+" Minutes"+"\n";
tracks.get(rand).setSongCount();
}
elements=0;
	}while (songcount!=tracks.size());//stops when the songcount(which increments everytime a song is shuffled) is equal to the size of the playlist, therfore when all songs have been play shuffled

		
	return shuffle;

}
}



