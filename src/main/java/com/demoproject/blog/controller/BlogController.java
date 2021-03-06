package com.demoproject.blog.controller;

import com.demoproject.blog.entity.Blog;
import com.demoproject.blog.service.BlogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
@Slf4j
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/save")
    @ApiOperation(value = "this api is used to save blogs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully post the blog content"),
            @ApiResponse(code = 500, message = "Unable to post the blog")
    })
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog)
    {
        log.info("Inside saveBlog method of Blog Controller");
        Blog obj= blogService.saveBlog(blog);
        return new ResponseEntity<>(obj,HttpStatus.OK);
        
    }

    @GetMapping("/findBlogById/{id}")
    @ApiOperation(value = "this api is used to find blog according to id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully find the post by id"),
            @ApiResponse(code = 500, message = "Unable to find the blog")})
    public Blog findBlogById(@PathVariable("id") Long blogId) throws Exception {
        log.info("Inside findBlogById method of Blog Controller");
        return blogService.findBlogById(blogId);
    }

    @PutMapping("/updateBlogById/{id}")
    @ApiOperation(value = "this api is used to update blog according to id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update"),
            @ApiResponse(code = 500, message = "Unable to update the blog")
    })
    public  ResponseEntity<Blog> updateBlogById(@RequestBody Blog blog,@PathVariable("id") Long blogId) throws Exception {
        log.info("Inside updateBlogById method of Blog Controller");
        Blog obj= blogService.updateBlogById(blog,blogId);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/deleteBlogById/{id}")
    @ApiOperation(value = "this api is used to delete blog by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully delete the blog content"),
            @ApiResponse(code = 500, message = "Unable to delete the blog")
    })
    public ResponseEntity<String> deleteBlogById(@PathVariable("id") Long blogId) throws Exception {
        log.info("Inside deleteBlogById method of Blog Controller");
        blogService.deleteBlogById(blogId);
        return new ResponseEntity<>("Blog is deleted successfully",HttpStatus.OK);
    }
}
