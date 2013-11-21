
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tjb2g11
 */
public class DataContext{
    
    private static String[] categories = {"Arts", "News", 
        "Computers & Technology", "Business & Economy", "Reference & Education", 
        "Health", "Society", "Sports", "Home & Domestic Life", "Shopping", "Recreation & Activities"};
    
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

    public DataContext(){
        
    }
    
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
        categories = aCategories;
    }
    
    /**
     * @return the featuresMap
     */
    public Map<String, Double> getFeaturesMap() {
        return featuresMap;
    }

    /**
     * @param featuresMap the featuresMap to set
     */
    public void setFeaturesMap(Map<String, Double> featuresMap) {
        this.featuresMap = featuresMap;
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
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }
        
}
