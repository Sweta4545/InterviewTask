package task1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MasterIdType {
	
	@Id
	private String masterId;
	
	private String nameString;
	private int code;
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "MasterIdType [masterId=" + masterId + ", nameString=" + nameString + ", code=" + code + "]";
	}
	
	

}
