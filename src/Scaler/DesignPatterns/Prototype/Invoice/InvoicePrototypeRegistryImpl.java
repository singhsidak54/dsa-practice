package Scaler.DesignPatterns.Prototype.Invoice;

import java.util.HashMap;

public class InvoicePrototypeRegistryImpl implements InvoicePrototypeRegistry {

    HashMap<InvoiceType, Invoice> registry;

    public InvoicePrototypeRegistryImpl() {
        this.registry = new HashMap<>();
    }

    @Override
    public void addPrototype(Invoice user) {
        this.registry.put(user.getType(), user);
    }

    @Override
    public Invoice getPrototype(InvoiceType type) {
        return this.registry.get(type);
    }

    @Override
    public Invoice clone(InvoiceType type) {
        return this.getPrototype(type).cloneObject();
    }
}
