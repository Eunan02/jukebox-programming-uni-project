package part01;
/**Name:Eunan Diamond Student Number 40293751 Date:31/10/2020
 * This is an enumberation and it is used to implement the Genre of music used in the AudioTrack class
 * All naming conventions have been carried out in this enumberation.
 */
/** 
 * @author Eunan Diamond Student Number 40293751 Date:31/10/2020
 *his is an enumberation and it is used to implement the Genre of music used in the AudioTrack class
 * All naming conventions have been carried out in this enumberation.
 */
public enum Genre {
ROCK(0),POP(1),DANCE(2),JAZZ(3),CLASSICAL(4),OTHER(5); //declaring the enumberation values
private int gNum;//this int is used to find the enumberation value
private String[] genreString= {"Rock and Roll","Easy Listening Pop","Techno Dance","Smooth Jazz","Classical","Unknown Genre"};//this string of arrays is used to delcare the string values of the enumberation
//This constructor is used to find the enumberation value by passing in the int and setting the value passed in equal to the variable num
private  Genre(int value) {
	gNum=value;
}//this method returns a string, which is the string value of the enumberation value, which is known in variable gNum, this method doesn't pass in any parameters
	public String names() {
		return genreString[gNum];
	}
}
