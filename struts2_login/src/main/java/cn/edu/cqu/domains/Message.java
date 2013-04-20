package cn.edu.cqu.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * leave message
 * @author hxd
 *
 */
@Entity
@Table(name = "message")

public class Message {
	
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * name 
	 */
	@Column(nullable = true, length = 100)
	private String name="匿名";
	/**
	 * content
	 */
	@Column(nullable = false, length = 5000)
	private String content;
	/**
	 * time
	 */
	@Column(nullable = false)
	private Date modifyDate;
	/**
	 * email
	 */
	@Column(nullable = false, length = 100)
	private String email;
	/**
	 * tel
	 */
	@Column(nullable = true, length = 20)
	private String tel;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
