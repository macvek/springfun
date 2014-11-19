package pl.almatron.subfun.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * subfun
 *
 * @author macvek
 */
@Entity
@Table(name="sampleObjects")
public class SampleObject {
    private Long id;
    private String title;
    private Date date;

    private Set<SampleItem> items = new HashSet<>();
    
    @Id
    @GeneratedValue
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

    @Column(name="sampletimestamp")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToMany(
        targetEntity=SampleItem.class
    )
    @JoinTable(
        name="sampleItems_sampleObjects",
        joinColumns=@JoinColumn(name="object_id"),
        inverseJoinColumns=@JoinColumn(name="item_id")
    )
    public Set<SampleItem> getItems() {
        return items;
    }

    public void setItems(Set<SampleItem> items) {
        this.items = items;
    }
    
}
