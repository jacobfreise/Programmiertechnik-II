package assignment6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import assignment6.hashing.JavaMDHashFunction;

public class JavaMDHashFunctionTest {

	@Test
	public void testMD5Hash() {
		// compare to http://md5-hash-online.waraxe.us/
		// current implementation: take first 4 bytes of the md5 hash
		assertEquals((int)Long.parseLong("5f4dcc3b5aa765d61d8327deb882cf99".substring(0,8), 16), JavaMDHashFunction.MD5.hash("password"));
		assertEquals((int)Long.parseLong("1bc29b36f623ba82aaf6724fd3b16718".substring(0,8), 16), JavaMDHashFunction.MD5.hash("md5"));
		assertEquals((int)Long.parseLong("0800fc577294c34e0b28ad2839435945".substring(0,8), 16), JavaMDHashFunction.MD5.hash("hash"));
	}
	@Test
	public void testMD5HashString() {
		// compare http://md5-hash-online.waraxe.us/
		assertEquals("5f4dcc3b5aa765d61d8327deb882cf99", JavaMDHashFunction.MD5.hashString("password"));
		assertEquals("1bc29b36f623ba82aaf6724fd3b16718", JavaMDHashFunction.MD5.hashString("md5"));
		assertEquals("0800fc577294c34e0b28ad2839435945", JavaMDHashFunction.MD5.hashString("hash"));
	}
	

	@Test
	public void testSHA1Hash() {
		// compare to http://www.sha1generator.de/
		// current implementation: take first 4 bytes of the sha-1 hash
		assertEquals((int)Long.parseLong("5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8".substring(0,8), 16), JavaMDHashFunction.SHA1.hash("password"));
		assertEquals((int)Long.parseLong("b710a299818728a4e4cb4851fca1607ae797a07b".substring(0,8), 16), JavaMDHashFunction.SHA1.hash("sha-1"));
		assertEquals((int)Long.parseLong("2346ad27d7568ba9896f1b7da6b5991251debdf2".substring(0,8), 16), JavaMDHashFunction.SHA1.hash("hash"));
	}
	@Test
	public void testSHA1HashString() {
		// compare http://www.sha1generator.de/
		assertEquals("5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", JavaMDHashFunction.SHA1.hashString("password"));
		assertEquals("b710a299818728a4e4cb4851fca1607ae797a07b", JavaMDHashFunction.SHA1.hashString("sha-1"));
		assertEquals("2346ad27d7568ba9896f1b7da6b5991251debdf2", JavaMDHashFunction.SHA1.hashString("hash"));
	}
	


	@Test
	public void testSHA256Hash() {
		// compare to http://www.xorbin.com/tools/sha256-hash-calculator
		// current implementation: take first 4 bytes of the sha-1 hash
		assertEquals((int)Long.parseLong("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8".substring(0,8), 16), JavaMDHashFunction.SHA256.hash("password"));
		assertEquals((int)Long.parseLong("3128f8ac2988e171a53782b144b98a5c2ee723489c8b220cece002916fbc71e2".substring(0,8), 16), JavaMDHashFunction.SHA256.hash("sha-256"));
		assertEquals((int)Long.parseLong("d04b98f48e8f8bcc15c6ae5ac050801cd6dcfd428fb5f9e65c4e16e7807340fa".substring(0,8), 16), JavaMDHashFunction.SHA256.hash("hash"));
	}
	@Test
	public void testSHA256HashString() {
		// compare http://www.xorbin.com/tools/sha256-hash-calculator
		assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", JavaMDHashFunction.SHA256.hashString("password"));
		assertEquals("3128f8ac2988e171a53782b144b98a5c2ee723489c8b220cece002916fbc71e2", JavaMDHashFunction.SHA256.hashString("sha-256"));
		assertEquals("d04b98f48e8f8bcc15c6ae5ac050801cd6dcfd428fb5f9e65c4e16e7807340fa", JavaMDHashFunction.SHA256.hashString("hash"));
	}
}
