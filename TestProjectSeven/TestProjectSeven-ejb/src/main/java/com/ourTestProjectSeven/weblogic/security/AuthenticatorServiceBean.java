package com.ourTestProjectSeven.weblogic.security;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.JndiName;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;

import com.ourTestProjectSeven.dao.UserDao;
import com.ourTestProjectSeven.model.User;

@Name(AuthenticatorService.NAME)
@JndiName(AuthenticatorService.JNDI_NAME)
@Stateless
public class AuthenticatorServiceBean implements AuthenticatorService {

	@Logger
	private Log log;

	@In
	private Credentials credentials;

	@EJB
	private UserDao userDao;

	@SuppressWarnings("unused")
	@Out(required = false, scope = ScopeType.SESSION)
	private User currentUser;

	@Override
	public boolean authenticate() {
		log.info("authenticate user #0", credentials.getUsername());
		User user = userDao.findByUsername(credentials.getUsername());

		if (user != null && user.verifyPassword(credentials.getPassword())) {
			currentUser = user;
			return true;
		}

		return false;

	}
}
