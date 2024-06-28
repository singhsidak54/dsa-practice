package Scaler.DesignPatterns.Singleton.ConnectionPool;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPoolImpl implements ConnectionPool {

    private static ConnectionPoolImpl CPIInstance;
    private final Queue<DatabaseConnection> queue;
    private final int maxConnections;
    private ConnectionPoolImpl(int maxConnections) {
        this.maxConnections = maxConnections;
        this.queue = new LinkedList<>();
        this.initializePool();
    }

    @Override
    public void initializePool() {
        for(int i=0; i<this.maxConnections; i++) {
            this.queue.add(new DatabaseConnection());
        }
    }

    @Override
    public DatabaseConnection getConnection() {
        return this.queue.poll();
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        this.queue.add(connection);
    }

    @Override
    public int getAvailableConnectionsCount() {
        return this.queue.size();
    }

    @Override
    public int getTotalConnectionsCount() {
        return this.maxConnections;
    }

    public static void resetInstance() {
        CPIInstance = null;
    }

    public static ConnectionPoolImpl getInstance(int maxConnections) {
        if(CPIInstance == null) {
            synchronized(ConnectionPoolImpl.class) {
                if(CPIInstance == null) {
                    CPIInstance = new ConnectionPoolImpl(maxConnections);
                }
            }
        }

        return CPIInstance;
    }
}
