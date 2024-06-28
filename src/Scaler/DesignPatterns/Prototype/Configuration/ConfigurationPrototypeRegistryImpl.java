package Scaler.DesignPatterns.Prototype.Configuration;

import java.util.HashMap;

public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry {
    HashMap<ConfigurationType, Configuration> registry;

    public ConfigurationPrototypeRegistryImpl() {
        this.registry = new HashMap<>();
    }
    @Override
    public void addPrototype(Configuration user) {
        this.registry.put(user.getType(), user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return this.registry.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        return this.getPrototype(type).cloneObject();
    }
}
