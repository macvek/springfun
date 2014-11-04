package pl.almatron.subfun;

import org.springframework.beans.factory.FactoryBean;

/**
 * subfun
 * @author macvek
 */
public class CustomFactoryBean implements FactoryBean{

    private String val = "SomeBean";
    
    @Override
    public Object getObject() throws Exception {
        return val;
    }

    @Override
    public Class getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
