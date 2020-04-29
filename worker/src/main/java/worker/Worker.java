package worker;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import java.sql.*;
import org.json.JSONObject;

class Worker {
  public static void main(String[] args) 
{
    try {
      Jedis redis = connectToRedis("redis");
      Connection dbConn = connectToDB("db");
      while (true){                                   //i have only create back-end structure here,so for continues connection i have use while loop..
      System.err.println("everything is setup ...."); //bt when you connect this structure to front-end system then you can put your logic queries to fetch data from redis &
                                                      //put it in POSTGRES database
      sleep(1000); 
                    }
         } 
    catch (SQLException e) {
               e.printStackTrace();
               System.exit(1);
                            }
   
}
static void sleep(long duration) {
    try {
      Thread.sleep(duration);
    } catch (InterruptedException e) {
      System.exit(1);
    }
  }

  static Jedis connectToRedis(String host) {
    Jedis conn = new Jedis(host);

    while (true) {
      try {
        conn.keys("*");
        break;
      } catch (JedisConnectionException e) {
        System.err.println("Waiting for redis");
      }
    }

    System.err.println("Connected to redis");
    return conn;
  }

  static Connection connectToDB(String host) throws SQLException {
    Connection conn = null;
      DriverManager.registerDriver(new org.postgresql.Driver());
      String url = "jdbc:postgresql://"+ host + ":5432/postgres";  //here url="jdbc:postgresql://your_host_name:your_port/database_u_want_to_connect"

      while (conn == null) {
          conn = DriverManager.getConnection(url, "postgres", "postgres");
      }

      PreparedStatement st = conn.prepareStatement(
        "CREATE TABLE IF NOT EXISTS votes (id VARCHAR(255) NOT NULL UNIQUE, vote VARCHAR(255) NOT NULL)");
      st.executeUpdate();
 

    System.err.println("Connected to db");
    return conn;
  }
}
