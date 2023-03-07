/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yazlab2;

/**
 *
 * @author ervas
 */
public class Benzerlik {

  public Benzerlik(String kayit1, String kayit2, double benzerlik) {
    this.kayit1 = kayit1;
    this.kayit2 = kayit2;
    this.benzerlik = benzerlik;
  }

  private String kayit1;
  private String kayit2;
  private double benzerlik;

  public String getKayit1() {
    return kayit1;
  }

  public void setKayit1(String kayit1) {
    this.kayit1 = kayit1;
  }

  public String getKayit2() {
    return kayit2;
  }

  public void setKayit2(String kayit2) {
    this.kayit2 = kayit2;
  }

  public double getBenzerlik() {
    return benzerlik;
  }

  public void setBenzerlik(double benzerlik) {
    this.benzerlik = benzerlik;
  }
}
