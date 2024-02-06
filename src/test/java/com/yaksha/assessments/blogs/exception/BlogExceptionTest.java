package com.yaksha.assessments.blogs.exception;

import static com.yaksha.assessments.blogs.testutils.TestUtils.currentTest;
import static com.yaksha.assessments.blogs.testutils.TestUtils.exceptionTestFile;
import static com.yaksha.assessments.blogs.testutils.TestUtils.testReport;
import static com.yaksha.assessments.blogs.testutils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assessments.blogs.controller.BlogController;
import com.yaksha.assessments.blogs.service.BlogService;

@WebMvcTest(BlogController.class)
@AutoConfigureMockMvc
public class BlogExceptionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BlogService blogService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCreateBlogInvalidDataException() throws Exception {
		yakshaAssert(currentTest(), true, exceptionTestFile);

	}

}
