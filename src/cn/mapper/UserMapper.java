package cn.mapper;

import java.util.List;
import java.util.Map;

import cn.pojo.Car;
import cn.pojo.User;
import cn.pojo.UserVo;

public interface UserMapper {
	//����id��ѯ�û�
	public User selectById(int id);
	//����û�
	public int  addUser(User user);
	//ͨ��map���ݲ���  ��ѯ�û��б�
	public List<User> selectByMap(Map<String,Object> map);
	//���ݶ������ ��ѯ�û��б�
	//public List<User> selectByParams(@Param("sex")String sex,@Param("addr")String address);
	public List<User> selectByParams(String sex,String address) ;
	//��ѯ���е�����
	public List<Car> selectCars();
	//��ѯ�����û����û�ӵ�е���������Ϣ
	public List<UserVo> selectUserAndCar();
	//������ѯ
	public List<User> selectUser(User user);
	//�޸��û�����Ϣ
	public int updateUser(User user);
	//����ids����ѯ�û��б�
	public List<User> selectByIds(List<Integer> ids);
}
