import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ChatController {
    @FXML private TextArea chatArea;
    @FXML private TextField inputField;
    @FXML private Button sendButton;

    private ChatClient client;
    private Thread receiveThread;

    public void setClient(ChatClient client) {
        this.client = client;
        receiveThread = new Thread(() -> {
            try {
                String line;
                while ((line = client.getInput().readLine()) != null) {
                    String msg = line;
                    Platform.runLater(() -> chatArea.appendText(msg + "\n"));
                }
            } catch (Exception e) {
                Platform.runLater(() -> chatArea.appendText("Déconnecté du serveur.\n"));
            }
        });
        receiveThread.setDaemon(true);
        receiveThread.start();
    }

    @FXML
    public void handleSend() {
        String text = inputField.getText();
        if (text != null && !text.isEmpty()) {
            client.sendMessage(text);
            chatArea.appendText("Moi: " + text + "\n");
            inputField.clear();
        }
    }
}
