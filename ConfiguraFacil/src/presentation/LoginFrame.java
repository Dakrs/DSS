/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.ConfiguraFacil;
import business.gConta.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Pedro
 */
public class LoginFrame extends javax.swing.JFrame {

    private static ConfiguraFacil cf;


    private void info(int tipo, String nome){
        StringBuilder s = new StringBuilder();

        if(tipo == 1) s.append("Stand: \n").append("Bem-vindo, ").append(nome).append("!");
        else if(tipo == 2) s.append("Fábrica: \n").append("Bem-vindo, ").append(nome).append("!");
        else if(tipo == 3) s.append("Bem-vindo, Admin!");

        JOptionPane.showMessageDialog(new JFrame(), s, "Login Efetuado", JOptionPane.INFORMATION_MESSAGE);

    }

    private void login_btnActionPerformed(ActionEvent evt) throws Exception {
        int id = -1;
        String password = "";

        try{
            id = Integer.parseInt(id_txt.getText());
            password = new String(pw_txt.getPassword()).trim();
        }catch (Exception e){
            this.error_txt.setText("Insira os campos");
        }

        int tipo = cf.logIn(id, password);

        if(tipo == 1) {
            this.dispose();
            Funcionario f = cf.getFuncionario(id);
            info(1, f.getNome());
            new StandFrame(this.cf, f).setVisible(true);
        }
        else if(tipo == 2) {
            this.dispose();
            Funcionario f = cf.getFuncionario(id);
            info(2, f.getNome());
            new FabricaFrame(this.cf, f).setVisible(true);
        }
        else if(tipo == 3){
            this.dispose();
            info(3, "");
            new FuncionariosFrame(this.cf).setVisible(true);
        }
        else this.error_txt.setText("Credenciais Inválidas");
    }


    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Pedro Miguel Moreira Ferreira
    private void initComponents() {
        sair_btn = new JButton();
        id_txt = new JTextField();
        pw_txt = new JPasswordField();
        login_btn = new JButton();
        jLabel1 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        error_txt = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("LogIn");
        Container contentPane = getContentPane();

        //---- sair_btn ----
        sair_btn.setText("Sair");
        sair_btn.addActionListener(e -> sair_btnActionPerformed(e));

        //---- login_btn ----
        login_btn.setText("Log In");
        login_btn.addActionListener(e -> {
            try {
                login_btnActionPerformed(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        //---- jLabel1 ----
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/presentation/logo.png")));

        //---- label1 ----
        label1.setText("ID");

        //---- label2 ----
        label2.setText("Password");

        //---- error_txt ----
        error_txt.setText(" ");
        error_txt.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        error_txt.setForeground(Color.red);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(pw_txt, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                .addComponent(id_txt, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(sair_btn, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(login_btn)))))
                    .addContainerGap(54, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 98, Short.MAX_VALUE)
                    .addComponent(error_txt, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                    .addGap(89, 89, 89))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(id_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(pw_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addGap(2, 2, 2)
                    .addComponent(error_txt)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(login_btn)
                        .addComponent(sair_btn))
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void sair_btnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* INICIA CONFIGURA FACIL */

        cf = new ConfiguraFacil();


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Pedro Miguel Moreira Ferreira
    private JButton sair_btn;
    private JTextField id_txt;
    private JPasswordField pw_txt;
    private JButton login_btn;
    private JLabel jLabel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel error_txt;
    // End of variables declaration//GEN-END:variables
}
