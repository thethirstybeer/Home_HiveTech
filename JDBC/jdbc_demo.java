package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class jdbc_demo {
    public static Connection connection;
    public static ArrayList<Orders> orders = new ArrayList<>();
    public static ArrayList<Orderdetails> orderdetails = new ArrayList<>();
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<Customers> customers = new ArrayList<>();
    public static ArrayList<Products> products = new ArrayList<>();
    public static ArrayList<Offices> offices = new ArrayList<>();

    public static void main(String[] args) throws SQLException {
        try {
            initDatabaseConnection();
        } finally {
            closeDatabaseConnection();
        }
    }

    private static void initDatabaseConnection() throws SQLException {
        System.out.println("Connecting to the Database...");
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/classicmodels",
                "root",
                "haininh100902");
        System.out.println("Connection valid: " + connection.isValid(5));
    }

    private static void closeDatabaseConnection() throws SQLException {
        System.out.println("Closing database connection...");
        connection.close();
        System.out.println("Connection valid: " + connection.isValid(5));
    }

    // 1 - No 2: tạo mảng order rồi in ra
    private static void No2() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT * FROM orders;
            """)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                boolean empty = true;
                while (resultSet.next()) {
                    empty = false;
                    Orders order = new Orders(
                            resultSet.getInt(1),
                            resultSet.getDate(2),
                            resultSet.getDate(3),
                            resultSet.getDate(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7));
                    orders.add(order);
                }
                if (empty) {
                    System.out.println("No Data");
                } else {
                    int count = 1;
                    for (Orders o : orders) {
                        System.out.println(count + ": " + o);
                        count++;
                    }
                }
            }
        }
    }

    // 2 - No 3: tạo mảng employees rồi in ra
    private static void No3() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT * FROM employees;
            """)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                boolean empty = true;
                while (resultSet.next()) {
                    empty = false;
                    Employee employee = new Employee(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7),
                            resultSet.getString(8)
                    );
                    employees.add(employee);
                }
                if (empty) {
                    System.out.println("No Data");
                } else {
                    int count = 1;
                    for (Employee e : employees) {
                        System.out.println(count + ": " + e);
                        count++;
                    }
                }

            }

        }
    }

    // 3 - No 6: đến số lượng employees
    private static void No6() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT COUNT(employees.employeeNumber) FROM employees;
             """)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println("Numbers Employee: " + resultSet.getInt(1));
                }
            }
        }
    }

    // 4 - No 11: tìm tất cả orders trong tháng 11/2003
    private static void No11() throws SQLException {
        orders.removeAll(orders);
        try (PreparedStatement statement = connection.prepareStatement("""
                SELECT * FROM orders
                WHERE orders.orderDate >= "2003-11-01" and orders.orderDate <= "2003-11-30";
             """)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                boolean empty = true;
                while (resultSet.next()) {
                    empty = false;
                    Orders order = new Orders(
                            resultSet.getInt(1),
                            resultSet.getDate(2),
                            resultSet.getDate(3),
                            resultSet.getDate(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7));
                    orders.add(order);
                }
                if (empty) {
                    System.out.println("No Data");
                } else {
                    int count = 1;
                    for (Orders o : orders) {
                        System.out.println(count + ": " + o);
                        count++;
                    }
                }
            }
        }
    }

    // 5 - No 12: thêm 2 employee
    private static void No12() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(9991, "Ninh", "Nguyen", "x1009", "hninh123@gmail.com", "1", 1009, "VP Sales"));
        employees.add(new Employee(9990, "Ninh", "Nguyen", "x1009", "hninh123@gmail.com", "1", 1009, "VP Sales"));
        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
             """)) {
            int rowInserted = 0;
            for (Employee e : employees) {
                statement.setInt(1, e.getEmployeeNumber());
                statement.setString(2, e.getLastName());
                statement.setString(3, e.getFirstName());
                statement.setString(4, e.getExtension());
                statement.setString(5, e.getEmail());
                statement.setString(6, e.getOfficeCode());
                statement.setInt(7, e.getReportTo());
                statement.setString(8, e.getJobTitle());
                statement.addBatch();
                rowInserted += statement.executeUpdate();
            }
            System.out.println("Row inserted: " + rowInserted);
        }
    }

    // 6 - No 13: thêm 2 office (Tương tự như thêm Employees)
    private static void No13() throws SQLException {
        ArrayList<Offices> offices = new ArrayList<>();
        offices.add(new Offices("10", "Bac Ninh", "+84 0373695999", "Dong Nguyen", null, "BN", "VietNam", "12345", "VietNam"));
        offices.add(new Offices("11", "Quang Ninh", "+84 0373695999", "Dong Nguyen", null, "BN", "VietNam", "12345", "VietNam"));
        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO offices(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
            """)) {
            int rowInserted = 0;
            for (Offices o : offices) {
                statement.setString(1, o.getOfficeCode());
                statement.setString(2, o.getCity());
                statement.setString(3, o.getPhone());
                statement.setString(4, o.getAddressLine1());
                statement.setString(5, o.getAddressLine2());
                statement.setString(6, o.getState());
                statement.setString(7, o.getCountry());
                statement.setString(8, o.getPostalCode());
                statement.setString(9, o.getTerritory());
                statement.addBatch();
                rowInserted += statement.executeUpdate();
            }
            System.out.println("Row inserted: " + rowInserted);
        }
    }

    // 7 - No 14: sửa addressLine2 = '31 street Red'  co officeCOde =1
    private static void No14(int officeCode, String address) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
                    UPDATE offices
                    SET addressLine2 = ?
                    WHERE officeCode = ?;
            """)) {
            statement.setString(1, address);
            statement.setInt(2, officeCode);
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }

    // 8 - No 15: update tất cả customer có addressLine là Null bằng addressLine1
    private static void No15() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
                UPDATE customers
                SET addressLine2 = addressLine1
                WHERE addressLine2 IS NULL;
            """)) {
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        }
    }

    // 9 - No 22: thêm 3 products
    private static void No22() throws SQLException {
        ArrayList<Products> products = new ArrayList<>();
        products.add(new Products("S10-9999", "1900 Harley Davidson Ultimate Chopper", "Motorcycles", "1:10", "Min Lin Diecast", "This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.", 7933, 48.81, 95.7));
        products.add(new Products("S10-9998", "1900 Harley Davidson Ultimate Chopper", "Motorcycles", "1:10", "Min Lin Diecast", "This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.", 7933, 48.81, 95.7));
        products.add(new Products("S10-9997", "1900 Harley Davidson Ultimate Chopper", "Motorcycles", "1:10", "Min Lin Diecast", "This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.", 7933, 48.81, 95.7));
        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO products(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
             """)) {
            int rowInserted = 0;
            for (Products p : products) {
                statement.setString(1, p.getProductCode());
                statement.setString(2, p.getProductName());
                statement.setString(3, p.getProductLine());
                statement.setString(4, p.getProductScale());
                statement.setString(5, p.getProductVendor());
                statement.setString(6, p.getProductDescription());
                statement.setInt(7, p.getQuantityInStock());
                statement.setDouble(8, p.getBuyPrice());
                statement.setDouble(9, p.getMSRP());
                statement.addBatch();
                rowInserted += statement.executeUpdate();
            }
            System.out.println("Row inserted: " + rowInserted);
        }
    }

    // 10 - No 23: xóa customers không có bất kì orders nào
    private static void No23() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("""
                DELETE c FROM customers c
                LEFT JOIN orders o using(customerNumber)
                WHERE o.customerNumber IS NULL;        
             """)) {
            int rowsDeleted = statement.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        }
    }

    // 11 - No 24: liệt kê orders, orderdetails theo từng customers
    private static void No24() throws SQLException{
        orders.removeAll(orders);
        orderdetails.removeAll(orderdetails);
        try(PreparedStatement statement = connection.prepareStatement("""
                select o.*, o2.*  from customers c
                left join orders o on c.customerNumber = o.customerNumber
                left join orderdetails o2 on o.orderNumber = o2.orderNumber;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Orders o;
                Orderdetails o2;
                while (resultSet.next()){
                    empty = false;
                    o = new Orders(
                            resultSet.getInt(1),
                            resultSet.getDate(2),
                            resultSet.getDate(3),
                            resultSet.getDate(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7)
                    );
                    o2 = new Orderdetails(
                            resultSet.getInt(8),
                            resultSet.getString(9),
                            resultSet.getInt(10),
                            resultSet.getDouble(11),
                            resultSet.getInt(12)
                    );
                    orders.add(o);
                    orderdetails.add(o2);
                }
                if(empty){
                    System.out.println("No Data");
                }else {
                    int count = 1;
                    for (Orders oo: orders) {
                        System.out.println(count + " " + oo + " " + orderdetails.get(count-1));
                        count++;
                    }
                }
            }
        }
    }

    // 12 - No 25: liệt kê customers tại USA có số lượng payment nhiều nhất
    private static void No25() throws SQLException {
        customers.removeAll(customers);
        try (PreparedStatement statement = connection.prepareStatement("""
                select c.*, count(p.customerNumber)  from customers c
                inner join payments p on c.customerNumber = p.customerNumber
                where country = "USA"
                group by p.customerNumber
                order by count(p.customerNumber) desc
                limit 1;
             """)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                boolean empty = true;
                Customers cus;
                ArrayList<Integer> countPayment = new ArrayList<>();
                while (resultSet.next()) {
                    empty = false;
                    cus = new Customers(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11),
                            resultSet.getInt(12),
                            resultSet.getDouble(13)
                    );
                    customers.add(cus);
                    countPayment.add(resultSet.getInt(14));
                }
                if (empty) {
                    System.out.println("No Data");
                } else {
                    int count = 1;
                    for (Customers c : customers) {
                        System.out.println(count + ": " + c + " ,countPayment: " + countPayment.get(count-1));
                        count++;
                    }
                }
            }
        }
    }

    // 13 - No 26: liệt kê 3 customers có lượng amout it́ nhất
    private static void No26() throws SQLException{
        customers.removeAll(customers);
        try(PreparedStatement statement = connection.prepareStatement("""
                select c.* , Sum(p.amount)  from customers c
                inner join payments p on c.customerNumber = p.customerNumber
                group by c.customerNumber
                order by Sum(p.amount)
                limit 3;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Customers cus;
                ArrayList<Double> sumAmount = new ArrayList<>();
                while (resultSet.next()){
                    empty = false;
                    cus = new Customers(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11),
                            resultSet.getInt(12),
                            resultSet.getDouble(13)
                    );
                    customers.add(cus);
                    sumAmount.add(resultSet.getDouble(14));
                }
                if (empty) {
                    System.out.println("No Data");
                } else {
                    int count = 1;
                    for (Customers c : customers) {
                        System.out.println(count + ": " + c + " ,sumAmount: " + sumAmount.get(count-1));
                        count++;
                    }
                }
            }
        }
    }

    // 14 - No 27: liệt kê 5 products có số lượng payment nhiều nhất
    private static void No27() throws SQLException{
        customers.removeAll(customers);
        try(PreparedStatement statement = connection.prepareStatement("""
                select c.*, count(p.customerNumber) from customers c
                inner join payments p ON c.customerNumber = p.customerNumber
                group by p.customerNumber
                order by count(p.customerNumber) desc
                limit 5;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Customers cus;
                ArrayList<Integer> countPayment = new ArrayList<>();
                while (resultSet.next()){
                    empty = false;
                    cus = new Customers(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11),
                            resultSet.getInt(12),
                            resultSet.getDouble(13)
                    );
                    customers.add(cus);
                    countPayment.add(resultSet.getInt(14));
                }
                if(empty){
                    System.out.println("No Data");
                }else {
                    int count = 1;
                    for (Customers c: customers) {
                        System.out.println(count + ": " + c + ", Count Payment: " + countPayment.get(count-1));
                        count++;
                    }
                }
            }
        }
    }

    // 15 - No 28: liệt kê orders được thanh toán trong tháng 4-2003 & tháng 12-2003
    private static void No28() throws SQLException{
        orders.removeAll(orders);
        try(PreparedStatement statement = connection.prepareStatement("""
                select * from orders o
                where (o.shippedDate >= "2003-04-01" and o.shippedDate <= "2003-04-30") or
                      (o.shippedDate >="2003-12-01" and o.shippedDate <= "2003-12-30");
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Orders o;
                while (resultSet.next()){
                    empty = false;
                    o = new Orders(
                            resultSet.getInt(1),
                            resultSet.getDate(2),
                            resultSet.getDate(3),
                            resultSet.getDate(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7)
                    );
                    orders.add(o);
                }
                if(empty){
                    System.out.println("No Data");
                }else {
                    int count = 1;
                    for(Orders oo: orders){
                        System.out.println(count+ ": " + oo);
                        count++;
                    }
                }
            }
        }
    }

    // 16 - No 29: liệt kê 1 office có số lượng employee chăm sóc nhiều customers nhất
    private static void No29() throws SQLException{
        offices.removeAll(offices);
        try(PreparedStatement statement = connection.prepareStatement("""
                select o.*, count(c.salesRepEmployeeNumber) as countCustomer  from offices o
                inner join employees e on o.officeCode = e.officeCode
                inner join customers c on e.employeeNumber = c.salesRepEmployeeNumber\s
                group by o.officeCode
                order by count(c.salesRepEmployeeNumber) desc
                limit 1;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                ArrayList<Integer> countEmployee = new ArrayList<>();
                Offices o;
                while (resultSet.next()){
                    empty = false;
                    o = new Offices(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9)
                    );
                    offices.add(o);
                    countEmployee.add(resultSet.getInt(10));
                }
                if(empty){
                    System.out.println("No Data");
                }else{
                    int count = 1;
                    for (Offices oo: offices){
                        System.out.println(count + ": " + oo + " countEmployee: " + countEmployee.get(count-1));
                        count++;
                    }
                }
            }
        }
    }

    // 17 - No 30: liệt kê 2 customer có giới hạn tín dụng < 20000
    private static void No30() throws SQLException{
        customers.removeAll(customers);
        try(PreparedStatement statement = connection.prepareStatement("""
                select c.*  from customers c
                where c.creditLimit < 20000
                limit 2;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Customers cus;
                while (resultSet.next()){
                    empty = false;
                    cus = new Customers(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11),
                            resultSet.getInt(12),
                            resultSet.getDouble(13)
                    );
                    customers.add(cus);
                }
                if (empty) {
                    System.out.println("No Data");
                } else {
                    int count = 1;
                    for (Customers c : customers) {
                        System.out.println(count + ": " + c);
                        count++;
                    }
                }
            }
        }
    }

    // 18 - No 31: liệt kê 2 products tồn hàng nhiều nhất
    private static void No31() throws SQLException{
        products.removeAll(products);
        try(PreparedStatement statement = connection.prepareStatement("""
                select p.*  from products p
                order by p.quantityInStock desc
                limit 2;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Products pro;
                while (resultSet.next()){
                    empty = false;
                    pro = new Products(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7),
                            resultSet.getDouble(8),
                            resultSet.getDouble(9)
                    );
                    products.add(pro);
                }
                if (empty) {
                    System.out.println("No Data");
                } else {
                    int count = 1;
                    for (Products p : products) {
                        System.out.println(count + ": " + p);
                        count++;
                    }
                }
            }
        }
    }

    // 19 - No 32: liêt kê 10 products có giá thấp nhất & được nhiều KH chọn nhất
    private static void No32() throws SQLException{
        products.removeAll(products);
        try(PreparedStatement statement = connection.prepareStatement("""
                select p.* , count(o.productCode)  from products p
                inner join orderdetails o on p.productCode = o.productCode
                group by p.productCode
                order by p.buyPrice  , count(o.productCode  ) desc
                limit 10;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Products pro;
                ArrayList<Integer> countBuy = new ArrayList<>();
                while (resultSet.next()){
                    empty = false;
                    pro = new Products(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7),
                            resultSet.getDouble(8),
                            resultSet.getDouble(9)
                    );
                    products.add(pro);
                    countBuy.add(resultSet.getInt(10));
                }
                if (empty) {
                    System.out.println("No Data");
                } else {
                    int count = 1;
                    for (Products p : products) {
                        System.out.println(count + ": " + p + " ,countBuy: " + countBuy.get(count-1));
                        count++;
                    }
                }
            }
        }
    }

    // 20 - No 33: liệt kê 5 sản phẩm bị Cancelled nhất
    private static void No33() throws SQLException{
        products.removeAll(products);
        try(PreparedStatement statement = connection.prepareStatement("""
                select p.*, count(o2.status)  from products p
                inner join orderdetails o on p.productCode = o.productCode
                inner join orders o2 on o.orderNumber = o2.orderNumber
                where o2.status = "Cancelled"
                group by p.productCode
                order by count(o2.status ) desc
                limit 5;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Products pro;
                ArrayList<Integer> countCancelled = new ArrayList<>();
                while (resultSet.next()){
                    empty = false;
                    pro = new Products(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7),
                            resultSet.getDouble(8),
                            resultSet.getDouble(9)
                    );
                    products.add(pro);
                    countCancelled.add(resultSet.getInt(10));
                }
                if(empty){
                    System.out.println("No Data");
                }else{
                    int count = 1;
                    for(Products p: products){
                        System.out.println(count + ": " + p + " , countCancelled: " + countCancelled.get(count-1));
                        count++;
                    }
                }
            }
        }
    }
    // 21 - No 34: liệt kê 5 sản phâm được giao hàng sớm nhất trong năm 2004
    private static void No34() throws SQLException{
        products.removeAll(products);
        try(PreparedStatement statement = connection.prepareStatement("""
               select p.*, o2.shippedDate  from products p
               inner join orderdetails o on p.productCode = o.productCode
               inner join orders o2 on o.orderNumber = o2.orderNumber
               where o2.shippedDate >= "2004-01-01" and o2.shippedDate <= "2004-12-30"
               limit 5;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Products pro;
                ArrayList<Date> dates = new ArrayList<>();
                while (resultSet.next()){
                    empty = false;
                    pro = new Products(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7),
                            resultSet.getDouble(8),
                            resultSet.getDouble(9)
                    );
                    products.add(pro);
                    dates.add(resultSet.getDate(10));
                }
                if(empty){
                    System.out.println("No Data");
                }else{
                    int count = 1;
                    for(Products p: products){
                        System.out.println(count + ": " + p + " , countCancelled: " + dates.get(count-1));
                        count++;
                    }
                }
            }
        }
    }
    // 22 - No 35: tính tổng số tiền đã được thanh toán theo từng KH có payment trong năm 2004
    private static void No35() throws SQLException{
        customers.removeAll(customers);
        try(PreparedStatement statement = connection.prepareStatement("""
                select c.*, sum(p.amount) from customers c
                inner join payments p on c.customerNumber = p.customerNumber
                where p.paymentDate between "2004-01-01" and "2004-12-31"
                group by c.customerNumber  ;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Customers cus;
                ArrayList<Double> totalAmount = new ArrayList<>();
                while (resultSet.next()){
                    empty = false;
                    cus = new Customers(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11),
                            resultSet.getInt(12),
                            resultSet.getDouble(13)
                    );
                    customers.add(cus);
                    totalAmount.add(resultSet.getDouble(14));
                }
                if(empty){
                    System.out.println("No Data");
                }else{
                    int count = 1;
                    for(Customers c: customers){
                        System.out.println(count + ": " + c + " , totalAmount: " + totalAmount.get(count-1));
                        count++;
                    }
                }
            }
        }
    }
    // 23 - No 36: tìm 2 employees bị báo cáo nhiều nhất
    private static void No36() throws SQLException{
        employees.removeAll(employees);
        try(PreparedStatement statement = connection.prepareStatement("""
                select e.* , count(e.employeeNumber) from employees e
                inner join employees e2 on e.employeeNumber = e2.reportsTo
                group by e.employeeNumber
                order by count(e.employeeNumber) desc
                limit 2;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Employee emp;
                ArrayList<Integer> countReport = new ArrayList<>();
                while (resultSet.next()){
                    empty = false;
                    emp = new Employee(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7),
                            resultSet.getString(8)
                    );
                    employees.add(emp);
                    countReport.add(resultSet.getInt(9));
                }
                if(empty){
                    System.out.println("No Data");
                }else{
                    int count = 1;
                    for(Employee e: employees){
                        System.out.println(count + ": " + e + " , totalAmount: " + countReport.get(count-1));
                        count++;
                    }
                }
            }
        }
    }
    // 24 - No 37: tìm 2 product ko được đặt hàng trong năm 2005
    private static void No37() throws SQLException{
        products.removeAll(products);
        try(PreparedStatement statement = connection.prepareStatement("""
                select p.* from products p
                left join orderdetails o using (productCode)
                left join orders o2 using (orderNumber)
                where o2.orderDate not between "2005-01-1" and "2005-12-31"
                limit 2;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Products pro;
                while (resultSet.next()){
                    empty = false;
                    pro = new Products(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7),
                            resultSet.getDouble(8),
                            resultSet.getDouble(9)
                    );
                    products.add(pro);
                }
                if(empty){
                    System.out.println("No Data");
                }else{
                    int count = 1;
                    for(Products p: products){
                        System.out.println(count + ": " + p);
                        count++;
                    }
                }
            }
        }

    }
    // 25 - No 38: top 10 oder được ship tính từ thời gian orderDate ko quá 3 ngày
    private static void No38() throws SQLException{
        orders.removeAll(orders);
        try(PreparedStatement statement = connection.prepareStatement("""
                select o.* from orders o
                where date_sub(o.shippedDate, interval 3 day) = o.orderDate
                limit 10;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Orders ord;
                while (resultSet.next()){
                    empty = false;
                    ord = new Orders(
                            resultSet.getInt(1),
                            resultSet.getDate(2),
                            resultSet.getDate(3),
                            resultSet.getDate(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7)
                    );
                    orders.add(ord);
                }
                if (empty) {
                    System.out.println("No Data");
                } else {
                    int count = 1;
                    for (Orders o : orders) {
                        System.out.println(count + ": " + o);
                        count++;
                    }
                }
            }
        }
    }

    // 26 - No 39: tìm 10 oder đả được hoàn thành ship trong tháng 12-2004
    private static void No39() throws SQLException{
        orders.removeAll(orders);
        try(PreparedStatement statement = connection.prepareStatement("""
                select *  from orders o
                where o.shippedDate  >= "2004-12-01" and o.shippedDate <= "2004-12-30" and o.status = "Shipped"
                limit 10;
            """)){
            try(ResultSet resultSet = statement.executeQuery()){
                boolean empty = true;
                Orders ord;
                while (resultSet.next()){
                    empty = false;
                    ord = new Orders(
                            resultSet.getInt(1),
                            resultSet.getDate(2),
                            resultSet.getDate(3),
                            resultSet.getDate(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7)
                    );
                    orders.add(ord);
                }
                if (empty) {
                    System.out.println("No Data");
                } else {
                    int count = 1;
                    for (Orders o : orders) {
                        System.out.println(count + ": " + o);
                        count++;
                    }
                }
            }
        }
    }
}

