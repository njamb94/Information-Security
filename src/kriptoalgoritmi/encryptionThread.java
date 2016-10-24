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
public class encryptionThread {
    
    private String[] content;
    private String[] filesInFolder;
    private String encDstFolder;
    private int numberOfLines;
    private int index;

    // Thread constructor that saves all necessary information:
    // Sentences in array to be encrypted (text)
    // Names of the .txt files to be encrypted (files)
    // Destination folder for encrypted files (dst)
    // Number of lines to be written (lines)
    // Index of the .txt file being encrypted (i)
    public encryptionThread(String[] text, String[] files, String dst, 
            int lines, int i) {
        content = text;
        filesInFolder = files;
        encDstFolder = dst;
        numberOfLines = lines;
        index = i;
    }
    
   // Code for thread's execution
    public void run() {
        // Text encryption:
        cryptionClass cryptObj = new cryptionClass(content);
        String[] encryptedText = cryptObj.encrypt();

        //////////////////////////////
        // TO-DO: Save encryptedText to file:            
        try {
            filesInFolder[index] = filesInFolder[index].replace(".txt", ".nj");
            FileWriter fileWriter = new FileWriter(encDstFolder + "\\" + 
                    filesInFolder[index]);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < numberOfLines; i++) {
                buffWriter.write(content[i] + "\n");
            }

            buffWriter.close();
            fileWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(directoryClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
