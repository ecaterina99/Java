/**
 * Implement a pseudo-encryption algorithm which given a string S and an integer N
 * concatenates all the odd-indexed characters of S with all the even-indexed characters of S,
 * this process should be repeated N times.
 * ex: encrypt("012345", 2)  =>  "135024"  ->  "304152"
 * also implement a decryption function which reverses the process.
 * If the string S is an empty value or the N is not positive, return the first argument without changes.
 */
void main() {
    final String text = "This is a test!";
    final int n = 2;
    String encryptedText = "";
    String decryptedText = "";
    if (n < 1 || text.isEmpty()) {
        encryptedText = text;
    } else {
        encryptedText = encrypt(text, n);
        decryptedText = decrypt(encryptedText, n);
    }
    System.out.println(encryptedText);
    System.out.println(decryptedText);
}

public String decrypt(String encryptedText, final int n) {
    for (int j = 0; j < n; j++) {
        int mid = encryptedText.length() / 2;

        String odd = encryptedText.substring(0, mid);
        String even = encryptedText.substring(mid);
        StringBuilder res = new StringBuilder();
        int evenIndex = 0, oddIndex = 0;

        for (int i = 0; i < encryptedText.length(); i++) {
            if (i % 2 == 0) {
                res.append(even.charAt(evenIndex++));
            } else {
                res.append(odd.charAt(oddIndex++));
            }
        }
        encryptedText = res.toString();
    }
    return encryptedText;
}


public String encrypt(String text, final int n) {
    StringBuilder odd = new StringBuilder();
    StringBuilder even = new StringBuilder();
    StringBuilder res = new StringBuilder();
    for (int j = 0; j < n; j++) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (i % 2 == 0) {
                even.append(c);
            } else {
                odd.append(c);
            }
        }
        text = res.append(odd).append(even).toString();
        even.delete(0, even.length());
        odd.delete(0, odd.length());
        res.delete(0, res.length());
    }
    return text;
}
