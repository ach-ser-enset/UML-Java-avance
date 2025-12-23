import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProductController {
    @FXML private TextField nameField;
    @FXML private TextField priceField;
    @FXML private ListView<Product> productList;

    private ObservableList<Product> products = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        productList.setItems(products);
    }

    @FXML
    public void handleAddProduct() {
        String name = nameField.getText();
        String priceText = priceField.getText();
        if (!name.isEmpty() && !priceText.isEmpty()) {
            try {
                double price = Double.parseDouble(priceText);
                products.add(new Product(name, price));
                nameField.clear();
                priceField.clear();
            } catch (NumberFormatException e) {
                // Optionally show an error dialog
            }
        }
    }
}
