import com.cosplay.beans.StaticDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        HelloWorld helloWorld = ctx.getBean("HelloWorld",HelloWorld.class);
//        System.out.println(helloWorld.getName());

//        Car car = ctx.getBean("car2",Car.class);
//        System.out.println(car);

//        Person person = ctx.getBean("person2",Person.class);
//        System.out.println(person);

//        Person person = ctx.getBean("person3",Person.class);
        //   Person person = ctx.getBean("person5",Person.class);
        //System.out.println(person);

        // ScopeBean scopeBean = ctx.getBean("scopeBean1",ScopeBean.class);
        //ScopeBean scopeBean1 = ctx.getBean("scopeBean1",ScopeBean.class);
//        ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Other other = ctx1.getBean("other",Other.class);
//        ctx1.close();

//        Controller controller = ctx.getBean("controller",Controller.class);
//        controller.controller();

        //  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
//        Service service = ctx.getBean("service",Service.class);
//        service.service();
//        Controller controller = ctx.getBean("controller",Controller.class);
//        controller.web();

        //     Controller1 controller1 = ctx.getBean("controller1",Controller1.class);
        //      Controller1 controller = ctx.getBean("controller1",Controller1.class);
        //   controller1.web();

//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
//        Other other = ctx.getBean("other",Other.class);
//        ctx.close();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        StaticDemo staticDemo = ctx.getBean("staticDemo", StaticDemo.class);
        staticDemo.test();

    }
}
