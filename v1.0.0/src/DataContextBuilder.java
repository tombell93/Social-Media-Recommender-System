
import com.alchemyapi.api.AlchemyAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class DataContextBuilder {
    
    SentimentAPI sentimentAPI = new SentimentAPI();
    Gson gson = new GsonBuilder().serializeNulls().create();
    String result;
    
    public DataContextBuilder(){
        
    }
    
    public List<DataItem> buildDataContexts(List<DataItem> dataItems){
        List<DataItem> dataItemsWithContext = new ArrayList<DataItem>();
        
        // Create an AlchemyAPI object.
//        AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromFile("api_key.txt");
        
        for(DataItem dataItem: dataItems){
            DataContext dataContext = new DataContext();  
            //TODO: Include more text for this and generate more accurate score
            //TODO: Get category of different text fields and assign score and category to each
            String text = dataItem.getDetail();
            
            if(!text.isEmpty()){
                String tempValue = null;
                JSONObject temp;
                JSONObject object;
                
                //Subjectivity detection
                temp = (JSONObject) JSONValue.parse(sentimentAPI.SubjectivityAnalysis(text));
                object = (JSONObject) JSONValue.parse(temp.get("output").toString());
                dataContext.setIsSubjective(("objective".equals(object.get("result").toString())?false:true));
                
                //Gender detection
                temp = (JSONObject) JSONValue.parse(sentimentAPI.GenderDetection(text));
                object = (JSONObject) JSONValue.parse(temp.get("output").toString());
                dataContext.setGender(object.get("result").toString());
                
                //Spam detection
                temp = (JSONObject) JSONValue.parse(sentimentAPI.SpamDetection(text));
                object = (JSONObject) JSONValue.parse(temp.get("output").toString());
                dataContext.setIsSpam(("nospam".equals(object.get("result").toString())?false:true));
                
                //Adult content detection
                temp = (JSONObject) JSONValue.parse(sentimentAPI.AdultContentDetection(text));
                object = (JSONObject) JSONValue.parse(temp.get("output").toString());
                dataContext.setIsAdult(("noadult".equals(object.get("result").toString())?false:true));
                
                //Readability detection
                temp = (JSONObject) JSONValue.parse(sentimentAPI.ReadabilityAssessment(text));
                object = (JSONObject) JSONValue.parse(temp.get("output").toString());
                dataContext.setIsReadable(("advanced".equals(object.get("result").toString())?false:true));
                
                //Commercial detection
                temp = (JSONObject) JSONValue.parse(sentimentAPI.ReadabilityAssessment(text));
                object = (JSONObject) JSONValue.parse(temp.get("output").toString());
                dataContext.setIsCommercial(("commercial".equals(object.get("result").toString())?true:false));
                
                //Educational detection
                temp = (JSONObject) JSONValue.parse(sentimentAPI.EducationalDetection(text));
                object = (JSONObject) JSONValue.parse(temp.get("output").toString());
                dataContext.setIsEducational(("educational".equals(object.get("result").toString())?true:false));
                    
                //Educational detection
                temp = (JSONObject) JSONValue.parse(sentimentAPI.TopicClassification(text));
                object = (JSONObject) JSONValue.parse(temp.get("output").toString());
                dataContext.setTopic(object.get("result").toString());
            }
            dataItem.setDataContext(dataContext);
        }
                
        return dataItemsWithContext;
    }
        
//    /**
//     * Converts a document (XML in this case) into a String
//     * @param doc
//     * @return String
//     */
//    private String getStringFromDocument(Document doc) {
//        try {
//            DOMSource domSource = new DOMSource(doc);
//            StringWriter writer = new StringWriter();
//            StreamResult result = new StreamResult(writer);
//
//            TransformerFactory tf = TransformerFactory.newInstance();
//            Transformer transformer = tf.newTransformer();
//            transformer.transform(domSource, result);
//
//            return writer.toString();
//        } catch (TransformerException ex) {
//            return null;
//        }
//    }
}
