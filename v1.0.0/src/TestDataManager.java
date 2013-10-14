
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class TestDataManager {

    public TestDataManager(){
        
    }
    
    public static void createTestData() throws IOException{
                
        int invalidCommand = 1;
        do{
            invalidCommand = 0;
            Scanner reader = new Scanner(System.in);
            System.out.println("Select data type.");
            System.out.println("Commands: "
                    + "\n 1 - Appointment"
                    + "\n 2 - Email"
                    + "\n 3 - Facebook status"
                    + "\n 4 - SMS"
                    + "\n 5 - Task"
                    + "\n 6 - Tweet"
                    + "\n 7 - Cancel request");
            int mode = reader.nextInt();
            
            switch(mode){
                case 1:
                    addTestData("Appointment");
                    break;
                case 2:
                    addTestData("Email");
                    break;
                case 3:
                    addTestData("FacebookStatus");
                    break;
                case 4:
                    addTestData("SMS");
                    break;
                case 5:
                    addTestData("Task");
                    break;
                case 6:
                    addTestData("Tweet");
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Incorrect command.");
                    invalidCommand = 1;
            }

        } while(invalidCommand==1);
    }
    
    public static List<DataItem> loadData() throws IOException{
        List<DataItem> dataItems = new ArrayList<DataItem>();
        
        Scanner reader = new Scanner(System.in);
        System.out.println("Which data type do you want to load?");
        System.out.println("Seperate by commas (no spaces): "
                + "\n 1 - Appointment"
                + "\n 2 - Email"
                + "\n 3 - Facebook status"
                + "\n 4 - SMS"
                + "\n 5 - Task"
                + "\n 6 - Tweet"
                + "\n 7 - Cancel request");
        String userInput = reader.nextLine();

        String dataTypes = "[" + userInput + "]";
        String[] items = dataTypes.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
        List<Integer> results = new ArrayList<Integer>();

        //Place each number into a list of integers representing data types
        for (int i = 0; i < items.length; i++) {
            try {
                results.add(Integer.parseInt(items[i]));
            } catch (NumberFormatException nfe) {}
        }

        if(results.contains(1)){
            dataItems.addAll(loadTestData("Appointment"));
        } 
        if (results.contains(2)){
            dataItems.addAll(loadTestData("Email"));
        } 
        if (results.contains(3)){
            dataItems.addAll(loadTestData("FacebookStatus"));
        } 
        if (results.contains(4)){
            dataItems.addAll(loadTestData("SMS"));
        } 
        if (results.contains(5)){
            dataItems.addAll(loadTestData("Task"));
        } 
        if (results.contains(6)){
            dataItems.addAll(loadTestData("Tweet"));
        }
        
        return dataItems;
        
    }
    
    public static List<String> listFilesInFolder(final File folder) {
        List<String> fileNames = new ArrayList<String>();
        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()){
                fileNames.add(fileEntry.getName());
            }
        }
        return fileNames;
    }
    
    private static int addTestData(String dataType) throws IOException {
        System.out.println("Adding " + dataType);
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        int uniqueFilePath = rand.nextInt(10000000);
        
        String filePath = "testData/" + dataType + "/" 
                + Integer.toString(uniqueFilePath) + ".txt";
        
        Gson gson = new GsonBuilder().serializeNulls().create();
        DataItem dataItem = new DataItem(dataType);
        
        //Types: Appointment  Email  FacebookStatus  SMS  Task  Tweet
        if(dataType.equals("Appointment")){
            System.out.println("Enter title:");
            dataItem.setTitle(reader.nextLine());

            System.out.println("Enter content:");
            dataItem.setDetail(reader.nextLine());
            
            System.out.println("Enter location:");
            dataItem.setLocation(reader.nextLine());

            //Asks them for a date
            System.out.println("Set a date (y/n)?");
            if(reader.nextLine().equals("y")){
                dataItem.setDate(setTestDate());
            }

        } else if(dataType.equals("Email")){
            System.out.println("Enter subject:");
            dataItem.setTitle(reader.nextLine());

            System.out.println("Enter content:");
            dataItem.setDetail(reader.nextLine());

            System.out.println("Enter from:");
            dataItem.setFrom(reader.nextLine());

            System.out.println("Enter to:");
            dataItem.setTo(reader.nextLine());

            //Asks them for a date
            System.out.println("Set a date of arrival (y/n)?");
            if(reader.nextLine().equals("y")){
                dataItem.setDate(setTestDate());
            }

        } else if(dataType.equals("FacebookStatus")){
            System.out.println("Enter content:");
            dataItem.setDetail(reader.nextLine());

            System.out.println("Enter author:");
            dataItem.setAuthor(reader.nextLine());

            System.out.println("Enter hashtags:");
            dataItem.setHashtag(reader.nextLine());

            //Asks them for a date
            System.out.println("Set a date of post(y/n)?");
            if(reader.nextLine().equals("y")){
                dataItem.setDate(setTestDate());
            }

            System.out.println("Enter link:");
            dataItem.setLink(reader.nextLine());
            
        } else if(dataType.equals("SMS")){
            System.out.println("Enter content:");
            dataItem.setDetail(reader.nextLine());

            System.out.println("Enter from:");
            dataItem.setFrom(reader.nextLine());

            //Asks them for a date
            System.out.println("Set a date of arrival(y/n)?");
            if(reader.nextLine().equals("y")){
                dataItem.setDate(setTestDate());
            }

        } else if(dataType.equals("Task")){
            System.out.println("Enter title:");
            dataItem.setTitle(reader.nextLine());

            System.out.println("Enter content:");
            dataItem.setDetail(reader.nextLine());
            
            //Asks them for a date
            System.out.println("Set a due date (y/n)?");
            if(reader.nextLine().equals("y")){
                dataItem.setDate(setTestDate());
            }
            
            System.out.println("Enter priority:");
            dataItem.setPriority(reader.nextInt());

        } else if(dataType.equals("Tweet")){
            System.out.println("Enter content:");
            dataItem.setDetail(reader.nextLine());

            System.out.println("Enter author:");
            dataItem.setAuthor(reader.nextLine());

            System.out.println("Enter hashtags:");
            dataItem.setHashtag(reader.nextLine());

            //Asks them for a date
            System.out.println("Set a date of tweet(y/n)?");
            if(reader.nextLine().equals("y")){
                dataItem.setDate(setTestDate());
            }

            System.out.println("Enter link:");
            dataItem.setLink(reader.nextLine());
        }
                
        
        String json = gson.toJson(dataItem);  
        FileManager.writeFile(filePath, json);
        return 0;
    }
    
    private static Calendar setTestDate(){
        Scanner reader = new Scanner(System.in);
        int year, month, date, hourOfDay, minute;
        Calendar calendar = Calendar.getInstance();
        System.out.println("Enter date (i.e. 10):");
        date = reader.nextInt();
        System.out.println("Enter month (i.e. 2):");
        month = reader.nextInt();
        System.out.println("Enter year (i.e. 1993):");
        year = reader.nextInt();
        System.out.println("Enter hour (i.e. 19):");
        hourOfDay = reader.nextInt();
        System.out.println("Enter minute (i.e. 36):");
        minute = reader.nextInt();
        calendar.set(year, month, date, hourOfDay, minute);
        return calendar;
    }
    
    private static List<DataItem> loadTestData(String dataType) throws IOException {
        List<DataItem> dataItems = new ArrayList<DataItem>();
        Gson gson = new GsonBuilder().serializeNulls().create();
        System.out.println("Loading " + dataType);
        DataItem dataItem = new DataItem();
        final File folder = new File("testData/" + dataType);
        List<String> files = TestDataManager.listFilesInFolder(folder);
        
        //TODO: Open each file in folder and load as DataItem to return
        for(Iterator<String> i = files.iterator(); i.hasNext(); ) {
            String file = folder.getPath() + "/" + i.next();
            System.out.println("Loading " + file);
            String fileContent = FileManager.readFile(file);
            dataItem = gson.fromJson(fileContent, DataItem.class);
            dataItems.add(dataItem);
        }
        return dataItems;
    }

}
