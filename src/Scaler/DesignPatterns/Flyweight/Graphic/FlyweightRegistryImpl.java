package Scaler.DesignPatterns.Flyweight.Graphic;

import java.util.HashMap;
import java.util.Map;

public class FlyweightRegistryImpl implements FlyweightRegistry {

    Map<GraphicType, GraphicIntrinsicState> map;

    public FlyweightRegistryImpl() {
        this.map = new HashMap<>();
    }
    @Override
    public void addFlyweight(GraphicIntrinsicState flyweight) {
        map.put(flyweight.getType(), flyweight);
    }

    @Override
    public GraphicIntrinsicState getFlyweight(GraphicType graphicType) {
        return map.get(graphicType);
    }
}
