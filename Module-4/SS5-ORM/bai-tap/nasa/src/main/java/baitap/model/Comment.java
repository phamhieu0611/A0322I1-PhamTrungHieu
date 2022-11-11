package baitap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String authorne;
    private String feedbackne;
    private int likene;
    private int ratingne;

    public Comment() {
    }

    public Comment(int id, String authorne, String feedbackne, int likene, int ratingne) {
        this.id = id;
        this.authorne = authorne;
        this.feedbackne = feedbackne;
        this.likene = likene;
        this.ratingne = ratingne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorne() {
        return authorne;
    }

    public void setAuthorne(String authorne) {
        this.authorne = authorne;
    }

    public String getFeedbackne() {
        return feedbackne;
    }

    public void setFeedbackne(String feedbackne) {
        this.feedbackne = feedbackne;
    }

    public int getLikene() {
        return likene;
    }

    public void setLikene(int likene) {
        this.likene = likene;
    }

    public int getRatingne() {
        return ratingne;
    }

    public void setRatingne(int ratingne) {
        this.ratingne = ratingne;
    }
}
