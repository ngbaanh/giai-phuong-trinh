/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.EquationType;
import app.Solver;

/**
 * @author ngbaanh
 *
 */
public class PolynomialEquation extends JPanel {
	private static final long serialVersionUID = -2180423182051280834L;
	Solver solver;
	JButton calculateBtn;
	JTextField a, b, c;
	/**
	 * 
	 */
	public PolynomialEquation() {
		this.setLayout(new BorderLayout());
		JPanel termPanel = new JPanel();
		termPanel.setLayout(new GridLayout(3, 2));
		a = new JTextField("");
		b = new JTextField("");
		c = new JTextField("");
		termPanel.add(new JLabel("Hệ số A"));
		termPanel.add(a);
		termPanel.add(new JLabel("Hệ số B"));
		termPanel.add(b);
		termPanel.add(new JLabel("Hệ số C"));
		termPanel.add(c);
		calculateBtn = new JButton("Tính nghiệm");
		
		this.add(new JLabel("<html><font color=\"red\">Ax² + Bx + C = 0</font></html>", JLabel.CENTER), BorderLayout.NORTH);
		this.add(termPanel, BorderLayout.CENTER);
		this.add(calculateBtn, BorderLayout.SOUTH);
		
		this.calculateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String termA, termB, termC;
				termA = a.getText();
				termB = b.getText();
				termC = c.getText();
				boolean isValidated = Solver.validateTerms(EquationType.POLYNOMIAL_EQUATION, termA, termB, termC);
				if (isValidated) {
					Vector<Double> terms = new Vector<Double>();
					terms.add(Double.parseDouble(termA));
					terms.add(Double.parseDouble(termB));
					terms.add(Double.parseDouble(termC));
					solver = new Solver(terms, EquationType.POLYNOMIAL_EQUATION);
					if (solver.isInconsistent()) {
						JOptionPane.showMessageDialog(null, "Vô nghiệm", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
					} else if (solver.isInfinite()) {
						JOptionPane.showMessageDialog(null, "Vô số nghiệm", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
					} else if (solver.isConsistent()) {
						JOptionPane.showMessageDialog(null, "Nghiệm: \n" + solver.getRoot(), "Kết quả", JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Đầu vào phải là số thực và đầy đủ giá trị!", "Sai Input", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}

}
