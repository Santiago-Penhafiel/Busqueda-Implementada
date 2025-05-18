import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JButton agregarButton;
    private JButton buscarButton;
    private JButton eliminarButton;
    private JButton ordenarButton;
    public JTextArea txtArea;
    private JLabel label;
    private JButton mostrarListaButton;
    Lista lista = new Lista();

    public Ventana() {

        lista.mostrarLista(txtArea);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    lista.agregarYActualizar(JOptionPane.showInputDialog("Ingrese el nombre"), JOptionPane.showInputDialog("Ingrese la especie"),
                            JOptionPane.showInputDialog("Ingrese la ocupacion"), JOptionPane.showInputDialog("Ingrese una breve descripción"), txtArea);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    lista.eliminar(JOptionPane.showInputDialog("Ingrese el nombre a eliminar"), txtArea);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    StringBuilder stringBuilder = new StringBuilder("Personaje encontrado :\n");
                    Personaje personaje = lista.convertirAArray()[lista.buscarLineal(JOptionPane.showInputDialog("Ingrese el nombre a buscar"), txtArea)];
                    stringBuilder.append(personaje.toString());
                    txtArea.setText("");
                    txtArea.setText(stringBuilder.toString());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    lista.ordenarBurbuja();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
