import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import java.nio.file.Files;
import java.nio.file.Paths;

 
public class newMergeTxt{
 
 public static void main(String[] args) throws Exception{
  
   try {
   //Choose file diag window
    JFileChooser jfc = new JFileChooser();
    jfc.showDialog(null,"Please Select the File");
    jfc.setVisible(true);
    File sourceFile1Path = jfc.getSelectedFile();
     
    //Choose file diag window
    JFileChooser jfc2 = new JFileChooser();
    jfc2.showDialog(null,"Please Select the File");
    jfc2.setVisible(true);
    File sourceFile2Path = jfc2.getSelectedFile();
    
    //get string from txt file 
    String contents = new String(Files.readAllBytes(Paths.get(sourceFile1Path.getAbsolutePath()))); 
    String contents1 = new String(Files.readAllBytes(Paths.get(sourceFile2Path.getAbsolutePath()))); 
  
 
    
    BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\MIKEY\\Downloads\\test\\sample.txt"));
    //write to out file 
    out.write(contents + " ");
    out.write(contents1);
    out.close();
    
   }catch (IOException e) {
    e.printStackTrace();
   }
  
 }
 

}