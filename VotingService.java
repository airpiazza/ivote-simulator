import java.util.*;

public class VotingService {

    private final Question question;
    private final Map<String, Integer> responseStatistics = new HashMap<>();
    private final Map<String, String[]> studentResponses = new HashMap<>();
    private final Set<String> answerSet = new HashSet<>();
    private final Set<String> studentIdSet = new HashSet<>();

    public VotingService(Question question, String[] answers) {
        this.question = question;

        for (String answer:
             answers) {
            responseStatistics.put(answer, 0);
            answerSet.add(answer);
        }
    }
    public void submit(ISubmission submission) {
        String[] responses = Arrays.stream(submission.getResponses()).filter(answerSet::contains).toArray(String[]::new);
        String studentId = submission.getStudentId();

        if (responses.length <= 0) {
            return;
        }

        if(studentIdSet.contains(studentId)) {
            String[] studentResponseArray = studentResponses.get(studentId);
            for (String studentResponse:
                 studentResponseArray) {
                responseStatistics.put(studentResponse, responseStatistics.get(studentResponse) - 1);
            }
        } else {
            studentIdSet.add(studentId);
        }

        studentResponses.put(studentId, responses);

        if(question.isMultipleChoice()) {
            for (String response:
                 responses) {
                responseStatistics.put(response, responseStatistics.get(response) + 1);
            }
        } else {
            String lastResponse = responses[responses.length - 1];
            responseStatistics.put(lastResponse, responseStatistics.get(lastResponse) + 1);
        }
    }

    public void outputStatistics() {
        System.out.println(question.getQuestion());
        Map<String, Integer> displayMap = new TreeMap<>(responseStatistics);
        displayMap.forEach((answer, amount) -> System.out.println(answer + ": " + amount));
    }

    // configure question types, multiple choice or single choice
    // configure candidate answers for each type
    // then can accept submissions from students
    // each student can only submit one answer, if multiple only last submission is counted
    // can output statistics of submission results

}
