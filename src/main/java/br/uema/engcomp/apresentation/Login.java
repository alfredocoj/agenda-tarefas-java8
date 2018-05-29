package br.uema.engcomp.apresentation;

import br.uema.engcomp.models.Usuario;
import br.uema.engcomp.models.query.QUsuario;

import javax.swing.*;

public class Login extends JFrame {
    private javax.swing.JButton jButtonConfirma;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldNome;
    private int contadorTentativas = 1;
    private Usuario usuario;

    public Login() {
        initComponents();
    }

    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonConfirma = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabelNome.setText("Nome");

        jLabelSenha.setText("Senha");

        jPasswordFieldSenha.setText("jPasswordField1");

        jButtonConfirma.setText("Confirma");
        jButtonConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButtonConfirma)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelSenha)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jPasswordFieldSenha))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelNome)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNome)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelSenha)
                                        .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jButtonConfirma)
                                .addGap(21, 21, 21))
        );

        pack();
    }

    private void jButtonConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmaActionPerformed
        // TODO add your handling code here:
        if (this.validoLogin()) {
            this.dispose();
            JFrameAgenda jFrameAgenda = new JFrameAgenda();
            jFrameAgenda.setUsuario(this.usuario);
            jFrameAgenda.setLocationRelativeTo(null);
            jFrameAgenda.setVisible(true);
        } else {
            this.contadorTentativas++;
            JOptionPane.showMessageDialog(rootPane, "Senha errada");
        }

        if (this.contadorTentativas > 3) {
            JOptionPane.showMessageDialog(rootPane, "Erro inicie novamente");
            this.dispose();
        }
    }

    public boolean validoLogin() {
        this.usuario = new QUsuario().nome.equalTo("admin").findOne(); //usuario.encontradoNome("admin"); // Cria o usuário
        if (this.usuario == null) { // Se não encontrado o usuário admin
            usuario.setNome("Admin"); // Configura o nome (não pode ser duplicado)
            usuario.setSenha("admin"); // Configura uma senha
            usuario.save();// Cria um usuário administrador
            if (usuario.getId()!=null) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível criar usuário administrador");
            }
        }
        this.usuario = new QUsuario().nome.equalTo(this.jTextFieldNome.getText()).findOne();//usuario.encontradoNome(this.jTextFieldNome.getText());
        String nome = this.jTextFieldNome.getText();
        String senha = new String (this.jPasswordFieldSenha.getPassword());
        return nome.equalsIgnoreCase(this.usuario.getNome()) && senha.equals(this.usuario.getSenha());
    }
}
