/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptoalgoritmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Njamb
 */
public class directoryClass {
    
    private static directoryClass directoryManipulationSingleton;
    
    private String encSrcTextField;
    private String encDstTextField;
    private String decSrcTextField;
    private String decDstTextField;
    private cryptionClass cryp;
    private mainFrame ptr;
    
    // Container for enrypted file names from encryption source directory
    private String[] encryptedFiles;
    // Container for files' names in encryption source directory:
    private File[] listOfFiles;
    private String[] filesInFolder;
    private int numberOfTxtFiles;
    private String[] content = null;
    
    private directoryClass() {
        encSrcTextField = "";
        encDstTextField = "";
        decSrcTextField = "";
        decDstTextField = "";
    }
  
    public static directoryClass getInstance() {
        if (directoryManipulationSingleton == null) {
            directoryManipulationSingleton = new directoryClass();
        }
        return directoryManipulationSingleton;
    }
    
    // Encryption source & destination directories:
    public String getEncSrc() { return encSrcTextField; }
    public void setEncSrc(String str) { encSrcTextField = str; }
    public String getEncDst() { return encDstTextField; }
    public void setEncDst(String str) { encDstTextField = str; }
    
    // Decryption source & destination directories:
    public String getDecSrc() { return decSrcTextField; }
    public void setDecSrc(String str) { decSrcTextField = str; }
    public String getDecDst() { return decDstTextField; }
    public void setDecDst(String str) { decDstTextField = str; }
    
    
    
    // Method for getting files' names from a directory:
    // and extracting the names of .txt files to 'filesInFolder'
    public void readDirectory(String path, boolean isEncrypt) {
        File folder = new File(path);
        listOfFiles = folder.listFiles();
        
        numberOfTxtFiles = 0;
        
        for (int i = 0; i < listOfFiles.length; i++) {
            if(isEncrypt) {
                if (listOfFiles[i].isFile() && 
                        listOfFiles[i].getName().contains(".txt")) {
                    numberOfTxtFiles++;
                }
            }
            else {
                if (listOfFiles[i].isFile() && 
                        listOfFiles[i].getName().contains(".nj")) {
                    numberOfTxtFiles++;
                }
            }
        }
        filesInFolder = new String[numberOfTxtFiles];
        int counter = 0;
        
        for (int i = 0; i < listOfFiles.length; i++) {
            if (isEncrypt) {
                if (listOfFiles[i].isFile() && 
                        listOfFiles[i].getName().contains(".txt")) {
                    filesInFolder[counter++] = listOfFiles[i].getName();
                }
            }
            else {
                if (listOfFiles[i].isFile() && 
                        listOfFiles[i].getName().contains(".nj")) {
                    filesInFolder[counter++] = listOfFiles[i].getName();
                }
            }
        }
    }
    
    public void setListener(mainFrame frm) {
        ptr = frm;
    }
    
    // Method that goes through .txt files, encrypts them, and writes them
    // at the encryption destination folder.
    public void encryptFiles() {
        
            
        encryptionThread myThread = null;
        // Reading the content from the files and storing them in 'content[]'
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        for (int k = 0; k < numberOfTxtFiles; k++) {
            
            int numberOfLines = 0;
            try {
                FileReader fileReader = new FileReader(encSrcTextField + "\\" + filesInFolder[k]);
                FileReader fr = new FileReader(encSrcTextField + "\\" + filesInFolder[k]);

                BufferedReader buffReader = new BufferedReader(fileReader);

                while (buffReader.readLine() != null)
                    numberOfLines++;

                content = new String[numberOfLines];
                buffReader = new BufferedReader(fr);
                for (int i = 0; i < numberOfLines; i++) {
                    content[i] = buffReader.readLine();
                }
                buffReader.close();
                fr.close();
                fileReader.close();

            }
            catch (IOException ex) {
                System.out.print("errir");
            }
            
            myThread = new encryptionThread(this, k, true);
            executor.execute(myThread);
        }
    }
    
    public void decryptFiles() {
        encryptionThread myThread = null;
        // Reading the content from the files and storing them in 'content[]'
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        for (int k = 0; k < numberOfTxtFiles; k++) {
        
            int numberOfLines = 0;
            try {
                FileReader fileReader = new FileReader(decSrcTextField + "\\" + filesInFolder[k]);
                FileReader fr = new FileReader(decSrcTextField + "\\" + filesInFolder[k]);

                BufferedReader buffReader = new BufferedReader(fileReader);

                while (buffReader.readLine() != null)
                    numberOfLines++;

                content = new String[numberOfLines];
                buffReader = new BufferedReader(fr);
                for (int i = 0; i < numberOfLines; i++) {
                    content[i] = buffReader.readLine();
                }
                buffReader.close();
                fr.close();
                fileReader.close();

            }
            catch (IOException ex) {
                System.out.print("errir");
            }
            
//            if (k == 3)
//                try {
//                    sleep(5000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(directoryClass.class.getName()).log(Level.SEVERE, null, ex);
//            }

            myThread = new encryptionThread(this, k, false);
            executor.execute(myThread);
        }
    }
    
    // Method for setting the encrypted files' names for emergency save:
    private void fillEncrypted() {
        int numberOfEncryptedFiles = 0;
        for (int i = 0; i < numberOfTxtFiles; i++) {
            if (filesInFolder[i].contains(".nj"))
                numberOfEncryptedFiles++;
        }
        encryptedFiles = new String[numberOfEncryptedFiles];
        int counter = 0;
        for (int i = 0; i < numberOfTxtFiles; i++) {
            if (filesInFolder[i].contains(".nj"))
                encryptedFiles[counter++] = filesInFolder[i]; 
        }
    }
    
    public int getNumberOfLines() {
        return content.length;
    }

    public String[] getContent() {
        return content;
    }
        
    public String[] getFilesInFolder() {
        return filesInFolder;
    }
    public void setFilesInFolder(String str, int index) {
        filesInFolder[index] = str;
    }
}


    
