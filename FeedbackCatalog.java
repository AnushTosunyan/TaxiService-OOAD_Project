import java.util.ArrayList;
import java.util.List;

public class FeedbackCatalog {
    private List<Feedback> feedbackList = new ArrayList<>();

    public Feedback createFeedback(double rating, String comment, int targetID) {
        Feedback feedback = new Feedback((feedbackList.get(feedbackList.size() - 1).getID()+1), comment, rating, targetID);
        feedbackList.add(feedback);
        return feedback;
    }
}
