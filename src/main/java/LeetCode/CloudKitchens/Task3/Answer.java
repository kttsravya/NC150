package LeetCode.CloudKitchens.Task3;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Votable, Commentable {
    private final int id;
    private final String content;
    private final User author;
    private final Question question;
    private boolean isAccepted;
    private final Date creationDate;
    private final List<Comment> comments;
    private final List<Vote> votes;

    public Answer(User author, Question question, String content) {
        this.id = generateId();
        this.author = author;
        this.question = question;
        this.content = content;
        this.creationDate = new Date();
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.isAccepted = false;
    }


    // TODO: if working correctly - iterator
    @Override
    public void vote(User user, int value) {
        if(value != -1 && value != 1){
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        for(Vote vote : votes){
            if(vote.getUser().getId() == user.getId()){
                votes.remove(user);
            }
        }
        votes.add(new Vote(user, value));
        author.updateReputation(value*10);
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }


    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void markAsAccepted(){
        this.isAccepted = true;
    }
}
