package encryptdecrypt;


/**
 * Concrete Product - Password Decrypted
 */
class PasswordDecrypted extends Password {
    private String data;
    private int key;

    public PasswordDecrypted(String data, int key) {
        this.data = data;
        this.key = key;

    }

    @Override
    public String getData() {
      return  this.data;
    }

    @Override
    public int getKey() {
        return  this.key;
    }

    @Override
    public String toString() {
        return decryption(data,key);
    }



    public String decryption(String data,int key) {
        char[] messageArray = data.toCharArray();
        char[] password = new char[messageArray.length];
        for (int i = 0; i < messageArray.length; i++) {
            int c = messageArray[i] - key;
            password[i] = (char) c;
    }
        StringBuilder sb = new StringBuilder(String.valueOf(password));
        return  sb.toString();

}}