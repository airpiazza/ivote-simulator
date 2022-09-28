// Interface to be implemented by different submission types
// Adds flexibility so there's no need for method overloading in the voting service
interface ISubmission {
    // Get the student ID of student associated with the submission
    String getStudentId();

    // Get what student is submitting
    String[] getResponses();
}
