/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.almatron.subfun;

import java.sql.SQLException;
import org.testng.annotations.Test;

/**
 *
 * @author macvek
 */
public class UseDataSourceTest extends FunTestBase {
    
    @Test
    public void testSomeMethod() throws SQLException {
        UseDataSource dataSource = context.getBean("useDataSource", UseDataSource.class);
        dataSource.action();
    }
    
}
