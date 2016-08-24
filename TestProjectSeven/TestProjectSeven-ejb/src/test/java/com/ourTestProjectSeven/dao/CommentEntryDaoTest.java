package com.ourTestProjectSeven.dao;

import java.util.List;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.jboss.seam.annotations.In;
import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;
import de.akquinet.jbosscc.needle.junit.DatabaseRule;
import de.akquinet.jbosscc.needle.junit.NeedleRule;
import com.ourTestProjectSeven.model.BlogEntry;
import com.ourTestProjectSeven.model.Comment;
import com.ourTestProjectSeven.testdata.BlogEntryTestdataBuilder;
import com.ourTestProjectSeven.testdata.CommentTestdataBuilder;

public class CommentEntryDaoTest {

	@Rule
	public DatabaseRule databaseRule = new DatabaseRule();

	@Rule
	public NeedleRule needleRule = new NeedleRule(databaseRule);

	@In
	private EntityManager entityManager;

	@ObjectUnderTest(implementation = CommentDaoBean.class)
	private CommentDao commentDao;

	@Test
	public void testFind() throws Exception {
		BlogEntry blogEntry1 = new BlogEntryTestdataBuilder(entityManager).buildAndSave();
		Comment comment = new CommentTestdataBuilder(entityManager).withBlogEntry(blogEntry1).buildAndSave();

		List<Comment> comments = commentDao.findComments(blogEntry1);
		Assert.assertEquals(1, comments.size());
		Assert.assertEquals(comment.getId(), comments.get(0).getId());

		BlogEntry blogEntry2 = new BlogEntryTestdataBuilder(entityManager).buildAndSave();
		comments = commentDao.findComments(blogEntry2);

		Assert.assertEquals(0, comments.size());

	}


}
