package remotebatch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchSlave {

	public static void main(String[] args) throws InterruptedException {
		ClassPathXmlApplicationContext clx = new ClassPathXmlApplicationContext("classpath:spring/root-context.xml");
		Thread.sleep(1000000);
		clx.destroy();
	}
}
