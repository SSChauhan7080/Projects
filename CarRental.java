import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Car{
    private String carID;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isavailable;
    public Car(String carID, String brand,String model,double basePricePerDay){
        this.carID=carID;
        this.brand=brand;
        this.model=model;
        this.basePricePerDay=basePricePerDay;
        this.isavailable=true;
    }
    public String getCarId(){
       return carID;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public double calculatePrice(int rentalDays){
        return basePricePerDay*rentalDays;
    }
    public boolean isavailable(){
        return isavailable;
    }
    public void rent(){
        isavailable=false;
    }
    public void returnCar(){
        isavailable=true;
    }

}
class Customer{
    private String customerId;
    private String name;
    public Customer(String customerId, String name){
        this.customerId=customerId;
        this.name=name;
    }
    public String getCustomerId(){
        return customerId;
    }
    public String getName(){
        return name;
    }
}

class Rental{
   private Car car;
   private Customer customer;
   private int days;
   public Rental(Car car, Customer customer, int days){
    this.car=car;
    this.customer=customer;
    this.days=days;
    }
   public Car getCar(){
    return car;
    }
   public Customer gCustomer(){
    return customer;
   }
   public int getDays(){
    return days;
    }
}
class CarRentalSystem{
    //create list to store
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;
    //create arraylist
    public CarRentalSystem(){
        cars=new ArrayList<>();
        customers=new ArrayList<>();
        rentals=new ArrayList<>();
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentalCar(Car car, Customer customer, int days){
        if(car.isavailable()){
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }else{
            System.out.println("car is not available for rent");
        }
    }
    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove=null;
        for(Rental rental:rentals){
            if(rental.getCar()==car){
                rentalToRemove=rental;
                break;
            }
        }
        if(rentalToRemove!=null){
            rentals.remove(rentalToRemove);
            System.out.println("Car return Succesfully");
        }else{
            System.out.println("Car Was Not rented");
        }
    }
    public void menu(){
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("::::::::WELOCOME TO MY CAR RENTAL SYSTEM:::::::");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("******ENTER YOUR CHOICE******");
            int choice=scanner.nextInt();
            scanner.nextLine();
            if(choice==1){
                System.out.println("-------RENT A CAR------");
                System.out.println("Enter your Name");
                String customerName=scanner.nextLine();
                
                System.out.println("---AVAILABLE CAR IS-----");
                for(Car car:cars){
                    if(car.isavailable()){
                        System.out.println(car.getCarId()+"  "+car.getBrand()+"  "+car.getModel());
                    }
                }
                System.out.println("\n ENTER THE CAR ID WHICH YOU WANT TO RENT ....");
                String carId=scanner.nextLine();
                
                System.out.println("ENTER THE NUMBER OF DAYS FOR RENT ");
                int rentaldays=scanner.nextInt();
                scanner.nextLine();
                Customer newCustomer=new Customer("CUS"+(customers.size()+1), customerName);
                addCustomer(newCustomer);
                Car selectedCar=null;
                for(Car car:cars){
                    if(car.getCarId().equals(carId) && car.isavailable()){
                        selectedCar=car;
                        break;
                    }
                }

                if(selectedCar!=null){
                    double totalPrice=selectedCar.calculatePrice(rentaldays);
                    System.out.println("\n :: RENTAL INFORMATION::");
                    System.out.println("Customer Id: "+newCustomer.getCustomerId());
                    System.out.println("Customer name: "+newCustomer.getName());
                    System.out.println("Car: "+selectedCar.getBrand()+"  "+selectedCar.getModel());
                    System.out.println("Rental Days: "+rentaldays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.println("\n Confirm rental(Y/N): ");
                    String confirm=scanner.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                       rentalCar(selectedCar, newCustomer, rentaldays);
                       System.out.println("Car Rented Successfully ");
                    }else{
                        System.out.println("\n rental Canceled  ");
                    }
                }else{
                    System.out.println("\n Invalid car Or selected Car are not availale foe rent. ");
                }
            }else if(choice==2){
                System.out.println("\n::RETURN A CAR :::\n");
                System.out.println("ENTER THE CAR ID WHICH YOU WANT TO RETURN: ");
                String carId=scanner.nextLine();

                Car carToReturn=null;
                for(Car car:cars){
                    if(car.getCarId().equals(carId) && !car.isavailable()){
                        carToReturn=car;
                        break;
                    }
                }
                if(carToReturn!=null){
                    Customer customer=null;
                    for(Rental rental: rentals){
                      if(rental.getCar()==carToReturn){
                        customer=rental.gCustomer();
                        break;
                      }
                    }
                    if(customer!=null){
                        returnCar(carToReturn);
                        System.out.println("Car Return Successfully by: "+customer.getName());
                    }else{
                        System.out.println(" Car was not rented or rental information is missing : ");
                    }
                } else{
                    System.out.println("Invalid car ID or Car is not available: ");
                }
            }else if(choice==3){
                break;
            }else{
                System.out.println("Invalid Choice: Please Enter the valid choice");
            }
        }
        System.out.println("\n ThankYou For Uing The Car Rental system: ");
    }

}
public class CarRental {

    public static void main(String[] args) {
        CarRentalSystem rentalSystem=new CarRentalSystem();
        Car car1=new Car("C001", "TOYOTO", "Camry", 60.0);
        Car car2=new Car("C002", "Honda", "Accord", 75.0);
        Car car3=new Car("C003", "Mahindra", "Thar", 150.0);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.menu();
    }
    
}