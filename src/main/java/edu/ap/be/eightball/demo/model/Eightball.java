package edu.ap.be.eightball.demo.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Eightball{
    private String question;
    private String answer;
    private List<String> answers = new LinkedList<String>(Arrays.asList("It is certain.", "It is decidedly so.", "Without a doubt.", "Yes - definitely.", "You may rely on it.", "As I see it, yes.",
    "Most likely.", "Outlook good.", "Yes.", "Signs point to yes.", "Reply hazy, try again", "Ask again later.", "Better not tell you now.",
    "Cannot predict now.", "Concentrate and ask again.", "Don't count on it.", "My reply is no.", "My sources say no",
    "Outlook not so good.", "Very doubtful."));


    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        Random rand = new Random();
        String random = this.answers.get(rand.nextInt(this.answers.size()));
        setAnswer(random);
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public List<String> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }


}