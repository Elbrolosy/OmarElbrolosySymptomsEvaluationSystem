/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundries._submission;

import Entities.Game;
import java.util.ArrayList;
import Entities.SymptomEvaluation;
import java.util.Scanner;

/**
 *
 * @author Omar Tarek
 */
public class AthleteUI {
    private ArrayList<String> severityEvaluationQuestions;

    public AthleteUI() {
        severityEvaluationQuestions = new ArrayList<>();
        severityEvaluationQuestions.add("Headache");
        severityEvaluationQuestions.add("Pressure in head");
        severityEvaluationQuestions.add("Neck Pain");
        severityEvaluationQuestions.add("Nausea or vomiting");
        severityEvaluationQuestions.add("Dizziness");
        severityEvaluationQuestions.add("Blurred vision");
        severityEvaluationQuestions.add("Balance problems");
        severityEvaluationQuestions.add("Sensitivity to light");
        severityEvaluationQuestions.add("Sensitivity to noise");
        severityEvaluationQuestions.add("Feeling slowed down");
        severityEvaluationQuestions.add("Feeling like “in a fog“");
        severityEvaluationQuestions.add("“Don’t feel right”");
        severityEvaluationQuestions.add("Difficulty concentrating");
        severityEvaluationQuestions.add("Difficulty remembering");
        severityEvaluationQuestions.add("Fatigue or low energy");
        severityEvaluationQuestions.add("Confusion");
        severityEvaluationQuestions.add("Drowsiness");
        severityEvaluationQuestions.add("Trouble falling asleep (if applicable)");
        severityEvaluationQuestions.add("More emotional");
        severityEvaluationQuestions.add("Irritability");
        severityEvaluationQuestions.add("Sadness");
        severityEvaluationQuestions.add("Nervous or Anxious");
    }
    
    public int openAthleteOptionsForm(){
        System.out.print("               Welcome to Sport Concussion System\n");
        System.out.print("Please select one of the following options\n");
        System.out.print("        1. Enter Symptoms\n");
        System.out.print("        2. Display Symptoms Summary\n");
        System.out.print("        3. Am I at Risk?\n");
        System.out.print("        4. Exit\n");
        int res;
        return readInt(1, 4);
    }
    
    public SymptomEvaluation openEvalSubmissionForm(){
        SymptomEvaluation res = new SymptomEvaluation();
        for(int i=0; i<severityEvaluationQuestions.size(); i++){
            System.out.print("Please enter your " + severityEvaluationQuestions.get(i) + 
                " score (none (0), mild(1-2), moderate(3-4), & severe (5-6): )");
            res.addSymptom(i, readInt(0, 6));
        }
        return res;
    }
    
    public void DisplayAthleteGames(ArrayList<Game> games){
        for (int i=0; i<games.size(); i++) {
            System.out.println("Game #" + (i+1) + "symptom : \n- " 
                + "Total number of symptoms : " + games.get(i).symptomSum.getTotalNumber() + "\n- "
                + "Severity score : " + games.get(i).symptomSum.getSeverityScore() + "\n- "
                + "Overall rating : " + games.get(i).symptomSum.overallRating.name().replace("_", " "));
            System.out.println("\n\n");
        }
    }
    
    private int readInt(int mn, int mx){
        int res;
        while(true){
            try{
                Scanner myInput = new Scanner( System.in );
                res = myInput.nextInt();
                if (res < mn || res > mx){
                    throw new Exception();
                }
                break;
            }
            catch (Exception ex){
                System.err.println("Invalid Value");
            }
        }
        return res;
    }
}
