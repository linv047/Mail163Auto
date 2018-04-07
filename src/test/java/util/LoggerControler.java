package util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lenovo on 2017/9/17.
 */
public class LoggerControler {
    private static Logger logger = null;
    private static LoggerControler logg = null;

    public static LoggerControler getlogger(Class<?>T){
        if (logger==null){
            Properties pros = new Properties();
            try {
              String path = System.getProperty("user.dir");
              String filePath = path + System.getProperty("file.separator")+"log4j.properties";
                InputStream input = new FileInputStream(filePath);
                pros.load(input);
            }catch (IOException e){
                e.printStackTrace();
            }
            PropertyConfigurator.configure(pros);
            logger = Logger.getLogger(T);
            logg = new LoggerControler();
        }
        return  logg;
    }

    public void info(String msg){
        logger.info(msg);
    }

    public void debug(String msg){
        logger.debug(msg);
    }

    public void error(String msg){
        logger.error(msg);
    }

    public void warn(String msg){
        logger.warn(msg);
    }
}
