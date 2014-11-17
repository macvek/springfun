package pl.almatron.subfun;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

/**
 * subfun
 * @author macvek
 */
@Repository
public class UseDataSource {
    
    private DataSource datasource;

    public DataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }
    
    public void action() throws SQLException {
        final Connection connection = DataSourceUtils.getConnection(datasource);
        final Statement statement = connection.createStatement();
        statement.execute("select * from sample");
        final ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            final String name = resultSet.getString("name");
            System.out.println("Result is : "+name);
        }
    }
}
