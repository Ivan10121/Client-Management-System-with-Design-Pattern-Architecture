import java.util.List;


public class AppController {
    private CustomerGateway gateway;
    private CustomerModel model;
    private CustomerView view;

    public AppController(CustomerModel model) {
        gateway = new CustomerGateway();
        this.model = model;
        view = new CustomerView(this,model);
        view.createUI();
        loadAllCustomers();
    }

    public void loadAllCustomers() {
        List<Customer> customers = gateway.findAllCustomers();
        model.setCustomers(customers);
    }

    public void findCustomersByName(String name) {
        List<Customer> filtered = gateway.findCustomersByName(name);
        model.setCustomers(filtered);
    }

    public void addCustomer(Customer customer){
        gateway.insertCustomer(customer);
        model.addCustomer(customer);
        view.clearFields();
        loadAllCustomers();
    }

    public void deleteCustomer(int id){
        gateway.deleteCustomerById(id);
        model.deleteCustomerById(id);
        loadAllCustomers();
    }
}
