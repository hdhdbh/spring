package springbatis.service;

import springbatis.entity.NewsUser;

public interface UserService {
    NewsUser getUser(String name, String password);

    void addUSer(String name, String password);

    void batchAddUser();//批量插入事务为了测试事务
}
