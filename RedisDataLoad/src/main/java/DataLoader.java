import redis.clients.jedis.Jedis;

import java.io.*;

/**
 *
 */
public class DataLoader {
    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis("node00.ali.ws.com",6379);

        BufferedReader br = new BufferedReader(new InputStreamReader(DataLoader.class.getResourceAsStream("/ip.data")));
        String data = null;
        while((data = br.readLine())!=null)
        {
            //System.out.println(data);
            jedis.set(data.substring(0,data.indexOf("\t")),data.substring(data.indexOf("\t")+1));
        }
        System.out.println("finish!");
    }
}
