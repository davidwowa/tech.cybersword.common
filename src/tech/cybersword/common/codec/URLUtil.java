package tech.cybersword.common.codec;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.apache.commons.codec.net.URLCodec;

public class URLUtil {

	private Logger logger = Logger.getLogger(URLUtil.class.getName());

	private URLCodec codec;

	private static URLUtil util;

	private URLUtil() {
		setCodec(new URLCodec());
	}

	public static URLUtil getInstance() {
		if (null == util) {
			util = new URLUtil();
		}
		return util;
	}

	public String safeUrl(String url) throws UnsupportedEncodingException {
		if (null != url) {
			return URLEncoder.encode(url, "utf-8");
//			return codec.encode(url, "utf-8");
		}
		logger.warning("url is null");
		return null;
	}

	public URLCodec getCodec() {
		return codec;
	}

	public void setCodec(URLCodec codec) {
		this.codec = codec;
	}
}