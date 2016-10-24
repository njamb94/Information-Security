/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptoalgoritmi;

/**
 *
 * @author Njamb
 */
public class cryptionClass {
    private String[] words;
    private int numberOfWords;
    private String[] sentences;
    
    public cryptionClass(String[] text) {
        sentences = text;
    }
    
    // Method that returns String array of the working text:
    private String[] getWordsFromText(String[] textInArray) {
        String[] newStr = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            newStr[i] = textInArray[i];
        }
        return newStr;
    }
    
    // Method for concatinating 2 word - words: (e.g. "Los Santos")
    private void separatedWords(String text) {
        words = text.split("\\s+");
        int currentNumber = words.length;
        
        for (int i = 0; i < currentNumber; i++) {
            switch (words[i].toLowerCase()) {
                case "los":
                case "san":
                case "las":
                case "de":
                case "saint":
                case "st":
                case "st.": {
                    if ((i + 1) < currentNumber - 1) {
                        int tmp = i;
                        words[i] = words[i].concat(" " + words[i + 1]);
                        
                        i++;
                        for (; i < currentNumber - 1; i++) {
                            words[i] = words[i + 1];
                        }
                        
                        currentNumber--;
                        i = tmp;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        
        numberOfWords = currentNumber;
        words = getWordsFromText(words);
    }
    
    // Encryption method:
    private void encryptText() {
        String tmp;
        int code = 0;
        
        switch (numberOfWords % 5) {
            case 2: {
                code = 2;
                break;
            }
            case 3: {
                code = 3;
                break;
            }
            case 4: {
                code = 4;
                break;
            }
        }
        
        int i = 0;
        if (numberOfWords > code) {
            while (numberOfWords - i >= 5) {
                tmp = words[i];
                words[i] = words[i + 3];
                words[i + 3] = words[i + 2];
                words[i + 2] = words[i + 4];
                words[i + 4] = words[i + 1];
                words[i + 1] = tmp;
                i = i + 5;
            }
        }
        else {
            i = 0;
        }
        switch (code) {
            case 2: {
                tmp = words[i];
                words[i] = words[i + 1];
                words[i + 1] = tmp;
                break;
            }
            case 3: {
                tmp = words[i];
                words[i] = words[i + 1];
                words[i + 1] = words[i + 2];
                words[i + 2] = tmp;
                break;
            }
            case 4: {
                tmp = words[i];
                words[i] = words[i + 3];
                words[i + 3] = words[i + 1];
                words[i + 1] = words[i + 2];
                words[i + 2] = tmp;
                break;
            }
        }
    }
    
    // Decryption method:
    private void decryptText() {
        String tmp;
        int code = 0;
        
        switch (numberOfWords % 5) {
            case 2: {
                code = 2;
                break;
            }
            case 3: {
                code = 3;
                break;
            }
            case 4: {
                code = 4;
                break;
            }
        }
        
        int i = 0;
        if (numberOfWords > code) {
            while (numberOfWords - i >= 5) {
                tmp = words[i + 1];
                words[i + 1] = words[i + 4];
                words[i + 4] = words[i + 2];
                words[i + 2] = words[i + 3];
                words[i + 3] = words[i];
                words[i] = tmp;
                i = i + 5;
            }
        }
        else {
            i = 0;
        }
        switch (code) {
            case 2: {
                tmp = words[i + 1];
                words[i + 1] = words[i];
                words[i] = tmp;
                break;
            }
            case 3: {
                tmp = words[i + 2];
                words[i + 2] = words[i + 1];
                words[i + 1] = words[i];
                words[i] = tmp;
                break;
            }
            case 4: {
                tmp = words[i + 2];
                words[i + 2] = words[i + 1];
                words[i + 1] = words[i + 3];
                words[i + 3] = words[i];
                words[i] = tmp;
                break;
            }
        }
    }
    
    // Method for printing all words to console:
    public void printWords() {
        String str = new String();
        for (int i = 0; i < numberOfWords; i++) {
            str = str.concat(words[i] + " ");
        }
        
        System.out.print(str);
    }

    // Interface for encryption:
    public String[] encrypt() {
        String tmp;
        for (int i = 0; i < sentences.length; i++) {
            separatedWords(sentences[i]);
            encryptText();
            
            tmp = new String();
            for (int k = 0; k < numberOfWords; k++) {
                tmp += words[k] + " ";
            }
            
            // Encrypted sentence returned to it's place:
            sentences[i] = tmp;
        }
        return sentences;
    }
    
    // Interface for decryption:
    public String[] decrypt() {
        String tmp;
        for (int i = 0; i < sentences.length; i++) {
            separatedWords(sentences[i]);
            decryptText();

            tmp = new String();
            for (int k = 0; k < numberOfWords; k++) {
                tmp += words[k] + " ";
            }

            // Decrypted sentence returned to it's place:
            sentences[i] = tmp;
        }
        return sentences;    
    }
}
