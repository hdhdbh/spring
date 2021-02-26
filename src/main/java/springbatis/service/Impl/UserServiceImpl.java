package springbatis.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springbatis.dao.UserDao;
import springbatis.entity.NewsUser;
import springbatis.service.UserService;

import javax.annotation.Resource;

@Service("UserService")
//@Transactional//开启事务
public class UserServiceImpl implements UserService {
    @Resource(name = "UserDao")
    private UserDao dao;

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public NewsUser getUser(String name, String password) {
        return dao.getUser(name, password);
    }

    @Override
    public void addUSer(String name, String password) {
        NewsUser user = new NewsUser(name, password);
        dao.insertUser(user);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class}, readOnly = false, propagation = Propagation.REQUIRED)
//    @Transactional(rollbackFor = {Exception.class} noRollbackFor ={RunTimeException})
//    readOnly = false 默认时为false 读写型事务
    //事务传播级别 propagation = Propagation.REQUIRED
    public void batchAddUser() {
        NewsUser user1 = new NewsUser("1", "1");
        NewsUser user2 = new NewsUser("2", "2");
        dao.insertUser(user1);
        dao.insertUser(user2);
        if (user1.getName().equals("1")) throw new RuntimeException("测试事务");
    }
}
