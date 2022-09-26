package part03;
import part01.*;
public class AudioTrackUnitTesting {
public static void testCase1() {
	//testing if the constructor works and able to create AudioTrack object
	AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	//don't need to execute method as it an instance was allow to happen
}
	public static void testCase2() {
		//testing getTitle outputs the title
	AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	System.out.println(testTrack.getTitle());//outputting getTitle to check if test is valid
	}
	public static void testCase3() throws ExceptionHandling {//needed as setTitle throws this excpetion, but no need for try catch as it is not needed for this test
		//testing if the setTitle works
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");
		String changeTitle="Morning glory";

			testTrack.setTitle(changeTitle);
			System.out.println(changeTitle);
	}
	public static void testCase4() {
		//testing if the validation in setTitle works
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		String changeTitle="";
		try {
			testTrack.setTitle(changeTitle);
		} catch (ExceptionHandling e) {
			// TODO Auto-generated catch block
	System.out.println(e.getErrorMessage());
		}
	}
	public static void testCase5() {
		//testing if getArtist outputs the artist name
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		System.out.println(testTrack.getArtist());//outputting getArtist to check if test is valid
	}
	public static void testCase6() throws ExceptionHandling {//needed as setArtist throws this excpetion, but no need for try catch as it is not needed for this test
		//testing if the setArtist works
				AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");
				String changeArtist="band";

					testTrack.setArtist(changeArtist);
					System.out.println(changeArtist);
	}
	public static void testCase7() {
		//testing if the validation in setTitle works
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		String changeArtist="";
		try {
			testTrack.setArtist(changeArtist);
		} catch (ExceptionHandling e) {
			// TODO Auto-generated catch block
	System.out.println(e.getErrorMessage());
		}
	}
	public static void testCase8() {
		//testing if getDuration outputs the artist name
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		System.out.println(testTrack.getDuration());//outputting getDuration to check if test is valid
	}
	public static void testCase9() {
		//testing if getMinutes returns the durations amount of minutes by dividing duration by 60
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	System.out.println(testTrack.getMinutes());
	}
	public static void testCase10() {
		//testing if getSeconds returns the durations amount of minutes by mod duration by 60
				AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
			System.out.println(testTrack.getSeconds());
	}
	public static void testCase11() throws ExceptionHandling {//needed as setDuration throws this excpetion, but no need for try catch as it is not needed for this test
		//testing the setDuration by setting it to a valid Duration
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		int changeDuration=120;
		testTrack.setDuration(changeDuration);
		System.out.println(testTrack.getDuration());
	}
	public static void testCase12() {
		//testing validation of setDuration
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		int changeDuration=-9;
		try {
			testTrack.setDuration(changeDuration);
		} catch (ExceptionHandling e) {
		System.out.println(e.getErrorMessage());//will output error message which has been set in the setDuration
		}
	}
	public static void testCase13() throws ExceptionHandling {//needed as setStyle throws this excpetion, but no need for try catch as it is not needed for this test
		//testing that you can set genre to Rock
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		String genre ="Rock";
		testTrack.setStyle(genre);
		System.out.println("DESCPRIPTION:"+testTrack.getStyle()+" NAME:"+testTrack.getStyleInString());
	}
	public static void testCase14() throws ExceptionHandling { //needed as setStyle throws this excpetion, but no need for try catch as it is not needed for this test
		//testing that you can set genre to Pop
				AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
				String genre ="Pop";
				testTrack.setStyle(genre);
				System.out.println("DESCPRIPTION:"+testTrack.getStyle()+" NAME:"+testTrack.getStyleInString());
			}
	public static void testCase15() throws ExceptionHandling { //needed as setStyle throws this excpetion, but no need for try catch as it is not needed for this test
		//testing that you can set genre to Jazz
				AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
				String genre ="Jazz";
				testTrack.setStyle(genre);
				System.out.println("DESCPRIPTION:"+testTrack.getStyle()+" NAME:"+testTrack.getStyleInString());
			}
	public static void testCase16() throws ExceptionHandling { //needed as setStyle throws this excpetion, but no need for try catch as it is not needed for this test
		//testing that you can set genre to Dance
				AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
				String genre ="Dance";
				testTrack.setStyle(genre);
				System.out.println("DESCPRIPTION:"+testTrack.getStyle()+" NAME:"+testTrack.getStyleInString());
			}
	public static void testCase17() throws ExceptionHandling { //needed as setStyle throws this excpetion, but no need for try catch as it is not needed for this test
		//testing that you can set genre to Classical
				AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
				String genre ="classical";
				testTrack.setStyle(genre);
				System.out.println("DESCPRIPTION:"+testTrack.getStyle()+" NAME:"+testTrack.getStyleInString());
			}
	public static void testCase18() throws ExceptionHandling { //needed as setStyle throws this excpetion, but no need for try catch as it is not needed for this test
		//testing that you can set genre to Other
				AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
				String genre ="Other";
				testTrack.setStyle(genre);
				System.out.println("DESCPRIPTION:"+testTrack.getStyle()+" NAME:"+testTrack.getStyleInString());
			}
	public static void testCase19() {
		//testing the validation of setStyle by entering a invalid genre
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		String genre ="no genre";
		try {
			testTrack.setStyle(genre);
		} catch (ExceptionHandling e) {
	System.out.println(e.getErrorMessage());//will output the errormessage that was set in the setStyle method for invalid genre entry
		}
	}
	public static void testCase20() throws ExceptionHandling { //needed as setEncoding throws this excpetion, but no need for try catch as it is not needed for this test
		//testing that encoding can be set to mp3
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		String encoding ="mp3";
		testTrack.setEncoding(encoding);
		System.out.println(testTrack.getEncoding());
	}
	public static void testCase21() throws ExceptionHandling { //needed as setEncoding throws this excpetion, but no need for try catch as it is not needed for this test
		//testing that encoding can be set to wav
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
	
		String encoding ="wav";
		testTrack.setEncoding(encoding);
		System.out.println(testTrack.getEncoding());
	}
	public static void testCase22() {
		//testing that the encoding can not be set to anything but wav or mp3 by testing valdation by entering a something different
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		String encoding ="no encoding";
		try {
			testTrack.setEncoding(encoding);
		} catch (ExceptionHandling e) {
			System.out.println(e.getErrorMessage());
		}
	}
	public static void testCase23() {
		//testing that the track code has been set
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		AudioTrack	testTrack1=new AudioTrack("morning glory","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		System.out.println("First Track Code:"+testTrack.getTrackCode());
		System.out.println("Second Track Code:"+testTrack1.getTrackCode());
	}
	public static void testCase24() {
		//testing that the song count can be set and can be outputted through getSongCount
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		System.out.println("Song played:"+testTrack.getSongCount()+" Times");
		testTrack.setSongCount();
		System.out.println("Song played:"+testTrack.getSongCount()+" Times");
		testTrack.setSongCount();
		System.out.println("Song Played:"+testTrack.getSongCount()+" Times");
	}
	public static void testCase25() {
		//testing that the getDetails method outputs the duration as getMinutes : getSeconds format
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		System.out.println(testTrack.getDetails());
	}
	public static void testCase26() {
		//testing that getDetails outputs track code, title, artist, style,duration, encoding and song count in that order
		AudioTrack	testTrack=new AudioTrack("wonderwall","oasis",180,Genre.ROCK,"wav");//instancing AudioTrack object
		System.out.println(testTrack.getDetails());
	}
public static void main(String[] args) throws ExceptionHandling {
	//methods commented out as testing one at a time
//testCase2();
//testCase3();
//testCase4();
//testCase5();
//testCase6();
//testCase7();
//	testCase8();
//testCase9();
	//testCase10();
	//testCase11();
	//testCase12();
	//testCase13();
	//testCase14();
//testCase15();
	//testCase16();
	//testCase17();
	//testCase18();
	//testCase19();
	//testCase20();
	//testCase21();
//testCase22();
	//testCase23();
	//testCase24();
	//testCase25();
	testCase26();
}

}
