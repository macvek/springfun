package pl.almatron.subfun;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * subfun
 * @author macvek
 */
public class SomeBeanPostProcessor implements BeanPostProcessor, Ordered{

    @Override
    public Object postProcessBeforeInitialization(Object o, String string) throws BeansException {
        System.out.println("CustomBeanPostProcessor before: "+o.toString()+", "+string);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String string) throws BeansException {
        System.out.println("CustomBeanPostProcessor after: "+o.toString()+", "+string);
        return o;
    }

    @Override
    public int getOrder() {
        return 100000;
    }

}
