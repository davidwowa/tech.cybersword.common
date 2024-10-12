package tech.cybersword.common.random;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class RandomUtil {

	private Logger logger = Logger.getLogger(RandomUtil.class.getName());

	private static RandomUtil instance;

	private RandomUtil() {
		logger.info("create instance of " + RandomUtil.class.getCanonicalName());
	}

	public static RandomUtil getInstance() {
		if (null == instance) {
			instance = new RandomUtil();
		}
		return instance;
	}

	public int getRandomIntBetween(int start, int end) {
		return ThreadLocalRandom.current().nextInt(start, end + 1);
	}
}