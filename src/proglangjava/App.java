/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglangjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Wolfwood
 */
public class App {

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.run();
    }
    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            synchronized (this) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
                    } catch (SQLException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return connection;
    }

    private HashMap< String, PreparedStatement> preparedStatementCache = null;
    public static final int SQL_STATEMENT_TIMEOUT_SECONDS = 10;

    public PreparedStatement getPreparedStatement(String sql) {
        if (preparedStatementCache == null) {
            synchronized (this) {
                if (preparedStatementCache == null) {
                    preparedStatementCache = new HashMap< String, PreparedStatement>();
                }
            }
        }

        PreparedStatement preparedStatement = preparedStatementCache.get(sql);
        if (preparedStatement == null) {
            synchronized (this) {
                preparedStatement = preparedStatementCache.get(sql);
                if (preparedStatement == null) {
                    try {
                        Connection connection = getConnection();
                        int keyMode = sql.startsWith("insert")
                                ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS;

                        preparedStatement
                                = connection.prepareStatement(sql, keyMode);
                        preparedStatement.setQueryTimeout(SQL_STATEMENT_TIMEOUT_SECONDS);
                        preparedStatementCache.put(sql, preparedStatement);
                    } catch (SQLException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }
        return preparedStatement;
    }

    ResultSet sql(String sql, Object... objects) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(sql);
            int index = 1;
            for (Object object : objects) {
                if (object instanceof Boolean) {
                    preparedStatement.setBoolean(index, (Boolean) object);
                } else if (object instanceof Integer) {
                    preparedStatement.setInt(index, (Integer) object);
                } else if (object instanceof Long) {
                    preparedStatement.setLong(index, (Long) object);
                } else if (object instanceof String) {
                    preparedStatement.setString(index, (String) object);
                } else {
                    throw new IllegalStateException("can't set type " + object.getClass().getName());
                }
                ++index;
            }
            if (sql.startsWith("insert")) {
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                return resultSet;
            } else {
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet;
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    Long longResult(ResultSet resultSet) {
        try {
            if (resultSet != null && resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    String stringResult(ResultSet resultSet) {
        try {
            if (resultSet != null && resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Statement statement = null;

    public Statement getStatement() {
        if (statement == null) {
            synchronized (this) {
                if (statement == null) {
                    try {
                        Connection connection = getConnection();
                        statement = connection.createStatement();
                        statement.setQueryTimeout(SQL_STATEMENT_TIMEOUT_SECONDS);
                    } catch (SQLException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return statement;
    }

    void sql(String command) {
        try {
            Statement statement = getStatement();
            statement.executeUpdate(command);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void reset() {
        sql("drop table if exists person");
        sql("create table person (id integer primary key, name string, test1 integer, test2 integer, average long)");
    }

    long insertPerson(String name, Integer test1, Integer test2) {
        long average =(test1+test2)/2;
        return longResult(sql("insert into person (name,test1,test2,average) values (?,?,?,?)", name, test1,test2,average));
    }

    String getPerson(long id) {
        return stringResult(sql("select name from person where id=?", id));
    }
    long getAverage(long id){
        return longResult(sql("select average from person where id=?",id));
    }

    void run() {
        reset();
        long aliceId = insertPerson("alice",89,100);
        System.out.println("aliceId=" + aliceId);
        long bobId = insertPerson("bob",64,86);
        System.out.println("alice name=" + getPerson(aliceId)+" alice average="+getAverage(aliceId));
        System.out.println("bob name="+getPerson(bobId)+" bob average"+ getAverage(bobId));
    }

}
