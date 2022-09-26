package part02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import part01.AudioPlayer;
import part01.AudioTrack;
import part01.ExceptionHandling;
import part01.Genre;
import part01.Jukebox;

/**
 * Date:15/11/2020
 * @author Eunan Diamond Student Number:40293751
 * This class will be used as the console application. The input and output will take place in this class, alongside some validation.
 */
public class AudioApp {
static Scanner input=new Scanner(System.in);//the scanner is declared so input is able to take place.
static AudioPlayer myPlayer=new AudioPlayer();
static WavPlayer wav=new WavPlayer();
static MP3Player mp3=new MP3Player();
static AudioPlayer player=new AudioPlayer();
//instance of audioPlayer created so that an instance of Jukebox can be created which passes in AudioPlayer parameter as it does in the constructor in Jukebox
static Jukebox myJukebox=new Jukebox(player);
static final int MAX=10;//max value of AudioTracks, count is checked to see if is smaller in addtrack method, if it is track can be added
static int count=0;//counts the amount of added to the AudioTrack array
static AudioTrack tracks[];//AudioTrack array, AudioTracks are added through jukebox method getTracks.
	
static String csvOutPath="jukebox.csv";
static String playlistName;//user will be able to make a playlist name through this variable
static boolean validInput=false;//this is used throughout the methods in this class for validation
static ArrayList<AudioTrack> playlist=new ArrayList<AudioTrack>();//playlist arraylist.
/**
 * 
 * @param args
 * @throws ExceptionHandling- throws this as the addTrack needs it for AudioTrack class error handling
 */
public static void main(String[] args) throws ExceptionHandling {
		// TODO Auto-generated method stub
	restoreData();//calling method to restore tracks already added
		String menuOptions[]= {"Display All Tracks","Display Tracks by Artist","Add New Track","Play a Track","Create a Playlist","Shuffle Play","Display the Top 10","Exit"};//creating array to be used for instance of menu class
		Menu appMenu=new Menu("JukeBox",menuOptions);//creating instance of menu class
		int choice=appMenu.getUserChoice();//asking user for which menu option they want
		while(choice != 8) {//if choice doesn't equal 8 this while loop will be executed.
			processChoice(choice);//call to class in this class
		choice=appMenu.getUserChoice();//call to method in menu class
		}
		System.out.println("Finished - Goodbye!");//this will output when user enters 8
storeData(myJukebox.getTracks(),csvOutPath);
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
	
	System.out.println("Track code is invalid");
	}

