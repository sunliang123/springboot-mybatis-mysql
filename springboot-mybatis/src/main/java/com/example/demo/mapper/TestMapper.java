package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Test;

@Mapper
public interface TestMapper {

	/**
	 * 添加操作，返回新增元素的 ID
	 *
	 * @param Test
	 */
	@Insert("insert into test(name,age) values(#{name},#{age})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insert(Test Test);

	/**
	 * 更新操作
	 *
	 * @param Test
	 * @return 受影响的行数
	 */
	@Update("update test set name=#{name},age=#{age} where id=#{id}")
	Long update(Test Test);

	/**
	 * 删除操作
	 *
	 * @param id
	 * @return 受影响的行数
	 */
	@Delete("delete from test where id=#{id}")
	Long delete(@Param("id") Long id);

	/**
	 * 查询所有
	 *
	 * @return
	 */
	@Select("select id,name,age from test")
	List<Test> selectAll();

	/**
	 * 根据主键查询单个
	 *
	 * @param id
	 * @return
	 */
	@Select("select id,name,age from test where id=#{id}")
	Test selectById(@Param("id") Long id);

}
