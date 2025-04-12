// Proyecto
import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.*;



public class Peso1{
    public static void main(String [] args){


        Scanner scanner = new Scanner(System.in);
        boolean exito = false;
        int peso = 0;

        int genero = 0;

        System.out.print("Selecciona 1 si sos Hombre, 2 si sos mujer: ");
        genero = scanner.nextInt();




        while(!exito){
            try {
                System.out.print("¿Cuanto pesas?: ");
                String entrada = scanner.nextLine();
                peso = Integer.parseInt(entrada);

                if(peso < 0){
                    throw new Exception("Dale, pone cuanto pesas: ");
                }

                exito = true;

            } catch (Exception e) {
                System.out.println("No no , dale tanto te cuesta? : " + e.getMessage());
                peso = 0;
            }
        }

        if(genero == 1 && peso > 80){
        mostrarPremio("imagen.jpg","audio.wav");
        }else{
            System.out.print("Bien ahi bro. Sos una bestia ");
        }

    }
    public static void mostrarPremio(String rutaImagen, String rutaAudio){

        //Mostrar la imagen
        ImageIcon icono = new ImageIcon(rutaImagen);
        JLabel etiqueta = new JLabel(icono);

        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().add(etiqueta);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        //Reproducir el audio

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(rutaAudio));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}