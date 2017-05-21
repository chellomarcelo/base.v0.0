package test;
 
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
 
/**
 *
 * @author beastieux
 */
public class Ejm07_EventoTextFieldChanged extends JFrame{
 
    private JTextField txtEjemplo;
    private JLabel lblEjemplo;
 
    public Ejm07_EventoTextFieldChanged()
    {
        txtEjemplo=new JTextField();
        lblEjemplo=new JLabel();
        this.add(txtEjemplo);
        this.add(lblEjemplo);
        this.setLayout(new GridLayout(1,1));
        this.setSize(400, 80);
 
        setJTexFieldChanged(txtEjemplo);
    }
 
    private void setJTexFieldChanged(JTextField txt) {
        DocumentListener documentListener = new DocumentListener() {
 
        @Override
        public void changedUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }
 
        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }
 
        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }};
        
        txt.getDocument().addDocumentListener(documentListener);
    }
 
    private void printIt(DocumentEvent documentEvent) {
        DocumentEvent.EventType type = documentEvent.getType();
 
        if (type.equals(DocumentEvent.EventType.CHANGE)){
 
        }
        else if (type.equals(DocumentEvent.EventType.INSERT))        {
            txtEjemploJTextFieldChanged();
        }
        else if (type.equals(DocumentEvent.EventType.REMOVE))        {
            txtEjemploJTextFieldChanged();
        }
    }
 
    private void txtEjemploJTextFieldChanged()    {
        //Copiar el contenido del jtextfield al jlabel
    	//this.lblEjemplo.setText("fff");
        this.lblEjemplo.setText(this.txtEjemplo.getText());
    }
 
    public static void main(String args[]) {
        Ejm07_EventoTextFieldChanged obj = new Ejm07_EventoTextFieldChanged();
        obj.setVisible(true);
    }
}
