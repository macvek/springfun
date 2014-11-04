package pl.almatron.subfun;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * subfun
 *
 * @author macvek
 */
public class SampleApp {

    public static void main(String... args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext(new String[]{"sampleconfig.xml"});

                
        Sample sample = context.getBean("sampleBean", Sample.class);
        System.out.println(sample.getRef().getValue());
        AnotherSample anotherSample = context.getBean("anotherBean", AnotherSample.class);
        
        System.out.println(anotherSample.getRef().equals(sample.getRef()));
        
        SingletonBean singleton = context.getBean("singletonBean", SingletonBean.class);
        System.out.println(singleton.getSummary());
        System.out.println(singleton.getSummary());
        
       
    }
}
