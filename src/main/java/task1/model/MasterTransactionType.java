package task1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MasterTransactionType {
	
	@Id
	private int transactionId;
	
	private String name;
	private int code;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "MasterTransactionType [transactionId=" + transactionId + ", name=" + name + ", code=" + code + "]";
	}
	
	

}
