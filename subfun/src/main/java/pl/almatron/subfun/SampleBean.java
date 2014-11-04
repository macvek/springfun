package pl.almatron.subfun;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * subfun
 * @author macvek
 */
public class SampleBean implements Sample, InitializingBean, DisposableBean {
    private Ref ref;

    @Override
    public Ref getRef() {
        return ref;
    }

    @Override
    public void setRef(Ref ref) {
        this.ref = ref;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Sample Bean initializing, callback by InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Sample Bean destroying, callback by DisposableBean");
    }
    
}
