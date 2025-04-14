import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.http.HttpResponse;
import java.util.Random;
import javax.swing.text.TabableView;



public class Juego extends  VentanaBase {

    private JButton[][] botones; // para la cuadricula de botones
    private int [][] matrizJuego; //para almacenar la cuadricula (0 =  vacio, 1 = bomba)
    private final int TAMAÑO = 4; // tamaño de la cuadricula 4 x 4
    private final int BOMBA = 1; // Valor que representa un bomba
    private final int VACIO = 0 ; // valor que representa un espacio vacio;

    public Juego() {
        super("Juego" , 500,400);

        botones = new JButton[TAMAÑO][TAMAÑO];
        matrizJuego = new int[TAMAÑO][TAMAÑO];

        // inicializar cuadricula con botones

        setLayout(new GridLayout(TAMAÑO, TAMAÑO));
        for(int i = 0; i < TAMAÑO; i++){
            for(int j = 0; j < TAMAÑO; j++){
                botones[i][j] = new JButton();
                botones[i][j].setPreferredSize(new Dimension(80, 80));
                botones[i][j].setFont(new Font("Arial", Font.PLAIN, 30));
                botones[i][j].setBackground(Color.LIGHT_GRAY);

                final int fila = i;
                final int col = j;


                // clase anónima para el ActionListeners


                botones[i][j].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        manejaClick(fila, col);
                    }
                });
                add(botones[i][j]);


            }
        }

        colocarBombas(3);

        mostrar();

    }
    // public void mostrar(){
    //     setVisible(true);
    // }
    //Metodo para colocar bombas aleatoriamente;

    private void colocarBombas(int cantidad){

        Random rand = new Random();
        int bombasColocadas = 0;

        while(bombasColocadas < cantidad){
            int fila = rand.nextInt(TAMAÑO);
            int col = rand.nextInt(TAMAÑO);

            // Si ya hay una bomba no la colocamos

            if(matrizJuego[fila][col] != BOMBA) {
                matrizJuego[fila][col] = BOMBA;
                bombasColocadas++;
            }
        }
    }

    // Metodo para manejar los click en los botones

    private void manejaClick(int fila, int col){
        if(matrizJuego[fila][col] == BOMBA){
            // Si hay una bomba termina el juego;

            ImageIcon iconoOriginal = new ImageIcon("bomba.png");
            Image imagen = iconoOriginal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon iconoEscalado = new ImageIcon(imagen);

            botones[fila][col].setIcon(iconoEscalado);

            JOptionPane.showMessageDialog(this, "¡Perdiste! Encontraste una bomba");
            dispose(); // cierra la ventana de juego
            new PantallaInicio().mostrar();

        }else{

            ImageIcon iconoOriginal = new ImageIcon("check.png");
            Image imagen = iconoOriginal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon iconoEscalado = new ImageIcon(imagen);

            botones[fila][col].setIcon(iconoEscalado);
            botones[fila][col].setBackground(Color.white);

        }
    }
}
