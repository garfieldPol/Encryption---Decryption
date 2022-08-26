package encryptdecrypt;

/** Factory method */

class PasswordsFactory {

    public Password getPassword(String data, String targetOperation, int key, String algorithm) {


        if (targetOperation == "enc" && algorithm == "unicode") {
            return new PasswordEncrypted(data,key);
        } else if (targetOperation == "enc" && algorithm == "shift") {
            return new PasswordEncryptedShift(data, key);
        } else if(targetOperation == "dec" && algorithm == "unicode"){
            return new PasswordDecrypted(data,key);
        } else if (targetOperation == "dec" && algorithm == "shift"){
            return new PasswordDecryptedShift(data, key);
        }


        return null;

        }
}


