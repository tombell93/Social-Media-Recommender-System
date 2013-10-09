
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
        
         /* 
+         * 1. Load test data into list of raw data objects
+         * 2. Parse them one by one into:
+         *      a. Parse into DataItem object
+         *          i. Parse data fields from raw data object into DataItem
+         *          ii. Perform topic analysis
+         *          iii. Store topic data in Relevance object
+         *      b. Persist ContextRelevance object
+         *          i. Includes:
+         *              - Time of day
+         *              - Matrix describing users topcic priorities 
+         *              - Matrix describing learned data about users priorities
+         *      c. Perform ranking using good ranking matrix-based algorithm
+         *          i. Give each DataItem a score 
+         *              - Based upon how well Relevance and ContextRelevance
+         *                  objects match
+         *          ii. Maintain unsorted DataItems in List<DataItem>
+         *      d. Place new DataItem into list according to score
+         */

        
    }
}
