package LeetCode.CloudKitchens.Task3;

public interface Votable {
    void vote(User user, int value);
    int getVoteCount();
}
