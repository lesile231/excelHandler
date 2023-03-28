package vo;

public class ResultVO {

    private String company_name; // 업체명
    private String company_type;  // 업체 형태 ["개인", "법인"]
    private String company_address; // 업체 주소

    private String company_marketing_number; // 업체 광고번호
    private String company_phone_number; // 업체 번호

    private String registered_date; // 등록 일자
    private String expiration_date; // 만료 일자

    private String registration_number; // 등록증 번호
    private String represent_name; // 대표자 성명

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getCompany_phone_number() {
        return company_phone_number;
    }

    public void setCompany_phone_number(String company_phone_number) {
        this.company_phone_number = company_phone_number;
    }

    public String getCompany_marketing_number() {
        return company_marketing_number;
    }

    public void setCompany_marketing_number(String company_marketing_number) {
        this.company_marketing_number = company_marketing_number;
    }

    public String getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(String registered_date) {
        this.registered_date = registered_date;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getRepresent_name() {
        return represent_name;
    }

    public void setRepresent_name(String represent_name) {
        this.represent_name = represent_name;
    }

    @Override public String toString() {
        return "ResultVO{" +
            "company_name='" + company_name + '\'' +
            ", company_type='" + company_type + '\'' +
            ", company_address='" + company_address + '\'' +
            ", company_marketing_number='" + company_marketing_number + '\'' +
            ", company_phone_number='" + company_phone_number + '\'' +
            ", registered_date='" + registered_date + '\'' +
            ", expiration_date='" + expiration_date + '\'' +
            ", registration_number='" + registration_number + '\'' +
            ", represent_name='" + represent_name + '\'' +
            '}';
    }
}
