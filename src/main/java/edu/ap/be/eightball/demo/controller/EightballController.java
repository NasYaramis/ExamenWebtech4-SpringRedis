package edu.ap.be.eightball.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ap.be.eightball.demo.model.Eightball;

import edu.ap.be.eightball.demo.redis.RedisService;

@Controller
public class EightballController {
    @Autowired
    private RedisService service;

    @GetMapping("/")
    public String index() {
        return "redirect:eightball";
    }

    @GetMapping("/eightball")
    public String eightball(Model model) {
        model.addAttribute("question", "");
        model.addAttribute("answer", "");
        return "eightball";
    }

    @PostMapping("/eightball")
    public String getAnswer(@RequestParam("question") String question, @ModelAttribute Eightball eightball,
            Model model) {
        if (service.exists(question)) {
            String answer;
            model.addAttribute("question", question);
            answer = service.getKey(question);
            model.addAttribute("answer", answer);

            return "eightball";
        } else {
            String answer = eightball.getAnswer();

            List<String> answers;
            answers = eightball.getAnswers();
            answers.remove(answer);
            eightball.setAnswers(answers);

            model.addAttribute("question", question);
            model.addAttribute("answer", answer);

            service.setKey(question, answer);

            return "eightball";
        }
    }
}