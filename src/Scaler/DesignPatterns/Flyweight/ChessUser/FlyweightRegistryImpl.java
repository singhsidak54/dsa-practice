package Scaler.DesignPatterns.Flyweight.ChessUser;

import java.util.HashMap;
import java.util.Map;

public class FlyweightRegistryImpl implements FlyweightRegistry {

    Map<String, UserIntrinsicState> map;

    public FlyweightRegistryImpl() {
        map = new HashMap<>();
    }

    @Override
    public void addFlyweight(UserIntrinsicState flyweight) {
        map.put(flyweight.getEmail(), flyweight);
    }

    @Override
    public UserIntrinsicState getFlyweight(String email) {
        return map.get(email);
    }
}
