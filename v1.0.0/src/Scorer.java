
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
        r = new Random();
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
        //Double score = 0.0;
        scoredDataItem.getDataContext();
        //Make the meat happen here
        
        double score = r.nextDouble();
        
        scoredDataItem.setScore(score);
        return scoredDataItem;
    }
}
