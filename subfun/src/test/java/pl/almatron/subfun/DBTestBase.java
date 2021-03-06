package pl.almatron.subfun;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;

/**
 * subfun
 *
 * @author macvek
 */
public abstract class DBTestBase {

    protected static ClassPathXmlApplicationContext context;

    @BeforeClass
    public static void setUpClass() {
        context = new ClassPathXmlApplicationContext(new String[]{"withhibernate.xml"});
    }
}
