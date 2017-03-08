/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import javax.swing.JFileChooser;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;



public class Driver
{
   
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Document Drafter");
        frame.setSize(600,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        openMainMenu(frame, null);
        frame.setVisible(true);
    }


    public static void openMainMenu(JFrame frame, JPanel remove)
    {
        if(remove != null)
        {
            frame.remove(remove);
        }

        JPanel mainMenu = new JPanel();
        mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.Y_AXIS));

        JButton btnDocs = new JButton("Documents");
        btnDocs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "To be implemented in release 2");
            }
        });

        JButton btnTemps = new JButton("Templates");
        btnTemps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                openTemplateMenu(frame, mainMenu);
            }
        });

        JButton btnPeeps = new JButton("People");
        btnPeeps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "To be implemented in release 3");
            }
        });

        JButton btnProps = new JButton("Properties");
        btnProps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "To be implemented in release 3");
            }
        });
        
        JButton btnFile = new JButton("File Explorer");
        btnFile.addActionListener(new ActionListener() { 
               public void actionPerformed(ActionEvent e) {
                   openFileExplorer(frame, mainMenu);
               }     
        });

        mainMenu.add(Box.createVerticalStrut(70));
        mainMenu.add(btnDocs);
        mainMenu.add(Box.createVerticalStrut(30));
        mainMenu.add(btnTemps);
        mainMenu.add(Box.createVerticalStrut(30));
        mainMenu.add(btnPeeps);
        mainMenu.add(Box.createVerticalStrut(30));
        mainMenu.add(btnProps);
        mainMenu.add(Box.createVerticalStrut(30));
        mainMenu.add(btnFile);

        btnDocs.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTemps.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPeeps.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnProps.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnFile.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(mainMenu);
        frame.revalidate();
        frame.repaint();
    }
    
    public static void openFileExplorer(JFrame frame, JPanel mainMenu)
    {
        frame.remove(mainMenu);
      
        JFileChooser fileExplorer = new JFileChooser();
        fileExplorer.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileExplorer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(fileExplorer.showOpenDialog(mainMenu) == JFileChooser.APPROVE_OPTION){
            //
        }
        System.out.println(fileExplorer.getSelectedFile().getAbsolutePath());
    }

    public static void openTemplateMenu(JFrame frame, JPanel mainMenu)
    {
        frame.remove(mainMenu);

        JPanel templateMenu = new JPanel();
        templateMenu.setLayout(new BoxLayout(templateMenu, BoxLayout.Y_AXIS));

        JButton btnNewTemp = new JButton("New Template");
        btnNewTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                openNewTemplateMenu(frame, templateMenu);
            }
        });

        JButton btnEditTemp = new JButton("Edit Template");
        btnEditTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //open edit Template View
                JOptionPane.showMessageDialog(null, "To be implemented in future releases");
            }
        });

        JButton btnDeleteTemp = new JButton("Delete Template");
        btnDeleteTemp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDeleteTemplateMenu(frame, templateMenu);
            }
        });

        JButton btnMainMenu = new JButton("Return to Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMainMenu(frame, templateMenu);
            }
        });

        templateMenu.add(Box.createVerticalStrut(70));
        templateMenu.add(btnNewTemp);
        templateMenu.add(Box.createVerticalStrut(30));
        templateMenu.add(btnEditTemp);
        templateMenu.add(Box.createVerticalStrut(30));
        templateMenu.add(btnDeleteTemp);
        templateMenu.add(Box.createVerticalStrut(30));
        templateMenu.add(btnMainMenu);

        btnNewTemp.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEditTemp.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDeleteTemp.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(templateMenu);
        frame.revalidate();
        frame.repaint();
    }

    public static void openNewTemplateMenu(JFrame frame, JPanel templateMenu)
    {
        frame.remove(templateMenu);

        JPanel newTempMenu = new JPanel();
        newTempMenu.setLayout(new BoxLayout(newTempMenu, BoxLayout.Y_AXIS));

        JPanel optionButtons = new JPanel();
        optionButtons.setMaximumSize(new Dimension(400, 40));
        JButton btnSaveTemp = new JButton("Save Template");
        btnSaveTemp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //call template save function
            }
        });

        JButton btnMainMenu = new JButton("Return to Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMainMenu(frame, newTempMenu);
            }
        });

        optionButtons.add(btnSaveTemp);
        optionButtons.add(btnMainMenu);

        JPanel entryFields = new JPanel();
        entryFields.setLayout(new BoxLayout(entryFields, BoxLayout.Y_AXIS));

        JPanel occupantP = new JPanel();
        JLabel occupantL = new JLabel("Occupant: ");
        JTextField occupantT = new JTextField(20);
        JCheckBox occupantC = new JCheckBox("Ignore when drafting?");
        occupantP.add(occupantL);
        occupantP.add(occupantT);
        occupantP.add(occupantC);

        JPanel addressP = new JPanel();
        JLabel addressL = new JLabel("Address: ");
        JTextField addressT = new JTextField(20);
        JCheckBox addressC = new JCheckBox("Ignore when drafting?");
        addressP.add(addressL);
        addressP.add(addressT);
        addressP.add(addressC);

        JPanel cityP = new JPanel();
        JLabel cityL = new JLabel("City: ");
        JTextField cityT = new JTextField(20);
        JCheckBox cityC = new JCheckBox("Ignore when drafting?");
        cityP.add(cityL);
        cityP.add(cityT);
        cityP.add(cityC);

        JPanel countyP = new JPanel();
        JLabel countyL = new JLabel("County: ");
        JTextField countyT = new JTextField(20);
        JCheckBox countyC = new JCheckBox("Ignore when drafting?");
        countyP.add(countyL);
        countyP.add(countyT);
        countyP.add(countyC);

        JPanel bedroomsP = new JPanel();
        JLabel bedroomsL = new JLabel("Bedrooms: ");
        JTextField bedroomsT = new JTextField(20);
        JCheckBox bedroomsC = new JCheckBox("Ignore when drafting?");
        bedroomsP.add(bedroomsL);
        bedroomsP.add(bedroomsT);
        bedroomsP.add(bedroomsC);

        entryFields.add(occupantP);
        entryFields.add(addressP);
        entryFields.add(cityP);
        entryFields.add(countyP);
        entryFields.add(bedroomsP);

        newTempMenu.add(optionButtons);
        JScrollPane scroller = new JScrollPane(entryFields);
        newTempMenu.add(scroller);

        frame.add(newTempMenu);
        frame.revalidate();
        frame.repaint();
    }

    public static void openDeleteTemplateMenu(JFrame frame, JPanel templateMenu)
    {
        frame.remove(templateMenu);

        JPanel deleteTempMenu = new JPanel();
        deleteTempMenu.setLayout(new BoxLayout(deleteTempMenu, BoxLayout.Y_AXIS));

        File folder = new File("./Templates");
        File[] listOfFiles = folder.listFiles();

        ArrayList<JCheckBox> boxList = new ArrayList<JCheckBox>();

        for (int i = 0; i < listOfFiles.length; i++)
        {
            if (listOfFiles[i].isFile())
            {
                JCheckBox tempCheck = new JCheckBox(listOfFiles[i].getName());
                boxList.add(tempCheck);
            }
        }

        JPanel optionButtons = new JPanel();
        optionButtons.setMaximumSize(new Dimension(400, 40));
        JButton btnDeleteTemp = new JButton("Delete Checked Templates");
        btnDeleteTemp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //deleteTemplate(boxList, frame, deleteTempMenu);
            }
        });

        JButton btnMainMenu = new JButton("Return to Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMainMenu(frame, deleteTempMenu);
            }
        });

        optionButtons.add(btnDeleteTemp);
        optionButtons.add(btnMainMenu);

        JPanel files = new JPanel();
        files.setLayout(new BoxLayout(files, BoxLayout.Y_AXIS));

        for (JCheckBox box : boxList)
        {
            files.add(box);
        }

        deleteTempMenu.add(optionButtons);
        JScrollPane scroller = new JScrollPane(files);
        deleteTempMenu.add(scroller);

        frame.add(deleteTempMenu);
        frame.revalidate();
        frame.repaint();
    }

    public static void deleteTemplate(ArrayList<JCheckBox> boxList, JFrame frame, JPanel deleteTempMenu)
    {
        for (JCheckBox box : boxList)
        {
            if (box.isSelected())
            {
                File file = new File("./Templates/" + box.getText());
                file.delete();
            }
        }
        openDeleteTemplateMenu(frame, deleteTempMenu);
    }
}