package companies.Bloomberg;

import java.util.HashMap;

public class DesignUndergroundSystem {
    class CustomerCheckedIn {
        int t;
        String stationName;
        public CustomerCheckedIn(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }

    class StationToStationStat {
        int sum;
        int times;
        public StationToStationStat () {
            this.sum = 0;
            this.times = 0;
        }
    }

    HashMap<Integer, CustomerCheckedIn> checkInMap;
    HashMap<String, HashMap<String, StationToStationStat>> stationsMap;
    public DesignUndergroundSystem() {
        checkInMap = new HashMap<>();
        stationsMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CustomerCheckedIn(stationName, t));
        stationsMap.putIfAbsent(stationName, new HashMap<>());
    }

    public void checkOut(int id, String stationName, int t) {
        CustomerCheckedIn checkIn = checkInMap.remove(id);
        HashMap<String, StationToStationStat> checkedInStationMap = stationsMap.get(checkIn.stationName);
        checkedInStationMap.putIfAbsent(stationName, new StationToStationStat());
        checkedInStationMap.get(stationName).sum += (t - checkIn.t);
        checkedInStationMap.get(stationName).times++;
    }

    public double getAverageTime(String startStation, String endStation) {
        StationToStationStat currentStat = stationsMap.get(startStation).get(endStation);
        return currentStat.sum/(double)currentStat.times;
    }
}
