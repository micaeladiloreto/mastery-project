package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {
    private HashtagStorage hashtagStorage;
    private PostStorage postStorage;

    public HashtagController(HashtagStorage hashtagStorage, PostStorage postStorage) {
        this.hashtagStorage = hashtagStorage;
        this.postStorage = postStorage;
    }

    @GetMapping("/{id}")
    public String displaySingleHashtag(@PathVariable long id, Model model) {
        model.addAttribute("hashtag", hashtagStorage.retrieveHashtagById(id));
        return "single-hashtag-template";
    }

    @GetMapping("")
    public String displayAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagStorage.retrieveAllHashtags());
        return "all-hashtags-template";
    }

    @PostMapping("/hashtag/post/{id}")
    public String displayPostsInHashtag(Model model, @PathVariable long id) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        model.addAttribute("allHashtags", hashtagStorage.retrieveAllHashtags());
        model.addAttribute("postInHash", postStorage.retrieveAllPosts());
        return "single-hashtag-template";
    }

    @PostMapping("/addHashtag")
    public String addHashtag(@RequestParam String newHashtag, @RequestParam Long postId) {

        Hashtag addedHashtag;
        if(newHashtag.length()>0){
            Hashtag existingHashtag = hashtagStorage.findHashtagByName(newHashtag);
            if(existingHashtag == null){
                addedHashtag = new Hashtag(newHashtag);
                hashtagStorage.save(addedHashtag);
            }else{
                addedHashtag = existingHashtag;
            }
            Post post = postStorage.retrievePostById(postId);
            if(!post.hasHashtag(addedHashtag)){
                post.addHashtag(addedHashtag);
                postStorage.save(post);
            }
            addedHashtag.addPost(post);
            hashtagStorage.save(addedHashtag);
        }
        return "redirect:/posts/" + postId;

    }
}