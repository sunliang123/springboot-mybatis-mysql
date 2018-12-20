package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Test;
import com.example.demo.mapper.TestMapper;

@EnableTransactionManagement // 需要事务的时候加上
@RestController
public class TestController {

	@Autowired
	private TestMapper testMapper;

	@RequestMapping("/save")
	public Integer save() {
		Test test = new Test();
		test.setName("张三");
		test.setAge(18);
		testMapper.insert(test);
		return test.getId();
	}

	@RequestMapping("/update")
	public Long update() {
		Test test = new Test();
		test.setId(2);
		test.setName("旺旺");
		test.setAge(12);
		return testMapper.update(test);
	}

	@RequestMapping("/delete/{id}")
	public Long delete(@PathVariable Long id) {
		return testMapper.delete(id);
	}

	@RequestMapping("/selectById/{id}")
	public Test selectById(@PathVariable Long id) {
		return testMapper.selectById(id);
	}

	@RequestMapping("/selectAll")
	public List<Test> selectAll() {
		return testMapper.selectAll();
	}

	@RequestMapping("/transaction")
	@Transactional // 需要事务的时候加上
	@SuppressWarnings("unused")
	public Boolean transaction() {
		delete(1L);
		int i = 3 / 0;
		save();

		return true;
	}
}
