package com.gaga.jdbc;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/19 15:03
 * @version: 1.0
 */
public class JdbcPool {

    private Vector<PoolConnection> connections = new Vector();

    private static String jdbcDriver;

    private static String jdbcUrl;

    private static String username;

    private static String password;

    private static Integer initConnectCount = 150;

    private static Integer poolMaxSize = 300;

    {
        try {
            Driver driver = (Driver) Class.forName(jdbcDriver).newInstance();
            DriverManager.registerDriver(driver);
            /*
             * 根据initConnectCount来初始化连接池
             * */
            createConnections(initConnectCount);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
    }

    JdbcPool() {
        this(initConnectCount);
    }

    JdbcPool(int poolMaxSize) {
        this.initPool(poolMaxSize);
    }

    private void initPool(int poolMaxSize) {
        createConnections(poolMaxSize);
    }

    private void createConnections(int initConnectCount) {
        for (int i = 0; i < initConnectCount; i++) {
            if (poolMaxSize > 0 && connections.size() >= poolMaxSize) {
                System.out.println("连接池中连接数量已经达到最大值");
                throw new RuntimeException("连接池中连接数量已经达到最大值");
            }
            try {
                connections.add(new PoolConnection(DriverManager.getConnection(jdbcUrl, username, password), false));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public PoolConnection getConnection() {

        if (connections.isEmpty()) {
            System.out.println("连接池中没有连接");
            throw new RuntimeException("连接池中没有连接");
        }

        for (PoolConnection temp : connections) {
            if (!temp.isUse()) {
                return temp;
            }
        }
        return null;
    }


    public static void main(String[] args) throws SQLException {
        JdbcPool jdbcPool = new JdbcPool();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(jdbcPool.getConnection().hashCode());
            }).start();
        }

    }
}

class PoolConnection {

    /**
     * 数据库连接
     */
    @Getter
    @Setter
    private Connection conn = null;

    /**
     * 标记该连接是否使用
     */
    @Getter
    @Setter
    private boolean isUse = false;

    /**
     * @param conn
     * @param isUse
     */
    public PoolConnection(Connection conn, boolean isUse) {
        this.conn = conn;
        this.isUse = isUse;
    }
}


