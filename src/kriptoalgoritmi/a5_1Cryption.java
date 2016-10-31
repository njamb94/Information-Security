/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptoalgoritmi;

/**
 *
 * @author njamb94
 */
public class a5_1Cryption {
    private String key;
    private byte oneByte;
    private int[] smallReg = new int[19]; // 0-18
    private int[] midReg = new int[22]; // 0-21
    private int[] bigReg = new int[23]; // 0-22
    private int majorityVote;
    
    public a5_1Cryption(String key) {
        this.key = key;
      
        clearRegs();
        fillRegsWithKey();
    }
    
//    // Setter for a sequence of numbers given as a string:
//    public void setNumbers(String numbers) {
//        this.numbers = numbers;
//    }
    
    // Method for clearing all three shifting registers:
    private void clearRegs() {
        for (int i = 0; i < 19; i++) {
                smallReg[i] = 0;
                midReg[i] = 0;
                bigReg[i] = 0;
            }

            for (int i = 19; i < 22; i++) {
                midReg[i] = 0;
                bigReg[i] = 0;
            }

            bigReg[22] = 0;
            majorityVote = 0;
    }
    
    // Method for filling shifting registers with the key value:
    private void fillRegsWithKey() {
        int counter = 0;
        
        for (int i = 0; i < 19; i++, counter++) {
            smallReg[i] = Integer.parseInt(String.valueOf(key.charAt(counter)));
        }
        
        for (int i = 0; i < 22; i++, counter++) {
            midReg[i] = Integer.parseInt(String.valueOf(key.charAt(counter)));
        }
        
        for (int i = 0; i < 23; i++, counter++) {
            bigReg[i] = Integer.parseInt(String.valueOf(key.charAt(counter)));
        }
    }
    
    // Method for checking which registers are going to be shifted.
    // Method returns XOR'ed value of top bits of each register (which are being
    // pushed to carry:
    private int majorityVote() {
        int zeros = 0;
        int ones = 0;
        
        if (smallReg[8] == 0)
            zeros++;
        else
            ones++;
        
        if (midReg[10] == 0)
            zeros++;
        else
            ones++;
        
        if (bigReg[10] == 0)
            zeros++;
        else
            ones++;
        
        if (zeros > ones) {
            majorityVote = 0;
            return shiftRegs(0);
        }
        else {
            majorityVote = 1;
            return shiftRegs(1);
        }
    }

    // Method for checking if majority in significant bits of register are 0/1.
    // Those who are part of majority, get shifted:
    private int shiftRegs(int major) {
        int small = smallReg[18];
        int mid = midReg[21];
        int big = bigReg[22];
        
        if (major == 0) {
            if (smallReg[8] == 0)
                shiftSmall();
            if (midReg[10] == 0)
                shiftMid();
            if (bigReg[10] == 0)
                shiftBig();
        }
        else {
            if (smallReg[8] == 1)
                shiftSmall();
            if (midReg[10] == 1)
                shiftMid();
            if (bigReg[10] == 1)
                shiftBig();
        }
        
        return small ^ mid ^ big;
    }

    // Shift method for smallReg:
    private void shiftSmall() {
        int xorValue = smallReg[13] ^ smallReg[16] 
                ^ smallReg[17] ^ smallReg[18];
        
        for (int i = 18; i > 0; i--)
            smallReg[i] = smallReg[i-1];
        smallReg[0] = xorValue;
    }

    
    // Shift method for midReg:
    private void shiftMid() {
        int xorValue = midReg[20] ^ midReg[21];
        
        for (int i = 21; i > 0; i--)
            midReg[i] = midReg[i-1];
        midReg[0] = xorValue;
    }

    // Shift method for bigReg:
    private void shiftBig() {
        int xorValue = bigReg[7] ^ bigReg[20] ^ bigReg[21] ^ bigReg[22];
        
        for (int i = 22; i > 0; i--)
            bigReg[i] = bigReg[i-1];
        bigReg[0] = xorValue;
    }

    // smallReg array getter:
    public int[] getSmallReg() {
        return smallReg;
    }
    
    // midReg array getter:
    public int[] getMidReg() {
        return midReg;
    }
    
    // bigReg array getter:
    public int[] getBigReg() {
        return bigReg;
    }
    
    // Method for setting the working byte - 'oneByte':
    public void setByte(byte block) {
        oneByte = block;
    }
    
    // Method for encryption using A5/1 algorithm:
    public byte encrypt() {
        byte xorByte = (byte) 0x80;
        
        for (int i = 0; i < 8; i++) {
            if (majorityVote() == 1) {
                oneByte ^= xorByte;
            }
            xorByte >>>= 1;
        }
        
        return oneByte;
    }
    
    // Method for decryption using A5/1 algorithm:
    public byte decrypt() {
        return encrypt();
    }
    
    // Getter for key:
    public String getKey() {
        return key;
    }
    
    // Setter for key:
    public void setKey(String key) {
        this.key = key;
    }
    
    public int getMajorityVote() {
        return majorityVote;
    }
}
