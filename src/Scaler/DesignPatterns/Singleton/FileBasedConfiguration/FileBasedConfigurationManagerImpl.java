package Scaler.DesignPatterns.Singleton.FileBasedConfiguration;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManagerImpl FBCM;

    private FileBasedConfigurationManagerImpl() {
        super();
    }

    @Override
    public String getConfiguration(String key) {
        return this.getProperties().getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String config = this.getConfiguration(key);
        return config == null ? null : this.convert(config, type);
    }

    @Override
    public void setConfiguration(String key, String value) {
        this.getProperties().setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        if(value == null) {
            this.removeConfiguration(key);
            return;
        }
        this.getProperties().setProperty(key, value.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        this.getProperties().remove(key);
    }

    @Override
    public void clear() {
        this.getProperties().clear();
    }

    public static FileBasedConfigurationManager getInstance() {
        if(FBCM == null) {
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if(FBCM == null) {
                    FBCM = new FileBasedConfigurationManagerImpl();
                }
            }
        }

        return FBCM;
    }

    public static void resetInstance() {
        FBCM = null;
    }
}
