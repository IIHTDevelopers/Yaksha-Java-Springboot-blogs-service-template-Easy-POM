package com.yaksha.assessments.blogs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assessments.blogs.entity.BlogEntity;
import com.yaksha.assessments.blogs.service.BlogService;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@PostMapping
	public ResponseEntity<BlogEntity> createBlog(@Valid @RequestBody BlogEntity blogEntity) {

		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<BlogEntity> getBlogById(@PathVariable Long id) {
		return null;
	}

	@PutMapping
	public ResponseEntity<BlogEntity> updateBlog(@RequestBody BlogEntity BlogEntity) {

		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBlogById(@PathVariable Long id) {
		return null;
	}

	@GetMapping("/all")
	public ResponseEntity<List<BlogEntity>> getAllBlogs() {
		return null;
	}
}
