package baitap.repository;

import baitap.model.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class CommentRepository implements ICommentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query=entityManager.createQuery("SELECT c from Comment as c", Comment.class);
        return query.getResultList();
    }

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }
}
