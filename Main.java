import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String election;

        while (true) {

            System.out.println("Please input operation (encode/decode/exit):");
            election = scanner.nextLine();

            switch (election) {

                case "encode":
                    System.out.println("Input string:");
                    String codeUser = Encoder.Encode(scanner.nextLine());
                    System.out.println("Encoded string:");
                    System.out.println(codeUser);
                    break;

                case "decode":
                    System.out.println("Input encoded string:");
                    Decoder.Decode(scanner.nextLine());
                    break;

                case "exit":
                    System.out.println("Bye");
                    return;

                default:
                    System.out.println("There is no '" + election + "' operation");
                    break;
            }

        }
    }
}
