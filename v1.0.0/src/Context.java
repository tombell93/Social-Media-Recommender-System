
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
    private List<Feature> features;
    
    public Context(){
        features = featuresList.getNewFeaturesList();
    }

    /**
     * @return the features
     */
    public List<Feature> getFeatures() {
        return features;
    }

    /**
     * @param features the features to set
     */
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
        
}
