package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;

public interface HashtagStorage {
    Iterable<Hashtag> retrieveAllHashtags();

    Hashtag retrieveHashtagById(long id);

    void save(Hashtag hashtagToAdd);

    Hashtag findHashtagByName(String name);
}