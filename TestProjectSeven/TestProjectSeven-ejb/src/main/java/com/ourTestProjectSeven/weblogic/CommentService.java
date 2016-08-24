package com.ourTestProjectSeven.weblogic;

import javax.ejb.Local;

import com.ourTestProjectSeven.model.Comment;

@Local
public interface CommentService {

	String NAME = "commentService";
	String JNDI_NAME = "java:app/TestProjectSeven-ejb/CommentServiceBean";

	Comment getInstance();

	void save();

	void remove();

}
