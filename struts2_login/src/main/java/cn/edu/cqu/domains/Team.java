package cn.edu.cqu.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "team", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Team {

	@Id
	@GeneratedValue
	private Long id;
	/**
	 * name
	 */
	@Column(nullable = false, length = 100)
	private String name;
	/**
	 * region
	 */
	@Column(nullable = true, length = 100)
	private String region;

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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
