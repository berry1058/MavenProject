package com.ourTestProjectSeven.weblogic;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.junit.NeedleRule;
import de.akquinet.jbosscc.needle.mock.EasyMockProvider;
import com.ourTestProjectSeven.dao.BlogEntryDao;
import com.ourTestProjectSeven.model.BlogEntry;
import com.ourTestProjectSeven.testdata.BlogEntryTestdataBuilder;
import com.ourTestProjectSeven.weblogic.BlogEntryListService;
import com.ourTestProjectSeven.weblogic.BlogEntryListServiceBean;

public class BlogEntryListServiceTest {

	@Rule
	public NeedleRule needleRule = new NeedleRule();

	@ObjectUnderTest(implementation = BlogEntryListServiceBean.class)
	private BlogEntryListService blogEntryListService;

	private EasyMockProvider mockProvider = needleRule.getMockProvider();

	@EJB
	private BlogEntryDao blogEntryDaoMock;

	@Test
	public void testGetResultList() throws Exception {
		EasyMock.expect(blogEntryDaoMock.find(5, 0)).andReturn(
				Arrays.asList(new BlogEntryTestdataBuilder().build()));

		mockProvider.replayAll();
		List<BlogEntry> resultList = blogEntryListService.getResultList();
		Assert.assertEquals(1, resultList.size());
		mockProvider.verifyAll();
	}

	@Test
	public void testPagination() throws Exception {
		EasyMock.expect(blogEntryDaoMock.count()).andReturn(9L).anyTimes();

		mockProvider.replayAll();

		Assert.assertEquals(Integer.valueOf(0),
				blogEntryListService.getFirstResult());

		Assert.assertEquals(5, blogEntryListService.getNextFirstResult());

		Assert.assertEquals(0, blogEntryListService.getPreviousFirstResult());

		Assert.assertEquals(true, blogEntryListService.isNextExists());
		Assert.assertEquals(false, blogEntryListService.isPreviousExists());

		blogEntryListService.setFirstResult(blogEntryListService.getNextFirstResult());

		Assert.assertEquals(Integer.valueOf(5),
				blogEntryListService.getFirstResult());

		Assert.assertEquals(10, blogEntryListService.getNextFirstResult());

		Assert.assertEquals(0, blogEntryListService.getPreviousFirstResult());

		Assert.assertEquals(false, blogEntryListService.isNextExists());
		Assert.assertEquals(true, blogEntryListService.isPreviousExists());

		mockProvider.verifyAll();
	}

	@Test
	public void testPreviousFirstResult() {
		blogEntryListService.setFirstResult(10);

		Assert.assertEquals(15, blogEntryListService.getNextFirstResult());

		Assert.assertEquals(5, blogEntryListService.getPreviousFirstResult());
	}

}
