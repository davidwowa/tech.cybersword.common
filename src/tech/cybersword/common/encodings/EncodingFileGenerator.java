package tech.cybersword.common.encodings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class EncodingFileGenerator {

	public static void main(String[] args) throws IOException {
		String folderName = "encodings";

		new File(folderName).mkdirs();

		Map<String, Charset> charsetMap = Charset.availableCharsets();

		Set<String> charsetKeys = charsetMap.keySet();

		for (String charsetKey : charsetKeys) {
			System.out.println(charsetKey);
			// @see http://bugs.java.com/view_bug.do?bug_id=4107300
			if (!charsetKey.contains("ISO-2022-CN") && !charsetKey.contains("x-COMPOUND_TEXT")
					&& !charsetKey.contains("x-JISAutoDetect")) {
				OutputStreamWriter writer = new OutputStreamWriter(
						new FileOutputStream(folderName + "/" + charsetKey + ".txt"), Charset.forName(charsetKey));
				for (int i = 0; i < Character.MAX_VALUE; i++) {
					writer.write(new Character((char) i));
				}
				writer.close();
			}
		}
	}
}