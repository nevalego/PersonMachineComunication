package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import logic.Customer;
import logic.Item;
import logic.ItemCategory;
import logic.Party;
import logic.PartyOrganizer;

public class PartyApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;

	private PartyOrganizer organizer = null;;
	private Party p = null;

	private JMenu mnParty;
	private JMenuItem menuItemExit;
	private JMenu mnHelp;
	private JMenuItem mntmContents;
	private JMenuItem mntmAbout;
	private JSeparator separator;
	private JButton btnGo;
	private JPanel pnPrincipal;
	private JPanel pnCards;
	private JPanel pnItemsAvailable;
	private JPanel pnFilters;
	private JCheckBox chckbxFood;
	private JCheckBox chckbxDrink;
	private JCheckBox chckbxPlace;
	private JLabel lblFilters;
	private JCheckBox chckbxDecoration;
	private JCheckBox chckbxOthers;
	private JButton btnSeeOrder;
	private JLabel lblChooseTheItems;

	private List<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
	private JPanel pnData;
	private JPanel pnDataTitle;
	private JTextField txtCurrentShoppingCard;
	private JPanel pnOrderData;
	private JPanel pnNameData;
	private JLabel lblName;
	private JTextField txtNameData;
	private JPanel pnSurnameData;
	private JLabel lblSurname;
	private JTextField txtSurnameData;
	private JPanel pnNIFData;
	private JLabel lblNumAttData;
	private JTextField txtNumAttData;
	private JPanel pnTotalPrice;
	private JPanel pnComents;
	private JLabel lblComentHere;
	private JPanel pnDate;
	private JSpinner spDay;
	private JLabel lblDay;
	private JLabel lblMonth;
	private JSpinner spMonth;
	private JLabel lblYear;
	private JSpinner spYear;
	private JTextField txtFinalPrice;
	private JPanel pnAttData;
	private JLabel lblNif;
	private JTextField txtNIFData;
	private JPanel pnDay;
	private JPanel pnMonth;
	private JPanel pnYear;
	private JTextArea tACommentsData;
	private JMenuItem menuItemBegin;
	private JSeparator sepNew;
	private JSeparator sepOrder;
	private JMenuItem menuItemPrint;
	private JLabel lblFinalPrice;
	private JPanel pnHour;
	private JPanel pnMinutes;
	private JLabel lblHour;
	private JLabel lblMinutes;
	private JSpinner spHour;
	private JSpinner spMinutes;
	private JLabel lblLogoWelcome;
	private JPanel pnCenter;
	private JPanel pnLogoWelcome;
	private JPanel pnSummary;
	private JPanel pnButtons;
	private JButton btnConfirm;
	private JPanel pnBillSummary;
	private JButton btnRegister;
	private JPanel pnListCardAtt;
	private JPanel pnRightAttendanceOrder;
	private JPanel pnItems;
	private JLabel lblNumberOfAttendants;
	private JTextField txtNAttendants;
	private JPanel pnSouthOrder;
	private JPanel pnCard;
	private JPanel pnCardTitle;
	private JLabel lblCardOfThe;
	private JButton btnBack;
	private JPanel pnCardItems;
	private JPanel pnAvailableItems;
	private JScrollPane spAvailableItems;
	private JPanel pnRight;
	private JButton btnClearAll;
	private JPanel pnLogging;
	private JButton btnCancel;
	private JPanel pnItem;
	private JTextArea textAreaDescriptionItem;
	private JLabel lblImageItem;
	private JPanel pnImagePrice;
	private JTextField txtPrice;
	private JPanel pnAttendanceNorth;
	private JList<Item> listAllItems;
	private DefaultListModel<Item> modelAllItems = new DefaultListModel<>();
	private JPanel pnButtonsItem;
	private JButton btnAddItem;
	private JTextField txtNameItem;
	private JPanel pnDescrImage;

	private Item selected;
	private JPanel pnPriceItem;
	private JLabel lblUnits;
	private JPanel pnUnitsItem;
	private JSpinner spUnitsItem;
	private JPanel pnUserName;
	private JLabel lblUserName;
	private JPanel pnGo;
	private JPanel pnTitleFilters;
	private JPanel pnFinalPriceCard;
	private JLabel lblFinalPriceCard;
	private JPanel pnTelephoneData;
	private JLabel lblTelephoneData;
	private JTextField txtTelephoneData;

	private int cardNumber = 0;
	private JTextArea textAreaBill;
	private JPanel pnLeft;
	private JPanel pnItemCard;
	private JPanel pnItemsCard;
	private JPanel pnRemoveItemCard;
	private JButton btnRemove;
	private JLabel lblUnitsToRemove;
	private JSpinner spUnitsToRemove;
	private JPanel pnItemCardData;
	private JLabel lblImageItemCard;
	private JPanel pnPriceUnitsItemCard;
	private JTextArea tADescriptionOfThe;
	private JLabel lblItemName;
	private JScrollPane spItemsCard;
	private JList<Item> listItemsCard;
	private DefaultListModel<Item> modelCardItems = new DefaultListModel<>();
	private JLabel lblItemsOfThe;
	private JLabel lblPriceItemCard;
	private JLabel lblUnitsCard;
	private JLabel lblPriceItemCardFinal;
	private JLabel lblTotalCard;
	private JPanel pnInfo;
	private JPanel pnDataCenter;
	private JPanel pnCommentsDate;
	private JPanel panelPriceData;
	private JPanel pnUppButtons;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartyApp frame = new PartyApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PartyApp() {
		setBackground(Color.WHITE);
		organizer = new PartyOrganizer("src/files/party.txt");
		p = new Party();
		selected = null;
		setIconImage(Toolkit.getDefaultToolkit().getImage(PartyApp.class.getResource("/img/logo.jpg")));
		setTitle("Party Organizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1278, 615);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnButtons(), BorderLayout.SOUTH);
		contentPane.add(getPnLogging(), BorderLayout.NORTH);
		contentPane.add(getPnCards(), BorderLayout.CENTER);
		setContentPane(contentPane);

		loadHelp();
		loadItems(true, true, true, true, true);
		hideButtons();
	}

	private void loadHelp() {

		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("help/Ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);// Creates helpset object
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(this, "HelpSet file not found");
			return;
		}

		HelpBroker hb = hs.createHelpBroker();// Create HelpBroker to easy visualization
		hb.initPresentation();

		hb.enableHelpKey(getRootPane(), "introduction", hs);// F1
		hb.enableHelpOnButton(mntmContents, "introduction", hs);// On menu Help-Contents

	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
			menuBar.add(getMnParty());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnParty() {
		if (mnParty == null) {
			mnParty = new JMenu("Party");
			mnParty.setMnemonic('P');
			mnParty.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnParty.add(getMenuItemBegin());
			mnParty.add(getSepNew());
			mnParty.add(getSepOrder());
			mnParty.add(getMenuItemPrint());
			mnParty.add(getMenuItemExit());
		}
		return mnParty;
	}

	private JMenuItem getMenuItemExit() {
		if (menuItemExit == null) {
			menuItemExit = new JMenuItem("Exit");
			menuItemExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			menuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
			menuItemExit.setFont(new Font("Arial", Font.PLAIN, 15));
		}
		return menuItemExit;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('H');
			mnHelp.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnHelp.add(getMntmContents());
			mnHelp.add(getSeparator());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
			mntmContents.setFont(new Font("Arial", Font.PLAIN, 15));
			mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_HELP, 0));
		}
		return mntmContents;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setFont(new Font("Arial", Font.PLAIN, 15));
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));

			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(getContentPane(),
							"Party Organizer App\nAutor Nerea Valdés Egocheaga\nVersión 3.12.2018",
							"About Party Organizer", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mntmAbout;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JButton getBtnGo() {
		if (btnGo == null) {
			btnGo = new JButton("Start");
			btnGo.setHorizontalTextPosition(SwingConstants.CENTER);
			btnGo.setVerticalAlignment(SwingConstants.BOTTOM);
			btnGo.setForeground(new Color(255, 255, 255));
			btnGo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btnGo.setMnemonic('S');
			btnGo.setBackground(new Color(219, 112, 147));
			btnGo.setFont(new Font("Tahoma", Font.PLAIN, 36));
			btnGo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					nextCard();
				}
			});
		}
		return btnGo;
	}

	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setBackground(new Color(255, 255, 255));
			pnPrincipal.setLayout(new BorderLayout(0, 0));
			pnPrincipal.add(getPnCenter(), BorderLayout.CENTER);
		}
		return pnPrincipal;
	}

	private JPanel getPnCards() {
		if (pnCards == null) {
			pnCards = new JPanel();
			pnCards.setBackground(new Color(255, 255, 255));
			pnCards.setLayout(new CardLayout(0, 0));
			pnCards.add(getPnPrincipal(), "principal");
			pnCards.add(getPnItemsAvailable(), "items");
			pnCards.add(getPnCard(), "card");
			pnCards.add(getPnData(), "data");
			pnCards.add(getPnSummary(), "summary");
		}
		return pnCards;
	}

	private JPanel getPnItemsAvailable() {
		if (pnItemsAvailable == null) {
			pnItemsAvailable = new JPanel();
			pnItemsAvailable.setBackground(new Color(255, 255, 255));
			pnItemsAvailable.setLayout(new GridLayout(0, 2, 0, 0));
			pnItemsAvailable.add(getPnItems());
			pnItemsAvailable.add(getPnItem());
		}
		return pnItemsAvailable;
	}

	protected void nextCard() {
		((CardLayout) pnCards.getLayout()).next(pnCards);
		cardNumber++;
		if (cardNumber == 5) {
			hideButtons();
		} else
			showButtons();
		if (cardNumber != 2)
			btnSeeOrder.setEnabled(true);
	}

	protected void previousCard() {
		((CardLayout) pnCards.getLayout()).previous(pnCards);
		cardNumber--;
		if (cardNumber == 0) {
			hideButtons();
			toFirst();
		} else
			showButtons();
		if (cardNumber != 2)
			btnSeeOrder.setEnabled(true);
	}

	private void hideButtons() {
		btnBack.setEnabled(false);
		btnBack.setVisible(false);
		btnConfirm.setEnabled(false);
		btnConfirm.setVisible(false);
		btnCancel.setEnabled(false);
		btnCancel.setVisible(false);
	}

	private void showButtons() {
		btnBack.setEnabled(true);
		btnBack.setVisible(true);
		btnConfirm.setEnabled(true);
		btnConfirm.setVisible(true);
		btnCancel.setEnabled(true);
		btnCancel.setVisible(true);
	}

	private JPanel getPnFilters() {
		if (pnFilters == null) {
			pnFilters = new JPanel();
			pnFilters.setForeground(new Color(255, 255, 255));
			pnFilters.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnFilters.setBackground(new Color(219, 112, 147));
			pnFilters.setLayout(new GridLayout(1, 1, 0, 0));
			pnFilters.add(getLblFilters());
			pnFilters.add(getChckbxFood());
			pnFilters.add(getChckbxDrink());
			pnFilters.add(getChckbxPlace());
			pnFilters.add(getChckbxDecoration());
			pnFilters.add(getChckbxOthers());
		}
		return pnFilters;
	}

	private JCheckBox getChckbxFood() {
		if (chckbxFood == null) {
			chckbxFood = new JCheckBox("Food");
			chckbxFood.setForeground(new Color(255, 255, 255));
			chckbxFood.setMnemonic('F');
			chckbxFood.setFont(new Font("Tahoma", Font.PLAIN, 14));
			chckbxFood.setBackground(new Color(219, 112, 147));
			chckbxFood.setSelected(true);
			checkboxes.add(chckbxFood);
			chckbxFood.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					loadItems(chckbxFood.isSelected(), chckbxDrink.isSelected(), chckbxPlace.isSelected(),
							chckbxDecoration.isSelected(), chckbxOthers.isSelected());
				}
			});

		}
		return chckbxFood;
	}

	private JCheckBox getChckbxDrink() {
		if (chckbxDrink == null) {
			chckbxDrink = new JCheckBox("Drink");
			chckbxDrink.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					loadItems(chckbxFood.isSelected(), chckbxDrink.isSelected(), chckbxPlace.isSelected(),
							chckbxDecoration.isSelected(), chckbxOthers.isSelected());
				}
			});
			chckbxDrink.setForeground(new Color(255, 255, 255));
			chckbxDrink.setMnemonic('D');
			chckbxDrink.setFont(new Font("Tahoma", Font.PLAIN, 14));
			chckbxDrink.setBackground(new Color(219, 112, 147));
			chckbxDrink.setSelected(true);
			checkboxes.add(chckbxDrink);
		}
		return chckbxDrink;
	}

	private JCheckBox getChckbxPlace() {
		if (chckbxPlace == null) {
			chckbxPlace = new JCheckBox("Place");
			chckbxPlace.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadItems(chckbxFood.isSelected(), chckbxDrink.isSelected(), chckbxPlace.isSelected(),
							chckbxDecoration.isSelected(), chckbxOthers.isSelected());
				}
			});
			chckbxPlace.setForeground(new Color(255, 255, 255));
			chckbxPlace.setMnemonic('P');
			chckbxPlace.setFont(new Font("Tahoma", Font.PLAIN, 14));
			chckbxPlace.setBackground(new Color(219, 112, 147));
			chckbxPlace.setSelected(true);
			checkboxes.add(chckbxPlace);
		}
		return chckbxPlace;
	}

	private JLabel getLblFilters() {
		if (lblFilters == null) {
			lblFilters = new JLabel("Filters:");
			lblFilters.setForeground(new Color(255, 255, 255));
			lblFilters.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblFilters.setBackground(new Color(219, 112, 147));
		}
		return lblFilters;
	}

	private JCheckBox getChckbxDecoration() {
		if (chckbxDecoration == null) {
			chckbxDecoration = new JCheckBox("Decoration");
			chckbxDecoration.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					loadItems(chckbxFood.isSelected(), chckbxDrink.isSelected(), chckbxPlace.isSelected(),
							chckbxDecoration.isSelected(), chckbxOthers.isSelected());
				}
			});
			chckbxDecoration.setForeground(new Color(255, 255, 255));
			chckbxDecoration.setMnemonic('C');
			chckbxDecoration.setFont(new Font("Tahoma", Font.PLAIN, 14));
			chckbxDecoration.setBackground(new Color(219, 112, 147));
			chckbxDecoration.setSelected(true);
			checkboxes.add(chckbxDecoration);
		}
		return chckbxDecoration;
	}

	private JCheckBox getChckbxOthers() {
		if (chckbxOthers == null) {
			chckbxOthers = new JCheckBox("Others");
			chckbxOthers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadItems(chckbxFood.isSelected(), chckbxDrink.isSelected(), chckbxPlace.isSelected(),
							chckbxDecoration.isSelected(), chckbxOthers.isSelected());
				}
			});
			chckbxOthers.setForeground(new Color(255, 255, 255));
			chckbxOthers.setMnemonic('O');
			chckbxOthers.setFont(new Font("Tahoma", Font.PLAIN, 14));
			chckbxOthers.setBackground(new Color(219, 112, 147));
			chckbxOthers.setSelected(true);
			checkboxes.add(chckbxOthers);
		}
		return chckbxOthers;
	}

	protected void loadItems(boolean food, boolean drink, boolean place, boolean deco, boolean other) {

		modelAllItems.removeAllElements();
		for (Item i : organizer.getItems()) {

			if (i.getCategory().equals(ItemCategory.Food) && food || i.getCategory().equals(ItemCategory.Drink) && drink
					|| i.getCategory().equals(ItemCategory.Place) && place
					|| i.getCategory().equals(ItemCategory.Decoration) && deco
					|| i.getCategory().equals(ItemCategory.Others) && other) {

				modelAllItems.addElement(i);
			}

		}

	}

	private JButton getBtnSeeOrder() {
		if (btnSeeOrder == null) {
			btnSeeOrder = new JButton("See Order");
			btnSeeOrder.setSize(new Dimension(90, 90));
			btnSeeOrder.setMnemonic('O');
			btnSeeOrder.setToolTipText("Click here to see order cart");
			btnSeeOrder.setBackground(new Color(255, 255, 255));
			btnSeeOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnSeeOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toCard();

				}
			});

		}
		return btnSeeOrder;
	}

	protected void toCard() {
		showButtons();
		((CardLayout) pnCards.getLayout()).show(pnCards, "card");
		cardNumber++;
		btnSeeOrder.setEnabled(false);
	}

	protected void setAttendance() {

		try {

			int people = Integer.parseInt(txtNAttendants.getText());

			p.setAttendance(people);

		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(this, "Wrong number of attendants", "Wrong attendants",
					JOptionPane.ERROR_MESSAGE);
		}
		txtNAttendants.setText(String.valueOf(p.getAttendance()));

	}

	private JLabel getLblChooseTheItems() {
		if (lblChooseTheItems == null) {
			lblChooseTheItems = new JLabel("Choose an item");
			lblChooseTheItems.setHorizontalAlignment(SwingConstants.LEFT);
			lblChooseTheItems.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblChooseTheItems.setBackground(new Color(219, 112, 147));
		}
		return lblChooseTheItems;
	}

	private JPanel getPnData() {
		if (pnData == null) {
			pnData = new JPanel();
			pnData.setBackground(Color.WHITE);
			pnData.setLayout(new BorderLayout(0, 0));
			pnData.add(getPnDataTitle(), BorderLayout.NORTH);
			pnData.add(getPnOrderData(), BorderLayout.CENTER);
		}
		return pnData;
	}

	private JPanel getPnDataTitle() {
		if (pnDataTitle == null) {
			pnDataTitle = new JPanel();
			pnDataTitle.setBackground(Color.WHITE);
			pnDataTitle.setLayout(new GridLayout(1, 0, 0, 0));
			pnDataTitle.add(getTxtCurrentShoppingCard());
		}
		return pnDataTitle;
	}

	private JTextField getTxtCurrentShoppingCard() {
		if (txtCurrentShoppingCard == null) {
			txtCurrentShoppingCard = new JTextField();
			txtCurrentShoppingCard.setBorder(null);
			txtCurrentShoppingCard.setFont(new Font("Tahoma", Font.PLAIN, 26));
			txtCurrentShoppingCard.setBackground(Color.WHITE);
			txtCurrentShoppingCard.setEditable(false);
			txtCurrentShoppingCard.setText("Party Data");
			txtCurrentShoppingCard.setColumns(10);
		}
		return txtCurrentShoppingCard;
	}

	protected void endParty() {

		p.getCustomer().setName(txtNameData.getText());
		p.getCustomer().setSurname(txtSurnameData.getText());
		p.getCustomer().setNIF(txtNIFData.getText());
		p.setComments(tACommentsData.getText());
		Date date = calculateDate();
		p.setDate(date);

		int att = Integer.parseInt(txtNumAttData.getText());
		if (att <= 0) {
			JOptionPane.showMessageDialog(this, "You must specify the number of attendants",
					"Wrong number of attendants", JOptionPane.ERROR_MESSAGE);
		} else {
			p.setAttendance(att);

			textAreaBill.setText(p.getBill());

		}
		refreshAll();
	}

	protected Date calculateDate() {

		int year = (int) spYear.getValue();
		int month = (int) spMonth.getValue();
		int day = (int) spDay.getValue();
		int h = (int) spHour.getValue();
		int time = (int) spMinutes.getValue();

		@SuppressWarnings("deprecation")
		Date date = new Date(year, month, day, h, time);

		return date;
	}

	private JPanel getPnOrderData() {
		if (pnOrderData == null) {
			pnOrderData = new JPanel();
			pnOrderData.setBackground(Color.WHITE);
			pnOrderData.setLayout(new BorderLayout(0, 0));
			pnOrderData.add(getPnInfo(), BorderLayout.CENTER);
		}
		return pnOrderData;
	}

	private JPanel getPnNameData() {
		if (pnNameData == null) {
			pnNameData = new JPanel();
			pnNameData.setBackground(Color.WHITE);
			pnNameData.setLayout(new GridLayout(0, 1, 0, 0));
			pnNameData.add(getLblName());
			pnNameData.add(getTxtName());
		}
		return pnNameData;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name:");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblName.setBackground(SystemColor.inactiveCaptionBorder);
		}
		return lblName;
	}

	private JTextField getTxtName() {
		if (txtNameData == null) {
			txtNameData = new JTextField();
			txtNameData.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtNameData.setColumns(10);
		}
		return txtNameData;
	}

	private JPanel getPnSurnameData() {
		if (pnSurnameData == null) {
			pnSurnameData = new JPanel();
			pnSurnameData.setBackground(Color.WHITE);
			pnSurnameData.setLayout(new GridLayout(0, 1, 0, 0));
			pnSurnameData.add(getLblSurname());
			pnSurnameData.add(getTxtSurname());
		}
		return pnSurnameData;
	}

	private JLabel getLblSurname() {
		if (lblSurname == null) {
			lblSurname = new JLabel("Surname:");
			lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSurname.setBackground(SystemColor.inactiveCaptionBorder);
		}
		return lblSurname;
	}

	private JTextField getTxtSurname() {
		if (txtSurnameData == null) {
			txtSurnameData = new JTextField();
			txtSurnameData.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtSurnameData.setColumns(10);
		}
		return txtSurnameData;
	}

	private JPanel getPnNIFData() {
		if (pnNIFData == null) {
			pnNIFData = new JPanel();
			pnNIFData.setBackground(Color.WHITE);
			pnNIFData.setLayout(new GridLayout(0, 1, 0, 0));
			pnNIFData.add(getLblNif());
			pnNIFData.add(getTxtNIF());
		}
		return pnNIFData;
	}

	private JLabel getLblNumAttData() {
		if (lblNumAttData == null) {
			lblNumAttData = new JLabel("Number of Attendants:");
			lblNumAttData.setBackground(SystemColor.inactiveCaptionBorder);
			lblNumAttData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblNumAttData;
	}

	private JTextField getTxtNumAttData() {
		if (txtNumAttData == null) {
			txtNumAttData = new JTextField();
			txtNumAttData.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtNumAttData.setColumns(10);
			txtNumAttData.setText(String.valueOf(p.getAttendance()));
		}
		return txtNumAttData;
	}

	private JPanel getPnTotalPrice() {
		if (pnTotalPrice == null) {
			pnTotalPrice = new JPanel();
			pnTotalPrice.setBorder(null);
			pnTotalPrice.setBackground(Color.WHITE);
			pnTotalPrice.setLayout(new GridLayout(1, 1, 0, 0));
			pnTotalPrice.add(getLblFinalPrice());
			pnTotalPrice.add(getTxtFinalPrice());
		}
		return pnTotalPrice;
	}

	private JPanel getPnComents() {
		if (pnComents == null) {
			pnComents = new JPanel();
			pnComents.setBackground(Color.WHITE);
			pnComents.setLayout(new BorderLayout(0, 0));
			pnComents.add(getLblComentHere(), BorderLayout.NORTH);
			pnComents.add(getTACommentsData());
		}
		return pnComents;
	}

	private JLabel getLblComentHere() {
		if (lblComentHere == null) {
			lblComentHere = new JLabel("Coment here ( Optional ):");
			lblComentHere.setHorizontalAlignment(SwingConstants.LEFT);
			lblComentHere.setBackground(SystemColor.inactiveCaptionBorder);
			lblComentHere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblComentHere;
	}

	private JPanel getPnDate() {
		if (pnDate == null) {
			pnDate = new JPanel();
			pnDate.setBackground(Color.WHITE);
			pnDate.setLayout(new GridLayout(0, 1, 0, 0));
			pnDate.add(getPnDay());
			pnDate.add(getPnMonth());
			pnDate.add(getPnYear());
			pnDate.add(getPnHour());
			pnDate.add(getPnMinutes());
		}
		return pnDate;
	}

	private JSpinner getSpDay() {
		if (spDay == null) {

			SpinnerModel spDayModel = new SpinnerNumberModel(1, 1, 31, 1);
			spDay = new JSpinner(spDayModel);
			spDay.setBorder(null);
			spDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spDay.setBackground(Color.WHITE);
		}
		return spDay;
	}

	private JLabel getLblDay() {
		if (lblDay == null) {
			lblDay = new JLabel("Day:");
			lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDay.setBackground(Color.WHITE);
		}
		return lblDay;
	}

	private JLabel getLblMonth() {
		if (lblMonth == null) {
			lblMonth = new JLabel("Month:");
			lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblMonth.setBackground(Color.WHITE);
		}
		return lblMonth;
	}

	private JSpinner getSpMonth() {
		if (spMonth == null) {
			SpinnerModel spMonthModel = new SpinnerNumberModel(1, 1, 12, 1);
			spMonth = new JSpinner(spMonthModel);
			spMonth.setBorder(null);
			spMonth.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spMonth.setBackground(Color.WHITE);
		}
		return spMonth;
	}

	private JLabel getLblYear() {
		if (lblYear == null) {
			lblYear = new JLabel("Year:");
			lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
			lblYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblYear.setBackground(Color.WHITE);
		}
		return lblYear;
	}

	private JSpinner getSpYear() {
		if (spYear == null) {
			SpinnerModel spYearModel = new SpinnerNumberModel(2019, 2019, 2039, 1);
			spYear = new JSpinner(spYearModel);
			spYear.setBorder(null);
			spYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spYear.setBackground(Color.WHITE);
		}
		return spYear;
	}

	private JTextField getTxtFinalPrice() {
		if (txtFinalPrice == null) {
			txtFinalPrice = new JTextField();
			txtFinalPrice.setBorder(null);
			txtFinalPrice.setHorizontalAlignment(SwingConstants.CENTER);
			txtFinalPrice.setForeground(Color.BLACK);
			txtFinalPrice.setFont(new Font("Tahoma", Font.PLAIN, 25));
			txtFinalPrice.setText("0.0 \u20AC");
			txtFinalPrice.setBackground(Color.WHITE);
			txtFinalPrice.setEditable(false);
			txtFinalPrice.setColumns(10);
		}
		return txtFinalPrice;
	}

	private JPanel getPnAttData() {
		if (pnAttData == null) {
			pnAttData = new JPanel();
			pnAttData.setBackground(Color.WHITE);
			pnAttData.setLayout(new GridLayout(0, 1, 0, 0));
			pnAttData.add(getLblNumAttData());
			pnAttData.add(getTxtNumAttData());
		}
		return pnAttData;
	}

	private JLabel getLblNif() {
		if (lblNif == null) {
			lblNif = new JLabel("NIF:");
			lblNif.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNif.setBackground(SystemColor.inactiveCaptionBorder);
		}
		return lblNif;
	}

	private JTextField getTxtNIF() {
		if (txtNIFData == null) {
			txtNIFData = new JTextField();
			txtNIFData.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtNIFData.setBackground(Color.WHITE);
			txtNIFData.setColumns(10);
		}
		return txtNIFData;
	}

	private JPanel getPnDay() {
		if (pnDay == null) {
			pnDay = new JPanel();
			pnDay.setBorder(null);
			pnDay.setBackground(Color.WHITE);
			pnDay.setLayout(new GridLayout(0, 1, 0, 0));
			pnDay.add(getLblDay());
			pnDay.add(getSpDay());
		}
		return pnDay;
	}

	private JPanel getPnMonth() {
		if (pnMonth == null) {
			pnMonth = new JPanel();
			pnMonth.setBorder(null);
			pnMonth.setBackground(Color.WHITE);
			pnMonth.setLayout(new GridLayout(0, 1, 0, 0));
			pnMonth.add(getLblMonth());
			pnMonth.add(getSpMonth());
		}
		return pnMonth;
	}

	private JPanel getPnYear() {
		if (pnYear == null) {
			pnYear = new JPanel();
			pnYear.setBorder(null);
			pnYear.setBackground(Color.WHITE);
			pnYear.setLayout(new GridLayout(0, 1, 0, 0));
			pnYear.add(getLblYear());
			pnYear.add(getSpYear());
		}
		return pnYear;
	}

	private JTextArea getTACommentsData() {
		if (tACommentsData == null) {
			tACommentsData = new JTextArea();
			tACommentsData.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			tACommentsData.setToolTipText("Write here comments");
			tACommentsData.setFont(new Font("Courier New", Font.PLAIN, 15));
			tACommentsData.setLineWrap(true);
			tACommentsData.setWrapStyleWord(true);
		}
		return tACommentsData;
	}

	private JMenuItem getMenuItemBegin() {
		if (menuItemBegin == null) {
			menuItemBegin = new JMenuItem("Begin");
			menuItemBegin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					restartApp();
				}
			});
			menuItemBegin.setFont(new Font("Arial", Font.PLAIN, 15));
			menuItemBegin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
		}
		return menuItemBegin;
	}

	protected void restartApp() {

		p.clearOrder();
		p.getCustomer().logOut();

		lblUserName.setVisible(false);
		btnRegister.setVisible(true);
		btnRegister.setEnabled(true);
		menuItemPrint.setEnabled(false);
		chckbxDecoration.setSelected(true);
		chckbxDrink.setSelected(true);
		chckbxFood.setSelected(true);
		chckbxPlace.setSelected(true);
		chckbxOthers.setSelected(true);
		txtNameData.setText("");
		txtSurnameData.setText("");
		txtNumAttData.setText("");
		txtNIFData.setText("");

		refreshAll();
		toFirst();
	}

	private JSeparator getSepNew() {
		if (sepNew == null) {
			sepNew = new JSeparator();
		}
		return sepNew;
	}

	private JSeparator getSepOrder() {
		if (sepOrder == null) {
			sepOrder = new JSeparator();
		}
		return sepOrder;
	}

	private JMenuItem getMenuItemPrint() {
		if (menuItemPrint == null) {
			menuItemPrint = new JMenuItem("Print");
			menuItemPrint.setFont(new Font("Arial", Font.PLAIN, 15));
			menuItemPrint.setEnabled(false);
			menuItemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
		}
		return menuItemPrint;
	}

	private JLabel getLblFinalPrice() {
		if (lblFinalPrice == null) {
			lblFinalPrice = new JLabel("Final Price:");
			lblFinalPrice.setLabelFor(getTxtFinalPrice());
			lblFinalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFinalPrice.setBackground(Color.WHITE);
			lblFinalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblFinalPrice;
	}

	private JPanel getPnHour() {
		if (pnHour == null) {
			pnHour = new JPanel();
			pnHour.setBorder(null);
			pnHour.setBackground(Color.WHITE);
			pnHour.setLayout(new GridLayout(0, 1, 0, 0));
			pnHour.add(getLblHour());
			pnHour.add(getSpHour());
		}
		return pnHour;
	}

	private JPanel getPnMinutes() {
		if (pnMinutes == null) {
			pnMinutes = new JPanel();
			pnMinutes.setBorder(null);
			pnMinutes.setBackground(Color.WHITE);
			pnMinutes.setLayout(new GridLayout(0, 1, 0, 0));
			pnMinutes.add(getLblMinutes());
			pnMinutes.add(getSpMinutes());
		}
		return pnMinutes;
	}

	private JLabel getLblHour() {
		if (lblHour == null) {
			lblHour = new JLabel("Hour:");
			lblHour.setHorizontalAlignment(SwingConstants.RIGHT);
			lblHour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblHour;
	}

	private JLabel getLblMinutes() {
		if (lblMinutes == null) {
			lblMinutes = new JLabel("Minutes:");
			lblMinutes.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMinutes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblMinutes;
	}

	private JSpinner getSpHour() {
		if (spHour == null) {
			SpinnerModel spHourModel = new SpinnerNumberModel(18, 1, 24, 1);
			spHour = new JSpinner(spHourModel);
			spHour.setBorder(null);
			spHour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return spHour;
	}

	private JSpinner getSpMinutes() {
		if (spMinutes == null) {
			SpinnerModel spMinModel = new SpinnerNumberModel(00, 0, 59, 1);
			spMinutes = new JSpinner(spMinModel);
			spMinutes.setForeground(Color.WHITE);
			spMinutes.setBorder(null);
			spMinutes.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spMinutes.setBackground(SystemColor.inactiveCaptionBorder);
		}
		return spMinutes;
	}

	private JLabel getLblLogoWelcome() {
		if (lblLogoWelcome == null) {
			lblLogoWelcome = new JLabel("");
			lblLogoWelcome.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon img = new ImageIcon(PartyApp.class.getResource("/img/logo.jpg"));
			Image im = img.getImage().getScaledInstance(390, 390, Image.SCALE_DEFAULT);
			lblLogoWelcome.setIcon(new ImageIcon(im));
			lblLogoWelcome.setIcon(img);
		}
		return lblLogoWelcome;
	}

	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			pnCenter.setBackground(new Color(255, 255, 255));
			pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.X_AXIS));
			pnCenter.add(getPnLogoWelcome());
		}
		return pnCenter;
	}

	private JPanel getPnLogoWelcome() {
		if (pnLogoWelcome == null) {
			pnLogoWelcome = new JPanel();
			pnLogoWelcome.setBorder(null);
			pnLogoWelcome.setBackground(new Color(255, 255, 255));
			pnLogoWelcome.setLayout(new BorderLayout(0, 0));
			pnLogoWelcome.add(getLblLogoWelcome(), BorderLayout.NORTH);
			pnLogoWelcome.add(getPnGo(), BorderLayout.CENTER);
		}
		return pnLogoWelcome;
	}

	private JPanel getPnSummary() {
		if (pnSummary == null) {
			pnSummary = new JPanel();
			pnSummary.setForeground(Color.WHITE);
			pnSummary.setBackground(new Color(219, 112, 147));
			pnSummary.setLayout(new BorderLayout(0, 0));
			pnSummary.add(getPnBillSummary(), BorderLayout.CENTER);
		}
		return pnSummary;
	}

	private JPanel getPnButtons() {
		if (pnButtons == null) {
			pnButtons = new JPanel();
			pnButtons.setBackground(Color.WHITE);
			FlowLayout fl_pnButtons = (FlowLayout) pnButtons.getLayout();
			fl_pnButtons.setAlignment(FlowLayout.RIGHT);
			pnButtons.add(getBtnBack());
			pnButtons.add(getBtnConfirm());
			pnButtons.add(getBtnCancel());
		}
		return pnButtons;
	}

	private JButton getBtnConfirm() {
		if (btnConfirm == null) {
			btnConfirm = new JButton("Confirm");
			btnConfirm.setToolTipText("Click here to continue the order");
			btnConfirm.setMnemonic('N');
			btnConfirm.setForeground(Color.WHITE);
			btnConfirm.setBackground(new Color(219, 112, 147));
			btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (lastCard()) {
						if (check()) {
							
							confirm();
							askInvoice();
							restartApp();
						} else {
							JOptionPane.showMessageDialog(null, "You must fill data for the party reservation",
									"Empty fields", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						if (dataCard()) {
							setValues();// TODO el nombre ,apellido y NIF no se guardan ,tampoco la fecha
							showBill();
						}
							
						nextCard();

					}

				}
			});
		}
		return btnConfirm;
	}

	protected void setValues() {

		p.getCustomer().setName(txtNameData.getText());
		p.getCustomer().setSurname(txtSurnameData.getText());
		Date date = new Date();
		//TODO date.setMonth(spMonth.getValue());
		
		p.setDate(date);
		p.getCustomer().setNIF(txtNIFData.getText());
		p.getCustomer().setTelephone(txtTelephoneData.getText());
		p.setComments(tACommentsData.getText());
	}

	protected void showBill() {

		textAreaBill.setText(p.getBill());
		textAreaBill.setVisible(true);
	}

	protected boolean dataCard() {
		if (cardNumber == 3)
			return true;
		return false;
	}

	protected boolean lastCard() {

		if (cardNumber == 4)
			return true;
		return false;
	}

	protected void confirm() {
		organizer.createParty(p);
	}

	protected boolean check() {

		return checkNameSurname() && checkNIFTelephone();

	}

	private boolean checkNIFTelephone() {
		if (txtNIFData.getText().equals("") || txtTelephoneData.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "You must write your NIF and telephone", "Wrong data",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean checkNameSurname() {

		if (txtNameData.getText().equals("") || txtSurnameData.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "You must write your name and surname", "Wrong data",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	protected void askInvoice() {

		int answer = JOptionPane.showConfirmDialog(btnConfirm, "Do you wish to obtain the invoice file ? ",
				"Wish Invoice", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				new ImageIcon("src/img/interrogacion.jpg"));
		if (answer == JOptionPane.YES_OPTION) {
			organizer.createInvoiceFile(p);
		}

	}

	private JPanel getPnBillSummary() {
		if (pnBillSummary == null) {
			pnBillSummary = new JPanel();
			pnBillSummary.setBackground(Color.WHITE);
			pnBillSummary.setLayout(new BorderLayout(0, 0));
			pnBillSummary.add(getTextAreaBill(), BorderLayout.CENTER);
		}
		return pnBillSummary;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Register");
			btnRegister.setBackground(new Color(221, 160, 221));
			btnRegister.setForeground(new Color(0, 0, 0));
			btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnRegister.setMnemonic('R');
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					showDialogRegister();
				}
			});

		}
		return btnRegister;
	}

	protected void showDialogRegister() {

		RegisterDialog d = new RegisterDialog(this);
		d.setLocationRelativeTo(null);
		d.setModal(true);
		d.setVisible(true);

	}

	public Customer getCustomer() {
		return p.getCustomer();
	}

	public PartyOrganizer getOrganizer() {
		return organizer;
	}

	private JPanel getPnListCardAtt() {
		if (pnListCardAtt == null) {
			pnListCardAtt = new JPanel();
			pnListCardAtt.setBackground(Color.WHITE);
			pnListCardAtt.setLayout(new BorderLayout(0, 0));
			pnListCardAtt.add(getPnRightAttendanceOrder(), BorderLayout.SOUTH);
			pnListCardAtt.add(getPnAvailableItems(), BorderLayout.CENTER);
		}
		return pnListCardAtt;
	}

	private JPanel getPnRightAttendanceOrder() {
		if (pnRightAttendanceOrder == null) {
			pnRightAttendanceOrder = new JPanel();
			pnRightAttendanceOrder.setBackground(Color.WHITE);
			pnRightAttendanceOrder.setLayout(new BorderLayout(0, 0));
			pnRightAttendanceOrder.add(getPnAttendanceNorth(), BorderLayout.NORTH);
			pnRightAttendanceOrder.add(getPnSouthOrder(), BorderLayout.SOUTH);
		}
		return pnRightAttendanceOrder;
	}

	private JPanel getPnItems() {
		if (pnItems == null) {
			pnItems = new JPanel();
			pnItems.setToolTipText("Items available");
			pnItems.setBackground(Color.WHITE);
			pnItems.setLayout(new BorderLayout(0, 0));
			pnItems.add(getPnListCardAtt());
			pnItems.add(getPnTitleFilters(), BorderLayout.NORTH);
		}
		return pnItems;
	}

	private JLabel getLblNumberOfAttendants() {
		if (lblNumberOfAttendants == null) {
			lblNumberOfAttendants = new JLabel("Number of Attendants:");
			lblNumberOfAttendants.setToolTipText("Specify number of attendants on the right");
			lblNumberOfAttendants.setDisplayedMnemonic('T');
			lblNumberOfAttendants.setLabelFor(getTxtNAttendants());
			lblNumberOfAttendants.setForeground(Color.BLACK);
			lblNumberOfAttendants.setBackground(Color.WHITE);
			lblNumberOfAttendants.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblNumberOfAttendants;
	}

	private JTextField getTxtNAttendants() {
		if (txtNAttendants == null) {
			txtNAttendants = new JTextField();
			txtNAttendants.setToolTipText("Set the number of people going to the party.Default vakue is 10 attendants");
			txtNAttendants.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNAttendants.setText(String.valueOf(p.getAttendance()));
		}
		return txtNAttendants;
	}

	private JPanel getPnSouthOrder() {
		if (pnSouthOrder == null) {
			pnSouthOrder = new JPanel();
			pnSouthOrder.setLayout(new BorderLayout(0, 0));
		}
		return pnSouthOrder;
	}

	private JPanel getPnCard() {
		if (pnCard == null) {
			pnCard = new JPanel();
			pnCard.setBackground(Color.WHITE);
			pnCard.setLayout(new BorderLayout(0, 0));
			pnCard.add(getPnCardTitle(), BorderLayout.NORTH);
			pnCard.add(getPnCardItems(), BorderLayout.CENTER);
		}
		return pnCard;
	}

	private JPanel getPnCardTitle() {
		if (pnCardTitle == null) {
			pnCardTitle = new JPanel();
			pnCardTitle.setForeground(Color.WHITE);
			pnCardTitle.setBackground(Color.WHITE);
			pnCardTitle.setLayout(new GridLayout(1, 0, 0, 0));
			pnCardTitle.add(getLblCardOfThe());
		}
		return pnCardTitle;
	}

	private JLabel getLblCardOfThe() {
		if (lblCardOfThe == null) {
			lblCardOfThe = new JLabel("Current Party Reservation");
			lblCardOfThe.setFont(new Font("Tahoma", Font.PLAIN, 26));
		}
		return lblCardOfThe;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.setToolTipText("Click here to go back to the previous step");
			btnBack.setBackground(Color.WHITE);
			btnBack.setMnemonic('B');
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					previousCard();
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnBack;
	}

	private JPanel getPnCardItems() {
		if (pnCardItems == null) {
			pnCardItems = new JPanel();
			pnCardItems.setBackground(Color.WHITE);
			pnCardItems.setLayout(new BorderLayout(0, 0));
			pnCardItems.add(getPnRight(), BorderLayout.SOUTH);
			pnCardItems.add(getPnLeft(), BorderLayout.CENTER);
		}
		return pnCardItems;
	}

	private JPanel getPnAvailableItems() {
		if (pnAvailableItems == null) {
			pnAvailableItems = new JPanel();
			pnAvailableItems.setBackground(Color.WHITE);
			pnAvailableItems.setLayout(new GridLayout(1, 0, 0, 0));
			pnAvailableItems.add(getSpAvailableItems());
		}
		return pnAvailableItems;
	}

	private JScrollPane getSpAvailableItems() {
		if (spAvailableItems == null) {
			spAvailableItems = new JScrollPane();
			spAvailableItems.setForeground(Color.WHITE);
			spAvailableItems.setBackground(Color.WHITE);
			spAvailableItems.setViewportView(getListAllItems());
		}
		return spAvailableItems;
	}

	private JPanel getPnRight() {
		if (pnRight == null) {
			pnRight = new JPanel();
			pnRight.setBackground(Color.WHITE);
			pnRight.setLayout(new BorderLayout(0, 0));
			pnRight.add(getPnFinalPriceCard());
			pnRight.add(getBtnClearAll(), BorderLayout.WEST);
		}
		return pnRight;
	}

	private JButton getBtnClearAll() {
		if (btnClearAll == null) {
			btnClearAll = new JButton("Clear All");
			btnClearAll.setMnemonic('L');
			btnClearAll.setBackground(Color.WHITE);
			btnClearAll.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnClearAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					clearPartyOrder();
					refreshAll();
				}
			});
		}
		return btnClearAll;
	}

	protected void clearPartyOrder() {

		p.clearOrder();
		modelCardItems.clear();

		pnItemCard.setVisible(false);
		listItemsCard.revalidate();
		listItemsCard.repaint();

	}

	protected void removeItem(Item i, int u) {

		// TODO Falla al eliminar de uno en uno las unidades de los items
		p.deleteItem(i, u);

		refreshAll();
	}

	private JPanel getPnLogging() {
		if (pnLogging == null) {
			pnLogging = new JPanel();
			pnLogging.setBackground(Color.WHITE);
			pnLogging.setLayout(new BorderLayout(0, 0));
			pnLogging.add(getPnUserName(), BorderLayout.CENTER);
			pnLogging.add(getPnUppButtons(), BorderLayout.EAST);
		}
		return pnLogging;
	}

	public Party getParty() {
		return p;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setToolTipText("Click here to start again");
			btnCancel.setMnemonic('C');
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cancelOrder();
				}
			});
			btnCancel.setBackground(Color.WHITE);
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnCancel;
	}

	protected void cancelOrder() {

		p.clearOrder();
		logout();
		refreshAll();
		toFirst();
	}

	private void toFirst() {
		((CardLayout) pnCards.getLayout()).first(pnCards);
		cardNumber = 0;
		hideButtons();
	}

	private void logout() {
		p.getCustomer().logOut();
		btnRegister.setVisible(true);
		btnRegister.setEnabled(true);
		lblUserName.setText("");
	}

	protected void login(String usr, String pass) {

		p.getCustomer().logIn(usr, pass);
		btnRegister.setVisible(false);
		lblUserName.setText("@" + p.getCustomer().getUsername());

	}

	private void refreshItems() {

		modelCardItems.clear();

		for (Item selected : p.getSelectedItems()) {
			// Panel Card
			modelCardItems.addElement(selected);

		}

		listItemsCard.revalidate();
		listItemsCard.repaint();
		pnItemCard.setVisible(false);
	}

	public void refreshAll() {

		refreshItems();
		setAttendance();
		lblTotalCard.setText(p.getFinalPrice() + " €");
		txtFinalPrice.setText(String.valueOf(p.getFinalPrice()) + " €");

	}

	private JPanel getPnItem() {
		if (pnItem == null) {
			pnItem = new JPanel();
			pnItem.setToolTipText("Item selected");
			pnItem.setBorder(null);
			pnItem.setBackground(Color.WHITE);
			pnItem.setLayout(new BorderLayout(0, 0));
			pnItem.add(getPnImagePrice(), BorderLayout.CENTER);
			pnItem.add(getPnButtonsItem(), BorderLayout.SOUTH);
			pnItem.add(getTxtNameItem(), BorderLayout.NORTH);
		}
		return pnItem;
	}

	private JTextArea getTextAreaDescriptionItem() {
		if (textAreaDescriptionItem == null) {
			textAreaDescriptionItem = new JTextArea();
			textAreaDescriptionItem.setToolTipText("Description of the item ");
			textAreaDescriptionItem.setEditable(false);
			textAreaDescriptionItem.setWrapStyleWord(true);
			textAreaDescriptionItem.setLineWrap(true);
			textAreaDescriptionItem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return textAreaDescriptionItem;
	}

	private JLabel getLblImageItem() {
		if (lblImageItem == null) {
			lblImageItem = new JLabel("");
			lblImageItem.setToolTipText("Image of the item");

		}
		return lblImageItem;
	}

	private JPanel getPnImagePrice() {
		if (pnImagePrice == null) {
			pnImagePrice = new JPanel();
			pnImagePrice.setBackground(Color.WHITE);
			pnImagePrice.setLayout(new BorderLayout(0, 0));
			pnImagePrice.add(getPnDescrImage(), BorderLayout.CENTER);
			pnImagePrice.add(getPnUnitsItem(), BorderLayout.SOUTH);
		}
		return pnImagePrice;
	}

	private JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setBorder(null);
			txtPrice.setForeground(Color.BLACK);
			txtPrice.setBackground(Color.WHITE);
			txtPrice.setDisabledTextColor(Color.WHITE);
			txtPrice.setToolTipText("Price for the item");
			txtPrice.setEditable(false);
			txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 30));
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}

	private JPanel getPnAttendanceNorth() {
		if (pnAttendanceNorth == null) {
			pnAttendanceNorth = new JPanel();
			pnAttendanceNorth.setBackground(Color.WHITE);
			pnAttendanceNorth.setLayout(new GridLayout(1, 1, 0, 0));
			pnAttendanceNorth.add(getLblNumberOfAttendants());
			pnAttendanceNorth.add(getTxtNAttendants());
		}
		return pnAttendanceNorth;
	}

	private JList<Item> getListAllItems() {
		if (listAllItems == null) {
			listAllItems = new JList<Item>(modelAllItems);
			listAllItems.setToolTipText("Available items for this filters");
			listAllItems.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

					showItemSelected();

				}
			});
			listAllItems.setFont(new Font("Tahoma", Font.PLAIN, 16));

			listAllItems.setBackground(Color.WHITE);
		}
		return listAllItems;
	}

	protected void showItemSelected() {

		selected = listAllItems.getSelectedValue();

		txtNameItem.setText(selected.getName());
		textAreaDescriptionItem.setText(selected.getDescription());
		spUnitsItem.setValue(1);

		if (selected.isGroup()) {
			txtPrice.setText(String.valueOf(selected.getGroupPrice()) + " €/group");
			spUnitsItem.setEnabled(false);
		} else {
			txtPrice.setText(String.valueOf(selected.getUnitPrice()) + " €/unit");
			spUnitsItem.setEnabled(true);
		}
		ImageIcon img = new ImageIcon("src/img/" + selected.getCode() + ".jpg");
		Image im = img.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		lblImageItem.setIcon(new ImageIcon(im));

		((CardLayout) pnCards.getLayout()).show(pnCards, "item selected");

	}

	private JPanel getPnButtonsItem() {
		if (pnButtonsItem == null) {
			pnButtonsItem = new JPanel();
			FlowLayout fl_pnButtonsItem = (FlowLayout) pnButtonsItem.getLayout();
			fl_pnButtonsItem.setAlignment(FlowLayout.RIGHT);
			pnButtonsItem.setBorder(null);
			pnButtonsItem.setBackground(Color.WHITE);
			pnButtonsItem.add(getBtnAddItem());
		}
		return pnButtonsItem;
	}

	private JButton getBtnAddItem() {
		if (btnAddItem == null) {
			btnAddItem = new JButton("Add item");
			btnAddItem.setToolTipText("Click here to add this item to the party order");
			btnAddItem.setMnemonic('A');
			btnAddItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAddItem.setBackground(Color.WHITE);
			btnAddItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					addItemToParty();

					((CardLayout) pnCards.getLayout()).show(pnCards, "items");

				}
			});

		}
		return btnAddItem;
	}

	protected void addItemToParty() {

		p.addItem(selected, (int) spUnitsItem.getValue());

		refreshAll();

	}

	private JTextField getTxtNameItem() {
		if (txtNameItem == null) {
			txtNameItem = new JTextField();
			txtNameItem.setToolTipText("Name of the item");
			txtNameItem.setBorder(null);
			txtNameItem.setBackground(Color.WHITE);
			txtNameItem.setFont(new Font("Tahoma", Font.PLAIN, 26));
			txtNameItem.setEditable(false);
			txtNameItem.setColumns(10);
		}
		return txtNameItem;
	}

	private JPanel getPnDescrImage() {
		if (pnDescrImage == null) {
			pnDescrImage = new JPanel();
			pnDescrImage.setBackground(Color.WHITE);
			pnDescrImage.setLayout(new BorderLayout(0, 0));
			pnDescrImage.add(getLblImageItem(), BorderLayout.CENTER);
			pnDescrImage.add(getTextAreaDescriptionItem(), BorderLayout.NORTH);
			pnDescrImage.add(getPnPriceItem(), BorderLayout.EAST);
		}
		return pnDescrImage;
	}

	private JPanel getPnPriceItem() {
		if (pnPriceItem == null) {
			pnPriceItem = new JPanel();
			pnPriceItem.setToolTipText("Price of the item ");
			pnPriceItem.setBackground(new Color(255, 255, 255));
			pnPriceItem.setLayout(new BorderLayout(0, 0));
			pnPriceItem.add(getTxtPrice(), BorderLayout.NORTH);
		}
		return pnPriceItem;
	}

	private JLabel getLblUnits() {
		if (lblUnits == null) {
			lblUnits = new JLabel("Units:");
			lblUnits.setToolTipText("Units specified on the right");
			lblUnits.setHorizontalAlignment(SwingConstants.RIGHT);
			lblUnits.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblUnits.setLabelFor(getSpUnitsItem());
			lblUnits.setDisplayedMnemonic('U');
		}
		return lblUnits;
	}

	private JPanel getPnUnitsItem() {
		if (pnUnitsItem == null) {
			pnUnitsItem = new JPanel();
			pnUnitsItem.setBackground(new Color(255, 255, 255));
			pnUnitsItem.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			pnUnitsItem.add(getLblUnits());
			pnUnitsItem.add(getSpUnitsItem());
		}
		return pnUnitsItem;
	}

	private JSpinner getSpUnitsItem() {
		if (spUnitsItem == null) {
			SpinnerModel m = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
			spUnitsItem = new JSpinner(m);
			spUnitsItem.setToolTipText("Select here the numebr of items you want for the unit-price ones");
			spUnitsItem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return spUnitsItem;
	}

	private JPanel getPnUserName() {
		if (pnUserName == null) {
			pnUserName = new JPanel();
			pnUserName.setForeground(Color.WHITE);
			pnUserName.setBackground(new Color(128, 0, 128));
			pnUserName.setLayout(new GridLayout(1, 0, 0, 0));
			pnUserName.add(getLblUserName());
		}
		return pnUserName;
	}

	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("");
			lblUserName.setForeground(new Color(255, 255, 255));
			lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblUserName;
	}

	private JPanel getPnGo() {
		if (pnGo == null) {
			pnGo = new JPanel();
			pnGo.setBackground(new Color(255, 255, 255));
			pnGo.add(getBtnGo());
		}
		return pnGo;
	}

	/**
	 * Show username in the app when customer logged in Hide bottom for register
	 */
	public void registeredUser() {

		String username = p.getCustomer().getUsername();
		lblUserName.setText("@" + username);
		btnRegister.setEnabled(false);
		btnRegister.setVisible(false);
	}

	private JPanel getPnTitleFilters() {
		if (pnTitleFilters == null) {
			pnTitleFilters = new JPanel();
			pnTitleFilters.setBackground(Color.WHITE);
			pnTitleFilters.setLayout(new GridLayout(0, 1, 0, 0));
			pnTitleFilters.add(getLblChooseTheItems());
			pnTitleFilters.add(getPnFilters());
		}
		return pnTitleFilters;
	}

	private JPanel getPnFinalPriceCard() {
		if (pnFinalPriceCard == null) {
			pnFinalPriceCard = new JPanel();
			pnFinalPriceCard.setBackground(Color.WHITE);
			pnFinalPriceCard.setLayout(new BorderLayout(0, 0));
			pnFinalPriceCard.add(getLblFinalPriceCard(), BorderLayout.NORTH);
			pnFinalPriceCard.add(getLblTotalCard(), BorderLayout.SOUTH);
		}
		return pnFinalPriceCard;
	}

	private JLabel getLblFinalPriceCard() {
		if (lblFinalPriceCard == null) {
			lblFinalPriceCard = new JLabel("Total:");
			lblFinalPriceCard.setAlignmentX(0.5f);
			lblFinalPriceCard.setBackground(Color.WHITE);
			lblFinalPriceCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblFinalPriceCard;
	}

	private JPanel getPnTelephoneData() {
		if (pnTelephoneData == null) {
			pnTelephoneData = new JPanel();
			pnTelephoneData.setBackground(Color.WHITE);
			pnTelephoneData.setLayout(new GridLayout(0, 1, 0, 0));
			pnTelephoneData.add(getLblTelephoneData());
			pnTelephoneData.add(getTxtTelephoneData());
		}
		return pnTelephoneData;
	}

	private JLabel getLblTelephoneData() {
		if (lblTelephoneData == null) {
			lblTelephoneData = new JLabel("Telephone:");
			lblTelephoneData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblTelephoneData;
	}

	private JTextField getTxtTelephoneData() {
		if (txtTelephoneData == null) {
			txtTelephoneData = new JTextField();
			txtTelephoneData.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtTelephoneData.setColumns(10);
		}
		return txtTelephoneData;
	}

	private JTextArea getTextAreaBill() {
		if (textAreaBill == null) {
			textAreaBill = new JTextArea();
			textAreaBill.setFont(new Font("Tahoma", Font.PLAIN, 17));
			textAreaBill.setEditable(false);
			textAreaBill.setLineWrap(true);
			textAreaBill.setWrapStyleWord(true);
		}
		return textAreaBill;
	}

	private JPanel getPnLeft() {
		if (pnLeft == null) {
			pnLeft = new JPanel();
			pnLeft.setBorder(null);
			pnLeft.setBackground(Color.WHITE);
			pnLeft.setLayout(new GridLayout(1, 0, 0, 0));
			pnLeft.add(getPnItemsCard());
			pnLeft.add(getPnItemCard());
		}
		return pnLeft;
	}

	private JPanel getPnItemCard() {
		if (pnItemCard == null) {
			pnItemCard = new JPanel();
			pnItemCard.setToolTipText("Item selected");
			pnItemCard.setBorder(null);
			pnItemCard.setVisible(false);
			pnItemCard.setBackground(Color.WHITE);
			pnItemCard.setLayout(new BorderLayout(0, 0));
			pnItemCard.add(getPnRemoveItemCard(), BorderLayout.SOUTH);
			pnItemCard.add(getPnItemCardData(), BorderLayout.CENTER);
			pnItemCard.add(getLblItemName(), BorderLayout.NORTH);
		}
		return pnItemCard;
	}

	private JPanel getPnItemsCard() {
		if (pnItemsCard == null) {
			pnItemsCard = new JPanel();
			pnItemsCard.setBorder(null);
			pnItemsCard.setBackground(Color.WHITE);
			pnItemsCard.setLayout(new BorderLayout(0, 0));
			pnItemsCard.add(getLblItemsOfThe(), BorderLayout.NORTH);
			pnItemsCard.add(getSpItemsCard());
		}
		return pnItemsCard;
	}

	private JPanel getPnRemoveItemCard() {
		if (pnRemoveItemCard == null) {
			pnRemoveItemCard = new JPanel();
			pnRemoveItemCard.setBorder(null);
			pnRemoveItemCard.setBackground(Color.WHITE);
			pnRemoveItemCard.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			pnRemoveItemCard.add(getLblUnitsToRemove());
			pnRemoveItemCard.add(getSpUnitsToRemove());
			pnRemoveItemCard.add(getBtnRemove());
		}
		return pnRemoveItemCard;
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove units");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Item sel = listItemsCard.getSelectedValue();
					int u = (int) spUnitsToRemove.getValue();

					removeItem(sel, u);

					try {
						if (p.itemIsInParty(sel))
							showItemInCard(sel);
					} catch (NullPointerException n) {
						pnItemCard.setVisible(false);
					}
				}
			});
			btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnRemove.setBackground(Color.WHITE);
			btnRemove.setMnemonic('R');
		}
		return btnRemove;
	}

	private JLabel getLblUnitsToRemove() {
		if (lblUnitsToRemove == null) {
			lblUnitsToRemove = new JLabel("Units:");
			lblUnitsToRemove.setLabelFor(getSpUnitsToRemove());
			lblUnitsToRemove.setDisplayedMnemonic('U');
			lblUnitsToRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblUnitsToRemove;
	}

	private JSpinner getSpUnitsToRemove() {
		if (spUnitsToRemove == null) {
			spUnitsToRemove = new JSpinner();
			spUnitsToRemove.setForeground(Color.BLACK);
			spUnitsToRemove.setBackground(Color.WHITE);
			spUnitsToRemove.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
			spUnitsToRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return spUnitsToRemove;
	}

	private JPanel getPnItemCardData() {
		if (pnItemCardData == null) {
			pnItemCardData = new JPanel();
			pnItemCardData.setBorder(null);
			pnItemCardData.setBackground(Color.WHITE);
			pnItemCardData.setLayout(new BorderLayout(0, 0));
			pnItemCardData.add(getLblImageItemCard(), BorderLayout.CENTER);
			pnItemCardData.add(getPnPriceUnitsItemCard(), BorderLayout.EAST);
			pnItemCardData.add(getTADescriptionOfThe(), BorderLayout.NORTH);
		}
		return pnItemCardData;
	}

	private JLabel getLblImageItemCard() {
		if (lblImageItemCard == null) {
			lblImageItemCard = new JLabel("");
			lblImageItemCard.setBackground(Color.WHITE);
		}
		return lblImageItemCard;
	}

	private JPanel getPnPriceUnitsItemCard() {
		if (pnPriceUnitsItemCard == null) {
			pnPriceUnitsItemCard = new JPanel();
			pnPriceUnitsItemCard.setBackground(Color.WHITE);
			pnPriceUnitsItemCard.setBorder(null);
			pnPriceUnitsItemCard.setLayout(new GridLayout(0, 1, 0, 0));
			pnPriceUnitsItemCard.add(getLblPriceItemCard());
			pnPriceUnitsItemCard.add(getLblUnitsCard());
			pnPriceUnitsItemCard.add(getLblPriceItemCardFinal());
		}
		return pnPriceUnitsItemCard;
	}

	private JTextArea getTADescriptionOfThe() {
		if (tADescriptionOfThe == null) {
			tADescriptionOfThe = new JTextArea();
			tADescriptionOfThe.setEditable(false);
			tADescriptionOfThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return tADescriptionOfThe;
	}

	private JLabel getLblItemName() {
		if (lblItemName == null) {
			lblItemName = new JLabel("");
			lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		}
		return lblItemName;
	}

	private JScrollPane getSpItemsCard() {
		if (spItemsCard == null) {
			spItemsCard = new JScrollPane();
			spItemsCard.setBorder(null);
			spItemsCard.setBackground(Color.WHITE);
			spItemsCard.setViewportView(getListItemsCard());
		}
		return spItemsCard;
	}

	private JList<Item> getListItemsCard() {
		if (listItemsCard == null) {
			listItemsCard = new JList<Item>(modelCardItems);
			listItemsCard.setFont(new Font("Tahoma", Font.PLAIN, 15));
			listItemsCard.setBorder(null);
			listItemsCard.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Item selected = listItemsCard.getSelectedValue();
					showItemInCard(selected);

				}
			});
		}
		return listItemsCard;
	}

	protected void showItemInCard(Item selected) {

		pnItemCard.setVisible(true);

		int max = p.getSelectedItemsUnits().get(selected);
		spUnitsToRemove.setModel(new SpinnerNumberModel(1, 1, max, 1));
		tADescriptionOfThe.setText(selected.getDescription());
		lblItemName.setText(selected.getName());

		String per = "";
		double priceItem = max * selected.getPrice();
		if (!selected.isGroup()) {
			per = " €/unit";
		} else {
			per = " €/ 10 attendants";
		}
		lblPriceItemCardFinal.setText(String.valueOf(priceItem) + " €");
		lblPriceItemCard.setText(String.valueOf(selected.getPrice() + per));
		lblUnitsCard.setText(String.valueOf(max) + " unit(s)");

		ImageIcon img = new ImageIcon("src/img/" + selected.getCode() + ".jpg");
		Image im = img.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		lblImageItemCard.setIcon(new ImageIcon(im));

	}

	private JLabel getLblItemsOfThe() {
		if (lblItemsOfThe == null) {
			lblItemsOfThe = new JLabel("Items");
			lblItemsOfThe.setLabelFor(getListItemsCard());
			lblItemsOfThe.setBackground(Color.WHITE);
			lblItemsOfThe.setFont(new Font("Tahoma", Font.PLAIN, 23));
		}
		return lblItemsOfThe;
	}

	private JLabel getLblPriceItemCard() {
		if (lblPriceItemCard == null) {
			lblPriceItemCard = new JLabel("");
			lblPriceItemCard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return lblPriceItemCard;
	}

	private JLabel getLblUnitsCard() {
		if (lblUnitsCard == null) {
			lblUnitsCard = new JLabel("");
			lblUnitsCard.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return lblUnitsCard;
	}

	private JLabel getLblPriceItemCardFinal() {
		if (lblPriceItemCardFinal == null) {
			lblPriceItemCardFinal = new JLabel("");
			lblPriceItemCardFinal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return lblPriceItemCardFinal;
	}

	private JLabel getLblTotalCard() {
		if (lblTotalCard == null) {
			lblTotalCard = new JLabel("");
			lblTotalCard.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return lblTotalCard;
	}

	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setLayout(new GridLayout(0, 3, 0, 0));
			pnInfo.add(getPnDataCenter());
			pnInfo.add(getPnCommentsDate());
			pnInfo.add(getPanelPriceData());
		}
		return pnInfo;
	}

	private JPanel getPnDataCenter() {
		if (pnDataCenter == null) {
			pnDataCenter = new JPanel();
			pnDataCenter.setLayout(new GridLayout(0, 1, 0, 0));
			pnDataCenter.add(getPnAttData());
			pnDataCenter.add(getPnNameData());
			pnDataCenter.add(getPnSurnameData());
			pnDataCenter.add(getPnNIFData());
			pnDataCenter.add(getPnTelephoneData());
		}
		return pnDataCenter;
	}

	private JPanel getPnCommentsDate() {
		if (pnCommentsDate == null) {
			pnCommentsDate = new JPanel();
			pnCommentsDate.setLayout(new GridLayout(2, 2, 0, 0));
			pnCommentsDate.add(getPnDate());
			pnCommentsDate.add(getPnComents());
		}
		return pnCommentsDate;
	}

	private JPanel getPanelPriceData() {
		if (panelPriceData == null) {
			panelPriceData = new JPanel();
			panelPriceData.setBackground(Color.WHITE);
			panelPriceData.setLayout(new BorderLayout(0, 0));
			panelPriceData.add(getPnTotalPrice(), BorderLayout.SOUTH);
		}
		return panelPriceData;
	}

	private JPanel getPnUppButtons() {
		if (pnUppButtons == null) {
			pnUppButtons = new JPanel();
			pnUppButtons.setBackground(Color.WHITE);
			FlowLayout fl_pnUppButtons = (FlowLayout) pnUppButtons.getLayout();
			fl_pnUppButtons.setAlignment(FlowLayout.RIGHT);
			pnUppButtons.add(getBtnRegister());
			pnUppButtons.add(getBtnSeeOrder());
		}
		return pnUppButtons;
	}
}