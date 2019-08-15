import java.awt.*;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
public class TemperatureConverter extends JFrame {
	double newTemperature,initialTemperature;
    JLabel unit, heading, input, output, result;
    JTextField temperature;
    JButton convert;
    JRadioButton fC;
    JRadioButton cF;
   
    public TemperatureConverter () 
    {
        super ("Temerature Converter");
        setLayout (new FlowLayout ());
        
        heading = new JLabel ("Temperature Converter\n", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        heading.setForeground(Color.RED);
        
        unit = new JLabel ("Choose Conversion Type: ", SwingConstants.CENTER);
       
        fC = new JRadioButton("Fahrenheit To Celsius", true);
        fC.setHorizontalAlignment(SwingConstants.CENTER);
        cF = new JRadioButton("Celsius To Fahrenheit", true);
        cF.setHorizontalAlignment(SwingConstants.CENTER);  
        ButtonGroup bg = new ButtonGroup();
        bg.add(fC);
        bg.add(cF);
        
        input = new JLabel ("Enter the temperature to convert: ", SwingConstants.LEFT);
        
        temperature = new JTextField();
        
        convert = new JButton ("Convert Temperature");
        convert.setHorizontalAlignment(SwingConstants.CENTER);
        
        output = new JLabel("The temperature converts to: ", SwingConstants.LEFT);
        result = new JLabel ("");
        JPanel panel1 = new JPanel(new GridLayout(4, 1, 12, 6));      
        panel1.add(heading);
        panel1.add(unit); 
        panel1.add(fC);
        panel1.add(cF);
        JPanel panel2 = new JPanel(new GridLayout(2, 1, 12, 6));
        panel2.add(input);
        panel2.add(temperature);
        panel2.add(output);
        panel2.add(result);
        JPanel panel3 = new JPanel(new GridLayout(1, 1, 12, 6));
        panel3.add(convert);
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
        convert.addActionListener(new Convert());
    }

    private class Convert implements ActionListener 
    {
        public void actionPerformed(ActionEvent event) 
        {
        	initialTemperature = Double.parseDouble(temperature.getText());
        	DecimalFormat df1 = new DecimalFormat(".#");
        	if (fC.isSelected()){
                newTemperature = (initialTemperature - 32)* (5.0/9.0);
                result.setText(" "+ df1.format(newTemperature) +" degrees Celsius");
            }
            else if(cF.isSelected()){
            	newTemperature = (initialTemperature* (9.0/5.0)) + 32;
                result.setText(" "+ df1.format(newTemperature) +" degrees Fahrenheit");
            }
        } 
    } 

    public static void main(String[] args)
    {
        TemperatureConverter test = new TemperatureConverter ();
        test.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        test.setSize (500, 300);
        test.setVisible (true); 
    }

}