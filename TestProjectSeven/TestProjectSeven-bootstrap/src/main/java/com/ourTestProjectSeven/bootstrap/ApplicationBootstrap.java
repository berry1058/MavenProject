package com.ourTestProjectSeven.bootstrap;

import javax.ejb.Local;

@Local
public interface ApplicationBootstrap {
  String NAME = "applicationBootstrap";
  String JNDI_NAME = "java:app/TestProjectSeven-bootstrap/ApplicationBootstrapBean";

  void init();
}