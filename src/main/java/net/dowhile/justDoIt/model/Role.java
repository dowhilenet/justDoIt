package net.dowhile.justDoIt.model;

import org.beetl.sql.core.annotatoin.AssignID;

public class Role {

	@AssignID("simple")
	private Long id;
	private String name;
	private String descn;

	public Role() {
	}

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

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}
}
