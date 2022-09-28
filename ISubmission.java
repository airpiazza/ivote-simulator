// Interface to be implemented by different submission types
interface ISubmission {
    // Get the student ID of student associated with the submission
    String getStudentId();

    // Get what student is submitting
    String[] getResponses();
}
