
import com.alchemyapi.api.AlchemyAPI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class DataContextBuilder {
    
    public DataContextBuilder(){
        
    }
    
    public List<DataItem> buildDataContexts(List<DataItem> dataItems)
            throws FileNotFoundException, IOException, SAXException, 
            ParserConfigurationException, XPathExpressionException{
        List<DataItem> dataItemsWithContext = new ArrayList<DataItem>();
        
        // Create an AlchemyAPI object.
        AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromFile("api_key.txt");
        
        for(DataItem dataItem: dataItems){
            DataContext dataContext = new DataContext();  
            
            //TODO: Include more text for this and generate more accurate score
            //TODO: Get category of different text fields and assign score and category to each
            //TODO: Try out alernative scoring API's
            String text = dataItem.getDetail();
            
            if(!text.isEmpty()){
                
                Document doc = alchemyObj.TextGetCategory(text);
                System.out.println(getStringFromDocument(doc));

                String category = doc.getElementsByTagName("category").item(0).getTextContent();

                Double score = Double.parseDouble(doc.getElementsByTagName("score").item(0).getTextContent());

                if(!category.equals("unknown")){
                    int indexOfCategory = new FeaturesList().getIndexOfCategory(category);
                    dataContext.getFeatures().get(indexOfCategory).setScore(score);
                    dataItem.setDataContext(dataContext);
                    dataItemsWithContext.add(dataItem);
                }
            }
            
        }
                
        return dataItemsWithContext;
    }
        
    /**
     * Converts a document (XML in this case) into a String
     * @param doc
     * @return String
     */
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
