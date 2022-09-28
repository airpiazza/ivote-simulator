import java.util.Random;
import java.util.UUID;

class Student {
    // allow student to submit answer to ivote service
    // has a unique ID string
    private final String uniqueId;
    private final VotingService votingService;

    Student(VotingService votingService) {
        Random random = new Random();
        uniqueId = UUID.randomUUID().toString() + random.nextInt(1000000000) + System.currentTimeMillis();
        this.votingService = votingService;
    }

    void answer(String response) {
        ISubmission submission = new SingleChoiceSubmission(uniqueId, response);
        votingService.submit(submission);
    }

    void answer(String[] responses) {
        ISubmission submission = new MultipleChoiceSubmission(uniqueId, responses);
        votingService.submit(submission);
    }
}
