package edu.loyola.cs485.view.EquipmentUpdateDialog;

import edu.loyola.cs485.controller.EquipmentService;
import edu.loyola.cs485.model.entity.Equipment;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class EquipmentUpdateDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtID;
    private JTextField txtBrand;
    private JTextField txtColor;
    private JTextField txtDescription;


    private JList lstClientUI;
    private Equipment updated;

    public EquipmentUpdateDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        try
        {
            String brand = (!txtBrand.getText().isEmpty()) ? txtBrand.getText() : updated.getBrand();
            String color = (!txtColor.getText().isEmpty()) ? txtColor.getText() : updated.getColor();
            String desc = (!txtDescription.getText().isEmpty()) ? txtDescription.getText() : updated.getDescription();

            Equipment tothis = new Equipment();
            tothis.setId(updated.getId());
            tothis.setBrand(brand);
            tothis.setColor(color);
            tothis.setDescription(desc);

            System.out.println(tothis.toString());

            EquipmentService service = new EquipmentService();
            service.setTothis(tothis);
            service.update(updated);

            dispose();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void setEquipment(Equipment e)
    {
        this.updated = e;
    }

    public static void main(String[] args) {
        EquipmentUpdateDialog dialog = new EquipmentUpdateDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
