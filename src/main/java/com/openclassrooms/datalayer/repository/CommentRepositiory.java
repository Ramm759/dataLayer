package com.openclassrooms.datalayer.repository;

import com.openclassrooms.datalayer.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepositiory extends CrudRepository<Comment, Integer> {
}
