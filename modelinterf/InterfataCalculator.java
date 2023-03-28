package modelinterf;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Monom;
import model.Polinom;


public class InterfataCalculator extends JFrame {

	private JPanel panel;
	private JLabel polinom1Label;
	private JTextField polinom1Field;
	private JLabel polinom2Label;
	private JTextField polinom2Field;
	private JLabel rezultatLabel;
	private JTextField rezultatField;
	 private JButton adunaButton, scadeButton, inmultesteButton, imparteButton, deriveazaButton, integreazaButton;
	private Pattern pattern;

	public InterfataCalculator() {
		super("Calculator Polinoame");

		// Crearea elementelor grafice
		panel = new JPanel();
		polinom1Label = new JLabel("Polinom 1:");
		polinom1Field = new JTextField(10);
		polinom2Label = new JLabel("Polinom 2:");
		polinom2Field = new JTextField(10);
		rezultatLabel = new JLabel("Rezultat:");
		rezultatField = new JTextField(10);
		rezultatField.setEditable(false);
		adunaButton = new JButton("Aduna");
		scadeButton = new JButton("Scade");
		inmultesteButton = new JButton("Inmulteste");
		deriveazaButton = new JButton("Deriveaza");
			pattern = Pattern.compile("^([+-]?\\d*\\*?[x]\\^\\d+\\s*)*[+-]?\\d*\\*?[x]?\\^?\\d*$");

		
		panel.add(polinom1Label);
		panel.add(polinom1Field);
		panel.add(polinom2Label);
		panel.add(polinom2Field);
		panel.add(rezultatLabel);
		panel.add(rezultatField);
		panel.add(adunaButton);
		panel.add(scadeButton);
		panel.add(inmultesteButton);
		panel.add(deriveazaButton);

		
		add(panel, BorderLayout.CENTER);

		
		adunaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Matcher matcher1 = pattern.matcher(polinom1Field.getText());
				Matcher matcher2 = pattern.matcher(polinom2Field.getText());
				if (!matcher1.matches() || !matcher2.matches()) {
					JOptionPane.showMessageDialog(null, "Polinoame invalide!", "Eroare", JOptionPane.ERROR_MESSAGE);
					return;
				}

				
				Polinom p1 = parsePolynomial(polinom1Field.getText());
				Polinom p2 = parsePolynomial(polinom2Field.getText());
				Polinom rezultat = p1.aduna(p2);
				rezultatField.setText(rezultat.toString());
			}
		});
		
		scadeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Matcher matcher1 = pattern.matcher(polinom1Field.getText());
				Matcher matcher2 = pattern.matcher(polinom2Field.getText());
				if (!matcher1.matches() || !matcher2.matches()) {
					JOptionPane.showMessageDialog(null, "Polinoame invalide!", "Eroare", JOptionPane.ERROR_MESSAGE);
					return;
				}

				
				Polinom p1 = parsePolynomial(polinom1Field.getText());
				Polinom p2 = parsePolynomial(polinom2Field.getText());
				Polinom rezultat = p1.scade(p2);
				rezultatField.setText(rezultat.toString());
			}
		});
		
		inmultesteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Matcher matcher1 = pattern.matcher(polinom1Field.getText());
				Matcher matcher2 = pattern.matcher(polinom2Field.getText());
				if (!matcher1.matches() || !matcher2.matches()) {
					JOptionPane.showMessageDialog(null, "Polinoame invalide!", "Eroare", JOptionPane.ERROR_MESSAGE);
					return;
				}

				
				Polinom p1 = parsePolynomial(polinom1Field.getText());
				Polinom p2 = parsePolynomial(polinom2Field.getText());
				Polinom rezultat = p1.inmulteste(p2);
				rezultatField.setText(rezultat.toString());
			}
		});
		
		deriveazaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Matcher matcher1 = pattern.matcher(polinom1Field.getText());
				Matcher matcher2 = pattern.matcher(polinom2Field.getText());
				if (!matcher1.matches() || !matcher2.matches()) {
					JOptionPane.showMessageDialog(null, "Polinoame invalide!", "Eroare", JOptionPane.ERROR_MESSAGE);
					return;
				}

				
				Polinom p1 = parsePolynomial(polinom1Field.getText());
				Polinom p2 = parsePolynomial(polinom2Field.getText());
				Polinom rezultat = p1.deriveaza(p2);
				rezultatField.setText(rezultat.toString());
			}
		});
		
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 600);
		setVisible(true);
	}

	
    private Polinom parsePolynomial(String input) {
    	  if (input == null || input.trim().isEmpty()) {
    	        return null;
    	    }

    	    List<Monom> monomials = new ArrayList<>();

    	   
    	    String[] monomialStrings = input.split("(?=[+-])");

    	   
    	    for (String monomialString : monomialStrings) {
    	        monomialString = monomialString.trim();

    	       
    	        if (monomialString.isEmpty()) {
    	            continue;
    	        }

    	        
    	        Matcher matcher = Pattern.compile("([+-]?\\d*)(x\\^(\\d+))?").matcher(monomialString);
    	        if (!matcher.matches()) {
    	            return null;
    	        }

    	        int coef = matcher.group(1).isEmpty() ? 1 : Integer.parseInt(matcher.group(1));
    	        int exp = matcher.group(3) == null ? 0 : Integer.parseInt(matcher.group(3));
    	        monomials.add(new Monom(coef, exp));
    	    }

    	  
    	    monomials.sort(Comparator.comparingInt(Monom::getExponent).reversed());

    	 
    	    Polinom result = new Polinom();
    	    for (Monom monom : monomials) {
    	        result.adaugaMonom(monom);
    	    }
    	    

    	    return result;
    }

}