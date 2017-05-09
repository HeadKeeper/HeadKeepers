package com.headkeeper.controller.util;

import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.UserResumeView;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.bean.view.VacancyView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    public static boolean validatePhoneNumber(String phoneNo) {
        if (phoneNo.matches("\\d{10}")) return true;
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{2}[-\\.\\s]\\d{7}")) return true;
        else if(phoneNo.matches("\\(\\d{3}\\)-\\d{2}-\\d{7}")) return true;
        else return false;
    }

    public static boolean validateUser(UserView user) {
        if (user == null) {
            return false;
        }
        if ((user.getEmail() == null) || (user.getPassword() == null) || (user.getNickname() == null)) {
            return false;
        }
        return true;
    }

    public static boolean validateCompanyInfo(CompanyInfoView companyInfo) {
        if (companyInfo == null) {
            return false;
        }
        if ((companyInfo.getAddress() == null)
                || (companyInfo.getDescription() == null)
                || (!validateUser(companyInfo.getUser()))) {
            return false;
        }
        return true;
    }

    public static boolean validateResume(UserResumeView resume) {
        if (resume == null) {
            return false;
        }
        if ((resume.getAddress() == null) ||
        (resume.getBirthdayDate() == null) ||
        (resume.getFirstName() == null) ||
        (resume.getLastName() == null) ||
        (resume.getMiddleName() == null) ||
        (resume.getMartialStatus() == null)) {
            return false;
        }
        return true;
    }

    public static boolean validateVacancy(VacancyView vacancy) {
        if (vacancy == null) {
            return false;
        }
        if ((!validateUser(vacancy.getUser())) ||
        (vacancy.getDescription() == null) ||
        (vacancy.getEmail() == null) ||
        (vacancy.getMinSalary() == null) ||
        (vacancy.getTitle() == null) ||
        (vacancy.getEssentialSkills() == null) ||
        (vacancy.getPreferableSkills() == null)) {
            return false;
        }
        return true;
    }
}
