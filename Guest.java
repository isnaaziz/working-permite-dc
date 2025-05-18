public class Guest {
    String company;
private String name;
private String phoneNumber;
private String dataCenter;
private String visitType;
private String companion;
            

    public Guest(String name, String phoneNumber, String company, String dataCenter, String visitType, String companion) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.dataCenter = dataCenter;
        this.visitType = visitType;
        this.companion = companion;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public String getDataCenter() {
        return dataCenter;
    }

    public String getVisitType() {
        return visitType;
    }

    public String getCompanion() {
        return companion;
    }
}