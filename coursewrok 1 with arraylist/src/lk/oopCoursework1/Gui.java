package lk.oopCoursework1;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Predicate;

public class Gui extends Application {
    Connection conn;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    TextField searchField;


    public static void main(String[] args) {
        launch(args);
    }

    public void CheckConnection(){
        conn = SqlConnection.DbConnector();
        if(conn == null){
            System.out.println("Connection is not successful.");
            System.exit(1);
        }else {
            System.out.println("Connection is successful.");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CheckConnection();

        primaryStage.setTitle("Javafx");
        BorderPane layout = new BorderPane();
        Scene newScene = new Scene(layout,1500,1000,Color.rgb(0,0,0,0));

        TableView<User> table = new TableView<>();
        final ObservableList<User> data = FXCollections.observableArrayList();

        TableColumn column1 = new TableColumn("Vehicle Type");
        column1.setMinWidth(50);
        column1.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));

        TableColumn column2 = new TableColumn("Vehicle Plate Number");
        column2.setMinWidth(150);
        column2.setCellValueFactory(new PropertyValueFactory<>("vehiclePlateNumber"));

        TableColumn column3 = new TableColumn("Vehicle Per KM");
        column3.setMinWidth(120);
        column3.setCellValueFactory(new PropertyValueFactory<>("pricePerKM"));

        TableColumn column4 = new TableColumn("Fuel Type");
        column4.setMinWidth(80);
        column4.setCellValueFactory(new PropertyValueFactory<>("fuelType"));

        TableColumn column5 = new TableColumn("Number Of Helmets");
        column5.setMinWidth(100);
        column5.setCellValueFactory(new PropertyValueFactory<>("numberOfHelmets"));

        TableColumn column6 = new TableColumn("Number Of Passengers");
        column6.setMinWidth(100);
        column6.setCellValueFactory(new PropertyValueFactory<>("numberOfPassengers"));

        TableColumn column7 = new TableColumn("Number Of Airbags");
        column7.setMinWidth(100);
        column7.setCellValueFactory(new PropertyValueFactory<>("numberOfAirbags"));

        TableColumn column8 = new TableColumn("Number Of Seats");
        column8.setMinWidth(100);
        column8.setCellValueFactory(new PropertyValueFactory<>("numberOfSeats"));

        TableColumn column9 = new TableColumn("Number Of Gears");
        column9.setMinWidth(100);
        column9.setCellValueFactory(new PropertyValueFactory<>("numberOfGears"));

        TableColumn column10 = new TableColumn("Wheel Diameter");
        column10.setMinWidth(100);
        column10.setCellValueFactory(new PropertyValueFactory<>("wheelDiameter"));

        TableColumn column11 = new TableColumn("Vehicle Make");
        column11.setMinWidth(100);
        column11.setCellValueFactory(new PropertyValueFactory<>("vehicleMake"));

        table.getColumns().addAll(column1,column2,column3,column4,column5,column6,column7,column8,column9,column10,column11);
        layout.setRight(table);
        BorderPane.setMargin(table,new Insets(0,10,10,0));

        Button load = new Button("Load Table");
        load.setFont(Font.font("SanSerif",15));
        load.setOnAction(e->{
            try{
                String query = "select * from vehicles";
                preparedStatement = conn.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    data.add(new User(
                            resultSet.getString("VehicleType"),
                            resultSet.getString("VehiclePlateNumber"),
                            resultSet.getDouble("PricePerKM"),
                            resultSet.getInt("FuelType"),
                            resultSet.getInt("NumberOfHelmets"),
                            resultSet.getInt("NumberOfPassengers"),
                            resultSet.getInt("NumberOfAirbags"),
                            resultSet.getInt("NumberOfSeats"),
                            resultSet.getInt("NumberOfGears"),
                            resultSet.getInt("WheelDiameter"),
                            resultSet.getString("VehicleMake")
                    ));
                    table.setItems(data);

                }
                preparedStatement.close();
                resultSet.close();
            }catch (Exception e2){
                System.err.println(e2);
            }
        });

        HBox hBox = new HBox(5);
        hBox.getChildren().add(load);
        layout.setBottom(hBox);
        BorderPane.setMargin(hBox, new Insets(10,0,10,10));

        VBox fields = new VBox(5);
        searchField = new TextField();
        searchField.setFont(Font.font("SanSerif",15));
        searchField.setPromptText("Vehicle Type");
        searchField.setMaxWidth(200);

        fields.getChildren().addAll(searchField);
        layout.setCenter(fields);
        FilteredList<User> filteredList = new FilteredList<>(data, e-> true);
        searchField.setOnKeyReleased(e->{
            searchField.textProperty().addListener((observable, oldValue, newValue) ->{
                filteredList.setPredicate((Predicate <? super  User>) user->{
                    if (newValue == null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseFilter = newValue;
                    if (user.getVehicleType().contains(newValue)){
                        return true;
                    }else if(user.getVehicleType().contains(lowerCaseFilter)){
                        return true;
                    }
                    return false;
                });
            });

            SortedList<User> sortedData = new SortedList<>(filteredList);
            sortedData.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedData);
        });
        primaryStage.setScene(newScene);
        primaryStage.show();

    }
}
