package org.example.DAO;

import org.example.Domain.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO implements DAO<Driver> {
    private static final String FIND_ALL = "SELECT * FROM drivers";
    private static final String FIND_BY_ID = "SELECT * FROM drivers WHERE id_driver = ?";
    private static final String SAVE = "INSERT INTO drivers (driver_name, nationality, driver_number, wins, drivers_championship, driver_image) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM drivers WHERE id_driver = ?";

    private static DriverDAO instance;
    private Connection connection;

    private DriverDAO() {

    }

    public static DriverDAO getInstance() {
        if (instance == null) {
            synchronized (CircuitDAO.class) {
                if (instance == null) {
                    instance = new DriverDAO();
                }
            }
        }
        return instance;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Driver> findAll() throws SQLException {
        List<Driver> drivers = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Driver driver = new Driver();
                driver.setId(resultSet.getInt("id_driver"));
                driver.setName(resultSet.getString("driver_name"));
                driver.setNationality(resultSet.getString("nationality"));
                driver.setDriverNumber(resultSet.getInt("driver_number"));
                driver.setWins(resultSet.getInt("wins"));
                driver.setDriversChampionship(resultSet.getInt("drivers_championship"));
                driver.setdriver_image(resultSet.getBlob("driver_image"));

                drivers.add(driver);
            }
        }

        return drivers;
    }

    @Override
    public Driver findById(String id) throws SQLException {
        Driver driver = null;

        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setString(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    driver = new Driver();
                    driver.setId(resultSet.getInt("id_driver"));
                    driver.setName(resultSet.getString("driver_name"));
                    driver.setNationality(resultSet.getString("nationality"));
                    driver.setDriverNumber(resultSet.getInt("driver_number"));
                    driver.setWins(resultSet.getInt("wins"));
                    driver.setDriversChampionship(resultSet.getInt("drivers_championship"));
                    driver.setdriver_image(resultSet.getBlob("driver_image"));
                }
            }
        }

        return driver;
    }

    @Override
    public Driver save(Driver driver) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getNationality());
            statement.setInt(3, driver.getDriverNumber());
            statement.setInt(4, driver.getWins());
            statement.setInt(5, driver.getDriversChampionship());
            statement.setBlob(6, driver.getdriver_image());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to save driver. No rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    driver.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Failed to save driver. No ID obtained.");
                }
            }
        }

        return driver;
    }

    @Override
    public void delete(Driver driver) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, driver.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void close() throws Exception {

    }
}
