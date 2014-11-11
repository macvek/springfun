package pl.almatron.subfun;

import java.io.File;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * subfun
 * @author macvek
 */
public class ChildBean extends BaseBean {
    private String childValue;
    private File file;
    
    @DateTimeFormat(pattern = "yyyyMMdd")
    private DateTime date;

    
    public String getChildValue() {
        return childValue;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

       

    
    public void setChildValue(String childValue) {
        this.childValue = childValue;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    
    
}
