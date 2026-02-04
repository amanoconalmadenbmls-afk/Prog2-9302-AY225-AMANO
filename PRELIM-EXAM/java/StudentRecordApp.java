// Programmer: CON AMANO - 25-2346-641

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class StudentRecordApp extends JFrame {

    DefaultTableModel model;
    JTable table;
    JTextField idField, fnameField, lnameField, lw1Field, lw2Field, lw3Field, prelimField, attendField;

    public StudentRecordApp() {

        this.setTitle("Records - CON AMANOI 25-2346-641");
        this.setSize(900, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // TABLE MODEL WITH ALL COLUMNS
        model = new DefaultTableModel(new String[]{
                "ID", "First Name", "Last Name", "LW1", "LW2", "LW3", "Prelim", "Attendance"
        }, 0);

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // INPUT PANEL
        JPanel panel = new JPanel(new GridLayout(3, 6));

        idField = new JTextField();
        fnameField = new JTextField();
        lnameField = new JTextField();
        lw1Field = new JTextField();
        lw2Field = new JTextField();
        lw3Field = new JTextField();
        prelimField = new JTextField();
        attendField = new JTextField();

        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");

        panel.add(new JLabel("ID")); panel.add(idField);
        panel.add(new JLabel("First Name")); panel.add(fnameField);
        panel.add(new JLabel("Last Name")); panel.add(lnameField);
        panel.add(new JLabel("LW1")); panel.add(lw1Field);
        panel.add(new JLabel("LW2")); panel.add(lw2Field);
        panel.add(new JLabel("LW3")); panel.add(lw3Field);
        panel.add(new JLabel("Prelim")); panel.add(prelimField);
        panel.add(new JLabel("Attendance")); panel.add(attendField);
        panel.add(addBtn); panel.add(deleteBtn);

        add(panel, BorderLayout.NORTH);

        loadCSV();

        // ADD
        addBtn.addActionListener(e -> {
            model.addRow(new Object[]{
                    idField.getText(), fnameField.getText(), lnameField.getText(),
                    lw1Field.getText(), lw2Field.getText(), lw3Field.getText(),
                    prelimField.getText(), attendField.getText()
            });
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) model.removeRow(row);
        });

        setVisible(true);
    }

    private void loadCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("MOCK_DATA.csv"))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { // skip header
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading CSV file!");
        }
    }

    public static void main(String[] args) {
        new StudentRecordApp();
    }
}