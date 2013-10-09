
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public class FileManager {
    
    public FileManager(){
    
    }
    
    /**
     * Appends 'filename' with 'text'
     * @param filename
     * @param text
     * @throws IOException 
     */
    public static void writeFile(String filename, String text) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            fos.write(text.getBytes("UTF-8"));
        } catch (IOException e) {
            close(fos);
            throw e;
        }
    }
    
    /**
     * Reads 'filename' and returns content in String
     * @param filename
     * @return
     * @throws IOException 
     */
    public static String readFile(String filename) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String fileContents;
        
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while(line != null){
            sb.append(line);
            line = br.readLine();
        }
        
        fileContents = sb.toString();
        br.close();
        return fileContents;
        
    }
    
    /**
     * Closes a file
     * @param closeable 
     */
    public static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch(IOException ignored) {
            
        }
    }
    
    
}
