
import java.util.Calendar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tjb2g11
 */
public class DataItem {
    
    private int id;
    private String title;
    private String detail;
    private String type;
    private Double score;
    private String link;
    private Calendar date;
    private String author;
    private String location;
    private String from;
    private String to;
    private String hashtag;
    private int priority;
    private DataContext dataContext = new DataContext();
    private int timeShown; //in minutes
    private Calendar timeAdded;
    
    public DataItem(){
        
    }
    
    public DataItem(String type){
        this.type = type;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the score
     */
    public Double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the hashtag
     */
    public String getHashtag() {
        return hashtag;
    }

    /**
     * @param hashtag the hashtag to set
     */
    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return the dataContext
     */
    public DataContext getDataContext() {
        return dataContext;
    }

    /**
     * @param dataContext the dataContext to set
     */
    public void setDataContext(DataContext dataContext) {
        this.dataContext = dataContext;
    }

    /**
     * @return the timeShown
     */
    public int getTimeShown() {
        return timeShown;
    }

    /**
     * @param timeShown the timeShown to set
     */
    public void setTimeShown(int timeShown) {
        this.timeShown = timeShown;
    }

    /**
     * @return the timeAdded
     */
    public Calendar getTimeAdded() {
        return timeAdded;
    }

    /**
     * @param timeAdded the timeAdded to set
     */
    public void setTimeAdded(Calendar timeAdded) {
        this.timeAdded = timeAdded;
    }
    
}
