
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tjb2g11
 */
public class Context {
    
    private FeaturesList featuresList = new FeaturesList();
    
    public Context(){
        
    }
    
    /**
     * @return the FeaturesList
     */
    public FeaturesList getFeaturesList() {
        return featuresList;
    }

    /**
     * @param adds the FeaturesList to set
     */
    public void setFeaturesList(FeaturesList featuresList) {
        this.featuresList = featuresList;
    }
    
    /**
     * @return the features
     */
    public List<Feature> getFeatures() {
        return featuresList.getFeatures();
    }

    /**
     * @param features the features to set
     */
    public void setFeaturesList(List<Feature> features) {
        this.featuresList.setFeatures(features);
    }
        
}
