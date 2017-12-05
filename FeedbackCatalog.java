import java.util.ArrayList;
import java.util.List;

public class FeedbackCatalog {
    private List<Feedback> feedbackList = new ArrayList<>();
    private int feedbacks = 0;

    public Feedback createFeedback(double rating, String comment, int targetID) {
        Feedback feedback = new Feedback(++feedbacks, comment, rating, targetID);
        feedbackList.add(feedback);
        return feedback;
    }
}
