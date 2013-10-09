
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
    public static void main(String[] args) throws IOException {
                
        int commandSet = 0;
        
        do{
            Scanner reader = new Scanner(System.in);
            System.out.println("What do you want to do?");
            System.out.println("Commands: \n 1 - Add new item of test data \n 2 - Load test data and proceed");

            int mode = reader.nextInt();

            if(mode == 1) {
                createTestData();
                commandSet = 1;
            } else if(mode == 2) {
                runPrioritiser();
                commandSet = 1;
            } else {
                System.out.println("Incorrect command.");
            }
        } while(!(commandSet==1));
        
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
    
    private static void createTestData() throws IOException{
        TestDataManager.createTestData();
        
    }
    
    public static void runPrioritiser() throws IOException{
        System.out.println("Load test data and proceed.");
        List<DataItem> dataItems = TestDataManager.loadData();
    }
    
    
}
