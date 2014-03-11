package adins.ace.taps.module;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;

import adins.ace.taps.bean.module.ActiveDirectoryBean;

public class QueryActiveDirectory {
	public QueryActiveDirectory() {
	}

	public static List<ActiveDirectoryBean> queryAD() {
		// TESTING
		String username = "budi.ss";
		String password = "Terev9977";
		String domainName = "nu-ace.ad-ins.com";

		List<ActiveDirectoryBean> AllADList = new ArrayList<ActiveDirectoryBean>();
		GetUserDomainModule getConnToAD = new GetUserDomainModule();
		Hashtable<String, String> env = getConnToAD.getDomainAuthentication(
				username, password, domainName);
		try {
			DirContext ctx = new InitialLdapContext(env, null);
			NamingEnumeration answer = ctx.list("OU=Trainee Atas,DC=nu-ace,DC=ad-ins,DC=com");
			while (answer.hasMore()){
				NameClassPair sr = (NameClassPair) answer.next();
				String user = sr.getName().replace("CN=", "");
				AllADList.add(getDetail(user, ctx));
			}
			ctx.close();

		} catch (NamingException e) {
			System.err.println("Problem searching directory: " + e);
		}
		return AllADList;
	}

	private static ActiveDirectoryBean getDetail(String username, DirContext ctx) {
		ActiveDirectoryBean ADRecord = new ActiveDirectoryBean();
		try {
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String[] attrIDs = { "sAMAccountName", "cn" };
			constraints.setReturningAttributes(attrIDs);
			NamingEnumeration answer = ctx.search("DC=nu-ace,DC=ad-ins,DC=com",
					"CN=" + username, constraints);
			if (answer.hasMore()) {
				Attributes attrs = ((SearchResult) answer.next())
						.getAttributes();
				ADRecord.setFullName((attrs.get("cn").toString()).toString()
						.replace("cn: ", ""));
				ADRecord.setUserDomain((attrs.get("sAMAccountName").toString())
						.replace("sAMAccountName: ", ""));
			} else {
				throw new Exception("Invalid User");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ADRecord;
	}
}
