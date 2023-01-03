package com.openclassrooms.datalayer.service;

import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.repository.CommentRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepositiory commentRepositiory;

    public Iterable<Comment> getComments(){
        return commentRepositiory.findAll();
    }
}
