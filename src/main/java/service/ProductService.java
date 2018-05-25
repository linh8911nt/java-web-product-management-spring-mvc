package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public int addProduct(Product product){
        int result = 0;
        try{
            String code = product.getCode();
            String name = product.getName();
            double price = product.getPrice();
            int category_id = product.getCategory_id();

            Connection connection = new ConnectionUtils().connection();

            String sql = "INSERT INTO `products`(`code`, `name`, `price`, `category_id`) VALUES (?,?,?,?)";


            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, code);
            statement.setString(2, name);
            statement.setDouble(3, price);
            statement.setInt(4, category_id);

            result = statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Product> findAll(){
        List<Product> products = new ArrayList<>();

        try {
            Connection connection = new ConnectionUtils().connection();

            String sql = "SELECT `products`.`id`, `products`.`code`, `products`.`name`, `products`.`price`, `categories`.`name` as `category`" +
                    "FROM `products` INNER JOIN `categories` ON `products`.`category_id` = `categories`.`id`";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.setCode(resultSet.getString("code"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setCategory(resultSet.getString("category"));

                products.add(product);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;
    }
}
