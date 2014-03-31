package adins.ace.taps.module;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import adins.ace.taps.configuration.App;
import adins.ace.taps.manager.LoginManager;

public class LoginModule {
	private String username;
	private String password;
	private String domainName;

	public LoginModule() {
	}

	public boolean getAuthenticationUser(String username, String password,
			String domainName,HttpServletRequest request) {
		boolean logged = false;
		this.username = username;
		this.password = password;
		this.domainName = domainName;
		LoginManager lMan = new LoginManager();
		Map params = new HashMap();
		
		params.put("username", this.username);
		params.put("password", this.password);
		
		
		if (isRecoveryMode(request)) {
			logged = lMan.tryLogin(params);
		} else {
			GetUserDomainModule domainAuth = new GetUserDomainModule();
			Hashtable<String, String> env = new Hashtable<String, String>();

			env = domainAuth.getDomainAuthentication(this.username, this.password,
					this.domainName);
			DirContext ctx = null;
			try {
				ctx = new InitialDirContext(env);
				if (!ctx.equals(null)) {
					logged = true;
				}
			} catch (NamingException ex) {
				System.out.println(ex.toString());
			}
			
		}
		if(logged){
			logged = lMan.userIsActive(params);	
		}
		return logged;
	}

	private boolean isRecoveryMode(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if ("true".equals(session.getAttribute("recoveryMode"))) {
			return true;
		} else {
			return false;
		}
	}

}
