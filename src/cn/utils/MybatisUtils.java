package cn.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis�Ĺ����� ������ȡSqlSessionFactory
 * @author ymh
 *
 */
public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try {
			//ͨ��io���ķ�ʽ��ȡȫ�������ļ�
			InputStream in  = Resources.getResourceAsStream("mybatis.xml");
			//��ȡSqlsessionFactory
			sqlSessionFactory= new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
}
