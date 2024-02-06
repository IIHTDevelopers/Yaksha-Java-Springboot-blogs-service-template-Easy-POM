package com.yaksha.assessments.blogs.functional;

import static com.yaksha.assessments.blogs.testutils.TestUtils.businessTestFile;
import static com.yaksha.assessments.blogs.testutils.TestUtils.currentTest;
import static com.yaksha.assessments.blogs.testutils.TestUtils.testReport;
import static com.yaksha.assessments.blogs.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.yaksha.assessments.blogs.controller.BlogController;
import com.yaksha.assessments.blogs.entity.BlogEntity;
import com.yaksha.assessments.blogs.service.BlogService;
import com.yaksha.assessments.blogs.testutils.MasterData;

@WebMvcTest(BlogController.class)
@AutoConfigureMockMvc
public class BlogControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BlogService blogService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCreateBlog() throws Exception {
		BlogEntity BlogEntity = MasterData.getBlogEntity();
		BlogEntity savedBlogEntity = MasterData.getBlogEntity();

		savedBlogEntity.setId(1L);

		when(this.blogService.createBlog(BlogEntity)).thenReturn(savedBlogEntity);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/blogs")
				.content(MasterData.asJsonString(BlogEntity)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedBlogEntity))
						? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testCreateBlogIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		BlogEntity BlogEntity = MasterData.getBlogEntity();
		BlogEntity savedBlogEntity = MasterData.getBlogEntity();

		savedBlogEntity.setId(1L);
		when(this.blogService.createBlog(BlogEntity)).then(new Answer<BlogEntity>() {

			@Override
			public BlogEntity answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedBlogEntity;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/blogs")
				.content(MasterData.asJsonString(BlogEntity)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testGetBlogById() throws Exception {
		BlogEntity BlogEntity = MasterData.getBlogEntity();
		BlogEntity.setId(1L);
		when(this.blogService.getBlogById(1L)).thenReturn(BlogEntity);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/blogs/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(BlogEntity)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetBlogByIdIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		BlogEntity BlogEntity = MasterData.getBlogEntity();
		when(this.blogService.getBlogById(1L)).then(new Answer<BlogEntity>() {

			@Override
			public BlogEntity answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return BlogEntity;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/blogs/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testUpdateBlog() throws Exception {
		BlogEntity BlogEntity = MasterData.getBlogEntity();
		BlogEntity savedBlogEntity = MasterData.getBlogEntity();

		savedBlogEntity.setId(1L);

		when(this.blogService.updateBlog(BlogEntity)).thenReturn(savedBlogEntity);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/blogs")
				.content(MasterData.asJsonString(BlogEntity)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedBlogEntity))
						? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testUpdateBlogIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		BlogEntity BlogEntity = MasterData.getBlogEntity();
		BlogEntity savedBlogEntity = MasterData.getBlogEntity();

		savedBlogEntity.setId(1L);
		when(this.blogService.updateBlog(BlogEntity)).then(new Answer<BlogEntity>() {

			@Override
			public BlogEntity answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedBlogEntity;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/blogs")
				.content(MasterData.asJsonString(BlogEntity)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testDeleteBlog() throws Exception {
		BlogEntity BlogEntity = MasterData.getBlogEntity();
		BlogEntity.setId(1L);
		when(this.blogService.deleteBlog(1L)).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/blogs/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(true)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testDeleteBlogIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		com.yaksha.assessments.blogs.entity.BlogEntity BlogEntity = MasterData.getBlogEntity();
		BlogEntity.setId(1L);
		when(this.blogService.deleteBlog(1L)).then(new Answer<Boolean>() {

			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return true;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/blogs/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testGetAllBlogs() throws Exception {
		List<BlogEntity> blogs = MasterData.getBlogEntityList();

		when(this.blogService.findAll()).thenReturn(blogs);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/blogs/all")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(blogs)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetAllProductsIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<BlogEntity> blogs = MasterData.getBlogEntityList();
		when(this.blogService.findAll()).then(new Answer<List<BlogEntity>>() {

			@Override
			public List<BlogEntity> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return blogs;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/blogs/all")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

}
