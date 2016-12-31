/**
 * 
 */
package app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.EquationSelector;
import gui.LinearEquation;
import gui.PolynomialEquation;

/**
 * @author ngbaanh
 *
 */
public class Main {
	JFrame mainFrame;
	EquationSelector equationSelector;
	JPanel equationDetail;

	public Main() {
		mainFrame = new JFrame("Giải phương trình");
		mainFrame.setBounds(200, 200, 400, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout());

		equationSelector = new EquationSelector();
		mainFrame.add(equationSelector, BorderLayout.NORTH);

		equationDetail = new JPanel();
		equationDetail.setLayout(new GridLayout(1, 1));
		equationDetail.add(new LinearEquation());

		mainFrame.add(equationDetail, BorderLayout.CENTER);
		mainFrame.setVisible(true);
		
		// Bắt event cho combobox
		this.equationSelector.getEquationTypeComboBox().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Xác định kiểu phương trình đã chọn
				@SuppressWarnings("rawtypes")
				JComboBox cBox = (JComboBox) e.getSource();
				EquationType type = (EquationType) cBox.getSelectedItem();
				
				equationDetail.removeAll(); // Xoá giao diện phương trình hiện tại 
				
				// Nạp lại giao diện phương trình mới vừa chọn
				switch (type) {
				case LINEAR_EQUATION: // PT bậc nhất 
					equationDetail.add(new LinearEquation());
					break;
				case POLYNOMIAL_EQUATION: // PT bậc 2
					equationDetail.add(new PolynomialEquation());
					break;
				default:
					break;
				}
				mainFrame.repaint();
				mainFrame.revalidate();
			}
		});
	}

	public static void main(String[] args) {
		new Main();
	}

}
