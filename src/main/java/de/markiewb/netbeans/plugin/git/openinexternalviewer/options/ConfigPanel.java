/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.markiewb.netbeans.plugin.git.openinexternalviewer.options;

import de.markiewb.netbeans.plugin.git.openinexternalviewer.Options;
import java.awt.Rectangle;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.prefs.Preferences;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.openide.awt.HtmlBrowser;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;

@org.netbeans.spi.options.OptionsPanelController.Keywords(location = "Team", tabTitle = "Open URL of GIT repository hoster", keywords = {"git", "repo", "repository", "url"})
final class ConfigPanel extends javax.swing.JPanel {

    private final ConfigOptionsPanelController controller;

    ConfigPanel(final ConfigOptionsPanelController controller) {
        this.controller = controller;
        initComponents();

        jEditorPane1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                controller.changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                controller.changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                controller.changed();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReset = new javax.swing.JButton();
        btnVisitHomePage = new javax.swing.JLabel();
        btnDonate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        org.openide.awt.Mnemonics.setLocalizedText(btnReset, org.openide.util.NbBundle.getMessage(ConfigPanel.class, "ConfigPanel.btnReset.text")); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnVisitHomePage, org.openide.util.NbBundle.getMessage(ConfigPanel.class, "ConfigPanel.btnVisitHomePage.text")); // NOI18N
        btnVisitHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVisitHomePageMouseClicked(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnDonate, org.openide.util.NbBundle.getMessage(ConfigPanel.class, "ConfigPanel.btnDonate.text")); // NOI18N
        btnDonate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDonateMouseClicked(evt);
            }
        });

        jEditorPane1.setContentType("text/x-properties"); // NOI18N
        jScrollPane1.setViewportView(jEditorPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisitHomePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDonate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVisitHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDonate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisitHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVisitHomePageMouseClicked
        try {
            HtmlBrowser.URLDisplayer.getDefault().showURLExternal(new URL("https://github.com/markiewb/nb-git-open-in-external-repoviewer/"));
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_btnVisitHomePageMouseClicked

    private void btnDonateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDonateMouseClicked
        try {
            HtmlBrowser.URLDisplayer.getDefault().showURLExternal(new URL("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=K4CMP92RZELE2"));
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_btnDonateMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        String defaultConfig = Options.getDefaultConfig();
        setConfigText(defaultConfig);
    }//GEN-LAST:event_btnResetActionPerformed

    void load() {
        Preferences pref = NbPreferences.forModule(Options.class);

        String text = new Options().load(pref);
        setConfigText(text);
    }

    public void setConfigText(String text) {
        this.jEditorPane1.setText(text);
        //scroll to top
        this.jEditorPane1.scrollRectToVisible(new Rectangle());
    }

    void store() {
        new Options().persist(this.jEditorPane1.getText());
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDonate;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel btnVisitHomePage;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
