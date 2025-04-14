import java.awt.*;
import javax.swing.*;




public  class VentanaBase extends JFrame{

    public VentanaBase(String titulo, int ancho, int alto){
        setTitle(titulo);
        setSize(ancho, alto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

    }
    
    public JButton crearBoton(String texto, int x, int y, int ancho, int alto){
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, alto);
        boton.setFocusPainted(false);
        boton.setBackground(new Color(255, 140, 0));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 18));
        return boton;

    }

    public JLabel crearImagen(String ruta, int x, int y, int ancho, int alto){

        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon(ruta);
        Image imagen = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

        JLabel etiqueta = new JLabel(new ImageIcon(imagen));

        //etiqueta.setHorizontalAlignment(JLabel.CENTER);
        //etiqueta.setVerticalAlignment(JLabel.CENTER);

        return etiqueta;

    }

    public void mostrar(){
        setVisible(true);
    }
  
}

    class  PantallaInicio extends VentanaBase{
        
    public PantallaInicio(){

        super("Menu de Inicio", 400, 300);
        
        JButton botonJugar = crearBoton("Jugar", 120,210, 150, 40);

        botonJugar.addActionListener(e -> {
            dispose();
            new Juego().mostrar();
        });
        add(botonJugar);

        JLabel fondo = crearImagen("busca.png", 0, 0, 150, 150);
        add(fondo, BorderLayout.CENTER);

        mostrar();



    }
}


