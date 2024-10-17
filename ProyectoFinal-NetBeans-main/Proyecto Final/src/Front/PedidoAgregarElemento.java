/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Front;

import Back.Producto;
import Back.Plato;
import Back.Pedido;
import Back.Mesa;
import Back.ItemPedido;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class PedidoAgregarElemento extends javax.swing.JPanel {

    /**
     * Creates new form PedidoAgregarElemento
     */
    public PedidoAgregarElemento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setText("Cantidad");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Agregar plato o producto");

        jLabel1.setText("Número de mesa");

        jLabel2.setText("Nombre del plato o producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextField3))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // Se inicializan variables para manejar información sobre la mesa, el nombre del ítem y la cantidad
    int numeroMesa = 0;
    String nombreItem = null;
    int cantidad = 0;

    // Bandera para controlar la repetición de la acción de agregar ítems
    boolean agregarOtro = true;

    // Variable para la respuesta del usuario
    int respuesta;

    // Lista para almacenar los elementos del pedido
    ArrayList<ItemPedido> elementosPedido = new ArrayList<>();

    // Listas para almacenar pedidos y mesas, inicializadas como nulas
    ArrayList<Pedido> listaPedidos = null; 
    ArrayList<Mesa> listaMesas = null;

    // Bucle mientras el usuario quiera agregar otro ítem al pedido
    while (agregarOtro) {
        // Verifica si los campos están llenos
        if ((jTextField1.getText() != null) && (jTextField2.getText() != null) && (jTextField3.getText() != null)) {
            nombreItem = jTextField2.getText(); // Se obtiene el nombre del ítem
            try {
                numeroMesa = Integer.parseInt(jTextField1.getText()); // Se obtiene el número de mesa
                cantidad = Integer.parseInt(jTextField3.getText()); // Se obtiene la cantidad del ítem
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número de mesa o cantidad inválida");
            }

            // Verifica si la mesa existe
            if (Mesa.buscarBinario(numeroMesa) != null) {
                Mesa m = Mesa.buscarBinario(numeroMesa);

                // Verifica si el pedido de la mesa no está vacío
                if ((m.getPedidoMesa()) != null) {
                    // Verifica si el ítem es un plato existente
                    if (Plato.buscarBinario(nombreItem) != null) {
                        ItemPedido p = new ItemPedido(Plato.buscarBinario(nombreItem), cantidad);
                        elementosPedido.add(p);

                        listaPedidos = Pedido.listarBinario();
                        listaPedidos.add(new Pedido(elementosPedido));
                        Pedido.escribirBinario(listaPedidos);

                        // Pregunta si se quiere agregar otro ítem al pedido
                        respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro item al pedido?", "Agregar plato o producto", JOptionPane.YES_NO_OPTION);
                        agregarOtro = respuesta == JOptionPane.YES_OPTION;

                        // Si no se quiere agregar más, se agrega la mesa con el pedido
                        if (!agregarOtro) {
                            listaMesas = Mesa.listarBinario();
                            listaMesas.add(new Mesa(numeroMesa, new Pedido(elementosPedido)));
                            Mesa.escribirBinario(listaMesas);
                        }
                    }
                    // Verifica si el ítem es un producto existente
                    else if (Producto.buscarBinario(nombreItem) != null) {
                        ItemPedido p = new ItemPedido(Producto.buscarBinario(nombreItem), cantidad);
                        elementosPedido.add(p);

                        listaPedidos = Pedido.listarBinario();
                        listaPedidos.add(new Pedido(elementosPedido));
                        Pedido.escribirBinario(listaPedidos);

                        // Pregunta si se quiere agregar otro ítem al pedido
                        respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro item al pedido?", "Agregar plato o producto", JOptionPane.YES_NO_OPTION);
                        agregarOtro = respuesta == JOptionPane.YES_OPTION;

                        // Si no se quiere agregar más, se agrega la mesa con el pedido
                        if (!agregarOtro) {
                            listaMesas = Mesa.listarBinario();
                            listaMesas.add(new Mesa(numeroMesa, new Pedido(elementosPedido)));
                            Mesa.escribirBinario(listaMesas);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "No se encontró el plato o producto");
                        agregarOtro = false;
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "No se encontró el pedido");
                    agregarOtro = false;
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "No se encontró la mesa");
                agregarOtro = false;
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            agregarOtro = false;
        }
        jTextField2.setText("");
        jTextField3.setText("");
    }
    // Limpia los campos de texto después de finalizar la iteración del bucle
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}