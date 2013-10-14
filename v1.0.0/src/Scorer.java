
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class Scorer {
        
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
        
        
        //Make the meat happen here
        
        
        scoredDataItem.setScore(score);
        return scoredDataItem;
    }
}
