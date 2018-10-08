package cn.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import cn.mapper.UserMapper;
import cn.pojo.Car;
import cn.pojo.User;
import cn.pojo.UserVo;
import cn.utils.MybatisUtils;

public class test {
	private SqlSession sqlSession;
	private UserMapper mapper;
	@Before
	public void init(){
		//获取SqlSession 
		sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		//获取mapper的代理对象
		mapper = sqlSession.getMapper(UserMapper.class);
	}
	@Test
	public void selectById(){
		//获取SqlSession 
		SqlSession sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		//获取mapper的代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//调用方法
		User user = mapper.selectById(1);
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void selectByMap(){
		//获取SqlSession 
		SqlSession sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		//获取mapper的代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Map<String,Object> map=new HashMap<>();
		map.put("sex", "男");
		map.put("address", "济宁");
		//调用方法
		List<User> list = mapper.selectByMap(map);
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void selectByParams(){
		//获取SqlSession 
		SqlSession sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		//获取mapper的代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.selectByParams("男", "%济宁%");
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void addUser(){
		SqlSession sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user =new User("jerry",new Date(),"男","jining");
		int addUser = mapper.addUser(user);
		sqlSession.commit();
		System.out.println(addUser);
		sqlSession.close();
	}
	@Test
	public void getCars(){
		SqlSession sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<Car> cars = mapper.selectCars();
		System.out.println(cars);
		sqlSession.close();
	}
	@Test
	public void getUserCars(){
		SqlSession sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<UserVo> list = mapper.selectUserAndCar();
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void ifSelectUser(){
		User user=new User();
		user.setSex("女");
		List<User> list = mapper.selectUser(user);
		System.err.println(list);
		sqlSession.close();
	}
	@Test
	public void updateUser(){
		User user=new User();
		user.setSex("女");
		user.setId(22);
		int list = mapper.updateUser(user);
		sqlSession.commit();
		System.err.println(list);
		sqlSession.close();
	}
	//foreach的测试用例
	@Test
	public void selectByIds(){
		List<Integer> ids=new ArrayList<>();
		ids.add(1);
		ids.add(3);
		ids.add(6);
		List<User> list = mapper.selectByIds(ids);
		System.out.println(list);
		sqlSession.close();
	}
}
