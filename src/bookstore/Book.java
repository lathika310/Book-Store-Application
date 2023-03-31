package bookstore;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {

    private StringProperty name;
    private DoubleProperty price;

    public Book(String name, double price) {
        nameProperty().set(name);
        price = ((int) (price * 100)) / 100.0;
        priceProperty().set(price);
    }

    public final StringProperty nameProperty() {
        if (name == null) {
            name = new SimpleStringProperty(this, "name");
        }
        return name;
    }

    public final DoubleProperty priceProperty() {
        if (price == null) {
            price = new SimpleDoubleProperty(this, "price");
        }
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book b = (Book) o;
        return nameProperty().get().equals(b.nameProperty().get()) && priceProperty().get() == b.priceProperty().get();
    }
}
