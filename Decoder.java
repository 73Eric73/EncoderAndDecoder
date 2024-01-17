public class Decoder {

    public static void Decode(String encodeInput) {
        try {

            StringBuilder binaryCode = new StringBuilder();
            encodeInput = encodeInput.trim();
            String[] x = encodeInput.split(" ");

            for (int i = 0; i < x.length; i++) {
                if (i % 2 == 0) {
                    if (!x[i].equals("00") && !x[i].equals("0")) {
                        throw new Exception("Encoded string is not valid.");
                    }
                }
            }

            for (int i = 0; i < x.length - 1; i++) {

                if (i == 0) {

                    if (x[i].equals("0")) {
                        binaryCode.append("1".repeat(x[i + 1].length()));
                        i++;
                    } else {
                        binaryCode.append("0".repeat(x[i + 1].length()));
                        i++;
                    }

                } else {

                    if (x[i].equals("0")) {
                        binaryCode.append("1".repeat(x[i + 1].length()));
                        i++;
                    } else {
                        binaryCode.append("0".repeat(x[i + 1].length()));
                        i++;
                    }
                }

            }
            BinaryToDecimal(binaryCode.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void BinaryToDecimal(String binaryCode) {

        String[] decimalArray = new String[binaryCode.length() / 7];

        int counter = 0;

        for (int i = 0; i < binaryCode.length() / 7; i++) {
            if (i == 0) {
                decimalArray[i] = binaryCode.substring(counter, counter + 7);
                counter = 7;
            } else {
                decimalArray[i] = binaryCode.substring(counter, counter + 7);
                counter += 7;
            }
        }

        double[] decimalNumber = new double[binaryCode.length() / 7];

        for (int i = 0; i < decimalArray.length; i++) {
            for (int j = 0; j < decimalArray[i].length(); j++) {
                if (decimalArray[i].charAt(j) == '1') {
                    decimalNumber[i] += Math.pow(2, 6 - j);
                }
            }
        }

        try {
            for (double v : decimalNumber) {
                if (v < 32 || v > 122) {
                    throw new Exception("Encoded string is not valid.");
                }
            }
            System.out.println("Decoded string:");
            for (double v : decimalNumber) {
                char x = (char) v;

                System.out.print(Character.valueOf(x));
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
