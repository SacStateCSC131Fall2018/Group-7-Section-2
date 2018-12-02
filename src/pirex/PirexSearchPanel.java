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
		super(new FlowLayout());

		//for top row (query row)
		GridLayout queryLayout = new GridLayout(0,3);
		JPanel topPanel = new JPanel();
		topPanel.add(new JLabel("Query: "));
		topPanel.add(new JTextField(70));
		topPanel.add(new JButton("Clear"));
		add(topPanel, queryLayout);


		addQuery();
		addClearButton();
		addResultsWindow();
		addPreviewWindow();
	}

	private void addQuery()
	{
		// TODO Auto-generated method stub

	}

	private void addClearButton()
	{
		// TODO Auto-generated method stub

	}

	private void addResultsWindow()
	{
		// TODO Auto-generated method stub

	}

	private void addPreviewWindow()
	{
		// TODO Auto-generated method stub

	}
}
