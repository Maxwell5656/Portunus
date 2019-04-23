/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portunus;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author sgoug
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    DefaultListModel<InfoUnit> AccountListModel = new DefaultListModel<>();
    
    private AccountCreator newAcc;
    private AccountDeleter deleter;
    private AccountOverWriter writer;
    private Info info;
    private UserLogin login;
    private SettingStorage store;
    private Decorator alterer;
    public Interface() {
        initComponents();
        this.AccountList.setCellRenderer(new InfoUnitCellRenderer());
        this.AccountList.setModel(new DefaultListModel<InfoUnit>());
    }
    public void addAccountCreator(AccountCreator newAcc)
    {
        this.newAcc = newAcc;
    }
    public void addUserLogin(UserLogin login)
    {
        this.login = login;
    }
    public void addDecorator(Decorator alterer)
    {
        this.alterer = alterer;
    }
    public void addAccountDeleter(AccountDeleter delete)
    {
        this.deleter = delete;
    }
    public void addAccountOverWriter(AccountOverWriter writer)
    {
        this.writer = writer;
    }
    private void testThis() // this is just to test the capabilities of calling a function's methods
    {
        System.out.println("This indeeed does work!");
         this.NewAccUNField.setText("WORK");
    }
    public void accountExists(SettingStorage store)
    {
        if(!store.userExists()) 
        {
            this.LoginScreen.setVisible(false);
            this.NewAccountScreen.setVisible(true);
        }
        else
        {
            this.LoginScreen.setVisible(true);
            this.NewAccountScreen.setVisible(false);
        }
    }
    public void changeCosmetics(Color colorChoice, String FontSelect)
    {
        alterer.colorSet(colorChoice, NavMenu1);
        alterer.colorSet(colorChoice, NewAccountPnl);
        alterer.colorSet(colorChoice, ExistingAccountPnl);
        alterer.colorSet(colorChoice, LoginAccPan);
        alterer.colorSet(colorChoice, NewAccPan);
        alterer.saveColor(colorChoice);
        
        //changing the font size
            //Navigation Panel
        alterer.fontSizeSet(FontSelect, PasswordsBtn);
        alterer.fontSizeSet(FontSelect, SettingsBtn);
        alterer.fontSizeSet(FontSelect, LoginOutBtn);
        
            //Settings Page
        alterer.fontSizeSet(FontSelect, ColorOptionsLbl);
        alterer.fontSizeSet(FontSelect, FontSizeLbl);
        
            //Passwords Page
        alterer.fontSizeSet(FontSelect, AccountList);
        alterer.fontSizeSet(FontSelect, ShowAccBtn);
        alterer.fontSizeSet(FontSelect, AccNameHolderField);
        alterer.fontSizeSet(FontSelect, NewAccNameLbl);
        alterer.fontSizeSet(FontSelect, ShowAccBtn);
        alterer.fontSizeSet(FontSelect, NewAccUNLbl);
        alterer.fontSizeSet(FontSelect, NewAccPWLbl);
        alterer.fontSizeSet(FontSelect, NewAccSQLbl1);
        alterer.fontSizeSet(FontSelect, NewAccSQLbl2);
        alterer.fontSizeSet(FontSelect, NewAccSQLbl3);
        alterer.fontSizeSet(FontSelect, NewSQAnswerLbl1);
        alterer.fontSizeSet(FontSelect, NewSQAnswerLbl2);
        alterer.fontSizeSet(FontSelect, NewSQAnswerLbl3);
        alterer.fontSizeSet(FontSelect, AddAccountBtn);
        alterer.fontSizeSet(FontSelect, AccUNLbl);
        alterer.fontSizeSet(FontSelect, AccPWLbl);
        alterer.fontSizeSet(FontSelect, AccSQLbl1);
        alterer.fontSizeSet(FontSelect, AccSQLbl2);
        alterer.fontSizeSet(FontSelect, AccSQLbl3);
        alterer.fontSizeSet(FontSelect, SQAnswerLbl1);
        alterer.fontSizeSet(FontSelect, SQAnswerLbl2);
        alterer.fontSizeSet(FontSelect, SQAnswerLbl3);
        alterer.fontSizeSet(FontSelect, UNCopyBtn);
        alterer.fontSizeSet(FontSelect, PWCopyBtn);
        alterer.fontSizeSet(FontSelect, SQCopyBtn1);
        alterer.fontSizeSet(FontSelect, SQCopyBtn2);
        alterer.fontSizeSet(FontSelect, SQCopyBtn3);
        alterer.fontSizeSet(FontSelect, DeleteAccBtn);
        alterer.fontSizeSet(FontSelect, EditAccBtn);
        
            //Create New User Account Page
        alterer.fontSizeSet(FontSelect, CreateNewAccUNLbl);
        alterer.fontSizeSet(FontSelect, CreateNewAccPWLbl);
        alterer.fontSizeSet(FontSelect, CreateUserAccBtn);
        
            //Login to User Account Page
        alterer.fontSizeSet(FontSelect, LoginUNLbl);
        alterer.fontSizeSet(FontSelect, LoginPWLbl);
        alterer.fontSizeSet(FontSelect, LoginPgBtn);
        alterer.fontSizeSet(FontSelect, CreateNewAccBtn);
    }
    private void displayAllSettings()
    {
        InfoUnit toDisplay = AccountList.getSelectedValue();
        this.AccNameHolderField.setText("");
        this.AccUNField.setText("");
        this.AccPWField.setText("");
        this.AccSQField1.setText("");
        this.AccSQField2.setText("");
        this.AccSQField3.setText("");
        this.AccSQAnswerField1.setText("");
        this.AccSQAnswerField2.setText("");
        this.AccSQAnswerField3.setText("");
        
        if(toDisplay!=null)
        {
            this.AccNameHolderField.setText(toDisplay.getSiteName());
            this.AccUNField.setText(toDisplay.getUsername());
            this.AccPWField.setText(toDisplay.getPassword());
            ArrayList<String> secQ = toDisplay.getAllSecQuestions();
            for(int i = 0; i < secQ.size(); i++)
            {
                switch(i)
                {
                    case 0:
                        this.AccSQField1.setText(secQ.get(i));
                        break;
                    case 1:
                        this.AccSQField2.setText(secQ.get(i));
                        break;
                    case 2:
                        this.AccSQField3.setText(secQ.get(i));
                        break;
                    default:
                        break;
                }
            }
            ArrayList<String> secA = toDisplay.getAllSecAnswers();
            for(int i = 0; i < secA.size(); i++)
            {
                switch(i)
                {
                    case 0:
                        this.AccSQAnswerField1.setText(secA.get(i));
                        break;
                    case 1:
                        this.AccSQAnswerField2.setText(secA.get(i));
                        break;
                    case 2:
                        this.AccSQAnswerField3.setText(secA.get(i));
                        break;
                    default:
                        break;
                }
            }
            
        }
    
    }
    public void addInfoUnit(String ident, String siteName, String username, String password, ArrayList<String> secQ, ArrayList<String> secA)
    {
        DefaultListModel<InfoUnit> list = (DefaultListModel<InfoUnit>) this.AccountList.getModel();
        list.addElement(new InfoUnit(ident, siteName, username, password, secQ, secA));
    }
    
    public void removeInfoUnit(String ident)
    {
        DefaultListModel<InfoUnit> list = (DefaultListModel<InfoUnit>) this.AccountList.getModel();
        ArrayList<InfoUnit> units = new ArrayList<>();
        System.out.println(AccountListModel.getSize());
        for(int i = 0; i < AccountListModel.getSize(); i++)
        {
            units.add(list.elementAt(i));
        }
        for(InfoUnit unit: units)
        {
            if(unit.getIdent().equals(ident))
            {
                list.removeElement(unit);
            }
        }
    }
    /*public boolean allInit()
            // checks if there's a controller for each button
    {
        if(newAcc == null) return false;
        else return true;
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginScreen = new javax.swing.JPanel();
        LoginAccPan = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        LoginPWLbl = new javax.swing.JLabel();
        LoginPgBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        LoginUNLbl = new javax.swing.JLabel();
        CreateNewAccBtn = new javax.swing.JButton();
        NewAccountScreen = new javax.swing.JPanel();
        NewAccPan = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        CreateNewAccPWLbl = new javax.swing.JLabel();
        CreateUserAccBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        CreateNewAccUNLbl = new javax.swing.JLabel();
        CreateNewAccWelcomeLbl = new javax.swing.JLabel();
        NavigationScreen = new javax.swing.JPanel();
        BGPanel = new javax.swing.JPanel();
        NavMenu1 = new javax.swing.JPanel();
        PortunusLogo1 = new javax.swing.JLabel();
        PasswordsBtn = new javax.swing.JButton();
        SettingsBtn = new javax.swing.JButton();
        LoginOutBtn = new javax.swing.JButton();
        ChangingPanel = new javax.swing.JPanel();
        PasswordsPan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AccountList = new javax.swing.JList<>();
        AccDisplayPan = new javax.swing.JPanel();
        NewAccountPnl = new javax.swing.JPanel();
        NewAccNameField = new javax.swing.JTextField();
        NewAccNameLbl = new javax.swing.JLabel();
        NewAccUNField = new javax.swing.JTextField();
        NewAccUNLbl = new javax.swing.JLabel();
        NewAccPWField = new javax.swing.JTextField();
        NewAccPWLbl = new javax.swing.JLabel();
        AddAccountBtn = new javax.swing.JButton();
        NewAccSQLbl1 = new javax.swing.JLabel();
        NewAccSQField4 = new javax.swing.JTextField();
        NewSQAnswerLbl1 = new javax.swing.JLabel();
        NewAccSQAnswerField4 = new javax.swing.JTextField();
        NewAccSQLbl2 = new javax.swing.JLabel();
        NewAccSQField5 = new javax.swing.JTextField();
        NewSQAnswerLbl2 = new javax.swing.JLabel();
        NewAccSQAnswerField5 = new javax.swing.JTextField();
        NewAccSQLbl3 = new javax.swing.JLabel();
        NewAccSQField6 = new javax.swing.JTextField();
        NewSQAnswerLbl3 = new javax.swing.JLabel();
        NewAccSQAnswerField6 = new javax.swing.JTextField();
        ExistingAccountPnl = new javax.swing.JPanel();
        AccUNField = new javax.swing.JTextField();
        AccUNLbl = new javax.swing.JLabel();
        AccPWLbl = new javax.swing.JLabel();
        AccPWField = new javax.swing.JTextField();
        AccSQField1 = new javax.swing.JTextField();
        AccSQLbl1 = new javax.swing.JLabel();
        UNCopyBtn = new javax.swing.JButton();
        PWCopyBtn = new javax.swing.JButton();
        DeleteAccBtn = new javax.swing.JButton();
        EditAccBtn = new javax.swing.JButton();
        SQAnswerLbl1 = new javax.swing.JLabel();
        AccSQAnswerField1 = new javax.swing.JTextField();
        SQCopyBtn1 = new javax.swing.JButton();
        SQCopyBtn2 = new javax.swing.JButton();
        AccSQAnswerField2 = new javax.swing.JTextField();
        SQAnswerLbl2 = new javax.swing.JLabel();
        AccSQField2 = new javax.swing.JTextField();
        AccSQLbl2 = new javax.swing.JLabel();
        AccSQLbl3 = new javax.swing.JLabel();
        AccSQField3 = new javax.swing.JTextField();
        SQAnswerLbl3 = new javax.swing.JLabel();
        AccSQAnswerField3 = new javax.swing.JTextField();
        SQCopyBtn3 = new javax.swing.JButton();
        AccNameHolderField = new javax.swing.JTextField();
        ShowAccBtn = new javax.swing.JButton();
        AddNewAccBtn = new javax.swing.JButton();
        SettingsPan = new javax.swing.JPanel();
        colorPicker = new javax.swing.JColorChooser();
        ColorOptionsLbl = new javax.swing.JLabel();
        FontSizeLbl = new javax.swing.JLabel();
        FontSizeSelection = new javax.swing.JComboBox<>();
        SettingsDoneBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new java.awt.CardLayout());

        LoginScreen.setBackground(new java.awt.Color(153, 153, 153));

        LoginAccPan.setBackground(new java.awt.Color(51, 204, 255));
        LoginAccPan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        LoginPWLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        LoginPWLbl.setText("Password");

        LoginPgBtn.setBackground(new java.awt.Color(204, 204, 204));
        LoginPgBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        LoginPgBtn.setText("Login");
        LoginPgBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        LoginPgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginPgBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel4.setText("Welcome to Portunus!");

        LoginUNLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        LoginUNLbl.setText("Username");

        CreateNewAccBtn.setBackground(new java.awt.Color(204, 204, 204));
        CreateNewAccBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        CreateNewAccBtn.setText("Create New Account");
        CreateNewAccBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        CreateNewAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewAccBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginAccPanLayout = new javax.swing.GroupLayout(LoginAccPan);
        LoginAccPan.setLayout(LoginAccPanLayout);
        LoginAccPanLayout.setHorizontalGroup(
            LoginAccPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginAccPanLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(LoginAccPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LoginAccPanLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(LoginUNLbl))
                    .addGroup(LoginAccPanLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(LoginPgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginAccPanLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(LoginPWLbl)))
                .addGap(0, 57, Short.MAX_VALUE))
            .addGroup(LoginAccPanLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(CreateNewAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginAccPanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(72, 72, 72))
        );
        LoginAccPanLayout.setVerticalGroup(
            LoginAccPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginAccPanLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(41, 41, 41)
                .addComponent(LoginUNLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(LoginPWLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(LoginPgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(CreateNewAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LoginScreenLayout = new javax.swing.GroupLayout(LoginScreen);
        LoginScreen.setLayout(LoginScreenLayout);
        LoginScreenLayout.setHorizontalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginScreenLayout.createSequentialGroup()
                .addContainerGap(531, Short.MAX_VALUE)
                .addComponent(LoginAccPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(509, 509, 509))
        );
        LoginScreenLayout.setVerticalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(LoginAccPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );

        getContentPane().add(LoginScreen, "card3");

        NewAccountScreen.setBackground(new java.awt.Color(153, 153, 153));

        NewAccPan.setBackground(new java.awt.Color(51, 204, 255));
        NewAccPan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPasswordField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        CreateNewAccPWLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        CreateNewAccPWLbl.setText("Password");

        CreateUserAccBtn.setBackground(new java.awt.Color(204, 204, 204));
        CreateUserAccBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        CreateUserAccBtn.setText("Create");
        CreateUserAccBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        CreateUserAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUserAccBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel7.setText("Welcome to Portunus!");

        CreateNewAccUNLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        CreateNewAccUNLbl.setText("Username");

        CreateNewAccWelcomeLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        CreateNewAccWelcomeLbl.setText("Let's Create a New Account:");

        javax.swing.GroupLayout NewAccPanLayout = new javax.swing.GroupLayout(NewAccPan);
        NewAccPan.setLayout(NewAccPanLayout);
        NewAccPanLayout.setHorizontalGroup(
            NewAccPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewAccPanLayout.createSequentialGroup()
                .addGroup(NewAccPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewAccPanLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(CreateNewAccPWLbl))
                    .addGroup(NewAccPanLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel7)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(NewAccPanLayout.createSequentialGroup()
                .addGroup(NewAccPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewAccPanLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(NewAccPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(NewAccPanLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(CreateNewAccUNLbl))
                    .addGroup(NewAccPanLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(CreateUserAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NewAccPanLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(CreateNewAccWelcomeLbl)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        NewAccPanLayout.setVerticalGroup(
            NewAccPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewAccPanLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(CreateNewAccWelcomeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(CreateNewAccUNLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(CreateNewAccPWLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(CreateUserAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout NewAccountScreenLayout = new javax.swing.GroupLayout(NewAccountScreen);
        NewAccountScreen.setLayout(NewAccountScreenLayout);
        NewAccountScreenLayout.setHorizontalGroup(
            NewAccountScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewAccountScreenLayout.createSequentialGroup()
                .addContainerGap(536, Short.MAX_VALUE)
                .addComponent(NewAccPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(504, 504, 504))
        );
        NewAccountScreenLayout.setVerticalGroup(
            NewAccountScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewAccountScreenLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(NewAccPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        getContentPane().add(NewAccountScreen, "card4");

        NavigationScreen.setBackground(new java.awt.Color(153, 153, 153));
        NavigationScreen.setForeground(new java.awt.Color(153, 153, 153));
        NavigationScreen.setMaximumSize(new java.awt.Dimension(600, 900));

        BGPanel.setBackground(new java.awt.Color(153, 153, 153));

        NavMenu1.setBackground(new java.awt.Color(51, 204, 255));
        NavMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        PortunusLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/portunus/PortunusLogo15.png"))); // NOI18N

        PasswordsBtn.setBackground(new java.awt.Color(204, 204, 204));
        PasswordsBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        PasswordsBtn.setText("Passwords");
        PasswordsBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        PasswordsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordsBtnActionPerformed(evt);
            }
        });

        SettingsBtn.setBackground(new java.awt.Color(204, 204, 204));
        SettingsBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        SettingsBtn.setText("Settings");
        SettingsBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        SettingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsBtnActionPerformed(evt);
            }
        });

        LoginOutBtn.setBackground(new java.awt.Color(204, 204, 204));
        LoginOutBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        LoginOutBtn.setText("Log In/out");
        LoginOutBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        LoginOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavMenu1Layout = new javax.swing.GroupLayout(NavMenu1);
        NavMenu1.setLayout(NavMenu1Layout);
        NavMenu1Layout.setHorizontalGroup(
            NavMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavMenu1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(NavMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PasswordsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SettingsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoginOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PortunusLogo1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        NavMenu1Layout.setVerticalGroup(
            NavMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavMenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PortunusLogo1)
                .addGap(30, 30, 30)
                .addComponent(PasswordsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(SettingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(LoginOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );

        ChangingPanel.setBackground(new java.awt.Color(153, 153, 153));
        ChangingPanel.setLayout(new java.awt.CardLayout());

        PasswordsPan.setBackground(new java.awt.Color(153, 153, 153));

        AccountList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        AccountList.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        AccountList.setModel(AccountListModel);
        AccountList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(AccountList);

        AccDisplayPan.setBackground(new java.awt.Color(51, 204, 255));
        AccDisplayPan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        AccDisplayPan.setPreferredSize(new java.awt.Dimension(990, 786));
        AccDisplayPan.setLayout(new java.awt.CardLayout());

        NewAccountPnl.setBackground(new java.awt.Color(51, 204, 255));
        NewAccountPnl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        NewAccNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        NewAccNameLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        NewAccNameLbl.setText("Account Name:");

        NewAccUNField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        NewAccUNLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        NewAccUNLbl.setText("Username:");

        NewAccPWField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        NewAccPWLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        NewAccPWLbl.setText("Password:");

        AddAccountBtn.setBackground(new java.awt.Color(204, 204, 204));
        AddAccountBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        AddAccountBtn.setText("Done");
        AddAccountBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        AddAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAccountBtnActionPerformed(evt);
            }
        });

        NewAccSQLbl1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        NewAccSQLbl1.setText("Security Question 1:");

        NewAccSQField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        NewSQAnswerLbl1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        NewSQAnswerLbl1.setText("Answer:");

        NewAccSQAnswerField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        NewAccSQLbl2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        NewAccSQLbl2.setText("Security Question 2:");

        NewAccSQField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        NewSQAnswerLbl2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        NewSQAnswerLbl2.setText("Answer:");

        NewAccSQAnswerField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        NewAccSQLbl3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        NewAccSQLbl3.setText("Security Question 3:");

        NewAccSQField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        NewSQAnswerLbl3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        NewSQAnswerLbl3.setText("Answer:");

        NewAccSQAnswerField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout NewAccountPnlLayout = new javax.swing.GroupLayout(NewAccountPnl);
        NewAccountPnl.setLayout(NewAccountPnlLayout);
        NewAccountPnlLayout.setHorizontalGroup(
            NewAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewAccountPnlLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(NewAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NewAccNameLbl)
                    .addComponent(NewAccPWLbl)
                    .addComponent(NewAccNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewAccSQLbl2)
                    .addComponent(NewAccSQLbl3)
                    .addComponent(NewAccSQLbl1)
                    .addComponent(NewAccPWField, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewAccSQField5, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(NewAccSQField4)
                    .addComponent(NewAccSQField6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(NewAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(NewAccountPnlLayout.createSequentialGroup()
                            .addGap(194, 194, 194)
                            .addComponent(AddAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NewAccSQAnswerField4)
                            .addComponent(NewAccSQAnswerField5)
                            .addComponent(NewSQAnswerLbl1)
                            .addComponent(NewSQAnswerLbl2)
                            .addComponent(NewSQAnswerLbl3)
                            .addComponent(NewAccSQAnswerField6, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(NewAccUNField, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewAccUNLbl))
                .addGap(67, 67, 67))
        );
        NewAccountPnlLayout.setVerticalGroup(
            NewAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewAccountPnlLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(NewAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(NewAccountPnlLayout.createSequentialGroup()
                        .addComponent(NewAccNameLbl)
                        .addGap(37, 37, 37))
                    .addComponent(NewAccNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(NewAccountPnlLayout.createSequentialGroup()
                        .addComponent(NewAccUNLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NewAccUNField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(NewAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewAccountPnlLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(NewAccPWLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewAccPWField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(NewAccSQLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewAccSQField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NewAccSQLbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewAccSQField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NewAccSQLbl3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewAccSQField6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewAccountPnlLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(NewSQAnswerLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewAccSQAnswerField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NewSQAnswerLbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewAccSQAnswerField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NewSQAnswerLbl3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewAccSQAnswerField6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(AddAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 128, Short.MAX_VALUE))
        );

        AccDisplayPan.add(NewAccountPnl, "card2");

        ExistingAccountPnl.setBackground(new java.awt.Color(51, 204, 255));
        ExistingAccountPnl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        AccUNField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        AccUNLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        AccUNLbl.setText("Username:");

        AccPWLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        AccPWLbl.setText("Password:");

        AccPWField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        AccSQField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        AccSQLbl1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        AccSQLbl1.setText("Security Question 1:");

        UNCopyBtn.setBackground(new java.awt.Color(204, 204, 204));
        UNCopyBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        UNCopyBtn.setText("Copy");
        UNCopyBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        UNCopyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNCopyBtnActionPerformed(evt);
            }
        });

        PWCopyBtn.setBackground(new java.awt.Color(204, 204, 204));
        PWCopyBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        PWCopyBtn.setText("Copy");
        PWCopyBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PWCopyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PWCopyBtnActionPerformed(evt);
            }
        });

        DeleteAccBtn.setBackground(new java.awt.Color(204, 204, 204));
        DeleteAccBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        DeleteAccBtn.setText("Delete");
        DeleteAccBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        DeleteAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAccBtnActionPerformed(evt);
            }
        });

        EditAccBtn.setBackground(new java.awt.Color(204, 204, 204));
        EditAccBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        EditAccBtn.setText("Edit");
        EditAccBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        EditAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditAccBtnActionPerformed(evt);
            }
        });

        SQAnswerLbl1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        SQAnswerLbl1.setText("Answer:");

        AccSQAnswerField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        SQCopyBtn1.setBackground(new java.awt.Color(204, 204, 204));
        SQCopyBtn1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        SQCopyBtn1.setText("Copy");
        SQCopyBtn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        SQCopyBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SQCopyBtn1ActionPerformed(evt);
            }
        });

        SQCopyBtn2.setBackground(new java.awt.Color(204, 204, 204));
        SQCopyBtn2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        SQCopyBtn2.setText("Copy");
        SQCopyBtn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        SQCopyBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SQCopyBtn2ActionPerformed(evt);
            }
        });

        AccSQAnswerField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        SQAnswerLbl2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        SQAnswerLbl2.setText("Answer:");

        AccSQField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        AccSQLbl2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        AccSQLbl2.setText("Security Question 2:");

        AccSQLbl3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        AccSQLbl3.setText("Security Question 3:");

        AccSQField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        SQAnswerLbl3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        SQAnswerLbl3.setText("Answer:");

        AccSQAnswerField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        SQCopyBtn3.setBackground(new java.awt.Color(204, 204, 204));
        SQCopyBtn3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        SQCopyBtn3.setText("Copy");
        SQCopyBtn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        SQCopyBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SQCopyBtn3ActionPerformed(evt);
            }
        });

        AccNameHolderField.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        AccNameHolderField.setText("Account Name");
        AccNameHolderField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout ExistingAccountPnlLayout = new javax.swing.GroupLayout(ExistingAccountPnl);
        ExistingAccountPnl.setLayout(ExistingAccountPnlLayout);
        ExistingAccountPnlLayout.setHorizontalGroup(
            ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExistingAccountPnlLayout.createSequentialGroup()
                .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(EditAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AccNameHolderField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                                .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AccSQLbl2)
                                    .addComponent(AccSQLbl3)
                                    .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                                        .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AccSQLbl1)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExistingAccountPnlLayout.createSequentialGroup()
                                                .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                                                        .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(AccUNLbl)
                                                            .addComponent(AccUNField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(UNCopyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(AccSQField2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(AccSQField1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(AccSQField3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)))
                                        .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(AccPWLbl)
                                                    .addComponent(AccPWField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(AccSQAnswerField1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(SQAnswerLbl1)
                                                    .addComponent(SQAnswerLbl2)
                                                    .addComponent(AccSQAnswerField2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(SQAnswerLbl3)
                                                    .addComponent(AccSQAnswerField3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(0, 62, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SQCopyBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PWCopyBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SQCopyBtn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SQCopyBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(77, 77, 77))
        );
        ExistingAccountPnlLayout.setVerticalGroup(
            ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(AccUNLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AccUNField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(AccNameHolderField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AccPWLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AccPWField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PWCopyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UNCopyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(SQAnswerLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AccSQAnswerField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SQCopyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                        .addComponent(AccSQLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AccSQField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                                .addComponent(AccSQLbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AccSQField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AccSQLbl3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AccSQField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                                .addComponent(SQAnswerLbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ExistingAccountPnlLayout.createSequentialGroup()
                                        .addComponent(AccSQAnswerField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(SQAnswerLbl3))
                                    .addComponent(SQCopyBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SQCopyBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AccSQAnswerField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(ExistingAccountPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        AccDisplayPan.add(ExistingAccountPnl, "card3");

        ShowAccBtn.setBackground(new java.awt.Color(204, 204, 204));
        ShowAccBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        ShowAccBtn.setText("Show");
        ShowAccBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ShowAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowAccBtnActionPerformed(evt);
            }
        });

        AddNewAccBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        AddNewAccBtn.setText("New Account");
        AddNewAccBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        AddNewAccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewAccBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PasswordsPanLayout = new javax.swing.GroupLayout(PasswordsPan);
        PasswordsPan.setLayout(PasswordsPanLayout);
        PasswordsPanLayout.setHorizontalGroup(
            PasswordsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PasswordsPanLayout.createSequentialGroup()
                .addGroup(PasswordsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PasswordsPanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PasswordsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AccDisplayPan, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(PasswordsPanLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(AddNewAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ShowAccBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        PasswordsPanLayout.setVerticalGroup(
            PasswordsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PasswordsPanLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PasswordsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ShowAccBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(AddNewAccBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AccDisplayPan, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                .addContainerGap())
        );

        ChangingPanel.add(PasswordsPan, "card2");

        SettingsPan.setBackground(new java.awt.Color(153, 153, 153));

        colorPicker.setBackground(new java.awt.Color(51, 204, 255));
        colorPicker.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        colorPicker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        colorPicker.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ColorOptionsLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        ColorOptionsLbl.setText("Change Color:");

        FontSizeLbl.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        FontSizeLbl.setText("Font Size:");

        FontSizeSelection.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        FontSizeSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Extra Small", "Small", "Normal", "Large", "Extra Large" }));
        FontSizeSelection.setSelectedItem("Normal");
        FontSizeSelection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        SettingsDoneBtn.setBackground(new java.awt.Color(204, 204, 204));
        SettingsDoneBtn.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        SettingsDoneBtn.setText("Done");
        SettingsDoneBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        SettingsDoneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsDoneBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SettingsPanLayout = new javax.swing.GroupLayout(SettingsPan);
        SettingsPan.setLayout(SettingsPanLayout);
        SettingsPanLayout.setHorizontalGroup(
            SettingsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanLayout.createSequentialGroup()
                .addGroup(SettingsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SettingsDoneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SettingsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SettingsPanLayout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(ColorOptionsLbl))
                        .addGroup(SettingsPanLayout.createSequentialGroup()
                            .addGap(101, 101, 101)
                            .addGroup(SettingsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(colorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(SettingsPanLayout.createSequentialGroup()
                                    .addGap(61, 61, 61)
                                    .addComponent(FontSizeLbl))
                                .addComponent(FontSizeSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(510, Short.MAX_VALUE))
        );
        SettingsPanLayout.setVerticalGroup(
            SettingsPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingsPanLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(ColorOptionsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(FontSizeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FontSizeSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(SettingsDoneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );

        ChangingPanel.add(SettingsPan, "card3");

        javax.swing.GroupLayout BGPanelLayout = new javax.swing.GroupLayout(BGPanel);
        BGPanel.setLayout(BGPanelLayout);
        BGPanelLayout.setHorizontalGroup(
            BGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(NavMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(ChangingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BGPanelLayout.setVerticalGroup(
            BGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChangingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BGPanelLayout.createSequentialGroup()
                        .addComponent(NavMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout NavigationScreenLayout = new javax.swing.GroupLayout(NavigationScreen);
        NavigationScreen.setLayout(NavigationScreenLayout);
        NavigationScreenLayout.setHorizontalGroup(
            NavigationScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationScreenLayout.createSequentialGroup()
                .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        NavigationScreenLayout.setVerticalGroup(
            NavigationScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(NavigationScreen, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordsBtnActionPerformed
        PasswordsPan.setVisible(true);
        SettingsPan.setVisible(false);
    }//GEN-LAST:event_PasswordsBtnActionPerformed

    private void SettingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsBtnActionPerformed
        SettingsPan.setVisible(true);
        PasswordsPan.setVisible(false);
    }//GEN-LAST:event_SettingsBtnActionPerformed

    private void LoginPgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginPgBtnActionPerformed
        //right now it will automatically display the Navigation screen when clicked
        //needs to be changed to only work when the right password is entered
        System.out.println(new String(jPasswordField1.getPassword()));
        System.out.println(jTextField1.getText());
        if(this.login.verifyCredentials(jTextField1.getText(), new String(jPasswordField1.getPassword())))
        {
            NavigationScreen.setVisible(true);
            LoginScreen.setVisible(false);
            NewAccountScreen.setVisible(false);
        }
        else System.out.println("Wrong Login Info"); //TODO: add message in GUI that displays
    }//GEN-LAST:event_LoginPgBtnActionPerformed

    private void LoginOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginOutBtnActionPerformed
        LoginScreen.setVisible(true);
        NavigationScreen.setVisible(false);
        NewAccountScreen.setVisible(false);
    }//GEN-LAST:event_LoginOutBtnActionPerformed

    private void CreateUserAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUserAccBtnActionPerformed
        NavigationScreen.setVisible(true);
        LoginScreen.setVisible(false);
        NewAccountScreen.setVisible(false);
        this.login.setLoginInfo(jTextField2.getText(), new String(jPasswordField2.getPassword()));
    }//GEN-LAST:event_CreateUserAccBtnActionPerformed

    private void CreateNewAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewAccBtnActionPerformed
        NewAccountScreen.setVisible(true);
        NavigationScreen.setVisible(false);
        LoginScreen.setVisible(false);
    }//GEN-LAST:event_CreateNewAccBtnActionPerformed

    private void SettingsDoneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsDoneBtnActionPerformed
        Color interfaceColor;
        interfaceColor = colorPicker.getColor();
        String newFont = FontSizeSelection.getSelectedItem().toString();
        this.changeCosmetics(interfaceColor, newFont);
        alterer.saveColor(interfaceColor);
        alterer.saveFont(newFont);
    }//GEN-LAST:event_SettingsDoneBtnActionPerformed

    private void ShowAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowAccBtnActionPerformed
        ExistingAccountPnl.setVisible(true);
        NewAccountPnl.setVisible(false);
        this.displayAllSettings();
    }//GEN-LAST:event_ShowAccBtnActionPerformed

    private void AddAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAccountBtnActionPerformed
        String AccName = NewAccNameField.getText();
        String AccUN = NewAccUNField.getText();
        String AccPW = NewAccPWField.getText();
        String AccSQ1 = NewAccSQField4.getText();
        String AccSQ2 = NewAccSQField5.getText();
        String AccSQ3 = NewAccSQField6.getText();
        String AccSQA1 = NewAccSQAnswerField4.getText();
        String AccSQA2 = NewAccSQAnswerField5.getText();
        String AccSQA3 = NewAccSQAnswerField6.getText();
        
        //Security Question ArrayList
        ArrayList SQList = new ArrayList();
        SQList.add(AccSQ1);
        SQList.add(AccSQ2);
        SQList.add(AccSQ3);
        
        ArrayList SQAList = new ArrayList();
        SQAList.add(AccSQA1);
        SQAList.add(AccSQA2);
        SQAList.add(AccSQA3);
                
        //Account name, Username, Password, ArrayList security Q, ArrayList security A 
        
        this.newAcc.createAccount(AccountListModel, AccName, AccUN, AccPW, SQList, SQAList);
        
    }//GEN-LAST:event_AddAccountBtnActionPerformed

    private void UNCopyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UNCopyBtnActionPerformed
        CopyInfo copier = new CopyInfo();
        copier.copy(AccUNField.getText());
    }//GEN-LAST:event_UNCopyBtnActionPerformed

    private void PWCopyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PWCopyBtnActionPerformed
        CopyInfo copier = new CopyInfo();
        copier.copy(AccPWField.getText());
    }//GEN-LAST:event_PWCopyBtnActionPerformed

    private void SQCopyBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SQCopyBtn1ActionPerformed
        CopyInfo copier = new CopyInfo();
        copier.copy(AccSQAnswerField1.getText());
    }//GEN-LAST:event_SQCopyBtn1ActionPerformed

    private void SQCopyBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SQCopyBtn2ActionPerformed
        CopyInfo copier = new CopyInfo();
        copier.copy(AccSQAnswerField2.getText());
    }//GEN-LAST:event_SQCopyBtn2ActionPerformed

    private void SQCopyBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SQCopyBtn3ActionPerformed
        CopyInfo copier = new CopyInfo();
        copier.copy(AccSQAnswerField3.getText());
    }//GEN-LAST:event_SQCopyBtn3ActionPerformed

    private void AddNewAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewAccBtnActionPerformed
        NewAccountPnl.setVisible(true);
        ExistingAccountPnl.setVisible(false);
    }//GEN-LAST:event_AddNewAccBtnActionPerformed

    private void DeleteAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAccBtnActionPerformed
        // TODO add your handling code here:
        NewAccountPnl.setVisible(true);
        ExistingAccountPnl.setVisible(false);
        DefaultListModel<InfoUnit> list = (DefaultListModel<InfoUnit>) this.AccountList.getModel();
        this.deleter.delete(this.AccountList.getSelectedValue().getIdent());
    }//GEN-LAST:event_DeleteAccBtnActionPerformed
    private void EditAccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditAccBtnActionPerformed
        // TODO add your handling code here:
        ArrayList<String> secQ = new ArrayList<>();
        ArrayList<String> secA = new ArrayList<>();
        secQ.add(AccSQField1.getText());
        secQ.add(AccSQField2.getText());
        secQ.add(AccSQField3.getText());
        secA.add(AccSQAnswerField1.getText());
        secA.add(AccSQAnswerField2.getText());
        secA.add(AccSQAnswerField3.getText());
        this.writer.overWrite(this.AccountList.getSelectedValue().getIdent(), AccNameHolderField.getText(), AccUNField.getText(), AccPWField.getText(), secQ, secA);
        
        
        DefaultListModel<InfoUnit> list = (DefaultListModel<InfoUnit>) this.AccountList.getModel();
        this.AccountList.getSelectedValue().setSiteName(AccNameHolderField.getText());
        this.AccountList.getSelectedValue().setUsername(AccUNField.getText());
        this.AccountList.getSelectedValue().setPassword(AccPWField.getText());
        this.AccountList.getSelectedValue().setAllSecQuestions(secQ);
        this.AccountList.getSelectedValue().setAllSecAnswers(secA);
    }//GEN-LAST:event_EditAccBtnActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void display(Interface view) 
    /* MY SOLUTION:
        display is now a static function that operates on a view object
        see how it works in initializer
            -Maxwell
    */
    {
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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    view.setVisible(true);
                    
                }
            });
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccDisplayPan;
    private javax.swing.JTextField AccNameHolderField;
    private javax.swing.JTextField AccPWField;
    private javax.swing.JLabel AccPWLbl;
    private javax.swing.JTextField AccSQAnswerField1;
    private javax.swing.JTextField AccSQAnswerField2;
    private javax.swing.JTextField AccSQAnswerField3;
    private javax.swing.JTextField AccSQField1;
    private javax.swing.JTextField AccSQField2;
    private javax.swing.JTextField AccSQField3;
    private javax.swing.JLabel AccSQLbl1;
    private javax.swing.JLabel AccSQLbl2;
    private javax.swing.JLabel AccSQLbl3;
    private javax.swing.JTextField AccUNField;
    private javax.swing.JLabel AccUNLbl;
    private javax.swing.JList<InfoUnit> AccountList;
    private javax.swing.JButton AddAccountBtn;
    private javax.swing.JButton AddNewAccBtn;
    private javax.swing.JPanel BGPanel;
    private javax.swing.JPanel ChangingPanel;
    private javax.swing.JLabel ColorOptionsLbl;
    private javax.swing.JButton CreateNewAccBtn;
    private javax.swing.JLabel CreateNewAccPWLbl;
    private javax.swing.JLabel CreateNewAccUNLbl;
    private javax.swing.JLabel CreateNewAccWelcomeLbl;
    private javax.swing.JButton CreateUserAccBtn;
    private javax.swing.JButton DeleteAccBtn;
    private javax.swing.JButton EditAccBtn;
    private javax.swing.JPanel ExistingAccountPnl;
    private javax.swing.JLabel FontSizeLbl;
    private javax.swing.JComboBox<String> FontSizeSelection;
    private javax.swing.JPanel LoginAccPan;
    private javax.swing.JButton LoginOutBtn;
    private javax.swing.JLabel LoginPWLbl;
    private javax.swing.JButton LoginPgBtn;
    private javax.swing.JPanel LoginScreen;
    private javax.swing.JLabel LoginUNLbl;
    private javax.swing.JPanel NavMenu1;
    private javax.swing.JPanel NavigationScreen;
    private javax.swing.JTextField NewAccNameField;
    private javax.swing.JLabel NewAccNameLbl;
    private javax.swing.JTextField NewAccPWField;
    private javax.swing.JLabel NewAccPWLbl;
    private javax.swing.JPanel NewAccPan;
    private javax.swing.JTextField NewAccSQAnswerField4;
    private javax.swing.JTextField NewAccSQAnswerField5;
    private javax.swing.JTextField NewAccSQAnswerField6;
    private javax.swing.JTextField NewAccSQField4;
    private javax.swing.JTextField NewAccSQField5;
    private javax.swing.JTextField NewAccSQField6;
    private javax.swing.JLabel NewAccSQLbl1;
    private javax.swing.JLabel NewAccSQLbl2;
    private javax.swing.JLabel NewAccSQLbl3;
    private javax.swing.JTextField NewAccUNField;
    private javax.swing.JLabel NewAccUNLbl;
    private javax.swing.JPanel NewAccountPnl;
    private javax.swing.JPanel NewAccountScreen;
    private javax.swing.JLabel NewSQAnswerLbl1;
    private javax.swing.JLabel NewSQAnswerLbl2;
    private javax.swing.JLabel NewSQAnswerLbl3;
    private javax.swing.JButton PWCopyBtn;
    private javax.swing.JButton PasswordsBtn;
    private javax.swing.JPanel PasswordsPan;
    private javax.swing.JLabel PortunusLogo1;
    private javax.swing.JLabel SQAnswerLbl1;
    private javax.swing.JLabel SQAnswerLbl2;
    private javax.swing.JLabel SQAnswerLbl3;
    private javax.swing.JButton SQCopyBtn1;
    private javax.swing.JButton SQCopyBtn2;
    private javax.swing.JButton SQCopyBtn3;
    private javax.swing.JButton SettingsBtn;
    private javax.swing.JButton SettingsDoneBtn;
    private javax.swing.JPanel SettingsPan;
    private javax.swing.JButton ShowAccBtn;
    private javax.swing.JButton UNCopyBtn;
    private javax.swing.JColorChooser colorPicker;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
