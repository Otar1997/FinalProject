package org.example.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config extends Properties {
    private static Config _instance;

    // The `private org.example.Config.Config()` constructor is a private constructor of the `org.example.Config.Config` class. It is called when an instance of
    // the `org.example.Config.Config` class is created.
    private Config() {
        load();
    }


    /**
     * The load() function loads the properties from a config file named "config.properties".
     */
    private void load() {
        try {
            InputStream inputStream = new FileInputStream("config.properties"); // config file location
            load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * use getProperty instead
     *
     * @return string value of a key
     */

    public String read(String key) {
        return getProperty(key);
    }

    /**
     * The function returns the instance of the org.example.Config.Config class, creating it if it doesn't already exist.
     *
     * @return The instance of the org.example.Config.Config class.
     */
    public static Config getInstance() {
        if (_instance == null) {
            _instance = new Config();
        }

        return _instance;
    }

}
