/**
 * 
 */
package gui;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.EquationType;

/**
 * @author ngbaanh
 *
 */
public class EquationSelector extends JPanel {
	private static final long serialVersionUID = 5315741973675016585L;
	private JLabel equationNameLabel;
	private JComboBox<EquationType> equationTypeComboBox;
	
	public EquationSelector() {
		this.setLayout(new GridLayout(2, 1));
		
		this.equationNameLabel = new JLabel("Xin chọn loại phương trình");
		EquationType[] types = EquationType.values();
		this.equationTypeComboBox = new JComboBox<EquationType>(types);
		this.equationTypeComboBox.setLightWeightPopupEnabled(true);
		
		this.add(equationNameLabel);
		this.add(equationTypeComboBox);
	}
	
	public JLabel getEquationNameLabel() {
		return equationNameLabel;
	}
	
	public void setEquationNameLabel(JLabel equationNameLabel) {
		this.equationNameLabel = equationNameLabel;
	}
	
	public JComboBox<EquationType> getEquationTypeComboBox() {
		return equationTypeComboBox;
	}
	
	public void setEquationTypeComboBox(JComboBox<EquationType> equationTypeComboBox) {
		this.equationTypeComboBox = equationTypeComboBox;
	}
	
	

}
