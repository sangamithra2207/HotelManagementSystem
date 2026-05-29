import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class HotelController {

    Connection con;

    HotelController() {

        con = DBConnection.getConnection();
    }

    void addRoom(int roomNo, String customerName, boolean booked) {

        try {

            String query =
                    "INSERT INTO rooms VALUES (?, ?, ?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, roomNo);
            pst.setString(2, customerName);
            pst.setBoolean(3, booked);

            pst.executeUpdate();

            System.out.println("Room Added Successfully");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    void displayRooms() {

        try {

            String query = "SELECT * FROM rooms";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            System.out.println("\nRoom Details:");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("room_no") + " - " +
                        rs.getString("customer_name") + " - " +
                        (rs.getBoolean("booked")
                                ? "Booked"
                                : "Available"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}