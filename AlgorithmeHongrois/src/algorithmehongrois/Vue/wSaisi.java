/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * wSaisi.java
 *
 * Created on 6 mai 2011, 16:00:45
 */

package algorithmehongrois.Vue;

import algorithmehongrois.Controleur.LogiqueHongrois;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author dverstraete
 */
public class wSaisi extends javax.swing.JFrame {

    /** Creates new form wSaisi */
    public wSaisi()
    {
        initComponents();
    }

    /**
     * Constructeur de la fenêtre de saisie
     * @param dimension Dimension de la matrice de saisie
     */
    public wSaisi(int dimension) {
        initComponents();

        Object[][] lignes = new Object[dimension][dimension];

        String[] header = new String[dimension];

        for (int i= 0; i < dimension; i++) {
            header[i] = "Colonne " + i;
        }

        tableUtilisateur.setModel(
            new DefaultTableModel(
                lignes,
                header
            )
        );
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableUtilisateur = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiCalculer = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableUtilisateur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableUtilisateur);

        jMenu1.setText("File");

        jmiCalculer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jmiCalculer.setText("Calculer...");
        jmiCalculer.setToolTipText("Lance la résolution du problème");
        jmiCalculer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCalculerActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCalculer);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCalculerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCalculerActionPerformed
        // TODO add your handling code here:

        /* Vérifier que toutes les cases ont été remplies (et correctement ?) */
        int dimension = tableUtilisateur.getColumnCount();
        boolean estRempli = true;

        for (int i= 0; i < dimension; i++) {
            for (int j= 0; j < dimension; j++) {

                Object o = tableUtilisateur.getValueAt(i, j);

                if(tableUtilisateur.getValueAt(i, j) == null)
                {
                    estRempli = false;
                    i = dimension;
                    j = dimension;
                }
                // On gère quand l'utilisateur écrit puis efface
                else if(tableUtilisateur.getValueAt(i, j).toString().equals(""))
                {
                    estRempli = false;
                    i = dimension;
                    j = dimension;
                }
            }
        }

        if(estRempli)
        {
            /* Création de la matrice utilisateur */
            Integer[][] matrice = new Integer[dimension][dimension];

            for (int i= 0; i < dimension; i++) {
                for (int j= 0; j < dimension; j++) {
                    matrice[i][j] = Integer.valueOf(tableUtilisateur.getValueAt(i, j).toString()); 
                }
            }

            /* Affichage du résultat dans une nouvelle fenêtre */
            wResultat wresultat = new wResultat(matrice); 
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Merci de remplir toute la matrice !"); 
        }
    }//GEN-LAST:event_jmiCalculerActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wSaisi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmiCalculer;
    private javax.swing.JTable tableUtilisateur;
    // End of variables declaration//GEN-END:variables

}
