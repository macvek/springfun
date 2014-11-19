/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.almatron.subfun;

import java.util.Set;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.almatron.subfun.domain.SampleItem;
import pl.almatron.subfun.domain.SampleObject;



/**
 *
 * @author macvek
 */
public class SampleRepoTest extends DBTestBase {
    private SampleRepo repo;
    
    @BeforeMethod 
    public void setup() {
        repo = context.getBean("sampleRepo", SampleRepo.class);
        repo.deleteAll();
    }
    
    @Test
    public void testSomeMethod() throws Exception {
        repo.doSomething();
        assertNotEquals(0, repo.countSampleObjects());
    }
    
    @Test
    public void testDeleteAll() throws Exception {
        repo.deleteAll();
        assertEquals(0, repo.countSampleObjects());
        assertEquals(0, repo.countSampleItems());
    }
    
    @Test
    public void testShouldRollbackTrasaction() throws Exception {
        assertEquals(0, repo.countSampleObjects());
        try {
            repo.doSomethingAndFail();
        }
        catch(RuntimeException exception) {
            assertEquals(0, repo.countSampleObjects());
            return;
        }
        Assert.fail("Should have thrown exception");
    }
    
    @Test
    public void testShouldAddItem() throws Exception {
        assertEquals(0, repo.countSampleItems());
        repo.doAddItem("SomeItem");
        assertEquals(1, repo.countSampleItems());
    }
    
    @Test
    public void testShouldAddItemToObject() {
        repo.doAddItem("SomeItem");
        repo.createObjectWithItem("SomeItem", "SomeTitle");
        final SampleItem item = repo.getCreatedObjectItem();
        assertEquals("SomeItem", item.getName());
    }
    
    @Test
    public void testShouldReturnObjectWithLoadedItems() {
        repo.doAddItem("SomeOtherItem");
        repo.createObjectWithItem("SomeOtherItem", "SomeOtherItem title");
        final SampleItem firstItem = repo.getFirstItem();
        assertEquals("SomeOtherItem title", firstItem.getObjects().get(0).getTitle());
    }
    
}
