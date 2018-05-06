package Models;

import java.io.Serializable;

/**
 * Created by Shoh Jahon on 06.05.2018.
 */
public class University implements Serializable {
    private int id;
    private String G1;
    private String G2;
    private String G3;
    private String G4;
    private String G5;
    private String G6;
    private String G7;
    private String G8;
    private String G9;
    private String G10;
    private String G11;
    private String G12;

    public University() {
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", G1='" + G1 + '\'' +
                ", G2='" + G2 + '\'' +
                ", G3='" + G3 + '\'' +
                ", G4='" + G4 + '\'' +
                ", G5='" + G5 + '\'' +
                ", G6='" + G6 + '\'' +
                ", G7='" + G7 + '\'' +
                ", G8='" + G8 + '\'' +
                ", G9='" + G9 + '\'' +
                ", G10='" + G10 + '\'' +
                ", G11='" + G11 + '\'' +
                ", G12='" + G12 + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getG1() {
        return G1;
    }

    public void setG1(String g1) {
        G1 = g1;
    }

    public String getG2() {
        return G2;
    }

    public void setG2(String g2) {
        G2 = g2;
    }

    public String getG3() {
        return G3;
    }

    public void setG3(String g3) {
        G3 = g3;
    }

    public String getG4() {
        return G4;
    }

    public void setG4(String g4) {
        G4 = g4;
    }

    public String getG5() {
        return G5;
    }

    public void setG5(String g5) {
        G5 = g5;
    }

    public String getG6() {
        return G6;
    }

    public void setG6(String g6) {
        G6 = g6;
    }

    public String getG7() {
        return G7;
    }

    public void setG7(String g7) {
        G7 = g7;
    }

    public String getG8() {
        return G8;
    }

    public void setG8(String g8) {
        G8 = g8;
    }

    public String getG9() {
        return G9;
    }

    public void setG9(String g9) {
        G9 = g9;
    }

    public String getG10() {
        return G10;
    }

    public void setG10(String g10) {
        G10 = g10;
    }

    public String getG11() {
        return G11;
    }

    public void setG11(String g11) {
        G11 = g11;
    }

    public String getG12() {
        return G12;
    }

    public void setG12(String g12) {
        G12 = g12;
    }
}
