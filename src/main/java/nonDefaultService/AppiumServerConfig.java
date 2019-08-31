package nonDefaultService;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerConfig {
	AppiumDriverLocalService localService;
	AppiumServiceBuilder builder;
	Logger logger;

	public void start() {
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingAnyFreePort();
		localService = AppiumDriverLocalService.buildService(builder);
		localService.start();
	}

	public void stop() {
		localService.stop();
	}

	public static void main(String[] args) {
		AppiumServerConfig serverConfig = new AppiumServerConfig();
		serverConfig.logger = Logger.getLogger(AppiumServerConfig.class);
		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "log4j.properties");
		serverConfig.start();
		int count = 10;
		while (count > 0) {
			serverConfig.logger.info("Server is up");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			--count;
		}
		serverConfig.logger.info("Server id down");
		serverConfig.stop();
	}

}
