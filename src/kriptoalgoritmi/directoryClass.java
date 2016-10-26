/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptoalgoritmi;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Njamb
 */
public class directoryClass implements Runnable{
    
    private static directoryClass directoryManipulationSingleton;
    
    // Placeholders for source & destination paths for encryption
    private String encSrcTextField;
    private String encDstTextField;
    // Placeholders for source & destination paths for decryption
    private String decSrcTextField;
    private String decDstTextField;
    // Reference holder for the main window:
    private mainFrame ptr;
    
    // Container for files in encryption/decryption source folder:
    private File[] listOfFiles;
    // Container for .txt/.nj file's names in encryption/decryption 
    // source folder:
    private String[] filesInFolder;
    // Number of .txt/.nj files in the source folder:
    private int numberOfTxtFiles;
    // Flag: True - encryption; False - decryption:
    private boolean encDec;
    private WatchService watcher;
    
    private directoryClass() {
        encSrcTextField = "";
        encDstTextField = "";
        decSrcTextField = "";
        decDstTextField = "";
    }
  
    // Singleton pattern:
    public static directoryClass getInstance() {
        if (directoryManipulationSingleton == null) {
            directoryManipulationSingleton = new directoryClass();
        }
        return directoryManipulationSingleton;
    }
    
    // Getters & setters for encryption source & destination folder paths:
    public String getEncSrc() { return encSrcTextField; }
    public void setEncSrc(String str) { encSrcTextField = str; }
    public String getEncDst() { return encDstTextField; }
    public void setEncDst(String str) { encDstTextField = str; }
    
    // Getters & setters for decryption source & destination folder paths:
    public String getDecSrc() { return decSrcTextField; }
    public void setDecSrc(String str) { decSrcTextField = str; }
    public String getDecDst() { return decDstTextField; }
    public void setDecDst(String str) { decDstTextField = str; }
    
    // Method to be called when thread of this class starts:
    @Override
    public void run() {
        // If the checkbox is checked and encryption is in mind:
        if (ptr.isChecked() && encDec) {
            // Encrypt files:
            encryptFiles();
            // Activate folder watcher for automated encryption:
            folderWatcher();
        }
        // Else check if it's only encryption/decryption
        else if (encDec)
            // Encrypt files:
                encryptFiles();
            else
            // Decrypt files:
                decryptFiles();
    }
    
