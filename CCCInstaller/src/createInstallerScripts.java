/*  -------------------------------------------------------
 *  createInstallerScripts.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Email:   composite.computing@gmail.com
 *  Date:	 Oct 9, 2018
 *  ------------------------------------------------------- */

// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class createInstallerScripts extends batchandbashHAF {
	// Panels
	private JPanel p2 = new JPanel(); // holds p4-p6
	private JPanel p3 = new JPanel(); // holds p7-p8
	private JPanel p4 = new JPanel(); // Tools Panel
	private JPanel p5 = new JPanel(); // Browsers Panel
	private JPanel p6 = new JPanel(); // Media Players Panel
	private JPanel p7 = new JPanel(); // Office Tools
	private JPanel p8 = new JPanel(); // Antivirus/Programming Panel
	private JPanel p9 = new JPanel(); // holds button
	private JPanel p10 = new JPanel();

	// Button 
	private JButton genScript = new JButton("Generate Script!");
	private ButtonGroup bgGroup = new ButtonGroup();
	
	// JCheckBoxes
	private JCheckBox vnc = new JCheckBox("TightVNC"); 
	private JCheckBox sevenZip = new JCheckBox("7zip"); 
	private JCheckBox cCleaner = new JCheckBox("C-Cleaner"); 
	private JCheckBox chrome = new JCheckBox("Google Chrome Browser"); 
	private JCheckBox eclipse = new JCheckBox("Eclipse IDE"); 
	private JCheckBox firefox = new JCheckBox("Firefox Browser"); 
	private JCheckBox frostwire = new JCheckBox("Frostwire");
	private JCheckBox googleEarth = new JCheckBox("Google Earth Pro"); 
	private JCheckBox iTunes = new JCheckBox("iTunes"); 
	private JCheckBox libreOffice = new JCheckBox("Libre Office"); 
	private JCheckBox openOffice = new JCheckBox("Open Office"); 
	private JCheckBox malwarebytes = new JCheckBox("Malwarebytes");
	private JCheckBox notepadplusplus = new JCheckBox("Notepad++"); 
	private JCheckBox pdfTools = new JCheckBox("PDF Tools"); 
	private JCheckBox python = new JCheckBox("Python Programming Language"); 
	private JCheckBox vlc = new JCheckBox("VLC"); 
	private JCheckBox adobeFlash = new JCheckBox("Adobe Flash Player"); 
	private JCheckBox adobeReader = new JCheckBox("Adobe Acrobat Reader"); 
	private JCheckBox tor = new JCheckBox("Tor Browser"); 
	private JCheckBox winDiskImager = new JCheckBox("win32DiskImager"); 
	private JCheckBox ipVanish = new JCheckBox("IPVanish VPN");
	private JCheckBox bitdefender = new JCheckBox("Bitdefender");
	private JCheckBox komodoEdit = new JCheckBox("Komodo Edit");
	private JCheckBox office2016 = new JCheckBox("Microsoft Office 2016");
	private JCheckBox silverlight = new JCheckBox("Microsoft Silverlight");
	private JCheckBox online = new JCheckBox("Online Installer (must have internet)");
	private JCheckBox offline = new JCheckBox("Offline Installer");
	private JCheckBox atom = new JCheckBox("Atom");
	private JCheckBox office2010 = new JCheckBox("Microsoft Office 2010");
	private JCheckBox winRAR = new JCheckBox("WinRAR");
	private JCheckBox logicPro = new JCheckBox("Logic Pro X");
	private JCheckBox finalCutPro = new JCheckBox("Final Cut Pro X");
	private JCheckBox sublime = new JCheckBox("Sublime");

	// JComboBox
	String[] choices = {"Generate Batch Script (Windows)", "Generate Bash Script (Macintosh)"};
	private JComboBox choice = new JComboBox(choices);

	// Text Field
	private JTextField field = new JTextField();
	
	public createInstallerScripts() {
		// Set overall layout
		setLayout(new GridLayout(3, 1));
				
		// p2
		p2.setLayout(new GridLayout(1, 3));
		
		p4.setLayout(new GridLayout(7, 1));
		p4.setBorder(BorderFactory.createTitledBorder("Tools"));
		p4.add(sevenZip);
		p4.add(winRAR);
		p4.add(cCleaner);
		p4.add(winDiskImager);
		p4.add(vnc);
		p4.add(googleEarth);
		p4.add(ipVanish);
		p2.add(p4); // add to p2
		
		p5.setLayout(new GridLayout(3, 1));
		p5.setBorder(BorderFactory.createTitledBorder("Browsers"));
		p5.add(chrome);
		p5.add(firefox);
		p5.add(tor);
		p2.add(p5); // add to p2
		
		p6.setLayout(new GridLayout(7, 1));
		p6.setBorder(BorderFactory.createTitledBorder("Media Players"));
		p6.add(vlc);
		p6.add(adobeFlash);
		p6.add(iTunes);
		p6.add(frostwire);
		p6.add(silverlight);
		p6.add(logicPro);
		p6.add(finalCutPro);
		p2.add(p6); // add to p2
		add(p2); // add p2 to frame
		
		// p3
		p3.setLayout(new GridLayout(1, 2));
		
		// p7
		p7.setLayout(new GridLayout(6, 1));
		p7.setBorder(BorderFactory.createTitledBorder("Office Tools"));
		p7.add(libreOffice);
		p7.add(openOffice);
		p7.add(office2016);
		p7.add(office2010);
		p7.add(adobeReader);
		p7.add(pdfTools);
		p3.add(p7); // add to p3
		
		// p8
		p8.setLayout(new GridLayout(8, 1));
		p8.setBorder(BorderFactory.createTitledBorder("Antivirus/Programming"));
		p8.add(malwarebytes);
		p8.add(bitdefender);
		p8.add(eclipse);
		p8.add(python);
		p8.add(notepadplusplus);
		p8.add(komodoEdit);
		p8.add(atom);
		p8.add(sublime);
		p3.add(p8); // add to p3
		add(p3);
		
		// p9
		p9.setLayout(new GridLayout(4, 1));
		p10.setLayout(new GridLayout(1, 2));
		bgGroup.add(online);
		bgGroup.add(offline);
		p10.add(online);
		p10.add(offline);
		p9.add(p10);
		p9.add(choice);
		p9.add(field);
		p9.add(genScript);
		add(p9);
				
		genScript.addActionListener(new ButtonListener());
		
		// Set default text
    	field.setText("");
    	
	}
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            if (choice.getSelectedIndex() == 0) { // creates batch script
            	try {
            		// Create the file
            		File file = new File("Installer.bat");
                	String path = file.getCanonicalPath();
                	
                	// Set default text
                	field.setText("");
                	
               		// Checks the check boxes
                	if (online.isSelected() == false && offline.isSelected() == false) {
                		field.setText("Must select an installation type!! Online or Offline!");
                	}
                	                	
                	else if (online.isSelected()) {
                		// Write standard header to the file 
                    	writeBatchHeader(path);
                    	
                   		// Method Calls
                   		if (vnc.isSelected()) writeVNCOnline(path);
                    	if (sevenZip.isSelected()) writeSevenZipOnline(path);
                    	if (cCleaner.isSelected()) writeCCleanerOnline(path);
                    	if (chrome.isSelected()) writeChromeOnline(path);
                    	if (eclipse.isSelected()) writeEclipseOnline(path);
                    	if (firefox.isSelected()) writeFirefoxOnline(path);        	
                    	if (frostwire.isSelected()) writeFrostwireOnline(path);
                    	if (googleEarth.isSelected()) writeGoogleEarthOnline(path);                         	
                    	if (iTunes.isSelected()) writeiTunesOnline(path);
                    	if (libreOffice.isSelected()) writelibreOfficeOnline(path);
                    	if (openOffice.isSelected()) writeopenOfficeOnline(path);
                    	if (malwarebytes.isSelected()) writeMalwarebytesOnline(path);                   	
                    	if (notepadplusplus.isSelected()) writenotepadPlusPlusOnline(path);
                    	if (pdfTools.isSelected()) writepdfToolsOnline(path);                           	
                    	if (python.isSelected()) writePythonOnline(path);      	
                    	if (vlc.isSelected()) writeVLCOnline(path);   
                    	if (adobeFlash.isSelected()) writeadobeFlashOnline(path);
                    	if (adobeReader.isSelected()) {writeadobeReaderOnline(path);   
                    	if (tor.isSelected()) writeTorOnline(path);        
                    	if (winDiskImager.isSelected()) writewinDiskImagerOnline(path);                 	
                    	if (ipVanish.isSelected()) writeipVanishOnline(path);
                    	if (bitdefender.isSelected()) writebitdefenderOnline(path);
                    	if (komodoEdit.isSelected()) writekomodoEditOnline(path);                                  
                    	if (silverlight.isSelected()) writeSilverlightOnline(path);
                    	if (atom.isSelected()) writeAtomOnline(path);
                    	if (sublime.isSelected()) writeSublimeOnline(path);

                    	// Exceptions
                    	String errorStatement = "Some programs selected cannot be installed via online sources. They have been unchecked.";
                    	
                    	if (office2010.isSelected()) {
                    		office2010.setSelected(false);
                    		field.setText(errorStatement);
                    	}
                    	
                    	if (office2016.isSelected()) {
                    		office2016.setSelected(false);
                    		field.setText(errorStatement);
                    	}
                    	
                    	if (winRAR.isSelected()) {
                    		winRAR.setSelected(false);
                    		field.setText(errorStatement);
                    	}
                    	
                    	if (office2016.isSelected()) {
                    		winRAR.setSelected(false);
                    		field.setText(errorStatement);
                    	}

                    	if (logicPro.isSelected()) {
                    		logicPro.setSelected(false);
                    		field.setText(errorStatement);
                    	}
                    	
                    	if (finalCutPro.isSelected()) {
                    		finalCutPro.setSelected(false);
                    		field.setText(errorStatement);
                    	}
                    	
                   		// Write standard footer to file
                    	writeBatchFooter(path);
                	}
                }
                else {
                	// Write standard header to the file 
                   	writeBatchHeader(path);
                	
                	
                   	// Methods
                   	if (vnc.isSelected()) writeVNC(path);
                    if (sevenZip.isSelected()) writeSevenZip(path);
                    if (cCleaner.isSelected()) writeCCleaner(path);
                    if (chrome.isSelected()) writeChrome(path);
                    if (eclipse.isSelected()) writeEclipse(path);
                    if (firefox.isSelected()) writeFirefox(path);          	
                    if (frostwire.isSelected()) writeFrostwire(path); 	
                    if (googleEarth.isSelected()) writeGoogleEarth(path);             	
                    if (iTunes.isSelected()) writeiTunes(path);
                    if (libreOffice.isSelected()) writelibreOffice(path);
                    if (openOffice.isSelected()) writeopenOffice(path);
                    if (malwarebytes.isSelected()) writeMalwarebytes(path);
                    if (notepadplusplus.isSelected()) writenotepadPlusPlus(path);
                    if (pdfTools.isSelected()) writepdfTools(path);                  	
                    if (python.isSelected()) writePython(path);      	
                    if (vlc.isSelected()) writeVLC(path);   
                    if (adobeFlash.isSelected()) writeadobeFlash(path);
                    if (adobeReader.isSelected()) writeadobeReader(path);   
                    if (tor.isSelected()) writeTor(path);         
                    if (winDiskImager.isSelected()) writewinDiskImager(path);                	
                    if (ipVanish.isSelected()) writeipVanish(path);                  	
                    if (bitdefender.isSelected()) writebitdefender(path);          
                    if(komodoEdit.isSelected()) writekomodoEdit(path);              
                   	if (office2016.isSelected()) writeOffice2016(path);                 
                   	if (silverlight.isSelected()) writeSilverlight(path);
                   	if (atom.isSelected()) writeAtom(path);
                   	if (winRAR.isSelected()) writeWinRAR(path);
                   	if (sublime.isSelected()) writeSublime(path);

                    	
                   	// Exceptions
                   	String errorStatement = "Some programs selected cannot be installed on Windows. They have been unchecked.";
                    	
                   	if (logicPro.isSelected()) {
                   		logicPro.setSelected(false);
                   		field.setText(errorStatement);
                   	}
                    	
                   	if (finalCutPro.isSelected()) {
                   		finalCutPro.setSelected(false);
                   		field.setText(errorStatement);
                   	}
                    	
                 	// Write standard footer to file
                   	writeBatchFooter(path);
                }       		
            }

            catch (IOException ex) {
            	field.setText("Error caught by John The Ripper");
            }
          } 
            
            else { // creates bash script
            	try {
            		File file = new File("Installer.sh");
                	String path = file.getCanonicalPath();
                	
                	// Set default text
                	field.setText("");
                	String errorStatement = "Some programs chosen are not compatibale with MacOS. These programs have been unchecked.";
                	
                	// Exceptions
                	if (sevenZip.isSelected()) {
                		sevenZip.setSelected(false);
                		field.setText(errorStatement);
                	}              	
                	if (winDiskImager.isSelected()) {
                		winDiskImager.setSelected(false);
                		field.setText(errorStatement);
                	}               	
             	
                	if (iTunes.isSelected()) {
                		iTunes.setSelected(false);
                		field.setText(errorStatement);
                	}               	
                	if (pdfTools.isSelected()) {
                		pdfTools.setSelected(false);
                		field.setText(errorStatement);
                	}               	
                	if (libreOffice.isSelected()) {
                		libreOffice.setSelected(false);
                		field.setText(errorStatement);
                	}	
                	if (openOffice.isSelected()) {
                		openOffice.setSelected(false);
                		field.setText(errorStatement);
                	}
                	if (notepadplusplus.isSelected()) {
                		notepadplusplus.setSelected(false);
                		field.setText(errorStatement);
                	}
                	if (office2010.isSelected()) {
                		office2010.setSelected(false);
                		field.setText(errorStatement);
                	}
                	if (winRAR.isSelected()) {
                		winRAR.setSelected(false);
                		field.setText(errorStatement);
                	}
                	
                	// Conditions to create installer script
                	if (online.isSelected() == false && offline.isSelected() == false) {
                		field.setText("Must select an installation type!! Online or Offline!");
                	}
                	
                	else if (offline.isSelected()) {
                		// Write standard header to the file
                		writeBashHeader(path);
                   		
                   		// Checks the checkboxes               	
                    	if (cCleaner.isSelected()) writeCCleanerBash(path);       
                    	if (chrome.isSelected()) writeChromeBash(path);                    	
                    	if (eclipse.isSelected()) writeEclipseBash(path);              
                    	if (firefox.isSelected()) writeFirefoxBash(path);                   	
                    	if (frostwire.isSelected()) writeFrostwireBash(path);           
                    	if (googleEarth.isSelected()) writeGoogleEarthBash(path);            
                    	if (malwarebytes.isSelected()) writeMalwarebytesBash(path);                  
                    	if (python.isSelected()) writePythonBash(path);              
                    	if (vlc.isSelected()) writeVLCBash(path);                     	
                    	if (adobeFlash.isSelected()) writeadobeFlashBash(path);               
                    	if (adobeReader.isSelected()) writeadobeReaderBash(path);                
                    	if (tor.isSelected()) writeTorBash(path);               
                       	if (ipVanish.isSelected()) writeipVanishBash(path);                    
                    	if (bitdefender.isSelected()) writebitdefenderBash(path);                    
                    	if (komodoEdit.isSelected()) writekomodoEditBash(path);                    
                    	if (office2016.isSelected()) writemacOffice(path);
                    	if (silverlight.isSelected()) writeSilverlightBash(path);
                    	if (vnc.isSelected()) writeVNCBash(path);
                    	if (logicPro.isSelected()) writeLogicBash(path);
                    	if (finalCutPro.isSelected()) writeFinalBash(path);
                    	if (atom.isSelected()) writeAtomBash(path);
                    	if (sublime.isSelected()) writeSublimeBash(path);

                    	
                        // Write standard footer
                    	writeBashFooter(path);

                	}   
                	
                	else {
                		// Write standard header to the file
                		writeBashHeader(path);
                   		
                   		// Checks the checkboxes               	
                    	if (cCleaner.isSelected()) writeCCleanerBashOnline(path);
                    	if (chrome.isSelected()) writeChromeBashOnline(path);
                    	if (eclipse.isSelected()) writeEclipseBashOnline(path);                  
                    	if (firefox.isSelected()) writeFirefoxBashOnline(path);             
                    	if (frostwire.isSelected()) writeFrostwireBashOnline(path);                
                    	if (googleEarth.isSelected()) writeGoogleEarthBashOnline(path);                 
                    	if (malwarebytes.isSelected()) writeMalwarebytesBashOnline(path);                  
                    	if (python.isSelected()) writePythonBashOnline(path);               
                    	if (vlc.isSelected()) writeVLCBashOnline(path);               
                    	if (adobeFlash.isSelected()) writeadobeFlashBashOnline(path);               
                    	if (adobeReader.isSelected()) writeadobeReaderBashOnline(path);                 
                    	if (tor.isSelected()) writeTorBashOnline(path);             
                       	if (ipVanish.isSelected()) writeipVanishBashOnline(path);                  
                    	if (bitdefender.isSelected()) writebitdefenderBashOnline(path);                    
                    	if (komodoEdit.isSelected()) writekomodoEditBashOnline(path);                  
                    	if (silverlight.isSelected()) writeSilverlightBashOnline(path);
                    	if (vnc.isSelected()) writeVNCBashOnline(path);
                    	if (atom.isSelected()) writeAtomBashOnline(path);
                    	if (sublime.isSelected()) writeSublimeBashOnline(path);

                    	
                    	// Exceptions            	
                    	if (logicPro.isSelected()) {
                    		logicPro.setSelected(false);
                    		field.setText("Some programs selected cannot be installed via online sources. They have been unchecked.");
                    	}
                    	
                    	if (finalCutPro.isSelected()) {
                    		finalCutPro.setSelected(false);
                    		field.setText("Some programs selected cannot be installed via online sources. They have been unchecked.");
                    	}
                    	
                    	if (office2016.isSelected()) {
                    		office2016.setSelected(false);
                    		field.setText("Some programs selected cannot be installed via online sources. They have been unchecked.");
                    	}
	      	
                        // Write standard footer
                    	writeBashFooter(path);
                	}
            	}  		
            	catch (IOException ex) {
            		field.setText("Error caught by John The Ripper");
            	}
            }
        }
	}

	// Main Method
	public static void main(String[] args) {
		createInstallerScripts tool = new createInstallerScripts();
	    tool.pack();
	    tool.setTitle("CCC Program Installer");
	    tool.setSize(615, 490); // size
	    tool.setLocationRelativeTo(null); // Center the frame
	    tool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    tool.setVisible(true);
	 
	}
}
