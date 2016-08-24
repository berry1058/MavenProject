package com.ourTestProjectSeven.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface CommentTestdata {

	String NAME = "commentTestdata";
	String JNDI_NAME = "java:app/TestProjectSeven-bootstrap/CommentTestdataBean";

	void insert();

}
