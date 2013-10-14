
import com.alchemyapi.api.AlchemyAPI;
import com.alchemyapi.api.AlchemyAPI_CategoryParams;
import com.alchemyapi.api.AlchemyAPI_Params;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

/**
 *
 * @author tom
 */
public class RankingAgent {
    
    private List<DataItem> sortedDataItems = new ArrayList<DataItem>();
    private List<DataItem> unsortedDataItems = new ArrayList<DataItem>();
    private DataItem addedDataItem = new DataItem();
    
    /**
     * TODO: Figure out how to remove old and irrelevant DataItems from list
     * @param unsortedDataItems
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws XPathExpressionException 
     */
    public RankingAgent(List<DataItem> unsortedDataItems) 
            throws IOException, SAXException, 
            ParserConfigurationException, XPathExpressionException{
        this.unsortedDataItems = unsortedDataItems;
    }

    public RankingAgent() {
        
    }
    
    /**
     * TODO: Implement sorting algorithm - modify Insertion sort
     * @return 
     */
    public List<DataItem> sortDataItems() {
        
        

        return sortedDataItems;
    }
    
}
