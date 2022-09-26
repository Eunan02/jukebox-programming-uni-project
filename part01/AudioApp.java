package part01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Date:15/11/2020
 * @author Eunan Diamond Student Number:40293751
 * This class will be used as the console application. The input and output will take place in this class, alongside some validation.
 */
public class AudioApp {
static Scanner input=new Scanner(System.in);//the scanner is declared so input is able to take place. static as needs to be used in different methods
static AudioPlayer myPlayer=new AudioPlayer();
//instance of audioPlayer created so that an instance of Jukebox can be created which passes in AudioPlayer parameter as it does in the constructor in Jukebox
static Jukebox myJukebox=new Jukebox(myPlayer);
static final int MAX=10;//max value of AudioTracks, count is checked to see if is smaller in addtrack method, if it is track can be added
static int count=0;//counts the amount of added to the AudioTrack array
static AudioTrack tracks[];//AudioTrack array, AudioTracks are added through jukebox method getTracks.
		//=new AudioTrack[MAX];

static String playlistName;//user will be able to make a playlist name through this variable
static boolean validInput=false;//this is used throughout the methods in this class for validation
static ArrayList<AudioTrack> playlist=new ArrayList<AudioTrack>();//playlist arraylist.

 
public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList playlist=new ArrayList();// this arraylist will be used to store a playlist.
		
		String menuOptions[]= {"Display All Tracks","Display Tracks by Artist","Add New Track","Play a Track","Create a Playlist","Shuffle Play","Display the Top 10","Exit"};//creating array to be used for instance of menu class
		Menu appMenu=new Menu("JukeBox",menuOptions);//creating instance of menu class
		int choice=appMenu.getUserChoice();//asking user for which menu option they want
		while(choice != 8) {//if choice doesn't equal 8 this while loop will be executed.
			processChoice(choice);//call to class in this class
		choice=appMenu.getUserChoice();//call to method in menu class
		}
		System.out.println("Finished - Goodbye!");//this will output when user enters 8
		}
	//this is used to process the choice the user has entered in
