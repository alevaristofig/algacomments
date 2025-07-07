package com.algacomments.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.algacomments.domain.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, String>{

}
