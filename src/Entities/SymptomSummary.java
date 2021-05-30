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

public class SymptomSummary {
    private int totalNumber;
    private int severityScore;
    public OveralRatingType overallRating;
    
    public boolean setTotalNumber(int totalNum){
        if (totalNum > 22 || totalNum < 0)
            return false;
        this.totalNumber = totalNum;
        return true;
    }
    
    public boolean setSeverityScore(int severityScore){
        if (severityScore > 132 || severityScore < 0)
            return false;
        this.severityScore = severityScore;
        return true;
    }
    
    public int getTotalNumber(){
        return this.totalNumber;
    }
    
    public int getSeverityScore(){
        return this.severityScore;
    }
}
