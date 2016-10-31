/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptoalgoritmi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author njamb94
 */
public class a5_1Thread implements Runnable{

    private final int fileIndex;
    private final boolean isEncryption;
    private final directoryClass dir;
    private String key;
    
    public a5_1Thread(directoryClass dir, int index, boolean bool, String key) {
        this.dir = dir;
        fileIndex = index;
        isEncryption = bool;
        this.key = key;
    }
    
    @Override
    public void run() {
        a5_1Cryption cryptObj = new a5_1Cryption(key);
        
        try {
            FileInputStream fileInput = null;
            BufferedInputStream buffInput = null;
            DataInputStream dataInput = null;
            
            FileOutputStream fileOutput = null;
            BufferedOutputStream buffOutput = null;
            DataOutputStream dataOutput = null;
                
            // Encryption:
            if (isEncryption) {
                if (!dir.getFilesInFolder()[fileIndex].isEmpty()) {

                    // Open input file: // Change "/" with "\\" when on WINDOWS
                    fileInput = new FileInputStream(dir.getEncSrc() + "/" + 
                            dir.getFilesInFolder()[fileIndex]);
                    buffInput = new BufferedInputStream(fileInput);
                    dataInput = new DataInputStream(buffInput);

                    // We extract the fileName from the array of Strings:
                    String fileName = dir.getFilesInFolder()[fileIndex];
                    // Get the index of extension prefix '.':
                    int index = fileName.indexOf(".");
                    // Get the extension (with it's prefix):
                    String extension = fileName.substring(index, 
                            fileName.length());
                    // Get the fileName without extension:
                    fileName = fileName.substring(0, index);

                    // Open output file:
                    fileOutput = new FileOutputStream(dir.getEncDst() + "/" +
                            fileName + ".a51");
                    buffOutput = new BufferedOutputStream(fileOutput);
                    dataOutput = new DataOutputStream(buffOutput);

                    // First we write key length (should be 64 always):
                    dataOutput.writeInt(key.length());
                    // Then we write the key itself:
                    for (int i = 0; i < key.length(); i++) {
                        dataOutput.writeChar(key.charAt(i));
                    }
                    
                    // After that, we write the number of chars needed to 
                    // remember the extension:
                    dataOutput.writeInt(extension.length());
                    // Then, we write the extension name:
                    dataOutput.writeChars(extension);

                    // Read byte by byte, encrypt it, and write it to 
                    // destination:
                    byte readByte;
                    while (dataInput.available() > 0) {
                        readByte = dataInput.readByte();
                        cryptObj.setByte(readByte);
                        readByte = cryptObj.encrypt();

                        dataOutput.writeByte(readByte);
                    }

                    // Close output:
                    dataOutput.close();
                    buffOutput.close();
                    fileOutput.close();

                    // Close input:
                    dataInput.close();
                    buffInput.close();
                    fileInput.close();
                }
            }
            // Decryption:
            else {
                // It will skip decryption if the file exists in the destination
                // folder in it's original 
                if (!dir.getFilesInFolder()[fileIndex].isEmpty()) {

                    // Open input file:
                    fileInput = new FileInputStream(dir.getDecSrc() + "/" + 
                            dir.getFilesInFolder()[fileIndex]);
                    buffInput = new BufferedInputStream(fileInput);
                    dataInput = new DataInputStream(buffInput);

                    // We extract the fileName from the array of Strings:
                    String fileName = dir.getFilesInFolder()[fileIndex];
                    // Get the index of extension prefix '.':
                    int index = fileName.indexOf(".");
                    // Get the fileName without extension:
                    fileName = fileName.substring(0, index);

                    // First we read the keyLength used for encryption:
                    int keyLength = dataInput.readInt();
                    // Then we make placeholder for our key:
                    char[] readKey = new char[keyLength];
                    // Read and store the key value:
                    for (int i = 0; i < keyLength; i++) {
                        readKey[i] = dataInput.readChar();
                    }
                    // Necessary conversion from char[] to String:
                    StringBuilder builder = new StringBuilder();
                    builder.append(readKey);
                    key = builder.toString();
                    
                    // First we write key length (should be 64 always):
                    dataOutput.writeInt(key.length());
                    // Then we write the key itself:
                    for (int i = 0; i < key.length(); i++) {
                        dataOutput.writeChar(key.charAt(i));
                    }
                    
                    // First we read the number of chars for written extension:
                    int numberOfChars = dataInput.readInt();
                    // Create extension placeholder and read it from file.
                    // (Extension with it's prefix dot):
                    char[] extension = new char[numberOfChars];
                    for (int i = 0; i < numberOfChars; i++)
                        extension[i] = dataInput.readChar();

                    // Open output file:
                    fileOutput = new FileOutputStream(dir.getDecDst() + "/" +
                            fileName + String.valueOf(extension));
                    buffOutput = new BufferedOutputStream(fileOutput);
                    dataOutput = new DataOutputStream(buffOutput);

                    // Read byte by byte, decrypt it, and write it at destination:
                    byte readByte;
                    while (fileInput.available() > 0) {
                        readByte = dataInput.readByte();
                        cryptObj.setByte(readByte);
                        readByte = cryptObj.decrypt();

                        dataOutput.writeByte(readByte);
                    }

                    // Close output:
                    dataOutput.close();
                    buffOutput.close();
                    fileOutput.close();

                    // Close input:
                    dataInput.close();
                    buffInput.close();
                    fileInput.close();
                }
            }
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(a5_1Thread.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(a5_1Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
