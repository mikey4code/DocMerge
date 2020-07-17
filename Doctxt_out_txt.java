/**
 * This program merge .doc and .txt file 
 * Where the output file is a .doc file 
 * NOTE : have to choose doc first then txt
 * 
*/


import java.io.*;
import java.util.*;  
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import org.apache.poi.*; 
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Doctxt_out_txt {
  
  
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
    
    
    FileInputStream fis = new FileInputStream(sourceFile1Path); 
    XWPFDocument src1Document = new XWPFDocument(fis);
    XWPFWordExtractor ex = new XWPFWordExtractor(src1Document);
    String contents = ex.getText();
    
    //get string from txt file 
    String contents2 = new String(Files.readAllBytes(Paths.get(sourceFile2Path.getAbsolutePath()))); 

    BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\MIKEY\\Downloads\\test\\sample.txt"));
     
    //write to out file 
    out.write(contents + " ");
    out.write(contents2);
    out.close();
    
    System.out.print("done");
    
    
    }catch(IOException e){
    
      e.printStackTrace();
    
    }
    
  }
  
}
