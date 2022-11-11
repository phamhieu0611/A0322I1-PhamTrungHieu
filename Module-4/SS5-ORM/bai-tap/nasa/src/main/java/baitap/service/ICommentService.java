package baitap.service;

import baitap.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    void save(Comment comment);
}
