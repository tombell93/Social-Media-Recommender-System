
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class FeaturesList {
    
    private static final String[] categories = {"Arts and Entertainment", "Business", 
        "Computers and Internet", "Culture and Politics", "Gaming", "Health",
        "Law and Crime", "Religion", "Recreation", "Science and Technology",
        "Sports", "Weather"};
    
    private List<Feature> features = new ArrayList<Feature>();
    
    public FeaturesList(){
        for(String category: categories){
            Feature feature = new Feature();
            feature.setCategory(category);
            feature.setScore(0.0);
            features.add(feature);
        }
    }
    
    public List<Feature> getNewFeaturesList(){
        List<Feature> newFeaturesList = features;
        return newFeaturesList;
    }
    
    public int getIndexOfCategory(String category){
        for (Feature feature : features){
          if (feature.getCategory().equals(category)){
            return features.indexOf(feature);
          }
        }
        return -1;
    }
    
}
