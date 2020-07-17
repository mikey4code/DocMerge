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

public class DocTxt_out_doc{
  
  
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
    String contents = new String(Files.readAllBytes(Paths.get(sourceFile2Path.getAbsolutePath()))); 

    FileInputStream fis = new FileInputStream(sourceFile1Path); 
    XWPFDocument src1Document = new XWPFDocument(fis);
    
    //get string from doc file 
    XWPFWordExtractor ex = new XWPFWordExtractor(src1Document);
    String contents2 = ex.getText();

    
    //create document(word doc)
    XWPFDocument document = new XWPFDocument();
    
    //output location
    FileOutputStream out = new FileOutputStream("C:\\Users\\MIKEY\\Downloads\\test\\m.docx");
    
    //create paragraph
    XWPFParagraph para = document.createParagraph();
    XWPFRun run = para.createRun();

    //write content from doc file into doc
    run.setText(contents2); 
    //add break new line 
    run.addCarriageReturn();
    //write the contents from txt file into doc
    run.setText(contents);
    
    document.write(out); 
    document.close();   
    out.close();
    
    System.out.print("done");
    
    
    }catch(IOException e){
    
      e.printStackTrace();
    
    }
    
  }
  
}
