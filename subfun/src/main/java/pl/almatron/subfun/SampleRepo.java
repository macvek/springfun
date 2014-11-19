package pl.almatron.subfun;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.almatron.subfun.domain.SampleItem;
import pl.almatron.subfun.domain.SampleObject;

/**
 * subfun
 * @author macvek
 */
@Repository
@Transactional
public class SampleRepo {
    @Autowired
    private SessionFactory sessionFactory;
    
    public void doSomething() {
        SampleObject object = new SampleObject();
        object.setDate(new Date());
        object.setTitle("doSomething title");
        
        final Session session = sessionFactory.getCurrentSession();
        session.save(object);
        
    }
    
    public int countSampleObjects() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from SampleObject").list().size();
    }

    public void deleteAll() {
        final Session currentSession = sessionFactory.getCurrentSession();
        final List<SampleObject> sampleList = currentSession.createQuery("from SampleObject").list();
        sampleList.stream().forEach(sampleObject -> currentSession.delete(sampleObject));
        
        final List<SampleItem> itemList = currentSession.createQuery("from SampleItem").list();
        itemList.stream().forEach(sampleObject -> currentSession.delete(sampleObject));
    }

    public void doSomethingAndFail() {
        doSomething();
        throw new RuntimeException("Failed");
    }

    public int countSampleItems() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from SampleItem").list().size();
    }

    public void doAddItem(String name) {
        final SampleItem item = new SampleItem();
        item.setName(name);
        
        final Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(item);
    }

    public void createObjectWithItem(String someItem, String someTitle) {
        final Session session = sessionFactory.getCurrentSession();
        SampleObject object = new SampleObject();
        object.setDate(new Date());
        object.setTitle(someTitle);
        
        session.save(object);
        
        final Query query = session.createQuery("from SampleItem where name=:name");
        query.setParameter("name", someItem);
        
        final SampleItem item = (SampleItem) query.list().get(0);
        object.getItems().add(item);
        
        session.save(object);
    }

    public SampleItem getCreatedObjectItem() {
        final Session session = sessionFactory.getCurrentSession();
        List<SampleObject> objects = session.createQuery("from SampleObject").list();
        return objects.get(0).getItems().iterator().next();
    }
    
    public SampleItem getFirstItem() {
        final Session session = sessionFactory.getCurrentSession();
        return (SampleItem) session.createQuery("from SampleItem").list().get(0);
    }
    
    
}
