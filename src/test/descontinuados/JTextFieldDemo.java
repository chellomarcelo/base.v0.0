package test.descontinuados;
import javax.swing.*;
import java.awt.*;
import java.io.*;
class JTextFieldDemo extends JFrame
{
JTextField t1,t2,t3,t4;

    public JTextFieldDemo()
    {
        createAndShowGUI();
    }
    
    private void createAndShowGUI()
    {
        setTitle("JTextField Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        // Empty one
        t1=new JTextField();
        
        // No.of cols
        t2=new JTextField(20);
        
        // Initial text
        t3=new JTextField("Third textfield");
        
        // Text and no.of cols
        t4=new JTextField("Fourth textfield",25);
        
        // Set text
        t1.setText("First field");
        t2.setText("Second field");
        
        // Get text
        System.out.println("Text in t1 "+t1.getText());
        
        // Set cols
        t1.setColumns(22);
        
        // Get columns
        System.out.println("Cols in t1 is "+t1.getColumns());
        
        // Set horizontal alignment
        // default is LEFT
        t1.setHorizontalAlignment(JTextField.CENTER);
        t2.setHorizontalAlignment(JTextField.RIGHT);
        
        // Set font
        t3.setFont(new Font("Tahoma",Font.PLAIN,18));
        
        // Set caret color
        t4.setCaretColor(Color.RED);
        
        // Select some text
        t1.select(0,5);
        t2.select(0,6);
        
        // Alternative ways for selecting
        // t1.setCaretPosition(0);
        // t1.moveCaretPosition(6);
        
        // t1.setSelectionStart(0);
        // t1.setSelectionEnd(4);
        
        // Get selected text
        System.out.println("Selected text in t1 "+t1.getSelectedText());
        
        // Set selection background color
        t1.setSelectionColor(Color.DARK_GRAY);
        
        // Set selected text color
        t1.setSelectedTextColor(Color.WHITE);
        
        // Set inner margin
        t4.setMargin(new Insets(5,5,5,5));
            
        // Replace selected text
        t2.replaceSelection("Two");
        
        // Write text in t1 to file
        try{
        t1.write(new FileWriter("t1.txt"));
        }catch(IOException e){}
        
        // Read from file and put in t4
        try{
        t4.read(new FileReader("t1.txt"),null);
        }catch(IOException e){}
        
        // Make t3 non editable
        t3.setEditable(false);
        
        // Disable t4
        t4.setEnabled(false);
        
        // Set disabled foreground
        t4.setDisabledTextColor(Color.BLUE);
        
        // Set focus accelerator
        // Alt+1 gives focus to t1
        t1.setFocusAccelerator('1');
        t2.setFocusAccelerator('2');
        
        // Copy selected text in t1 to clipboard
        t1.copy();
        
        // For cutting,
        // t2.cut();
        
        // Pasting..
        // t2.paste();
        
        // Add all
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        
        setSize(400,400);
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new JTextFieldDemo();
    }
}