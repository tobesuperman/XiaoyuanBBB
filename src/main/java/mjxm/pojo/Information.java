package mjxm.pojo;

public class Information {
    private Integer informationId;

    private String phoneNumber;

    private String address;

    private Integer defaults;

    private Integer userId;

    public Information(Integer informationId, String phoneNumber, String address, Integer defaults, Integer userId) {
        this.informationId = informationId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.defaults = defaults;
        this.userId = userId;
    }

    public Information() {
        super();
    }

    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDefaults() {
        return defaults;
    }

    public void setDefaults(Integer defaults) {
        this.defaults = defaults;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}