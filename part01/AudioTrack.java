package part01;
/**
 * @author:Eunan Diamond @StudentNumber:40293751 @Date:4/11/2020
 *This is an object class. It is used to declare an Audio Track, with the necessary variables, getters and setters, and methods.
 *This class also uses the sub class of exception which I created, ExceptionHandling, for basic validation for each variable. 
 */
public class AudioTrack implements ITrack{//implementing ITrack ensures it uses all the methods within that interface
private int trackCode;//this variable is the trackcode which uniquely indentfies a track
private static int nextCode=0;//this static variable is used to set the trackcode
private String title;//the title of the track
private String artist;//the track's artist
private int duration;//how long the track lasts in minutes
private Genre style;//the genre of the track,using the enumberation Genre
private String encoding;//the encoding of the track, either wav or mp3
public String errorMessage="";//this is used to set the errormessage for each variable, using the exceptionHandling class
private int songCount=0;// this variable is used to count the amount of times the track has been played
//Constructor-needed to instance the object in main class, it is always public follow by object name and then any parameters
public AudioTrack(String title, String artist,int duration,Genre style,String encoding) {//constructor will takes these parameters
	//setting instances of variables
	setTrackCode();
	this.title=title;
	this.artist=artist;
	this.duration=duration;
	this.style=style;
	this.encoding=encoding;
	this.songCount=0;
}

public String getTitle() {
return this.title;//this will return the title of the track, needed for output in the top10 method in console app
}
//each setter throws ExceptionHandling as it uses this for it's valdation
public void setTitle(String t) throws ExceptionHandling {
//valdation
	if (t.length()==0) {
	errorMessage="You must enter a Track title";
	throw new ExceptionHandling(errorMessage);//throws the exception if it is not valid
}
else if(t.length()>0)
	this.title=t;//setting the title if it valid, bigger than one in length
}
public int getTrackCode() {
	return this.trackCode;//gets the track code, needed for output
}
public void setTrackCode() {
	this.trackCode=useNextCode();//setting the trackcode by using the useNextCode method which sets the track code one bigger than the last track code
}
public String getArtist() {
return	this.artist;//returns the artist name
}
public void setArtist(String a) throws ExceptionHandling {
	//validation
	if (a.length() ==0) {
		errorMessage="You must enter an artist name";
		throw new ExceptionHandling(errorMessage);//throws the exception if it is not valid
	}
	else this.artist=a;//setting the artist name if it valid, bigger than one in length
}
public String getStyle() {
	return this.style.names();//returns the style from the array in Genre which gives it's description
}
public String getStyleInString() {
	return this.style.toString();//returns the style from the array in Genre which gives it name in string, needed for csv file read in
}
public void setStyle(Genre s) {
	this.style=s;//sets the style enumberation value
}
public void setStyle(String s) throws ExceptionHandling {
//validation, matching each input to it's enumberation value
	if ("Rock".equalsIgnoreCase(s.intern())) {
		setStyle(Genre.ROCK);//will set the enumberation value if the String entered in the main console app is valid.
	}
	else if ("Pop".equalsIgnoreCase(s.intern())) {
		setStyle(Genre.POP);
	}
	else if ("Dance".equalsIgnoreCase(s.intern())) {
		setStyle(Genre.DANCE);
	}
	else if ("Jazz".equalsIgnoreCase(s.intern())) {
		setStyle(Genre.JAZZ);
	}
	else if ("Classical".equalsIgnoreCase(s.intern())) {
		setStyle(Genre.CLASSICAL);
	}
	else if ("Other".equalsIgnoreCase(s.intern())){
		setStyle(Genre.OTHER);
	}
	else {// if the user doesn't enter a any valid string for the enumberation value this else statement will be executed.
		errorMessage="No valid Genre entered";//this errormessage will be set
		throw new ExceptionHandling(errorMessage);//and the errormessage will be outputted when this exception is thrown in the main console applcation
	}
}
public String getEncoding() {
	return this.encoding;//this returns the encoding which is needed for outputting it and for csv file
}

public void setEncoding(String s) throws ExceptionHandling {
	//validation, checking if  the user entered a string which has a valid encoding which is either mp3 or wav
	if ("mp3".equalsIgnoreCase(s.intern())) //not dependent on case
	{
		this.encoding=s;//will set the encoding if it is valid
	}
	else if ("wav".equalsIgnoreCase(s.intern()))//not dependent on case
	{
		this.encoding=s;
	}
	else  {//if the user doesn't enter a any valid string for the encoding value this else statement will be executed.
		errorMessage="Encoding must be either wav or mp3";//this errormessage will be set
		throw new ExceptionHandling(errorMessage);//and this will be outputted when this exception is thrown
	}
}
public int getDuration() {
	return this.duration;//this returns the duration which is needed to work out minutes and seconds of track and for csv file read in

}
//used for outputting duration in right format
public int getMinutes() {
	int minutes=getDuration() / 60;
	
	return minutes;
	
}
//used for outputting duration in right format
public int getSeconds() {
	int seconds= getDuration() % 60;
	return seconds;
}
public void setDuration(int d) throws ExceptionHandling {
	if (d>0)
	this.duration=d;//will set duration if it greater than 0
	else{
		errorMessage="A Track can not last 0 seconds or less";
		throw new ExceptionHandling(errorMessage);//will be thrown if the int entered is below 0 with the errormessage which has been set
	}
}
public int getSongCount() {
	return this.songCount;//gets the songCount, which is needed for the top10 method in the console application as well for csv file read in
}
public void setSongCount() {
	this.songCount++;//this is needed to set songcount and is done everytime the song has played
}
/**
 * This method passes no parameters and is used to output all the details of the Audio track, by storing it inside a String
 * @return this returns the string all of details of a trackcode as a string, so it can be outputted
 */
public String getDetails() {
	//used for output of displayAllTracks
	String str="Track Code:"+getTrackCode();
	str+=","+"Title:"+getTitle();
	str+=","+"Artist:"+getArtist();
	str+=","+"Style:"+getStyle();
	str+=","+"Duration:"+getMinutes()+":"+getSeconds()+" Minutes";
	//str+=","+"Duaration:"+getDuration();
	str+=","+"Encoding:"+getEncoding();
	str+=","+"Song Count:"+getSongCount();
	return str;
}
//this class is used to set the TrackCode to the next avaiable Trackcode number, it is void and passes no parameters
private static int useNextCode() {
nextCode++;//the nextCode is increments so next time it is a 1 bigger
	return nextCode;

}
}