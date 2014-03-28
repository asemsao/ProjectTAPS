package adins.ace.taps.module;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import adins.ace.taps.configuration.App;

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
		env.put(Context.PROVIDER_URL, "ldap://"+App.getConfiguration("ad_ip")+":"+App.getConfiguration("ad_port"));
		return env;
	}
	public boolean checkAD(){
		boolean flag = true;
		String username = App.getConfiguration("ad_username");
		String password = App.getConfiguration("ad_password");
		String domainName = App.getConfiguration("domain_name");
		GetUserDomainModule domainAuth = new GetUserDomainModule();
		Hashtable<String, String> env = new Hashtable<String, String>();

		env = domainAuth.getDomainAuthentication(username, password,domainName);
		DirContext ctx = null;
		try {
			ctx = new InitialDirContext(env);
			if (!ctx.equals(null)) {
				flag = true;
			}
		} catch (NamingException ex) {
			System.out.println(ex.getCause());
			if(ex.getCause().toString().contains(App.getConfiguration("ad_ip"))){
				flag = false;
			}
		}
		return flag;
	}
}
