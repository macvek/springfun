/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.almatron.subfun;

import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



/**
 *
 * @author macvek
 */
public class SampleRepoTest extends DBTestBase {
    private SampleRepo repo;
    
    @BeforeMethod 
    public void setup() {
        repo = context.getBean("sampleRepo", SampleRepo.class);
    }
    
    @Test
    public void testSomeMethod() throws Exception {
        repo.doSomething();
        assertNotEquals(0, repo.countAllItems());
    }
    
    @Test
    public void testDeleteAll() throws Exception {
        repo.deleteAll();
        assertEquals(0, repo.countAllItems());
    }
    
    @Test
    public void testShouldRollbackTrasaction() throws Exception {
        assertEquals(0, repo.countAllItems());
        try {
            repo.doSomethingAndFail();
        }
        catch(RuntimeException exception) {
            assertEquals(0, repo.countAllItems());
            return;
        }
        Assert.fail("Should have thrown exception");
    }
    
}
