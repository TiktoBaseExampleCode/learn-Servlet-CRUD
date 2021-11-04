package tikto.utama.ejb;

import java.io.Serializable;

public class Follower implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String realName;
	private String id;
	
	public void setRealname(String realName) {
		this.realName = realName;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRealname() {
		return realName;
	}
	
	public String getId() {
		return id;
	}
	
}
