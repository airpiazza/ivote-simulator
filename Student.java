import java.util.Random;
import java.util.UUID;

class Student {
    // allow student to submit answer to ivote service
    // has a unique ID string

    // Unique ID of student
    private final String uniqueId;

    // VotingService instance the student is submitting to
    private final VotingService votingService;

    Student(VotingService votingService) {
        // Initialize the unique ID using a random UUID added to a random integer added to the current time in ms
        Random random = new Random();
        uniqueId = UUID.randomUUID().toString() + random.nextInt(1000000000) + System.currentTimeMillis();

        // Initialize the voting service to the instance the student is submitting to
        this.votingService = votingService;
    }

    // Submit a single response
    void answer(String response) {
        // Initialize a single choice submission with the student's ID and single response
        ISubmission submission = new SingleChoiceSubmission(uniqueId, response);

        // Submit to the voting service with the single choice submission
        votingService.submit(submission);
    }

    // Submit multiple responses
    void answer(String[] responses) {
        // Initialize a multiple choice submission with the student's unique ID and responses
        ISubmission submission = new MultipleChoiceSubmission(uniqueId, responses);

        // Submit to the voting service with the multiple choice submission
        votingService.submit(submission);
    }
}
