package com.example.demo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

@Table(name = "test")
public class Test extends BaseModel {

	private static final long serialVersionUID = -790616373958187979L;

	@Column(name = "id", type = MySqlTypeConstant.INT, length = 11, isKey = true, isAutoIncrement = true)
	private Integer id;

	@Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 111)
	private String name;

	@Column(name = "age", type = MySqlTypeConstant.INT, length = 3)
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	// @Column(name = "description", type = MySqlTypeConstant.TEXT)
	// private String description;
	//
	// @Column(name = "create_time", type = MySqlTypeConstant.DATETIME)
	// private Date createTime;
	//
	// @Column(name = "update_time", type = MySqlTypeConstant.DATETIME)
	// private Date updateTime;
	//
	// @Column(name = "number", type = MySqlTypeConstant.BIGINT, length = 5)
	// private Long number;
	//
	// @Column(name = "life_cycle", type = MySqlTypeConstant.CHAR, length = 1)
	// private String lifeCycle;
	//
	// @Column(name = "dekes", type = MySqlTypeConstant.DOUBLE, length = 5,
	// decimalLength = 2)
	// private Double dekes;

}
