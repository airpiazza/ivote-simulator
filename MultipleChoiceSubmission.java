// Multiple choice submission class for answering multiple choice questions to the voting service
class MultipleChoiceSubmission implements ISubmission {
    // Student ID of student associated with the multiple choice submission
    private final String studentId;

    // The answer or answers submitted by the student
    private final String[] responses;

    // Initialize with the student's ID and answers
    MultipleChoiceSubmission(String studentId, String[] responses) {
        this.studentId = studentId;
        this.responses = responses;
    }

    // Get ID of student associated with the submission
    @Override
    public String getStudentId() {
        return studentId;
    }

    // Get responses of student associated with the submission
    @Override
    public String[] getResponses() {
        return responses;
    }
}
