/**
 * This program receive a txt output file
 * Then output a .doc file 
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

public class save_as_doc{
  
  
  public static void main(String[] args) throws Exception{
    
   
    
    try {
      
    //this receiving a txt output file 
    //We'll have to figure out how to past the output file path 
      
    //Choose file diag window
    JFileChooser jfc = new JFileChooser();
    jfc.showDialog(null,"Please Select the File");
    jfc.setVisible(true);
    File sourceFile1Path = jfc.getSelectedFile();
    
    
    //get string from txt file 
    String contents = new String(Files.readAllBytes(Paths.get(sourceFile1Path.getAbsolutePath()))); 

    //create document(word doc)
    XWPFDocument document = new XWPFDocument();
    
    //output location
    FileOutputStream out = new FileOutputStream("C:\\Users\\MIKEY\\Downloads\\test\\m.docx");
    
    //create paragraph
    XWPFParagraph para = document.createParagraph();
    XWPFRun run = para.createRun();

    //write content from doc file into doc
    run.setText(contents); 
    //add break new line 
    run.addCarriageReturn();
    
    document.write(out); 
    document.close();   
    out.close();
    
    System.out.print("done");
    
    
    }catch(IOException e){
    
      e.printStackTrace();
    
    }
    
  }
  
}
