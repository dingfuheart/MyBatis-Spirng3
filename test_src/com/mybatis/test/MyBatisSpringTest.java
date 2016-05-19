package com.mybatis.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.domain.User;
import com.mybatis.inter.IUserOperation;


public class MyBatisSpringTest {
	private static ApplicationContext ctx;
	
	static 
    {  
        ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml"); 
    }        

	@Test
	public void test() {
		IUserOperation mapper = (IUserOperation)ctx.getBean("userMapper"); 
        //测试id=1的用户查询，根据数据库中的情况，可以改成你自己的.
        System.out.println("得到用户id=1的用户信息");
        User user = mapper.selectUserByID(1);
        System.out.println(user.getUserAddress()); 
        
        //得到文章列表测试
        System.out.println("得到用户id为1的所有文章列表");
        User user1 = mapper.getUserArticles(1);
        System.out.println(user1.getArList().size());
        
	}

}
