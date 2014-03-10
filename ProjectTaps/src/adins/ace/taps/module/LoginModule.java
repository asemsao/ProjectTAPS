package adins.ace.taps.module;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LoginModule {
	private String username;
	private String password;
	private String domainName;

	public LoginModule() {
	}

	public boolean getAuthenticationUser(String username, String password,
			String domainName) {
		boolean pass = false;
		this.username = username;
		this.password = password;
		this.domainName = domainName;

		GetUserDomainModule domainAuth = new GetUserDomainModule();
		Hashtable<String, String> env = new Hashtable<String, String>();

		env = domainAuth.getDomainAuthentication(this.username, this.password,
				this.domainName);
		DirContext ctx = null;
		try {
			ctx = new InitialDirContext(env);
			if (!ctx.equals(null)) {
				pass = true;
			}
		} catch (NamingException ex) {
			System.out.println(ex.toString());
		}
		return pass;
	}
}
