package main.GUIC.mainPaneGUIC;

import java.util.ArrayList;

import main.Genre;
import main.GUIC.IController;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;

/**
 * MainPanel SubController
 * 
 * @author mayoineko
 *
 */
public class MainPanelSubController implements MainPanelSubject {
	private static MainPanelSubject subController = new MainPanelSubController();
	private ArrayList<IController> observers;
	//Controllers
	private HowToUseC howToUseC;
	private ResizableC resizableC;
	private AddFileC addFileC;
	
	private CanvasC canvasC;
	private ScrollPaneC1 scrollPaneC1;
	private ScrollPaneC2 scrollPaneC2;
	private ScrollPaneC3 scrollPaneC3;
	
	private ExeButtonC exeButtonC;
	private GameListViewC gameListViewC;
	private GenreBoxC genreBoxC;
	/**
	 * initialize observers
	 * observers初期化
	 */
	private MainPanelSubController() {
		observers = new ArrayList<IController>();
	}
	/**
	 * Instance of this class
	 * 唯一のインスタンス
	 * @return
	 */
	public static MainPanelSubController getInstance() {
		return (MainPanelSubController)subController;
	}
	/**
	 * set Controls of MainPanel.fxml
	 * MainPanel.fxmlの部品を定義する
	 * @param controls
	 */
	public void setupMainPanel(Object... controls) {
		// MenuItem
		howToUseC = new HowToUseC((MenuItem)controls[0]);
		howToUseC.setup();
		addFileC = new AddFileC((MenuItem)controls[1],subController);
		addFileC.setup();
		// CheckMenuItem
		resizableC = new ResizableC((CheckMenuItem)controls[2]);
		resizableC.setup();
	}
	/**
	 * set Controls of OperatePanel.fxml
	 * OperatePanel.fxmlの部品を定義する
	 * 
	 * 引数をControlにするとMenuItem,etc...
	 * がキャストできないので、Objectにして渡す
	 * @param controls
	 */
	public void setupOperatePanel(Object... controls) {
		// ComboBox<Genre>
		genreBoxC = new GenreBoxC((ComboBox<Genre>)controls[0], subController);
		genreBoxC.setup();
		// ListView<String>
		gameListViewC = new GameListViewC((ListView<String>)controls[1], subController);
		gameListViewC.setup();
		// Button
		exeButtonC = new ExeButtonC((Button)controls[2]);
		exeButtonC.setup();
	}
	/**
	 * set Controls of DetailPanel.fxml
	 * DetailPanel.fxmlの部品を定義する
	 * @param controls
	 */
	public void setupDetailPanel(Object...controls) {
		canvasC = new CanvasC((Canvas)controls[0], subController);
		canvasC.setup();
		scrollPaneC1 = new ScrollPaneC1((ScrollPane)controls[1], subController);
		scrollPaneC1.setup();
		scrollPaneC2 = new ScrollPaneC2((ScrollPane)controls[2], subController);
		scrollPaneC2.setup();
		scrollPaneC3 = new ScrollPaneC3((ScrollPane)controls[3], subController);
		scrollPaneC3.setup();
	}
	@Override
	public void registerObserver(IController c) {
		observers.add(c);
	}
	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++) {
			MainPanelIController observer = (MainPanelIController)observers.get(i);
			observer.reset();
		}
	}
	@Override
	public void removeObserver(IController c) {
		int i= observers.indexOf(c);
		if (i>=0)
			observers.remove(i);
	}
}
