package pl.almatron.subfun;

import java.util.Date;
import org.joda.time.DateTime;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import pl.almatron.subfun.scannable.FoundService;

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
        childBean.setDate(DateTime.now());
        System.out.println("File : " + childBean.getFile().toPath().toString());
        System.out.println("ChildValue:" + childBean.getChildValue() + ", " + childBean.getSomeValue());

        ChildBean childBeanNoParent = context.getBean("childBeanNoParent", ChildBean.class);
        System.out.println("ChildValue NoParent:" + childBeanNoParent.getChildValue() + ", " + childBeanNoParent.getSomeValue());

        String someBean = context.getBean("someBean", String.class);
        System.out.println("Bean created by custom factory bean: " + someBean);

        FactoryBean<String> someBeanFactory = context.getBean("&someBean", FactoryBean.class);
        System.out.println("Factory bean for someBean:" + someBeanFactory.toString());
        System.out.println("Bean produces by someBean FactoryBean:" + someBeanFactory.getObject());

        ChildBean codeOriended = context.getBean("codeConfigChildBean", ChildBean.class);
        System.out.println("Code oriented configuration: " + codeOriended);

        ApplicationContext codeBaseContext = new AnnotationConfigApplicationContext(ConfigBean.class);
        final Sample bean = codeBaseContext.getBean("sampleBean", Sample.class);
        System.out.println("Code based config is using xml defined bean definition: " + bean);

        FoundService service = codeBaseContext.getBean(FoundService.class);
        service.foundServiceAction();

        new SpringEL().checkItOut(childBean);
        
    }
}
