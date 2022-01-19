package com.demoproject.blog.repository;

import com.demoproject.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long>
{
    Blog findByBlogId(Long blogId);
}