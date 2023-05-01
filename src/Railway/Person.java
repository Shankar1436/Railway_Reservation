/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Railway;

/**
 *
 * @author shank
 */
public class Person {
    private String name;
    private String source;
    private String destination;
    private int age;
    enum sex{MALE, FEMALE};
    private int phoneNo;

    public Person(String name, String source, String destination, int age, int phoneNo) {
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.age = age;
        this.phoneNo = phoneNo;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the phoneNo
     */
    public int getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    
    
}

