package cn.mapper;

import java.util.List;
import java.util.Map;

import cn.pojo.Car;
import cn.pojo.User;
import cn.pojo.UserVo;

public interface UserMapper {
	//根据id查询用户
	public User selectById(int id);
	//添加用户
	public int  addUser(User user);
	//通过map传递参数  查询用户列表
	public List<User> selectByMap(Map<String,Object> map);
	//传递多个参数 查询用户列表
	//public List<User> selectByParams(@Param("sex")String sex,@Param("addr")String address);
	public List<User> selectByParams(String sex,String address) ;
	//查询所有的汽车
	public List<Car> selectCars();
	//查询所有用户和用户拥有的汽车的信息
	public List<UserVo> selectUserAndCar();
	//条件查询
	public List<User> selectUser(User user);
	//修改用户的信息
	public int updateUser(User user);
	//根据ids来查询用户列表
	public List<User> selectByIds(List<Integer> ids);
}
