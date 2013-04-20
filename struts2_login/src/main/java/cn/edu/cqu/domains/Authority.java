package cn.edu.cqu.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "authority", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Authority {
	
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * authority name 
	 */
	@Column(nullable = false, length = 100)
	private String name;
	
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

}
