
import java.util.ArrayList;
import java.util.List;

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
    
    public List<DataItem> buildDataContexts(List<DataItem> dataItems){
        List<DataItem> dataItemsWithContext = new ArrayList<DataItem>();
        
        for(DataItem dataItem: dataItems){
            DataContext dataContext = new DataContext();
            //TODO: alchemy stuff in here. Set data Context up
            
            dataItem.setDataContext(dataContext);
            dataItemsWithContext.add(dataItem);
        }
                
        return dataItemsWithContext;
    }
}
