package com.ourTestProjectSeven.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface BlogEntryTestdata {

	String NAME = "blogEntryTestdata";
	String JNDI_NAME = "java:app/TestProjectSeven-bootstrap/BlogEntryTestdataBean";

	void insert();

}
