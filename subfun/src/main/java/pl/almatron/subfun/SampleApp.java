package pl.almatron.subfun;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * subfun
 *
 * @author macvek
 */
public class SampleApp {

    public static void main(String... args) throws Exception {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext(new String[]{"sampleconfig.xml"});

                
        Sample sample = context.getBean("sampleBean", Sample.class);
        System.out.println(sample.getRef().getValue());
        AnotherSample anotherSample = context.getBean("anotherBean", AnotherSample.class);
        
        System.out.println(anotherSample.getRef().equals(sample.getRef()));
        
        SingletonBean singleton = context.getBean("singletonBean", SingletonBean.class);
        System.out.println(singleton.getSummary());
        System.out.println(singleton.getSummary());

        ChildBean childBean = context.getBean("childBean", ChildBean.class);
        System.out.println("ChildValue:"+childBean.getChildValue()+", "+childBean.getSomeValue());
       
        ChildBean childBeanNoParent = context.getBean("childBeanNoParent", ChildBean.class);
        System.out.println("ChildValue NoParent:"+childBeanNoParent.getChildValue()+", "+childBeanNoParent.getSomeValue());
        
        String someBean = context.getBean("someBean", String.class);
        System.out.println("Bean created by custom factory bean: "+someBean);
        
        FactoryBean<String> someBeanFactory = context.getBean("&someBean", FactoryBean.class);
        System.out.println("Factory bean for someBean:"+someBeanFactory.toString());
        System.out.println("Bean produces by someBean FactoryBean:"+someBeanFactory.getObject());
        
    }
}
