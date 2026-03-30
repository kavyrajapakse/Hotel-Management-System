/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import gui.CRM.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import model.MySQL;

/**
 *
 * @author Kavithma
 */
public class Analytics extends javax.swing.JPanel {

    private JPanel chartPanel1, chartPanel2, chartPanel3, chartPanel4;

    /**
     * Creates new form Guests
     */
    public Analytics() {
        initComponents();
        kGradientPanel4.setLayout(new BorderLayout());
        setupChartPanels();
        loadCharts();

//         loadGuests();
    }

    private void setupChartPanels() {
        chartPanel1 = new JPanel(new BorderLayout());
        chartPanel2 = new JPanel(new BorderLayout());
        chartPanel3 = new JPanel(new BorderLayout());
        chartPanel4 = new JPanel(new BorderLayout());

        Dimension preferredChartSize = new Dimension(550, 300); // adjust width & height as needed
        chartPanel1.setPreferredSize(preferredChartSize);
        chartPanel2.setPreferredSize(preferredChartSize);
        chartPanel3.setPreferredSize(preferredChartSize);
        chartPanel4.setPreferredSize(preferredChartSize);

        JPanel allCharts = new JPanel();
        allCharts.setLayout(new java.awt.GridLayout(2, 2, 10, 10));  // 30px gaps horizontally and vertically
        allCharts.add(chartPanel1);
        allCharts.add(chartPanel2);
        allCharts.add(chartPanel3);
        allCharts.add(chartPanel4);

        kGradientPanel4.removeAll();
        kGradientPanel4.setLayout(new BorderLayout());
        kGradientPanel4.add(allCharts, BorderLayout.CENTER);
        kGradientPanel4.revalidate();
        kGradientPanel4.repaint();
    }

    private void loadCharts() {
        loadComplaintStatusChart();
        loadGuestCountryChart();
        loadMonthlyFeedbackChart();
        loadFeedbackRatingChart();
    }

    private void loadComplaintStatusChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT COUNT(*) AS total, status FROM complaints GROUP BY status");
            while (rs.next()) {
                dataset.addValue(rs.getInt("total"), "Complaints", rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading complaint status chart: " + e.getMessage());
        }
        JFreeChart chart = ChartFactory.createBarChart("Complaint Status", "Status", "Count", dataset);
        chartPanel1.removeAll();
        chartPanel1.add(new ChartPanel(chart), BorderLayout.CENTER);
        chartPanel1.revalidate();
        chartPanel1.repaint();
    }

    private void loadGuestCountryChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT country, COUNT(*) AS total FROM guests GROUP BY country");
            while (rs.next()) {
                dataset.setValue(rs.getString("country"), rs.getInt("total"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading guest country chart: " + e.getMessage());
        }
        JFreeChart chart = ChartFactory.createPieChart("Guests by Country", dataset, true, true, false);
        chartPanel2.removeAll();
        chartPanel2.add(new ChartPanel(chart), BorderLayout.CENTER);
        chartPanel2.revalidate();
        chartPanel2.repaint();
    }

    private void loadMonthlyFeedbackChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet rs = MySQL.executeSearch(
                    "SELECT YEAR(feedback_date) AS year, MONTH(feedback_date) AS month, COUNT(*) AS total "
                    + "FROM feedback GROUP BY year, month ORDER BY year, month"
            );

            while (rs.next()) {
                int year = rs.getInt("year");
                int month = rs.getInt("month");
                int total = rs.getInt("total");

                // Format month with leading zero for better labels like "2025-05"
                String monthLabel = month < 10 ? "0" + month : String.valueOf(month);
                String label = year + "-" + monthLabel;

                dataset.addValue(total, "Feedbacks", label);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading monthly feedback chart: " + e.getMessage());
        }

        JFreeChart chart = ChartFactory.createBarChart("Monthly Feedback", "Month", "Feedback Count", dataset);
        chartPanel3.removeAll();
        chartPanel3.add(new ChartPanel(chart), BorderLayout.CENTER);
        chartPanel3.revalidate();
        chartPanel3.repaint();
    }

    private void loadFeedbackRatingChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet rs = MySQL.executeSearch("SELECT rating, COUNT(*) AS total FROM feedback GROUP BY rating");
            while (rs.next()) {
                dataset.addValue(rs.getInt("total"), "Ratings", String.valueOf(rs.getInt("rating")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading feedback rating chart: " + e.getMessage());
        }
        JFreeChart chart = ChartFactory.createBarChart("Feedback Ratings", "Rating", "Count", dataset);
        chartPanel4.removeAll();
        chartPanel4.add(new ChartPanel(chart), BorderLayout.CENTER);
        chartPanel4.revalidate();
        chartPanel4.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        kGradientPanel4 = new com.k33ptoo.components.KGradientPanel();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(1640, 965));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkGradientFocus(1000);
        kGradientPanel1.setkStartColor(new java.awt.Color(91, 91, 37));

        kGradientPanel4.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(91, 91, 37));

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 741, Short.MAX_VALUE)
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(600, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel4;
    // End of variables declaration//GEN-END:variables
}
