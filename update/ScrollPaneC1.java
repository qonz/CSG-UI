package main.GUIC.mainPaneGUIC;

import main.TextReader;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * ScrollPaneController
 * スクロールパネルにテキストを貼る処理
 * 
 * @author mayoineko
 * 
 */
public class ScrollPaneC1 implements MainPanelIController {
	//private MainPanelSubject subController;
	@FXML private ScrollPane scrollPane;
	/** textPanel */
	private Text panel;
	/**
	 * Constructor
	 * 
	 * @param scrollPane
	 */
	ScrollPaneC1(ScrollPane scrollPane,MainPanelSubject subController) {
		this.scrollPane = scrollPane;
		panel = new Text();
		//this.subController = subController;
		subController.registerObserver(this);
	}
	@Override
	public void setup() {
		panel.setFont(new Font(32));
		panel.setText("左のListからゲームを選択してください。");
		scrollPane.setContent(panel);
		panel.setWrappingWidth(630);
	}
	@Override
	public void reset() {
		String text = TextReader.reads(gameList.getTextPah());
		if(text != null) panel.setText(text);
		else panel.setText("TextFileはありません");
		scrollPane.setContent(panel);
		panel.setWrappingWidth(scrollPane.getWidth());
	}
}
