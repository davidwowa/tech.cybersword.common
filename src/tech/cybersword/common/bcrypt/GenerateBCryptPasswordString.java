package tech.cybersword.common.bcrypt;

import org.mindrot.jbcrypt.BCrypt;

public class GenerateBCryptPasswordString {
	public static void main(String[] args) {
		String hashedPassword = BCrypt.hashpw("!testTEST1234!", BCrypt.gensalt(12));
		System.out.println(hashedPassword);
	}
}
