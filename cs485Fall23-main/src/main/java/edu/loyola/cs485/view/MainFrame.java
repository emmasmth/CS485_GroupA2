package edu.loyola.cs485.view;

import edu.loyola.cs485.view.EquipmentUpdateDialog.EquipmentUpdateDialog;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        super("Loyola Athletics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setJMenuBar(createMainMenu());
    }

    public JMenuBar createMainMenu(){
        JMenuBar bar = new JMenuBar();

        JMenu menuFile = new JMenu("File");

        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(
                e->{ System.exit(0); }
        );
        menuFile.add(mniExit);

        JMenu menuEquipment = new JMenu("Equipment");
        JMenuItem mniEquipmentInsert = new JMenuItem("New / Create");
        mniEquipmentInsert.addActionListener(e->{
            newEquipmentClick();
        });
        menuEquipment.add(mniEquipmentInsert);

        JMenuItem mniEquipmentCrud = new JMenuItem("CRUD");
        mniEquipmentCrud.addActionListener( e->{
            crudEquipmentClick();
        });
        menuEquipment.add(mniEquipmentCrud);


        bar.add(menuFile);
        bar.add(menuEquipment);
        return bar;
    }

    public void newEquipmentClick(){
        EquipmentDialog dlg = new EquipmentDialog();
        dlg.pack();
        dlg.setVisible(true);
    }

    public void crudEquipmentClick(){
        EquipmentCrudDialog dlg = new EquipmentCrudDialog();
        dlg.pack();
        dlg.setVisible(true);
    }

    public void updateEquipmentClick()
    {
        EquipmentUpdateDialog dlg = new EquipmentUpdateDialog();
        dlg.pack();
        dlg.setVisible(true);
    }



}
