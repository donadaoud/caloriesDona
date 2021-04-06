package daoud.dona.caloriesdona.Data;

import java.io.Serializable;
import java.util.Date;

public class UserPlan {
    protected int id;
    protected  String userName;
    protected Date birth;
    protected double age;
    protected double weight;
    protected double height;
    protected String gender;
   public UserPlan(){

   }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(int id) {
        this.id = id;
    }
    public double bmr(){
       return ((this.age * 5) - (this.height * 6.25) + (this.weight * 10) + 5);
    }
    public void bmi() {
        double bmiNum;
        if (this.gender == "male") {
            bmiNum =(this.weight/(this.height*this.height));
            if (bmiNum < 20) {
                System.out.println(bmiNum + " תת-משקל");
            }
            if (bmiNum >= 20 && bmiNum <= 24) {
                System.out.println(bmiNum + " התחום הנורמלי אצל מבוגרים");
            }
            if (bmiNum >= 25 && bmiNum <= 26) {
                System.out.println(bmiNum + " השמנה מדרגה ראשונה");
            }
            if (bmiNum >= 27 && bmiNum <= 29) {
                System.out.println(bmiNum + " השמנה מדרגה שנייה");
            }
            if (bmiNum >= 30 && bmiNum <= 35) {
                System.out.println(bmiNum + " השמנה כמחלה");
            } else
                System.out.println(bmiNum + " השמנה כמסכנת חיים");


        } else
            bmiNum = ((this.age * 5) - (this.height * 6.25) + (this.weight * 10) - 161);
        if (bmiNum < 20) {
            System.out.println(bmiNum + " תת-משקל");
        }
        if (bmiNum >= 20 && bmiNum <= 24) {
            System.out.println(bmiNum + " התחום הנורמלי אצל מבוגרים");
        }
        if (bmiNum >= 25 && bmiNum <= 26) {
            System.out.println(bmiNum + " השמנה מדרגה ראשונה");
        }
        if (bmiNum >= 27 && bmiNum <= 29) {
            System.out.println(bmiNum + " השמנה מדרגה שנייה");
        }
        if (bmiNum >= 30 && bmiNum <= 35) {
            System.out.println(bmiNum + " השמנה כמחלה");
        } else
            System.out.println(bmiNum + " השמנה כמסכנת חיים");
    }
    }




