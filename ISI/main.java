import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.*;




public class main{
    public static void main(String[] args) {

        String [] binario = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        char [] hexadecimal = {'1','2','3','4','5','6','7','8','9','A','B','C','D','E','F',};


        //Crear ventana

        JFrame ventana = new JFrame("Conversor de Sistemas de Representacion");
        ventana.setSize(400,500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.getContentPane().setBackground(new Color(255,255,200));
        ventana.setLayout(null);
        ventana.setResizable(false);
    
        //Area para ingresar el texto
        JLabel etiqueta = new JLabel(" Ingrese el numero: ");
        etiqueta.setBounds(100,25,200,30);

        JTextField campoTexto = new JTextField(15); // Para escribir el numero
        campoTexto.setBounds(100,60,200,30);
        
        // Botones

        JButton IBM360 = crearBoton("IBM-360",125,120,120,40);
        JButton PDP11 = crearBoton("PDP-11", 125, 170, 120,40);
        JButton IEEE754 = crearBoton("IEEE-754", 125, 220, 120, 40);
        JButton Decimal = crearBoton("Decimal", 125, 270, 120, 40);

        // Etiqueta para mostrar el resultado
        JLabel resultadoEtiqueta = new JLabel("Resultado: ");
        resultadoEtiqueta.setBounds(100,320,300,30);


        // Añado todo a la ventana
        ventana.add(etiqueta);        
        ventana.add(campoTexto);
        ventana.add(IBM360);
        ventana.add(PDP11);
        ventana.add(IEEE754);       
        ventana.add(Decimal);
        ventana.add(resultadoEtiqueta);

        ventana.setVisible(true);


        // Accion boton IBM 360

        IBM360.addActionListener(new ActionListener() {
            @Override // Sobreescribe
            public void actionPerformed(ActionEvent e){

                String texto = campoTexto.getText(); // Obtiene el numero ingresado en forma de texto

                if(!texto.isEmpty()){ // verifica que no este vacio
                    try {

                        double numero = Double.parseDouble(texto);
                        //String resultadoIBM360 = convertirAIBM360(numero);
                        convertirAIBM360(numero);
                        resultadoEtiqueta.setText("Resultado: " + numero);

                    } catch (NumberFormatException ex) {
                        resultadoEtiqueta.setText("Por favor, ingrese un numero valido: ");
                    }
                }else{
                    resultadoEtiqueta.setText("Por favor, ingrese un numero: ");
                }

            }


        });


    } // CIERRE MAIN
    

    //constructor boton

    public static JButton crearBoton(String texto, int x, int y, int ancho, int alto){

        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, alto);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setBackground(new  Color(65,105,224));
        boton.setForeground(Color.white);
        boton.setFont(new Font("Arial", Font.BOLD, 14));


        //Accion del mouse al pasar por el boton
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                boton.setBackground(new Color(65,165,224));
            }
            
            public void mouseExited(MouseEvent e){
                boton.setBackground(new Color(65,105,224));
            }
        });

        return boton;



    } // CIERRE CONSTRUCTOR BOTON

    public static void convertirAIBM360(double numero){
        // Arreglos donde se guarda signo , exponente y mantisa;

        int [] signo = new int [1];
        int [] exponente = new int [7];
        int [] mantisa = new int [24];

        //Parte Entera

        int parteEntera = (int) numero;
        //System.out.println(parteEntera);
        
        // parte Fraccionaria

        double parteFraccionaria = numero - parteEntera;

        // Redondeo de parte decimal
        BigDecimal parteFraccionariaBD = new BigDecimal(parteFraccionaria);

        // Redondea a maximo 5 decimales

        parteFraccionariaBD = parteFraccionariaBD.setScale(5, RoundingMode.HALF_UP);

        //System.out.print(parteFraccionariaBD);

        // Determinar Bit de signo
        if(parteEntera >= 0){
            signo[0] = 0;
        }else{
            signo[0] = 1;
        }

        //Pasar la mantisa a binario

        // Parte entera
        int bitsParteEntera = 0;

        int temp = parteEntera;
        while(temp > 0){
            temp = temp / 2;
            bitsParteEntera++;
        }
        int [] auxBiEntero = new int [bitsParteEntera];
        //System.out.print(bitsParteEntera);

        while(parteEntera > 0){
            int resto = parteEntera % 2;
            parteEntera = parteEntera / 2;
            auxBiEntero[bitsParteEntera -1] = resto;
            bitsParteEntera--;

        }   
        for(int j : auxBiEntero){
             System.out.print(j);
         }
         System.out.print("|");

        // Parte decimal
        
        int [] binarioDecimal = new int[20 - bitsParteEntera]; 

        for(int t = 0; t < binarioDecimal.length; t++){
            parteFraccionaria *= 2;
            int bit = (int) parteFraccionaria;
            binarioDecimal[t] = bit;
            parteFraccionaria -= bit;

            if(parteFraccionaria == 0){
                break;
            }
        }

        for(int f : binarioDecimal){
            System.out.print(f);
        }


    }
}