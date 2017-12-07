public class Feedback {
    private int feedbackID;
    private String comment;
    private double rating;
    private int targetID;

    public Feedback(int id, String comment, double rating, int targetID){
        this.comment = comment;
        this.feedbackID = id;
        this.targetID = targetID;
        this.rating = rating;
    }

    public int getID() {
        return feedbackID;
    }
}
