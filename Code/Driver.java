/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
                openDocumentMenu(frame, mainMenu);
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
				openNewPerson(frame, mainMenu);
            }
        });

        JButton btnProps = new JButton("Properties");
        btnProps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "To be implemented in a future release");
            }
        });

        JButton btnFile = new JButton("File Explorer");
        btnFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFileExplorer();
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

    public static void openFileExplorer()
    {
    try{
       Desktop.getDesktop().open(new File("./Documents"));
    }catch(Exception e){}
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

        JPanel fileNameP = new JPanel();
        JLabel fileNameL = new JLabel("File Name: ");
        JTextField fileNameT = new JTextField(20);
        fileNameP.add(fileNameL);
        fileNameP.add(fileNameT);

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

        JPanel bathsP = new JPanel();
        JLabel bathsL = new JLabel("Baths: ");
        JTextField bathsT = new JTextField(20);
        JCheckBox bathsC = new JCheckBox("Ignore when drafting?");
        bathsP.add(bathsL);
        bathsP.add(bathsT);
        bathsP.add(bathsC);

        JPanel arrivalDateP = new JPanel();
        JLabel arrivalDateL = new JLabel("Arrival Date: ");
        JTextField arrivalDateT = new JTextField(20);
        JCheckBox arrivalDateC = new JCheckBox("Ignore when drafting?");
        arrivalDateP.add(arrivalDateL);
        arrivalDateP.add(arrivalDateT);
        arrivalDateP.add(arrivalDateC);

        JPanel arrivalTimeP = new JPanel();
        JLabel arrivalTimeL = new JLabel("Arrival Time: ");
        JTextField arrivalTimeT = new JTextField(20);
        JCheckBox arrivalTimeC = new JCheckBox("Ignore when drafting?");
        arrivalTimeP.add(arrivalTimeL);
        arrivalTimeP.add(arrivalTimeT);
        arrivalTimeP.add(arrivalTimeC);

        JPanel departureDateP = new JPanel();
        JLabel departureDateL = new JLabel("Departure Date: ");
        JTextField departureDateT = new JTextField(20);
        JCheckBox departureDateC = new JCheckBox("Ignore when drafting?");
        departureDateP.add(departureDateL);
        departureDateP.add(departureDateT);
        departureDateP.add(departureDateC);

        JPanel departureTimeP = new JPanel();
        JLabel departureTimeL = new JLabel("Departure Time: ");
        JTextField departureTimeT = new JTextField(20);
        JCheckBox departureTimeC = new JCheckBox("Ignore when drafting?");
        departureTimeP.add(departureTimeL);
        departureTimeP.add(departureTimeT);
        departureTimeP.add(departureTimeC);

        JPanel maxAdultsP = new JPanel();
        JLabel maxAdultsL = new JLabel("Max # of Adults: ");
        JTextField maxAdultsT = new JTextField(20);
        JCheckBox maxAdultsC = new JCheckBox("Ignore when drafting?");
        maxAdultsP.add(maxAdultsL);
        maxAdultsP.add(maxAdultsT);
        maxAdultsP.add(maxAdultsC);

        JPanel maxChildrenP = new JPanel();
        JLabel maxChildrenL = new JLabel("Max # of Children: ");
        JTextField maxChildrenT = new JTextField(20);
        JCheckBox maxChildrenC = new JCheckBox("Ignore when drafting?");
        maxChildrenP.add(maxChildrenL);
        maxChildrenP.add(maxChildrenT);
        maxChildrenP.add(maxChildrenC);

        JPanel approvedPeopleP = new JPanel();
        JLabel approvedPeopleL = new JLabel("Approved People: ");
        JTextField approvedPeopleT = new JTextField(20);
        JCheckBox approvedPeopleC = new JCheckBox("Ignore when drafting?");
        approvedPeopleP.add(approvedPeopleL);
        approvedPeopleP.add(approvedPeopleT);
        approvedPeopleP.add(approvedPeopleC);

        JPanel reserveFeeP = new JPanel();
        JLabel reserveFeeL = new JLabel("Reservation Fee: ");
        JTextField reserveFeeT = new JTextField(20);
        JCheckBox reserveFeeC = new JCheckBox("Ignore when drafting?");
        reserveFeeP.add(reserveFeeL);
        reserveFeeP.add(reserveFeeT);
        reserveFeeP.add(reserveFeeC);

        JPanel rentP = new JPanel();
        JLabel rentL = new JLabel("Rent: ");
        JTextField rentT = new JTextField(20);
        JCheckBox rentC = new JCheckBox("Ignore when drafting?");
        rentP.add(rentL);
        rentP.add(rentT);
        rentP.add(rentC);

        JPanel depositP = new JPanel();
        JLabel depositL = new JLabel("Security Deposit: ");
        JTextField depositT = new JTextField(20);
        JCheckBox depositC = new JCheckBox("Ignore when drafting?");
        depositP.add(depositL);
        depositP.add(depositT);
        depositP.add(depositC);

        JPanel cleaningFeeP = new JPanel();
        JLabel cleaningFeeL = new JLabel("Cleaning Fee: ");
        JTextField cleaningFeeT = new JTextField(20);
        JCheckBox cleaningFeeC = new JCheckBox("Ignore when drafting?");
        cleaningFeeP.add(cleaningFeeL);
        cleaningFeeP.add(cleaningFeeT);
        cleaningFeeP.add(cleaningFeeC);

        JPanel damageDepositP = new JPanel();
        JLabel damageDepositL = new JLabel("Refundable Damage Deposit: ");
        JTextField damageDepositT = new JTextField(20);
        JCheckBox damageDepositC = new JCheckBox("Ignore when drafting?");
        damageDepositP.add(damageDepositL);
        damageDepositP.add(damageDepositT);
        damageDepositP.add(damageDepositC);

        JPanel hoaP = new JPanel();
        JLabel hoaL = new JLabel("HOA Registration Fee: ");
        JTextField hoaT = new JTextField(20);
        JCheckBox hoaC = new JCheckBox("Ignore when drafting?");
        hoaP.add(hoaL);
        hoaP.add(hoaT);
        hoaP.add(hoaC);

        JPanel taxP = new JPanel();
        JLabel taxL = new JLabel("Transient Occupancy Tax: ");
        JTextField taxT = new JTextField(20);
        JCheckBox taxC = new JCheckBox("Ignore when drafting?");
        taxP.add(taxL);
        taxP.add(taxT);
        taxP.add(taxC);

        JPanel dueDateP = new JPanel();
        JLabel dueDateL = new JLabel("Payment Due Date: ");
        JTextField dueDateT = new JTextField(20);
        JCheckBox dueDateC = new JCheckBox("Ignore when drafting?");
        dueDateP.add(dueDateL);
        dueDateP.add(dueDateT);
        dueDateP.add(dueDateC);

        JPanel lateChargeP = new JPanel();
        JLabel lateChargeL = new JLabel("Late Charge: ");
        JTextField lateChargeT = new JTextField(20);
        JCheckBox lateChargeC = new JCheckBox("Ignore when drafting?");
        lateChargeP.add(lateChargeL);
        lateChargeP.add(lateChargeT);
        lateChargeP.add(lateChargeC);

        entryFields.add(fileNameP);
        entryFields.add(occupantP);
        entryFields.add(addressP);
        entryFields.add(cityP);
        entryFields.add(countyP);
        entryFields.add(bedroomsP);
        entryFields.add(bathsP);
        entryFields.add(arrivalDateP);
        entryFields.add(arrivalTimeP);
        entryFields.add(departureDateP);
        entryFields.add(departureTimeP);
        entryFields.add(maxAdultsP);
        entryFields.add(maxChildrenP);
        entryFields.add(approvedPeopleP);
        entryFields.add(reserveFeeP);
        entryFields.add(rentP);
        entryFields.add(depositP);
        entryFields.add(cleaningFeeP);
        entryFields.add(damageDepositP);
        entryFields.add(hoaP);
        entryFields.add(taxP);
        entryFields.add(dueDateP);
        entryFields.add(lateChargeP);

        btnSaveTemp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	SaveTemplate save = new SaveTemplate();

            	ArrayList <String> text = new ArrayList<>();

                text.add(fileNameT.getText());
                text.add(occupantT.getText());
                text.add(addressT.getText());
                text.add(cityT.getText());
                text.add(countyT.getText());
                text.add(bedroomsT.getText());
                text.add(bathsT.getText());
                text.add(arrivalDateT.getText());
                text.add(arrivalTimeT.getText());
                text.add(departureDateT.getText());
                text.add(departureTimeT.getText());
                text.add(maxAdultsT.getText());
                text.add(maxChildrenT.getText());
                text.add(approvedPeopleT.getText());
                text.add(reserveFeeT.getText());
                text.add(rentT.getText());
                text.add(depositT.getText());
                text.add(cleaningFeeT.getText());
                text.add(damageDepositT.getText());
                text.add(hoaT.getText());
                text.add(taxT.getText());
                text.add(dueDateT.getText());
                text.add(lateChargeT.getText());

				save.save(text);
            }
        });

        newTempMenu.add(optionButtons);
        JScrollPane scroller = new JScrollPane(entryFields);
        newTempMenu.add(scroller);

        frame.add(newTempMenu);
        frame.revalidate();
        frame.repaint();
    }

    public static void openNewPerson(JFrame frame, JPanel mainMenu)
    {
        frame.remove(mainMenu);

        JPanel newPersMenu = new JPanel();
        newPersMenu.setLayout(new BoxLayout(newPersMenu, BoxLayout.Y_AXIS));

        JPanel optionButtons = new JPanel();
        optionButtons.setMaximumSize(new Dimension(400, 40));
        JButton btnSavePers = new JButton("Save Person");

        JButton btnMainMenu = new JButton("Return to Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMainMenu(frame, newPersMenu);
            }
        });

        optionButtons.add(btnSavePers);
        optionButtons.add(btnMainMenu);

        JPanel entryFields = new JPanel();
        entryFields.setLayout(new BoxLayout(entryFields, BoxLayout.Y_AXIS));

        JPanel fNameP = new JPanel();
        JLabel fNameL = new JLabel("First Name: ");
        JTextField fNameT = new JTextField(20);
        fNameP.add(fNameL);
        fNameP.add(fNameT);

        JPanel lNameP = new JPanel();
        JLabel lNameL = new JLabel("Last Name: ");
        JTextField lNameT = new JTextField(20);
        lNameP.add(lNameL);
        lNameP.add(lNameT);

        JPanel emailP = new JPanel();
        JLabel emailL = new JLabel("Email: ");
        JTextField emailT = new JTextField(20);
        emailP.add(emailL);
        emailP.add(emailT);

        JPanel phoneP = new JPanel();
        JLabel phoneL = new JLabel("Phone Number: ");
        JTextField phoneT = new JTextField(20);
        phoneP.add(phoneL);
        phoneP.add(phoneT);

        JPanel addressP = new JPanel();
        JLabel addressL = new JLabel("Address: ");
        JTextField addressT = new JTextField(20);
        addressP.add(addressL);
        addressP.add(addressT);

        JPanel cityP = new JPanel();
        JLabel cityL = new JLabel("City: ");
        JTextField cityT = new JTextField(20);
        cityP.add(cityL);
        cityP.add(cityT);

        JPanel zipP = new JPanel();
        JLabel zipL = new JLabel("Zip Code: ");
        JTextField zipT = new JTextField(20);
        zipP.add(zipL);
        zipP.add(zipT);

        JPanel countyP = new JPanel();
        JLabel countyL = new JLabel("County: ");
        JTextField countyT = new JTextField(20);
        countyP.add(countyL);
        countyP.add(countyT);

        entryFields.add(fNameP);
        entryFields.add(lNameP);
        entryFields.add(emailP);
        entryFields.add(phoneP);
        entryFields.add(addressP);
        entryFields.add(cityP);
        entryFields.add(zipP);
        entryFields.add(countyP);

        btnSavePers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	SavePerson save = new SavePerson();

            	ArrayList <String> text = new ArrayList<>();

            	text.add(fNameT.getText());
            	text.add(lNameT.getText());
            	text.add(emailT.getText());
            	text.add(phoneT.getText());
                text.add(addressT.getText());
                text.add(cityT.getText());
                text.add(zipT.getText());
                text.add(countyT.getText());
				save.save(text);
            }
        });

        newPersMenu.add(optionButtons);
        JScrollPane scroller = new JScrollPane(entryFields);
        newPersMenu.add(scroller);
        /*
        btnSavePers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //call template save function
            	SavePerson save = new SavePerson();//new

            	ArrayList <String> text = new ArrayList<>();
            	text.add(phoneT.getText());
            	text.add(addressT.getText());
            	text.add(cityT.getText());
            	text.add(zipT.getText());
            	text.add(countyT.getText());


				save.save(text);//new
            }
        });
        */

        frame.add(newPersMenu);
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
                deleteTemplate(boxList, frame, deleteTempMenu);
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

    public static void openDocumentMenu(JFrame frame, JPanel mainMenu)
    {
        frame.remove(mainMenu);

        JPanel documentMenu = new JPanel();
        documentMenu.setLayout(new BoxLayout(documentMenu, BoxLayout.Y_AXIS));

        JButton btnNewDoc = new JButton("New Document");
        btnNewDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                openNewDocMenu(frame, documentMenu);
            }
        });

        JButton btnEditDoc = new JButton("Edit Document");
        btnEditDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //open edit Document View
                JOptionPane.showMessageDialog(null, "To be implemented in future releases");
            }
        });

        JButton btnDeleteDoc = new JButton("Delete Document");
        btnDeleteDoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDeleteDocMenu(frame, documentMenu);
            }
        });

        JButton btnRenameDoc = new JButton("Rename Document");
        btnRenameDoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openRenameDocMenu(frame, documentMenu);
            }
        });

        JButton btnMainMenu = new JButton("Return to Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMainMenu(frame, documentMenu);
            }
        });

        documentMenu.add(Box.createVerticalStrut(70));
        documentMenu.add(btnNewDoc);
        documentMenu.add(Box.createVerticalStrut(30));
        documentMenu.add(btnEditDoc);
        documentMenu.add(Box.createVerticalStrut(30));
        documentMenu.add(btnDeleteDoc);
        documentMenu.add(Box.createVerticalStrut(30));
        documentMenu.add(btnRenameDoc);
        documentMenu.add(Box.createVerticalStrut(30));
        documentMenu.add(btnMainMenu);

        btnNewDoc.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEditDoc.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDeleteDoc.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRenameDoc.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(documentMenu);
        frame.revalidate();
        frame.repaint();
    }

    public static void openNewDocMenu(JFrame frame, JPanel documentMenu)
    {
        frame.remove(documentMenu);

        JPanel newDocMenu = new JPanel();
        newDocMenu.setLayout(new BoxLayout(newDocMenu, BoxLayout.Y_AXIS));

        JPanel optionButtons = new JPanel();
        optionButtons.setMaximumSize(new Dimension(600, 40));
        JButton btnSaveDoc = new JButton("Save Document");
        JButton btnApplyTemp = new JButton("Apply Template");

        JButton btnMainMenu = new JButton("Return to Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMainMenu(frame, newDocMenu);
            }
        });

        optionButtons.add(btnSaveDoc);
        optionButtons.add(btnApplyTemp);
        optionButtons.add(btnMainMenu);

        JPanel entryFields = new JPanel();
        entryFields.setLayout(new BoxLayout(entryFields, BoxLayout.Y_AXIS));

        JPanel fileNameP = new JPanel();
        JLabel fileNameL = new JLabel("File Name: ");
        JTextField fileNameT = new JTextField(20);
        fileNameP.add(fileNameL);
        fileNameP.add(fileNameT);

        JPanel occupantP = new JPanel();
        JLabel occupantL = new JLabel("Occupant: ");
        JTextField occupantT = new JTextField(20);
        occupantP.add(occupantL);
        occupantP.add(occupantT);

        JPanel addressP = new JPanel();
        JLabel addressL = new JLabel("Address: ");
        JTextField addressT = new JTextField(20);
        addressP.add(addressL);
        addressP.add(addressT);

        JPanel cityP = new JPanel();
        JLabel cityL = new JLabel("City: ");
        JTextField cityT = new JTextField(20);
        cityP.add(cityL);
        cityP.add(cityT);

        JPanel countyP = new JPanel();
        JLabel countyL = new JLabel("County: ");
        JTextField countyT = new JTextField(20);
        countyP.add(countyL);
        countyP.add(countyT);

        JPanel bedroomsP = new JPanel();
        JLabel bedroomsL = new JLabel("Bedrooms: ");
        JTextField bedroomsT = new JTextField(20);
        bedroomsP.add(bedroomsL);
        bedroomsP.add(bedroomsT);

        JPanel bathsP = new JPanel();
        JLabel bathsL = new JLabel("Baths: ");
        JTextField bathsT = new JTextField(20);
        bathsP.add(bathsL);
        bathsP.add(bathsT);

        JPanel arrivalDateP = new JPanel();
        JLabel arrivalDateL = new JLabel("Arrival Date: ");
        JTextField arrivalDateT = new JTextField(20);
        arrivalDateP.add(arrivalDateL);
        arrivalDateP.add(arrivalDateT);

        JPanel arrivalTimeP = new JPanel();
        JLabel arrivalTimeL = new JLabel("Arrival Time: ");
        JTextField arrivalTimeT = new JTextField(20);
        arrivalTimeP.add(arrivalTimeL);
        arrivalTimeP.add(arrivalTimeT);

        JPanel departureDateP = new JPanel();
        JLabel departureDateL = new JLabel("Departure Date: ");
        JTextField departureDateT = new JTextField(20);
        departureDateP.add(departureDateL);
        departureDateP.add(departureDateT);

        JPanel departureTimeP = new JPanel();
        JLabel departureTimeL = new JLabel("Departure Time: ");
        JTextField departureTimeT = new JTextField(20);
        departureTimeP.add(departureTimeL);
        departureTimeP.add(departureTimeT);

        JPanel maxAdultsP = new JPanel();
        JLabel maxAdultsL = new JLabel("Max # of Adults: ");
        JTextField maxAdultsT = new JTextField(20);
        maxAdultsP.add(maxAdultsL);
        maxAdultsP.add(maxAdultsT);

        JPanel maxChildrenP = new JPanel();
        JLabel maxChildrenL = new JLabel("Max # of Children: ");
        JTextField maxChildrenT = new JTextField(20);
        maxChildrenP.add(maxChildrenL);
        maxChildrenP.add(maxChildrenT);

        JPanel approvedPeopleP = new JPanel();
        JLabel approvedPeopleL = new JLabel("Approved People: ");
        JTextField approvedPeopleT = new JTextField(20);
        approvedPeopleP.add(approvedPeopleL);
        approvedPeopleP.add(approvedPeopleT);

        JPanel reserveFeeP = new JPanel();
        JLabel reserveFeeL = new JLabel("Reservation Fee: ");
        JTextField reserveFeeT = new JTextField(20);
        reserveFeeP.add(reserveFeeL);
        reserveFeeP.add(reserveFeeT);

        JPanel rentP = new JPanel();
        JLabel rentL = new JLabel("Rent: ");
        JTextField rentT = new JTextField(20);
        rentP.add(rentL);
        rentP.add(rentT);

        JPanel depositP = new JPanel();
        JLabel depositL = new JLabel("Security Deposit: ");
        JTextField depositT = new JTextField(20);
        depositP.add(depositL);
        depositP.add(depositT);

        JPanel cleaningFeeP = new JPanel();
        JLabel cleaningFeeL = new JLabel("Cleaning Fee: ");
        JTextField cleaningFeeT = new JTextField(20);
        cleaningFeeP.add(cleaningFeeL);
        cleaningFeeP.add(cleaningFeeT);

        JPanel damageDepositP = new JPanel();
        JLabel damageDepositL = new JLabel("Refundable Damage Deposit: ");
        JTextField damageDepositT = new JTextField(20);
        damageDepositP.add(damageDepositL);
        damageDepositP.add(damageDepositT);

        JPanel hoaP = new JPanel();
        JLabel hoaL = new JLabel("HOA Registration Fee: ");
        JTextField hoaT = new JTextField(20);
        hoaP.add(hoaL);
        hoaP.add(hoaT);

        JPanel taxP = new JPanel();
        JLabel taxL = new JLabel("Transient Occupancy Tax: ");
        JTextField taxT = new JTextField(20);
        taxP.add(taxL);
        taxP.add(taxT);

        JPanel dueDateP = new JPanel();
        JLabel dueDateL = new JLabel("Payment Due Date: ");
        JTextField dueDateT = new JTextField(20);
        dueDateP.add(dueDateL);
        dueDateP.add(dueDateT);

        JPanel lateChargeP = new JPanel();
        JLabel lateChargeL = new JLabel("Late Charge: ");
        JTextField lateChargeT = new JTextField(20);
        lateChargeP.add(lateChargeL);
        lateChargeP.add(lateChargeT);

        entryFields.add(fileNameP);
        entryFields.add(occupantP);
        entryFields.add(addressP);
        entryFields.add(cityP);
        entryFields.add(countyP);
        entryFields.add(bedroomsP);
        entryFields.add(bathsP);
        entryFields.add(arrivalDateP);
        entryFields.add(arrivalTimeP);
        entryFields.add(departureDateP);
        entryFields.add(departureTimeP);
        entryFields.add(maxAdultsP);
        entryFields.add(maxChildrenP);
        entryFields.add(approvedPeopleP);
        entryFields.add(reserveFeeP);
        entryFields.add(rentP);
        entryFields.add(depositP);
        entryFields.add(cleaningFeeP);
        entryFields.add(damageDepositP);
        entryFields.add(hoaP);
        entryFields.add(taxP);
        entryFields.add(dueDateP);
        entryFields.add(lateChargeP);

        btnSaveDoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	SaveDocument save = new SaveDocument();

            	ArrayList <String> text = new ArrayList<>();
                text.add(fileNameT.getText());
                text.add("1. OCCUPANT: ");
                text.add(occupantT.getText());
                text.add("(\"Occupant\") agrees as follows:\n");
                text.add("2. PROPERTY: Occupant rents, for vaction purposes only, the furnished real property and improvements described as:");
                text.add(addressT.getText());
                text.add(", situated in ");
                text.add(cityT.getText());
                text.add(", County of ");
                text.add(countyT.getText());
                text.add(", California (\"Premises\"). The Premises has ");
                text.add(bedroomsT.getText());
                text.add(" bedroom(s) and ");
                text.add(bathsT.getText());
                text.add(" bath(s).\n");
                text.add("3. ARIVAL AND DEPATURE: Arival:");
                text.add(arrivalDateT.getText());
                text.add(" (Date) at ");
                text.add(arrivalTimeT.getText());
                text.add(" (Time) Depature: ");
                text.add(departureDateT.getText());
                text.add(" (Date) at ");
                text.add(departureTimeT.getText());
                text.add("(Time).\n");
                text.add("4. AUTHORIZED USE AND GUESTS: The Premises are for the sole use as a personal vacation residence by not more than ");
                text.add(maxAdultsT.getText());
                text.add(" adualts and ");
                text.add(maxChildrenT.getText());
                text.add(" children. In addition to the Occupant identified in paragraph 1, only the follwing shall reside at the Premises: ");
                text.add(approvedPeopleT.getText());
                text.add(" (\"Authorized Guests\").  No other guests, visitors or persons are permitted. If the Premises are uses, in any way, by more or different persons than those identified in this paragraph, (i) Occupant, Authorized Guests and all others may be required to immediately leave the Premises or be removed from the Premisesl (ii) Occupant is in breach of this Agreement; and (iii) Occupant forfeits its right to return any security deposit.\n");
                text.add("5. PAYMENTS: Occupant agrees to the following payments:\n");
                text.add("A. The Premises will not be held for Occupant until both the reservation fee and this Agreement signed by Occupant have actually been received.  Once paid, the reservation fee is for services rendered in entering into this Agreement and is NONREFUNDABLE.\n");
                text.add("B. Reservation Fee:");
                text.add(reserveFeeT.getText());
                text.add("Rent:");
                text.add(rentT.getText());
                text.add("Security Deposit:");
                text.add(depositT.getText());
                text.add("Cleaning Fee:");
                text.add(cleaningFeeT.getText());
                text.add("Damage Deposit:");
                text.add(damageDepositT.getText());
                text.add("HOA Tax:");
                text.add(hoaT.getText());
                text.add("Transient Occupancy Tax:");
                text.add(taxT.getText());
                text.add("Payment Date:");
                text.add(dueDateT.getText());
                text.add("\n6. BALANCE DUE; LATE CHARE: if any amount due is not received by the applicable Payment Due Date, Owner may, at Owner's or Owner's Represntative's sole discretion, either terminate this Agreement and refund to Occupant all payments except the reservation fee, or impose a late charge of $");
                text.add(lateChargeT.getText());
                text.add("\n");
                save.save(text);
            }
        });

        btnApplyTemp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tempFolderLocation = System.getProperty("user.dir") + "/Templates";
                File tempFolder = new File(tempFolderLocation);
                JFileChooser fileChooser = new JFileChooser(tempFolder);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try{
                        Scanner scanner = new Scanner(selectedFile);

                        fileNameT.setText(scanner.nextLine());
                        occupantT.setText(scanner.nextLine());
                        addressT.setText(scanner.nextLine());
                        cityT.setText(scanner.nextLine());
                        countyT.setText(scanner.nextLine());
                        bedroomsT.setText(scanner.nextLine());
                        bathsT.setText(scanner.nextLine());
                        arrivalDateT.setText(scanner.nextLine());
                        arrivalTimeT.setText(scanner.nextLine());
                        departureDateT.setText(scanner.nextLine());
                        departureTimeT.setText(scanner.nextLine());
                        maxAdultsT.setText(scanner.nextLine());
                        maxChildrenT.setText(scanner.nextLine());
                        approvedPeopleT.setText(scanner.nextLine());
                        reserveFeeT.setText(scanner.nextLine());
                        rentT.setText(scanner.nextLine());
                        depositT.setText(scanner.nextLine());
                        cleaningFeeT.setText(scanner.nextLine());
                        damageDepositT.setText(scanner.nextLine());
                        hoaT.setText(scanner.nextLine());
                        taxT.setText(scanner.nextLine());
                        dueDateT.setText(scanner.nextLine());
                        lateChargeT.setText(scanner.nextLine());

                        frame.setVisible(true);
                    } catch(Exception e2) {

                    }

                }
            }
        });

        newDocMenu.add(optionButtons);
        JScrollPane scroller = new JScrollPane(entryFields);
        newDocMenu.add(scroller);

        frame.add(newDocMenu);
        frame.revalidate();
        frame.repaint();
    }

    public static void openDeleteDocMenu(JFrame frame, JPanel documentMenu)
    {
        frame.remove(documentMenu);

        JPanel deleteDocMenu = new JPanel();
        deleteDocMenu.setLayout(new BoxLayout(deleteDocMenu, BoxLayout.Y_AXIS));

        File folder = new File("./Documents");
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
        JButton btnDeleteDoc = new JButton("Delete Checked Documents");
        btnDeleteDoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteDocument(boxList, frame, deleteDocMenu);
            }
        });

        JButton btnMainMenu = new JButton("Return to Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMainMenu(frame, deleteDocMenu);
            }
        });

        optionButtons.add(btnDeleteDoc);
        optionButtons.add(btnMainMenu);

        JPanel files = new JPanel();
        files.setLayout(new BoxLayout(files, BoxLayout.Y_AXIS));

        for (JCheckBox box : boxList)
        {
            files.add(box);
        }

        deleteDocMenu.add(optionButtons);
        JScrollPane scroller = new JScrollPane(files);
        deleteDocMenu.add(scroller);

        frame.add(deleteDocMenu);
        frame.revalidate();
        frame.repaint();
    }

    public static void deleteDocument(ArrayList<JCheckBox> boxList, JFrame frame, JPanel deleteDocMenu)
    {
        for (JCheckBox box : boxList)
        {
            if (box.isSelected())
            {
                File file = new File("./Documents/" + box.getText());
                file.delete();
            }
        }
        openDeleteTemplateMenu(frame, deleteDocMenu);
    }

    public static void openRenameDocMenu(JFrame frame, JPanel documentMenu)
    {
        frame.remove(documentMenu);

        JPanel renameDocMenu = new JPanel();
        renameDocMenu.setLayout(new BoxLayout(renameDocMenu, BoxLayout.Y_AXIS));

        File folder = new File("./Documents");
        File[] listOfFiles = folder.listFiles();

        ArrayList<JRadioButton> radioList = new ArrayList<JRadioButton>();
        ButtonGroup radioButtons = new ButtonGroup();

        for (int i = 0; i < listOfFiles.length; i++)
        {
            if (listOfFiles[i].isFile())
            {
                JRadioButton tempRadio = new JRadioButton(listOfFiles[i].getName());
                radioList.add(tempRadio);
                radioButtons.add(tempRadio);
            }
        }

        JPanel optionButtons = new JPanel();
        optionButtons.setMaximumSize(new Dimension(400, 40));
        JButton btnRenameDoc = new JButton("Rename Selected Document");
        btnRenameDoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = JOptionPane.showInputDialog("Document's New Name: ");
                if(userInput != null)
                {
                    renameDocument(radioList, userInput, frame, renameDocMenu);
                }
            }
        });

        JButton btnMainMenu = new JButton("Return to Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMainMenu(frame, renameDocMenu);
            }
        });

        optionButtons.add(btnRenameDoc);
        optionButtons.add(btnMainMenu);

        JPanel files = new JPanel();
        files.setLayout(new BoxLayout(files, BoxLayout.Y_AXIS));

        for (JRadioButton radio : radioList)
        {
            files.add(radio);
        }

        renameDocMenu.add(optionButtons);
        JScrollPane scroller = new JScrollPane(files);
        renameDocMenu.add(scroller);

        frame.add(renameDocMenu);
        frame.revalidate();
        frame.repaint();
    }

    public static void renameDocument(ArrayList<JRadioButton> radioList, String newName, JFrame frame, JPanel renameDocMenu)
    {
        for (JRadioButton radio : radioList)
        {
            if (radio.isSelected())
            {
                File file = new File("./Documents/" + radio.getText());
                File newFile = new File("./Documents/" + newName);
                Boolean success = file.renameTo(newFile);

                if (success == false)
                {
                    JOptionPane.showMessageDialog(null, "Failed to rename file");
                }
            }
        }
        openRenameDocMenu(frame, renameDocMenu);
    }
}
