package br.uema.engcomp.apresentation;

import br.uema.engcomp.models.Usuario;
import br.uema.engcomp.models.query.QUsuario;
import org.jdesktop.beansbinding.BindingGroup;

import javax.swing.*;

public class JFrameUsuarios extends JFrame {


    /**
     * Creates new form JFrameUsuarios
     */
    public JFrameUsuarios() {
        initComponents();
    }

    BindingGroup bindingGroup;

    private void initComponents() {
        this.bindingGroup = new BindingGroup();

        //JavaApplicationAgendaJAVAPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("JavaApplicationAgendaJAVAPU").createEntityManager();
        //usuarioQuery = java.beans.Beans.isDesignTime() ? null : JavaApplicationAgendaJAVAPUEntityManager.createQuery("SELECT u FROM Usuario u");
        usuarioList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(new QUsuario().findList()); // usuarioQuery.getResultList()
        jButtonInserir = new javax.swing.JButton();
        jPasswordFieldConfirmSenha = new javax.swing.JPasswordField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelNome = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jLabelId = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonVerTarefas = new javax.swing.JButton();
        jTextFieldId = new javax.swing.JTextField();
        jLabelConfirmSenha = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuários");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jPasswordFieldConfirmSenha.setText("jPasswordField1");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableUsuarios, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.senha}"), jPasswordFieldSenha, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jPasswordFieldSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        jLabelNome.setText("Nome");

