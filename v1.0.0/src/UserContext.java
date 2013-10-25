
import java.util.Calendar;

/**
 *
 * @author tjb2g11
 */
//TODO: Make this extend/implement general 'Context' class
public class UserContext extends Context {

    private Calendar currentTime;

    public UserContext() {
        
    }

    /**
     * @return the currentTime
     */
    public Calendar getCurrentTime() {
        return currentTime;
    }

    /**
     * @param currentTime the currentTime to set
     */
    public void setCurrentTime(Calendar currentTime) {
        this.currentTime = currentTime;
    }
    
}
