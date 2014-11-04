package pl.almatron.subfun;

/**
 * subfun
 * @author macvek
 */
public abstract class SingletonBean {
    private String configValue;
    private String entryValue;

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    abstract public Ref createSampleRef();

    public String getEntryValue() {
        return entryValue;
    }

    public void setEntryValue(String entryValue) {
        this.entryValue = entryValue;
    }

    public String getSummary() {
        return "Config: "+configValue+", Entry: "+entryValue+", ref:"+createSampleRef();
    }

   
}
