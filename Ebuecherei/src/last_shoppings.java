import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class last_shoppings extends javax.swing.JFrame {

    int customer_id = new login().customer_id;
    
    public last_shoppings() {
        initComponents();
        
        show_lastShoppings_live();
        System.out.println(customer_id);
        
        //puts the window in the middle of the screen
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        last_shopping_table = new javax.swing.JTable();
        back_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        book_name_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LAST SHOPPINGS");

        last_shopping_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Basket ID", "Total Price", "Shopping Date"
            }
        ));
        last_shopping_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                last_shopping_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(last_shopping_table);

        back_icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\pc\\Desktop\\Tulpar için\\Udemy Courses\\SQL\\E-Bücherei Project\\icons\\back.png")); // NOI18N
        back_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_iconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back_iconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back_iconMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Bought Books");

        book_name_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Name"
            }
        ));
        jScrollPane2.setViewportView(book_name_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_icon)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(back_icon)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_iconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_iconMouseEntered
        Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
        back_icon.setBorder(border);
    }//GEN-LAST:event_back_iconMouseEntered

    private void back_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_iconMouseExited
        back_icon.setBorder(null);
    }//GEN-LAST:event_back_iconMouseExited

    private void back_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_iconMouseClicked
        dispose();
        new basket().setVisible(true);
    }//GEN-LAST:event_back_iconMouseClicked

    private void last_shopping_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_last_shopping_tableMouseClicked
        
        DefaultTableModel model = (DefaultTableModel)book_name_table.getModel();
            model.setRowCount(0);
        String SQL_expression = "SELECT book_name FROM book INNER JOIN shoppingbasket_book "
                + "ON book.book_isbn = shoppingbasket_book.book_isbn WHERE sb_id=?";
        
        try {
            postresql_db_connection db_connection = new postresql_db_connection();
            PreparedStatement st = db_connection.connect().prepareStatement(SQL_expression);
            ResultSet rs;
            
                int selected_row = last_shopping_table.getSelectedRow();
                st.setInt(1, (int) last_shopping_table.getValueAt(selected_row, 0));
                
            rs = st.executeQuery();
            
            while(rs.next()){
                model.addRow(new Object[] {rs.getString("book_name")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_last_shopping_tableMouseClicked

    void show_lastShoppings_live(){
        
        ArrayList<last_shopping> last_shopping_list = get_last_bought_book_datas();
        DefaultTableModel model = (DefaultTableModel)last_shopping_table.getModel();
            model.setRowCount(0);
        Object[] row = new Object[3];
        
        for(int i=0; i<last_shopping_list.size();i++){
            
            row[0] = last_shopping_list.get(i).getBasket_id();
            row[1] = last_shopping_list.get(i).getTotal_price();
            row[2] = last_shopping_list.get(i).getShopping_date();
            
            //with this method we allow to all bought book datas live existing in the database based on customer_id
            model.addRow(row);
        }
    }
    
    ArrayList<last_shopping> get_last_bought_book_datas(){
        
        ArrayList<last_shopping> last_shopping_list = new ArrayList<>();
        
        String SQLExpression = "SELECT shoppingbasket.sb_id,sb_total_price,transport_date FROM shoppingbasket " +
                                "INNER JOIN transport ON shoppingbasket.sb_id = transport.sb_id WHERE customer_id = ?";
        
        try {
            postresql_db_connection db_connection = new postresql_db_connection();
            PreparedStatement st = db_connection.connect().prepareStatement(SQLExpression);
            ResultSet rs;
            st.setInt(1, customer_id);
            rs = st.executeQuery();
            //an object from last_shopping class so that we can save all bought book datas existing in database
            last_shopping last_shopping;
            
            while(rs.next()){
                last_shopping = new last_shopping(rs.getInt("sb_id"),rs.getInt("sb_total_price"),rs.getString("transport_date"));
                last_shopping_list.add(last_shopping);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return last_shopping_list;
    }
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
            java.util.logging.Logger.getLogger(last_shoppings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(last_shoppings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(last_shoppings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(last_shoppings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new last_shoppings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_icon;
    private javax.swing.JTable book_name_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable last_shopping_table;
    // End of variables declaration//GEN-END:variables
}
