import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//MergeTxt imports
import java.io.*;

import javax.swing.JFileChooser;
 

public class TestGUI {
	
	File file1;
	File file2;
	File file3;

	private JFrame frmHi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI window = new TestGUI();
					window.frmHi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHi = new JFrame();
		frmHi.setTitle("Multiple Document Combination Software");
		frmHi.setBounds(100, 100, 385, 278);
		frmHi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmHi.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab(".txt", null, panel_1, "For text files");
		panel_1.setLayout(null);
		
		JLabel lblMergeTextFiles = new JLabel("Choose text files to combine");
		lblMergeTextFiles.setBounds(97, 11, 265, 14);
		panel_1.add(lblMergeTextFiles);
		
		final JLabel txtfilename1 = new JLabel("No file selected");
		txtfilename1.setBounds(177, 36, 172, 14);
		panel_1.add(txtfilename1);
		
		JButton btnFirstFile = new JButton("First File");
		btnFirstFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//try{
				JFileChooser jfc = new JFileChooser();
				jfc.showDialog(null,"Please select a text file");
				jfc.setVisible(true);
				File sourceFile1Path = jfc.getSelectedFile();
				txtfilename1.setText(sourceFile1Path.getName());
				file1 = sourceFile1Path;
				/*}catch(IOException e){
					JOptionPane.showMessageDialog(null, "Input error");
				*/
				
			}
		});
		btnFirstFile.setBounds(63, 36, 104, 23);
		panel_1.add(btnFirstFile);
		
		final JLabel txtfilename2 = new JLabel("No file selected");
		txtfilename2.setBounds(177, 70, 172, 14);
		panel_1.add(txtfilename2);
		
		JButton btnSecondFile = new JButton("Second File");
		btnSecondFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc2 = new JFileChooser();
				jfc2.showDialog(null, "Please select a text file");
				jfc2.setVisible(true);
				File sourceFile2path = jfc2.getSelectedFile();
				txtfilename2.setText(sourceFile2path.getName());
				file2 = sourceFile2path;
			}
		});
		btnSecondFile.setBounds(63, 70, 104, 23);
		panel_1.add(btnSecondFile);
		
		final JLabel txtfilename3 = new JLabel("No file selected");
		txtfilename3.setBounds(177, 104, 172, 14);
		panel_1.add(txtfilename3);
		
		JButton btnThirdFile = new JButton("Third File");
		btnThirdFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc3 = new JFileChooser();
				jfc3.showDialog(null, "Please select a text file");
				jfc3.setVisible(true);
				File sourceFile3path = jfc3.getSelectedFile();
				txtfilename3.setText(sourceFile3path.getName());
				file3 = sourceFile3path;
			}
		});
		btnThirdFile.setBounds(63, 104, 104, 23);
		panel_1.add(btnThirdFile);
		
		JButton btnCombineTxt = new JButton("Combine!");
		btnCombineTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//add fancy exception handling soon, like if the user only selected 2 files (when we support 3)
				File[] FileArray = new File[2]; //change to 3 when adding support for a third file
				FileArray[0] = file1;
				FileArray[1] = file2;
				//FileArray[3] = file3;
				File mergedFile = new File("C:/Users/Patrick/Desktop/mdcs/output.txt");
				
				  FileWriter fstream = null;
				  BufferedWriter out = null;
				  try {
				   fstream = new FileWriter(mergedFile, true);
				    out = new BufferedWriter(fstream);
				  } catch (IOException e1) {
				   e1.printStackTrace();
				  }
				 
				  for (File f : FileArray) {
				   System.out.println("merging: " + f.getName());
				   FileInputStream fis;
				   try {
				    fis = new FileInputStream(f);
				    BufferedReader in = new BufferedReader(new InputStreamReader(fis));
				 
				    String aLine;
				    while ((aLine = in.readLine()) != null) {
				     out.write(aLine);
				     out.newLine();
				    }
				 
				    in.close();
				   } catch (IOException e) {
				    e.printStackTrace();
				   }
				  }
				 
				  try {
				   out.close();
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
				

			}
		});
		btnCombineTxt.setBounds(107, 141, 119, 23);
		panel_1.add(btnCombineTxt);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab(".doc/.docx", null, panel, "For microsoft word documents.");
		panel.setLayout(null);
		
		JLabel lblMergeMicrosoftWord = new JLabel("Choose Microsoft Word Documents to combine");
		lblMergeMicrosoftWord.setBounds(61, 11, 301, 14);
		panel.add(lblMergeMicrosoftWord);
		
		JButton btnFirstDocument = new JButton("First Document");
		btnFirstDocument.setBounds(34, 46, 160, 23);
		panel.add(btnFirstDocument);
		
		JButton btnSecondDocument = new JButton("Second Document");
		btnSecondDocument.setBounds(34, 80, 160, 23);
		panel.add(btnSecondDocument);
		
		JButton btnThirdDocument = new JButton("Third Document");
		btnThirdDocument.setBounds(34, 114, 160, 23);
		panel.add(btnThirdDocument);
		
		JButton btnCombineDoc = new JButton("Combine!");
		btnCombineDoc.setBounds(130, 148, 91, 23);
		panel.add(btnCombineDoc);
	}
}
