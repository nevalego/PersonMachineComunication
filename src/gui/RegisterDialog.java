package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.Customer;

public class RegisterDialog extends JDialog {

	private JPanel contentPane;
	private PartyApp partyApp = null;
	private JPanel pnFill;
	private JPanel pnUsername;
	private JPanel pnPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JTextField txtUsername;
	private JButton btnRegister;
	private JLabel lblCreatingAccount;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public RegisterDialog(PartyApp partyApp) {
		setModal(true);
		setTitle("Registration");
		this.partyApp = partyApp;

		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterDialog.class.getResource("/img/logo.jpg")));
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnFill());
		contentPane.add(getLblCreatingAccount(), BorderLayout.NORTH);
	}

	private JPanel getPnFill() {
		if (pnFill == null) {
			pnFill = new JPanel();
			pnFill.setBackground(Color.WHITE);
			pnFill.setLayout(new GridLayout(0, 1, 0, 0));
			pnFill.add(getPnUsername());
			pnFill.add(getPnPassword());
			pnFill.add(getBtnRegister());
			pnFill.add(getBtnCancel());
		}
		return pnFill;
	}

	private JPanel getPnUsername() {
		if (pnUsername == null) {
			pnUsername = new JPanel();
			pnUsername.setBackground(Color.WHITE);
			pnUsername.setLayout(new GridLayout(1, 0, 0, 0));
			pnUsername.add(getLblUsername());
			pnUsername.add(getTxtUsername());
		}
		return pnUsername;
	}

	private JPanel getPnPassword() {
		if (pnPassword == null) {
			pnPassword = new JPanel();
			pnPassword.setBackground(Color.WHITE);
			pnPassword.setLayout(new GridLayout(1, 0, 0, 0));
			pnPassword.add(getLblPassword());
			pnPassword.add(getPasswordField());
		}
		return pnPassword;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setDisplayedMnemonic('U');
			lblUsername.setToolTipText("Fill username in its text field");
			lblUsername.setLabelFor(getTxtUsername());
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setToolTipText("Fill password in its text field");
			lblPassword.setLabelFor(getPasswordField());
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblPassword;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setToolTipText("Text field for password");
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return passwordField;
	}

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setToolTipText("Text field for username");
			txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Register");
			btnRegister.setToolTipText("Click here to register");
			btnRegister.setMnemonic('R');
			btnRegister.setForeground(Color.WHITE);
			btnRegister.setBackground(new Color(219, 112, 147));
			btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					register();

				}
			});
		}
		return btnRegister;
	}

	/**
	 * Logging in an existing username or register a new one and log in
	 */
	protected void register() {

		// User is already registered -> check password
		if (partyApp.getOrganizer().existsUser(txtUsername.getText())) {

			Customer existing = partyApp.getOrganizer().getCustomerByUsername(txtUsername.getText());

			if (existing.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
				partyApp.getParty().setCustomer(existing);
				closeDialog();
			} else {
				JOptionPane.showMessageDialog(btnRegister, "Wrong password for this username", "Wrong password",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {

			// New user customer registring
			partyApp.getCustomer().logIn(txtUsername.getText(), String.valueOf(passwordField.getPassword()));
			Customer c = partyApp.getCustomer();
			partyApp.getOrganizer().registerClient(c);
			partyApp.getParty().setCustomer(c);
			closeDialog();

		}
	}

	protected void closeDialog() {

		this.setVisible(false);

	}

	private JLabel getLblCreatingAccount() {
		if (lblCreatingAccount == null) {
			lblCreatingAccount = new JLabel("Creating Account");
			lblCreatingAccount.setBackground(new Color(255, 255, 255));
			lblCreatingAccount.setForeground(new Color(0, 0, 0));
			lblCreatingAccount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return lblCreatingAccount;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setMnemonic('C');
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					closeDialog();
				}
			});
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnCancel.setBackground(new Color(255, 255, 255));
		}
		return btnCancel;
	}
}
