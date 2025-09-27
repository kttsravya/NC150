package LeetCode.CloudKitchens.Task3;

import java.util.Arrays;
import java.util.List;

public class StackOverFlowDemo {
    public static void main(String[] args){
        StackOverflow stackOverflow = new StackOverflow();

        //create users
        User alice = stackOverflow.createUser("Alice","alice@example.com");
        User bob = stackOverflow.createUser("Bob", "bob@example.com");
        User charlie = stackOverflow.createUser("Charlie", "charlie@example.com");

        // Alice asks a question
        Question javaQuestion = stackOverflow.askQuestion(alice, "what is polymorphism in java?", "Can someone explain polymorphism in Java with an example?",
                Arrays.asList("java", "oop"));

        Answer bobAnswer = stackOverflow.answerQuestion(bob, javaQuestion, "Polymorphism in java is the ability of an object to take on many forms");

        //Charlie comments on the question
        stackOverflow.addComment(charlie, javaQuestion,"Great question! I'm also interest in learning about this.");

        stackOverflow.addComment(alice, bobAnswer,"Thanks for explination! could you provide a code example?");

        stackOverflow.voteQuestion(charlie, javaQuestion, 1);
        stackOverflow.voteAnswer(charlie, bobAnswer, 1);

        Question pythonQuestion = stackOverflow.askQuestion(bob, "How to use list comprehensions in Python?",
                "I'm new to Python and I've heard about list comprehensions. Can someone explain how to use them?",
                Arrays.asList("python", "list-comprehension"));

        // Alice answers Bob's question
        Answer aliceAnswer = stackOverflow.answerQuestion(alice, pythonQuestion,
                "List comprehensions in Python provide a concise way to create lists...");

        // Charlie votes on Bob's question and Alice's answer
        stackOverflow.voteQuestion(charlie, pythonQuestion, 1);  // Upvote
        stackOverflow.voteAnswer(charlie, aliceAnswer, 1);  //

        // Print out the current state
        System.out.println("Question: " + javaQuestion.getTitle());
        System.out.println("Asked by: " + javaQuestion.getAuthor().getUserName());
        System.out.println("Tags: " + javaQuestion.getTags().stream().map(Tag::getName).reduce((a, b) -> a + ", " + b).orElse(""));
        System.out.println("Votes: " + javaQuestion.getVoteCount());
        System.out.println("Comments: " + javaQuestion.getComments().size());
        System.out.println("\nAnswer by " + bobAnswer.getAuthor().getUserName() + ":");
        System.out.println(bobAnswer.getContent());
        System.out.println("Votes: " + bobAnswer.getVoteCount());
        System.out.println("Accepted: " + bobAnswer.isAccepted());
        System.out.println("Comments: " + bobAnswer.getComments().size());

        System.out.println("\nUser Reputations:");
        System.out.println("Alice: " + alice.getReputation());
        System.out.println("Bob: " + bob.getReputation());
        System.out.println("Charlie: " + charlie.getReputation());

        // Demonstrate search functionality
        System.out.println("\nSearch Results for 'java':");
        List<Question> searchResults = stackOverflow.searchQuestions("java");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }

        System.out.println("\nSearch Results for 'python':");
        searchResults = stackOverflow.searchQuestions("python");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }

        // Demonstrate getting questions by user
        System.out.println("\nBob's Questions:");
        List<Question> bobQuestions = stackOverflow.getQuestionsByUser(bob);
        for (Question q : bobQuestions) {
            System.out.println(q.getTitle());
        }

    }
}
