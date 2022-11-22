package JDBC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Orders {
    private int orderNumber;
    private java.sql.Date orderDate;
    private java.sql.Date requiredDate;
    private java.sql.Date shippedDate;
    private String status;
    private String comments;
    private int customerNumber;
}
