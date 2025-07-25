package learningjavaproject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLoggingDemo {

	public static void main(String[] args) {
		Log log = LogFactory.getLog(CommonsLoggingDemo.class);
		log.info("start...");
		log.warn("end.");

	}
}
