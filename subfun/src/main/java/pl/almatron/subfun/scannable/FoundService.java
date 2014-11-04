package pl.almatron.subfun.scannable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * subfun
 * @author macvek
 */

@Service
public class FoundService {
    @Autowired
    private JustPojo justPojo;
    
    public void foundServiceAction() {
        justPojo.pojoAction();
    }
}
