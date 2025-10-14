package com.example.demo;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // db 연결 준비
        Class.forName("com.mysql.cj.jdbc.Driver");
        // db 연결
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","myuser","mypass");
        // 쿼리문 수행
        PreparedStatement preparedStatement = connection.prepareStatement("select * from member");
        // 결과 반환
        ResultSet resultSet = preparedStatement.executeQuery();

        // 결과 조회를 위한 반복문
        while (resultSet.next()){

            var user = new Member();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(resultSet.getInt("age"));

            System.out.println(user.toString());
        }
    }
}
