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
public class LinearEquation extends JPanel {
	private static final long serialVersionUID = 699625817488818771L;
	Solver solver;
	JButton calculateBtn;
	JTextField a, b;
	/**
	 * 
	 */
	public LinearEquation() {
		this.setLayout(new BorderLayout());
		JPanel termPanel = new JPanel();
		termPanel.setLayout(new GridLayout(2, 2));
		a = new JTextField("");
		b = new JTextField("");
		termPanel.add(new JLabel("Hệ số A"));
		termPanel.add(a);
		termPanel.add(new JLabel("Hệ số B"));
		termPanel.add(b);
		calculateBtn = new JButton("Tính nghiệm");
		
		this.add(new JLabel("<html><font color=\"red\">Ax + B = 0</font></html>", JLabel.CENTER), BorderLayout.NORTH);
		this.add(termPanel, BorderLayout.CENTER);
		this.add(calculateBtn, BorderLayout.SOUTH);
		
		this.calculateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String termA, termB;
				termA = a.getText();
				termB = b.getText();
				boolean isValidated = Solver.validateTerms(EquationType.LINEAR_EQUATION, termA, termB);
				if (isValidated) {
					Vector<Double> terms = new Vector<Double>();
					terms.add(Double.parseDouble(termA));
					terms.add(Double.parseDouble(termB));
					solver = new Solver(terms, EquationType.LINEAR_EQUATION);
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
