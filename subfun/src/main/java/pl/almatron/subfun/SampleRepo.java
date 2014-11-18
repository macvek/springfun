package pl.almatron.subfun;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
    
    public int countAllItems() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from SampleObject").list().size();
    }

    public void deleteAll() {
        final Session currentSession = sessionFactory.getCurrentSession();
        final List<SampleObject> list = currentSession.createQuery("from SampleObject").list();
        
        list.stream().forEach(sampleObject -> currentSession.delete(sampleObject));
    }

    public void doSomethingAndFail() {
        doSomething();
        throw new RuntimeException("Failed");
    }
    
    
}
