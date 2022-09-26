package part03;
import part01.*;
public class AudioPlayerUnitTests {
public static void testCase27() {
	//testing if you are able to create an instance of the AudioPlayer Object
	AudioPlayer myPlayer=new AudioPlayer();//no need to output as no error proves it passes the test, the AudioPlayer constructor takes no parameters
}
public static void testCase28() {
	//check if the play method sets the currentTrack
	AudioPlayer myPlayer=new AudioPlayer();//instancing AudioPlayer object
	AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	myPlayer.play(testTrack);//calling play method in AudioPlayer which takes in a AudioTrack
	System.out.println(myPlayer.getCurrentTrack().getTitle());//checking if it outputs the title of the track put in.
}
public static void testCase29() {
	//checking if the return true works in the play method, it should never return anything else as the validation for a valid track takes place in the playTrack in Jukebox
	AudioPlayer myPlayer=new AudioPlayer();//instancing AudioPlayer object
	AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	if (myPlayer.play(testTrack)==true)//calling play method in AudioPlayer which takes in a AudioTrack
	System.out.println("This test PASSED!");
	else
		System.out.println("This test FAILED!");
}
	public static void main(String[] args) {
		//methods commented out as testing one at a time
//testCase28();
		testCase29();
	}

}
