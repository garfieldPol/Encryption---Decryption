package encryptdecrypt;

import java.util.Arrays;

public class PasswordEncrypted extends Password {

    private String data;
    private int key;


    public PasswordEncrypted(String data,int key) {
        this.data = data;
         this.key = key;
    }

    @Override
    public String getData() {
        return this.data;
    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public String toString() {
        return encryption(data,key);
    }



    public String encryption(String data,int key) {
        char[] messageArray = data.toCharArray();
        char[] password = new char[messageArray.length];
       for (int i = 0; i < messageArray.length; i++) {
           int c = messageArray[i] + key;
            password[i] = (char) c;
        }

          StringBuilder sb = new StringBuilder(String.valueOf(password));
          return  sb.toString();

    }


}


