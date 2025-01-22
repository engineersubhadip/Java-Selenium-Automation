package ThreadLocal_SameDriverInstance;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManagement {

	private static DriverManagement instance;
	private static Lock lock = new ReentrantLock();
	private static ThreadLocal<WebDriver> tLocal = new ThreadLocal<>();

	private DriverManagement() {
	}

	public static DriverManagement getInstance() {
		if (instance == null) {
			lock.lock();
			if (instance == null) {
				instance = new DriverManagement();
			}
			lock.unlock();
		}
		return instance;
	}

	public void setDriver(String browserName) { // this code will be executed by a thread via the shared object
		if (tLocal.get() == null) {
			if (browserName.toLowerCase().contains("chrome")) {
				tLocal.set(new ChromeDriver());
			} else if (browserName.toLowerCase().contains("edge")) {
				tLocal.set(new EdgeDriver());
			} else {
				return;
			}
		}
	}

	public WebDriver getDriver() { // this piece of code will be executed by a thread, via the shared object
		if (tLocal.get() != null) {
			return tLocal.get();
		}
		return null;
	}

	public void quitDriver() { // this piece of code will be executed by a thread via the shared object
		if (tLocal.get() != null) {
			tLocal.get().quit();
			tLocal.remove();
		}
	}
}
