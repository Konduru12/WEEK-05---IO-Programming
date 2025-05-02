package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

public class ListtoJSONArray{
    public static class Car {
        public String brand;
        public int year;
        public Car() {}
        public Car(String brand, int year) {
            this.brand = brand;
            this.year = year;
        }
        public String getBrand() {
            return brand;
        }
        public int getYear() {
            return year;
        }
        public void setBrand(String brand) {
            this.brand = brand;
        }
        public void setYear(int year) {
            this.year = year;
        }
    }

    public static void main(String[] args) {
        try {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("Toyota", 2020));
            cars.add(new Car("Honda", 2019));
            cars.add(new Car("Ford", 2021));
            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
