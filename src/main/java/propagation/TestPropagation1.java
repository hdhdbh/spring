package propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestPropagation1 {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private TestPropagation2 test2;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("propagation.xml");
        TestPropagation1 test1 = ctx.getBean("testPropagation1", TestPropagation1.class);
//        test1.testREQUIRED();
//        test1.testSUPPORTS();
//        test1.testMANDATORY();
//        test1.testREQUIRES_NEW();
//        test1.testREQUIRES_NEW1();
//        test1.testNOT_SUPPORTED();
//        test1.testNEVER();
//        test1.testNESTED();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testREQUIRED() {
        String sql = "insert into propagation(name) values ('REQUIRED1')";
        jdbc.execute(sql);
        test2.testREQUIRED(true);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testSUPPORTS() {
        String sql = "insert into propagation(name) values ('SUPPORTS1')";
        jdbc.execute(sql);
        test2.testSUPPORTS(true);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testMANDATORY() {
        String sql = "insert into propagation(name) values ('MANDATORY1')";
        jdbc.execute(sql);
        test2.testMANDATORY(true);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testREQUIRES_NEW() {
        String sql = "insert into propagation(name) values ('REQUIRES_NEW1')";
        jdbc.execute(sql);
        test2.testREQUIRES_NEW(true);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testREQUIRES_NEW1() {
        String sql = "insert into propagation(name) values ('REQUIRES_NEW1')";
        jdbc.execute(sql);

        test2.testREQUIRES_NEW(false);
        if (true) throw new RuntimeException("REQUIRES_NEW1抛出异常");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testNOT_SUPPORTED() {
        String sql = "insert into propagation(name) values ('NOT_SUPPORTED1')";
        jdbc.execute(sql);
        test2.testREQUIRES_NEW(false);
        if (true) throw new RuntimeException("NOT_SUPPORTED1抛出异常");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testNEVER() {
        String sql = "insert into propagation(name) values ('NEVER1')";
        jdbc.execute(sql);
        test2.testNEVER(false);
        if (true) throw new RuntimeException("NEVER1抛出异常");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testNESTED() {
        String sql = "insert into propagation(name) values ('NESTED1')";
        jdbc.execute(sql);
        try {
            test2.testNESTED(true);
        } catch (Exception e) {

        }
        //if (true) throw  new RuntimeException("NESTED1抛出异常");// 嵌套事务应该随父事务回滚
    }
}
