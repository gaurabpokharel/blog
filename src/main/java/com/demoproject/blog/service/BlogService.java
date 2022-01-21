package com.demoproject.blog.service;

import com.demoproject.blog.entity.Blog;
import com.demoproject.blog.repository.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;


    public Blog saveBlog(Blog blog) {
        log.info("Inside saveBlog of BlogService");
       return blogRepository.save(blog);
    }

    public Blog findBlogById(Long blogId) throws Exception {
        log.info("Inside findBlogById of BlogService");

        Blog obj= blogRepository.findByBlogId(blogId);
        if(obj==null)
        {
            throw new Exception("Blog is not found with id"+blogId);
        }
        return obj;
    }

    public void deleteBlogById(Long blogId) throws Exception {
        log.info("Inside deleteBlogById of BlogService");
        Blog obj= blogRepository.findByBlogId(blogId);
        if(obj==null)
        {
            throw new Exception("Blog is not found with id"+blogId);
        }
        blogRepository.deleteById(blogId);
    }

    public Blog updateBlogById(Blog blog, Long blogId) throws Exception {
        log.info("Inside deleteBlogById of BlogService");
        blog.setBlogId(blogId);
        Blog obj= blogRepository.findByBlogId(blogId);
        if(obj==null)
        {
            throw new Exception("Blog is not found with id"+blogId);
        }
        return blogRepository.save(blog);
    }
}