    // Method for automated encryption:
    private void folderWatcher() {
        try {
                watcher = FileSystems.getDefault().newWatchService();
                Path path = Paths.get(getEncSrc());
                path.register(watcher, ENTRY_CREATE);
                
                while (true) {
                    WatchKey key = watcher.take();
                    
                    for (WatchEvent<?> event : key.pollEvents()) {
                        // get event type
                        WatchEvent.Kind<?> kind = event.kind();

                        // get file name
                        @SuppressWarnings("unchecked")
                        WatchEvent<Path> ev = (WatchEvent<Path>) event;
                        Path fileName = ev.context();

                        System.out.println(kind.name() + ": " + fileName);

                        // If another file is created in the watched folder and
                        // no one pressed decryption:
                        if (kind == ENTRY_CREATE && encDec) {
                            // Call encrypt button's method:
                            ptr.clickEncBtn();
                        }
                    }
                    
                    // Reset the watch key:
                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
            }
    }
    
    // Method for getting files' names from a directory:
    // and extracting the names of files with .txt/.nj extension 
    // to 'filesInFolder':
    public void readDirectory(String path, boolean isEncrypt) {
        // Save if it's encryption or decryption (true/false):
        encDec = isEncrypt;
        
        // Open the specified folder and get it's content:
        File folder = new File(path);
        listOfFiles = folder.listFiles();
        
        // Counter of .txt/.nj files:
        numberOfTxtFiles = 0;
        
        // While there are files in folder:
        for (int i = 0; i < listOfFiles.length; i++) {
            // Check if it's encryption and if it's automated:
            if(isEncrypt && ptr.isChecked()) {
                // Check if the file is .txt:
                if (listOfFiles[i].isFile() && 
                        listOfFiles[i].getName().contains(".txt")) {
                    // If so - count them in:
                    numberOfTxtFiles++;
                }
            }
            else {
                // Check if the file is encrypted:
                if (listOfFiles[i].isFile() && 
                        listOfFiles[i].getName().contains(".nj")) {
                    // If so - count them in:
                    numberOfTxtFiles++;
                }
            }
        }
        // Create a placeholder for out files:
        filesInFolder = new String[numberOfTxtFiles];
        // Counter for tracking where we are in the array:
        int counter = 0;
        
        // While there are files in the folder:
        for (int i = 0; i < listOfFiles.length; i++) {
            if (isEncrypt) {
                // If it's .txt file:
                if (listOfFiles[i].isFile() && 
                        listOfFiles[i].getName().contains(".txt")) {
                    // Get it's name and store it to our placeholder:
                    filesInFolder[counter++] = listOfFiles[i].getName();
                }
            }
            else {
                // If it's .nj file:
                if (listOfFiles[i].isFile() && 
                        listOfFiles[i].getName().contains(".nj")) {
                    // Get it's name and store it to our placeholder:
                    filesInFolder[counter++] = listOfFiles[i].getName();
                }
            }
        }
    }
    
    // Method for setting the reference of the main window:
    public void setListener(mainFrame frm) {
        ptr = frm;
    }
    
    // Method that goes through .txt files, encrypts them, and writes them
    // at the encryption destination folder.
    public void encryptFiles() {
        // Block (read disable) GUI so the user doesn't do something bad:
        ptr.blockGUI(true);
        // Set the text on the encryption button so the user knows that
        // something is going in the background (feedback):
        ptr.setEncBtnLabel("Encrypting...");
        Thread t;
        
        // For every .txt file:
        for (int k = 0; k < numberOfTxtFiles; k++) {
            // Checking for the number of running threads: 
            if (k % 3 == 0 ) {
                // Additional check for the first thread:
                if (k != 0) {
                    try {
                        // Block and wait for other thread to finish:
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(directoryClass.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
            }
            // Create our encryption thread:
            t = new Thread (new encryptionThread(this, k, true));
            // Let it do it's encryption:
            t.start();
        }
        
        // After they all finish, unblock (enable) GUI for further use:
        ptr.blockGUI(false);
        // Change the text on the encryption button back:
        ptr.setEncBtnLabel("Encrypt");
    }
    
    // Method that goes through .nj files, decrypts them, and writes them
    // at the decryption destination folder.
    public void decryptFiles() {
        // Block (read disable) GUI so the user doesn't do something bad:
        ptr.blockGUI(true);
        // Set the text on the decryption button so the user knows that
        // something is going in the background (feedback):
        ptr.setDecBtnLabel("Decrypting...");
        Thread t;
        
        // For every .nj file:
        for (int k = 0; k < numberOfTxtFiles; k++) {
            // Checking for the number of running threads: 
            if (k % 3 == 0 ) {
                // Additional check for the first thread:
                if (k != 0) {
                    try {
                        // Block and wait for other thread to finish:
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(directoryClass.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
            }
            // Create our decryption thread:
            t = new Thread (new encryptionThread(this, k, false));
            // Let it do it's decryption:
            t.start();
        }
        
        // After they all finish, unblock (enable) GUI for further use:
        ptr.blockGUI(false);
        // Change the text on the decryption button back:
        ptr.setDecBtnLabel("Decrypt");
    }
    
    // Getter for the container for the .txt/.nj files in folder:
    public String[] getFilesInFolder() {
        return filesInFolder;
    }
    
    // Setter for the file in folder name.
    // Used when encrypting (.txt -> .nj) and vice-versa:
    public void setFilesInFolder(String str, int index) {
        filesInFolder[index] = str;
    }
}