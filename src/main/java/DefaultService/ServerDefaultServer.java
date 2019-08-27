package DefaultService;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ServerDefaultServer {

	public static void main(String[] args) {
		AppiumDriverLocalService localService = AppiumDriverLocalService.buildDefaultService();
		localService.start();
		System.out.println("Appium Server is up and running");
		int count=1;
		do
		{
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("Server is still running from last "+count+" Second");
			++count;
		}while(count<=10);
		
		localService.stop();
		System.out.println("Appium Server is down now");
	}

}
