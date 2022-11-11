package baitap.repository;

import baitap.model.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findAll();
    void save(Comment comment);
}
