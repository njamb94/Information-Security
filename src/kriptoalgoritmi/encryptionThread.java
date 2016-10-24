/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptoalgoritmi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Njamb
 */
public class encryptionThread implements Runnable{
    
    private String[] content;
    private String[] filesInFolder;
    private String encDstFolder;
    private String decDstFolder;
    private int numberOfLines;
    private int index;
    private boolean isEncryption;

    // Thread constructor that saves all necessary information:
    // Sentences in array to be encrypted/decrypted (text)
    // Names of the .txt files to be encrypted/decrypted (files)
    // Destination folder for encrypted/decrypted files (dst)
    // Number of lines to be written (lines)
    // Index of the .txt/.nj file being encrypted/decrypted (i)
    public encryptionThread(directoryClass dir, int i, boolean bool) {
        
        content = new String[dir.getContent().length];
        for (int k = 0; k < content.length; k++)
            content[k] = dir.getContent()[k];
        
        filesInFolder = dir.getFilesInFolder();
        encDstFolder = dir.getEncDst();
        decDstFolder = dir.getDecDst();
        numberOfLines = dir.getNumberOfLines();
        index = i;
        isEncryption = bool;
    }
    
   // Code for thread's execution
    public void run() {
        // Text encryption:
        cryptionClass cryptObj = new cryptionClass(content);
        String[] text;
        if (isEncryption)
            text = cryptObj.encrypt();
        else
            text = cryptObj.decrypt();
        
        //////////////////////////////
        // TO-DO: Save encryptedText/decryptedText to file:            
        try {
            FileWriter fileWriter;
            if (isEncryption) {
                filesInFolder[index] = filesInFolder[index].replace(".txt", 
                        ".nj");
                fileWriter = new FileWriter(encDstFolder + "\\" + 
                    filesInFolder[index]);
            }
            else {
                filesInFolder[index] = filesInFolder[index].replace(".nj", 
                        ".txt");
                fileWriter = new FileWriter(decDstFolder + "\\" + 
                    filesInFolder[index]);
            }
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < numberOfLines - 1; i++) {
                buffWriter.write(text[i]);
                buffWriter.newLine();
            }
            buffWriter.write(text[numberOfLines - 1]);

            buffWriter.close();
            fileWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(directoryClass.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
    } 
}
