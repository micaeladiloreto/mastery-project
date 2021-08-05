package com.survivingcodingbootcamp.blog;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private TopicStorage topicStorage;
    private PostStorage postStorage;
    private HashtagRepository hashtagRepository;


    public Populator(TopicStorage topicStorage, PostStorage postStorage, HashtagRepository hashtagRepository) {

        this.topicStorage = topicStorage;
        this.postStorage = postStorage;
        this.hashtagRepository = hashtagRepository;
    }

    @Override
    public void run(String...args)throws Exception{
        Hashtag bootCamp = new Hashtag("#bootCamp");
        hashtagRepository.save(bootCamp);
        Hashtag imposterSyndromeIsReal = new Hashtag("#imposterSyndromeIsReal");
        hashtagRepository.save(imposterSyndromeIsReal);
        Hashtag learningJava = new Hashtag("#learningJava");
        hashtagRepository.save(learningJava);
        Hashtag oOP = new Hashtag("#oOP");
        hashtagRepository.save(oOP);
        Hashtag tddIsAnnoying = new Hashtag("#tddIsAnnoying");
        hashtagRepository.save(tddIsAnnoying);
        Hashtag hardWorkPaysOff = new Hashtag("#hardWorkPaysOff");
        hashtagRepository.save(hardWorkPaysOff);



        Topic topic1 = new Topic("Learning TDD");
        topicStorage.save(topic1);
        Post post1 = new Post("TDD For Fun and Profit", topic1,"Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.","Timothy Chalamet",tddIsAnnoying, bootCamp,learningJava);
        postStorage.save(post1);
        Post post2 = new Post("Test the Fear Away", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.","Robert Pattinson",bootCamp,hardWorkPaysOff);
        postStorage.save(post2);
        Post post3 = new Post("Unit Tests and You", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.","Phoebe Bridgers",bootCamp,tddIsAnnoying);
        postStorage.save(post3);


        Topic topic2 = new Topic("Battling Imposter Syndrome");
        topicStorage.save(topic2);
        Post post4 = new Post("How to take back your power",topic2,"Lorem ipsum dolor sit amet, consectetur " +
                                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis" +
                                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id" +
                                "est laborum.","Evan Peters", imposterSyndromeIsReal,bootCamp);
        postStorage.save(post4);

        Topic topic3 = new Topic("Introductory Java");
        topicStorage.save(topic3);
        Post post5 = new Post("Getting to know the basics",topic3,"Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis" +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id" +
                "est laborum.","Johnny Depp",learningJava,bootCamp,hardWorkPaysOff);
        postStorage.save(post5);

        Topic topic4 = new Topic("Object Oriented Programming and You");
        topicStorage.save(topic4);
        Post post6 = new Post("Think of a cat",topic4,"Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis" +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id" +
                "est laborum.","Steven Morrissey",oOP,bootCamp);
        postStorage.save(post6);


    }

}
