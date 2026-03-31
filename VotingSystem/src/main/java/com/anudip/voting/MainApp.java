package com.anudip.voting;

import java.util.Scanner;

import com.anudip.voting.service.VoteService;
import com.anudip.voting.service.ResultService;
import com.anudip.voting.service.CandidateService;
import com.anudip.voting.service.VoterService;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create service objects
        VoteService voteService =
                new VoteService();

        ResultService resultService =
                new ResultService();

        CandidateService candidateService =
                new CandidateService();

        VoterService voterService =
                new VoterService();

        while (true) {

            System.out.println(
                    "\n===== ONLINE VOTING SYSTEM =====");

            System.out.println("1. Show Candidates");
            System.out.println("2. Cast Vote");
            System.out.println("3. Show Winner");
            System.out.println("4. Show Voters");
            System.out.println("5. Exit");

            System.out.print(
                    "Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                candidateService.showCandidates();
                break;

            case 2:

                System.out.print(
                        "Enter Voter ID: ");

                int voterId =
                        sc.nextInt();

                System.out.print(
                        "Enter Candidate ID: ");

                int candidateId =
                        sc.nextInt();

                voteService.castVote(
                        voterId,
                        candidateId);

                break;

            case 3:

                resultService.showWinner();
                break;

            case 4:

                voterService.showVoters();
                break;

            case 5:

                System.out.println(
                        "Exiting...");

                sc.close();
                System.exit(0);

            default:

                System.out.println(
                        "Invalid choice!");
            }
        }
    }
}