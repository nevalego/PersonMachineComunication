package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import logic.Item;
import javax.swing.BoxLayout;

public class PanelItem extends JPanel {

	private static final long serialVersionUID = 1L;
	private Item item = null;
	private int units = 0;
	private JPanel pnItemInfo;
	private JLabel lblItemName;
	private JPanel pnPrices;
	private JLabel lblUnitPrice;
	private JTextField txtUnitPrice;
	private JLabel lblGroupPrice;
	private JTextField txtGroupPrice;
	private JLabel lblUnits;
	private JTextField txtUnits;
	private JPanel pnCenter;
	private JPanel pnTitle;
	private JLabel label;
	private JTextField txtUnitsToRemove;

	private PartyApp p;

	/**
	 * Create the panel.
	 */
	public PanelItem(Item i, int units, PartyApp p) {
		this.p = p;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		item = i;
		this.units = units;
		setLayout(new GridLayout(1, 0, 0, 0));
		add(getPnItemInfo());

	}

	public Item getItem() {
		return item;
	}

	private JPanel getPnItemInfo() {
		if (pnItemInfo == null) {
			pnItemInfo = new JPanel();
			pnItemInfo.setBackground(new Color(221, 160, 221));
			pnItemInfo.setLayout(new BorderLayout(0, 0));
			pnItemInfo.add(getPnCenter(), BorderLayout.CENTER);
			pnItemInfo.add(getPnTitle(), BorderLayout.NORTH);
		}
		return pnItemInfo;
	}

	private JLabel getLblItemName() {
		if (lblItemName == null) {
			lblItemName = new JLabel("");
			lblItemName.setForeground(Color.WHITE);
			lblItemName.setBackground(new Color(219, 112, 147));
			lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblItemName.setText(item.getName());
		}
		return lblItemName;
	}

	private JPanel getPnPrices() {
		if (pnPrices == null) {
			pnPrices = new JPanel();
			pnPrices.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnPrices.setBackground(Color.WHITE);
			pnPrices.setLayout(new BoxLayout(pnPrices, BoxLayout.X_AXIS));
			pnPrices.add(getLblUnitPrice());
			pnPrices.add(getTxtUnitPrice());
			pnPrices.add(getLblGroupPrice());
			pnPrices.add(getTxtGroupPrice());
			pnPrices.add(getLblUnits());
			pnPrices.add(getTxtUnits());
		}
		return pnPrices;
	}

	private JLabel getLblUnitPrice() {
		if (lblUnitPrice == null) {
			lblUnitPrice = new JLabel("Unit price:");
			lblUnitPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblUnitPrice;
	}

	private JTextField getTxtUnitPrice() {
		if (txtUnitPrice == null) {
			txtUnitPrice = new JTextField();
			txtUnitPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtUnitPrice.setColumns(10);
			txtUnitPrice.setText(String.valueOf(item.getUnitPrice()) + " €");
		}
		return txtUnitPrice;
	}

	private JLabel getLblGroupPrice() {
		if (lblGroupPrice == null) {
			lblGroupPrice = new JLabel("Group price:");
			lblGroupPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblGroupPrice;
	}

	private JTextField getTxtGroupPrice() {
		if (txtGroupPrice == null) {
			txtGroupPrice = new JTextField();
			txtGroupPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtGroupPrice.setColumns(10);
			txtGroupPrice.setText(String.valueOf(item.getGroupPrice()) + " €");
		}
		return txtGroupPrice;
	}

	private JLabel getLblUnits() {
		if (lblUnits == null) {
			lblUnits = new JLabel("Units:");
			lblUnits.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblUnits;
	}

	private JTextField getTxtUnits() {
		if (txtUnits == null) {
			txtUnits = new JTextField();
			txtUnits.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtUnits.setText("1");
			txtUnits.setColumns(10);
			txtUnits.setText(String.valueOf(units));
		}
		return txtUnits;
	}

	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			pnCenter.setLayout(new GridLayout(1, 0, 0, 0));
			pnCenter.add(getPnPrices());
		}
		return pnCenter;
	}

	private JPanel getPnTitle() {
		if (pnTitle == null) {
			pnTitle = new JPanel();
			pnTitle.setBackground(new Color(219, 112, 147));
			pnTitle.setLayout(new GridLayout(1, 0, 0, 0));
			pnTitle.add(getLblItemName());
		}
		return pnTitle;
	}
}
