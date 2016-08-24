package com.ourTestProjectSeven.dao;

import java.util.List;

import javax.ejb.Local;

import com.ourTestProjectSeven.model.BlogEntry;

@Local
public interface BlogEntryDao extends Dao<BlogEntry> {

	String NAME = "blogEntryDao";
	String JNDI_NAME = "java:app/TestProjectSeven-ejb/BlogEntryDaoBean";

	List<BlogEntry> find(int maxresults, int firstresult);

	Long count();

}
