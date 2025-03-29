import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HackeoEtico {
    private static Scanner tec = new Scanner(System.in);
    public static void main(String[] args){
        mostrarMenu();
    }

    private static void mostrarMenu() {
        int menu = tec.nextInt();
        tec.nextLine();

        switch (menu){
            case 1:
                codificarContrasena();
                mostrarMenu();
                break;
            case 2:
                desencriptarContrasena();
                mostrarMenu();
                break;
            case 3:
                System.out.println("Fin");
                break;
            default:
                mostrarMenu();
                break;
        }
    }

    private static void codificarContrasena() {
        String contra = tec.nextLine();
        byte[] msg = contra.getBytes();
        byte[] hash;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            hash = md.digest(msg);
            StringBuilder strBuilder = new StringBuilder();

            for (byte b : hash) {
                strBuilder.append(String.format("%02x", b));
            }

            String strHash = strBuilder.toString();
            System.out.println(strHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void desencriptarContrasena() {
        String encriptado = tec.nextLine();
        String contra = null;

        try (BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\leo10\\IdeaProjects\\FundamentosProgramacion\\src\\Parcial4\\diccionario.txt"))) {
            buscarContrasena(lector, encriptado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void buscarContrasena(BufferedReader lector, String encriptado) throws Exception {
        String contra;
        while ((contra = lector.readLine()) != null) {
            byte[] msg = contra.getBytes();
            byte[] hash;

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                hash = md.digest(msg);
                StringBuilder strBuilder = new StringBuilder();

                for (byte b : hash) {
                    strBuilder.append(String.format("%02x", b));
                }

                String strHash = strBuilder.toString();

                if (encriptado.equals(strHash)) {
                    System.out.println(contra);
                    return;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Error");
    }
}