/** @param choice- passes in the int the user has entered for which choice they want from the menu, it will then use the switch statement to check which menu choice the user has 
 * chosed. If the user enters a number which is not in does not have a case, the default switch statement will be excuted.If the user enters a value between 1 and 7 that case
 * will be executed. 
* */
	private static void processChoice(int choice)  {
		switch(choice) {
		case 1 : displayAllTracks() ;
			
		break; 
		case 2 : displayTracksByArtist() ;
	
		break;
	case 3: addNewTrack();
		break;
		case 4: playATrack();
	
			break;
		case 5: createAPlaylist();
	
			break;
		case 6: shufflePlay();
		
		break;
		
		case 7: displayTheTop10();
	
			break;
		default: System.out.println("Option "+choice+" is invalid.");//will out this message when a user enters invalid input e.g 11 or 9
		}
		System.out.println();
		
}
	/** This class passes in no parameters and it's purpose is to output the tracks by artists.It does this by displaying a list of artists and a number beside them
	 * the user then inputs the number beside artist name and it will display the tracks added by that artist.
	 */
	public static void displayTracksByArtist() {
	if (count>0) {
		ArrayList<String> artists=new ArrayList();//this arraylist is used to store the artist name, it will be cleared everytime this method is called so new artists can be added
		int choice=-1;//user uses this int to input artist they want, set an inital -1 value.
	//this nested for loop sequence is used to add artists to the artist array, it will check through the if statement if this artist has already been added to the artist arraylist
		for (int x=0;x<count;x++) {
		boolean duplicate=false;

		for (int y=0;y<artists.size();y++) {
if    (artists.get(y).intern()==tracks[x].getArtist().intern()) 
	
duplicate=true;
		}	
		
	if(!duplicate) {
artists.add(tracks[x].getArtist());//adding the artist string to the artist arraylist if this artist is not in the arraylist already
}
}
	
		
	for (int x=0;x<artists.size();x++)
		System.out.println(x+1+":"+artists.get(x));//outputing the list of artists 
	do {
	System.out.print("Chose an Artist(Enter 0 to stop):");
	try { choice=input.nextInt();//used to find the artist
	input.nextLine();//needed after an int input to clear the scanner
	String artistTracks=new String();//this string is used to output the tracks of the selected artist
	artistTracks="";
	
	if (choice !=0) {
		//used to find the tracks of the artist that the user wants
	for (int x=0; x<count;x++) {
	if (artists.get(choice-1).equals(tracks[x].getArtist())) {
	artistTracks+=tracks[x].getDetails()+"\n";//adding song to array
	}
	}
	System.out.println(artistTracks);//outputs the string of the tracks of the artists the user wanted.
	}
	}
	//these catchs are used to find if this is the choice entered is in the list or if it is a valid input type (an int) and will output a message to tell user it's invalid
	catch(IndexOutOfBoundsException ex) {
	
	System.out.println("invalid");
	}
	catch(NullPointerException ex) {

		System.out.println("invalid");
		input.nextLine();
	}
	catch (InputMismatchException ex) {
		
		System.out.println("invalid");
		input.nextLine();
	}
	
	
	}while(choice !=0);//this will continue to be executed till user enters 0, this allows the user to view multiple artists tracks.
	//input.nextLine();
	}else
		System.out.println("***NO TRACKS ADDED, NO ARTISTS TO DISPLAY***");
	}
	/**
	 * This method is used to add a new track, which is done by using the addTrack method in the jukebox class, first an instance of the audioTrack and each variable is added
	 * after this audioTrack instance is passed into the addTrack method in the jukebox, it is then added to the audioTrack array which is an instance of the getTracks in jukebox
	 */
	public static void addNewTrack() {
		
	//checks if the count is smaller than max if it is the user will be able to a track
		if (count<MAX) {
		
			System.out.println("***ADD NEW TRACK***");//title
			//Variables for inputting for adding a track
			String title="";
			String artist="";
			int duration=0;
			Genre genre=Genre.CLASSICAL;
			String encoding="";
			AudioTrack trk=new AudioTrack(title,artist,duration,genre,encoding);//audioTrack instance passing in the parameters in the constructor
		do{
		try {	System.out.print("Enter the track's title:");//output message asking user for input
		
		 title=input.nextLine();//using  scanner to input the title name
		 trk.setTitle(title);//calling the setTitle method in AudioTrack to set the title name
		 validInput=true;
		 //try and catch is used to ensure input is valid
		}catch(ExceptionHandling e) {//this is the validation in the setTitle in  AudioTrack class
			System.out.println(e.getErrorMessage());
		}
		}while(!validInput);//will continue to be executed till valid input has been entered
		validInput=false;//resets the validInput
		 do {
			try {
		
		 System.out.print("Enter the track's artist:");//outputting message asking for artist name input
		 artist=input.nextLine();//scanner used to input the artist name
			trk.setArtist(artist);//calling the setArtist method in the AudioTrack to set the artist name
			validInput=true;
			//try and catch is used to ensure input is valid
		}catch(ExceptionHandling e) {//this is the validation in the setArtist in  AudioTrack class
			System.out.println(e.getErrorMessage());
		}
		}while(!validInput);//will keep carrying out till user enters a valid Input.
		validInput=false;
		do{System.out.print("Enter the track's duration(In Seconds):");//outputting message asking for duration input
		try { duration=input.nextInt();//scanner used to input the duration as an int
		//input.nextLine();
		trk.setDuration(duration);//calling the setDuration method in the AudioTrack method to set Duration length
		validInput=true;
		}
		//try and catch used to ensure the user enters a valid int for duration
		catch(ExceptionHandling e) {//this is the validation in the setDuration in  AudioTrack class
			System.out.println(e.getErrorMessage());
			input.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid Input, enter a number!");
		input.nextLine();
		}
	
		}while(!validInput);//will continue to be executed till valid input has been entered
		validInput=false;
		System.out.println("**List Of Genres**");
		//this advanced for loop is used to generate a list of all the genres.
		for (Genre g : Genre.values())
		{
			System.out.println(g.name()+":"+g.names());//outputing the genres and a description of each genre. 
		}
		input.nextLine();//clear int input
		do {
			System.out.print("Enter the Track's Genre:");//outputting message asking for genre input
		try {String style=input.nextLine();//scanner used to input the genre as a string
			trk.setStyle(style);//calling the setStyle method in the AudioTrack method to set Genre
	
			validInput=true;
		}
		 //try and catch is used to ensure input is valid
		catch(ExceptionHandling e) {//this is the validation in the setStyle in  AudioTrack class
			System.out.println(e.getErrorMessage());
		}
		}
		while(!validInput);
			validInput=false;

		do {
			System.out.print("Enter the tracks encoding:");//outputting message asking for encoding input
	try{
		encoding=input.nextLine();//scanner used to input the encoding as a string
		trk.setEncoding(encoding);//calling the setEncoding in the AudioTrack method to set encoding
		
	validInput=true;}
	//try and catching to ensure the user enters wav or mp3
	catch(ExceptionHandling e) //this is the validation in the setEncoding in  AudioTrack class
	{
		System.out.println(e.getErrorMessage());
		
	}
		}while(!validInput);//will continue to be executed till valid input has been entered
	boolean addedAlready=false;
	for (int x=0;x<count;x++) {
		if (tracks[x].getTitle().equals(title) && (tracks[x].getArtist().equals(artist))) {//this is checking through the tracks added if the same song by same artist has been added
			addedAlready=true;//if it has it will set this to true and not allow the user to add this track
		}
		
	}
	if(!addedAlready) {//track hasn't been added already so it will add
	myJukebox.addTrack(trk);//adding the track to the arraylist in jukebox class 
	tracks=myJukebox.getTracks();//the getTracks return audioTrack array, this is making tracks a AudioTrack array
	tracks[count] = trk;//adds the track to the array
	count++;//increasing count
	System.out.println("TRACK ADDED!");
	}
	else { System.out.println("This song by this artist has already been added,unable to add!!");

	}}

	//this will be outputted if count is greater than MAX
		else
			System.out.println("The limited amount of tracks has been added");
	}
	/**
	 * This method is used to display all the tracks added. It returns nothing and passes in no parameters 
	 */
	public static void displayAllTracks() {
		System.out.println("***ALL TRACKS***");//title
		if (count==0) {
			
			System.out.println("***NO TRACKS***");//will output this if no tracks have been added
		}
		else {
			AudioTrack [] tracksOrdered=new AudioTrack[count];
			//bubble sort so that tracks output in alphabetical order of titles, this is done by using compareTo for the titles as below shows
		for (int x=0;x<count;x++) {
			tracksOrdered[x]=tracks[x];
		}
		AudioTrack temp;
		int numLength=count;
		for (int i=1;i<=(numLength-1);i++) {
			for(int j=0;j<(numLength-1);j++) {
				String track1=tracksOrdered[j].getTitle();
				String track2=tracksOrdered[j+1].getTitle();
				if (track1.compareTo(track2)>0) {
					temp=tracksOrdered[j];
					tracksOrdered[j]=tracksOrdered[j+1];
					tracksOrdered[j+1]=temp;
				}
			}
		}
			for (int x=0;x<count;x++) {
				//tracks= myJukebox.getTracks();
				System.out.println(tracksOrdered[x].getDetails());//outputting each track which has been added
			}
		}
	}
	/** This method passes in no parameters and is used to create a playlist */
	public static void createAPlaylist() {
		System.out.println("***CREATE A PLAYLIST***");//outputting title
		
		
		int choice=-1;//this int is used to enter track code to add track to playlist
	
		int elements=0;//this is used that if the user has already added a track it will not allow them to add it again if this variable is greater than 1
		if(count>0) {// this will not be executed unless there has been at least one track added.
			
			playlist= new ArrayList();//the arraylist used to store the playlist, it will instanced every time this method is executed as there can only be one playlist
			System.out.print("Enter name for playlist:");//outputting message asking user to enter playlist name
		playlistName=input.nextLine();//choice;//scanner used to input playlist name as a string
		System.out.println(myJukebox.getTrackList());//outputting the track code and song so user can see list of tracks to add to playlist
		do {
		System.out.print("Enter Track Code to add to playlist(Enter 0 to stop adding):");//outputting message asking for input
		try {
			validInput=true;
		choice=input.nextInt();//user adds track to playlist by entering it's trackcode
	input.nextLine();//clearing the scanner after inputting an int
	for (int x=0;x<playlist.size();x++) {
	if(choice!=0){
	{
	if (playlist.get(x).getTrackCode()==tracks[choice-1].getTrackCode())//checking if this track has been added already by comparing all the trackcodes to the trackcode entered
	{
		System.out.println("This Track has already been added to playlist");//will output this message if track code entered has already been added to playlist
	
	elements++;//this ensures that it will not be added again
	}
	}
	}
	}
	if ( elements==0 && choice !=0 &&validInput==true && tracks[choice-1]!=null)//a track will be added to the playlist arraylist if it follows this if statement, this if statements ensures it's a valid track which has not already been added
	{
		playlist.add(tracks[choice-1]);//adding the track to the playlist arraylist
	System.out.println("Track Added!");//outputting message to ensure the user knows that the track was added.
	}		
		
		}
		//try and catch used to ensure the choice entered is a valid int which is a track code, will throw an one of these exceptions if it is not.
	catch(IndexOutOfBoundsException ex) {
	validInput=false;
	System.out.println("Track code is invalid");

	}
	catch(NullPointerException ex) {
		validInput=false;
		System.out.println("Track code is invalid");
		input.nextLine();
	}
	catch (InputMismatchException ex) {
		validInput=false;
		System.out.println("Track Code is invalid");
		input.nextLine();
	}
		}
			while (choice !=0);//will keep executed this do while loop till the user enters 0 which means they have added all the songs they've wanted to the playlist
		System.out.println("Playlist "+playlistName+ " Created!");		//making user aware that their playlist has been created.
		}
		else
			System.out.println("***No tracks added, so playlist is not able to be added***");//will output this if no tracks added as it would be impossible to make a playlist
	}
	/**
	 * This method is used to play a track, it passes no parameters and uses the playTracks method in jukebox to play a track
	 */
	public static void playATrack() {
		boolean play = false;//used to check if a track has played or not
		int choice=-1;//the choice int used to enter a trackcode, instanced at -1 as this is not a track code and will not play a track code straight away
		System.out.println("PLAY A TRACK");//title
		if (count>0) {//this ensures the user will only be able to play a track if at least one track has been added
		System.out.println(myJukebox.getTrackList());//outputting a list of track code and track name.
	do {	
		System.out.print("Chose a Track to Play(Enter 0 to stop):");
	try {	
	choice=input.nextInt();//inputing an int for track code of track they want to play
		 play=myJukebox.playTrack(tracks[choice-1]);//passing this choice -1 into playTrack method in jukebox this will check if it is a valid track and play in it in AudioPlayer class
	input.nextLine();
	}
	//try and catch is used to ensure the user enters a valid int, if not these catchs will be thrown.
	catch(IndexOutOfBoundsException ex) {//will be thrown if the user enters a track not on the list

	}
	catch(NullPointerException ex) {//will be thrown if the user enters a track which is null
		
		input.nextLine();
	}
	catch (InputMismatchException ex) {//will be thrown if the user doesn't enter an integer
		
		input.nextLine();
	}
		
		 if (play==true) {//will output if the user enters a valid trackcode which passes to playTrack method in jukebox and be true
			 System.out.println("Valid Song, it has been played!"+tracks[choice-1].getTitle()+" by "+tracks[choice-1].getArtist()+" played for "+tracks[choice-1].getMinutes()+":"+tracks[choice-1].getSeconds());
		 }
		 else if (play==false && choice !=0) {//will output if the user enters a invalid trackcode or invalid type of track code as it will pass to the playTrack method in jukebox and be false
			 System.out.println("Invalid Input, No song has been played,enter a track number which is in the track list!");
		 }
		 play=false;//restarting the value
	}
		while (choice!=0);//will keep executing till user enters 0 letting them play as many songs as they want
		input.nextLine();
		}	
	else {
		System.out.println("***NO TRACKS ADDED TO PLAY***");//this will output if there are no tracks added, as it would be impossible to play any songs
	}
	}
	/**
	 * this method passes no parameters and calls the shuffle method in the Jukebox class to shuffle play the arraylist of the playlist.
	 */
	public static void shufflePlay() {
		if(playlist.size()>0) {
		System.out.println(playlistName+" SHUFFLED");//this lets the user now that the playlist(outputting it's name) has been shuffled
		String shufflePlay=myJukebox.shuffle(playlist);//passing in the arraylist playlist to jukebox method shuffle which then shuffle plays each track once
		System.out.println(shufflePlay);	//outputs the order of the shuffle
	}
		else 
			System.out.println("***No playlist to shuffle***");////if the playlist array is size 0 this will output as there would be nothing to shuffle.
	}
	/**
	 * This method passes in no parameters, it is used to calculate the order of the tracks played from biggest to smallest, using bubble sort algorithm, there is validation at end to ensure it is top 10 if there is more than 10 tracks
	 */
	public static void displayTheTop10() {
System.out.println("TOP 10");//title
		if(count>0) {
			 AudioTrack top10[]=new AudioTrack[count];//this array will be used to store the AudioTracks from most Played to least Played
			for (int x= 0;x<count;x++) {
				top10[x]=tracks[x];
			}
	boolean flag=true;
	AudioTrack temp;
	int order=0;
	int numLength=count;
	//bubble sort algorithm this will sort the top10 array into biggest song count to smallest
	for (int i =1;i<=(numLength-1)&&flag;i++){
		flag=false;
		for (int j=0;j<(numLength-1);j++) {
			if (top10[j+1].getSongCount()>top10[j].getSongCount()) {//comparing songCount this if statement will be executed if top10[j+1] song count is greater than top[j] song count
				temp=top10[j];
				top10[j]=top10[j+1];
			top10[j+1]=temp;	
				flag=true;
			}
		}
	}//if it's greater than 10 it will only show the first 10 tracks as top 10 
	if (count>10) {
		for(int x=0;x<10;x++) {
			order++;
			System.out.println(order+":"+"times Played:"+top10[x].getSongCount()+",Song Name:"+top10[x].getTitle());//outputting the song count in order will it's number in the top 10
		}
	}
	//if it's less than 10 it will display all the tracks
	else {
		for(int x=0;x<count;x++) {
			order++;
			System.out.println(order+":"+"times Played:"+top10[x].getSongCount()+",Song Name:"+top10[x].getTitle());//outputting the song count in order will it's number in the top 10
	}
	}
		}
		else {
			System.out.println("***NO TRACKS***");//this will output if there is no tracks added
		}
	}
	
	}


