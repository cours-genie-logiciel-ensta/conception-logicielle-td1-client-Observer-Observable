
package banqueServer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//## dependency swing 
//## class DerniereOperationGUI 
import javax.swing.JFrame;
//## dependency JTextField 
import javax.swing.JTextField;

/**
 * Une interface graphique triviale (un seul {@link JTextField}) qui affiche un
 * label représentant la dernière opération
 *
 */
@SuppressWarnings("serial")
public class DerniereOperationGUI extends JFrame implements PropertyChangeListener {

	private final JTextField derniereOperationTextField;

	public DerniereOperationGUI(Banque banque) {
		super();

		// On "écoute" la banque
		banque.getPropertyChangeSupport().addPropertyChangeListener(this);

		this.setTitle("Dernière opération");
		derniereOperationTextField = new javax.swing.JTextField();
		this.add(derniereOperationTextField);

		derniereOperationTextField.setBackground(new java.awt.Color(255, 128, 0));
		derniereOperationTextField.setPreferredSize(new java.awt.Dimension(250, 108));
		derniereOperationTextField.setFont(new java.awt.Font("Antique Olive", 1, 20));
		derniereOperationTextField.setText(String.valueOf(banque.getTypeOperation()));
		this.pack();
		this.setVisible(true);
		getContentPane().setBackground(new java.awt.Color(255, 128, 64));
		getContentPane().setForeground(new java.awt.Color(255, 128, 0));
	}

	/**
	 * Cette méthode est appelée quand un objet "écouté" notifie une modification
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() instanceof Banque) {
			if (evt.getPropertyName().equals("typeOperation")) {
				derniereOperationTextField.setText(((Banque) evt.getSource()).getTypeOperation());
			}
		}
	}
}
