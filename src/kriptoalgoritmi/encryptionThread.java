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
    
    private String[] filesInFolder;
    private String encSrcFolder;
    private String encDstFolder;
    private String decSrcFolder;
    private String decDstFolder;
    
    private int index;
    private boolean isEncryption;

    // Thread constructor that saves all necessary information:
    // Sentences in array to be encrypted/decrypted (text)
    // Names of the .txt files to be encrypted/decrypted (files)
    // Destination folder for encrypted/decrypted files (dst)
    // Number of lines to be written (lines)
    // Index of the .txt/.nj file being encrypted/decrypted (i)
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
        // Text encryption:
        cryptionClass cryptObj = new cryptionClass();
                    
        try {
            FileReader fileReader;
            BufferedReader buffReader;
            FileWriter fileWriter;
            if (isEncryption) {
                fileReader = new FileReader(encSrcFolder + "\\" + 
                            filesInFolder[index]);
                buffReader = new BufferedReader(fileReader);
                
                filesInFolder[index] = filesInFolder[index].replace(".txt", 
                        ".nj");
                fileWriter = new FileWriter(encDstFolder + "\\" + 
                    filesInFolder[index]);
            }
            else {
                fileReader = new FileReader(decSrcFolder + "\\" + 
                            filesInFolder[index]);
                buffReader = new BufferedReader(fileReader);
                
                 filesInFolder[index] = filesInFolder[index].replace(".nj", 
                        ".txt");
                fileWriter = new FileWriter(decDstFolder + "\\" + 
                    filesInFolder[index]);
            }
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            
            if (filesInFolder[index].contains("SWE")) {
                int p;
            }
            
            String line;
            while ((line = buffReader.readLine()) != null) {
                if (isEncryption){
                    line = cryptObj.encrypt(line);
                }
                else {
                    line = cryptObj.decrypt(line);
                }
                
                buffWriter.write(line);
                buffWriter.newLine();
            }
            buffReader.close();
            fileReader.close();
            buffWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(directoryClass.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        if (index % 2 == 0)
            synchronized (directoryClass.getInstance()) {
                directoryClass.getInstance().notify();
            }
    } 
}
