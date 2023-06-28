package org.example.DAO;

import org.example.Connections.ConnectionMySQL;
import org.example.Domain.Circuit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CircuitDAO implements DAO<Circuit> {
    private static final String FIND_ALL = "SELECT * FROM circuits";
    private static final String FIND_BY_ID = "SELECT * FROM circuits WHERE id_circuit = ?";
    private static final String SAVE = "INSERT INTO circuits (circuit_name, circuit_image, circuit_info, fastest_lap_record) VALUES (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM circuits WHERE id_circuit = ?";

    private static CircuitDAO instance;
    private Connection connection;

    private CircuitDAO() {

    }

    public static CircuitDAO getInstance() {
        if (instance == null) {
            synchronized (CircuitDAO.class) {
                if (instance == null) {
                    instance = new CircuitDAO();
                }
            }
        }
        return instance;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Circuit> findAll() throws SQLException {
        List<Circuit> circuits = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement(FIND_ALL);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Circuit circuit = new Circuit();
                circuit.setId(rs.getInt("id_circuit"));
                circuit.setName(rs.getString("circuit_name"));
                circuit.setImage(rs.getBlob("circuit_image"));
                circuit.setInformation(rs.getString("circuit_info"));
                circuit.setFastestLapRecord(rs.getString("fastest_lap_record"));
                circuits.add(circuit);
            }
        }
        return circuits;
    }

    @Override
    public Circuit findById(String id) throws SQLException {
        try (PreparedStatement pst = connection.prepareStatement(FIND_BY_ID)) {
            pst.setString(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Circuit circuit = new Circuit();
                    circuit.setId(rs.getInt("id_circuit"));
                    circuit.setName(rs.getString("circuit_name"));
                    circuit.setImage(rs.getBlob("circuit_image"));
                    circuit.setInformation(rs.getString("circuit_info"));
                    circuit.setFastestLapRecord(rs.getString("fastest_lap_record"));
                    return circuit;
                }
            }
        }
        return null;
    }

    @Override
    public Circuit save(Circuit entity) throws SQLException {
        try (PreparedStatement pst = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, entity.getName());
            pst.setBlob(2,entity.getImage());
            pst.setString(3, entity.getInformation());
            pst.setString(4, entity.getFastestLapRecord());
            pst.executeUpdate();
            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    entity.setId(id);
                    return entity;
                }
            }
        }
        return null;
    }

    @Override
    public void delete(Circuit entity) throws SQLException {
        try (PreparedStatement pst = connection.prepareStatement(DELETE)) {
            pst.setInt(1, entity.getId());
            pst.executeUpdate();
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
