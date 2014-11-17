/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.almatron.subfun;

import java.sql.SQLException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;

/**
 *
 * @author macvek
 */
public class DataSourceServiceTest extends FunTestBase {
    
    
    @Test
    public void testTransactionRollback() throws SQLException {
        final DataSourceService service = context.getBean(DataSourceService.class);
        service.cleanupSuperDummies();
        try {
            service.actionWithException();
        } 
        catch(RuntimeException e) {
            assertEquals("This exception stops transaction", e.getMessage());
        }
        finally {
            assertFalse(service.hasSuperDummy());
        }
    }
    
}
