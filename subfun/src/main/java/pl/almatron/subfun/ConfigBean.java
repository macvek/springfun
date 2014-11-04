package pl.almatron.subfun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

/**
 * subfun
 * @author macvek
 */
@Configuration
@ComponentScan("pl.almatron.subfun.scannable")
@ImportResource("classpath:/sampleconfig.xml")
public class ConfigBean {
    
    @Bean
    @Scope(value = "prototype")
    public ChildBean codeConfigChildBean() {
        return new ChildBean();
    }

}
