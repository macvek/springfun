/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.almatron.subfun.scannable;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author macvek
 */
public class FoundServiceTest {
    
    @InjectMocks
    private FoundService foundService;
    
    @Mock
    private JustPojo justPojo;
    
        
    @BeforeMethod
    public void initMocks() {
        foundService = new FoundService();
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testTrue() {
        assertTrue(true);
    }
    
    @Test
    public void testFalse() {
        assertFalse(false);
    }
    
    @Test
    public void mockedTest() {
        foundService.foundServiceAction();
        verify(justPojo).pojoAction();
    }
    
}
