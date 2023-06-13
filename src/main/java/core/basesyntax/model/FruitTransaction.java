package core.basesyntax.model;

import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String operationCode, String fruit, int quantity) {
        this.operation = getOperationByCode(operationCode);
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return quantity == that.quantity
               && operation == that.operation
               && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, quantity);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
               + "operation=" + operation
               + ", fruit='" + fruit + '\''
               + ", quantity=" + quantity
               + '}';
    }

    private Operation getOperationByCode(String operationCode) {
        for (Operation value : Operation.values()) {
            if (value.getCode().equals(operationCode)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Can't find operation code: " + operationCode);
    }
}
