package com.ourTestProjectSeven.bootstrap.testdata;

import javax.ejb.Local;

@Local
public interface UserTestdata {

	String NAME = "userTestdata";
	String JNDI_NAME = "java:app/TestProjectSeven-bootstrap/UserTestdataBean";

	void insert();
}
