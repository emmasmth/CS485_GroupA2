package edu.loyola.cs485.view;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        super("CS485 Music Store");
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

        JMenu menuClient = new JMenu("Client");
        JMenuItem mniClientInsert = new JMenuItem("New / Create");
        mniClientInsert.addActionListener(e->{
            newClientClick();
        });
        menuClient.add(mniClientInsert);

        JMenuItem mniClientCrud = new JMenuItem("CRUD");
        mniClientCrud.addActionListener( e->{
            crudClientClick();
        });
        menuClient.add(mniClientCrud);

        bar.add(menuFile);
        bar.add(menuClient);
        return bar;
    }

    public void newClientClick(){
        ClientDialog dlg = new ClientDialog();
        dlg.pack();
        dlg.setVisible(true);
    }

    public void crudClientClick(){
        ClientCrudDialog dlg = new ClientCrudDialog();
        dlg.pack();
        dlg.setVisible(true);
    }


}
