/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Omar Tarek
 */
public class Game {
    public SymptomEvaluation symptomEval;
    public SymptomSummary symptomSum;

    public Game(SymptomEvaluation eval) {
        this.symptomEval = eval;
    }
    
    
}
