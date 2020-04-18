package DAO;

import java.net.URLDecoder;

public interface DataDAO {
    String path = Thread.currentThread().getContextClassLoader().getResource("config\\data").getPath();
}