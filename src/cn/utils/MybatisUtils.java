package cn.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis的工具类 单例获取SqlSessionFactory
 * @author ymh
 *
 */
public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try {
			//通过io流的方式读取全局配置文件
			InputStream in  = Resources.getResourceAsStream("mybatis.xml");
			//获取SqlsessionFactory
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
