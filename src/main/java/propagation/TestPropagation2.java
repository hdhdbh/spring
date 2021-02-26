package propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestPropagation2 {
    @Autowired
    private JdbcTemplate jdbc;

    @Transactional(propagation = Propagation.REQUIRED)
    public void testREQUIRED(Boolean flag) {
        String sql = "insert into propagation(name) values ('REQUIRED2')";
        jdbc.execute(sql);
        if (flag == true) throw new RuntimeException("REQUIRED2抛出异常");
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void testSUPPORTS(Boolean flag) {
        String sql = "insert into propagation(name) values ('SUPPORTS2')";
        jdbc.execute(sql);
        if (flag == true) throw new RuntimeException("SUPPORTS2抛出异常");
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void testMANDATORY(Boolean flag) {
        String sql = "insert into propagation(name) values ('MANDATORY2')";
        jdbc.execute(sql);
        if (flag == true) throw new RuntimeException("MANDATORY2抛出异常");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testREQUIRES_NEW(Boolean flag) {
        String sql = "insert into propagation(name) values ('REQUIRES_NEW2')";
        jdbc.execute(sql);
        if (flag == true) throw new RuntimeException("REQUIRES_NEW2抛出异常");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testNOT_SUPPORTED(Boolean flag) {
        String sql = "insert into propagation(name) values ('NOT_SUPPORTED2')";
        jdbc.execute(sql);
        if (flag == true) throw new RuntimeException("NOT_SUPPORTED2抛出异常");
    }

    @Transactional(propagation = Propagation.NEVER)
    public void testNEVER(Boolean flag) {
        String sql = "insert into propagation(name) values ('NEVER2')";
        jdbc.execute(sql);
        if (flag == true) throw new RuntimeException("NEVER2抛出异常");
    }

    @Transactional(propagation = Propagation.NESTED)
    public void testNESTED(Boolean flag) {
        String sql = "insert into propagation(name) values ('NESTED2')";
        jdbc.execute(sql);
        if (flag == true) throw new RuntimeException("NESTED2抛出异常");
    }
}
