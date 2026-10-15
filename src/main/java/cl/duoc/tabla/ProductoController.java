package cl.duoc.tabla;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductoController {


    private final ObservableList<Producto> productos = FXCollections.observableArrayList();

    public VBox crearVista() {
        TableView<Producto> tabla = new TableView<>();

        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");


        colNombre.setCellValueFactory(dato ->
                new SimpleStringProperty(dato.getValue().nombre())
        );


        TableColumn<Producto, String> colCategoria = new TableColumn<>("Categotia");


        colCategoria.setCellValueFactory(dato ->
                new SimpleStringProperty(dato.getValue().categoria())
        );


        TableColumn<Producto, Number> colPrecio = new TableColumn<>("Precio");


        colPrecio.setCellValueFactory(dato ->
                new SimpleDoubleProperty(dato.getValue().precio())
        );


        tabla.getColumns().addAll(colNombre,
                colCategoria, colPrecio);


        tabla.setItems(productos);


        productos.add(new Producto("Salchichas Montina", "Embutidos", 3500));
        productos.add(new Producto("Queso cheddar", "Lacteos", 2000));
        productos.add(new Producto("Crema para batir (Nestle)", "Lacteos", 1100));


        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");


        TextField txtCategoria = new TextField();
        txtCategoria.setPromptText("Categoria");


        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");


        Button btnAgregar = new Button("Agregar Producto");


        btnAgregar.setOnAction(evento -> {
            String nombre = txtNombre.getText();
            String categoria = txtCategoria.getText();
            double precio = Double.parseDouble(txtPrecio.getText());


            productos.add(new Producto(nombre, categoria, precio));


            txtNombre.clear();
            txtCategoria.clear();
            txtPrecio.clear();
        });

        return new VBox(10, tabla, txtNombre, txtCategoria, txtPrecio, btnAgregar);
    }
}
