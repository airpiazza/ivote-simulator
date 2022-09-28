import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
Driver to simulate using the voting service sample questions, answers, and
randomly generated students with their randomly generated answers
*/
public class SimulationDriver {
    // Main method
    public static void main(String[] args) {
        // Configure question type to multiple choice and configure question by initializing a Question object
        Question multipleChoiceQuestion = new Question(true, "What is the answer?");

        // Configure the answers as a string array for use in the voting service
        String[] multipleChoiceAnswers = {"A", "B", "C", "D"};

        /*
        Start a new multiple choice voting session configured with the question and answers by
        initializing a VotingService object
        */
        VotingService multipleChoiceVotingService = new VotingService(multipleChoiceQuestion, multipleChoiceAnswers);

        // For-loop for simulating random students answering the multiple choice question
        for (int i = 0; i < 150; i++) {
            // Make a random student by initializing a new Student with the voting service
            Student randomStudent = new Student(multipleChoiceVotingService);

            // Select random answers from the available answers for submission
            Random random = new Random();
            String[] choices = new String[random.nextInt(multipleChoiceAnswers.length) + 1];
            for (int j = 0; j < choices.length; j++) {
                choices[j] = multipleChoiceAnswers[random.nextInt(multipleChoiceAnswers.length)];
            }

            // Submit an answer using the random student object's answer method which accepts an array of answers
            Set<String> choiceSet = new HashSet<>(Arrays.asList(choices));
            randomStudent.answer(choiceSet.toArray(new String[0]));
        }

        // Output statistics using the voting service's output statistics method
        multipleChoiceVotingService.outputStatistics();

        System.out.println();

        // Configure the question type to single and configure the question by making a question object
        Question singleChoiceQuestion = new Question(false, "Which one is it?");

        // A string array of answers for the voting service
        String[] singleChoiceAnswers = { "1. True", "2. Wrong", "3. Maybe", "4. I don't know" };

        // Open a single choice voting session by initializing a VotingService object with the question and answers
        VotingService singleChoiceVotingService = new VotingService(singleChoiceQuestion, singleChoiceAnswers);

        // For-loop for simulating random students submitting answers
        for (int i = 0; i < 100; i++) {
            // Create a random student by initializing a Student object with the voting service
            Student randomStudent = new Student(singleChoiceVotingService);

            // Select a random answer to submit
            Random random = new Random();
            String choice = singleChoiceAnswers[random.nextInt(singleChoiceAnswers.length)];

            // Submit the answer choice
            randomStudent.answer(choice);
        }

        // Output the statistics of the single choice voting
        singleChoiceVotingService.outputStatistics();
    }
}
