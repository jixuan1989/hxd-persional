package cn.edu.cqu.domains;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "loginName" }) })
public class User {
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * login name
	 */
	@Column(nullable = false, length = 100)
	private String loginName;
	/**
	 * real name
	 */
	@Column(nullable = false, length = 100)
	private String name;
	/**
	 * password
	 */
	@Column(nullable = false, length = 100)
	private String pwd;
	/**
	 * department
	 */
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)
	@JoinColumn(name="department_id")
	private Department department;
	/**
	 * sex male：m female：f
	 */
	@Column(nullable = false, length = 1)
	private String sex;
	/**
	 * telephone number
	 */
	@Column(nullable = false, length = 20)
	private String tel;
	/**
	 * email
	 */
	@Column(nullable = false, length = 100)
	private String email;
	/**
	 * scholarship type
	 */
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private ScholarshipType scholarshipType;
	/**
	 * time to gain scholarship
	 */
	@Column(nullable = false)
	private Date scholarshipTime;
	/**
	 * position
	 */
	@Column(nullable = false, length = 100)
	private String position;
	/**
	 * cqu number
	 */
	@Column(nullable = false, length = 20)
	private String cquNo;
	/**
	 * current address
	 */
	@Column(nullable = false, length = 200)
	private String currentAddress;
	/**
	 * bank name
	 */
	@Column(nullable = false, length = 100)
	private String bankName;
	/**
	 * bank account
	 */
	@Column(nullable = false, length = 100)
	private String bankAccount;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ScholarshipType getScholarshipType() {
		return scholarshipType;
	}

	public void setScholarshipType(ScholarshipType scholarshipType) {
		this.scholarshipType = scholarshipType;
	}

	public Date getScholarshipTime() {
		return scholarshipTime;
	}

	public void setScholarshipTime(Date scholarshipTime) {
		this.scholarshipTime = scholarshipTime;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCquNo() {
		return cquNo;
	}

	public void setCquNo(String cquNo) {
		this.cquNo = cquNo;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((loginName == null) ? 0 : loginName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		return true;
	}


}
