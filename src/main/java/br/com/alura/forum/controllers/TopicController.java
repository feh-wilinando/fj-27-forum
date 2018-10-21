package br.com.alura.forum.controllers;

import br.com.alura.forum.controllers.dtos.TopicBriefOutputDto;
import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic_domain.Topic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @GetMapping("/api/topics")
    public List<TopicBriefOutputDto> allTopics(){
        Category subCategory = new Category("Java", new Category("Programming"));
        Course course = new Course("Java & JSF", subCategory);
        User someone = new User("Someone", "someone@gmail.com", "1234");
        Topic topic = new Topic("Problem with JSF", "JSF is weird", someone, course);

        List<Topic> topics = Arrays.asList(topic, topic, topic);

        return TopicBriefOutputDto.listFromTopics(topics);
    }
}
