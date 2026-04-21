import java.sql.*;

public class MainMostrarEmpleados {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "RIBERA",
                    "ribera"
            );

            Statement statement = connection.createStatement();

            String sql = "SELECT EMPLEADO.NOMBRE AS nombre, DEPARTAMENTO.NOMBRE AS nombre_dep\n" +
                    "FROM EMPLEADO JOIN DEPARTAMENTO ON EMPLEADO.DEPARTAMENTO_ID = DEPARTAMENTO.ID\n" +
                    "ORDER BY DEPARTAMENTO.NOMBRE";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String departamento = resultSet.getString("nombre_dep");
                System.out.println(nombre + " " + departamento);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}