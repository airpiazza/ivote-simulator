import java.util.*;

// Class for the voting service which handles the single choice or multiple choice voting session
public class VotingService {

    // Keeps track of question and question type
    private final Question question;

    // Keeps track of how many votes for each answer
    private final Map<String, Integer> responseStatistics = new HashMap<>();

    // Keeps track of what each student has responded with
    private final Map<String, String[]> studentResponses = new HashMap<>();

    // Keeps track of answers available
    private final Set<String> answerSet = new HashSet<>();

    // Keeps track of students that have already answered
    private final Set<String> studentIdSet = new HashSet<>();

    // Initialize voting service with question and answers
    public VotingService(Question question, String[] answers) {
        // Initialize question with the question object
        this.question = question;

        // For-each-loop for initializing the vote tally to 0 and adding answers to the answer set
        for (String answer: answers) {
            responseStatistics.put(answer, 0);
            answerSet.add(answer);
        }
    }
    public void submit(ISubmission submission) {
        // Filter out the responses that are not one of the options
        String[] responses = Arrays.stream(submission.getResponses()).filter(answerSet::contains).toArray(String[]::new);

        // Get the id of student submitting
        String studentId = submission.getStudentId();

        // If there are no responses, return because there is nothing to process and submit
        if (responses.length <= 0) {
            return;
        }

        // Check if student has already submitted before
        if(studentIdSet.contains(studentId)) {
            // Remove the student's old answers from the tally
            String[] studentResponseArray = studentResponses.get(studentId);
            for (String studentResponse: studentResponseArray) {
                responseStatistics.put(studentResponse, responseStatistics.get(studentResponse) - 1);
            }
        } else {
            // Add student to the collection of students that have already answered
            studentIdSet.add(studentId);
        }

        // Record the student's latest submission
        studentResponses.put(studentId, responses);

        // check if question is multiple choice
        if(question.isMultipleChoice()) {
            // Use responses to update tally
            for (String response: responses) {
                responseStatistics.put(response, responseStatistics.get(response) + 1);
            }
        } else {
            // Uses last response in response array to update the tyally
            String lastResponse = responses[responses.length - 1];
            responseStatistics.put(lastResponse, responseStatistics.get(lastResponse) + 1);
        }
    }

    // Method for outputting statistics
    public void outputStatistics() {
        // Print question
        System.out.println(question.getQuestion());

        // Sort response statistics
        Map<String, Integer> displayMap = new TreeMap<>(responseStatistics);

        // Output tally
        displayMap.forEach((answer, amount) -> System.out.println(answer + ": " + amount));
    }

}
