// Question class to configure the question type and question
class Question {
    // Keeps track of whether the question is multiple choice or not
    private final boolean isMultipleChoice;

    // Question asked to the students
    private final String question;

    // Initialized with configuration of whether it is multiple choice or not and the question
    Question(boolean isMultipleChoice, String question){
        this.isMultipleChoice = isMultipleChoice;
        this.question = question;
    }

    // Returns whether the question is multiple choice or not
    public boolean isMultipleChoice() {
        return isMultipleChoice;
    }

    // Returns question being asked to the students
    public String getQuestion() {
        return question;
    }
}
