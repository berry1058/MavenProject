package com.ourTestProjectSeven.weblogic.security;

import javax.ejb.Local;

@Local
public interface AuthenticatorService {
	String NAME = "authenticator";
	String JNDI_NAME = "java:app/TestProjectSeven-ejb/AuthenticatorServiceBean";

	boolean authenticate();
}
