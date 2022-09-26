package part01;
/**
 * 
 * @author eunan Diamond @StudentNumber 40293751 Date 11/11/2020
 *This interface is used to ensure AudioTrack uses these methods
 *
 */
public interface ITrack {
	public String getDetails();
	public String getTitle();
	public String getArtist();
	public int getDuration();
	public String getStyle();
	public String getEncoding();
}
