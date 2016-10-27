/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptoalgoritmi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Njamb
 */
public class encryptionThread implements Runnable{
    
    // Placeholder for the names of the .txt/.nj files:
    private String[] filesInFolder;
    // Placeholders for source & destination paths for encryption & decryption:
    private String encSrcFolder;
    private String encDstFolder;
    private String decSrcFolder;
    private String decDstFolder;
    
    // Index of the file in 'filesInFolder' being encrypted/decrypted:
    private int index;
    // Flag for determinating if it's encryption/decryption (true/false):
    private boolean isEncryption;

    // Thread constructor that sets above mentioned placeholders:
    public encryptionThread(directoryClass dir, int i, boolean bool) {
       
        filesInFolder = dir.getFilesInFolder();
        encSrcFolder = dir.getEncSrc();
        encDstFolder = dir.getEncDst();
        decSrcFolder = dir.getDecSrc();
        decDstFolder = dir.getDecDst();
        
        index = i;
        isEncryption = bool;
    }
    
   // Code for thread's execution
    public void run() {
        // Create object for our encryption/decryption:
        cryptionClass cryptObj = new cryptionClass();
                    
        try {
            FileReader fileReader = null;
            BufferedReader buffReader = null;
            FileWriter fileWriter = null;
            BufferedWriter buffWriter = null;
            // If it's encryption:
            if (isEncryption) {
                if (!filesInFolder[index].isEmpty()) {
                    // Open the source folder, concatenated by the file's name:
                    fileReader = new FileReader(encSrcFolder + "\\" + 
                                filesInFolder[index]);
                    buffReader = new BufferedReader(fileReader);
                                
                    // Change that file's extension to '.nj' before being stored:
                    filesInFolder[index] = filesInFolder[index].replace(".txt", 
                            ".nj");
                    // Open the destination folder, concatenated by the file's new
                    // name:
                    fileWriter = new FileWriter(encDstFolder + "\\" + 
                        filesInFolder[index]);
                    buffWriter = new BufferedWriter(fileWriter);
                }
            }
            // If it's decryption:
            else {
                if (!filesInFolder[index].isEmpty()) {
                // Open the source folder, concatenated by the file's name:
                    fileReader = new FileReader(decSrcFolder + "\\" + 
                                filesInFolder[index]);
                    buffReader = new BufferedReader(fileReader);
                    
                    // Change that file's extension to '.txt' before being stored:
                    filesInFolder[index] = filesInFolder[index].replace(".nj", 
                            ".txt");
                    // Open the destination folder, concatenated by the file's new
                    // name:
                    fileWriter = new FileWriter(decDstFolder + "\\" + 
                        filesInFolder[index]);
                    buffWriter = new BufferedWriter(fileWriter);
                }
            }
            
            if (!filesInFolder[index].isEmpty()) {
                // Placeholder for the line that's next to be written: 
                String line;
                // While there is something to read, read it, and store it to 
                // 'line'
                while ((line = buffReader.readLine()) != null) {
                        if (isEncryption){
                            // Encrypt the line of text:
                            line = cryptObj.encrypt(line);
                        }
                        else {
                            // Decrypt the line of text:
                            line = cryptObj.decrypt(line);
                        }

                        // Write that line and go to the new line:
                        buffWriter.write(line);
                        buffWriter.newLine();
                    }
                    // Close all readers/writers:
                    buffReader.close();
                    fileReader.close();
                    buffWriter.close();
                    fileWriter.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(directoryClass.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        // Thread awakening mechanism (for the thread that's waiting):
        if (index % 2 == 0)
            synchronized (directoryClass.getInstance()) {
                directoryClass.getInstance().notify();
            }
    } 
}
