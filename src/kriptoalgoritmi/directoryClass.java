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
    // Reference holders for the calling window:
    private electionFrame ptr;
    private A5_1Frame a51ptr;
    
    // Container for files in encryption/decryption source folder:
    private File[] listOfFiles;
    // Container for .txt/.nj file's names in encryption/decryption 
    // source folder:
    private String[] filesInFolder;
    // Number of .txt/.nj files in the source folder:
    private int numberOfTxtFiles;
    // Flag: True - encryption; False - decryption:
    private boolean encDec;
    private int wordsPerGroup;
    private WatchService watcher;
    
    // Key placeholder for A5/1 algorithm:
    private String key;
    
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
        if (ptr != null) {
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
        else if (a51ptr != null) {
            // If the checkbox is checked and encryption is in mind:
            if (a51ptr.isChecked() && encDec) {
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
                            if (ptr != null)
                                // Call encrypt button's method:
                                ptr.clickEncBtn();
                            else if (a51ptr != null)
                                a51ptr.clickEncBtn();
                        }
                    }
                    
                    // Reset the watch key:
                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(electionFrame.class.getName()).log(Level.SEVERE, null, ex);
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
            if(isEncrypt) {
                wordsPerGroup = ptr.getNumberPerGroup();
                
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
                wordsPerGroup = ptr.getNumberPerGroup();
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
    
    public void readAllFromDirectory(String path, boolean isEncryption) {
        encDec = isEncryption;
        
        // Open the specified folder and get it's content:
        File folder = new File(path);
        listOfFiles = folder.listFiles();
        
        filesInFolder = new String[listOfFiles.length];
        
        // Extract String formated files' names from our list:
        for (int i = 0; i < filesInFolder.length; i++)
            filesInFolder[i] = listOfFiles[i].getName();
        
        numberOfTxtFiles = filesInFolder.length;
    }
    
    // Method for setting the reference of the election calling form:
    public void setElectionListener(electionFrame frm) {
        ptr = frm;
    }
    
    // Method for setting the reference of the A5/1 calling form:
    public void setA5_1Listener(A5_1Frame frm) {
        a51ptr = frm;
    }
    
    // Method for clearing references to directoryClass:
    public void clearListeners() {
        ptr = null;
        a51ptr = null;
    }
    
    // Method that goes through .txt files, encrypts them, and writes them
    // at the encryption destination folder.
    public void encryptFiles() {
        
        if (ptr != null) {
            // Block (read disable) GUI so the user doesn't do something bad:
            ptr.blockGUI(true);
            // Set the text on the encryption button so the user knows that
            // something is going in the background (feedback):
            ptr.setEncBtnLabel("Encrypting...");
        }
        else if (a51ptr != null) {
            // Block (read disable) GUI so the user doesn't do something bad:
            a51ptr.blockGUI(true);
            // Set the text on the encryption button so the user knows that
            // something is going in the background (feedback):
            a51ptr.setEncBtnLabel("Encrypting...");
        }
        Thread t = null;
        
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
            if (ptr != null)
                // Create our election encryption thread:
                t = new Thread (new encryptionThread(this, k, true));
            else
                // Create our a5/1 encryption thread:
                if (a51ptr != null)
                    t = new Thread (new a5_1Thread(this, k, encDec, key));
            // Let it do it's encryption:
            t.start();
        }
        
        if (ptr != null) {
            // After they all finish, unblock (enable) GUI for further use:
            ptr.blockGUI(false);
            // Change the text on the encryption button back:
            ptr.setEncBtnLabel("Encrypt");
        }
        else if (a51ptr != null) {
            // After they all finish, unblock (enable) GUI for further use:
            a51ptr.blockGUI(false);
            // Change the text on the encryption button back:
            a51ptr.setEncBtnLabel("Encrypt");
        }
    }
    
    // Method that goes through .nj files, decrypts them, and writes them
    // at the decryption destination folder.
    public void decryptFiles() {
        if (ptr != null) {
            // Block (read disable) GUI so the user doesn't do something bad:
            ptr.blockGUI(true);
            // Set the text on the decryption button so the user knows that
            // something is going in the background (feedback):
            ptr.setDecBtnLabel("Decrypting...");
        }
        else if (a51ptr != null) {
            // Block (read disable) GUI so the user doesn't do something bad:
            a51ptr.blockGUI(true);
            // Set the text on the decryption button so the user knows that
            // something is going in the background (feedback):
            a51ptr.setDecBtnLabel("Decrypting...");
        }
        Thread t = null;
        
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
            if (ptr != null)
                // Create our election decryption thread:
                t = new Thread (new encryptionThread(this, k, false));
            else
                // Create our a5/1 decryption thread:
                if (a51ptr != null)
                    t = new Thread (new a5_1Thread(this, k, encDec, key));
            // Let it do it's decryption:
            t.start();
        }
        
        if (ptr != null) {
            // After they all finish, unblock (enable) GUI for further use:
            ptr.blockGUI(false);
            // Change the text on the decryption button back:
            ptr.setDecBtnLabel("Decrypt");
        }
        else if (a51ptr != null) {
            // After they all finish, unblock (enable) GUI for further use:
            a51ptr.blockGUI(false);
            // Change the text on the decryption button back:
            a51ptr.setDecBtnLabel("Decrypt");
        }
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
    
    // 'Remove' already encrypted/decrypted files from the working list
    // that are located at the destination folder:
    public void clearExisting() {
        File dstFolder;
        // Open destination folder:
        if (encDec)
            dstFolder = new File(getEncDst());
        else
            dstFolder = new File(getDecDst());
        
        // List all the files from the folder:
        File[] allFiles = dstFolder.listFiles();
        
        // Placeholder for the file name:
        String tmp;
        for (int i = 0; i < filesInFolder.length; i++) {
            for (int k = 0; k < allFiles.length; k++) {
                tmp = allFiles[k].getName();
                
                if (encDec)
                    // If working file already exists 
                    // (compare without extension '.nj')
                    if (filesInFolder[i]
                            .contains(tmp.substring(0, tmp.length()-3)))
                        filesInFolder[i] = "";
                else
                        
                    // If working file already exists 
                    // (compare without extension '.txt')
                    if (filesInFolder[i]
                            .contains(tmp.substring(0, tmp.length()-4)))
                        filesInFolder[i] = "";
            }
        }
    }
    
    // Getter for user's choice of words per group for encryption:
    public int retWordsPerGroup() {
        return wordsPerGroup;
    }
    
    // Setter for user's choice of words per group for encryption:
    public void setWordsPerGroup(int number) {
        wordsPerGroup = number;
    }
    
    // Key setter method:
    public void setKey(String parseKey) {
        key = parseKey;
    }
    
    // Key getter method:
    public String getKey() {
        return key;
    }
}