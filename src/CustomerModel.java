import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerModel {
    private List<Customer> customers;
    private List<Observer> observers;


    // METODOS PARA LOS OBSERVERS
    public CustomerModel() {
        this.customers = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(customers);
        }
    }


    
    // LOGICA DEL PROGRAMA
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
        notifyObservers();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void deleteCustomerById(int customerId) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getCustomerId() == customerId) {
                iterator.remove();
                break; 
            }
        }
    }


}
