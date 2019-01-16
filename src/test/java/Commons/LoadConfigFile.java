package Commons;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class LoadConfigFile {
    static Properties prop;
    /*BufferedReader reader;
    public  Properties loadPropertiesFile(String propertyFilePath) throws FileNotFoundException {

        reader = new BufferedReader(new FileReader(propertyFilePath));
        prop = new Properties();
        try {
            prop.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }*/

    /*public static Properties loadPropertiesFile(String propertyFilePath) {
        prop = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(new File(propertyFilePath));
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }*/

    static void loadPropertiesFile() {
        // Use to store key/value pairs.
        prop = new Properties();
        try {
            // Use to get key/value pairs in Properties object
            // following propertyFilePath stream.
            prop.load(new FileInputStream("./src/test/Resources/Configs/Config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
