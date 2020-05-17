import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Module2 extends javax.swing.JFrame {


    public Module2() {
        
        initComponents();
    }
    
    int i_gd, i_ld, i_hash;
    Ext_Hash_1 ins = new Ext_Hash_1();
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        M2Insert = new javax.swing.JLabel();
        M2Search = new javax.swing.JLabel();
        M2InsertTF = new javax.swing.JTextField();
        M2SearchTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        M2GlobalDepthTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        M2HashFunctionTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        M2initialLDTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        HashValueTFM2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Box = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Module 2");

        M2Insert.setText("Insert: ");

        M2Search.setText("Search:");

        M2InsertTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M2InsertTFActionPerformed(evt);
            }
        });
        M2InsertTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                M2InsertTFKeyPressed(evt);
            }
        });

        M2SearchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                M2SearchTFKeyPressed(evt);
            }
        });

        jLabel1.setText("Global Depth:");

        //Ext_Hash_1 gd_value = new Ext_Hash_1();
        //int gd = gd_value.glob_depth;
        //String gd_d = Integer.toString(gd);
        //M2GlobalDepthTF.setText(gd_d);
        M2GlobalDepthTF.setToolTipText("");
        M2GlobalDepthTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M2GlobalDepthTFActionPerformed(evt);
            }
        });
        M2GlobalDepthTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                M2GlobalDepthTFKeyPressed(evt);
            }
        });

        jLabel2.setText("Hash Function:");

        M2HashFunctionTF.setText("k%10");
        M2HashFunctionTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                M2HashFunctionTFKeyPressed(evt);
            }
        });

        jLabel4.setText("Initial LD:");

        M2initialLDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M2initialLDTFActionPerformed(evt);
            }
        });
        M2initialLDTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                M2initialLDTFKeyPressed(evt);
            }
        });

        jLabel5.setText("Hash Value:");

        Box.setColumns(20);
        Box.setRows(5);
        jScrollPane1.setViewportView(Box);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Module1");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Module2");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(M2HashFunctionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(M2Insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(M2InsertTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(M2Search, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(M2SearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(M2GlobalDepthTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HashValueTFM2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(M2initialLDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(M2Insert)
                    .addComponent(M2InsertTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(M2HashFunctionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(M2Search)
                    .addComponent(M2SearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(M2GlobalDepthTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(HashValueTFM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(M2initialLDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        EntryScreen n = new EntryScreen();
        n.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Module1 n = new Module1();
        n.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Module2 n = new Module2();
        n.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void M2InsertTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M2InsertTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_M2InsertTFActionPerformed

    /**************************************************************************************************/
    int InsertNo;
    int hv;
    String hv_s, s_M2, dir_M2;
    int ans;
            
    int ld_M2;
    String inpptext;
    private void M2InsertTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M2InsertTFKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            Box.setText("");
            inpptext = M2InsertTF.getText();
            if(inpptext.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Cannot enter empty string!");
            }
            else
            {
                InsertNo = Integer.parseInt(inpptext);
                hv = InsertNo%10;
                hv_s = Integer.toString(hv);
                HashValueTFM2.setText(hv_s);

                ins.a[ins.ind++] = InsertNo;        //as soon as number is inserted
                ins.insert(InsertNo);
                s_M2 = ins.get_binary(InsertNo % 10);		//binary String of hash
                dir_M2 = ins.get_directory(s_M2);		//directory of element
                ld_M2 = ins.get_loc_depth(dir_M2);
                
                
         /*       for(int i=0; i<8; i++)
                {
                    Box.append(ins.loc_depth[i] + "\n");
                }
           
        */
            Box.setText("global depth : " + ins.glob_depth + "\nDirectory\tBucket No.\tBucket\t\tlocal depth\n");    
            for(int i=0; i<Math.pow(2,ins.glob_depth); i++)
            {
                String k = ins.get_binary(i);
                
                Box.append(k + "\t");
                
               // Box.append(String.valueOf(i) + "\t");
               //bucket no in binary, last local digits
               int x = i;
		String buckno = "";
		for(int j = 0; j < ins.loc_depth[i]; j++)
		{
			if(x % 2 == 1)
				buckno = "1" + buckno;
			else
				buckno = "0" + buckno;
			x /= 2;
		}   
		Box.append("   " + buckno + "\t");
                for(int j=0; j<ins.bfr; j++)
                {
                    if(ins.bucket[i][j] == ins.emp)
                    {
                        Box.append("  ");
                    }
                    else
                    {
                        Box.append(String.valueOf(ins.bucket[i][j] + " "));
                    }
                }
                
                Box.append("\t\t");
                
                Box.append("    " + ins.loc_depth[i] + "\n");
                
            }
            

                //Clear the textfield
                M2InsertTF.setText("");
                }

            }
    }//GEN-LAST:event_M2InsertTFKeyPressed

    private void M2SearchTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M2SearchTFKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            String searchinp = M2SearchTF.getText();
            int SearchNo = Integer.parseInt(searchinp);
            if(searchinp.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Cannot enter empty string!");
            }
            
            else{
                
                boolean s_result = ins.search(SearchNo);
                if(s_result == true)
                {
                    int x = SearchNo;		//copy number
                    String s = ins.get_binary(x % 10);		//binary String of hash
                    String dir = ins.get_directory(s);		//directory of element
                    int ld = ins.get_loc_depth(dir);		//local depth of required bucket
                    int buck = ins.get_bucket(ld, dir);
                    JOptionPane.showMessageDialog(null, "Hello search num " + SearchNo + "\nYou are at bucket no: " + buck);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Not found!");
                }
            }
            
            
            
        }
    }//GEN-LAST:event_M2SearchTFKeyPressed

    private void M2GlobalDepthTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M2GlobalDepthTFActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_M2GlobalDepthTFActionPerformed

    private void M2GlobalDepthTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M2GlobalDepthTFKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            String inp_gd = M2GlobalDepthTF.getText();
            i_gd = Integer.parseInt(inp_gd);    //as the input contains only numbers, string is converted to int
            ins.glob_depth = i_gd;
            JOptionPane.showMessageDialog(null, "Global Depth Entered is: " + i_gd);
        }
        
        
        
    }//GEN-LAST:event_M2GlobalDepthTFKeyPressed

    private void M2initialLDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M2initialLDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_M2initialLDTFActionPerformed

    private void M2HashFunctionTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M2HashFunctionTFKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String inp_hash = M2HashFunctionTF.getText();
          
            //BT: take the integers from the string k%23142412
            String inp_hashno_str = "";
            for(int j=2; j<inp_hash.length(); j++)
            {
                inp_hashno_str = inp_hashno_str + inp_hash.charAt(j);
            }
            
            i_hash = Integer.parseInt(inp_hashno_str);
            ins.hash_mod = i_hash;
//  int hash_modby = inp_hash.charAt(3) - '0'; 
            
            JOptionPane.showMessageDialog(null, "Key entered is: " + i_hash);
            
            
        }
        
    }//GEN-LAST:event_M2HashFunctionTFKeyPressed

    private void M2initialLDTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M2initialLDTFKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            String inp_ld = M2initialLDTF.getText();
            i_ld = Integer.parseInt(inp_ld);      //as the input contains only numbers, string is converted to int
            
            
            for(int i=0; i< ins.max_size; i++)
            {
                ins.loc_depth[i] = i_ld;
            }
            
            JOptionPane.showMessageDialog(null, "Initial Local Depth Entered: " + i_ld);
        }
    }//GEN-LAST:event_M2initialLDTFKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Module2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Module2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Box;
    public javax.swing.JTextField HashValueTFM2;
    private javax.swing.JTextField M2GlobalDepthTF;
    private javax.swing.JTextField M2HashFunctionTF;
    private javax.swing.JLabel M2Insert;
    private javax.swing.JTextField M2InsertTF;
    private javax.swing.JLabel M2Search;
    private javax.swing.JTextField M2SearchTF;
    private javax.swing.JTextField M2initialLDTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private Ext_Hash_1 Ext_Hash_1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}