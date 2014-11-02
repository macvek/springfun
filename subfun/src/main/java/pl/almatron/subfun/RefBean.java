package pl.almatron.subfun;

/**
 * subfun
 * @author macvek
 */
public class RefBean implements Ref {
    private String value = "Value";

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
    
}
