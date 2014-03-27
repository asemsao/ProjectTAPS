package adins.ace.taps.form.login;


import org.apache.struts.action.ActionForm;


@SuppressWarnings("serial")
public class LoginForm extends ActionForm{
	private String task;
	private String username;
	private String password;
	private String message;
	private String color;
	private boolean keepMeSign;
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isKeepMeSign() {
		return keepMeSign;
	}
	public void setKeepMeSign(boolean keepMeSign) {
		this.keepMeSign = keepMeSign;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