        jLabelSenha.setText("Senha");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabelId.setText("Id");

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonVerTarefas.setText("Ver tarefas");
        jButtonVerTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerTarefasActionPerformed(evt);
            }
        });

        jTextFieldId.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableUsuarios, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.id}"), jTextFieldId, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabelConfirmSenha.setText("Confirm. Senha");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableUsuarios, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), jTextFieldNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, usuarioList, jTableUsuarios);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${senha}"));
        columnBinding.setColumnName("Senha");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane2.setViewportView(jTableUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelNome)
                                                        .addComponent(jLabelSenha)
                                                        .addComponent(jLabelConfirmSenha)
                                                        .addComponent(jLabelId))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPasswordFieldConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButtonCancelar)
                                                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(95, 95, 95)
                                                .addComponent(jButtonVerTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonInserir)
                                        .addComponent(jButtonVerTarefas)
                                        .addComponent(jLabelId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSalvar)
                                        .addComponent(jLabelNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelSenha)
                                        .addComponent(jButtonCancelar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jPasswordFieldConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelConfirmSenha))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(rootPane, "Confirma a exclusão deste registro?") == JOptionPane.OK_OPTION) {
            try {
                Usuario usuario = new Usuario(); // Cria o objeto
                usuario.setId(Integer.valueOf(this.jTextFieldId.getText())); // Configura o id de exclusão
                if (usuario.delete()) { // Exclui o objeto do BD
                    int linhaSelecionada = this.jTableUsuarios.getSelectedRow(); // Marca linha selecionada da tabela
                    this.usuarioList.remove(this.jTableUsuarios.getSelectedRow()); // Remove objeto da lista
                    if (this.jTableUsuarios.getRowCount() > 0) { // Se houver linhas na tabela
                        if (linhaSelecionada > 0) {
                            linhaSelecionada--;
                        }
                        this.jTableUsuarios.setRowSelectionInterval(linhaSelecionada, linhaSelecionada); // Seleciona linha marcada
                    }

                    //Configura botões
                    this.jButtonInserir.setEnabled(true);
                    this.jButtonExcluir.setEnabled(this.jTableUsuarios.getRowCount() != 0);
                    this.jButtonCancelar.setEnabled(false);
                    this.jButtonSalvar.setEnabled(false);
                    this.jButtonVerTarefas.setEnabled(this.jTableUsuarios.getRowCount() != 0);

                    this.estado = Estado.CONSULTANDO;

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonVerTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerTarefasActionPerformed
        // TODO add your handling code here:
        // Busca usuário e passa-o para janela de tarefas
        Usuario usuario = new QUsuario().id.equalTo(Integer.valueOf(this.jTextFieldId.getText())).findOne();

        JFrameTarefas jFrameTarefas = new JFrameTarefas(usuario);
        jFrameTarefas.setLocationRelativeTo(null); // Janela no centro

        jFrameTarefas.setVisible(true);
    }//GEN-LAST:event_jButtonVerTarefasActionPerformed

    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        // TODO add your handling code here:
        this.jButtonInserir.setEnabled(false);
        this.jButtonExcluir.setEnabled(false);
        this.jButtonCancelar.setEnabled(true);
        this.jButtonSalvar.setEnabled(true);
        this.jButtonVerTarefas.setEnabled(this.jTableUsuarios.getRowCount() != 0);

        if (this.estado == Estado.CONSULTANDO) {
            if (this.jTableUsuarios.getRowCount() != 0) {
                this.estado = Estado.EDITANDO;
            } else {
                this.jButtonInserirActionPerformed(null);
            }
        }
    }//GEN-LAST:event_jTextFieldNomeKeyPressed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        try {
            if (this.estado == Estado.INSERINDO) {
                this.usuarioList.remove(this.jTableUsuarios.getSelectedRow()); // Remove objeto inserido na lista
                if (this.jTableUsuarios.getRowCount() > 0) { // Se houver objetos na lista
                    // Seleciona o último da lista
                    this.jTableUsuarios.setRowSelectionInterval(this.jTableUsuarios.getRowCount() - 1, this.jTableUsuarios.getRowCount() - 1);
                }
            } else {
                Usuario usuario = new QUsuario().id.equalTo(Integer.valueOf(this.jTextFieldId.getText())).findOne();
                if (usuario.getId() != null) {
                    this.jTextFieldNome.setText(usuario.getNome());
                    this.jPasswordFieldSenha.setText(usuario.getSenha());
                }

            }

            //Configura botões
            this.jButtonInserir.setEnabled(true);
            this.jButtonExcluir.setEnabled(this.jTableUsuarios.getRowCount() != 0);
            this.jButtonCancelar.setEnabled(false);
            this.jButtonSalvar.setEnabled(false);
            this.jButtonVerTarefas.setEnabled(this.jTableUsuarios.getRowCount() != 0);
            this.estado = Estado.CONSULTANDO;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        // TODO add your handling code here:
        Usuario usuario = new Usuario();
        this.usuarioList.add(usuario);

        // Seleciona objeto inserido na lista e estabelece foco
        this.jTableUsuarios.setRowSelectionInterval(this.jTableUsuarios.getRowCount() - 1, this.jTableUsuarios.getRowCount() - 1);
        this.jTextFieldNome.requestFocus();

        //Configura botões
        this.jButtonInserir.setEnabled(false);
        this.jButtonExcluir.setEnabled(false);
        this.jButtonCancelar.setEnabled(true);
        this.jButtonSalvar.setEnabled(true);
        this.jButtonVerTarefas.setEnabled(false);

        this.estado = Estado.INSERINDO;
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        try {
            if (this.jPasswordFieldSenha.getPassword().equals(this.jPasswordFieldConfirmSenha.getPassword())) {
                // Cria e configura o objeto
                Usuario usuario = new Usuario();


                if (this.estado == Estado.INSERINDO) {

                    // Atualiza o objeto
                    usuario.setNome(this.jTextFieldNome.getText());
                    usuario.setSenha(this.jPasswordFieldSenha.getPassword().toString());
                    try {

                        // Retira o objeto da lista e o adiciona com o id
                        this.usuarioList.remove(this.jTableUsuarios.getSelectedRow());
                        this.usuarioList.add(usuario);

                        // Seleciona o último da lista
                        this.jTableUsuarios.setRowSelectionInterval(this.jTableUsuarios.getRowCount() - 1, this.jTableUsuarios.getRowCount() - 1);
                        this.jButtonInserir.setEnabled(true);
                        this.jButtonExcluir.setEnabled(this.jTableUsuarios.getRowCount() != 0);
                        this.jButtonCancelar.setEnabled(false);
                        this.jButtonSalvar.setEnabled(false);
                        this.jButtonVerTarefas.setEnabled(this.jTableUsuarios.getRowCount() != 0);

                        this.estado = Estado.CONSULTANDO;
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(rootPane, e);
                    }
                } else {
                    // Encontra e carrega o objeto de atualização

                    if (usuario.getId().equals(new QUsuario().id.equalTo(Integer.valueOf(this.jTextFieldId.getText())).findOne().getId())) {

                        // Atualiza o objeto
                        usuario.setNome(this.jTextFieldNome.getText());
                        usuario.setSenha(this.jPasswordFieldSenha.getPassword().toString());

                        try{
                            usuario.update();

                            // Seleciona o último da lista
                            this.jButtonInserir.setEnabled(true);
                            this.jButtonExcluir.setEnabled(this.jTableUsuarios.getRowCount() != 0);
                            this.jButtonCancelar.setEnabled(false);
                            this.jButtonSalvar.setEnabled(false);
                            this.jButtonVerTarefas.setEnabled(this.jTableUsuarios.getRowCount() != 0);

                            this.estado = Estado.CONSULTANDO;
                        } catch (Exception e){
                            JOptionPane.showMessageDialog(rootPane, e);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Confirmação de senha não coincidente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if (this.jTableUsuarios.getRowCount() > 0) { // Se houver linhas na lista
            this.jTableUsuarios.setRowSelectionInterval(0, 0); // Seleciona linha 0
        }

        // Configura botões
        this.jButtonInserir.setEnabled(true);
        this.jButtonExcluir.setEnabled(this.jTableUsuarios.getRowCount() != 0);
        this.jButtonCancelar.setEnabled(false);
        this.jButtonSalvar.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameUsuarios().setVisible(true);
            }
        });
    }

    private enum Estado {

        INSERINDO,
        EDITANDO,
        CONSULTANDO
    }

    private Estado estado = Estado.CONSULTANDO;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVerTarefas;
    private javax.swing.JLabel jLabelConfirmSenha;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPasswordField jPasswordFieldConfirmSenha;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNome;
    private java.util.List<Usuario> usuarioList;
    private javax.persistence.Query usuarioQuery;
}
