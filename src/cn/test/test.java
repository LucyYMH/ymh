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
		//��ȡSqlSession 
		sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		//��ȡmapper�Ĵ������
		mapper = sqlSession.getMapper(UserMapper.class);
	}
	@Test
	public void selectById(){
		//��ȡSqlSession 
		SqlSession sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		//��ȡmapper�Ĵ������
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//���÷���
		User user = mapper.selectById(1);
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void selectByMap(){
		//��ȡSqlSession 
		SqlSession sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		//��ȡmapper�Ĵ������
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Map<String,Object> map=new HashMap<>();
		map.put("sex", "��");
		map.put("address", "����");
		//���÷���
		List<User> list = mapper.selectByMap(map);
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void selectByParams(){
		//��ȡSqlSession 
		SqlSession sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		//��ȡmapper�Ĵ������
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.selectByParams("��", "%����%");
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void addUser(){
		SqlSession sqlSession=MybatisUtils.getSqlSessionFactory().openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user =new User("jerry",new Date(),"��","jining");
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
		user.setSex("Ů");
		List<User> list = mapper.selectUser(user);
		System.err.println(list);
		sqlSession.close();
	}
	@Test
	public void updateUser(){
		User user=new User();
		user.setSex("Ů");
		user.setId(22);
		int list = mapper.updateUser(user);
		sqlSession.commit();
		System.err.println(list);
		sqlSession.close();
	}
	//foreach�Ĳ�������
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
