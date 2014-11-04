package pl.almatron.subfun;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * subfun
 * @author macvek
 */
public class RefBean implements Ref {
    private String value = "Value";

    @PostConstruct
    public void onPostConstruct() {
        System.out.println("refBean post construct "+toString());
    }
    
    @PreDestroy
    public void onPreDestroy() {
        System.out.println("refBean pre destroy "+toString());
    }
    
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
    
}
