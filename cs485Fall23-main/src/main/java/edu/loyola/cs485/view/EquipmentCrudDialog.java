package edu.loyola.cs485.view;

import edu.loyola.cs485.controller.EquipmentService;
import edu.loyola.cs485.model.entity.Equipment;
import edu.loyola.cs485.view.EquipmentUpdateDialog.EquipmentUpdateDialog;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class EquipmentCrudDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton deleteButton;
    private JButton newButton;
    private JList lstClientUI;

    public EquipmentCrudDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);
        populateList();

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
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNewClick();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteClick();
            }
        });
    }

    private void onOK() {
        try
        {
            Equipment selEquipment = (Equipment) lstClientUI.getSelectedValue();
            EquipmentUpdateDialog dlg = new EquipmentUpdateDialog();
            dlg.setEquipment(selEquipment);
            dlg.pack();
            dlg.setVisible(true);

            populateList();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void onNewClick(){
        EquipmentDialog dlg=new EquipmentDialog();
        dlg.pack();
        dlg.setVisible(true);

        populateList();
    }

    public void onDeleteClick(){
        try{
            Equipment selEquipment = (Equipment) lstClientUI.getSelectedValue();
            //System.out.println(selClient);
            EquipmentService service = new EquipmentService();
            service.delete(selEquipment);

            populateList();
        }catch(Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
        }
    }

    public void populateList(){
        try {
            EquipmentService service = new EquipmentService();
            List lstdata = service.getEquipment();

            lstClientUI.setListData( lstdata.toArray() );
        }catch(Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
        }
    }

    public static void main(String[] args) {
        EquipmentCrudDialog dialog = new EquipmentCrudDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
