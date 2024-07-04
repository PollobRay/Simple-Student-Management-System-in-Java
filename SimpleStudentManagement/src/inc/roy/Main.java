package inc.roy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Main extends JFrame implements ActionListener {

    private Container c;
    private JLabel titleLabel, fnLabel, lnLabel, PhoneLabel, gpaLabel;
    private JTextField fnTf, lnTf, phoneTf, gpaTf;
    private JButton addButton, updateButton, deleteButton, clearButton;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    
    String []columns={"First Name","Last Name","Phone Number","GPA"};
    String []rows=new String[4];
    
    Main()
    {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(780,690);
    this.setLocationRelativeTo(null);
    this.setTitle("Student Tabel");
    
    c=this.getContentPane();
    c.setLayout(null);
    c.setBackground(Color.PINK);
    
    Font font=new Font("Arial",Font.BOLD,16);
    
    titleLabel=new JLabel("Student Registation");
    titleLabel.setFont(font);
    titleLabel.setBounds(140,10,250,50);
    c.add(titleLabel);
    
    fnLabel=new JLabel("First Name");
    fnLabel.setBounds(10, 80, 140, 30);
    fnLabel.setFont(font);
    c.add(fnLabel);
    
    fnTf=new JTextField();
    fnTf.setBounds(110,80,200,30);
    fnTf.setFont(font);
    c.add(fnTf);
    
    addButton=new JButton("Add");
    addButton.setBounds(400,80,100,30);
    addButton.setFont(font);
    c.add(addButton);
    
    lnLabel=new JLabel("Last Name");
    lnLabel.setBounds(10,130,150,30);
    lnLabel.setFont(font);
    c.add(lnLabel);
    
    lnTf=new JTextField();
    lnTf.setBounds(110,130,200,30);
    lnTf.setFont(font);
    c.add(lnTf);
    
    updateButton=new JButton("Upadate");
    updateButton.setBounds(400,130,100,30);
    updateButton.setFont(font);
    c.add(updateButton);
    
    PhoneLabel=new JLabel("Phone");
    PhoneLabel.setBounds(10,180,150,30);
    PhoneLabel.setFont(font);
    c.add(PhoneLabel);
    
    phoneTf=new JTextField();
    phoneTf.setBounds(110,180,200,30);
    phoneTf.setFont(font);
    c.add(phoneTf);
    
    deleteButton=new JButton("Delete");
    deleteButton.setBounds(400,180,100,30);
    deleteButton.setFont(font);
    c.add(deleteButton);
    
    gpaLabel=new JLabel("GPA");
    gpaLabel.setBounds(10,230,150,30);
    gpaLabel.setFont(font);
    c.add(gpaLabel);
    
    gpaTf=new JTextField();
    gpaTf.setBounds(110,230,200,30);
    gpaTf.setFont(font);
    c.add(gpaTf);
    
    clearButton=new JButton("Clear");
    clearButton.setBounds(400,230,100,30);
    clearButton.setFont(font);
    c.add(clearButton);
    
    
    table=new JTable();
    model=new DefaultTableModel();
    model.setColumnIdentifiers(columns);
    table.setModel(model);
    table.setFont(font);
    table.setSelectionBackground(Color.GREEN);
    
    table.setBackground(Color.WHITE);
    table.setRowHeight(30);
    
    scroll=new JScrollPane(table);
    scroll.setBounds(10,360,740,256);
    c.add(scroll);
    
    addButton.addActionListener(this);
    clearButton.addActionListener(this);
    deleteButton.addActionListener(this);
    updateButton.addActionListener(this);
    
    
    table.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
            {
                int numberofrow=table.getSelectedRow();
                String fname=model.getValueAt(numberofrow,0).toString();
                String lname=model.getValueAt(numberofrow, 1).toString();  
                String phone=model.getValueAt(numberofrow, 2).toString(); 
                String gpa=model.getValueAt(numberofrow, 3).toString(); 
                
                fnTf.setText(fname);
                lnTf.setText(lname);
                phoneTf.setText(phone);
                gpaTf.setText(gpa);
            }
            });
    
 
    
    
    
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==addButton)
       {
           rows[0]=fnTf.getText();
           rows[1]=lnTf.getText();
           rows[2]=phoneTf.getText();
           rows[3]=gpaTf.getText();
           
           model.addRow(rows);
       }
       else if(e.getSource()==clearButton)
       {
           fnTf.setText("");
           lnTf.setText("");
           phoneTf.setText("");
           gpaTf.setText("");
       }
       else if(e.getSource()==deleteButton)
       {
           int num=table.getSelectedRow();
           
           if(num>=0)
           {
               model.removeRow(num);
           }
           else
           {
               JOptionPane.showMessageDialog(null,"No Row Selected");
           }
       }
       else if(e.getSource()==updateButton)
       {
           int num=table.getSelectedRow();
           
           if(num>=0)
           {
           String fname=fnTf.getText();
           String lname=lnTf.getText();
           String phone=phoneTf.getText();
           String gpa=gpaTf.getText();
           
           model.setValueAt(fname, num, 0);
           model.setValueAt(lname,num,1);
           model.setValueAt(phone,num,2);
           model.setValueAt(gpa,num,3);
           }
       }
    }
    
    public static void main(String[] args) {
        
        
        Main m=new Main();
        m.setVisible(true);
    }
}
