package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    //sql Server: root, pw:12345678
    public void testListUser() {
        List<User> users = userMapper.list();
        users.stream().forEach(user ->{
            System.out.println(user);
        });
    }

}
