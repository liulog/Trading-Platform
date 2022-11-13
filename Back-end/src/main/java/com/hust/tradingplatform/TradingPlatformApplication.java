package com.hust.tradingplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;
import java.util.Scanner;

@SpringBootApplication
public class TradingPlatformApplication {

  public static void main(String[] args) {
//    SpringApplication.run(TradingPlatformApplication.class, args);
//    System.out.println("Hello !");
    Connection connection = null;
    //申明下文中的resultSet, statement
    Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    Scanner input = new Scanner(System.in);

    System.out.print("请输入用户名：");
    String loginName = input.nextLine();
    System.out.print("请输入密码：");
    String loginPass = input.nextLine();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      String userName = "root";
      String passWord = "123123";
      String url = "jdbc:mysql://127.0.0.1:3306/finance?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=UTC";
      connection = DriverManager.getConnection(url, userName, passWord);
      // 补充实现代码:

      statement = connection.createStatement();
      String sql = "select c_password from client where c_mail = "+loginName+";";
      // preparedStatement = connection.prepareStatement(sql);
      // preparedStatement.setString(1,loginName);
      resultSet = statement.executeQuery(sql);
      while(resultSet.next()){
        String mail = resultSet.getString("c_password");
        if(mail.equals(loginPass))
          System.out.print("登录成功。");
        else
          System.out.print("用户名或密码错误！");
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (resultSet != null) {
          resultSet.close();
        }
        if (statement != null) {
          statement.close();
        }

        if (connection != null) {
          connection.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }

  }


}
