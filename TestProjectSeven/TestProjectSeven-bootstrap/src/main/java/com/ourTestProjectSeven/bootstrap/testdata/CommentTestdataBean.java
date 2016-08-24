package com.ourTestProjectSeven.bootstrap.testdata;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.seam.annotations.JndiName;
import org.jboss.seam.annotations.Name;

import com.ourTestProjectSeven.dao.BlogEntryDao;
import com.ourTestProjectSeven.dao.CommentDao;
import com.ourTestProjectSeven.model.BlogEntry;
import com.ourTestProjectSeven.model.Comment;

@Stateless
@Name(CommentTestdata.NAME)
@JndiName(CommentTestdata.JNDI_NAME)
public class CommentTestdataBean implements CommentTestdata {

	private static final String CONTENT = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.";

	private static final int QUANTITY = 2;

	@EJB
	private BlogEntryDao blogEntryDao;

	@EJB
	private CommentDao commentDao;

	@Override
	public void insert() {
		List<BlogEntry> blogEntries = blogEntryDao.findAll();

		for (BlogEntry blogEntry : blogEntries) {
			for (int i = 0; i < QUANTITY; i++) {
				Comment comment = new Comment();
				comment.setAuthor(blogEntry.getAuthor());
				comment.setBlogEntry(blogEntry);
				comment.setContent(CONTENT);

				commentDao.persist(comment);
			}
		}
	}

}
