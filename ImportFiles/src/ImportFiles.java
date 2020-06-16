import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author ysmorgon
 */
public class ImportFiles extends javax.swing.JFrame {

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private String path;
	// End of variables declaration

	public ImportFiles() {
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Elders Import");

		jLabel1.setText("Welcome to Elders Import Area, please select file ");

		jButton1.setText("Select Elder File");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Process File");
		jButton2.setActionCommand("Process File");
		jButton2.setEnabled(false);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton2ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(36, 36, 36).addComponent(jTextField1).addGap(18, 18, 18)
								.addComponent(jButton1).addGap(32, 32, 32))
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(47, 47, 47).addComponent(jLabel1))
								.addGroup(layout.createSequentialGroup().addGap(110, 110, 110).addComponent(jButton2)))
						.addContainerGap(62, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1)
						.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18).addComponent(jButton2)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
				.addContainerGap()));

		pack();
	}// </editor-fold>

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser fileChoose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChoose.setAcceptAllFileFilterUsed(false);
		fileChoose.setDialogTitle("Select a .xlsx file");
		FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .xlsx files", "xlsx");
		fileChoose.addChoosableFileFilter(restrict);
		int r = fileChoose.showOpenDialog(null);
		if (r == JFileChooser.APPROVE_OPTION) {
			// set the label to the path of the selected file
			jTextField1.setText(fileChoose.getSelectedFile().getAbsolutePath());
			jButton2.setEnabled(true);
			this.path = fileChoose.getSelectedFile().getAbsolutePath();
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		String output;
		if (!this.path.isEmpty()) {
			jTextArea1.setText("File in process");
			ImportFromExcel reader = new ImportFromExcel();
			List<Elders> NewEldersList = null;
			NewEldersList = reader.readBooksFromExcelFile(this.path);
			output = reader.InsertIntoDB(NewEldersList);
			jTextArea1.setText(output);
		} else {
			jTextArea1.setText("Couldn't load the file, please try again");
		}
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ImportFiles.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ImportFiles.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ImportFiles.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ImportFiles.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ImportFiles().setVisible(true);
			}
		});
	}
}
