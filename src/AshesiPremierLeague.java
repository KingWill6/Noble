import java.util.Scanner;

public class AshesiPremierLeague {
    public static void main(String[] args) {

        final float pound = 0.45359237f;
        final int meter = 100;


        String name;
        Integer age;
        double height;
        double weight;
        Integer jersey_number;
        String jersey_position = "";
        double weight_in_kg;
        double height_in_cm;
        Integer category;
        String category_name = "";
        Integer eligibility;
        String eligibility_name = "";
        String final_decision = "";
        String attacker_jersey = "";

        Scanner input = new Scanner(System.in);

        System.out.print("Enter player's name: ");
        name = input.nextLine();

        System.out.print("Enter player's age: ");
        age = input.nextInt();

        System.out.print("Enter player's height: ");
        height = input.nextDouble();
        height_in_cm = (height * meter);
        int new_height = (int) height_in_cm;

        System.out.print("Enter player's weight: ");
        weight = input.nextDouble();
        int intweight = (int) weight;
        weight_in_kg = weight * pound;
        int new_weight = (int) weight_in_kg;

        System.out.print("Enter player's jersey number: ");
        jersey_number = input.nextInt();

        input.close();


        // Eligibility: age 18-35 and weight < 90kg (set eligibility_name appropriately)
        if (age >= 18 && age <= 35) {
            if (new_weight < 90) {
                eligibility_name = "Eligible";
            } else {
                eligibility_name = "Not Eligible";
                System.out.println("Not Eligible");
            }
        } else {
            eligibility_name = "Not Eligible";
            System.out.println("Not Eligible");
        }

        // Final decision based on eligibility
        if (eligibility_name.equals("Eligible")) {
            final_decision = "Play";
        } else {
            final_decision = "Rest";
            System.out.println("Rest");
        }


        // Category by age
        if (age < 20) {
            category_name = "Rising Star";
        } else if (age >= 20 && age <= 30) {
            category_name = "Prime Player";
        } else if (age > 30) {
            category_name = "Veteran";
        }


        switch (jersey_number) {
            case 1:
                jersey_position = "Goalkeeper";
                break;
            case 2:
            case 5:
                jersey_position = "defender";
                break;
            case 6:
                jersey_position = "midfielder";
                break;
            case 7:
                jersey_position = "Winger";
                break;
            case 8:
                jersey_position = "Midfielder";
                break;
            case 9:
                jersey_position = "Striker";
                break;
            case 10:
                jersey_position = "Winger";
                break;
            default:
                jersey_position = "Player position not known";
        }

        if (jersey_number == 9) {
            attacker_jersey = "Yes";
        } else {
            attacker_jersey = "No";
        }


        // Lineup decision logic:
        // - If under 20: Bench
        // - If 20..30 inclusive: Starting Lineup if weight <= 90, otherwise Bench
        // - Over 30: Bench
        String lineupStatus;
        if (age < 20) {
            lineupStatus = "Bench";
            System.out.println("Bench");
        } else if (age >= 20 && age <= 30) {
            if (new_weight <= 90) {
                lineupStatus = "Starting Lineup";
                System.out.println("Starting Lineup");
            } else {
                lineupStatus = "Bench";
                System.out.println("Bench");
            }
        } else {
            lineupStatus = "Bench";
            System.out.println("Bench");
        }

        // Always print the player report
        System.out.println("\n --- PlayerReport ---");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + category_name + ")");
        System.out.println("Height: " + new_height + "cm");
        System.out.println("Weight: " + new_weight + "kg");
        System.out.println("Jersey Number: " + jersey_number );
        System.out.println("Position: " + jersey_position);
        System.out.println("Attacker jersey: " + attacker_jersey);
        System.out.println("Eligibility: " + eligibility_name);
        System.out.println("Lineup decision: 4-3-3");
        System.out.println("Final Decision: " + final_decision);

    }
}