
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author tom
 */
public class Prioritiser {
    public static RankingAgent rankingAgent;
    public static List<DataItem> rankedDataItems = new ArrayList<DataItem>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
            throws IOException, SAXException, ParserConfigurationException, XPathExpressionException
    {     
        int commandSet = 0;
        
        do{
            Scanner reader = new Scanner(System.in);
            System.out.println("What do you want to do?");
            System.out.println("Commands: \n 1 - Add new item of test data \n "
                    + "2 - Load test data and proceed \n 3 - Close");
            
            int mode = reader.nextInt();

            if(mode == 1) {
                createTestData();
                commandSet = 1;
            } else if(mode == 3) {
                System.out.println("Closing");
                commandSet = 1;
                return;
            } else {
                runRankingAgent();
                commandSet = 1;
            }
        } while(!(commandSet==1));
    }
    
    private static void createTestData() throws IOException{
        TestDataManager.createTestData();
        
    }
    
    public static void runRankingAgent() throws IOException, SAXException, ParserConfigurationException, XPathExpressionException{
        System.out.println("Load test data and proceed.");
        Gson gson = new GsonBuilder().serializeNulls().create();
        String userContextText = FileManager.readFile("testData/UserContext.txt");
        UserContext userContext = gson.fromJson(userContextText, UserContext.class);
        List<DataItem> dataItems = TestDataManager.loadData();
        rankingAgent = new RankingAgent(userContext); 
        rankedDataItems = rankingAgent.update(dataItems);
    }
}
