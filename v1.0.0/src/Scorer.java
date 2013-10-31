
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class Scorer {
        
    Random r;
    
    public Scorer(){
        
    }
    
    public List<DataItem> scoreDataItems(List<DataItem> unscoredDataItems){
        List<DataItem> scoredDataItems = new ArrayList<DataItem>();
        for(DataItem unscoredDataItem: unscoredDataItems){
            scoredDataItems.add(scoreDataItem(unscoredDataItem));
        }
        return scoredDataItems;
    }
    
    /**
     * Scores each DataItem
     * @param unscoredDataItem
     * @return 
     */
    public DataItem scoreDataItem(DataItem unscoredDataItem){
        DataItem scoredDataItem = unscoredDataItem;
        Double score = 0.0;
        scoredDataItem.getDataContext();
        int testing = 1;
        //testing = 0;
        
        if(testing==1){
            r = new Random();
            score = r.nextDouble();            
        }else{
            //Make the meat happen here
            //TODO: 1st Create user context before this - JavaDB
            
            
        }
        
        
        
        scoredDataItem.setScore(score);
        return scoredDataItem;
    }
}
