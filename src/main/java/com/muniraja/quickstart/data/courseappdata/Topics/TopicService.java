package com.muniraja.quickstart.data.courseappdata.Topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    //Arrays.asList is immutable, to me it as mutable create a new arrayList
   /* private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Java","Java11","java-Desc"),
                new Topic("Spring","SpringBoot","Spring-Desc"),
                new Topic("Maven","Maven","Maven-Desc")
        ));*/

    public List<Topic> getAllTopics(){
        //return topics;
        List<Topic> topicList = new ArrayList<>();
        topicRepository.findAll().forEach(topicList::add);
        System.out.println("HEllo");
        System.out.println("---------------------------------");
        return topicList;
    }

    public Optional<Topic> getTopic(String id) {
        //return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {

        /*for(int i = 0; i < topics.size() ;i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }*/
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //topics.removeIf(topic -> topic.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
