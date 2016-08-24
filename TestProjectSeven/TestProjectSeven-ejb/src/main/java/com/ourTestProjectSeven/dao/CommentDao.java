package com.ourTestProjectSeven.dao;

import java.util.List;

import javax.ejb.Local;

import com.ourTestProjectSeven.model.BlogEntry;
import com.ourTestProjectSeven.model.Comment;

@Local
public interface CommentDao extends Dao<Comment> {

	String NAME = "commentDao";
	String JNDI_NAME = "java:app/TestProjectSeven-ejb/CommentDaoBean";

	List<Comment> findComments(BlogEntry blogEntry);

}
