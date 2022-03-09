package com.example.wrapper.dataset;

public class SelectDatabase{
    public String catalogsNames;
    public String connectionName;
    public String databaseType;
    public String ipAddress;
    public String portNumber;
    public String sidOrServiceName;
    public String databaseService;
    public String username;
    public String password;

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getSidOrServiceName() {
        return sidOrServiceName;
    }

    public void setSidOrServiceName(String sidOrServiceName) {
        this.sidOrServiceName = sidOrServiceName;
    }

    public String getDatabaseService() {
        return databaseService;
    }

    public void setDatabaseService(String databaseService) {
        this.databaseService = databaseService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCatalogsNames() {
        return catalogsNames;
    }

    public void setCatalogsNames(String catalogsNames) {
        this.catalogsNames = catalogsNames;
    }
}
