/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/************************************************************************
Palabra de honor:
* No he discutido ni mostrado el código de mi programa con alguien que no sea mi compañero,
* Profesor o con el monitor asignado a este curso.
*
* No he utilizado código obtenido de otro u otros estudiantes,
* O cualquier otra fuente no autorizada, ya sea modificado o sin modificar.
*
* Si cualquier código o documentación utilizada en mi programa
* Fue obtenido de otra fuente, tal como un libro de texto o notas del curso
* debe ser claramente señalado con una cita apropiada en
* los comentarios de mi programa.
*
* &lt;Diego Andrés Martínez Florez – 0222120002; *
***********************************************************************/
package Front;

import Back.ClientePreferencial;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class ClientePreferencialModificar extends javax.swing.JPanel {

    /**
     * Creates new form ClientePreferencialNombre
     */
    public ClientePreferencialModificar() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Modificar datos de un cliente preferencial");

        jLabel2.setText("Número de tarjeta");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Actualizar datos");

        jLabel4.setText("Nombre");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Descuento");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

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
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    int tarjetaCliente=0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        // Se verifica si se ha ingresado un número de tarjeta
    if ((jTextField1.getText() != null)) {
        try {
            // Se intenta convertir el valor del campo a un número entero (número de tarjeta)
            tarjetaCliente = Integer.parseInt(jTextField1.getText());
        } catch (NumberFormatException e) {
            // Si el valor ingresado no es un número válido, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Número de tarjeta inválido");
        }
        // Se busca al cliente preferencial usando el número de tarjeta ingresado
        if (ClientePreferencial.buscarBinario(tarjetaCliente) != null) {
            // Si se encuentra al cliente, se establecen los valores de nombre y descuento en los campos correspondientes
            jTextField2.setText(ClientePreferencial.buscarBinario(tarjetaCliente).getNombre());
            jTextField3.setText(String.valueOf(ClientePreferencial.buscarBinario(tarjetaCliente).getDescuento()));
        } else {
            // Si no se encuentra al cliente, se muestra un mensaje indicando que no se encontró y se limpian los campos
            JOptionPane.showMessageDialog(null, "No se encontró al cliente");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        }
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // Se inicializan las variables para almacenar el nombre y el descuento del cliente
    String nombre = null;
    double descuento = 0;

    // Se verifica si se han ingresado valores en los campos de texto correspondientes al nombre y descuento
    if ((jTextField1.getText() != null) && (jTextField2.getText() != null)) {
        try {
            // Se intenta convertir el valor del campo de descuento a un número decimal
            descuento = Double.parseDouble(jTextField1.getText());
        } catch (NumberFormatException e) {
            // Si el valor ingresado para el descuento no es válido, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Descuento inválido");
        }

        // Se obtiene el nombre del cliente a partir de la búsqueda por el número de tarjeta
        nombre = ClientePreferencial.buscarBinario(tarjetaCliente).getNombre();

        // Se obtiene la lista de clientes preferenciales
        ArrayList<ClientePreferencial> clientes = ClientePreferencial.listarBinario();

        // Se recorre la lista de clientes preferenciales
        for (ClientePreferencial e : clientes) {
            // Si se encuentra al cliente correspondiente al número de tarjeta ingresado
            if (e.getTarjetaCliente() == tarjetaCliente) {
                // Se actualizan los valores de nombre y descuento del cliente
                e.setDescuento(descuento);
                e.setNombre(nombre);
                // Se detiene el bucle después de realizar la actualización
                break;
            }
        }

        // Se actualiza el archivo binario con los cambios realizados en la lista de clientes
        ClientePreferencial.escribirBinario(clientes);
        // Se muestra un mensaje indicando que los datos del cliente se han actualizado con éxito
        JOptionPane.showMessageDialog(null, "Datos del cliente actualizados con éxito");
    } else {
        // Si no se han ingresado valores en los campos de nombre y descuento, se muestra un mensaje de advertencia
        JOptionPane.showMessageDialog(null, "Debe ingresar un nombre y un descuento");
    }

    // Se limpian los campos de texto para futuros ingresos
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
