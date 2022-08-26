package encryptdecrypt;

class PasswordDecryptedShift extends Password{

    private String data;
    private int key;



    public PasswordDecryptedShift(String data, int key) {
        this.data = data;
        this.key = key;

    }

    @Override
    public String getData() {
        return null;
    }

    @Override
    public int getKey() {
        return 0;
    }

    @Override
    public String toString() {
        return decryption(data,key);
    }


    char[] smallLetters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] smallLettersDouble = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] bigletters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char[] biglettersDouble = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public String decryption(String data,int key) {

        char[] messageArray = data.toCharArray();
        char[] password = new char[messageArray.length];
        for (int i = 0; i < messageArray.length; i++) {
            for (int j = 0; j < smallLetters.length; j++) {
                if (messageArray[i] == smallLetters[j]) {
                    password[i] = smallLettersDouble[j  + 26 - key];
                } else if (messageArray[i] == ' '){
                    password[i] = ' ';
                }
            }
        }

        //No Big letters Services


        StringBuilder sb = new StringBuilder(String.valueOf(password));
        return  sb.toString();

    }}
