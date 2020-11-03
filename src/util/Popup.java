package util;

import javafx.scene.control.Alert;

public class Popup {

	
	public static void infoDialog(String titulo,String header, String msg){
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle(titulo);
       // dialogoInfo.setHeaderText(header);
        dialogoInfo.setContentText(msg);
        dialogoInfo.showAndWait();
	}
}