	catch (InputMismatchException ex) {
		
		System.out.println("Track Code is invalid");
		input.nextLine();
	}
	
	
	}while(choice !=0);//this will continue to be executed till user enters 0, this allows the user to view multiple artists tracks.
		}else System.out.println("***NO TRACKS ADDED, NO ARTISTS TO DISPLAY***");
		}
		
	/**
	 * This method is used to add a new track, which is done by using the addTrack method in the jukebox class, first an instance of the audioTrack and each variable is added
	 * after this audioTrack instance is passed into the addTrack method in the jukebox, it is then added to the audioTrack array which is an instance of the getTracks in jukebox
	 */
	public static void addNewTrack()  {
		
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
		try {	
			
			System.out.print("Enter the track's title:");//output message asking user for input
		 title=input.nextLine();//using  scanner to input the title name
		 trk.setTitle(title);//calling the setTitle method in AudioTrack to set the title name
		 validInput=true;
		 //try and catch is used to ensure input is valid
		}catch(ExceptionHandling e) {
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
		}catch(ExceptionHandling e) {
			System.out.println(e.getErrorMessage());
		}
		}while(!validInput);//will keep carrying out till user enters a valid Input.
		validInput=false;
		do{System.out.print("Enter the track's duration:");//outputting message asking for duration input
		try { duration=input.nextInt();//scanner used to input the duration as an int
		//input.nextLine();
		trk.setDuration(duration);//calling the setDuration method in the AudioTrack method to set Duration length
		validInput=true;
		}
		//try and catch used to ensure the user enters a valid int for duration
		catch(ExceptionHandling e) {
			System.out.println(e.getErrorMessage());
			input.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid Input, enter a number!");
		input.nextLine();
		}
		catch (NullPointerException e) {
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
		input.nextLine();
		do {
			System.out.print("Enter the Track's Genre:");//outputting message asking for genre input
		try {String style=input.nextLine();//scanner used to input the genre as a string
			trk.setStyle(style);//calling the setStyle method in the AudioTrack method to set Genre
	
			validInput=true;
		}
		 //try and catch is used to ensure input is valid
		catch(ExceptionHandling e) {
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
	catch(ExceptionHandling e) 
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
		else System.out.println("This song by this artist has already been added,unable to add!!");
		}
		
	//this will be outputted if count is greater than MAX
		else
			System.out.println("The limited about of tracks has been added");
	}
	/**
	 * This method is used to display all the tracks added.
	 */
	public static void displayAllTracks() {
		System.out.println("***ALL TRACKS***");//title
		if (count==0) {
			System.out.println("***NO TRACKS***");//will output this if no tracks have been added
		}
		else
		{
			AudioTrack [] tracksOrdered=new AudioTrack[count];
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
	//input.nextLine();
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
		boolean valid=true;
		boolean validInput=true;
		int choice=-1;//the choice int used to enter a trackcode, instanced at -1 as this is not a track code and will not play a track code straight away
		System.out.println("PLAY A TRACK");//title
		if (count>0) {//this ensures the user will only be able to play a track if at least one track has been added
		////outputting a list of track code and track name.
	
	System.out.println("***PLAYERS***");
	System.out.println("1:MP3 Player");
	System.out.println("2:Wav Player");
	System.out.println();
	do {
	System.out.print("Chose a Player:");
	try {
	int playerChoice=input.nextInt();
	input.nextLine();
	if(playerChoice==1) {
		valid=true;
		 myJukebox=new Jukebox(mp3);
		 for (int x=0;x<count;x++) {
			 myJukebox.addTrack(tracks[x]);
		 }
	}
		else if (playerChoice==2) {
			valid=true;
	myJukebox=new Jukebox(wav);
	 for (int x=0;x<count;x++) {
		 myJukebox.addTrack(tracks[x]);
	 }	
		}
	 else {
		 System.out.println("Enter 1 for mp3 player or Enter 2 for wav player");
	valid=false;
	 }
	}catch(InputMismatchException e) {
		 System.out.println("Enter 1 for mp3 player or Enter 2 for wav player");
		valid=false;
		input.nextLine();
	}
	}while(valid!=true);
	System.out.println(myJukebox.getTrackList());
	do {
		try {
		System.out.println();
		System.out.print("Chose a Track to Play(Enter 0 to stop):");
	choice=input.nextInt();//inputing an int for track code of track they want to play
		 play=myJukebox.playTrack(tracks[choice-1]);//passing this choice -1 into playTrack method in jukebox this will check if it is a valid track and play in it in AudioPlayer class
	}
	//try and catch is used to ensure the user enters a valid int, if not these catchs will be thrown.
	catch(IndexOutOfBoundsException ex) {//will be thrown if the user enters a track not on the list
		if (choice!=0) {
		System.out.println("Invalid Input, enter a track number which is in the track list!");
		validInput=false;
		input.nextLine();
	}
	}
	catch(NullPointerException ex) {//will be thrown if the user enters a track which is null
	
		System.out.println("Invalid Input, enter a track number which is in the track list!");
		validInput=false;
		input.nextLine();
	
	}
	catch (InputMismatchException ex) {//will be thrown if the user doesn't enter an integer
		System.out.println("Invalid Song, No song has been played");
		validInput=false;
		input.nextLine();
	}
		
		 if (play==true &&validInput==true) {//will output if the user enters a valid trackcode which passes to playTrack method in jukebox and be true
			 System.out.println("Valid Song, it has been played!"+tracks[choice-1].getTitle()+" by "+tracks[choice-1].getArtist()+" played for "+tracks[choice-1].getMinutes()+":"+tracks[choice-1].getSeconds()+" Minutes");
		 }
		 else if (play==false &&validInput==true &&choice !=0) {//will output if the user enters a invalid trackcode or invalid type of track code as it will pass to the playTrack method in jukebox and be false
		//	 System.out.println("Invalid Song, No song has been played");
			 System.out.println("Invalid,This song is not valid for this player, No song has been played");
		 }
		 play=false;//restarting the value
	validInput=true;
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
	 * This method passes in no parameters, it is used to calculate the order of the tracks played from biggest to smallest, using bubble sort algorithm,as the MAX value is 10 there is no need to do any validation for 10 tracks
	 * as it will never be more than 10
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
	}
	if (count>10) {//if it's greater than 10 it will only show the first 10 tracks as top 10 
		for(int x=0;x<10;x++) {
			order++;
			System.out.println(order+":"+"times Played:"+top10[x].getSongCount()+",Song Name:"+top10[x].getTitle());//outputting the song count in order will it's number in the top 10
		}
	}
	else {//if it's less than 10 it will display all the tracks
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
	/**
	 * 
	 * @param trks-needs all the tracks passed in so it can store them in the csv
	 * @param csvOutPath needs the csv address
	 */
	public static void storeData(AudioTrack[] trks,String csvOutPath) {
try {	
	PrintWriter pw=new PrintWriter(csvOutPath);//print reader is needed to read the variables into the csv file

	pw.println("TrackCode, Title, Artist, Duration, Style, Encoding,Song Count");//variable needs will be printed out in the top
	//advanced for loop goes through every AudioTrack in the array and adds them to the csv file
	for (AudioTrack trk:trks) {
		pw.print(trk.getTrackCode()+",");
		pw.print(trk.getTitle()+",");
		pw.print(trk.getArtist()+",");
		pw.print(trk.getDuration()+",");
		pw.print(trk.getStyleInString()+",");
		pw.print(trk.getEncoding()+",");
		pw.print(trk.getSongCount());
		pw.print("\n");
	}
	pw.close();
	}catch(FileNotFoundException e) {//expection increase the outpath file is not found
		e.printStackTrace();
	}

System.out.println("CSV file has stored Tracks!");//message to let user know it has been stored
}
	/**
	 * This method here is used to restore data when the program is first executed (when this is called)
	 * @throws ExceptionHandling as the methods use this but it will not implement it here as all the data being restored will be valid AudioTrack variables
	 */
	public static void restoreData() throws ExceptionHandling  {
	
		boolean hasHeader=true;
		try {
		File myFile=new File (csvOutPath);
		Scanner sc=new Scanner(myFile);
		if (hasHeader) {//checks if the file has a header which is does (variable names) it will therefore move on to the next line of the file
			sc.nextLine();
		}
		while(sc.hasNextLine())//will keep doing this as long there is another line
		{
			//this is restore the tracks that were in that file by instancing a AudioTrack setting it's variables values and then adding it to the jukebox tracks list
			String title="";
			String artist="";
			int duration=0;
			Genre genre=Genre.CLASSICAL;
			String encoding="";
			AudioTrack trk=new AudioTrack(title,artist,duration,genre,encoding);
			String record=sc.nextLine();
			String[] parts=record.split(",");//using a string to split the AudioTrack as each variable is seperated by a comma in the CSV
			int trackCode=Integer.parseInt(parts[0].trim());
			title=parts[1].trim();
			trk.setTitle(title);
			
			 artist=parts[2].trim();
			 trk.setArtist(artist);
			 duration=Integer.parseInt(parts[3].trim());
			 trk.setDuration(duration);
			 String style=parts[4].trim();
			trk.setStyle(style);
			 encoding=parts[5].trim();
			 trk.setEncoding(encoding);
			 int songCount=Integer.parseInt(parts[6].trim());
		
			 myJukebox.addTrack(trk);//adding the track to the arraylist in jukebox class 
				tracks=myJukebox.getTracks();//the getTracks return audioTrack array, this is making tracks a AudioTrack array
				tracks[count] = trk;//adds the track to the array
				for (int x=0;x<songCount;x++) {
					tracks[count].setSongCount();//recounting each song count for each song
				}
				count++;//increasing count
				
		}
		sc.close();
	}catch(FileNotFoundException e) {//increasing the file were restoring is not found, so the application doesn't crash
		e.printStackTrace();
	}
}
}

