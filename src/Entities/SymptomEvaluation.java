/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;

/**
 *
 * @author Omar Tarek
 */


public class SymptomEvaluation {
    private int[] symptoms;

    public SymptomEvaluation() {
        symptoms = new int[22];
    }
    
    public boolean addSymptom(int i, int value){
        if (i < 0 || i > 21 || value < 0 || value > 6)
            return false;
        symptoms[i] = value;
        return true;
    }
    
    public int getSymptom(int i){
        if (i < 0 || i > 21)
            return -1;
        return symptoms[i];
    }
}
