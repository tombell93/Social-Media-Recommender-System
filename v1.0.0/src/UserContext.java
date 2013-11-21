
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tjb2g11
 */
//TODO: Make this extend/implement general 'Context' class
public class UserContext{

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

    private Calendar currentTime;
    
    private static String[] categories = {"Arts", "News", 
        "Computers & Technology", "Business & Economy", "Reference & Education", 
        "Health", "Society", "Sports", "Home & Domestic Life", "Shopping", "Recreation & Activities"};

    private Map<String, Double> featuresMap = new HashMap<String, Double>();
    
    private String sentiment;
    private Boolean wantsSubjective;
    private Boolean wantsSpam;
    private Boolean wantsAdult;
    private Boolean onlyReadable;
    private String language;
    private Boolean wantsCommercial;
    private Boolean wantsEducational;
    private String gender;   
    private String topic;  

    public UserContext() {
        for(int i = 0; i < categories.length; i++){
            featuresMap.put(categories[i], Double.NaN);
        }
    }

    /**
     * @return the currentTime
     */
    public Calendar getCurrentTime() {
        return currentTime;
    }

    /**
     * @param currentTime the currentTime to set
     */
    public void setCurrentTime(Calendar currentTime) {
        this.currentTime = currentTime;
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
     * @return the wantsSubjective
     */
    public Boolean getWantsSubjective() {
        return wantsSubjective;
    }

    /**
     * @param wantsSubjective the wantsSubjective to set
     */
    public void setWantsSubjective(Boolean wantsSubjective) {
        this.wantsSubjective = wantsSubjective;
    }

    /**
     * @return the wantsSpam
     */
    public Boolean getWantsSpam() {
        return wantsSpam;
    }

    /**
     * @param wantsSpam the wantsSpam to set
     */
    public void setWantsSpam(Boolean wantsSpam) {
        this.wantsSpam = wantsSpam;
    }

    /**
     * @return the wantsAdult
     */
    public Boolean getWantsAdult() {
        return wantsAdult;
    }

    /**
     * @param wantsAdult the wantsAdult to set
     */
    public void setWantsAdult(Boolean wantsAdult) {
        this.wantsAdult = wantsAdult;
    }

    /**
     * @return the onlyReadable
     */
    public Boolean getOnlyReadable() {
        return onlyReadable;
    }

    /**
     * @param onlyReadable the onlyReadable to set
     */
    public void setOnlyReadable(Boolean onlyReadable) {
        this.onlyReadable = onlyReadable;
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
     * @return the wantsCommercial
     */
    public Boolean getWantsCommercial() {
        return wantsCommercial;
    }

    /**
     * @param wantsCommercial the wantsCommercial to set
     */
    public void setWantsCommercial(Boolean wantsCommercial) {
        this.wantsCommercial = wantsCommercial;
    }

    /**
     * @return the wantsEducational
     */
    public Boolean getWantsEducational() {
        return wantsEducational;
    }

    /**
     * @param wantsEducational the wantsEducational to set
     */
    public void setWantsEducational(Boolean wantsEducational) {
        this.wantsEducational = wantsEducational;
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
