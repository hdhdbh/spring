package springbatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import springbatis.entity.NewsUser;

@Repository("UserDao")
public interface UserDao {
    NewsUser getUser(@Param("name") String name, @Param("password") String password);

    void insertUser(NewsUser user);
}
