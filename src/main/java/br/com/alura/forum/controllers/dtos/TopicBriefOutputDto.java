package br.com.alura.forum.controllers.dtos;

import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.topic_domain.Topic;
import br.com.alura.forum.model.topic_domain.TopicStatus;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class TopicBriefOutputDto {


    private final Topic topic;
    private final Course course;
    private static final AtomicLong id = new AtomicLong();
    ;

    public TopicBriefOutputDto(Topic topic) {
        this.topic = topic;
        this.course = topic.getCourse();
    }

    public Long getId() {
        return id.incrementAndGet();
    }

    public String getShortDescription() {
        return topic.getShortDescription();
    }

    public long getSecondsSinceLastUpdate() {
        return topic.getLastUpdate().until(Instant.now(), ChronoUnit.MICROS);
    }

    public String getOwnerName() {
        return topic.getOwnerName();
    }

    public String getCourseName() {
        return course.getName();
    }

    public String getSubcategoryName() {
        return course.getSubcategoryName();
    }

    public String getCategoryName() {
        return course.getCategoryName();
    }

    public int getNumberOfResponse() {
        return topic.getNumberOfAnswers();
    }

    public boolean isSolved() {
        return TopicStatus.SOLVED.equals(topic.getStatus());
    }


    public static List<TopicBriefOutputDto> listFromTopics(List<Topic> topics) {
        return topics.stream().map(TopicBriefOutputDto::new).collect(Collectors.toList());
    }
}
