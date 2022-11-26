package com.example.blog_update.repository;

import com.example.blog_update.model.Blog;
import com.example.blog_update.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {

    List<Blog> findByBlogNameContains(String blogName);

    @Query("Select b from Blog b where b.blogName like :blogName")
    List<Blog> searchAllByName(String blogName);

    @Query("Select b from Blog b where b.blogName = :blogName")
    Blog findBlogByName(String blogName);

    List<Blog> findBlogsByCategory(Category category);
}
