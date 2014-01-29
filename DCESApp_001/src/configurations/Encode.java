package configurations;

import net.rim.device.api.crypto.SHA1Digest;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class Encode {

private static String convertToHex(byte[] data) {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < data.length; i++) {
        int halfbyte = (data[i] >>> 4) & 0x0F;
        int two_halfs = 0;
        do {
            if ((0 <= halfbyte) && (halfbyte <= 9))
                buf.append((char) ('0' + halfbyte));
            else
                buf.append((char) ('a' + (halfbyte - 10)));
            halfbyte = data[i] & 0x0F;
        } while (two_halfs++ < 1);
    }
    return buf.toString();
}

public String SHA1(String text) {
    SHA1Digest sha1Digest = new SHA1Digest();
    sha1Digest.update(text.getBytes(), 0, text.length());
    byte[] hashValBytes = new byte[sha1Digest.getDigestLength()];
    hashValBytes = sha1Digest.getDigest();
    return convertToHex(hashValBytes);
}
public String longSHA1(long text1) {
	String text = text1+"1";
    SHA1Digest sha1Digest = new SHA1Digest();
    sha1Digest.update(text.getBytes(), 0, text.length());
    byte[] hashValBytes = new byte[sha1Digest.getDigestLength()];
    hashValBytes = sha1Digest.getDigest();
    return convertToHex(hashValBytes);
}
}
