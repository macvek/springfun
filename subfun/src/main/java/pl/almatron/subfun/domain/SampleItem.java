package pl.almatron.subfun.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * subfun
 * @author macvek
 */
public class SampleItem {
    private String name;
    private Long id;
    
    private List<SampleObject> objects = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SampleObject> getObjects() {
        return objects;
    }

    public void setObjects(List<SampleObject> objects) {
        this.objects = objects;
    }
    
    
}
