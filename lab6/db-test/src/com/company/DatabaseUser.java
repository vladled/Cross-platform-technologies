package com.company;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabaseUser {
    private Connection connectionObj;
    private Statement statementObj;
    private ResultSet resultSet;
    private final String dbString = "jdbc:mysql://localhost:3306/store";
    private final String userName = "root";
    private final String password = "root";
    private String SQLStringSelectFromUser ="SELECT * FROM user";

    public void run()
    {
        try
        {
            DriverManager.registerDriver(new com.jdbc.Driver());
            connectionObj = DriverManager.getConnection(dbString,"root","root");
            statementObj = connectionObj.createStatement();

            String[] names = { "Angela", "Carla", "Kate", "Tonya", "Angelina", "Julia", "Sasha", "Michael", "John", "Teddy", "Mark","Alex"};
            String[] surnames = {"Boldwin", "Lark", "Jameson", "Stewart", "Stand", "Olsen", "Shore", "Kudd", "Utterson", "Pope", "Gustaw", "Piters"};

            String[] namesChanged = {"Kitty", "Sun", "Honey", "Darling", "Snowgirl", "Foxie", "Cat", "Newrise", "Cardriver", "Ford", "Ocean8", "Bill"};
            String[] surnamesChanged = {"123", "DZ", "Juice", "River", "Fork", "234", "ee", "you2", "neverland", "333", "8", "Kill"};
            ArrayList<String> users = new ArrayList<>();
            ArrayList<String> usersAlias = new ArrayList<>();
            for(int i=0; i<100; i++) {
                    int pn = (int) (Math.random()*12 - 1);
                    int ps = (int) (Math.random()*12 - 1);
                    int age = (int) (Math.random()*80 - 1);
                    String s = "INSERT INTO `user` (name, surname, age) " +
                            "VALUES " +"(" + "\"" +names[pn].toString()+ "\"" + "," + "\"" + surnames[ps].toString()+ "\"" + "," + age +")";
                    users.add(names[pn].toString()+ "\"" + "," + "\"" + surnames[ps].toString()+ "\"" + "," + age);
                    usersAlias.add("\"" +namesChanged[pn].toString()+ "\"" + "," + "\"" + surnamesChanged[ps].toString()+ "\"");
                    String changedS = "INSERT INTO `user_alias` (name, surname, age) " +
                            "VALUES " +"(" + "\"" +namesChanged[pn].toString()+ "\"" + "," + "\"" + surnamesChanged[ps].toString()+ "\"" + "," + age +")";
                    System.out.println(s);
                    System.out.println(changedS);
                    statementObj.executeUpdate(s);
                    statementObj.executeUpdate(changedS);
                }

            System.out.println("Enter name and surname:");
            String currentName = new Scanner(System.in).next();
            String currentSurname = new Scanner(System.in).next();
            for(int k = 0; k < users.size(); k++){
                if(users.get(k).contains(currentName) && users.get(k).contains(currentSurname)){
                    System.out.println("Your persons alias is");
                    System.out.println(usersAlias.get(k));
                }
            }

            resultSet = statementObj.executeQuery(SQLStringSelectFromUser);
            while(resultSet.next())
            {
                System.out.print("Name: "+resultSet.getString("name")+"\t\t Surname: "+resultSet.getString("surname"));
                System.out.println("");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                connectionObj.close();
                statementObj.close();
                resultSet.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }

    }

}

