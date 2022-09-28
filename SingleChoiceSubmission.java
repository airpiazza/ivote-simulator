// Single choice submission class for submitting answer of single choice question to the voting service
class SingleChoiceSubmission implements ISubmission {

    // ID of student associated with the submission
    private final String studentId;

    // Student's answer to the question
    private final String response;

    // Initialize with student's ID and answer
    SingleChoiceSubmission(String studentId, String response) {
        this.studentId = studentId;
        this.response = response;
    }

    // Get ID of student associated with the submission
    @Override
    public String getStudentId() {
        return studentId;
    }

    // Get student's answer
    @Override
    public String[] getResponses() {
        // Puts the response into an array to be returned to satisfy the interface contract and maintain flexibility
        return new String[]{ response };
    }
}
