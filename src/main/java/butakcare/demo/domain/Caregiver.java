package butakcare.demo.domain;

import butakcare.demo.common.Address;

import java.time.LocalDate;

public class Caregiver extends CommonUser {

    private LocalDate birth;

    private String gender;

    private String caregiver_license;

    private String social_worker_license;

    private String nursing_assistant_license;

    private Boolean has_car;

    private Boolean has_dementia_training;

    private Address address;

    private LocalDate career_start;

    private String career_description;
}
