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
    // Placeholder for the words in the line:
    private String[] words;
    // Word count:
    private int numberOfWords;
    private int wordsPerGroup;
    public cryptionClass(int number) {
        wordsPerGroup = number;
    }
    
    // Method that returns array of Strings of the working text:
    private String[] getWordsFromText(String[] textInArray) {
        // Make a new array with corrected number of words:
        String[] newStr = new String[numberOfWords];
        // Copy the words:
        for (int i = 0; i < numberOfWords; i++) {
            newStr[i] = textInArray[i];
        }
        // Return corrected words:
        return newStr;
    }
    
    // Method for concatinating 2 word - words: (e.g. "Los Santos")
    private void separatedWords(String text) {
        // Split the line of text into array of Strings:
        words = text.split("\\s+");
        // Current number of words is the number of words in the placeholder:
        int currentNumber = words.length;
        
        // Check if any of the words have one of these prefix's:
        for (int i = 0; i < currentNumber; i++) {
            // To lower case for easier pattern matching:
            switch (words[i].toLowerCase()) {
                case "los":
                case "san":
                case "las":
                case "de":
                case "saint":
                case "st":
                case "st.": {
                    // If the word was found and it's not the last word in text:
                    if ((i + 1) < currentNumber - 1) {
                        // Save it's position:
                        int tmp = i;
                        // Concatenate it with the word following it:
                        words[i] = words[i].concat(" " + words[i + 1]);
                        
                        // Increase the counter (go to the next word):
                        i++;
                        // Move the rest of the text one word back:
                        for (; i < currentNumber - 1; i++) {
                            words[i] = words[i + 1];
                        }
                        // By concatinating 2 separated words, we count one
                        // word less:
                        currentNumber--;
                        // Resume the text search from the found word's postion:
                        i = tmp;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        // Save the 'real' number of words:
        numberOfWords = currentNumber;
        // 'Cut off' the rest of the text not needed and get the correct form
        // of the words needed for encrypting/decrypting:
        words = getWordsFromText(words);
    }
    
    // Encryption method:
    private void encryptText() {
//        String tmp;
//        // Leftover words:
//        int code = 0;
//        
//        // Leftover words' count after separating them in the chunks of 5 words:
//        switch (numberOfWords % 5) {
//            case 2: {
//                code = 2;
//                break;
//            }
//            case 3: {
//                code = 3;
//                break;
//            }
//            case 4: {
//                code = 4;
//                break;
//            }
//        }
//        // Index of the words in the array:
//        int i = 0;
//        // If there are more words in the line of text than the leftover count:
//        if (numberOfWords > code) {
//            // While there are chunks of 5 words in the line, substitute their
//            // positions:
//            while (numberOfWords - i >= 5) {
//                tmp = words[i];
//                words[i] = words[i + 3];
//                words[i + 3] = words[i + 2];
//                words[i + 2] = words[i + 4];
//                words[i + 4] = words[i + 1];
//                words[i + 1] = tmp;
//                // After shuffling them, go to the next 5 words:
//                i = i + 5;
//            }
//        }
//        else {
//            i = 0;
//        }
//        // If there are 2, 3 or 4 words as 'leftover', shuffle them aswell:
//        switch (code) {
//            case 2: {
//                tmp = words[i];
//                words[i] = words[i + 1];
//                words[i + 1] = tmp;
//                break;
//            }
//            case 3: {
//                tmp = words[i];
//                words[i] = words[i + 1];
//                words[i + 1] = words[i + 2];
//                words[i + 2] = tmp;
//                break;
//            }
//            case 4: {
//                tmp = words[i];
//                words[i] = words[i + 3];
//                words[i + 3] = words[i + 1];
//                words[i + 1] = words[i + 2];
//                words[i + 2] = tmp;
//                break;
//            }
//        }

        enc();
    }
    
    // Decryption method:
    private void decryptText() {
//        String tmp;
//        // Leftover words:
//        int code = 0;
//        
//        // Leftover words' count after separating them in the chunks of 5 words:
//        switch (numberOfWords % 5) {
//            case 2: {
//                code = 2;
//                break;
//            }
//            case 3: {
//                code = 3;
//                break;
//            }
//            case 4: {
//                code = 4;
//                break;
//            }
//        }
//        // Index of the words in the array:
//        int i = 0;
//        // If there are more words in the line of text than the leftover count:
//        if (numberOfWords > code) {
//            // While there are chunks of 5 words in the line, substitute their
//            // positions back:
//            while (numberOfWords - i >= 5) {
//                tmp = words[i + 1];
//                words[i + 1] = words[i + 4];
//                words[i + 4] = words[i + 2];
//                words[i + 2] = words[i + 3];
//                words[i + 3] = words[i];
//                words[i] = tmp;
//                // After decrypting them, go to the next 5 words:
//                i = i + 5;
//            }
//        }
//        else {
//            i = 0;
//        }
//        // If there are 2, 3 or 4 words as 'leftover', shuffle them back aswell:
//        switch (code) {
//            case 2: {
//                tmp = words[i + 1];
//                words[i + 1] = words[i];
//                words[i] = tmp;
//                break;
//            }
//            case 3: {
//                tmp = words[i + 2];
//                words[i + 2] = words[i + 1];
//                words[i + 1] = words[i];
//                words[i] = tmp;
//                break;
//            }
//            case 4: {
//                tmp = words[i + 2];
//                words[i + 2] = words[i + 1];
//                words[i + 1] = words[i + 3];
//                words[i + 3] = words[i];
//                words[i] = tmp;
//                break;
//            }
//        }
        dec();
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
    public String encrypt(String txt) {
        String tmp;
        // Get the line of text separated and stored in 'words' variable:
        separatedWords(txt);
        // Encrypt the text:
        encryptText();
        // Our placeholder for the concatenated words:
        tmp = new String();
        
        // Concatenation:
        for (int k = 0; k < numberOfWords; k++) {
            tmp += words[k] + " ";
        }
        
        // Return the sentence as whole:
        return tmp;
    }
    
    // Interface for decryption:
    public String decrypt(String txt) {
        String tmp;
        // Get the line of text separated and stored in 'words' variable:
        separatedWords(txt);
        // Decrypt the text:
        decryptText();
        // Our placeholder for the concatenated words:
        tmp = new String();
        
        // Concatenation:
        for (int k = 0; k < numberOfWords; k++) {
            tmp += words[k] + " ";
        }
        
        // Return the sentence as whole:
        return tmp;   
    }
    
    public void enc() {
        String tmp;
        int pom = wordsPerGroup;
        int backIndex = pom - 1;
        int halfGroup;
        
        for (int i = 0; i < words.length && pom < words.length; i += wordsPerGroup) {

            backIndex = pom - 1;
            halfGroup = (((backIndex - i)/2)+i);

            for (int k = i; k < halfGroup; k++, backIndex--) {
                tmp = words[k];
                words[k] = words[backIndex];
                words[backIndex] = tmp;
            }

            backIndex = pom - 1;
            for (int k = i; k < pom && halfGroup < pom; k++, halfGroup++) {
                if (k % 2 == 0) {
                    tmp = words[k];
                    words[k] = words[halfGroup];
                    words[halfGroup] = tmp;
                }
            }
            pom += wordsPerGroup;
        }
    }
    
    public void dec() {
        String tmp;
        int pom = wordsPerGroup;
        int backIndex = pom - 1;
        int halfGroup;
        
        for (int i = 0; i < words.length && pom < words.length; i += wordsPerGroup) { 

                backIndex = pom - 1;
                halfGroup = (((backIndex - i)/2)+i);

                for (int k = i; k < pom && halfGroup < pom; k++, halfGroup++) {
                    if (k % 2 == 0) {
                        tmp = words[k];
                        words[k] = words[halfGroup];
                        words[halfGroup] = tmp;
                    }
                }
                
                backIndex = pom - 1;
                halfGroup = (((backIndex - i)/2)+i);
                for (int k = i; k < halfGroup; k++, backIndex--) {
                    tmp = words[k];
                    words[k] = words[backIndex];
                    words[backIndex] = tmp;
                }
                
                
                pom += wordsPerGroup;
        }
    }
}
