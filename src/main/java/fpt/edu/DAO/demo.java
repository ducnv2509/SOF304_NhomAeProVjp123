package fpt.edu.DAO;

import fpt.edu.entity.Supplier;

public class demo {
   static SupplierDAO sDao = new SupplierDAO();

    public static Supplier getForm() {
        Supplier s = new Supplier();
        s.setAddress("Ha NOi");
        s.setNameMaterial("Nguyen DUCN");
        s.setPhoneNumber("0332429178");
        return s;
    }
    public static void main(String[] args) {
        Supplier s = getForm();
        sDao.insert(s);
    }
}
