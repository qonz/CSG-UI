package main.GUIC;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;

/**
 * DetailPanel Controller
 * 
 * @author mayoineko
 *
 */
public class DetailPanelController extends MainPanelController implements Initializable {
	/** FXML */
	@FXML private Canvas canvas;
	@FXML private ScrollPane scrollPane1;
	@FXML private ScrollPane scrollPane2;
	@FXML private ScrollPane scrollPane3;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		setControls();
		System.out.println("DetailPanelController OK");
	}
	/**
	 * set controls
	 */
	private void setControls() {
		subController.setupDetailPanel(canvas,scrollPane1,scrollPane2,scrollPane3);
	}
}
