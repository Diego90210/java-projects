/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Front;

import Back.Producto;
import Back.Plato;
import Back.ItemMenu;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class MenuModificarItem extends javax.swing.JPanel {
    String nombreP;

    /**
     * Creates new form MenuModificarItem
     */
    public MenuModificarItem() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Modificar detalles de un producto o plato ");

        jLabel2.setText("Nombre");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Actualizar datos");

        jLabel4.setText("Nombre");

        jLabel5.setText("Precio");

        jLabel6.setText("Disponibilidad");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Si");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("No");

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel3)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2)))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       // Se declara la variable para almacenar el nombre
    String nombre = null;

    // Verifica si el campo de texto está vacío para el nombre del producto o plato
    if (jTextField1.getText().isEmpty()) {
        // Si está vacío, muestra un mensaje indicando que se debe proporcionar el nombre del producto o plato
        JOptionPane.showMessageDialog(null, "Debe proporcionar el nombre del producto o plato");
    } else {
        // Si se ha ingresado un nombre, se asigna a la variable correspondiente
        nombre = jTextField1.getText();
        nombreP = jTextField1.getText(); // Posible error de declaración previa de nombreP fuera de este fragmento de código

        // Se busca el nombre tanto en la lista de platos como en la lista de productos
        Plato p1 = Plato.buscarBinario(nombre);
        Producto p2 = Producto.buscarBinario(nombre);

        // Si se encuentra el nombre en la lista de platos, se muestran los detalles del plato en los campos de texto correspondientes
        if (p1 != null) {
            jTextField2.setText(p1.getNombre());
            jTextField3.setText(String.valueOf(p1.getPrecio()));
        }
        // Si se encuentra el nombre en la lista de productos, se muestran los detalles del producto en los campos de texto correspondientes
        else if (p2 != null) {
            jTextField2.setText(p2.getNombre());
            jTextField3.setText(String.valueOf(p2.getPrecio()));
        }
        // Si no se encuentra el nombre ni en platos ni en productos, muestra un mensaje indicando que no se encontró el producto o plato
        else {
            JOptionPane.showMessageDialog(null, "No se encontró el producto o plato");
        }
    }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        // Se declara una bandera como verdadera por defecto
    boolean bandera = true;

    // Se verifica si no se ha seleccionado ningún botón en el grupo de botones
    if (buttonGroup1.getSelection() == null) {
        bandera = false; // Si no se ha seleccionado, se cambia la bandera a falso
    }

    // Se verifica si los campos de texto están vacíos o si la bandera está en falso
    if (((jTextField2.getText().isEmpty()) || (jTextField3.getText().isEmpty()) || (!bandera))) {
        JOptionPane.showMessageDialog(null, "Debe Llenar todos los campos");
    } else {
        // Si todos los campos están completos, se procede a buscar el nombre del plato o producto en los archivos correspondientes
        // Si se encuentra, se aplicarán las modificaciones realizadas por el usuario.

        String nombre = jTextField2.getText(); // Se obtiene el nombre ingresado
        double precio = Double.parseDouble(jTextField3.getText()); // Se obtiene el precio ingresado
        ItemMenu p1; // Objeto para almacenar el plato o producto encontrado
        ArrayList<Plato> listaPlatos = null; // Lista de platos
        ArrayList<Producto> listaProductos = null; // Lista de productos

        // Se busca el nombre del plato o producto en el archivo correspondiente
        if ((p1 = Plato.buscarBinario(nombreP)) != null) { // Si se encuentra en la lista de platos
            listaPlatos = Plato.listarBinario(); // Se obtiene la lista de platos

            // Se recorre la lista de platos para realizar las modificaciones en el plato correspondiente
            for (Plato p : listaPlatos) {
                if (nombreP.equals(p.getNombre())) {
                    p.setNombre(nombre);
                    p.setPrecio(precio);
                    p.setDisponible(jRadioButton1.getModel().isSelected());
                    break;
                }
            }

            Plato.escribirBinario(listaPlatos); // Se escriben las modificaciones en el archivo de platos
            JOptionPane.showMessageDialog(null, "Cambio realizado con éxito");
        } else { // Si no se encuentra en la lista de platos
            listaProductos = Producto.listarBinario(); // Se obtiene la lista de productos

            // Se recorre la lista de productos para realizar las modificaciones en el producto correspondiente
            for (Producto p : listaProductos) {
                if (nombreP.equals(p.getNombre())) {
                    p.setNombre(nombre);
                    p.setPrecio(precio);
                    p.setDisponible(jRadioButton1.getModel().isSelected());
                    break;
                }
            }

            JOptionPane.showMessageDialog(null, "Cambio realizado con éxito");
            Producto.escribirBinario(listaProductos); // Se escriben las modificaciones en el archivo de productos
        }
    }

    // Se limpian los campos de texto después de realizar las operaciones
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}