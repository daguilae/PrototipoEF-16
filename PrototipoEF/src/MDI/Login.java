/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDI;

import MDI.mdi_Principal;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Flores
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form f_Login
     */
    public void get_fecha() {
        //Obtenemos la fecha
        Calendar c1 = Calendar.getInstance();
        fecha.setCalendar(c1);
    }

    public void get_usuario() {
        try {
            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("CALL `ef`.`buscar_usuario`(?)");
            pst.setString(1, txtUsuario.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                lbusu.setText(rs.getString("id_usuario"));

            }
        } catch (Exception e) {

        }
    }

    public void bitacora_inicio() {
        
        //Desciframos la fecha
        java.util.Date fechaN = fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);

        //Obtenemos la hora
        Calendar timec = Calendar.getInstance();

        int hora = timec.get(Calendar.HOUR_OF_DAY);
        int minutos = timec.get(Calendar.MINUTE);
        int segundos = timec.get(Calendar.SECOND);

        String time = hora + ":" + minutos + ":" + segundos;

        try {

            Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, txtUsuario.getText());
            pst.setString(3, "Ingresó a la plataforma");
            pst.setString(4, dateN.toString());
            pst.setString(5, time);

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(900, 635);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        txtUsuario.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtContraseña.setBackground(new java.awt.Color(0, 0, 0, 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pass = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        lbusu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        fondo_login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Login/Usuario.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Login/pass.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Base de Datos I");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 310, 80));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Sistema Hotelería");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 360, 80));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Grupo 2");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 170, 80));

        btnRegistrar.setBackground(new java.awt.Color(102, 255, 153));
        btnRegistrar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnRegistrar.setText("Iniciar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 80, 30));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(204, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 80, 30));

        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setToolTipText("Ingrese su usuario");
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtUsuario.setOpaque(false);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 216, -1));

        txtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        txtContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtContraseña.setOpaque(false);
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyTyped(evt);
            }
        });
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 216, -1));

        fondo_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_Login/TemaNegro.jpg"))); // NOI18N
        jPanel1.add(fondo_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        String nombre = new String();
        String contra = new String();
        String no = new String();
        String co = new String();
        if (txtUsuario.getText().trim().isEmpty() || txtContraseña.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                Connection cn = DriverManager.getConnection(mdi_Principal.BD, mdi_Principal.Usuario, mdi_Principal.Contraseña);
                PreparedStatement pst = cn.prepareStatement("CALL `ef`.`buscar_usuario`(?)");
                pst.setString(1, txtUsuario.getText().trim());

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    nombre = rs.getString("id_usuario");
                    contra = rs.getString("password_usuario");
                    co = txtContraseña.getText();

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña no registrada.");
                    txtContraseña.setText("");
                    txtUsuario.setText("");
                }
                if (txtUsuario.getText().equals(nombre) && co.equals(contra)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido\n", "Mensaje de bienvenida", JOptionPane.INFORMATION_MESSAGE);
                   //bitacora_inicio();
                    mdi_Principal principal = new mdi_Principal();
                    mdi_Principal.labelusuario.setText(nombre);
                    mdi_Principal.labelc.setText(contra);
                    principal.setVisible(true);
                    this.dispose();

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ERROR AL ENCONTRAR USUARIO o CONTRASEÑA", "ERROR", JOptionPane.ERROR_MESSAGE);
                txtContraseña.setText("");
                txtUsuario.setText("");
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtContraseña.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        int limite = 20;
        if (txtUsuario.getText().length() >= limite) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Llegó al máximo de caracteres", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void txtContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyTyped
        int limite = 35;
        if (txtContraseña.getText().length() >= limite) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Llegó al máximo de caracteres", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_txtContraseñaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel fondo_login;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbusu;
    private javax.swing.JLabel pass;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
