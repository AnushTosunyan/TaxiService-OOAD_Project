import java.util.ArrayList;
import java.util.List;

public class FeedbackCatalog {
    private List<Feedback> feedbackList;

    public FeedbackCatalog(){

        feedbackList = new ArrayList<>();
        feedbackList.add(new Feedback(0, " ", 10.0, 0));
    }

    public Feedback createFeedback(double rating, String comment, int targetID) {
        Feedback feedback = new Feedback((feedbackList.get(feedbackList.size() - 1).getID()+1), comment, rating, targetID);
        feedbackList.add(feedback);
        return feedback;
    }
}
