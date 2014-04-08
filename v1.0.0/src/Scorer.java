
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.HOUR_OF_DAY;
import java.util.Date;
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
//        int testing = 1;
        int testing = 0;
        DataContext dataContext = unscoredDataItem.getDataContext();
        
        if(testing==1){
            r = new Random();
            score = r.nextDouble();            
        }else{
            if("Appointment".equals(unscoredDataItem.getType()) || "Task".equals(unscoredDataItem.getType())){
                // Score according to time until due
                float gamma = 0.0f;
                Calendar currentTime = Calendar.getInstance();
                
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                //get current date time with Date()
//                Date date = new Date();
//                System.out.println(dateFormat.format(date));
//                System.out.println(dateFormat.format(currentTime.getTime()));
//                int secondsTillDue = unscoredDataItem.getDate().
//                unscoredDataItem.getTimeAdded();
                
                
                
                Calendar deadline = (Calendar) unscoredDataItem.getDate().clone();
                Calendar thresholdTime = (Calendar) unscoredDataItem.getDate().clone();
                thresholdTime.add(HOUR_OF_DAY, -1);
                
                System.out.println("deadline " + dateFormat.format(deadline.getTime()));
                System.out.println("thresholdTime " + dateFormat.format(thresholdTime.getTime()));
                System.out.println("currentTime " + dateFormat.format(currentTime.getTime()));
                
                // Deadline after current time
                boolean one = (deadline.compareTo(currentTime) >= 0);
                
                //Current time after threshold time
                boolean two = (currentTime.compareTo(thresholdTime) >= 0);
                
                if(one && two){
                    score += 10.0;
                }           
                
            } else {
                //Check if initial conditions are met
                if(dataContext.getIsSet()){
                    if(    ( userContext.getOnlyReadable() && !dataContext.getIsReadable())
                        || (!userContext.getWantsAdult() && dataContext.getIsAdult())
                        || (!userContext.getWantsCommercial() && dataContext.getIsCommercial())
                        || (!userContext.getWantsEducational() && dataContext.getIsEducational())
                        || (!userContext.getWantsSpam() && dataContext.getIsSpam())
                        || (!userContext.getWantsSubjective() && dataContext.getIsSubjective())){
                        return scoredDataItem;
                    }
                } else {
                    //Calculate score based upon users preferences
                    if(dataContext.getTopic() != null)
                    score += userContext.getFeaturesMap().get(dataContext.getTopic());
//                    for(int i = 0; i < userContext.getFeaturesMap().size(); i++){
                        
//                        if(userContext.getFeaturesMap().get(categories[i])!=null &&
//                                dataContext.getFeaturesMap().get(categories[i])!=null){
//
//                            // Sum components of score
//                            score += userContext.getFeaturesMap().get(categories[i])
//                                * dataContext.getFeaturesMap().get(categories[i]);
//
//                        }
//                    }
                }
            }
            
        }
        scoredDataItem.setScore(score);
        return scoredDataItem;
    }
}
