
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
    UserContext userContext;
    private static String[] categories = {"Arts", "News", 
        "Computers & Technology", "Business & Economy", "Reference & Education", 
        "Health", "Society", "Sports", "Home & Domestic Life", "Shopping", "Recreation & Activities"};
    
    public Scorer(UserContext userContext){
        this.userContext = userContext;
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
        scoredDataItem.setScore(score);
        scoredDataItem.getDataContext();
        int testing = 1;
        //testing = 0;
        DataContext dataContext = unscoredDataItem.getDataContext();
        
        if(testing==1){
            r = new Random();
            score = r.nextDouble();            
        }else{
            //Check if initial conditions are met
            if(         (userContext.getOnlyReadable() && !dataContext.getIsReadable())
                    || (!userContext.getWantsAdult() && dataContext.getIsAdult())
                    || (!userContext.getWantsCommercial() && dataContext.getIsCommercial())
                    || (!userContext.getWantsEducational() && dataContext.getIsEducational())
                    || (!userContext.getWantsSpam() && dataContext.getIsSpam())
                    || (!userContext.getWantsSubjective() && dataContext.getIsSubjective())){
                return scoredDataItem;
            } else {
                //Calculate score based upon users preferences
                for(int i = 0; i < userContext.getFeaturesMap().size(); i++){
                    if(userContext.getFeaturesMap().get(categories[i])!=null &&
                            dataContext.getFeaturesMap().get(categories[i])!=null){
                        score += userContext.getFeaturesMap().get(categories[i])
                            * dataContext.getFeaturesMap().get(categories[i]);
                    }
                }
            }
        }
        scoredDataItem.setScore(score);
        return scoredDataItem;
    }
}
