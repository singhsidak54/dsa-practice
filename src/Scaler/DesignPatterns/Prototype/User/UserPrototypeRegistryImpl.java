package Scaler.DesignPatterns.Prototype.User;

import java.util.HashMap;

public class UserPrototypeRegistryImpl implements UserPrototypeRegistry {

    HashMap<UserType, User> registry;

    public UserPrototypeRegistryImpl() {
        registry = new HashMap<>();
    }

    @Override
    public void addPrototype(User user) {
        registry.put(user.getType(), user);
    }

    @Override
    public User getPrototype(UserType type) {
        return registry.get(type);
    }

    @Override
    public User clone(UserType type) {
        return registry.get(type).cloneObject();
    }
}
