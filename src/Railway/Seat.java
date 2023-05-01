/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Railway;

/**
 *
 * @author shank
 */
public class Seat {
    private int seatNo;
    enum seatPreference{LOWER,MIDDLE,UPPER,SIDE_LOWER,SIDE_UPPER};
    private boolean occupied;
    private Person p;

    public Seat(int seatNo, boolean occupied, Person p) {
        this.seatNo = seatNo;
        this.occupied = occupied;
        this.p = p;
    }

    /**
     * @return the seatNo
     */
    public int getSeatNo() {
        return seatNo;
    }

    /**
     * @param seatNo the seatNo to set
     */
    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    /**
     * @return the occupied
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * @param occupied the occupied to set
     */
    public void setOccupied() {
        occupied = false;
    }

    /**
     * @return the p
     */
    public Person getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(Person p) {
        this.p = p;
    }
    
    
    
    
}
