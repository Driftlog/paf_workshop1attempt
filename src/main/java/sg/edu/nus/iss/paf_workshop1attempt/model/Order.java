package sg.edu.nus.iss.paf_workshop1attempt.model;

import java.sql.Date;

public class Order {
    private int id;
    private int employeeID;
    private int custID;
    private Date orderDate;
    private Date shippedDate;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public int getCustID() {
        return custID;
    }
    public void setCustID(int custID) {
        this.custID = custID;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Date getShippedDate() {
        return shippedDate;
    }
    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }
    @Override
    public String toString() {
        return "Order [id=" + id + ", employeeID=" + employeeID + ", custID=" + custID + ", orderDate=" + orderDate
                + ", shippedDate=" + shippedDate + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + employeeID;
        result = prime * result + custID;
        result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
        result = prime * result + ((shippedDate == null) ? 0 : shippedDate.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id != other.id)
            return false;
        if (employeeID != other.employeeID)
            return false;
        if (custID != other.custID)
            return false;
        if (orderDate == null) {
            if (other.orderDate != null)
                return false;
        } else if (!orderDate.equals(other.orderDate))
            return false;
        if (shippedDate == null) {
            if (other.shippedDate != null)
                return false;
        } else if (!shippedDate.equals(other.shippedDate))
            return false;
        return true;
    }

    
    
    
}
