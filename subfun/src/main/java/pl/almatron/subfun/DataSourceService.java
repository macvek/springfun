package pl.almatron.subfun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 * subfun
 *
 * @author macvek
 */

public class DataSourceService {

    @Autowired
    private DataSource dataSource;

    public void cleanupSuperDummies() throws SQLException {
        DataSourceUtils.getConnection(dataSource).prepareStatement("delete from sample where name='superDummy';").execute();
    }
    
    //@Transactional
    public void actionWithException() throws SQLException {
        final Connection connection = DataSourceUtils.getConnection(dataSource);
        boolean autocommit = connection.getAutoCommit();
        connection.prepareStatement("insert into sample(name) values('superDummy');").execute();
        throw new RuntimeException("This exception stops transaction");

    }

    public boolean hasSuperDummy() throws SQLException {
        final PreparedStatement stmt = DataSourceUtils.getConnection(dataSource).prepareStatement("select name from sample where name='superDummy'");
        stmt.execute();
        
        return stmt.getResultSet().next();
    }
}
