/**
 * This program take a doc output file 
 * Then output a txt output file 
 * 
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

public class save_as_txt{
  
  
  public static void main(String[] args) throws Exception{
    
    try {
      
    //Choose file diag window
    JFileChooser jfc = new JFileChooser();
    jfc.showDialog(null,"Please Select the File");
    jfc.setVisible(true);
    File sourceFile1Path = jfc.getSelectedFile();
     
    
    FileInputStream fis = new FileInputStream(sourceFile1Path); 
    XWPFDocument src1Document = new XWPFDocument(fis);
    XWPFWordExtractor ex = new XWPFWordExtractor(src1Document);
    String contents = ex.getText();
  
    BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\MIKEY\\Downloads\\test\\sample.txt"));
     
    //write to out file 
    out.write(contents + " ");
    out.close();
    
    System.out.print("done");
    
    
    }catch(IOException e){
    
      e.printStackTrace();
    
    }
    
  }
  
}
