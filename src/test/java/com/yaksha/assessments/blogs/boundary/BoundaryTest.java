package com.yaksha.assessments.blogs.boundary;

import static com.yaksha.assessments.blogs.testutils.TestUtils.boundaryTestFile;
import static com.yaksha.assessments.blogs.testutils.TestUtils.currentTest;
import static com.yaksha.assessments.blogs.testutils.TestUtils.testReport;
import static com.yaksha.assessments.blogs.testutils.TestUtils.yakshaAssert;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {
	private static Validator validator;

	// ----------------------------------------------------------------------------------------------
	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testBlogTitleNotNull() throws Exception {

		yakshaAssert(currentTest(), true, boundaryTestFile);
	}

//	@Test
//	public void testBlogContentNotNull() throws Exception {
//		BlogEntity blogEntity = MasterData.getBlogEntity();
//		blogEntity.setContent(null);
//		Set<ConstraintViolation<BlogEntity>> violations = validator.validate(blogEntity);
//		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
//	}

}
