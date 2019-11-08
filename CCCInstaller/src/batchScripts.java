/*  -------------------------------------------------------
 *  batchScripts.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Email:   composite.computing@gmail.com
 *  Date:	 Oct 9, 2018
 *  ------------------------------------------------------- */

// Imports
import javax.swing.*;
import java.io.*;

public class batchScripts extends JFrame {
	public static void writeVNC(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Tight VNC----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\TightVNC\" (");
		out.newLine();
		out.append("	echo Tight VNC is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install x11VNC");
		out.newLine();
		out.append("	echo Installing x11VNC & Mirage Driver...");
		out.newLine();
		out.append("	START /wait %installer%\\1.VNCDriver.exe /verysilent /norestart");
		out.newLine();
		out.append("	msiexec /i %installer%\\2.VNC.msi /quiet /norestart");
		out.newLine();
		out.append("	echo Done VNC Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
	
	public static void writeSevenZip(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------7-zip----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\7-Zip\" (");
		out.newLine();
		out.append("	echo 7-zip is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install 7zip File Archiver");
		out.newLine();
		out.append("	echo 7zip File Archiver...");
		out.newLine();
		out.append("	START /wait %installer%\\3.7zip.exe /S");
		out.newLine();
		out.append("	echo Done 7-zip Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
	
	public static void writeWinRAR(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------WinRAR----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\WinRAR\" (");
		out.newLine();
		out.append("	echo WinRAR is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install WinRAR File Archiver");
		out.newLine();
		out.append("	echo WinRAR File Archiver...");
		out.newLine();
		out.append("	START /wait %installer%\\WinRAR\\winrar-64Bit-400.exe /S");
		out.newLine();
		out.append("	echo Done WinRAR Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
	
    public static void writeCCleaner(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------C-Cleaner----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\CCleaner\" (");
		out.newLine();
		out.append("	echo CCleaner is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install C-Cleaner");
		out.newLine();
		out.append("	echo Installing C-Cleaner...");
		out.newLine();
		out.append("	START /wait %installer%\\4.C-Cleaner.exe /S");
		out.newLine();
		out.append("	echo Done C-Cleaner Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
	public static void writeChrome(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Google Chrome----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files (x86)\\Google\" (");
		out.newLine();
		out.append("	echo Google Chrome is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Chrome");
		out.newLine();
		out.append("	echo Installing Google Chrome...");
		out.newLine();
		out.append("	msiexec /i %installer%\\5.Chrome.msi /quiet /norestart");
		out.newLine();
		out.append("	echo Done Google Chrome Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
    public static void writeFirefox(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Firefox----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files (x86)\\Mozilla Firefox\" (");
		out.newLine();
		out.append("	echo Firefox is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Firefox");
		out.newLine();
		out.append("	echo Installing Firefox...");
		out.newLine();
		out.append("	START /wait %installer%\\7.Firefox.exe /S");
		out.newLine();
		out.append("	echo Done Firefox Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
	public static void writeFrostwire(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Frostwire----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files (x86)\\Frostwire 6\" (");
		out.newLine();
		out.append("	echo Frostwire is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Frostwire");
		out.newLine();
		out.append("	echo Installing Frostwire...");
		out.newLine();
		out.append("	%installer%\\8.Frostwire.exe /S");
		out.newLine();
		out.append("	echo Done Frostwire Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
	
    public static void writeopenOffice(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Open Office----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Open Office\" (");
		out.newLine();
		out.append("	echo Open Office is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Open Office");
		out.newLine();
		out.append("	echo Installing Apache Open Office...");
		out.newLine();
		out.append("	START /wait %installer%\\23.OpenOffice.exe /L=1033 /S");
		out.newLine();
		out.append("	echo Done Apache Open Office Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
    public static void writeMalwarebytes(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Malwarebytes----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Malwarebytes\" (");
		out.newLine();
		out.append("	echo Malwarebytes is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Malwarebytes");
		out.newLine();
		out.append("	echo Installing Malwarebytes Anti-Malware...");
		out.newLine();
		out.append("	START /wait %installer%\\14.Malwarebytes.exe /verysilent /norestart");
		out.newLine();
		out.append("	echo Done Malwarebytes Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
	public static void writenotepadPlusPlus(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Notepad++----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files (x86)\\Notepad++\" (");
		out.newLine();
		out.append("	echo Notepad++ is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Notepad++");
		out.newLine();
		out.append("	echo Installing Notepad++...");
		out.newLine();
		out.append("	START /wait %installer%\\15.Notepad++.exe /S");
		out.newLine();
		out.append("	echo Done Notepad++ Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
	
	public static void writeGoogleEarth(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Google Earth----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Google\" (");
		out.newLine();
		out.append("	echo Google Earth is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Google Earth");
		out.newLine();
		out.append("	echo Installing Google Earth...");
		out.newLine();
		out.append("	msiexec /i %installer%\\\\9.GoogleEarth.msi /quiet /norestart");
		out.newLine();
		out.append("	echo Done Google Earth Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();	
	}
	
    public static void writelibreOffice(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Libre Office----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files (x86)\\LibreOffice 3.6\" (");
		out.newLine();
		out.append("	echo Libre Office is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Libre Office");
		out.newLine();
		out.append("	echo Installing Libre Office...");
		out.newLine();
		out.append("	msiexec /i %installer%\\13.LibreOffice.msi /quiet /norestart ");
		out.newLine();
		out.append("	echo Done Libre Office Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();	
	}
    
    public static void writeadobeFlash(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Adobe Flash----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Adobe\" (");
		out.newLine();
		out.append("	echo Adobe Flash is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Adobe Flash Player");
		out.newLine();
		out.append("	echo Installing Adobe Flash...");
		out.newLine();
		out.append("	%installer%\\19.Adobe-Flash.exe -install");
		out.newLine();
		out.append("	echo Done Adobe Flash Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
    public static void writeadobeReader(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Adobe Reader----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Adobe\" (");
		out.newLine();
		out.append("	echo Adobe Reader is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Adobe Reader");
		out.newLine();
		out.append("	echo Installing Adobe Reader...");
		out.newLine();
		out.append("	START /wait %installer%\\AcroRdrDC1801120035_en_US.exe /sALL /rs");
		out.newLine();
		out.append("	echo Done Adobe Reader Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
    public static void writeTor(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Tor----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Tor\" (");
		out.newLine();
		out.append("	echo Tor is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Tor");
		out.newLine();
		out.append("	echo Installing Tor...");
		out.newLine();
		out.append("	START /wait %installer%\\21.Tor-Browser.exe /S");
		out.newLine();
		out.append("	echo Done Tor Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
    public static void writewinDiskImager(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Win32DiskImager----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Win32DiskImager\" (");
		out.newLine();
		out.append("	echo Win32DiskImager is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Win32DiskImager");
		out.newLine();
		out.append("	echo Installing Win32DiskImager...");
		out.newLine();
		out.append("	START /wait %installer%\\22.Win32DiskImager.exe /verysilent /norestart");
		out.newLine();
		out.append("	echo Done Win32DiskImager Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
    public static void writePython(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Python----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Python\" (");
		out.newLine();
		out.append("	echo Python Language is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Python Library");
		out.newLine();
		out.append("	echo Installing Python Library...");
		out.newLine();
		out.append("	START /wait %installer%\\17.Python.exe /SILENT /norestart");
		out.newLine();
		out.append("	echo Done Python Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
    public static void writeVLC(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------VLC----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\VLC\" (");
		out.newLine();
		out.append("	echo VLC is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install VLC");
		out.newLine();
		out.append("	echo Installing VLC Media Player...");
		out.newLine();
		out.append("	START /wait %installer%\\18.VLC.exe /L=1033 /S");
		out.newLine();
		out.append("	echo Done VLC Media Player Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
    public static void writepdfTools(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------PDFTools----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\PDFTools\" (");
		out.newLine();
		out.append("	echo PDF Tools is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install PDF Tools");
		out.newLine();
		out.append("	echo Installing PDF Tools...");
		out.newLine();
		out.append("	%installer%\\16.PDFTools.exe /qn /norestart");
		out.newLine();
		out.append("	echo Done PDF Tools Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
    }
    
    public static void writeipVanish(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------IPVanish----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\IPVanish VPN\" (");
		out.newLine();
		out.append("	echo IPVanish is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install IPVansih");
		out.newLine();
		out.append("	echo Installing IPVanish...");
		out.newLine();
		out.append("	START /wait %installer%\\25.IPVanish.exe /qn /norestart");
		out.newLine();
		out.append("	echo Done IPVanish Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
    }	
    
	public static void writekomodoEdit(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Komodo Edit----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files (x86)\\Komodo Edit\" (");
		out.newLine();
		out.append("	echo Komodo Edit is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Komodo Edit");
		out.newLine();
		out.append("	echo Installing Komodo Edit...");
		out.newLine();
		out.append("	msiexec /i %installer%\\26.KomodoEdit.msi /quiet /norestart ");
		out.newLine();
		out.append("	echo Done Komodo Edit Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
		out.close();
	}
        
    public static void writeSilverlight(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Microsoft Silverlight----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files (x86)\\Microsoft Silverlight\" (");
		out.newLine();
		out.append("	echo Microsoft Silverlight is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Microsoft Silverlight");
		out.newLine();
		out.append("	echo Installing Microsoft Silverlight...");
		out.newLine();
		out.append("	%installer%\\27.Silverlight.exe /q /doNotRequireDRMPrompt /noupdate");
		out.newLine();
		out.append("	echo Done Microsoft Silverlight Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.newLine();
    	out.close();
    }
    
    public static void writeEclipse(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Eclipse IDE----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Eclipse\" (");
		out.newLine();
		out.append("	echo Eclipse IDE is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Eclipse");
		out.newLine();
		out.append("	echo Installing Eclipse IDE...");
		out.newLine();
		out.append("	START /wait %installer%\\6.Eclipse.exe /SILENT /norestart");
		out.newLine();
		out.append("	echo Done Eclipse IDE Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.append("pause");
		out.newLine();
		out.newLine();
    	out.close();
	}
    
	public static void writeiTunes(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------iTunes----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\iTunes\" (");
		out.newLine();
		out.append("	echo iTunes is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install iTunes");
		out.newLine();
		out.append("	echo Installing iTunes...");
		out.newLine();
		out.append("	START /wait %installer%\\10.iTunes.exe");
		out.newLine();
		out.append("	echo Done iTunes Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.append("pause");
		out.newLine();
		out.newLine();
    	out.close();	
	}
    
    public static void writebitdefender(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Bitdefender----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Bitdefender\" (");
		out.newLine();
		out.append("	echo Bitdefender is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Bitdefender");
		out.newLine();
		out.append("	echo Installing Bitdefender...");
		out.newLine();
		out.append("	START /wait %installer%\\24.Bitdefender.exe /SILENT /norestart");
		out.newLine();
		out.append("	echo Done Bitdefender Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.append("pause");
		out.newLine();
		out.newLine();
    	out.close();
    }	
    
    public static void writeOffice2016(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Microsoft Office 2016----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files (x86)\\Microsoft Office\" (");
		out.newLine();
		out.append("	echo Microsoft Office is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Microsoft Office");
		out.newLine();
		out.append("	echo Installing Microsoft Office...");
		out.newLine();
		out.append("	START /wait %installer%\\\"Office 2016 (32-bit)\"\\setup.exe");
		out.newLine();
		out.append("	echo Done Microsoft Office 2016 Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.append("pause");
		out.newLine();
		out.newLine();
    	out.close();
    }
    
    public static void writeOffice2010(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Microsoft Office 2010----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files (x86)\\Microsoft Office\" (");
		out.newLine();
		out.append("	echo Microsoft Office is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Microsoft Office 2010");
		out.newLine();
		out.append("	echo Installing Microsoft Office 2010...");
		out.newLine();
		out.append("	START /wait %installer%\\\"Office-2010-Plus\"\\setup.exe");
		out.newLine();
		out.append("	echo Done Microsoft Office 2010 Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.append("pause");
		out.newLine();
		out.newLine();
    	out.close();
    }
    
	public static void writeAtom(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Atom----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Atom\" (");
		out.newLine();
		out.append("	echo Atom is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Atom");
		out.newLine();
		out.append("	echo Installing Atom...");
		out.newLine();
		out.append("	START /wait %installer%\\28.Atom.exe /S");
		out.newLine();
		out.append("	echo Done Atom Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.append("pause");
		out.newLine();
		out.newLine();
    	out.close();
	}
	
	public static void writeSublime(String path) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.append(":: ----------Sublime----------");
		out.newLine();
		out.append(":: Check if it is already installed");
		out.newLine();
		out.append("if exist \"C:\\Program Files\\Sublime\" (");
		out.newLine();
		out.append("	echo Sublime is already installed!!");
		out.newLine();
		out.append(") else (");
		out.newLine();
		out.append("	:: Install Sublime");
		out.newLine();
		out.append("	echo Installing Sublime...");
		out.newLine();
		out.append("	START /wait %installer%\\29.Sublime.exe /S");
		out.newLine();
		out.append("	echo Done Sublime Installation...");
		out.newLine();
		out.append(")");
		out.newLine();
		out.append("pause");
		out.newLine();
		out.newLine();
    	out.close();
	}
}
