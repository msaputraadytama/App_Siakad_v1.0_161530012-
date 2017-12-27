package Forms;

import Tools.KoneksiDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class IfrLapMahasiswa extends javax.swing.JInternalFrame {

    KoneksiDB getCnn = new KoneksiDB();
    Connection _Cnn;
    String sqlselect, vkd_prodi, vprodi, vfoto;
    

    public IfrLapMahasiswa() {
        initComponents();
        
        listProdi();
    }
    
    String[] KeyProdi;
    private void listProdi(){
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sqlselect = "select kd_prodi, prodi"
                    + " from tbprodi order by kd_jur asc";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            cmbProdi.removeAllItems();
            cmbProdi.repaint();
            cmbProdi.addItem("-- Pilih --");
            int i = 1;
            while(res.next()){
                cmbProdi.addItem(res.getString(2));
                i++;
            }
            res.first();
            KeyProdi = new String[i+1];
            for(Integer x = 1;x < i;x++){
                KeyProdi[x] = res.getString(1);
                res.next();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method listProdi() : " 
                    + ex, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void cetakLaporan1(){
        String pth = System.getProperty("user.dir") + "/reports/rpMahasiswa1.jrxml";
        String logo = System.getProperty("user.dir") + "/reports/";
        try{
            Map<String, Object> parameters = new HashMap<>();
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            parameters.put("Foto", logo);
            JasperReport jrpt = JasperCompileManager.compileReport(pth);
            JasperPrint jprint = JasperFillManager.fillReport(jrpt, parameters, _Cnn);
            
            JasperViewer.viewReport(jprint, false);
            
        }catch(SQLException | JRException ex){
            JOptionPane.showMessageDialog(this, "Error method cetakLaporanMahasiswa1() : " 
                    + ex, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void cetakLaporan2(){
        String pth = System.getProperty("user.dir") + "/reports/rpMahasiswa2.jrxml";
        String logo = System.getProperty("user.dir") + "/reports/";
        vkd_prodi = KeyProdi[cmbProdi.getSelectedIndex()];
        try{
            Map<String, Object> parameters = new HashMap<>();
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            parameters.put("parLogo", logo);
            parameters.put("parKdProdi", vkd_prodi);
            JasperReport jrpt = JasperCompileManager.compileReport(pth);
            JasperPrint jprint = JasperFillManager.fillReport(jrpt, parameters, _Cnn);
            
            JasperViewer.viewReport(jprint, false);
            
        }catch(SQLException | JRException ex){
            JOptionPane.showMessageDialog(this, "Error method cetakLaporanMahasiswa1() : " 
                    + ex, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmbProdi = new javax.swing.JComboBox<>();
        btnCetak2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCetak1 = new javax.swing.JButton();

        setClosable(true);
        setTitle(".: Form Laporan Mahasiswa");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        jLabel3.setText("Laporan Mahasiswa");

        jLabel4.setText("Form ini digunakan untuk mencetak laporan mahasiswa");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Cetak Per Prodi : "));
        jPanel1.setOpaque(false);

        cmbProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));
        cmbProdi.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Program Studi : "));
        cmbProdi.setOpaque(false);

        btnCetak2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/print_preview.png"))); // NOI18N
        btnCetak2.setText("Cetak");
        btnCetak2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetak2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbProdi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCetak2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbProdi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnCetak2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Cetak Semua Data Mahasiswa :"));
        jPanel2.setOpaque(false);

        btnCetak1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/print_preview.png"))); // NOI18N
        btnCetak1.setText("Cetak");
        btnCetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetak1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCetak1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCetak1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetak1ActionPerformed
        cetakLaporan1();
    }//GEN-LAST:event_btnCetak1ActionPerformed

    private void btnCetak2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetak2ActionPerformed
        if(cmbProdi.getSelectedIndex()<=0){
            JOptionPane.showMessageDialog(this, "Anda belum memilih prodi", 
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            cetakLaporan2();
        }
    }//GEN-LAST:event_btnCetak2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak1;
    private javax.swing.JButton btnCetak2;
    private javax.swing.JComboBox<String> cmbProdi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}