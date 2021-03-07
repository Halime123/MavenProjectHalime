package com.hrms.testbase;

import com.hrms.pages.*;

public class PageInitializer extends BaseClass{
    public static LoginPage loginPage;
    public static DashBoardPage dashBoardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeListPage employeeListPage;
    public static PageInitializer pageInitializer;
    public static PersonalDetailsPage personalDetailsPage;
    public static void initializePageObjects(){
        loginPage=new LoginPage();
        dashBoardPage=new DashBoardPage();
        addEmployeePage=new AddEmployeePage();
        employeeListPage=new EmployeeListPage(driver);
        pageInitializer=new PageInitializer();
        personalDetailsPage=new PersonalDetailsPage(driver);

    }
}
