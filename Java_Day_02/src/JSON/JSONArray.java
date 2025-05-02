package JSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class JSONArray {
    public static class Car {
        @JsonProperty("brand")
        private String brand;
        @JsonProperty("model")
        private String model;
        @JsonProperty("year")
        private int year;
        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }
        public String getBrand() {
            return brand;
        }
        public void setBrand(String brand) {
            this.brand = brand;
        }
        public String getModel() {
            return model;
        }
        public void setModel(String model) {
            this.model = model;
        }
        public int getYear() {
            return year;
        }
        public void setYear(int year) {
            this.year = year;
        }
    }
    public static void main(String[] args) {
        try {
            List<Car> carList = new ArrayList<>();
            carList.add(new Car("Toyota", "Camry", 2022));
            carList.add(new Car("Honda", "Civic", 2021));
            carList.add(new Car("Tesla", "Model S", 2023));
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(carList);
            System.out.println(jsonArray);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
