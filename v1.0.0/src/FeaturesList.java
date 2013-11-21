
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tom
 */
public class FeaturesList {
    
    private static String[] categories = {"Arts", "News", 
        "Computers & Technology", "Business & Economy", "Reference & Education", 
        "Health", "Society", "Sports", "Home & Domestic Life", "Shopping", "Recreation & Activities"};

    private List<Feature> features = new ArrayList<Feature>();
    private Map<String, Double> featuresMap = new HashMap<String, Double>();
    
    private String sentiment;
    private Boolean isSubjective;
    private Boolean isSpam;
    private Boolean isAdult;
    private Boolean isReadable;
    private String language;
    private Boolean isCommercial;
    private Boolean isEducational;
    private String gender;   
    private String topic;   
    
    /**
     * @return the categories
     */
    public static String[] getCategories() {
        return categories;
    }

    /**
     * @param aCategories the categories to set
     */
    public static void setCategories(String[] aCategories) {
        setCategories(aCategories);
    } 
    
    public FeaturesList(){
        for(String category: categories){
            Feature feature = new Feature();
            feature.setCategory(category);
            feature.setScore(0.0);
            features.add(feature);
        }
    }
    
    public List<Feature> getNewFeaturesList(){
        List<Feature> newFeaturesList = getFeatures();
        return newFeaturesList;
    }
    
    public int getIndexOfCategory(String category){
        for (Feature feature : getFeatures()){
          if (feature.getCategory().equals(category)){
            return getFeatures().indexOf(feature);
          }
        }
        return -1;
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

    /**
     * @return the sentiment
     */
    public String getSentiment() {
        return sentiment;
    }

    /**
     * @param sentiment the sentiment to set
     */
    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    /**
     * @return the isSubjective
     */
    public Boolean getIsSubjective() {
        return isSubjective;
    }

    /**
     * @param isSubjective the isSubjective to set
     */
    public void setIsSubjective(Boolean isSubjective) {
        this.isSubjective = isSubjective;
    }

    /**
     * @return the isSpam
     */
    public Boolean getIsSpam() {
        return isSpam;
    }

    /**
     * @param isSpam the isSpam to set
     */
    public void setIsSpam(Boolean isSpam) {
        this.isSpam = isSpam;
    }

    /**
     * @return the isAdult
     */
    public Boolean getIsAdult() {
        return isAdult;
    }

    /**
     * @param isAdult the isAdult to set
     */
    public void setIsAdult(Boolean isAdult) {
        this.isAdult = isAdult;
    }

    /**
     * @return the isReadable
     */
    public Boolean getIsReadable() {
        return isReadable;
    }

    /**
     * @param isReadable the isReadable to set
     */
    public void setIsReadable(Boolean isReadable) {
        this.isReadable = isReadable;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the isCommercial
     */
    public Boolean getIsCommercial() {
        return isCommercial;
    }

    /**
     * @param isCommercial the isCommercial to set
     */
    public void setIsCommercial(Boolean isCommercial) {
        this.isCommercial = isCommercial;
    }

    /**
     * @return the isEducational
     */
    public Boolean getIsEducational() {
        return isEducational;
    }

    /**
     * @param isEducational the isEducational to set
     */
    public void setIsEducational(Boolean isEducational) {
        this.isEducational = isEducational;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the category
     */
    public String getTopic() {
        return topic;
    }

    /**
     * @param category the category to set
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }
    
}
