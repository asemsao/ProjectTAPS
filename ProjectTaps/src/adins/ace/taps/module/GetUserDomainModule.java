package adins.ace.taps.module;

import java.util.Hashtable;

import javax.naming.Context;

public class GetUserDomainModule {
	public GetUserDomainModule() {
	}
	public static Hashtable<String, String> getDomainAuthentication(String username, String password, String domainName){
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, username+"@"+domainName);
		env.put(Context.SECURITY_CREDENTIALS, password);
		env.put(Context.PROVIDER_URL, "ldap://ace-router:389");
		return env;
	}
}
