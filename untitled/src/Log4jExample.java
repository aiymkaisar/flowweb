import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {
    private static final Logger logger = LogManager.getLogger(Log4jExample.class);

    public static void main(String[] args) {
        logger.info("Бұл INFO хабарламасы.");
        logger.error("Бұл ERROR хабарламасы.");
    }
}
