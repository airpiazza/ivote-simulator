import java.util.Random;

/*
Driver to simulate using the voting service sample questions, answers, and
randomly generated students with their randomly generated answers
*/
public class SimulationDriver {
    // Main method
    public static void main(String[] args) {
        // create a question type
        // configure the answers
        // configure the question for the ivote service
        // randomly generate a number of students and answers
        // submit all students' anssers to iVote service
        // call voting service output function to display result

        // Configure question type to multiple choice and configure question by initializing a Question object
        Question multipleChoiceQuestion = new Question(true, "What is the answer?");

        // Configure the answers as a string array for use in the voting service
        String[] multipleChoiceAnswers = {"A", "B", "C", "D"};
        VotingService multipleChoiceVotingService = new VotingService(multipleChoiceQuestion, multipleChoiceAnswers);

        for (int i = 0; i < 150; i++) {
            Student randomStudent = new Student(multipleChoiceVotingService);
            Random random = new Random();
            String[] choices = new String[random.nextInt(multipleChoiceAnswers.length) + 1];
            for (int j = 0; j < choices.length; j++) {
                choices[j] = multipleChoiceAnswers[random.nextInt(multipleChoiceAnswers.length)];
            }
            randomStudent.answer(choices);
            String[] badAnswers = {"z", "h"};
            randomStudent.answer(badAnswers);
        }

        multipleChoiceVotingService.outputStatistics();

        System.out.println();

        Question singleChoiceQuestion = new Question(false, "Which one is it?");
        String[] singleChoiceAnswers = {"1. True", "2. Wrong", "3. Maybe", "4. I don't know"};
        VotingService singleChoiceVotingService = new VotingService(singleChoiceQuestion, singleChoiceAnswers);
        for (int i = 0; i < 100; i++) {
            Student randomStudent = new Student(singleChoiceVotingService);
            Random random = new Random();
            String choice = singleChoiceAnswers[random.nextInt(singleChoiceAnswers.length)];
            randomStudent.answer(choice);
            randomStudent.answer("asdfjweifpoiwe");
        }

        singleChoiceVotingService.outputStatistics();
    }
}
