/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Game;
import Entities.SymptomEvaluation;
import java.util.ArrayList;

/**
 *
 * @author Omar Tarek
 */
public class Athlete{
    private int id;
    private String name;
    
    public boolean setId(int id){
        if (id < 1){
            return false;
        }
        this.id = id;
        return true;
    }
    public int getId(){
        return this.id;
    }
    
    public boolean setName(String name){
        if (name == null || name.isEmpty()){
            return false;
        }
        this.name = name;
        return true;
    }
    
    public String getName(){
        return this.name;
    }
    
    public ArrayList<Game> viewGames(){
        return SymptomManager.readAthleteGames(this.id);
    }
    
    public boolean submitEvaluation(SymptomEvaluation eval){
        return SymptomManager.submitEvaluation(this.id, eval);
    }
}
