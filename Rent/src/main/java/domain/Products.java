package domain;

public class Products {
//    create table Object
//            (
//                    ObjectID             int not null auto_increment,
//                    UserID               int not null,
//                    ObjectName           varchar(16) not null,
//    ObjectIntro          text not null,
//    ObjectType           varchar(16) not null,
//    ObjectPhoto          longblob not null,
    //Price Double;
//    primary key (ObjectID)
//)CHARACTER SET utf8 COLLATE utf8_general_ci;
    private Integer ObjectID;
    private Integer UserID;
    private String ObjectName;
    private String ObjectIntro;
    private String ObjectType;
    private String ObjectPhoto;
    private Double Price;

    public Integer getObjectID() {
        return ObjectID;
    }

    public void setObjectID(Integer objectID) {
        ObjectID = objectID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getObjectName() {
        return ObjectName;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }

    public String getObjectIntro() {
        return ObjectIntro;
    }

    public void setObjectIntro(String objectIntro) {
        ObjectIntro = objectIntro;
    }

    public String getObjectType() {
        return ObjectType;
    }

    public void setObjectType(String objectType) {
        ObjectType = objectType;
    }

    public String getObjectPhoto() {
        return ObjectPhoto;
    }

    public void setObjectPhoto(String objectPhoto) {
        ObjectPhoto = objectPhoto;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "ObjectID=" + ObjectID +
                ", UserID='" + UserID + '\'' +
                ", ObjectName='" + ObjectName + '\'' +
                ", ObjectIntro='" + ObjectIntro + '\'' +
                ", ObjectType='" + ObjectType + '\'' +
                ", ObjectPhoto='" + ObjectPhoto + '\'' +
                ", Price=" + Price +
                '}';
    }
}
