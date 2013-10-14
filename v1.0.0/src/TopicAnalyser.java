
import com.alchemyapi.api.AlchemyAPI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author tom
 */
public class TopicAnalyser {
    
    public TopicAnalyser(){
        
    }
    
    public List<DataItem> getTopics(List<DataItem> dataItem){
        List<DataItem> dataItemsWithTopic = new ArrayList<DataItem>();
        
        return dataItemsWithTopic;
    }
    
    /**
     * TODO: Get topic and set Topic object for each DataItem
     * @return 
     */
    public DataItem getTopic() throws FileNotFoundException, IOException, SAXException, ParserConfigurationException, XPathExpressionException{
        DataItem dataItemWithTopic = new DataItem();
        
        // Create an AlchemyAPI object.
        AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromFile("api_key.txt");
        String text = "a bible holiday bursting with life";        
        Document doc = alchemyObj.TextGetCategory(text);
        System.out.println(getStringFromDocument(doc));
        
        return dataItemWithTopic;
    }
    
    // utility method
    private String getStringFromDocument(Document doc) {
        try {
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);

            return writer.toString();
        } catch (TransformerException ex) {
            return null;
        }
    }
}
