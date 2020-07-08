package Volunteer;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class VolunteerView extends JFrame {

	// Variables declaration - do not modify
	private JList<String> HobbiesField;
	private JLabel HobbiesLabel;
	private JList<String> LanguagiesField;
	private JLabel LanguagiesLabel;
	private JTextField addressField;
	private JLabel addressLabel;
	private JTextField ageField;
	private JLabel ageLabel;
	private JTextField assosicationField;
	private JLabel assosicationLabel;
	private JTextField cityField;
	private JLabel cityLabel;
	private JLabel fullNameLabel;
	private JTextField fullnameField;
	private JTextField idField;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JLabel message;
	private JButton submit;
	private JLabel telephoneLabel;
	private JTextField telephoneField;
	private JLabel userIdLabel;
	private JLabel welcomeMessage;
	private JButton back;

	// End of variables declaration

	public VolunteerView() {

		setTitle("עריכת מתנדב");
		welcomeMessage = new JLabel();
		userIdLabel = new JLabel();
		telephoneLabel = new JLabel();
		cityLabel = new JLabel();
		assosicationLabel = new JLabel();
		idField = new JTextField();
		telephoneField = new JTextField();
		cityField = new JTextField();
		assosicationField = new JTextField();
		fullnameField = new JTextField();
		fullNameLabel = new JLabel();
		ageLabel = new JLabel();
		ageField = new JTextField();
		addressField = new JTextField();
		addressLabel = new JLabel();
		HobbiesLabel = new JLabel();
		jScrollPane1 = new JScrollPane();
		HobbiesField = new JList<>();
		jScrollPane2 = new JScrollPane();
		LanguagiesField = new JList<>();
		LanguagiesLabel = new JLabel();
		submit = new JButton();
		message = new JLabel();
		back = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		assosicationField.setEnabled(false);
		idField.setEnabled(false);

		welcomeMessage.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);

		userIdLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		userIdLabel.setText("תעודת זהות:");

		telephoneLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		telephoneLabel.setText("טלפון:");

		cityLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		cityLabel.setText("עיר מגורים:");

		assosicationLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		assosicationLabel.setText("עמותה:");

		fullNameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		fullNameLabel.setText("שם מלא:");

		ageLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		ageLabel.setText("גיל:");

		addressLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		addressLabel.setText("כתובת:");

		HobbiesLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		HobbiesLabel.setText("תחביבים:");
		jScrollPane1.setViewportView(HobbiesField);

		jScrollPane2.setViewportView(LanguagiesField);

		LanguagiesLabel.setFont(new Font("Arial", 0, 14)); // NOI18N
		LanguagiesLabel.setText("שפות:");
		submit.setText("עדכן");
		back.setText("חזור");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(welcomeMessage).addGap(164, 164, 164))
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(64, 64, 64)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
														.addComponent(fullnameField, GroupLayout.PREFERRED_SIZE, 100,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(fullNameLabel))
												.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
														.addComponent(ageField, GroupLayout.PREFERRED_SIZE, 100,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(ageLabel))
												.addGroup(layout.createSequentialGroup()
														.addComponent(addressField, GroupLayout.PREFERRED_SIZE, 100,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(addressLabel)))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addGroup(layout.createSequentialGroup().addComponent(cityField)
														.addGap(18, 18, 18).addComponent(cityLabel))
												.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
														.addComponent(telephoneField, GroupLayout.PREFERRED_SIZE, 100,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(telephoneLabel))
												.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
														.addComponent(idField, GroupLayout.PREFERRED_SIZE, 100,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(userIdLabel))))
								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(submit, GroupLayout.PREFERRED_SIZE, 131,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(back, GroupLayout.PREFERRED_SIZE, 131,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(assosicationField, GroupLayout.Alignment.LEADING)
												.addGroup(GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE,
																		100, GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18).addComponent(LanguagiesLabel)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
																		100, GroupLayout.PREFERRED_SIZE)))
										.addGap(27, 27, 27)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(assosicationLabel, GroupLayout.Alignment.TRAILING)
												.addComponent(HobbiesLabel, GroupLayout.Alignment.TRAILING))))
						.addGap(30, 30, 30))
				.addGroup(layout.createSequentialGroup().addGap(138, 138, 138)
						.addComponent(message, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addComponent(welcomeMessage).addGap(21, 21, 21)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(userIdLabel)
								.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(fullNameLabel).addComponent(fullnameField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(11, 11, 11)
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(telephoneLabel)
										.addComponent(telephoneField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(ageLabel).addComponent(ageField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(11, 11, 11)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(cityLabel)
								.addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(addressLabel).addComponent(addressField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(11, 11, 11)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(assosicationLabel)
								.addComponent(assosicationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(11, 11, 11)
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(HobbiesLabel)
										.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(LanguagiesLabel))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(message)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(submit, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(back, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(37, Short.MAX_VALUE)));

		pack();
	}

	public JList<String> getHobbiesField() {
		return HobbiesField;
	}

	public void setHobbiesField(JList<String> hobbiesField) {
		HobbiesField = hobbiesField;
	}

	public JLabel getHobbiesLabel() {
		return HobbiesLabel;
	}

	public void setHobbiesLabel(JLabel hobbiesLabel) {
		HobbiesLabel = hobbiesLabel;
	}

	public JList<String> getLanguagiesField() {
		return LanguagiesField;
	}

	public void setLanguagiesField(JList<String> languagiesField) {
		LanguagiesField = languagiesField;
	}

	public JLabel getLanguagiesLabel() {
		return LanguagiesLabel;
	}

	public void setLanguagiesLabel(JLabel languagiesLabel) {
		LanguagiesLabel = languagiesLabel;
	}

	public JTextField getAddressField() {
		return addressField;
	}

	public void setAddressField(JTextField addressField) {
		this.addressField = addressField;
	}

	public JLabel getAddressLabel() {
		return addressLabel;
	}

	public void setAddressLabel(JLabel addressLabel) {
		this.addressLabel = addressLabel;
	}

	public JTextField getAgeField() {
		return ageField;
	}

	public void setAgeField(JTextField ageField) {
		this.ageField = ageField;
	}

	public JLabel getAgeLabel() {
		return ageLabel;
	}

	public void setAgeLabel(JLabel ageLabel) {
		this.ageLabel = ageLabel;
	}

	public JTextField getAssosicationField() {
		return assosicationField;
	}

	public void setAssosicationField(JTextField assosicationField) {
		this.assosicationField = assosicationField;
	}

	public JLabel getAssosicationLabel() {
		return assosicationLabel;
	}

	public void setAssosicationLabel(JLabel assosicationLabel) {
		this.assosicationLabel = assosicationLabel;
	}

	public JTextField getCityField() {
		return cityField;
	}

	public void setCityField(JTextField cityField) {
		this.cityField = cityField;
	}

	public JLabel getCityLabel() {
		return cityLabel;
	}

	public void setCityLabel(JLabel cityLabel) {
		this.cityLabel = cityLabel;
	}

	public JLabel getFullNameLabel() {
		return fullNameLabel;
	}

	public void setFullNameLabel(JLabel fullNameLabel) {
		this.fullNameLabel = fullNameLabel;
	}

	public JTextField getFullnameField() {
		return fullnameField;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public void setFullnameField(JTextField fullnameField) {
		this.fullnameField = fullnameField;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public JScrollPane getjScrollPane2() {
		return jScrollPane2;
	}

	public void setjScrollPane2(JScrollPane jScrollPane2) {
		this.jScrollPane2 = jScrollPane2;
	}

	public JLabel getMessage() {
		return message;
	}

	public void setMessage(JLabel message) {
		this.message = message;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	public JLabel getTelephoneLabel() {
		return telephoneLabel;
	}

	public void setTelephoneLabel(JLabel telephoneLabel) {
		this.telephoneLabel = telephoneLabel;
	}

	public JTextField getTelephoneField() {
		return telephoneField;
	}

	public void setTelephoneField(JTextField telephoneField) {
		this.telephoneField = telephoneField;
	}

	public JLabel getUserIdLabel() {
		return userIdLabel;
	}

	public void setUserIdLabel(JLabel userIdLabel) {
		this.userIdLabel = userIdLabel;
	}

	public JLabel getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(JLabel welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

}
