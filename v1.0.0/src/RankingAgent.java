
import com.alchemyapi.api.AlchemyAPI;
import com.alchemyapi.api.AlchemyAPI_CategoryParams;
import com.alchemyapi.api.AlchemyAPI_Params;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

/**
 *
 * @author tom
 */
public class RankingAgent {
    private final static int ACCURACY = 1000;
    private List<DataItem> sortedDataItems = new ArrayList<DataItem>();
    private List<DataItem> unsortedDataItems = new ArrayList<DataItem>();
    private DataItem addedDataItem = new DataItem();
    private Scorer scorer;
    private UserContext userContext;
    private DataContextBuilder dataContextBuilder = new DataContextBuilder();
    private static String[] categories = {"Arts", "News", 
        "Computers & Technology", "Business & Economy", "Reference & Education", 
        "Health", "Society", "Sports", "Home & Domestic Life", "Shopping", "Recreation & Activities"};
    
    /**
     * TODO: Figure out how to remove old and irrelevant DataItems from list
     * @param unsortedDataItems
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws XPathExpressionException 
     */
    public RankingAgent(List<DataItem> unsortedDataItems) 
            throws IOException, SAXException, 
            ParserConfigurationException, XPathExpressionException{
        this.unsortedDataItems = unsortedDataItems;
    }
    
    public RankingAgent(UserContext userContext) {
        //initialiseRankingAgent();
        this.userContext = userContext;
        scorer = new Scorer(userContext);
    }
        
    /**
     * Accepts new DataItems and returns the most recent ranked list
     * @param addedDataItems
     * @return 
     */
    public List<DataItem> update(List<DataItem> addedDataItems) 
            throws FileNotFoundException, IOException, SAXException, 
            ParserConfigurationException, XPathExpressionException{
        List<DataItem> dataItemsWithContext = new ArrayList<DataItem>();
        
        System.out.println("Building data contexts");   
        dataItemsWithContext = 
                dataContextBuilder.buildDataContexts(addedDataItems);
        
        //TODO: Implement 3rd
        //Score new DataItems before sorting
        System.out.println("Scoring data");  
        List<DataItem> newScoredDataItems = 
                scorer.scoreDataItems(dataItemsWithContext);
        
        //Adds new scored DataItems to ranked list in correct place
        System.out.println("Building data contexts");  
        sortedDataItems = sortNewScoredDataItems(newScoredDataItems);
        
        //TODO: Implement 4th  
        //runMaintenance();
        
        System.out.println("End of program");        
        return sortedDataItems;
    }
    
    /**
     * If only a single DataItem is added, add to list and call update(List<>)
     * @param addedDataItem
     * @return 
     */
    public List<DataItem> update(DataItem addedDataItem)
            throws FileNotFoundException, IOException, SAXException, 
            ParserConfigurationException, XPathExpressionException{
        List<DataItem> addedDataItems = new ArrayList<DataItem>();
        addedDataItems.add(addedDataItem);
        return update(addedDataItems);
    }
    
    /**
     * TODO: Implement sorting algorithm - modify Insertion sort
     * Return the complete list of ordered DataItem's
     * @return 
     */
    private List<DataItem> sortNewScoredDataItems(List<DataItem> unsortedDataItems) {
        List<DataItem> tempDataItems = sortedDataItems;
        tempDataItems.addAll(unsortedDataItems);
        //Insert unsortedDataItems into tempDataItems
        
        for (DataItem dataItem : tempDataItems){
            System.out.println("Before sorting on price: " + dataItem.getScore().toString());
        }
        
        Collections.sort(tempDataItems, comparator);

        for (DataItem dataItem : tempDataItems){
            System.out.println("After sorting on price: " + dataItem.getScore().toString());
        }
        
        //When implemented return tempDataItems
        return unsortedDataItems;   
    }
    
    private static Comparator<DataItem> comparator = new Comparator<DataItem>()
    {
        public int compare(DataItem o1, DataItem o2)
        {
            return (int)((o1.getScore() - o2.getScore())*ACCURACY);
        }
    };

    private void runMaintenance() {
        //Maintain sortedDataItems by reviewing the relevance of each
        //Remove DataItems which have become irrelevant
    }

    private void updateShownTimes() {
        List<DataItem> updatedShownTimesDataItems = new ArrayList();
        for(Iterator<DataItem> dataItem = sortedDataItems.iterator(); dataItem.hasNext(); ) {
            DataItem dataItemToUpdate = dataItem.next();
            int timeShown = 1;
            
            //TODO: Compare 'timeAdded' with current time to update 'timeShown' in minutes
            //dataItem.next().setTimeShown(timeShown);
            dataItemToUpdate.setTimeShown(timeShown);
            updatedShownTimesDataItems.add(dataItemToUpdate);
        }
        return;
    }
    
    private void initialiseRankingAgent() {
        //TODO: Load UserContext
        UserContext userContext = new UserContext();
        userContext.setGender(null);
        userContext.setGender("male");
        userContext.setWantsAdult(Boolean.FALSE);
        userContext.setWantsCommercial(Boolean.TRUE);
        userContext.setWantsEducational(Boolean.TRUE);
        userContext.setOnlyReadable(Boolean.TRUE);
        userContext.setWantsSpam(Boolean.TRUE);
        userContext.setWantsSubjective(Boolean.TRUE);
        userContext.setLanguage("en");
        userContext.setSentiment("neutral");
        userContext.setTopic("News");
        Map<String, Double> featuresMap = new HashMap<String, Double>();
        for(int i = 0; i < categories.length; i++){
            featuresMap.put(categories[i], 5.0);
        }
        userContext.setFeaturesMap(featuresMap);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(userContext);  
        try {
            FileManager.writeFile("testData/UserContext.txt", json);
        } catch (IOException ex) {
            Logger.getLogger(RankingAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
