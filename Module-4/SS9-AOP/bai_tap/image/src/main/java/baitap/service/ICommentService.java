package baitap.service;

import baitap.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommentService {
    Page<Comment> findAll(Pageable pageable);
    void save(Comment comment);
}
