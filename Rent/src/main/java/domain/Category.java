package domain;

public class Category {
    private Integer cid;
    private String type;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", type='" + type + '\'' +
                '}';
    }
}
