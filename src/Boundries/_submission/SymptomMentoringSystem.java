/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundries._submission;

import Controllers.Athlete;
import Entities.Game;
import Entities.OveralRatingType;
import Entities.SymptomEvaluation;
import java.util.ArrayList;

/**
 *
 * @author Omar Tarek
 */
public class SymptomMentoringSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AthleteUI ui = new AthleteUI();
        Athlete athleteController = new Athlete();
        athleteController.setId(1);
        athleteController.setName("Demo user");
        
        while (true){
            int choosenPage = ui.openAthleteOptionsForm();
            if (choosenPage == 4)
                break;
            if (choosenPage == 1){
                SymptomEvaluation submission = ui.openEvalSubmissionForm();
                if (!athleteController.submitEvaluation(submission)){
                    System.err.println("Something went wrong, please resubmit again!");
                }
            }
            else if (choosenPage == 2){
                ui.DisplayAthleteGames(athleteController.viewGames());
                try{
                    System.out.println("Press enter to return to the main menu!");
                    System.in.read();
                }
                catch(Exception ex){
                    continue;
                }
            }
            else if (choosenPage == 3){
                ArrayList<Game> games = athleteController.viewGames();
                Game lastGame = games.get(games.size()-1);
                if (lastGame.symptomSum.overallRating == OveralRatingType.No_difference){
                    System.out.println("\u001B[32m" + "You are good ;)" +
                        "\u001B[0m");
                }
                else if (lastGame.symptomSum.overallRating == OveralRatingType.Unsure){
                    System.out.println("\u001B[33m" + "Take care :)" +
                        "\u001B[0m");
                }
                else{
                    System.out.println("\u001B[31m" + "You are in danger :(" +
                        "\u001B[0m");
                }
                try{
                    System.out.println("Press enter to return to the main menu!");
                    System.in.read();
                }
                catch(Exception ex){
                    continue;
                }
            }
        }
    }
    
}
