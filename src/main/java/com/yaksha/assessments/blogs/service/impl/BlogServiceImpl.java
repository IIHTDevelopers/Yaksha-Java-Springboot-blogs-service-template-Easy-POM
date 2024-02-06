package com.yaksha.assessments.blogs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaksha.assessments.blogs.entity.BlogEntity;
import com.yaksha.assessments.blogs.repository.BlogRepository;
import com.yaksha.assessments.blogs.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public BlogEntity createBlog(BlogEntity blogEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogEntity getBlogById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogEntity updateBlog(BlogEntity blogEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBlog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
