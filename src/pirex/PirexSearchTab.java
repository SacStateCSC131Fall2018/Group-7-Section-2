package pirex;
import javax.swing.*;
import java.awt.*;

public class PirexSearchPanel extends JPanel
{
	/**
	 *
	 */
	private static final long serialVersionUID = -2664023311134068156L;

	public PirexSearchPanel()
	{
		super(new GridBagLayout());

		addQueryRow();
		addResultsWindow();
		addRetrieveDocumentsCounter();
		addPreviewWindow();
	}

	private void addQueryRow()
	{
		//for top row (query row)
		JPanel topPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Insets inset = new Insets(0,5,5,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = inset;
		topPanel.add(new JLabel("Query: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		topPanel.add(new JTextField(70), gbc);
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = inset;
		topPanel.add(new JButton("Clear"), gbc);
		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(topPanel, gbc);
	}

	private void addResultsWindow()
	{
		JPanel middlePanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Insets inset = new Insets(0,5,5,0);
		JTextArea resultsText = new JTextArea();
		resultsText.setText("");
		resultsText.setEditable(false);
		JScrollPane scrollResults = new JScrollPane(resultsText, 20, 31);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = inset;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		middlePanel.add(scrollResults, gbc);
		gbc = new GridBagConstraints();
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		add(middlePanel, gbc);
	}
	
	private void addRetrieveDocumentsCounter()
	{
		JPanel middlePanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel message = new JLabel("Test");
		//message.setVisible(false);
		middlePanel2.add(message);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(middlePanel2, gbc);
	}

	private void addPreviewWindow()
	{
		// TODO Auto-generated method stub

	}
}
