package DefaultService;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ServerDefaultServer {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(ServerDefaultServer.class);
		PropertyConfigurator.configure(System.getProperty("user.dir")+File.separator+"log4j.properties");
		AppiumDriverLocalService localService = AppiumDriverLocalService.buildDefaultService();
		localService.start();
		logger.info("Appium Server is up and running");
		int count=1;
		do
		{
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			logger.info("Server is still running from last "+count+" Second");
			++count;
		}while(count<=10);
		
		localService.stop();
		logger.info("Appium Server is down now");
	}

}
