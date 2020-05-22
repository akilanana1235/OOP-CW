package lk.oopCoursework1;

public interface RentalVehicleManager {

    int maxParking = 50; //parking spaces
    void addVehicle();
    void deleteVehicle();
    void printVehicleList();
    void saveVehicleList();
    void saveInDatabase();
}
