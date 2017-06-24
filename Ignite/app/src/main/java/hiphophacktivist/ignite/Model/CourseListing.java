package hiphophacktivist.ignite.Model;


import com.google.gson.annotations.SerializedName;

public class CourseListing {
//    "address1": "3907 PRINCE ST STE 2C",
//            "borough": "Queens",
//            "city": "FLUSHING",
//            "contact_firstname": "Winnie",
//            "contact_lastname": "Zhou",
//            "cost_includes": "Classroom Hours 700   Lab Hours 0   Internship Hours 0   Practical Hours 0",
//            "cost_total": "5850",
//            "course_name": "English as a Second Language - TAA ONLY",
//            "coursedescription": "The ESL Training Program is for students who like to learn and improve their English wihich includes Listening  Speaking  Reading  and Writing for social academic or job related purposes. Complete four terms of English as a Second Language program and earn a certificate. Students will become sufficient in English as it relates to the world of work and academic skill development. This course will be taught in following languages: English  Chinese Mandarin and Cantonese.. .Upon completion of training student will receive certificate of completion.",
//            "delivery_method": "Classroom Training",
//            "duration": "700",
//            "duration_unit": "Hour(s)",
//            "fax": "7187622685",
//            "financial_aid_services": "Some types of Financial Aid are provided.",
//            "is_hra": "No",
//            "is_sbs": "No",
//            "job_placement_services": "Job Placement Services are available.",
//            "neighborhood": "Flushing - Clearview",
//            "numhours": "700",
//            "organization_name": "Compu21 Corporation (Flushing)",
//            "phone1": "7187621900",
//            "prerequisites": "None.",
//            "schedule": "Check with school to receive most updated schedule",
//            "state": "New York",
//            "website": "http://www.compu21.com",
//            "zip_code": "11354"

    @SerializedName("address1")
    String address;
    String borough;
    String city;
    @SerializedName("contact_firstname")
    String contactFirstName;
    @SerializedName("contact_lastname")
    String contactLastName;
    @SerializedName("coursedescription")
    String courseDescription;
    @SerializedName("course_name")
    String courseName;
    @SerializedName("cost_total")
    String costTotal;
    String duration;
    @SerializedName("duration_unit")
    String durationUnit;
    String state;
    String website;
    @SerializedName("zip_code")
    String zipcode;

    @SerializedName("phone1")
    String phoneNumber;

    public String getAddress() {
        return address;
    }

    public String getBorough() {
        return borough;
    }

    public String getCity() {
        return city;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCostTotal() {
        return costTotal;
    }

    public String getDuration() {
        return duration;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public String getState() {
        return state;
    }

    public String getWebsite() {
        return website;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}


