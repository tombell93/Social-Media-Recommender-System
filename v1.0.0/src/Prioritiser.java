
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class Prioritiser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("This is a ranking agent.");
        Gson gson = new GsonBuilder().serializeNulls().create();
    }
}
