package pl.almatron.subfun;

/**
 * subfun
 * @author macvek
 */
public class SampleBean implements Sample {
    private Ref ref;

    @Override
    public Ref getRef() {
        return ref;
    }

    @Override
    public void setRef(Ref ref) {
        this.ref = ref;
    }
    
}
