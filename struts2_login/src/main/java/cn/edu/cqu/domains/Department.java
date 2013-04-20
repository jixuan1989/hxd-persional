package cn.edu.cqu.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "department", uniqueConstraints = { @UniqueConstraint(columnNames = { "name","team_id" }) })
public class Department {
	
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * department name 
	 */
	@Column(nullable = false, length = 100)
	private String name;
	/**
	 * team 
	 */
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)
	@JoinColumn(name="team_id")
	private Team team;
	/**
	 * authority
	 */
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)
	@JoinColumn(name="authority_id")
	private Authority authority;
	/**
	 * members 
	 */
	@OneToMany(mappedBy="department")
	private List<User> members;
	
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
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}
