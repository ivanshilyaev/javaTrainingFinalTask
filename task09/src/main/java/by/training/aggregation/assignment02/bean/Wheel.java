package by.training.aggregation.assignment02.bean;

import java.util.Objects;

public class Wheel {
     private int diameter;
     private WheelType type;

     public Wheel(int diameter, WheelType type) {
          this.diameter = diameter;
          this.type = type;
     }

     public int getDiameter() {
          return diameter;
     }

     public WheelType getType() {
          return type;
     }

     public void setDiameter(int diameter) {
          this.diameter = diameter;
     }

     public void setType(WheelType type) {
          this.type = type;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Wheel wheel = (Wheel) o;
          return diameter == wheel.diameter &&
                  type == wheel.type;
     }

     @Override
     public int hashCode() {
          return Objects.hash(diameter, type);
     }

     @Override
     public String toString() {
          return "Wheel: " +
                  "diameter = " + diameter +
                  ", type = " + type;
     }
}
