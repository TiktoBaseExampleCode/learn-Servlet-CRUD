package tikto.utama.ejb;

import java.io.Serializable;

public class Follower implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String realName;
	private Integer id;
	
	public void setRealname(String realName) {
		this.realName = realName;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRealname() {
		return realName;
	}
	
	public Integer getId() {
		return id;
	}
}
