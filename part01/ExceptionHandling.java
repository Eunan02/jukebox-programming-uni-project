package part01;
/**
 * 
 * @author Eunan Diamond @StudentNumber 40293751 @Date:1/11/2020
 *This class is used for the validation in the AudioTrack, it is a sub class of the Exception super class
 */
public class ExceptionHandling extends Exception {
private String errorMessage;
public ExceptionHandling() {
	super();
}
public ExceptionHandling(String message) {//constructor which takes one parameter of String
	super(message);
	this.errorMessage=message;
}
public String getErrorMessage(){//this allows the user to be able to get this errormesaage in the main console app meaning it can be outputted
return this.errorMessage;
}
public void setErrorMessage(String em) {//this allows a errormessage to be set in the 
	this.errorMessage=em;
}
}
