package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyDaoHelper {

    public static String getTypeDao() {
        Properties properties = new Properties();
        try {
            InputStream stream = UserDaoFactory.class.getClassLoader().getResourceAsStream("dao.property");
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("dao");
    }

}
