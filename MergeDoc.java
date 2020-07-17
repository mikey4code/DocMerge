import java.io.*;
import java.util.*;  
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import org.apache.poi.*; 
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class MergeDoc {
  
  
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
    //get string from doc1
    XWPFWordExtractor ex = new XWPFWordExtractor(src1Document);
    String contents = ex.getText();
    
    FileInputStream fis2 = new FileInputStream(sourceFile2Path);
    XWPFDocument src2Document = new XWPFDocument(fis2);
    //get string from doc2
    XWPFWordExtractor ex2 = new XWPFWordExtractor(src2Document);
    String contents2 = ex2.getText();
    
    //create document(word doc)
    XWPFDocument document = new XWPFDocument();
    
    //output location
    FileOutputStream out = new FileOutputStream("C:\\Users\\MIKEY\\Downloads\\test\\m.docx");
    
    //create paragraph for ouput doc
    XWPFParagraph para = document.createParagraph();
    XWPFRun run = para.createRun();

    //add doc1 content to output file
    run.setText(contents);
    //break to new line
    run.addCarriageReturn();
    //add doc2 content to output
    run.setText(contents2);              
    run.addCarriageReturn(); 
  

    document.write(out); 
    document.close();   
    out.close();
    
    System.out.print("done");
    
    
    
    }catch(IOException e){
    
      System.out.print("Exception");
    
    }
    
  }
 
}
