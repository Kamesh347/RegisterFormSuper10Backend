package com.example.springlearn.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "register_form")
public class RegisterForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String senderName;
    private String senderAddress;
    private String senderCity;
    private String senderState;
    private int senderZip;
    private String senderDate;
    private String subject;
    private String receiverName;
    private String receiverDesignation;
    private String organizationName;
    private String organizationAddress;
    private String Salutation;
    @Column(length = 2000)
    private String openingParagraph;
    @Column(length = 2000)
    private String bodyParagraph;
    @Column(length = 2000)  
    private String closingParagraph;
    private String signOff;
    private String senderDesignation;
    private String senderContactNumber;
    private String senderEmail;

    public RegisterForm(Long id, String senderName, String senderAddress, String senderCity, String senderState, int senderZip, String senderDate, String subject, String receiverName, String receiverDesignation, String organizationName, String organizationAddress, String salutation, String openingParagraph, String bodyParagraph, String closingParagraph, String signOff, String senderDesignation, String senderContactNumber, String senderEmail) {
        this.id = id;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderCity = senderCity;
        this.senderState = senderState;
        this.senderZip = senderZip;
        this.senderDate = senderDate;
        this.subject = subject;
        this.receiverName = receiverName;
        this.receiverDesignation = receiverDesignation;
        this.organizationName = organizationName;
        this.organizationAddress = organizationAddress;
        Salutation = salutation;
        this.openingParagraph = openingParagraph;
        this.bodyParagraph = bodyParagraph;
        this.closingParagraph = closingParagraph;
        this.signOff = signOff;
        this.senderDesignation = senderDesignation;
        this.senderContactNumber = senderContactNumber;
        this.senderEmail = senderEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderState() {
        return senderState;
    }

    public void setSenderState(String senderState) {
        this.senderState = senderState;
    }

    public int getSenderZip() {
        return senderZip;
    }

    public void setSenderZip(int senderZip) {
        this.senderZip = senderZip;
    }

    public String getSenderDate() {
        return senderDate;
    }

    public void setSenderDate(String senderDate) {
        this.senderDate = senderDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverDesignation() {
        return receiverDesignation;
    }

    public void setReceiverDesignation(String receiverDesignation) {
        this.receiverDesignation = receiverDesignation;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String salutation) {
        Salutation = salutation;
    }

    public String getOpeningParagraph() {
        return openingParagraph;
    }

    public void setOpeningParagraph(String openingParagraph) {
        this.openingParagraph = openingParagraph;
    }

    public String getBodyParagraph() {
        return bodyParagraph;
    }

    public void setBodyParagraph(String bodyParagraph) {
        this.bodyParagraph = bodyParagraph;
    }

    public String getClosingParagraph() {
        return closingParagraph;
    }

    public void setClosingParagraph(String closingParagraph) {
        this.closingParagraph = closingParagraph;
    }

    public String getSignOff() {
        return signOff;
    }

    public void setSignOff(String signOff) {
        this.signOff = signOff;
    }

    public String getSenderDesignation() {
        return senderDesignation;
    }

    public void setSenderDesignation(String senderDesignation) {
        this.senderDesignation = senderDesignation;
    }

    public String getSenderContactNumber() {
        return senderContactNumber;
    }

    public void setSenderContactNumber(String senderContactNumber) {
        this.senderContactNumber = senderContactNumber;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }


    @Override
    public String toString() {
        return "RegisterForm{" +
                "id=" + id +
                ", senderName='" + senderName + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", senderCity='" + senderCity + '\'' +
                ", senderState='" + senderState + '\'' +
                ", senderZip=" + senderZip +
                ", senderDate='" + senderDate + '\'' +
                ", subject='" + subject + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverDesignation='" + receiverDesignation + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", organizationAddress='" + organizationAddress + '\'' +
                ", Salutation='" + Salutation + '\'' +
                ", openingParagraph='" + openingParagraph + '\'' +
                ", bodyParagraph='" + bodyParagraph + '\'' +
                ", closingParagraph='" + closingParagraph + '\'' +
                ", signOff='" + signOff + '\'' +
                ", senderDesignation='" + senderDesignation + '\'' +
                ", senderContactNumber='" + senderContactNumber + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                '}';
    }

    public RegisterForm() {
    }
}
