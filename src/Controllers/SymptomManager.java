/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Game;
import Entities.OveralRatingType;
import Entities.SymptomEvaluation;
import Entities.SymptomSummary;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Omar Tarek
 */
public class SymptomManager {
    private static HashMap<Integer, ArrayList<Game>> games = new HashMap<>();
    
    public static boolean submitEvaluation(int athleteId, SymptomEvaluation symptomEval){
        Game newGame = new Game(symptomEval);
        if (games.containsKey(athleteId)){
            games.get(athleteId).add(newGame);
        }
        else{
            ArrayList<Game> athleteGames = new ArrayList<>();
            athleteGames.add(newGame);
            games.put(athleteId, athleteGames);
        }
        SymptomSummary sum = evaluateSummary(athleteId);
        newGame.symptomSum = sum;
        games.get(athleteId).set(games.get(athleteId).size()-1, newGame);
        if (games.get(athleteId).size() > 5){
            games.get(athleteId).remove(0);
        }
        return true;
    }
    
    public static ArrayList<Game> readAthleteGames(int athleteId){
        if (!games.containsKey(athleteId))
            return new ArrayList<>();
        return games.get(athleteId);
    }
    
    private static SymptomSummary evaluateSummary(int athleteId){
        ArrayList<Game> athleteGames = games.get(athleteId);
        SymptomSummary res = new SymptomSummary();
        if (athleteGames.isEmpty()) return res;
        
        int totalNumber = 0;
        int severityScore = 0;
        Game lastGame = athleteGames.get(athleteGames.size()-1);
        for(int i=0; i<22; i++){
            severityScore += lastGame.symptomEval.getSymptom(i);
            totalNumber += lastGame.symptomEval.getSymptom(i) == 0 ? 0 : 1;
        }
        res.setSeverityScore(severityScore);
        res.setTotalNumber(totalNumber);
        
        if (athleteGames.size() >= 2){
            Game previousLastGame = athleteGames.get(athleteGames.size()-2);
            int totalDiff = totalNumber - previousLastGame.symptomSum.getTotalNumber();
            int severityDiff = severityScore - previousLastGame.symptomSum.getSeverityScore();

            res.overallRating = totalDiff < 3 && severityDiff < 10 ? OveralRatingType.No_difference
                    : totalDiff < 3 && severityDiff >= 10 && severityDiff < 15 ? OveralRatingType.Unsure
                    : OveralRatingType.Very_different;
        }
        else{
            res.overallRating = OveralRatingType.None;
        }
        
        lastGame.symptomSum = res;
        return res;
    }
}
