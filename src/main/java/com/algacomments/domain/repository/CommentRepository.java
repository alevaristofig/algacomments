package com.algacomments.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.algacomments.api.model.CommentCollection;
import com.algacomments.domain.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, String>{

}
