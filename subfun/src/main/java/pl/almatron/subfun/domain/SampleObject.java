package pl.almatron.subfun.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * subfun
 *
 * @author macvek
 */
public class SampleObject {
    private Long id;
    private String title;
    private Date date;

    private Set<SampleItem> items = new HashSet<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<SampleItem> getItems() {
        return items;
    }

    public void setItems(Set<SampleItem> items) {
        this.items = items;
    }
    
}
